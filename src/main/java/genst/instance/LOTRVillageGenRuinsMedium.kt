package genst.instance

import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.LOTRWorldGenNumenorRuin
import lotr.common.world.structure2.LOTRWorldGenStoneRuin.STONE
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*

class LOTRVillageGenRuinsMedium : LOTRVillageGen(LOTRBiome.forodwaith) {
	init {
		gridScale = 10
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = 5
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> {
		return Instance(this, world, i, k, random, loc)
	}

	class Instance(
		village: LOTRVillageGenRuinsMedium?, world: World?, i: Int, k: Int, random: Random?, loc: LocationInfo?
	) : AbstractInstance<LOTRVillageGenRuinsMedium?>(village, world, i, k, random, loc) {

		override fun addVillageStructures(random: Random) {
			addStructure(LOTRWorldGenNumenorRuin(false), -18, 0, 0, true)
			addStructure(LOTRWorldGenNumenorRuin(false), +18, 0, 0, true)
			addStructure(LOTRWorldGenNumenorRuin(false), 0, +18, 0, true)
			addStructure(LOTRWorldGenNumenorRuin(false), 0, +18, 0, true)
			addStructure(STONE(5, 7), -18, -18, 0, true)
			addStructure(STONE(5, 7), +18, -18, 0, true)
			addStructure(STONE(5, 7), -18, +18, 0, true)
			addStructure(STONE(5, 7), +18, +18, 0, true)
			addStructure(LOTRWorldGenNumenorRuin(false), 0, 0, 0, true)
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