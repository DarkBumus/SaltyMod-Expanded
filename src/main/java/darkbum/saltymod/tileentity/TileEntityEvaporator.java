package darkbum.saltymod.tileentity;

import darkbum.saltymod.init.ModAchievementList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.AxisAlignedBB;
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

import java.util.List;
import java.util.Objects;

import static darkbum.saltymod.block.BlockEvaporator.*;
import static darkbum.saltymod.common.config.ModConfigurationBlocks.*;

public class TileEntityEvaporator extends TileEntity implements ISidedInventory, IFluidHandler {

    private static final int[] slotsBottom = new int[] { 0, 1 };
    private static final int[] slotsSides = new int[] { 1 };
    private ItemStack[] invSlots = new ItemStack[2];

    public int burningTime;
    public int currentItemBurnTime;
    public int evaporateTime;
    private int steamTime;

    public int liquidID;
    public int liquidLevel;
    private int liquidChange;
    private int steamLevel;
    public int pressure;

    private String inventoryName;

    private int redSS;

    public final int maxCap = 1000 * evaporatorVolume;
    public FluidTank tank = new FluidTank(maxCap);

    public String getInventoryName() {
        return hasCustomInventoryName() ? inventoryName : "container.evaporator";
    }

    public boolean hasCustomInventoryName() {
        return (inventoryName != null && !inventoryName.isEmpty());
    }

    public void updateEntity() {
        if (!worldObj.isRemote) {
            boolean burn = (burningTime > 0);
            boolean teUpdate = false;
            boolean clear = !worldObj.isSideSolid(xCoord, yCoord + 1, zCoord, ForgeDirection.DOWN);
            Block blockUp = worldObj.getBlock(xCoord, yCoord + 1, zCoord);
            boolean liquid = (FluidRegistry.lookupFluidForBlock(blockUp) != null || blockUp instanceof BlockDynamicLiquid);
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
                    && worldObj.getBlockMetadata(xCoord, yCoord + 1, zCoord) == 0) {
                    int den = blockFluid.getViscosity() / 200;
                    if (liquidLevel == 0 || (maxCap - liquidLevel > den
                        && blockFluid == FluidRegistry.getFluid(liquidID))) {
                        worldObj.setBlockToAir(xCoord, yCoord + 1, zCoord);
                        tank.fill(new FluidStack(blockFluid, 1000), true);
                        liquid = false;
                    } else if (maxCap - liquidLevel == den) {
                        tank.fill(new FluidStack(blockFluid, den), true);
                    }
                }
            }
            if (liquidLevel > 0 && liquidChange == 0) {
                liquidChange = liquidLevel;
                teUpdate = true;
                if (canEvaporate()) updateEvaporatorState((burningTime > 0), true, worldObj, xCoord, yCoord, zCoord);
            }
            if (liquidLevel == 0 && liquidChange > 0) {
                liquidChange = 0;
                evaporateTime = 0;
                teUpdate = true;
                updateEvaporatorState((burningTime > 0), false, worldObj, xCoord, yCoord, zCoord);
            }
            if (burningTime > 0) burningTime--;
            if (liquidChange != liquidLevel && redSS != getFluidAmountScale(15)) {
                liquidChange = liquidLevel;
                redSS = getFluidAmountScale(15);
                teUpdate = true;
            }
            liquidID = (tank.getFluid() != null) ? tank.getFluid().getFluidID() : 0;
            liquidLevel = (tank.getFluid() != null) ? tank.getFluidAmount() : 0;
            if (burningTime != 0 || (invSlots[1] != null && !isFluidTankEmpty())) {
                if (burningTime == 0 && canEvaporate() && !liquid) {
                    currentItemBurnTime = burningTime = TileEntityFurnace.getItemBurnTime(invSlots[1]);
                    if (burningTime > 0) {
                        teUpdate = true;
                        if (invSlots[1] != null) {
                            (invSlots[1]).stackSize--;
                            if ((invSlots[1]).stackSize == 0) invSlots[1] = Objects.requireNonNull(invSlots[1].getItem()).getContainerItem(invSlots[1]);
                        }
                    }
                }
                if (isBurning() && canEvaporate()) {
                    if (clear && !liquid) {
                        int vol = EvaporatingRecipe.instance().getEvaporateFluidVolume(tank.getFluid().getFluid());
                        evaporateTime++;
                        if (evaporateTime == vol) {
                            evaporateTime = 0;
                            evaporate();
                            teUpdate = true;
                        }
                        tank.drain(1, true);
                    } else if (!liquid) {
                        pressure();
                    }
                } else {
                    evaporateTime = 0;
                }
            }
            if (burn != ((burningTime > 0))) {
                teUpdate = true;
                updateEvaporatorState((burningTime > 0), canEvaporate(), worldObj, xCoord, yCoord, zCoord);
            }
            if ((steamLevel != 0 && clear) || (liquidLevel == 0 && !clear) || !isBurning()) {
                pressure = 0;
                steamLevel = 0;
                steamTime = 0;
            }
            if (teUpdate) markDirty();
        }
    }

    public boolean isBurning() {
        return (burningTime > 0);
    }

    public void pressure() {
        int vol = EvaporatingRecipe.instance().getEvaporateFluidVolume(tank.getFluid().getFluid());
        int maxPressure = evaporatorPressureBuildup;

        steamTime++;
        if (steamTime % (pressure + 1) == 0) {
            evaporateTime++;
            steamTime = 0;

            if (evaporateTime == vol) {
                evaporateTime = 0;
                evaporate();
                markDirty();
            }

            tank.drain(1, true);
        }

        steamLevel++;

        pressure++;

        if (pressure >= maxPressure) {
            worldObj.setBlockToAir(xCoord, yCoord, zCoord);
            worldObj.createExplosion(null, xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, 2.5F, true);

            double radius = 5.0D;
            AxisAlignedBB explosionRange = AxisAlignedBB.getBoundingBox(
                xCoord - radius, yCoord - radius, zCoord - radius,
                xCoord + radius, yCoord + radius, zCoord + radius
            );

            List<EntityPlayer> players = worldObj.getEntitiesWithinAABB(EntityPlayer.class, explosionRange);
            for (EntityPlayer player : players) {
                if (player.getHealth() < player.getMaxHealth()) {
                    player.addStat(ModAchievementList.explodespec_evaporator, 1);
                }
            }
        }
    }

    public boolean canEvaporate() {
        if (isFluidTankEmpty()) return false;
        ItemStack itemstack = EvaporatingRecipe.instance()
            .getEvaporateItemStack(
                tank.getFluid()
                    .getFluid());
        if (itemstack == null) return false;
        if (invSlots[0] == null) return true;
        if (!invSlots[0].isItemEqual(itemstack)) return false;
        int result = (invSlots[0]).stackSize + itemstack.stackSize;
        return (result <= getInventoryStackLimit() && result <= invSlots[0].getMaxStackSize());
    }

    public void evaporate() {
        if (canEvaporate()) {
            ItemStack itemstack = EvaporatingRecipe.instance()
                .getEvaporateItemStack(
                    tank.getFluid()
                        .getFluid());
            if (invSlots[0] == null) {
                invSlots[0] = itemstack.copy();
            } else if (invSlots[0].isItemEqual(itemstack)) {
                (invSlots[0]).stackSize += itemstack.stackSize;
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public int getEvaporateProgressScale(int scale) {
        int vol = EvaporatingRecipe.instance().getEvaporateFluidVolume(FluidRegistry.getFluid(liquidID));
        if (vol == 0) vol = 1000;
        return evaporateTime * scale / vol;
    }

    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScale(int scale) {
        if (currentItemBurnTime == 0) currentItemBurnTime = 200;
        return burningTime * scale / currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public int getPressureProgressScale(int scale) {
        int maxPressure = evaporatorPressureBuildup;
        if (maxPressure == 0) return 0;
        return (pressure * scale) / maxPressure;
    }

    @SideOnly(Side.CLIENT)
    public int getFluidAmountScaleClient(int scale) {
        return MathHelper.ceiling_float_int(((float) (liquidLevel * scale) / maxCap));
    }

    public ItemStack getStackInSlot(int slot) {
        return invSlots[slot];
    }

    public ItemStack decrStackSize(int slot, int amt) {
        if (invSlots[slot] != null) {
            if ((invSlots[slot]).stackSize <= amt) {
                ItemStack itemStack = invSlots[slot];
                invSlots[slot] = null;
                return itemStack;
            }
            ItemStack itemstack = invSlots[slot].splitStack(amt);
            if ((invSlots[slot]).stackSize == 0) invSlots[slot] = null;
            return itemstack;
        }
        return null;
    }

    public ItemStack getStackInSlotOnClosing(int slot) {
        if (invSlots[slot] != null) {
            ItemStack itemstack = invSlots[slot];
            invSlots[slot] = null;
            return itemstack;
        }
        return null;
    }

    public void setInventorySlotContents(int slot, ItemStack stack) {
        invSlots[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) stack.stackSize = getInventoryStackLimit();
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public int getSizeInventory() {
        return invSlots.length;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {
        return (worldObj.getTileEntity(xCoord, yCoord, zCoord) == this
            && player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64.0D);
    }

    public void openInventory() {}

    public void closeInventory() {}

    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return (slot == 1 && TileEntityFurnace.isItemFuel(stack));
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

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagList inv_tags = nbt.getTagList("Items", 10);
        invSlots = new ItemStack[getSizeInventory()];
        for (int i = 0; i < inv_tags.tagCount(); i++) {
            NBTTagCompound tag = inv_tags.getCompoundTagAt(i);
            byte b0 = tag.getByte("Slot");
            if (b0 >= 0 && b0 < invSlots.length) invSlots[b0] = ItemStack.loadItemStackFromNBT(tag);
        }
        burningTime = nbt.getShort("BurnTime");
        evaporateTime = nbt.getShort("CookTime");
        currentItemBurnTime = nbt.getShort("ItemBurnTime");
        steamLevel = nbt.getShort("SteamLevel");
        readTankFromNBT(nbt);
        if (nbt.hasKey("CustomName", 8)) inventoryName = nbt.getString("CustomName");
    }

    protected void readTankFromNBT(NBTTagCompound nbt) {
        if (nbt.hasKey("Tank")) tank.readFromNBT(nbt.getCompoundTag("Tank"));
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setShort("BurnTime", (short) burningTime);
        nbt.setShort("CookTime", (short) evaporateTime);
        nbt.setShort("ItemBurnTime", (short) currentItemBurnTime);
        nbt.setShort("SteamLevel", (short) steamLevel);
        NBTTagList taglist = new NBTTagList();
        for (int i = 0; i < invSlots.length; i++) {
            if (invSlots[i] != null) {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setByte("Slot", (byte) i);
                invSlots[i].writeToNBT(tag);
                taglist.appendTag(tag);
            }
        }
        nbt.setTag("Items", taglist);
        writeTankToNBT(nbt);
        if (hasCustomInventoryName()) nbt.setString("CustomName", inventoryName);
    }

    protected void writeTankToNBT(NBTTagCompound nbt) {
        NBTTagCompound tag = new NBTTagCompound();
        tank.writeToNBT(tag);
        nbt.setTag("Tank", tag);
    }

    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        return tank.fill(resource, doFill);
    }

    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        if (resource == null || !resource.isFluidEqual(tank.getFluid())) return null;
        return drain(from, resource.amount, doDrain);
    }

    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        return tank.drain(maxDrain, doDrain);
    }

    public boolean canFill(ForgeDirection from, Fluid fluid) {
        return true;
    }

    public boolean canDrain(ForgeDirection from, Fluid fluid) {
        return true;
    }

    public FluidTankInfo[] getTankInfo(ForgeDirection from) {
        return new FluidTankInfo[] { tank.getInfo() };
    }

    public int getFluidAmountScale(int scale) {
        return MathHelper.ceiling_float_int(((float) (getFluidAmount() * scale) / maxCap));
    }

    public boolean isFluidTankEmpty() {
        return (getFluidAmount() == 0);
    }

    public int getFluidAmount() {
        return tank.getFluidAmount();
    }
}
