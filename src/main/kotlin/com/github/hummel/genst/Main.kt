package com.github.hummel.genst

import com.github.hummel.genst.init.Locations
import com.github.hummel.genst.init.Mountains
import com.github.hummel.genst.init.Roads
import com.github.hummel.genst.init.Waypoints
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent

@Mod(modid = "genst", dependencies = "required-after:lotr", useMetadata = true)
@Suppress("unused", "UNUSED_PARAMETER")
class Main {
	@Mod.EventHandler
	fun preInit(event: FMLPreInitializationEvent) {
		Config.preInit(event)

		Waypoints.preInit()
	}

	@Mod.EventHandler
	fun postInit(event: FMLPostInitializationEvent) {
		Mountains.postInit()
		Roads.postInit()
		Locations.postInit()
	}
}