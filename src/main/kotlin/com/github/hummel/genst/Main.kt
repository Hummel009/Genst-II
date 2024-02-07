package com.github.hummel.genst

import com.github.hummel.genst.world.Locations
import com.github.hummel.genst.world.map.Mountains
import com.github.hummel.genst.world.map.Roads
import com.github.hummel.genst.world.map.Waypoints
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent

@Mod(modid = "genst", dependencies = "required-after:lotr", useMetadata = true)
@Suppress("unused", "UNUSED_PARAMETER")
class Main {
	@Mod.EventHandler
	fun preInit(e: FMLPreInitializationEvent) {
		Waypoints.preInit()
	}

	@Mod.EventHandler
	fun postInit(e: FMLPostInitializationEvent) {
		Config.postInit()
		Mountains.postInit()
		Roads.postInit()
		Locations.postInit()
	}
}