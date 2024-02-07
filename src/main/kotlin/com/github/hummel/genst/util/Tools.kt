package com.github.hummel.genst.util

import cpw.mods.fml.relauncher.ReflectionHelper
import com.github.hummel.genst.world.Locations
import lotr.common.block.*
import lotr.common.world.map.LOTRMountains
import lotr.common.world.map.LOTRRoads
import lotr.common.world.map.LOTRWaypoint
import lotr.common.world.village.LOTRVillageGen
import net.minecraft.block.*
import net.minecraftforge.common.util.EnumHelper
import kotlin.math.abs

var i: Int = 0

fun affix(inst: LOTRVillageGen, wp: LOTRWaypoint, addX: Double, addY: Double, dir: Locations.Dir) {
	if (wp.isGenstEnabled()) {
		inst.addFixedLocation(wp, addX, addY, dir.ordinal, "PLACEHOLDER_${i++}")
		Locations.locations.add(inst)
	}
}

fun registerRoadI(data: Array<Any>, xAxis: Boolean) {
	val from = data[0] as LOTRWaypoint
	val to = data[1] as DoubleArray
	if (from.isGenstEnabled()) {
		val fromX = from.x
		val fromY = from.y
		val toX = to[0]
		val toY = to[1]
		if (xAxis) {
			val halfway = 0.1.coerceAtMost(abs((fromX - toX) / 2.0)) * if (fromX < toX) -1 else 1
			registerRoad(arrayOf(from, doubleArrayOf(toX + halfway, toY)))
			registerRoad(arrayOf(doubleArrayOf(toX + halfway, toY), doubleArrayOf(toX, toY)))
		} else {
			val halfway = 0.1.coerceAtMost(abs((fromY - toY) / 2.0)) * if (fromY < toY) -1 else 1
			registerRoad(arrayOf(from, doubleArrayOf(toX, toY + halfway)))
			registerRoad(arrayOf(doubleArrayOf(toX, toY + halfway), doubleArrayOf(toX, toY)))
		}
	}
}

fun registerRoad(waypoints: Array<Any>) {
	val addControlZoneMethod = ReflectionHelper.findMethod<LOTRRoads?>(
		LOTRRoads::class.java, null, arrayOf("registerRoad"), *arrayOf<Class<*>>(
			String::class.java, Array<Any>::class.java
		)
	)
	try {
		addControlZoneMethod.invoke(null, *arrayOf<Any>("Linker", waypoints))
	} catch (e: Exception) {
		e.printStackTrace()
	}
}

fun addMountain(wp: LOTRWaypoint, h: Float, r: Int, lava: Int) {
	if (wp.isGenstEnabled()) {
		addMountain(doubleArrayOf(wp.x, wp.y), h, r, lava)
	}
}

fun addMountain(db: DoubleArray, h: Float, r: Int, lava: Int) {
	val classArr = arrayOf<Class<*>>(
		java.lang.Double.TYPE, java.lang.Double.TYPE, java.lang.Float.TYPE, Integer.TYPE, Integer.TYPE
	)
	val args = arrayOf<Any>(db[0], db[1], h, r, lava)
	EnumHelper.addEnum(LOTRMountains::class.java, "PLACEHOLDER_${i++}", classArr, args)
}

fun editWaypoint(wp: LOTRWaypoint, shiftX: Double, shiftY: Double) {
	val name = wp.codeName
	val x = wp.x + shiftX
	val y = wp.y + shiftY
	val enumClass = LOTRWaypoint::class.java
	val enumValue = enumClass.enumConstants.find { it.name == name }

	enumValue?.let {
		val imgX = enumClass.getDeclaredField("imgX")
		val imgY = enumClass.getDeclaredField("imgY")
		val xCoord = enumClass.getDeclaredField("xCoord")
		val zCoord = enumClass.getDeclaredField("zCoord")

		imgX.isAccessible = true
		imgY.isAccessible = true
		xCoord.isAccessible = true
		zCoord.isAccessible = true

		imgX.set(it, x)
		imgY.set(it, y)
		xCoord.set(it, LOTRWaypoint.mapToWorldX(x))
		zCoord.set(it, LOTRWaypoint.mapToWorldZ(y))

		println("Modified $name: x=${it.x}, y=${it.y}")
	} ?: run {
		println("Waypoint $name not found.")
	}
}
