package genst

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLServerStartingEvent

@Mod(modid = "genst", dependencies = "required-after:lotr")
class Genst {
	@Mod.EventHandler
	fun postInit(e: FMLPostInitializationEvent) {
		GenstMountains.postInit()
		GenstRoads.postInit()
		GenstLocations.postInit()
		GenstLogger.postInit()
	}

	@Mod.EventHandler
	fun serverStarting(e: FMLServerStartingEvent) {
		e.registerServerCommand(GenstLogger)
	}
}
