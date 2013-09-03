package bigfoot.mass.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import bigfoot.mass.info.MASS_Info;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MASS_Machine extends Block 
{

	public MASS_Machine(int id) {
		super(id, Material.iron);
		setCreativeTab(CreativeTabs.tabRedstone);
		setHardness(5F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(MASS_Info.machineUnlocalizedName);
	}

	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	@SideOnly(Side.CLIENT)
	private Icon bottomIcon;
	@SideOnly(Side.CLIENT)
	private Icon sideIcons[];
	@SideOnly(Side.CLIENT)
	private Icon disableIcon;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register)
	{
		topIcon = register.registerIcon(MASS_Info.TEXTURE_LOCATION + ":" + MASS_Info.machineTop);
		bottomIcon = register.registerIcon(MASS_Info.TEXTURE_LOCATION + ":" + MASS_Info.machineBottom);
		sideIcons = new Icon[MASS_Info.machineSides.length];
		for (int i = 0; i < sideIcons.length; i++){
			sideIcons[i] = register.registerIcon(MASS_Info.TEXTURE_LOCATION + ":" + MASS_Info.machineSides[i]);
		}
		disableIcon = register.registerIcon(MASS_Info.TEXTURE_LOCATION + ":" + MASS_Info.machineDisable);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta)
	{
		if (side == 0)
		{
			return bottomIcon;
		}
		if (side == 1)
		{
			return isDisabled(meta) ? disableIcon : topIcon;
		}
		else
		{
			int type = meta / 2;
			return sideIcons[type];
		}

	}
	
	private boolean isDisabled(int meta)
	{
		return meta % 2 == 1;
	}
		
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int id)
	{
		int meta = world.getBlockMetadata(x, y, z);
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && isDisabled(meta))
		{
			switch (meta / 2)
			{
				case 0:
				for (int i = -1; i < 1; i++)
				{
					spawnBlock(world, x, y + 1, z);
				}
				break;
				case 1:
				for (int i = -1; i < 1; i++)
				{
					spawnBlock1(world, x, y + 1, z);
				}
				break;
				case 2:
				for (int i = -1; i < 1; i++)
				{
					spawnBlock2(world, x, y + 1, z);
				}
				break;
				case 3:
				for (int i = -1; i < 1; i++)
				{
					spawnBlock3(world, x, y + 1, z);
				}
				break;
			}
		}
	}
	
	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
	
	private void spawnBlock(World world, int x, int y, int z)
	{
		if (world.isAirBlock(x, y, z))
		{
			world.setBlock(x, y, z, Block.cobblestone.blockID);
		}
	}
	private void spawnBlock1(World world, int x, int y, int z)
	{
		if (world.isAirBlock(x, y, z))
		{
			world.setBlock(x, y, z, Block.dirt.blockID);
		}
	}
	private void spawnBlock2(World world, int x, int y, int z)
	{
		if (world.isAirBlock(x, y, z))
		{
			world.setBlock(x, y, z, Block.waterStill.blockID);
		}
	}
	private void spawnBlock3(World world, int x, int y, int z)
	{
		if (world.isAirBlock(x, y, z))
		{
			world.setBlock(x, y, z, Block.sand.blockID);
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			int meta = world.getBlockMetadata(x, y, z);
			
			int type = meta / 2;
			int disabled = meta % 2 == 0 ? 1 : 0;
			int newMeta = type * 2 + disabled;
					
			world.setBlockMetadataWithNotify(x, y, z, newMeta, 3);
		}
		return true;
	}
	
	
	
}
