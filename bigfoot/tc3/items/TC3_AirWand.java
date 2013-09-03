package bigfoot.tc3.items;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import bigfoot.tc3.info.TC3_Info;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TC3_AirWand extends Item {
	@SideOnly(Side.CLIENT)
	private Icon chargedIcon;

	public TC3_AirWand(int par1) {
		super(par1);
		setCreativeTab(CreativeTabs.tabCombat);
		setMaxStackSize(1);
		setUnlocalizedName(TC3_Info.airWandUnlocalizedName);
	}

	@Override
	public boolean func_111207_a(ItemStack itemstack, EntityPlayer player,
			EntityLivingBase target) {
		if (!target.worldObj.isRemote) {
			target.motionY = 2;
			if (isCharged(itemstack.getItemDamage())) {
				target.motionX = (target.posX - player.posX) * 2;
				target.motionZ = (target.posZ - player.posZ) * 2;

				itemstack.setItemDamage(0);
			} else {
				itemstack.setItemDamage(itemstack.getItemDamage() + 1);
			}
		}

		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(TC3_Info.TEXTURE_LOCATION + ":"
				+ TC3_Info.airWandIcon);
		chargedIcon = register.registerIcon(TC3_Info.TEXTURE_LOCATION + ":"
				+ TC3_Info.airWandChargedIcon);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg) {
		if (isCharged(dmg)) {
			return chargedIcon;
		} else {
			return itemIcon;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, EntityPlayer player,
			List info, boolean useExtraInformation) {
		info.add(EnumChatFormatting.WHITE + "You are "
				+ itemstack.getItemDamage() * 10 + "%" + " charged!");

		if (isCharged(itemstack.getItemDamage())) {
			info.remove(EnumChatFormatting.WHITE + "You are "
					+ itemstack.getItemDamage() * 10 + "%" + " charged!");
			info.add(EnumChatFormatting.RED + "100% CHARGED!");
		}
	}

	private boolean isCharged(int dmg) {
		return dmg >= 10;
	}
}
