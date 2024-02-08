package com.github.hummel.genst.settlement

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
		fixedVillageChunkRadius = 3
	}

	open class Instance(
		village: LOTRVillageGenSouthron, world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	) : LOTRVillageGenSouthron.Instance(village, world, i, k, random, loc) {

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			val meta = world.getBlockMetadata(i, j, k)
			val path = arrayOf(
				LOTRMod.slabSingle4 to 0,
				LOTRMod.slabSingle7 to 1,
				LOTRMod.slabSingleSand to 0,
				LOTRMod.slabSingleDirt to 1,
				LOTRMod.brick3 to 11,
				LOTRMod.brick to 15,
				Blocks.sand to 0,
				Blocks.sandstone to 0,
				LOTRMod.dirtPath to 0
			)
			return super.isVillageSpecificSurface(world, i, j, k) || path.any { (pairBlock, pairMeta) ->
				block == pairBlock && meta == pairMeta
			}
		}

		override fun isFlat(): Boolean = false
	}
}