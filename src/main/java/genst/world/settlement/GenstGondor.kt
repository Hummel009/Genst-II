package genst.world.settlement

import genst.utils.getAllowedBlocks
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.structure2.LOTRWorldGenGondorStructure
import lotr.common.world.village.LOTRVillageGenGondor
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*

open class GenstGondor(
	fief: LOTRWorldGenGondorStructure.GondorFiefdom, radius: Int
) : LOTRVillageGenGondor(LOTRBiome.forodwaith, fief, 0.0f) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = radius
		fixedVillageChunkRadius = radius
	}

	open class Instance(
		village: LOTRVillageGenGondor, world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	) : LOTRVillageGenGondor.Instance(village, world, i, k, random, loc) {

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			return getAllowedBlocks(world, i, j, k)
		}

		override fun isFlat(): Boolean = false
	}
}