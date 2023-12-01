package genst.world.settlement

import lotr.common.LOTRMod
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.village.LOTRVillageGenRohan
import lotr.common.world.village.LocationInfo
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*

open class GenstRohan : LOTRVillageGenRohan(LOTRBiome.forodwaith, 0.0f) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = 4
		fixedVillageChunkRadius = 2
	}

	open class Instance(
		village: LOTRVillageGenRohan, world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	) : LOTRVillageGenRohan.Instance(village, world, i, k, random, loc) {

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			val meta = world.getBlockMetadata(i, j, k)
			val path = arrayOf(
				LOTRMod.slabSingle to 6,
				LOTRMod.brick to 4,
				LOTRMod.slabSingleDirt to 0,
				LOTRMod.slabSingleDirt to 1,
				LOTRMod.slabSingle11 to 4,
				Blocks.dirt to 1,
				LOTRMod.dirtPath to 0,
				LOTRMod.rock to 2
			)
			return super.isVillageSpecificSurface(world, i, j, k) || path.any { (pairBlock, pairMeta) ->
				block == pairBlock && meta == pairMeta
			}
		}

		override fun isFlat(): Boolean = false
	}
}