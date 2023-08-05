package genst.instance

import lotr.common.block.LOTRBlockBrick
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.structure2.LOTRWorldGenGondorStructure
import lotr.common.world.village.LOTRVillageGenGondor
import lotr.common.world.village.LocationInfo
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*

open class GenstGondor(
	biome: LOTRBiome, fief: LOTRWorldGenGondorStructure.GondorFiefdom, f: Float
) : LOTRVillageGenGondor(biome, fief, f) {
	init {
		villageChunkRadius = 6
	}

	open class Instance(
		village: LOTRVillageGenGondor, world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	) : LOTRVillageGenGondor.Instance(village, world, i, k, random, loc) {
		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			val road = block is LOTRBlockBrick
			val path = block == Blocks.cobblestone
			return villageType == VillageType.TOWN && (path || road)
		}
	}
}