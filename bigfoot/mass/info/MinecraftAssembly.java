package bigfoot.mass.info;

import bigfoot.ic2.blocks.IC2_Blocks;
import bigfoot.ic2.items.IC2_Items;
import bigfoot.mass.blocks.MASS_Blocks;
import bigfoot.mass.config.MASS_ConfigHandler;
import bigfoot.mass.items.MASS_Items;
import bigfoot.mass.network.MASS_PacketHandler;
import bigfoot.mass.proxies.MASS_CommonProxy;
import bigfoot.tc3.blocks.TC3_Blocks;
import bigfoot.tc3.items.TC3_Items;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
@NetworkMod(channels = { ModInfo.CHANNEL }, clientSideRequired = true, serverSideRequired = false, packetHandler = MASS_PacketHandler.class)
public class MinecraftAssembly {
	@Instance(ModInfo.ID)
	public static MinecraftAssembly instance;

	@SidedProxy(clientSide = "bigfoot.mass.proxies.MASS_ClientProxy", serverSide = "bigfoot.mass.proxies.MASS_CommonProxy")
	public static MASS_CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MASS_ConfigHandler.init(event.getSuggestedConfigurationFile());
		MASS_Items.init();
		MASS_Blocks.init();
		IC2_Items.init();
		IC2_Blocks.init();
		TC3_Items.init();
		TC3_Blocks.init();
		proxy.initSounds();
		proxy.initRenderers();
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		MASS_Blocks.addNames();
		MASS_Blocks.registerRecipes();
		MASS_Blocks.registerTileEntities();

		MASS_Items.addNames();
		MASS_Items.registerRecipes();
		
		IC2_Items.addNames();
		IC2_Items.registerRecipes();

		TC3_Items.addNames();
		TC3_Items.registerRecipes();
		
	}

	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent event) {

	}

}
