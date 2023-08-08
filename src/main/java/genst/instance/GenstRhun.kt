package genst.instance

import lotr.common.block.LOTRBlockBrickBase
import lotr.common.block.LOTRBlockSlabBase
import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityEasterling
import lotr.common.entity.npc.LOTREntityEasterlingArcher
import lotr.common.entity.npc.LOTREntityEasterlingWarrior
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.*
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs

open class GenstRhun(radius: Int) : LOTRVillageGen(LOTRBiome.forodwaith) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = radius
		fixedVillageChunkRadius = radius
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> {
		return Instance(this, world, i, k, random, loc)
	}

	enum class VillageType {
		VILLAGE, TOWN, FORT
	}

	open class Instance(village: GenstRhun, world: World?, i: Int, k: Int, random: Random?, loc: LocationInfo?) :
		AbstractInstance<GenstRhun?>(village, world, i, k, random, loc) {
		var villageType: VillageType? = null

		override fun addVillageStructures(random: Random) {
			when (villageType) {
				VillageType.VILLAGE -> setupVillage(random)
				VillageType.TOWN -> setupTown(random)
				VillageType.FORT -> setupFort(random)
				else -> {}
			}
		}

		private fun getOtherVillageStructure(random: Random): LOTRWorldGenStructureBase2 {
			return if (random.nextBoolean()) {
				LOTRWorldGenEasterlingStables(false)
			} else LOTRWorldGenEasterlingSmithy(false)
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			var outerOut: Int
			var innerOut: Int
			val i1 = abs(i.toDouble()).toInt()
			val k1 = abs(k.toDouble()).toInt()
			if (villageType == VillageType.VILLAGE) {
				val dSq = i * i + k * k
				val imn = 15 + random.nextInt(4)
				if (dSq < imn * imn || i1 <= 64 && k1 <= 3 + random.nextInt(2)) {
					return LOTRRoadType.PATH
				}
			}
			if (villageType == VillageType.TOWN) {
				innerOut = 18
				if (i1 <= innerOut && k1 <= innerOut && (i1 >= 12 || k1 >= 12)) {
					return LOTRRoadType.RHUN
				}
				if (i1 <= 3 && k1 >= innerOut && k1 <= 86 || k1 <= 3 && i1 >= innerOut && i1 <= 86) {
					return LOTRRoadType.RHUN
				}
				outerOut = 66
				if (i1 <= outerOut && k1 <= outerOut && (i1 >= 60 || k1 >= 60)) {
					return LOTRRoadType.RHUN
				}
			}
			if (villageType == VillageType.FORT) {
				innerOut = 24
				if (i1 <= innerOut && k1 <= innerOut && (i1 >= 20 || k1 >= 20)) {
					return LOTRRoadType.RHUN
				}
				if (k in 14..54 && i1 <= 2) {
					return LOTRRoadType.RHUN
				}
				outerOut = 52
				if (i1 <= outerOut && k1 <= outerOut && (i1 >= 48 || k1 >= 48)) {
					return LOTRRoadType.RHUN
				}
			}
			return null
		}

		private fun getRandomHouse(): LOTRWorldGenStructureBase2 {
			return LOTRWorldGenEasterlingHouse(false)
		}

		private fun getRandomVillageFarm(random: Random): LOTRWorldGenStructureBase2 {
			return if (random.nextBoolean()) {
				LOTRWorldGenEasterlingVillageFarm.Animals(false)
			} else LOTRWorldGenEasterlingVillageFarm.Crops(false)
		}

		override fun isFlat(): Boolean {
			return false
		}

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			return block is LOTRBlockBrickBase || block is LOTRBlockSlabBase
		}

		private fun setupFort(random: Random) {
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityEasterling::class.java)
					spawner.setCheckRanges(50, -12, 12, 16)
					spawner.setSpawnRanges(30, -6, 6, 40)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			for (i1 in intArrayOf(-48, 48)) {
				for (k1 in intArrayOf(-48, 48)) {
					addStructure(object : LOTRWorldGenNPCRespawner(false) {
						override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
							spawner.setSpawnClasses(
								LOTREntityEasterlingWarrior::class.java, LOTREntityEasterlingArcher::class.java
							)
							spawner.setCheckRanges(32, -12, 12, 16)
							spawner.setSpawnRanges(20, -6, 6, 40)
							spawner.setBlockEnemySpawnRange(40)
						}
					}, i1, k1, 0)
				}
			}
			addStructure(LOTRWorldGenEasterlingFortress(false), 0, 13, 2, true)
			val stableX = 26
			val stableZ = 0
			addStructure(LOTRWorldGenEasterlingStables(false), -stableX, stableZ, 1, true)
			addStructure(LOTRWorldGenEasterlingStables(false), stableX, stableZ, 3, true)
			val wellZ = 18
			addStructure(LOTRWorldGenEasterlingWell(false), -stableX, wellZ, 1, true)
			addStructure(LOTRWorldGenEasterlingWell(false), stableX, wellZ, 3, true)
			val farmZ = 27
			for (l in -3..3) {
				val farmX = l * 10
				if (random.nextInt(3) == 0) {
					addStructure(LOTRWorldGenHayBales(false), farmX, -farmZ - 5, 2)
					continue
				}
				addStructure(getRandomVillageFarm(random), farmX, -farmZ, 2)
			}
			val statueX = 6
			val statueZ = 36
			addStructure(LOTRWorldGenEasterlingStatue(false), -statueX, statueZ, 1, true)
			addStructure(LOTRWorldGenEasterlingStatue(false), statueX, statueZ, 3, true)
			addStructure(LOTRWorldGenEasterlingGatehouse(false).disableSigns(), 0, 62, 2, true)
			val towerX = 58
			addStructure(
				LOTRWorldGenEasterlingTower(false).disableDoor().setBackLadder().setLeftLadder(),
				-towerX,
				-towerX - 3,
				0,
				true
			)
			addStructure(
				LOTRWorldGenEasterlingTower(false).disableDoor().setBackLadder().setRightLadder(),
				towerX,
				-towerX - 3,
				0,
				true
			)
			addStructure(
				LOTRWorldGenEasterlingTower(false).disableDoor().setBackLadder().setRightLadder(),
				-towerX,
				towerX + 3,
				2,
				true
			)
			addStructure(
				LOTRWorldGenEasterlingTower(false).disableDoor().setBackLadder().setLeftLadder(),
				towerX,
				towerX + 3,
				2,
				true
			)
			addStructure(LOTRWorldGenEasterlingTownWall.Centre(false), 0, -towerX, 0)
			addStructure(LOTRWorldGenEasterlingTownWall.Centre(false), towerX, 0, 1)
			addStructure(LOTRWorldGenEasterlingTownWall.Centre(false), -towerX, 0, 3)
			for (l in 0..5) {
				val wallX = 11 + l * 8
				addStructure(LOTRWorldGenEasterlingTownWall.Left(false), wallX, -towerX, 0)
				addStructure(LOTRWorldGenEasterlingTownWall.Right(false), -wallX, -towerX, 0)
				addStructure(LOTRWorldGenEasterlingTownWall.Left(false), towerX, wallX, 1)
				addStructure(LOTRWorldGenEasterlingTownWall.Right(false), towerX, -wallX, 1)
				addStructure(LOTRWorldGenEasterlingTownWall.Left(false), -wallX, towerX, 2)
				addStructure(LOTRWorldGenEasterlingTownWall.Right(false), wallX, towerX, 2)
				addStructure(LOTRWorldGenEasterlingTownWall.Left(false), -towerX, -wallX, 3)
				addStructure(LOTRWorldGenEasterlingTownWall.Right(false), -towerX, wallX, 3)
			}
			var lampX = 17
			addStructure(LOTRWorldGenEasterlingLamp(false), -lampX, -lampX, 2, false)
			addStructure(LOTRWorldGenEasterlingLamp(false), lampX, -lampX, 2, false)
			addStructure(LOTRWorldGenEasterlingLamp(false), -lampX, lampX, 0, false)
			addStructure(LOTRWorldGenEasterlingLamp(false), lampX, lampX, 0, false)
			lampX = 45
			addStructure(LOTRWorldGenEasterlingLamp(false), -lampX, -lampX, 2, false)
			addStructure(LOTRWorldGenEasterlingLamp(false), lampX, -lampX, 2, false)
			addStructure(LOTRWorldGenEasterlingLamp(false), -lampX, lampX, 0, false)
			addStructure(LOTRWorldGenEasterlingLamp(false), lampX, lampX, 0, false)
		}

		private fun setupTown(random: Random) {
			var marketZ: Int
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityEasterling::class.java)
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
								LOTREntityEasterlingWarrior::class.java, LOTREntityEasterlingArcher::class.java
							)
							spawner.setCheckRanges(50, -12, 12, 16)
							spawner.setSpawnRanges(20, -6, 6, 64)
							spawner.setBlockEnemySpawnRange(60)
						}
					}, i1, k1, 0)
				}
			}
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenEasterlingGarden(false), 0, 10, 2, true)
			} else {
				addStructure(LOTRWorldGenEasterlingStatue(false), 0, 6, 2, true)
			}
			val mansionX = 12
			val mansionZ = 20
			addStructure(LOTRWorldGenEasterlingLargeTownHouse(false), -mansionX, -mansionZ, 2, true)
			addStructure(LOTRWorldGenEasterlingLargeTownHouse(false), mansionX, -mansionZ, 2, true)
			addStructure(LOTRWorldGenEasterlingLargeTownHouse(false), -mansionX, mansionZ, 0, true)
			addStructure(LOTRWorldGenEasterlingLargeTownHouse(false), mansionX, mansionZ, 0, true)
			addStructure(LOTRWorldGenEasterlingLargeTownHouse(false), -mansionZ, -mansionX, 1, true)
			addStructure(LOTRWorldGenEasterlingLargeTownHouse(false), -mansionZ, mansionX, 1, true)
			addStructure(LOTRWorldGenEasterlingLargeTownHouse(false), mansionZ, -mansionX, 3, true)
			addStructure(LOTRWorldGenEasterlingLargeTownHouse(false), mansionZ, mansionX, 3, true)
			for (l in 0..3) {
				val houseX = 10 + 14 * l
				val houseZ1 = 58
				val houseZ2 = 68
				if (l <= 2) {
					if (l >= 1) {
						if (l == 1) {
							addStructure(LOTRWorldGenEasterlingTavernTown(false), -houseX - 7, -houseZ1, 0, true)
						}
					} else {
						addStructure(LOTRWorldGenEasterlingTownHouse(false), -houseX, -houseZ1, 0, true)
					}
					addStructure(LOTRWorldGenEasterlingTownHouse(false), houseX, -houseZ1, 0, true)
					if (l >= 1) {
						addStructure(LOTRWorldGenEasterlingTownHouse(false), -houseX, houseZ1, 2, true)
						addStructure(LOTRWorldGenEasterlingTownHouse(false), houseX, houseZ1, 2, true)
					}
					addStructure(LOTRWorldGenEasterlingTownHouse(false), -houseZ1, -houseX, 3, true)
					addStructure(LOTRWorldGenEasterlingTownHouse(false), -houseZ1, houseX, 3, true)
					addStructure(LOTRWorldGenEasterlingTownHouse(false), houseZ1, -houseX, 1, true)
					addStructure(LOTRWorldGenEasterlingTownHouse(false), houseZ1, houseX, 1, true)
				}
				if (l == 1) {
					addStructure(LOTRWorldGenEasterlingVillageFarm.Tree(false), -houseX, -houseZ2, 2, true)
					addStructure(LOTRWorldGenEasterlingVillageFarm.Tree(false), houseX, -houseZ2, 2, true)
					addStructure(LOTRWorldGenEasterlingVillageFarm.Tree(false), -houseX, houseZ2, 0, true)
					addStructure(LOTRWorldGenEasterlingVillageFarm.Tree(false), houseX, houseZ2, 0, true)
					addStructure(LOTRWorldGenEasterlingVillageFarm.Tree(false), -houseZ2, -houseX, 1, true)
					addStructure(LOTRWorldGenEasterlingVillageFarm.Tree(false), -houseZ2, houseX, 1, true)
					addStructure(LOTRWorldGenEasterlingVillageFarm.Tree(false), houseZ2, -houseX, 3, true)
					addStructure(LOTRWorldGenEasterlingVillageFarm.Tree(false), houseZ2, houseX, 3, true)
					continue
				}
				addStructure(LOTRWorldGenEasterlingTownHouse(false), -houseX, -houseZ2, 2, true)
				addStructure(
					if (l == 3) LOTRWorldGenEasterlingSmithy(false) else LOTRWorldGenEasterlingTownHouse(false),
					houseX,
					-houseZ2,
					2,
					true
				)
				addStructure(LOTRWorldGenEasterlingTownHouse(false), -houseX, houseZ2, 0, true)
				addStructure(LOTRWorldGenEasterlingTownHouse(false), houseX, houseZ2, 0, true)
				addStructure(LOTRWorldGenEasterlingTownHouse(false), -houseZ2, -houseX, 1, true)
				addStructure(LOTRWorldGenEasterlingTownHouse(false), -houseZ2, houseX, 1, true)
				addStructure(LOTRWorldGenEasterlingTownHouse(false), houseZ2, -houseX, 3, true)
				addStructure(LOTRWorldGenEasterlingTownHouse(false), houseZ2, houseX, 3, true)
			}
			var marketX = 4
			for (l in 0..2) {
				marketZ = 56 - l * 7
				addStructure(
					LOTRWorldGenEasterlingMarketStall.getRandomStall(random, false), -marketX, marketZ, 1, true
				)
				addStructure(LOTRWorldGenEasterlingMarketStall.getRandomStall(random, false), marketX, marketZ, 3, true)
			}
			marketX = 14
			marketZ = 59
			addStructure(LOTRWorldGenEasterlingMarketStall.getRandomStall(random, false), -marketX, marketZ, 2, true)
			addStructure(LOTRWorldGenEasterlingMarketStall.getRandomStall(random, false), marketX, marketZ, 2, true)
			val gardenX = 58
			addStructure(LOTRWorldGenEasterlingVillageFarm.Tree(false), -gardenX + 5, -gardenX, 0, true)
			addStructure(LOTRWorldGenEasterlingVillageFarm.Tree(false), gardenX - 5, -gardenX, 0, true)
			addStructure(LOTRWorldGenEasterlingVillageFarm.Tree(false), -gardenX + 5, gardenX, 2, true)
			addStructure(LOTRWorldGenEasterlingVillageFarm.Tree(false), gardenX - 5, gardenX, 2, true)
			val wellX = 69
			val wellZ = 63
			addStructure(LOTRWorldGenEasterlingWell(false), -wellX, -wellZ, 1, true)
			addStructure(LOTRWorldGenEasterlingWell(false), -wellZ, -wellX, 2, true)
			addStructure(LOTRWorldGenEasterlingWell(false), wellX, -wellZ, 3, true)
			addStructure(LOTRWorldGenEasterlingWell(false), wellZ, -wellX, 2, true)
			addStructure(LOTRWorldGenEasterlingWell(false), -wellX, wellZ, 1, true)
			addStructure(LOTRWorldGenEasterlingWell(false), -wellZ, wellX, 0, true)
			addStructure(LOTRWorldGenEasterlingWell(false), wellX, wellZ, 3, true)
			addStructure(LOTRWorldGenEasterlingWell(false), wellZ, wellX, 0, true)
			addStructure(LOTRWorldGenEasterlingGatehouse(false), 0, 94, 2, true)
			val towerX = 90
			addStructure(
				LOTRWorldGenEasterlingTower(false).disableDoor().setBackLadder().setLeftLadder(),
				-towerX,
				-towerX - 3,
				0,
				true
			)
			addStructure(
				LOTRWorldGenEasterlingTower(false).disableDoor().setBackLadder().setRightLadder(),
				towerX,
				-towerX - 3,
				0,
				true
			)
			addStructure(
				LOTRWorldGenEasterlingTower(false).disableDoor().setBackLadder().setRightLadder(),
				-towerX,
				towerX + 3,
				2,
				true
			)
			addStructure(
				LOTRWorldGenEasterlingTower(false).disableDoor().setBackLadder().setLeftLadder(),
				towerX,
				towerX + 3,
				2,
				true
			)
			addStructure(LOTRWorldGenEasterlingTownWall.Centre(false), 0, -towerX, 0)
			addStructure(LOTRWorldGenEasterlingTownWall.Centre(false), towerX, 0, 1)
			addStructure(LOTRWorldGenEasterlingTownWall.Centre(false), -towerX, 0, 3)
			for (l in 0..9) {
				val wallX = 11 + l * 8
				addStructure(LOTRWorldGenEasterlingTownWall.Left(false), wallX, -towerX, 0)
				addStructure(LOTRWorldGenEasterlingTownWall.Right(false), -wallX, -towerX, 0)
				addStructure(LOTRWorldGenEasterlingTownWall.Left(false), towerX, wallX, 1)
				addStructure(LOTRWorldGenEasterlingTownWall.Right(false), towerX, -wallX, 1)
				addStructure(LOTRWorldGenEasterlingTownWall.Left(false), -wallX, towerX, 2)
				addStructure(LOTRWorldGenEasterlingTownWall.Right(false), wallX, towerX, 2)
				addStructure(LOTRWorldGenEasterlingTownWall.Left(false), -towerX, -wallX, 3)
				addStructure(LOTRWorldGenEasterlingTownWall.Right(false), -towerX, wallX, 3)
			}
		}

		private fun setupVillage(random: Random) {
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityEasterling::class.java)
					spawner.setCheckRanges(40, -12, 12, 40)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClasses(
						LOTREntityEasterlingWarrior::class.java, LOTREntityEasterlingArcher::class.java
					)
					spawner.setCheckRanges(40, -12, 12, 16)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			val pathEnd = 68
			val pathSide = 7
			val centreSide = 19
			addStructure(LOTRWorldGenEasterlingWell(false), 0, -2, 0, true)
			addStructure(LOTRWorldGenEasterlingLargeTownHouse(false), 0, -centreSide, 2, true)
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenEasterlingTavern(false), -pathEnd, 0, 1, true)
				addStructure(getOtherVillageStructure(random), pathEnd, 0, 3, true)
			} else {
				addStructure(getOtherVillageStructure(random), -pathEnd, 0, 1, true)
				addStructure(LOTRWorldGenEasterlingTavern(false), pathEnd, 0, 3, true)
			}
			val rowHouses = 3
			for (l in -rowHouses..rowHouses) {
				val i1 = l * 18
				var k1 = pathSide
				if (abs(i1.toDouble()) <= 15) {
					k1 += 15 - pathSide
				}
				if (abs(l.toDouble()) >= 1) {
					addStructure(getRandomHouse(), i1, -k1, 2)
					addStructure(getRandomHouse(), i1, k1, 0)
				}
				val k2 = k1 + 20
				if (l != 0) {
					if (random.nextInt(3) == 0) {
						addStructure(getRandomVillageFarm(random), i1, -k2, 2)
					} else {
						addStructure(LOTRWorldGenHayBales(false), i1, -k2, 2)
					}
					if (random.nextInt(3) == 0) {
						addStructure(getRandomVillageFarm(random), i1, k2, 0)
					} else {
						addStructure(LOTRWorldGenHayBales(false), i1, k2, 0)
					}
				}
			}
		}

		override fun setupVillageProperties(random: Random) {
		}
	}
}