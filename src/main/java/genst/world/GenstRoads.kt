package genst.world

import genst.utils.info
import genst.utils.registerRoad
import lotr.common.LOTRMod
import lotr.common.world.map.LOTRRoadType
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
		val gondorTown = 0.3359375
		registerRoad("Linker", arrayOf(LOTRWaypoint.PELARGIR, LOTRWaypoint.PELARGIR.info(-0.1, -gondorTown)))
	}
}