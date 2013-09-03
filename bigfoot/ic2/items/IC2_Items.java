package bigfoot.ic2.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import bigfoot.ic2.info.IC2_Info;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class IC2_Items {
	public static Item electricSteak; 
	public static Item advElectricSteak; 
	public static Item electricGrafter;
	
	public static void init()
	{
		electricSteak = new IC2_ElectricSteak(IC2_Info.electricSteakID);
		advElectricSteak = new IC2_AdvElectricSteak(IC2_Info.advElectricSteakID);
		electricGrafter = new IC2_ElectricGrafter(IC2_Info.electricGrafterID);
	}

	public static void addNames()
	{
		LanguageRegistry.addName(electricSteak, IC2_Info.electricSteakName);
		LanguageRegistry.addName(advElectricSteak, IC2_Info.advElectricSteakName);
		LanguageRegistry.addName(electricGrafter, IC2_Info.electricGrafterName);
	}
	
	public static void registerRecipes()
	{		
		GameRegistry.addRecipe(new ItemStack(electricGrafter, 1), 
				new Object[] { " RD", "RCR", "DR ",
			   			'R', ic2.api.item.Items.getItem("refinedIronIngot"),
			   			'E', ic2.api.item.Items.getItem("reBattery"),
			   			'C', ic2.api.item.Items.getItem("electronicCircuit"),
			   			'D', ic2.api.item.Items.getItem("treetap")});
		
		GameRegistry.addRecipe(new ItemStack(electricSteak, 1), 
				new Object[] { "SCS", "RER", "SCS",
   						'R', ic2.api.item.Items.getItem("refinedIronIngot"),
			   			'E', ic2.api.item.Items.getItem("reBattery"),
			   			'C', ic2.api.item.Items.getItem("electronicCircuit"),
			   			'S', Item.beefCooked});
		GameRegistry.addRecipe(new ItemStack(advElectricSteak, 1), 
				new Object[] { "EAE", "RTR", "EAE",
   						'R', ic2.api.item.Items.getItem("refinedIronIngot"),
			   			'E', ic2.api.item.Items.getItem("reBattery"),
			   			'A', ic2.api.item.Items.getItem("advancedCircuit"),
			   			'T', electricSteak});

	}

}
