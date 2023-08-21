package genst.world.settlement

import lotr.common.LOTRMod
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.village.LOTRVillageGenSouthron
import lotr.common.world.village.LocationInfo
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*

open class GenstSouthron : LOTRVillageGenSouthron(LOTRBiome.forodwaith, 0.0f) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = 5
		fixedVillageChunkRadius = 5
	}

	open class Instance(
		village: LOTRVillageGenSouthron, world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	) : LOTRVillageGenSouthron.Instance(village, world, i, k, random, loc) {

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			val meta = world.getBlockMetadata(i, j, k)
			val path = arrayOf(
				Pair(LOTRMod.slabSingle4, 0),
				Pair(LOTRMod.slabSingle7, 1),
				Pair(LOTRMod.slabSingleSand, 0),
				Pair(LOTRMod.slabSingleDirt, 1),
				Pair(LOTRMod.brick3, 11),
				Pair(LOTRMod.brick, 15),
				Pair(Blocks.sand, 0),
				Pair(Blocks.sandstone, 0),
				Pair(LOTRMod.dirtPath, 0)
			)
			return super.isVillageSpecificSurface(world, i, j, k) || path.any { (pairBlock, pairMeta) ->
				block == pairBlock && meta == pairMeta
			}
		}

		override fun isFlat(): Boolean = false
	}
}