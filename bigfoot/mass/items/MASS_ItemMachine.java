package bigfoot.mass.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import bigfoot.mass.info.MASS_Info;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MASS_ItemMachine extends ItemBlock
{

	public MASS_ItemMachine(int id) {
		super(id);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int dmg)
	{
		return dmg;
	}
		
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int id, CreativeTabs tab, List list)
	{
		for (int i = 0; i < MASS_Info.machineSides.length; i++)
		{
			list.add(new ItemStack(id, 1, i * 2));
		}
	}
	

}
