package genst.utils

import cpw.mods.fml.relauncher.ReflectionHelper
import genst.GenstLogger
import genst.world.GenstLocations
import lotr.common.world.map.LOTRMountains
import lotr.common.world.map.LOTRRoads
import lotr.common.world.map.LOTRWaypoint
import lotr.common.world.village.LOTRVillageGen
import net.minecraftforge.common.util.EnumHelper

fun affix(inst: LOTRVillageGen, wp: LOTRWaypoint, addX: Double, addY: Double, rotation: Int) {
	GenstLogger.skip.add(wp)
	inst.addFixedLocation(wp, addX, addY, rotation, "PLACEHOLDER")
	GenstLocations.locations.add(inst)
}

fun registerRoad(name: String, waypoints: Array<Any>) {
	val addControlZoneMethod = ReflectionHelper.findMethod<LOTRRoads?>(
		LOTRRoads::class.java, null, arrayOf("registerRoad"), *arrayOf<Class<*>>(
			String::class.java, Array<Any>::class.java
		)
	)
	try {
		addControlZoneMethod.invoke(null, *arrayOf<Any>(name, waypoints))
	} catch (e: Exception) {
		e.printStackTrace()
	}
}

var i: Int = 0
fun addMountain(x: Double, z: Double, h: Float, r: Int, lava: Int) {
	val classArr = arrayOf<Class<*>>(
		java.lang.Double.TYPE, java.lang.Double.TYPE, java.lang.Float.TYPE, Integer.TYPE, Integer.TYPE
	)
	val args = arrayOf<Any>(x, z, h, r, lava)
	EnumHelper.addEnum(LOTRMountains::class.java, "PLACEHOLDER_${i++}", classArr, args)
}