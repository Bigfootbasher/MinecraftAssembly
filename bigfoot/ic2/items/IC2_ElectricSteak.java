package bigfoot.ic2.items;

import ic2.api.item.ElectricItem;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import bigfoot.ic2.info.IC2_Info;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IC2_ElectricSteak extends IC2_ElectricBase {

	public IC2_ElectricSteak(int id) {
		super(id);
		setCreativeTab(CreativeTabs.tabFood);
		setUnlocalizedName(IC2_Info.electricSteakUnlocalizedName);
		this.maxCharge = 10000;
		this.transferLimit = 200;
		this.tier = 1;
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
	    if (ElectricItem.manager.use(itemstack, 1000, player))
	    {
	    	if(player.isSneaking()) {
	    		player.getFoodStats().addStats(-6, 2.4F);
	    		return itemstack;
	    	} else {
	    		player.getFoodStats().addStats(6, 2.4F);
	    		return itemstack;
	    	}
	    } else {
	    	if(!world.isRemote)
	    		player.addChatMessage(EnumChatFormatting.RED + "Out of EU!");
	    }

	    return itemstack;
	  }

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(IC2_Info.TEXTURE_LOCATION + ":" + IC2_Info.electricSteakIcon);
	}
}