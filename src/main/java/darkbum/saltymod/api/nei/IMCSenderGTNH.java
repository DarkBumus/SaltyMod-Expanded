package darkbum.saltymod.api.nei;

import darkbum.saltymod.SaltyMod;
import cpw.mods.fml.common.event.FMLInterModComms;
import net.minecraft.nbt.NBTTagCompound;

public class IMCSenderGTNH {

	public static void IMCSender() {
		sendHandler("darkbum.saltymod.api.nei.NEIPotcookingRecipeHandler", "saltymod:cooking_pot");
		sendCatalyst(SaltyMod.MODID + ".cooking_pot", "saltymod:cooking_pot");

		sendHandler("darkbum.saltymod.api.nei.NEIOvenbakingRecipeHandler", "saltymod:clay_oven");
		sendCatalyst(SaltyMod.MODID + ".clay_oven", "saltymod:clay_oven");
	}

	/*
	 * These were copied from GTNewHorizons/GoodGenerator (Fork of GlodBlock/GoodGenerator)
	 * Author: GlodBlock
	*/

	private static void sendHandler(String aName, String aBlock) {
		sendHandler(aName, aBlock, 1);
	}

	private static void sendHandler(String aName, String aBlock, int maxRecipesPerPage) {
		NBTTagCompound aNBT = new NBTTagCompound();
		aNBT.setString("handler", aName);
		aNBT.setString("modName", SaltyMod.NAME);
		aNBT.setString("modId", SaltyMod.MODID);
		aNBT.setBoolean("modRequired", true);
		aNBT.setString("itemName", aBlock);
		aNBT.setInteger("handlerHeight", 65);
		aNBT.setInteger("handlerWidth", 166);
		aNBT.setInteger("maxRecipesPerPage", maxRecipesPerPage);
		aNBT.setInteger("yShift", 6);
		FMLInterModComms.sendMessage("NotEnoughItems", "registerHandlerInfo", aNBT);
	}

	private static void sendCatalyst(String aName, String aStack, int aPriority) {
		NBTTagCompound aNBT = new NBTTagCompound();
		aNBT.setString("handlerID", aName);
		aNBT.setString("itemName", aStack);
		aNBT.setInteger("priority", aPriority);
		FMLInterModComms.sendMessage("NotEnoughItems", "registerCatalystInfo", aNBT);
	}

	private static void sendCatalyst(String aName, String aStack) {
		sendCatalyst(aName, aStack, 0);
	}
}