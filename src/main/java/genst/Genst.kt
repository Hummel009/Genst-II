package genst

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import genst.world.GenstLocations
import genst.world.GenstMountains
import genst.world.GenstRoads
import genst.world.GenstWaypoints

@Mod(modid = "genst", dependencies = "required-after:lotr", useMetadata = true)
@Suppress("unused", "UNUSED_PARAMETER")
class Genst {
	@Mod.EventHandler
	fun preInit(e: FMLPreInitializationEvent) {
		GenstWaypoints.preInit()
	}

	@Mod.EventHandler
	fun postInit(e: FMLPostInitializationEvent) {
		GenstConfig.postInit()
		GenstMountains.postInit()
		GenstRoads.postInit()
		GenstLocations.postInit()
	}
}