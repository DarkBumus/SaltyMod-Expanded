package darkbum.saltymod.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import darkbum.saltymod.util.EvaporatingRecipe;
import darkbum.saltymod.block.BlockEvaporator;
import darkbum.saltymod.common.config.ModConfigurationBlocks;

public class TileEntityEvaporator extends TileEntity implements ISidedInventory, IFluidHandler {

    private static final int[] slotsBottom = new int[] { 0, 1 };

    private static final int[] slotsSides = new int[] { 1 };

    private ItemStack[] invSlots = new ItemStack[2];

    public int burningTime;

    public int currentItemBurnTime;

    public int evaporateTime;

    public int liquidID;

    public int liquidLevel;

    private String inventoryName;

    private int liquidChange;

    private int redSS;

    private int steamLevel;

    private int steamTime;

    public int pressure;

    private int maxCap = 1000 * ModConfigurationBlocks.evaporatorVolume;

    public FluidTank tank = new FluidTank(this.maxCap);

    public String getInventoryName() {
        return hasCustomInventoryName() ? this.inventoryName : "container.evaporator";
    }

    public boolean hasCustomInventoryName() {
        return (this.inventoryName != null && !this.inventoryName.isEmpty());
    }

    public void updateEntity() {
        if (!this.worldObj.isRemote) {
            boolean burn = (this.burningTime > 0);
            boolean teUpdate = false;
            boolean clear = !this.worldObj.isSideSolid(this.xCoord, this.yCoord + 1, this.zCoord, ForgeDirection.DOWN);
            Block blockUp = this.worldObj.getBlock(this.xCoord, this.yCoord + 1, this.zCoord);
            boolean liquid = (FluidRegistry.lookupFluidForBlock(blockUp) != null
                || blockUp instanceof net.minecraft.block.BlockDynamicLiquid);
            if (liquid) {
                Fluid blockFluid = null;
                if (FluidRegistry.lookupFluidForBlock(blockUp) != null) {
                    blockFluid = FluidRegistry.lookupFluidForBlock(blockUp);
                } else if (blockUp.getMaterial() == Material.water) {
                    blockFluid = FluidRegistry.WATER;
                } else if (blockUp.getMaterial() == Material.lava) {
                    blockFluid = FluidRegistry.LAVA;
                }
                if (blockFluid != null && !blockFluid.isGaseous()
                    && this.worldObj.getBlockMetadata(this.xCoord, this.yCoord + 1, this.zCoord) == 0) {
                    int den = blockFluid.getViscosity() / 200;
                    if (this.liquidLevel == 0 || (this.maxCap - this.liquidLevel > den
                        && blockFluid == FluidRegistry.getFluid(this.liquidID))) {
                        this.worldObj.setBlockToAir(this.xCoord, this.yCoord + 1, this.zCoord);
                        this.tank.fill(new FluidStack(blockFluid, 1000), true);
                        liquid = false;
                    } else if (this.maxCap - this.liquidLevel == den) {
                        this.tank.fill(new FluidStack(blockFluid, den), true);
                    }
                }
            }
            if (this.liquidLevel > 0 && this.liquidChange == 0) {
                this.liquidChange = this.liquidLevel;
                teUpdate = true;
                if (canEvaporate()) BlockEvaporator.updateEvaporatorState(
                    (this.burningTime > 0),
                    true,
                    this.worldObj,
                    this.xCoord,
                    this.yCoord,
                    this.zCoord);
            }
            if (this.liquidLevel == 0 && this.liquidChange > 0) {
                this.liquidChange = 0;
                this.evaporateTime = 0;
                teUpdate = true;
                BlockEvaporator.updateEvaporatorState(
                    (this.burningTime > 0),
                    false,
                    this.worldObj,
                    this.xCoord,
                    this.yCoord,
                    this.zCoord);
            }
            if (this.burningTime > 0) this.burningTime--;
            if (this.liquidChange != this.liquidLevel && this.redSS != getFluidAmountScaled(15)) {
                this.liquidChange = this.liquidLevel;
                this.redSS = getFluidAmountScaled(15);
                teUpdate = true;
            }
            this.liquidID = (this.tank.getFluid() != null) ? this.tank.getFluid()
                .getFluidID() : 0;
            this.liquidLevel = (this.tank.getFluid() != null) ? this.tank.getFluidAmount() : 0;
            if (this.burningTime != 0 || (this.invSlots[1] != null && !isFluidTankEmpty())) {
                if (this.burningTime == 0 && canEvaporate() && !liquid) {
                    this.currentItemBurnTime = this.burningTime = TileEntityFurnace.getItemBurnTime(this.invSlots[1]);
                    if (this.burningTime > 0) {
                        teUpdate = true;
                        if (this.invSlots[1] != null) {
                            (this.invSlots[1]).stackSize--;
                            if ((this.invSlots[1]).stackSize == 0) this.invSlots[1] = this.invSlots[1].getItem()
                                .getContainerItem(this.invSlots[1]);
                        }
                    }
                }
                if (isBurning() && canEvaporate()) {
                    if (clear && !liquid) {
                        int vol = EvaporatingRecipe.instance()
                            .getEvaporateFluidVolume(
                                this.tank.getFluid()
                                    .getFluid());
                        this.evaporateTime++;
                        if (this.evaporateTime == vol) {
                            this.evaporateTime = 0;
                            evaporate();
                            teUpdate = true;
                        }
                        this.tank.drain(1, true);
                    } else if (!liquid) {
                        pressure();
                    }
                } else {
                    this.evaporateTime = 0;
                }
            }
            if (burn != ((this.burningTime > 0))) {
                teUpdate = true;
                BlockEvaporator.updateEvaporatorState(
                    (this.burningTime > 0),
                    canEvaporate(),
                    this.worldObj,
                    this.xCoord,
                    this.yCoord,
                    this.zCoord);
            }
            if ((this.steamLevel != 0 && clear) || (this.liquidLevel == 0 && !clear) || !isBurning()) {
                this.pressure = 0;
                this.steamLevel = 0;
                this.steamTime = 0;
            }
            if (teUpdate) markDirty();
        }
    }

    public boolean isBurning() {
        return (this.burningTime > 0);
    }

    public void pressure() {
        int vol = EvaporatingRecipe.instance()
            .getEvaporateFluidVolume(
                this.tank.getFluid()
                    .getFluid());
        this.pressure = this.steamLevel / (32 - getFluidAmountScaled(32) + 1) * 4;
        this.steamTime++;
        if (this.steamTime % (this.pressure + 1) == 0) {
            this.evaporateTime++;
            this.steamTime = 0;
            if (this.evaporateTime == vol) {
                this.evaporateTime = 0;
                evaporate();
                markDirty();
            }
            this.tank.drain(1, true);
        }
        this.steamLevel++;
        if (this.pressure >= 16) {
            this.worldObj.setBlockToAir(this.xCoord, this.yCoord, this.zCoord);
            this.worldObj.createExplosion(null, this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D, 2.5F, true);
        }
    }

    public boolean canEvaporate() {
        if (isFluidTankEmpty()) return false;
        ItemStack itemstack = EvaporatingRecipe.instance()
            .getEvaporateItemStack(
                this.tank.getFluid()
                    .getFluid());
        if (itemstack == null) return false;
        if (this.invSlots[0] == null) return true;
        if (!this.invSlots[0].isItemEqual(itemstack)) return false;
        int result = (this.invSlots[0]).stackSize + itemstack.stackSize;
        return (result <= getInventoryStackLimit() && result <= this.invSlots[0].getMaxStackSize());
    }

    public void evaporate() {
        if (canEvaporate()) {
            ItemStack itemstack = EvaporatingRecipe.instance()
                .getEvaporateItemStack(
                    this.tank.getFluid()
                        .getFluid());
            if (this.invSlots[0] == null) {
                this.invSlots[0] = itemstack.copy();
            } else if (this.invSlots[0].isItemEqual(itemstack)) {
                (this.invSlots[0]).stackSize += itemstack.stackSize;
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public int getEvaporateProgressScaled(int scale) {
        int vol = EvaporatingRecipe.instance()
            .getEvaporateFluidVolume(FluidRegistry.getFluid(this.liquidID));
        if (vol == 0) vol = 1000;
        return this.evaporateTime * scale / vol;
    }

    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int scale) {
        if (this.currentItemBurnTime == 0) this.currentItemBurnTime = 200;
        return this.burningTime * scale / this.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public int getFluidAmountScaledClient(int scale) {
        return MathHelper.ceiling_float_int((this.liquidLevel * scale / this.maxCap));
    }

    public ItemStack getStackInSlot(int slot) {
        return this.invSlots[slot];
    }

    public ItemStack decrStackSize(int slot, int amt) {
        if (this.invSlots[slot] != null) {
            if ((this.invSlots[slot]).stackSize <= amt) {
                ItemStack itemStack = this.invSlots[slot];
                this.invSlots[slot] = null;
                return itemStack;
            }
            ItemStack itemstack = this.invSlots[slot].splitStack(amt);
            if ((this.invSlots[slot]).stackSize == 0) this.invSlots[slot] = null;
            return itemstack;
        }
        return null;
    }

    public ItemStack getStackInSlotOnClosing(int slot) {
        if (this.invSlots[slot] != null) {
            ItemStack itemstack = this.invSlots[slot];
            this.invSlots[slot] = null;
            return itemstack;
        }
        return null;
    }

    public void setInventorySlotContents(int slot, ItemStack stack) {
        this.invSlots[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) stack.stackSize = getInventoryStackLimit();
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public int getSizeInventory() {
        return this.invSlots.length;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {
        return (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this
            && player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D);
    }

    public void openInventory() {}

    public void closeInventory() {}

    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return (slot != 0 && slot == 1 && TileEntityFurnace.isItemFuel(stack));
    }

    public int[] getAccessibleSlotsFromSide(int side) {
        return (side == 0) ? slotsBottom : ((side != 1) ? slotsSides : new int[0]);
    }

    public boolean canInsertItem(int slot, ItemStack stack, int side) {
        return isItemValidForSlot(slot, stack);
    }

    public boolean canExtractItem(int slot, ItemStack stack, int side) {
        return (side != 0 || slot != 1 || stack.getItem() == Items.bucket);
    }

    public void func_145951_a(String string) {
        this.inventoryName = string;
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagList inv_tags = nbt.getTagList("Items", 10);
        this.invSlots = new ItemStack[getSizeInventory()];
        for (int i = 0; i < inv_tags.tagCount(); i++) {
            NBTTagCompound tag = inv_tags.getCompoundTagAt(i);
            byte b0 = tag.getByte("Slot");
            if (b0 >= 0 && b0 < this.invSlots.length) this.invSlots[b0] = ItemStack.loadItemStackFromNBT(tag);
        }
        this.burningTime = nbt.getShort("BurnTime");
        this.evaporateTime = nbt.getShort("CookTime");
        this.currentItemBurnTime = nbt.getShort("ItemBurnTime");
        this.steamLevel = nbt.getShort("SteamLevel");
        readTankFromNBT(nbt);
        if (nbt.hasKey("CustomName", 8)) this.inventoryName = nbt.getString("CustomName");
    }

    protected void readTankFromNBT(NBTTagCompound nbt) {
        if (nbt.hasKey("Tank")) this.tank.readFromNBT(nbt.getCompoundTag("Tank"));
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setShort("BurnTime", (short) this.burningTime);
        nbt.setShort("CookTime", (short) this.evaporateTime);
        nbt.setShort("ItemBurnTime", (short) this.currentItemBurnTime);
        nbt.setShort("SteamLevel", (short) this.steamLevel);
        NBTTagList taglist = new NBTTagList();
        for (int i = 0; i < this.invSlots.length; i++) {
            if (this.invSlots[i] != null) {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setByte("Slot", (byte) i);
                this.invSlots[i].writeToNBT(tag);
                taglist.appendTag(tag);
            }
        }
        nbt.setTag("Items", taglist);
        writeTankToNBT(nbt);
        if (hasCustomInventoryName()) nbt.setString("CustomName", this.inventoryName);
    }

    protected void writeTankToNBT(NBTTagCompound nbt) {
        NBTTagCompound tag = new NBTTagCompound();
        this.tank.writeToNBT(tag);
        nbt.setTag("Tank", tag);
    }

    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        int f = this.tank.fill(resource, doFill);
        return f;
    }

    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        if (resource == null || !resource.isFluidEqual(this.tank.getFluid())) return null;
        return drain(from, resource.amount, doDrain);
    }

    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        FluidStack d = this.tank.drain(maxDrain, doDrain);
        return d;
    }

    public boolean canFill(ForgeDirection from, Fluid fluid) {
        return true;
    }

    public boolean canDrain(ForgeDirection from, Fluid fluid) {
        return true;
    }

    public FluidTankInfo[] getTankInfo(ForgeDirection from) {
        return new FluidTankInfo[] { this.tank.getInfo() };
    }

    public int getFluidAmountScaled(int scale) {
        return MathHelper.ceiling_float_int((getFluidAmount() * scale / this.maxCap));
    }

    public boolean isFluidTankEmpty() {
        return (getFluidAmount() == 0);
    }

    public int getFluidAmount() {
        return this.tank.getFluidAmount();
    }
}
