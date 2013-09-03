package bigfoot.mass.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import bigfoot.mass.info.MASS_Info;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MASS_Items 
{
	public static Item card;
	
	public static void init()
	{
		card = new MASS_ItemCard(MASS_Info.cardID);
	}

	public static void addNames()
	{
		for (int i = 0; i < MASS_Info.cardNames.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(card, 1, i), MASS_Info.cardNames[i]);
		}
	}
	
	public static void registerRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(card, 1, 0), 
				new Object[] { "RDR", "GBG", "RDR",
			   			'R', Item.redstone,
			   			'D', Item.diamond,
			   			'G', Item.ingotGold,
			   			'B', Block.dirt});
		GameRegistry.addRecipe(new ItemStack(card, 1, 0), 
				new Object[] { "RGR", "DBD", "RGR",
			   			'R', Item.redstone,
			   			'D', Item.diamond,
			   			'G', Item.ingotGold,
			   			'B', Block.dirt});

		GameRegistry.addRecipe(new ItemStack(card, 1, 1), 
				new Object[] { "RDR", "GWG", "RDR",
						'R', Item.redstone,
						'D', Item.diamond,
						'G', Item.ingotGold,
						'W', Item.bucketWater});
		GameRegistry.addRecipe(new ItemStack(card, 1, 1), 
				new Object[] { "RGR", "DWD", "RGR",
						'R', Item.redstone,
						'D', Item.diamond,
						'G', Item.ingotGold,
						'W', Item.bucketWater});

		GameRegistry.addRecipe(new ItemStack(card, 1, 2), 
				new Object[] { "RDR", "GSG", "RDR",
					   	'R', Item.redstone,
					   	'D', Item.diamond,
					   	'G', Item.ingotGold,
					   	'S', Block.sand});
		GameRegistry.addRecipe(new ItemStack(card, 1, 2), 
				new Object[] { "RGR", "DSD", "RGR",
					   	'R', Item.redstone,
					   	'D', Item.diamond,
					   	'G', Item.ingotGold,
					   	'S', Block.sand});
	}
	
}
