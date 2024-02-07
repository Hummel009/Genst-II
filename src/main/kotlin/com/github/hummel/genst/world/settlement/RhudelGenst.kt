package com.github.hummel.genst.world.settlement

import lotr.common.LOTRMod
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.village.LOTRVillageGenRhun
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*

open class RhudelGenst(
	radius: Int
) : LOTRVillageGenRhun(LOTRBiome.forodwaith, 0.0f, false) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = radius + 2
		fixedVillageChunkRadius = radius
	}

	open class Instance(
		village: LOTRVillageGenRhun, world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	) : LOTRVillageGenRhun.Instance(village, world, i, k, random, loc) {

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			val meta = world.getBlockMetadata(i, j, k)
			val path = arrayOf(
				LOTRMod.slabSingle12 to 1,
				LOTRMod.slabSingle12 to 2,
				LOTRMod.slabSingle12 to 0,
				LOTRMod.brick5 to 13,
				LOTRMod.brick5 to 14,
				LOTRMod.brick5 to 11
			)
			return super.isVillageSpecificSurface(world, i, j, k) || path.any { (pairBlock, pairMeta) ->
				block == pairBlock && meta == pairMeta
			}
		}

		override fun isFlat(): Boolean = false
	}
}