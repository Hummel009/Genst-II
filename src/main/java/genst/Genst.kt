package genst

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.SidedProxy
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import genst.proxy.CommonProxy
import genst.world.GenstLocations
import genst.world.GenstMountains
import genst.world.GenstRoads
import genst.world.GenstWaypoints

@Mod(modid = "genst", dependencies = "required-after:lotr", useMetadata = true)
@Suppress("unused", "UNUSED_PARAMETER")
class Genst {
	companion object {
		@SidedProxy(clientSide = "genst.proxy.ClientProxy", serverSide = "genst.proxy.CommonProxy")
		@JvmStatic
		lateinit var proxy: CommonProxy

		const val VERSION: String = "24.02.29"
	}

	@Mod.EventHandler
	fun preInit(e: FMLPreInitializationEvent) {
		GenstWaypoints.preInit()
		proxy.preInit()
	}

	@Mod.EventHandler
	fun postInit(e: FMLPostInitializationEvent) {
		GenstConfig.postInit()
		GenstMountains.postInit()
		GenstRoads.postInit()
		GenstLocations.postInit()
	}
}
