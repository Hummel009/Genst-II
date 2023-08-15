package genst.world.settlement

import lotr.common.block.LOTRBlockBrickBase
import lotr.common.block.LOTRBlockSlabBase
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.village.LOTRVillageGenRhun
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*

open class GenstRhun(
	radius: Int
) : LOTRVillageGenRhun(LOTRBiome.forodwaith, 0.0f, false) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = radius
		fixedVillageChunkRadius = radius
	}

	open class Instance(
		village: LOTRVillageGenRhun, world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	) : LOTRVillageGenRhun.Instance(village, world, i, k, random, loc) {
		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			return block is LOTRBlockBrickBase || block is LOTRBlockSlabBase
		}

		override fun isFlat(): Boolean {
			return false
		}
	}
}