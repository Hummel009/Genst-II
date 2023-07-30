package genst;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = "genst", dependencies = "required-after:lotr")
public class Genst {
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		GenstMountains.postInit();
		GenstLocations.postInit();
		GenstLogger.postInit();
	}

	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent e) {
		e.registerServerCommand(GenstLogger.INSTANCE);
	}
}
