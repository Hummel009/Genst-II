package genst

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.event.FMLServerStartingEvent
import genst.command.GenstLogger
import genst.world.GenstLocations
import genst.world.GenstMountains
import genst.world.GenstRoads

@Mod(modid = "genst", dependencies = "required-after:lotr")
class Genst {
	@Mod.EventHandler
	fun preInit(e: FMLPreInitializationEvent) {
		GenstTwicks.preInit()
	}

	@Mod.EventHandler
	fun postInit(e: FMLPostInitializationEvent) {
		GenstConfig.postInit()
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