package bigfoot.mass.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import bigfoot.mass.info.MASS_Info;
import bigfoot.mass.items.MASS_ItemMachine;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MASS_Blocks {
	public static Block blockGenerator;

	public static Block smeltery;
	public static Block smelteryActive;
	
	public static Block titaniumOre;

	public static void init() {
		blockGenerator = new MASS_Machine(MASS_Info.machineID);
		GameRegistry.registerBlock(blockGenerator, MASS_ItemMachine.class,
				MASS_Info.machineKey);

		smeltery = new MASS_Smeltery(MASS_Info.smelteryID, Material.rock).setUnlocalizedName(MASS_Info.smelteryUnlocalizedName);
		GameRegistry.registerBlock(smeltery, MASS_Info.smelteryKey);
		smelteryActive = new MASS_Smeltery(MASS_Info.smelteryActiveID, Material.rock).setUnlocalizedName(MASS_Info.smelteryActiveUnlocalizedName);
		GameRegistry.registerBlock(smelteryActive, MASS_Info.smelteryActiveKey);
	}

	public static void addNames() {
		LanguageRegistry.addName(blockGenerator, MASS_Info.machineName);
		LanguageRegistry.addName(smeltery, MASS_Info.smelteryName);
		
		
	}

	public static void registerRecipes() {
		GameRegistry.addRecipe(new ItemStack(blockGenerator, 1), new Object[] {
				"ODO", "III", "ORO", 'O', Block.obsidian, 'D', Item.diamond,
				'I', Block.blockIron, 'R', Block.blockRedstone });
	}

	public static void registerTileEntities() {
	}
}
