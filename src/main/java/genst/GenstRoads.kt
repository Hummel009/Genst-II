package genst

import lotr.common.LOTRMod
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.map.LOTRRoads
import lotr.common.world.map.LOTRWaypoint
import net.minecraft.init.Blocks
import net.minecraft.world.biome.BiomeGenBase
import java.util.*


object GenstRoads {
	val PATH_COBBLE: LOTRRoadType = object : LOTRRoadType() {
		override fun getBlock(rand: Random, biome: BiomeGenBase, top: Boolean, slab: Boolean): RoadBlock {
			val blockTypes: Array<RoadBlock> = if (slab) {
				arrayOf(
					RoadBlock(Blocks.stone_slab, 5),
					RoadBlock(Blocks.stone_slab, 3),
					RoadBlock(Blocks.stone_slab, 3),
					RoadBlock(LOTRMod.slabSingleV, 4)
				)
			} else {
				arrayOf(
					RoadBlock(Blocks.stonebrick, 0),
					RoadBlock(Blocks.cobblestone, 0),
					RoadBlock(Blocks.cobblestone, 0),
					RoadBlock(Blocks.mossy_cobblestone, 0)
				)
			}
			return blockTypes[rand.nextInt(blockTypes.size)]
		}
	}

	fun postInit() {
		registerRoad("Linker", arrayOf(LOTRWaypoint.PELARGIR, LOTRWaypoint.PELARGIR.info(0.0, -0.5)))
	}

	private fun registerRoad(name: String, waypoints: Array<Any>) {
		try {
			val lotrRoadsClass = LOTRRoads::class.java
			val registerRoadMethod = lotrRoadsClass.getDeclaredMethod(
				"registerRoad", String::class.java, Array<Any>::class.java
			)
			registerRoadMethod.setAccessible(true)
			registerRoadMethod.invoke(null, name, waypoints)
		} catch (e: Exception) {
			e.printStackTrace()
		}
	}
}

private fun LOTRWaypoint.info(x: Double, y: Double): Array<Double> {
	return arrayOf(this.x + x, this.y + y)
}