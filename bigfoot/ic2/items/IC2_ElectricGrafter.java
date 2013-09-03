package bigfoot.ic2.items;

import ic2.api.item.ElectricItem;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import bigfoot.ic2.info.IC2_Info;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IC2_ElectricGrafter extends IC2_ElectricBase {

	public IC2_ElectricGrafter(int id) {
		super(id);
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName(IC2_Info.electricGrafterUnlocalizedName);
		this.maxCharge = 10000;
		this.transferLimit = 200;
		this.tier = 1;
	}
	    	@Override
	   public boolean onBlockDestroyed(ItemStack itemstack, World world, int blockID, int x, int y, int z, EntityLivingBase entityLivingBase) {
	  if (ElectricItem.manager.use(itemstack, 1000, entityLivingBase))
	  {	  
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
	  }
	    		return true;
	    	}

		
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(IC2_Info.TEXTURE_LOCATION + ":" + IC2_Info.electricGrafterIcon);
	}
}