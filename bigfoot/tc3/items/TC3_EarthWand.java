package bigfoot.tc3.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import bigfoot.tc3.info.TC3_Info;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TC3_EarthWand extends Item
{
	public TC3_EarthWand(int par1) {
		super(par1);
		setCreativeTab(CreativeTabs.tabTools);
		setMaxStackSize(1);
		setUnlocalizedName(TC3_Info.earthWandUnlocalizedName);
	}
 	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, int blockID,
			int x, int y, int z, EntityLivingBase entityLivingBase) {
				if (!world.isRemote) {
					if (blockID == Block.tallGrass.blockID) {
						world.spawnEntityInWorld(new EntityItem(world, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack(Item.seeds, 1, 0)));
					}
				}
				if (!world.isRemote) {
				if (blockID == Block.leaves.blockID) {
					switch (Block.leaves.getDamageValue(world, x, y, z)) {
					case 0:
						world.spawnEntityInWorld(new EntityItem(world, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack(Block.sapling, 1, 0)));
						break;
					case 1:
						world.spawnEntityInWorld(new EntityItem(world, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack(Block.sapling, 1, 1)));
						break;
					case 2:
						world.spawnEntityInWorld(new EntityItem(world, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack(Block.sapling, 1, 2)));
						break;
					case 3:
						world.spawnEntityInWorld(new EntityItem(world, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack(Block.sapling, 1, 3)));
					}
				}
		}
		return true;
	}

    @Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(TC3_Info.TEXTURE_LOCATION + ":" + TC3_Info.earthWandIcon);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation)
	{
		info.add(EnumChatFormatting.GREEN + "You are " + itemstack.getItemDamage() * 10 + "%" + " charged!");
	}
}