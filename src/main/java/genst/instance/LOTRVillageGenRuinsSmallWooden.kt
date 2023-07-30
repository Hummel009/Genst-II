package genst.instance

import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.LOTRWorldGenRuinedHouse
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*

class LOTRVillageGenRuinsSmallWooden(biome: LOTRBiome?, f: Float) : LOTRVillageGen(biome) {
	init {
		gridScale = 14
		gridRandomDisplace = 1
		spawnChance = f
		villageChunkRadius = 6
	}

	override fun createVillageInstance(
		world: World,
		i: Int,
		k: Int,
		random: Random,
		loc: LocationInfo
	): AbstractInstance<*> {
		return Instance(this, world, i, k, random, loc)
	}

	class Instance(
		village: LOTRVillageGenRuinsSmallWooden?,
		world: World?,
		i: Int,
		k: Int,
		random: Random?,
		loc: LocationInfo?
	) : AbstractInstance<LOTRVillageGenRuinsSmallWooden?>(village, world, i, k, random, loc) {
		override fun addVillageStructures(random: Random) {
			addStructure(LOTRWorldGenRuinedHouse(false), 0, 0, 0, true)
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			return null
		}

		override fun isFlat(): Boolean {
			return false
		}

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			return false
		}

		override fun setupVillageProperties(random: Random) {}
	}
}
