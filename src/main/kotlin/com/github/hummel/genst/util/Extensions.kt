package com.github.hummel.genst.util

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

fun LOTRWaypoint.linkTo(shiftX: Double, shiftY: Double): Array<Any> =
	if (isGenstEnabled()) arrayOf(this, shift(shiftX, shiftY)) else arrayOf()

fun LOTRWaypoint.shift(shiftX: Double, shiftY: Double): DoubleArray = doubleArrayOf(x + shiftX, y + shiftY)

fun LOTRWaypoint.isGenstEnabled(): Boolean = com.github.hummel.genst.Config.on[this] ?: false

fun Double.toSettlement(radius: Double): Double {
	return when {
		this > 0.0 -> this - radius / 128.0
		this < 0.0 -> this + radius / 128.0
		else -> this
	}
}

fun Double.toHaradTown(): Double = toSettlement(46.0)

fun Double.toGondorTown(): Double = toSettlement(84.0)

fun Double.toGondorFort(): Double = toSettlement(39.0)

fun Double.toRhunTown(): Double = toSettlement(94.0)

fun Double.toRhunFort(): Double = toSettlement(61.0)

fun Double.toRohanFort(): Double = toSettlement(51.0)

fun Double.toBasicVillage(): Double = toSettlement(17.0)

fun Double.toBasicTown(): Double = toSettlement(86.0)

fun Double.toHarnennor(): Double = toSettlement(63.0)

fun Double.toGulf(): Double = toSettlement(98.0)

fun Double.toHaradTownGate(xAxis: Boolean): Double = this + 34.0 / 128.0 * if (xAxis) 1 else -1