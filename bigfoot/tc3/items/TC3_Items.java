package bigfoot.tc3.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import bigfoot.tc3.info.TC3_Info;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class TC3_Items {
	public static Item airWand;
	public static Item earthWand;

	public static void init() {
		airWand = new TC3_AirWand(TC3_Info.airWandID);
		earthWand = new TC3_EarthWand(TC3_Info.earthWandID);
	}

	public static void addNames() {
		LanguageRegistry.addName(airWand, TC3_Info.airWandName);
		LanguageRegistry.addName(earthWand, TC3_Info.earthWandName);
	}

	public static void registerRecipes() {
		GameRegistry.addRecipe(new ItemStack(airWand, 1), 
				new Object[] { "  X", " X ", "S  ",
							   'X', Item.feather,
							   'S', Item.stick });
	

	}

}
