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

@Mod(modid = "genst", dependencies = "required-after:lotr")
class Genst {
	companion object {
		const val VERSION: String = "23.08.25"

		@SidedProxy(clientSide = "genst.proxy.ClientProxy", serverSide = "genst.proxy.CommonProxy")
		@JvmStatic
		lateinit var proxy: CommonProxy
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