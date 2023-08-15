package genst.world.settlement

import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.LOTRWorldGenBreeInn
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*

object GenstBreeInn : LOTRVillageGen(LOTRBiome.forodwaith) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = 2
		fixedVillageChunkRadius = 2
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> {
		return Instance(this, world, i, k, random, loc)
	}

	class Instance(
		village: GenstBreeInn?, world: World?, i: Int, k: Int, random: Random?, loc: LocationInfo?
	) : AbstractInstance<GenstBreeInn?>(village, world, i, k, random, loc) {
		override fun addVillageStructures(random: Random) {
			addStructure(LOTRWorldGenBreeInn(false), 0, 0, 2, true)
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