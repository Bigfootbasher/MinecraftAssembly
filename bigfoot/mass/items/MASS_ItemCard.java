package bigfoot.mass.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import bigfoot.mass.info.MASS_Info;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MASS_ItemCard extends Item {

	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	public MASS_ItemCard(int par1) {
		super(par1);
		setCreativeTab(CreativeTabs.tabMisc);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return MASS_Info.cardUnlocalizedName + itemstack.getItemDamage();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		icons = new Icon[MASS_Info.cardIcons.length];
		for (int i = 0; i < icons.length; i++) {
			icons[i] = register.registerIcon(MASS_Info.TEXTURE_LOCATION + ":"
					+ MASS_Info.cardIcons[i]);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIconFromDamage(int dmg) {
		return icons[dmg];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < MASS_Info.cardNames.length; i++) {
			ItemStack stack = new ItemStack(id, 1, i);
			list.add(stack);
		}
	}

	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player,
			World world, int x, int y, int z, int side, float hitX, float hitY,
			float hitZ) {
		if (!world.isRemote && world.getBlockId(x, y, z) == MASS_Info.machineID) {
			int meta = world.getBlockMetadata(x, y, z);
			int disabled = meta % 2;
			int type = stack.getItemDamage() + 1;
			int newMeta = type * 2 + disabled;

			world.setBlockMetadataWithNotify(x, y, z, newMeta, 3);
			stack.stackSize--;

			return true;
		} else {
			return false;
		}
	}
}
