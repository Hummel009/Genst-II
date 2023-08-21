package genst.world.settlement

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
		villageChunkRadius = radius
		fixedVillageChunkRadius = radius
	}

	open class Instance(
		village: LOTRVillageGenGondor, world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	) : LOTRVillageGenGondor.Instance(village, world, i, k, random, loc) {

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			val meta = world.getBlockMetadata(i, j, k)
			val path = arrayOf(
				Pair(LOTRMod.brick, 1),
				Pair(LOTRMod.slabSingle, 2),
				Pair(LOTRMod.slabSingle, 3),
				Pair(LOTRMod.slabSingle, 4),
				Pair(LOTRMod.slabSingle, 5),
				Pair(LOTRMod.slabDouble, 2),
				Pair(LOTRMod.brick, 2),
				Pair(LOTRMod.brick, 3),
				Pair(LOTRMod.slabSingle6, 7),
				Pair(LOTRMod.brick3, 9),
				Pair(Blocks.cobblestone, 0)
			)
			return super.isVillageSpecificSurface(world, i, j, k) || path.any { (pairBlock, pairMeta) ->
				block == pairBlock && meta == pairMeta
			}
		}

		override fun isFlat(): Boolean = false
	}
}