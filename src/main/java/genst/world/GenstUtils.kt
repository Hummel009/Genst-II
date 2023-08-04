package genst.world

import cpw.mods.fml.relauncher.ReflectionHelper
import genst.GenstLogger
import lotr.common.world.map.LOTRMountains
import lotr.common.world.map.LOTRRoads
import lotr.common.world.map.LOTRWaypoint
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraftforge.common.util.EnumHelper

fun affix(inst: LOTRVillageGen, wp: LOTRWaypoint, addX: Double, addY: Double, rotation: Int) {
	GenstLogger.skip.add(wp)
	inst.addFixedLocation(
		wp, addX, addY, rotation, "PLACEHOLDER"
	)
	GenstLocations.locations.add(inst)
}

@Suppress("UNCHECKED_CAST")
fun LOTRVillageGen.addFixedLocation(
	wp: LOTRWaypoint, addX: Double, addY: Double, rotation: Int, name: String
): LocationInfo {
	val loc = LocationInfo(
		LOTRWaypoint.mapToWorldX(wp.x + addX), LOTRWaypoint.mapToWorldZ(wp.y + addY), rotation, name
	).setFixedLocation(wp)

	val field = LOTRVillageGen::class.java.getDeclaredField("fixedLocations")
	field.isAccessible = true
	val fixedLocationsValue = field.get(this) as ArrayList<LocationInfo>
	fixedLocationsValue.add(loc)
	return loc
}

fun LOTRWaypoint.info(x: Double, y: Double): DoubleArray {
	return doubleArrayOf(this.x + x, this.y + y)
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

fun addMountain(x: Double, z: Double, h: Float, r: Int, lava: Int) {
	val classArr = arrayOf<Class<*>>(
		java.lang.Double.TYPE, java.lang.Double.TYPE, java.lang.Float.TYPE, Integer.TYPE, Integer.TYPE
	)
	val args = arrayOf<Any>(x, z, h, r, lava)
	var i = 0
	EnumHelper.addEnum(LOTRMountains::class.java, "PLACEHOLDER_${i++}", classArr, args)
}