package genst.world.settlement

import lotr.common.block.*
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.village.LOTRVillageGenRohan
import lotr.common.world.village.LocationInfo
import net.minecraft.block.BlockStone
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*

open class GenstRohan : LOTRVillageGenRohan(LOTRBiome.forodwaith, 0.0f) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = 5
		fixedVillageChunkRadius = 5
	}

	open class Instance(
		village: LOTRVillageGenRohan, world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	) : LOTRVillageGenRohan.Instance(village, world, i, k, random, loc) {

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			return block is LOTRBlockBrickBase || block is LOTRBlockSlabBase || block is LOTRBlockRock || block is LOTRBlockGrass || block is LOTRBlockDirtPath || block is BlockStone || block == Blocks.cobblestone
		}

		override fun isFlat() = false
	}
}