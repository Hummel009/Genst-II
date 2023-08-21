package genst.world.settlement

import lotr.common.LOTRMod
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.LOTRWorldGenGondorStructure
import lotr.common.world.village.LOTRVillageGenGondor
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs

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
				Pair(LOTRMod.slabSingle, 3)
			)
			return path.any { (pairBlock, pairMeta) ->
				block == pairBlock && meta == pairMeta
			}
		}

		override fun isFlat(): Boolean = false

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			val i1 = abs(i)
			val k1 = abs(k)
			if (villageType == VillageType.VILLAGE) {
				val dSq = i * i + k * k
				val imn = 20 + random.nextInt(4)
				if (dSq < imn * imn) {
					return LOTRRoadType.PATH
				}
				val omn = 53 - random.nextInt(4)
				val omx = 60 + random.nextInt(4)
				if (dSq > omn * omn && dSq < omx * omx || dSq < 2809 && abs(i1 - k1) <= 2 + random.nextInt(4)) {
					return LOTRRoadType.PATH
				}
			}
			if (villageType == VillageType.TOWN && i1 <= 80 && k1 <= 80) {
				return LOTRRoadType.PATH
			}
			if (villageType == VillageType.FORT) {
				if (i1 <= 1 && (k >= 13 || k <= -12) && k1 <= 36) {
					return instanceVillageBiome.roadBlock
				}
				if (k1 <= 1 && i1 >= 12 && i1 <= 36) {
					return instanceVillageBiome.roadBlock
				}
				if (k in 26..28 && i1 <= 12) {
					return instanceVillageBiome.roadBlock
				}
			}
			return null
		}
	}
}