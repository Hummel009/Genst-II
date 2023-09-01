package genst.world.settlement

import lotr.common.LOTRMod
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.village.LOTRVillageGenUmbar
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*

open class GenstUmbar : LOTRVillageGenUmbar(LOTRBiome.forodwaith, 0.0f) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = 5
		fixedVillageChunkRadius = 3
	}

	open class Instance(
		village: LOTRVillageGenUmbar, world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	) : InstanceUmbar(village, world, i, k, random, loc) {

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			val meta = world.getBlockMetadata(i, j, k)
			val path = arrayOf(
				Pair(LOTRMod.slabSingle13, 2),
				Pair(LOTRMod.brick6, 6)
			)
			return super.isVillageSpecificSurface(world, i, j, k) || path.any { (pairBlock, pairMeta) ->
				block == pairBlock && meta == pairMeta
			}
		}

		override fun isFlat(): Boolean = false
	}
}