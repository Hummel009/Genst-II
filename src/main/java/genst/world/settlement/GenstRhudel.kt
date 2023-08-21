package genst.world.settlement

import lotr.common.LOTRMod
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.village.LOTRVillageGenRhun
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*

open class GenstRhudel(
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
			val meta = world.getBlockMetadata(i, j, k)
			val path = arrayOf(
				Pair(LOTRMod.slabSingle12, 1),
				Pair(LOTRMod.slabSingle12, 2),
				Pair(LOTRMod.slabSingle12, 0),
				Pair(LOTRMod.brick5, 13),
				Pair(LOTRMod.brick5, 14),
				Pair(LOTRMod.brick5, 11)
			)
			return path.any { (pairBlock, pairMeta) ->
				block == pairBlock && meta == pairMeta
			}
		}

		override fun isFlat(): Boolean = false
	}
}