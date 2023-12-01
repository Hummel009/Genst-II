package genst.base

import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.*
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*

@Suppress("unused")
class SettlementTaurethrim(biome: LOTRBiome?, f: Float) : LOTRVillageGen(biome) {
	init {
		gridScale = 10
		gridRandomDisplace = 1
		spawnChance = f
		villageChunkRadius = 3
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> = Instance(this, world, i, k, random, loc)

	class Instance(
		village: SettlementTaurethrim?, world: World?, i: Int, k: Int, random: Random?, loc: LocationInfo?
	) : AbstractInstance<SettlementTaurethrim?>(village, world, i, k, random, loc) {

		override fun addVillageStructures(random: Random) {
			val smithyPos = random.nextInt(4)
			addStructure(LOTRWorldGenTauredainChieftainPyramid(false), 0, -11, 0, true)
			addStructure(LOTRWorldGenTauredainVillageTree(false), 0, -16, 2)
			addStructure(LOTRWorldGenTauredainVillageFarm(false), -16, -19, 2)
			addStructure(LOTRWorldGenTauredainVillageFarm(false), 16, -19, 2)
			addStructure(LOTRWorldGenTauredainHouseStilts(false), 0, 15, 0)
			addStructure(LOTRWorldGenTauredainVillageFarm(false), -16, 19, 0)
			addStructure(LOTRWorldGenTauredainVillageFarm(false), 16, 19, 0)
			addStructure(LOTRWorldGenTauredainHouseLarge(false), -20, 0, 1)
			addStructure(LOTRWorldGenTauredainHouseLarge(false), 20, 1, 3)
			addStructure(LOTRWorldGenTauredainHouseSimple(false), -15, -36, 0)
			addStructure(LOTRWorldGenTauredainHouseSimple(false), 15, -36, 0)
			if (smithyPos == 0) {
				addStructure(LOTRWorldGenTauredainSmithy(false), -22, -13, 1)
			} else {
				addStructure(LOTRWorldGenTauredainHouseSimple(false), -32, -22, 3)
				addStructure(LOTRWorldGenTauredainHouseSimple(false), -32, -12, 3)
			}
			if (smithyPos == 1) {
				addStructure(LOTRWorldGenTauredainSmithy(false), -22, 14, 1)
			} else {
				addStructure(LOTRWorldGenTauredainHouseSimple(false), -32, 13, 3)
				addStructure(LOTRWorldGenTauredainHouseSimple(false), -32, 23, 3)
			}
			if (smithyPos == 2) {
				addStructure(LOTRWorldGenTauredainSmithy(false), 22, -13, 3)
			} else {
				addStructure(LOTRWorldGenTauredainHouseSimple(false), 32, -22, 1)
				addStructure(LOTRWorldGenTauredainHouseSimple(false), 32, -12, 1)
			}
			if (smithyPos == 3) {
				addStructure(LOTRWorldGenTauredainSmithy(false), 22, 14, 3)
			} else {
				addStructure(LOTRWorldGenTauredainHouseSimple(false), 32, 13, 1)
				addStructure(LOTRWorldGenTauredainHouseSimple(false), 32, 23, 1)
			}
			addStructure(LOTRWorldGenTauredainHouseSimple(false), -15, 36, 2)
			addStructure(LOTRWorldGenTauredainHouseSimple(false), 0, 37, 2)
			addStructure(LOTRWorldGenTauredainHouseSimple(false), 15, 36, 2)
			addStructure(LOTRWorldGenTauredainWatchtower(false), -26, -36, 0)
			addStructure(LOTRWorldGenTauredainWatchtower(false), 26, -36, 0)
			addStructure(LOTRWorldGenTauredainWatchtower(false), -26, 37, 2)
			addStructure(LOTRWorldGenTauredainWatchtower(false), 26, 37, 2)
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? = null

		override fun isFlat(): Boolean = false

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean = false

		override fun setupVillageProperties(random: Random) {}
	}
}
