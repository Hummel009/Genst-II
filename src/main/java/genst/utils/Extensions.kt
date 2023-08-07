package genst.utils

import genst.GenstConfig
import lotr.common.world.map.LOTRWaypoint
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo


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

fun LOTRWaypoint.isNotForbidden(): Boolean {
	return GenstConfig.isNotForbidden(this) ?: false
}
