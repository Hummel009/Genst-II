package genst.world.settlement

import lotr.common.world.biome.LOTRBiome
import lotr.common.world.village.LOTRVillageGenSouthron
import lotr.common.world.village.LocationInfo
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

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean = false

		override fun isFlat(): Boolean = false
	}
}