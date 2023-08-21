package genst.utils

import cpw.mods.fml.relauncher.ReflectionHelper
import genst.command.GenstLogger
import genst.world.GenstLocations
import lotr.common.block.*
import lotr.common.world.map.LOTRMountains
import lotr.common.world.map.LOTRRoads
import lotr.common.world.map.LOTRWaypoint
import lotr.common.world.village.LOTRVillageGen
import net.minecraft.block.*
import net.minecraft.init.Blocks
import net.minecraft.world.World
import net.minecraftforge.common.util.EnumHelper
import kotlin.math.abs

var i: Int = 0

fun affix(inst: LOTRVillageGen, wp: LOTRWaypoint, addX: Double, addY: Double, dir: GenstLocations.Dir) {
	if (wp.isGenstEnabled()) {
		GenstLogger.skip.add(wp)
		inst.addFixedLocation(wp, addX, addY, dir.ordinal, "PLACEHOLDER_${i++}")
		GenstLocations.locations.add(inst)
	}
}

fun registerRoadI(data: Array<Any>, subtractX: Boolean) {
	val wp = data[0] as LOTRWaypoint
	val final = data[1] as DoubleArray
	if (wp.isGenstEnabled()) {
		val origX = wp.x
		val origY = wp.y
		val finalX = final[0]
		val finalY = final[1]
		if (subtractX) {
			val wayXprev = abs((origX - finalX) / 2.0)
			val wayX = if (wayXprev > 0.1) 0.1 else wayXprev
			val shift = if (origX < finalX) -wayX else wayX
			registerRoad(arrayOf(wp, doubleArrayOf(finalX + shift, finalY)))
			registerRoad(arrayOf(doubleArrayOf(finalX + shift, finalY), doubleArrayOf(finalX, finalY)))
		} else {
			val wayYprev = abs((origY - finalY) / 2.0)
			val wayY = if (wayYprev > 0.1) 0.1 else wayYprev
			val shift = if (origY < finalY) -wayY else wayY
			registerRoad(arrayOf(wp, doubleArrayOf(finalX, finalY + shift)))
			registerRoad(arrayOf(doubleArrayOf(finalX, finalY + shift), doubleArrayOf(finalX, finalY)))
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
	} ?: {
		println("Waypoint $name not found.")
	}
}


val classes: Array<Class<out Block>> = arrayOf(
	BlockSnow::class.java,
	BlockStone::class.java,
	LOTRBlockRock::class.java,
	BlockSand::class.java,
	BlockSandStone::class.java,
	LOTRBlockWaste::class.java,
	BlockGravel::class.java,
	BlockClay::class.java,
	BlockHardenedClay::class.java,
	LOTRBlockBrickBase::class.java,
	LOTRBlockSlabBase::class.java,
	LOTRBlockDirtPath::class.java,
	LOTRBlockMud::class.java,
	LOTRBlockMudGrass::class.java,
	LOTRBlockPillarBase::class.java,
	LOTRBlockWallBase::class.java,
	LOTRBlockQuagmire::class.java,
	LOTRBlockCobblebrick::class.java,
	BlockDirt::class.java,
	BlockGrass::class.java,
	BlockOre::class.java,
	BlockSlab::class.java,
	BlockIce::class.java,
	BlockSoulSand::class.java,
	BlockStoneBrick::class.java,
	BlockPackedIce::class.java,
)

val blocks: Array<Block> = arrayOf(
	Blocks.cobblestone, Blocks.mossy_cobblestone
)

fun getAllowedBlocks(world: World, i: Int, j: Int, k: Int): Boolean {
	val block = world.getBlock(i, j, k)
	return classes.contains(block::class.java) || blocks.contains(block)
}