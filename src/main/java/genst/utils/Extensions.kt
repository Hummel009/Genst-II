package genst.utils

import genst.GenstConfig
import genst.world.GenstLocations
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

fun LOTRWaypoint.linkTo(x: Double, y: Double): Array<Any> {
	return if (this.isGenstEnabled()) arrayOf(this, shift(x, y)) else emptyArray<Any>()
}

fun LOTRWaypoint.shift(x: Double, y: Double): DoubleArray = doubleArrayOf(this.x + x, this.y + y)

fun LOTRWaypoint.isGenstEnabled(): Boolean = GenstConfig.on[this] ?: false

fun Double.distance(radius: Double): Double {
	return when {
		this > 0.0 -> this - radius / 128.0
		this < 0.0 -> this + radius / 128.0
		else -> this
	}
}

fun Double.toHaradTown(): Double = distance(46.0)

fun Double.toGondorTown(): Double = distance(84.0)

fun Double.toGondorFort(): Double = distance(39.0)

fun Double.toRhunTown(): Double = distance(94.0)

fun Double.toRhunFort(): Double = distance(61.0)

fun Double.toRohanFort(): Double = distance(51.0)

fun Double.toBasicVillage(): Double = distance(17.0)

fun Double.toBasicTown(): Double = distance(86.0)

fun Double.toHarnennor(): Double = distance(63.0)

fun Double.toGulf(): Double = distance(98.0)

fun Double.toHaradTownGate(dir: GenstLocations.Dir): Double {
	return when (dir) {
		GenstLocations.Dir.EAST, GenstLocations.Dir.NORTH -> this - 34.0 / 128.0
		GenstLocations.Dir.SOUTH, GenstLocations.Dir.WEST -> this + 34.0 / 128.0
	}
}