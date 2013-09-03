package bigfoot.mass.config;

import java.io.File;

import net.minecraftforge.common.Configuration;
import bigfoot.ic2.info.IC2_Info;
import bigfoot.mass.info.MASS_Info;
import bigfoot.tc3.info.TC3_Info;

public class MASS_ConfigHandler 
{	
	
	public static void init(File file)
	{
		Configuration config = new Configuration(file);
		
		config.load();
		
		MASS_Info.machineID = config.getBlock(MASS_Info.machineKey, MASS_Info.machineDefault).getInt();
		MASS_Info.smelteryID = config.getBlock(MASS_Info.smelteryKey, MASS_Info.smelteryDefault).getInt();
		MASS_Info.cardID = config.getItem(MASS_Info.cardKey, MASS_Info.cardDefault).getInt() - 256;

		TC3_Info.airWandID = config.getItem(TC3_Info.airWandKey, TC3_Info.airWandDefault).getInt() - 256;
		TC3_Info.earthWandID = config.getItem(TC3_Info.earthWandKey, TC3_Info.earthWandDefault).getInt() - 256;
		
		IC2_Info.electricSteakID = config.getItem(IC2_Info.electricSteakKey, IC2_Info.electricSteakDefault).getInt() - 256;
		IC2_Info.advElectricSteakID = config.getItem(IC2_Info.advElectricSteakKey, IC2_Info.advElectricSteakDefault).getInt() - 256;
		IC2_Info.electricGrafterID = config.getItem(IC2_Info.electricGrafterKey, IC2_Info.electricGrafterDefault).getInt() - 256;

		config.save();		
		
	}

}
