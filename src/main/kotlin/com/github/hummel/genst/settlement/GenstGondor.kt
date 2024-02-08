package com.github.hummel.genst.settlement

import lotr.common.LOTRMod
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.structure2.LOTRWorldGenGondorStructure
import lotr.common.world.village.LOTRVillageGenGondor
import lotr.common.world.village.LocationInfo
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*

open class GenstGondor(
	fief: LOTRWorldGenGondorStructure.GondorFiefdom, radius: Int
) : LOTRVillageGenGondor(LOTRBiome.forodwaith, fief, 0.0f) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = radius + 2
		fixedVillageChunkRadius = radius
	}

	open class Instance(
		village: LOTRVillageGenGondor, world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	) : LOTRVillageGenGondor.Instance(village, world, i, k, random, loc) {

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			val meta = world.getBlockMetadata(i, j, k)
			val path = arrayOf(
				LOTRMod.brick to 1,
				LOTRMod.slabSingle to 2,
				LOTRMod.slabSingle to 3,
				LOTRMod.slabSingle to 4,
				LOTRMod.slabSingle to 5,
				LOTRMod.slabDouble to 2,
				LOTRMod.brick to 2,
				LOTRMod.brick to 3,
				LOTRMod.slabSingle6 to 7,
				LOTRMod.brick3 to 9,
				Blocks.cobblestone to 0
			)
			return super.isVillageSpecificSurface(world, i, j, k) || path.any { (pairBlock, pairMeta) ->
				block == pairBlock && meta == pairMeta
			}
		}

		override fun isFlat(): Boolean = false
	}
}