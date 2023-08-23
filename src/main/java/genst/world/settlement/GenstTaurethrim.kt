package genst.world.settlement

import lotr.common.LOTRMod
import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityTauredain
import lotr.common.entity.npc.LOTREntityTauredainBlowgunner
import lotr.common.entity.npc.LOTREntityTauredainWarrior
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.*
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs

open class GenstTaurethrim : LOTRVillageGen(LOTRBiome.forodwaith) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = 6
		fixedVillageChunkRadius = 4
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> {
		return Instance(this, world, i, k, random, loc)
	}

	open class Instance(village: GenstTaurethrim, world: World, i: Int, k: Int, random: Random, loc: LocationInfo) :
		AbstractInstance<GenstTaurethrim>(village, world, i, k, random, loc) {

		override fun addVillageStructures(random: Random) {
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityTauredain::class.java)
					spawner.setCheckRanges(80, -12, 12, 100)
					spawner.setSpawnRanges(60, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			val spawnerX = 60
			for (i1 in intArrayOf(-spawnerX, spawnerX)) {
				for (k1 in intArrayOf(-spawnerX, spawnerX)) {
					addStructure(object : LOTRWorldGenNPCRespawner(false) {
						override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
							spawner.setSpawnClasses(
								LOTREntityTauredainWarrior::class.java, LOTREntityTauredainBlowgunner::class.java
							)
							spawner.setCheckRanges(50, -12, 12, 16)
							spawner.setSpawnRanges(20, -6, 6, 64)
							spawner.setBlockEnemySpawnRange(60)
						}
					}, i1, k1, 0)
				}
			}
			addStructure(LOTRWorldGenTauredainChieftainPyramid(false), 0, 11, 2, true)

			val square = 32
			addStructure(LOTRWorldGenTauredainHouseStilts(false), -square, -square + 5, 2, true)
			addStructure(LOTRWorldGenTauredainHouseStilts(false), square, -square + 5, 2, true)
			addStructure(LOTRWorldGenTauredainHouseStilts(false), -square, square - 5, 0, true)
			addStructure(LOTRWorldGenTauredainHouseStilts(false), square, square - 5, 0, true)

			val mansionX = 12
			val mansionZ = 20
			addStructure(LOTRWorldGenTauredainHouseLarge(false), -mansionX + 1, -mansionZ, 2, true) //лево верх верх
			addStructure(LOTRWorldGenTauredainHouseLarge(false), mansionX, -mansionZ, 2, true) //право верх верх
			addStructure(LOTRWorldGenTauredainHouseLarge(false), -mansionX, mansionZ, 0, true) // лево низ низ
			addStructure(LOTRWorldGenTauredainHouseLarge(false), mansionX - 1, mansionZ, 0, true) //право низ низ

			addStructure(LOTRWorldGenTauredainHouseLarge(false), -mansionZ, -mansionX, 1, true) //лево лево верх
			addStructure(LOTRWorldGenTauredainHouseLarge(false), -mansionZ, mansionX - 1, 1, true) //лево лево низ
			addStructure(LOTRWorldGenTauredainHouseLarge(false), mansionZ, -mansionX + 1, 3, true) //право право верх
			addStructure(LOTRWorldGenTauredainHouseLarge(false), mansionZ, mansionX, 3, true) //право право низ


			addStructure(LOTRWorldGenTauredainHouseLarge(false), -mansionX + 1, -mansionZ - 14, 2, true)
			addStructure(LOTRWorldGenTauredainHouseLarge(false), mansionX, -mansionZ - 14, 2, true)
			addStructure(LOTRWorldGenTauredainHouseLarge(false), -mansionX, mansionZ + 14, 0, true)
			addStructure(LOTRWorldGenTauredainHouseLarge(false), mansionX - 1, mansionZ + 14, 0, true)

			addStructure(LOTRWorldGenTauredainHouseLarge(false), -mansionZ - 14, -mansionX, 1, true)
			addStructure(LOTRWorldGenTauredainHouseLarge(false), -mansionZ - 14, mansionX - 1, 1, true)
			addStructure(LOTRWorldGenTauredainHouseLarge(false), mansionZ + 14, -mansionX + 1, 3, true)
			addStructure(LOTRWorldGenTauredainHouseLarge(false), mansionZ + 14, mansionX, 3, true)

			for (l in 0..3) {
				val houseX = 10 + 14 * l
				val houseZ1 = 58
				val houseZ2 = 68

				//внутренний контур
				if (l <= 2) {
					addStructure(LOTRWorldGenTauredainHouseLarge(false), -houseX - 2, -houseZ1, 0, true)
					addStructure(LOTRWorldGenTauredainHouseLarge(false), houseX + 1, -houseZ1, 0, true)
					addStructure(LOTRWorldGenTauredainHouseLarge(false), -houseX - 1, houseZ1, 2, true)
					addStructure(LOTRWorldGenTauredainHouseLarge(false), houseX + 2, houseZ1, 2, true)
					addStructure(LOTRWorldGenTauredainHouseLarge(false), -houseZ1, -houseX - 1, 3, true)
					addStructure(LOTRWorldGenTauredainHouseLarge(false), -houseZ1, houseX + 2, 3, true)
					addStructure(LOTRWorldGenTauredainHouseLarge(false), houseZ1, -houseX - 2, 1, true)
					addStructure(LOTRWorldGenTauredainHouseLarge(false), houseZ1, houseX + 1, 1, true)
				}
				if (l == 1) {
					addStructure(LOTRWorldGenTauredainHouseSimple(false), -houseX - 1, -houseZ2 - 2, 2, true)
					addStructure(LOTRWorldGenTauredainHouseSimple(false), houseX + 2, -houseZ2 - 2, 2, true)
					addStructure(LOTRWorldGenTauredainHouseSimple(false), -houseX - 2, houseZ2 + 2, 0, true)
					addStructure(LOTRWorldGenTauredainHouseSimple(false), houseX + 1, houseZ2 + 2, 0, true)
					addStructure(LOTRWorldGenTauredainHouseSimple(false), -houseZ2 - 2, -houseX - 2, 1, true)
					addStructure(LOTRWorldGenTauredainHouseSimple(false), -houseZ2 - 2, houseX + 1, 1, true)
					addStructure(LOTRWorldGenTauredainHouseSimple(false), houseZ2 + 2, -houseX - 1, 3, true)
					addStructure(LOTRWorldGenTauredainHouseSimple(false), houseZ2 + 2, houseX + 2, 3, true)
				} else {
					val str = if (l == 3) LOTRWorldGenTauredainSmithy(false) else LOTRWorldGenTauredainHouseLarge(false)
					addStructure(str, -houseX - 1, -houseZ2, 2, true)
					addStructure(str, houseX + 2, -houseZ2, 2, true)
					addStructure(str, -houseX - 2, houseZ2, 0, true)
					addStructure(str, houseX + 1, houseZ2, 0, true)
					addStructure(str, -houseZ2, -houseX - 2, 1, true)
					addStructure(str, -houseZ2, houseX + 1, 1, true)
					addStructure(str, houseZ2, -houseX - 1, 3, true)
					addStructure(str, houseZ2, houseX + 2, 3, true)
				}
			}
			val farmX = 58
			addStructure(LOTRWorldGenTauredainVillageFarm(false), -farmX + 5, -farmX, 0, true)
			addStructure(LOTRWorldGenTauredainVillageFarm(false), farmX - 5, -farmX, 0, true)
			addStructure(LOTRWorldGenTauredainVillageFarm(false), -farmX + 5, farmX, 2, true)
			addStructure(LOTRWorldGenTauredainVillageFarm(false), farmX - 5, farmX, 2, true)
			val towerX = 69
			val towerZ = 63
			addStructure(LOTRWorldGenTauredainWatchtower(false), -towerX, -towerZ, 1, true)
			addStructure(LOTRWorldGenTauredainWatchtower(false), -towerZ, -towerX, 2, true)
			addStructure(LOTRWorldGenTauredainWatchtower(false), towerX, -towerZ, 3, true)
			addStructure(LOTRWorldGenTauredainWatchtower(false), towerZ, -towerX, 2, true)
			addStructure(LOTRWorldGenTauredainWatchtower(false), -towerX, towerZ, 1, true)
			addStructure(LOTRWorldGenTauredainWatchtower(false), -towerZ, towerX, 0, true)
			addStructure(LOTRWorldGenTauredainWatchtower(false), towerX, towerZ, 3, true)
			addStructure(LOTRWorldGenTauredainWatchtower(false), towerZ, towerX, 0, true)
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			val i1 = abs(i)
			val k1 = abs(k)
			val innerOut = 18
			if (i1 <= innerOut && k1 <= innerOut && (i1 >= 12 || k1 >= 12)) {
				return getRoadType()
			}
			if (i1 <= 3 && k1 >= innerOut && k1 <= 86 || k1 <= 3 && i1 >= innerOut && i1 <= 86) {
				return getRoadType()
			}
			val outerOut = 66
			if (i1 <= outerOut && k1 <= outerOut && (i1 >= 60 || k1 >= 60)) {
				return getRoadType()
			}
			return null
		}

		open fun getRoadType(): LOTRRoadType = LOTRRoadType.TAUREDAIN

		override fun isFlat(): Boolean = false

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			val meta = world.getBlockMetadata(i, j, k)
			val path = arrayOf(
				Pair(LOTRMod.slabSingle8, 1),
				Pair(LOTRMod.slabSingle8, 2),
				Pair(LOTRMod.slabSingle8, 0),
				Pair(LOTRMod.brick4, 1),
				Pair(LOTRMod.brick4, 2),
				Pair(LOTRMod.brick4, 0)
			)
			return path.any { (pairBlock, pairMeta) ->
				block == pairBlock && meta == pairMeta
			}
		}

		override fun setupVillageProperties(random: Random) {}
	}
}
