package genst.based

import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityRohanMan
import lotr.common.entity.npc.LOTREntityRohirrimArcher
import lotr.common.entity.npc.LOTREntityRohirrimWarrior
import lotr.common.entity.npc.LOTRNames
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.*
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.util.MathHelper
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs

class LOTRVillageGenRohan(biome: LOTRBiome?, f: Float) : LOTRVillageGen(biome) {
	init {
		gridScale = 14
		gridRandomDisplace = 1
		spawnChance = f
		villageChunkRadius = 5
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

	enum class VillageType {
		VILLAGE,
		FORT
	}

	class Instance(village: LOTRVillageGenRohan?, world: World?, i: Int, k: Int, random: Random?, loc: LocationInfo?) :
		AbstractInstance<LOTRVillageGenRohan?>(village, world, i, k, random, loc) {
		private var villageType: VillageType? = null
		private lateinit var villageName: Array<String>
		private var palisade = false
		override fun addVillageStructures(random: Random) {
			if (villageType == VillageType.VILLAGE) {
				setupVillage(random)
			} else if (villageType == VillageType.FORT) {
				setupFort(random)
			}
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			val i1 = abs(i.toDouble()).toInt()
			val k1 = abs(k.toDouble()).toInt()
			if (villageType == VillageType.VILLAGE) {
				val dSq = i * i + k * k
				val imn = 20 + random.nextInt(4)
				if (dSq < imn * imn) {
					return LOTRRoadType.PATH
				}
				val omn = 50 - random.nextInt(4)
				val omx = 56 + random.nextInt(4)
				if (dSq > omn * omn && dSq < omx * omx || dSq < 2500 && abs((i1 - k1).toDouble()) <= 2 + random.nextInt(
						4
					)
				) {
					return LOTRRoadType.PATH
				}
				if (palisade && k < -56 && k > -81 && i1 <= 2 + random.nextInt(4)) {
					return LOTRRoadType.PATH
				}
			}
			if (villageType == VillageType.FORT) {
				if (k <= -14 && k >= -49 && i1 <= 2) {
					return LOTRRoadType.ROHAN
				}
				if (k <= -14 && k >= -17 && i1 <= 37) {
					return LOTRRoadType.PATH
				}
				if (k >= -14 && k <= 20 && i1 >= 19 && i1 <= 22) {
					return LOTRRoadType.PATH
				}
				if (k in 20..23 && i1 <= 37) {
					return LOTRRoadType.PATH
				}
			}
			return null
		}

		private fun getRandomFarm(random: Random): LOTRWorldGenStructureBase2 {
			return if (random.nextInt(3) == 0) {
				LOTRWorldGenRohanVillagePasture(false)
			} else LOTRWorldGenRohanVillageFarm(false)
		}

		private fun getRandomHouse(random: Random): LOTRWorldGenStructureBase2 {
			if (random.nextInt(4) == 0) {
				val i = random.nextInt(3)
				when (i) {
					0 -> return LOTRWorldGenRohanSmithy(false)
					1 -> return LOTRWorldGenRohanStables(false)
					2 -> return LOTRWorldGenRohanBarn(false)
					else -> {}
				}
			}
			return LOTRWorldGenRohanHouse(false)
		}

		override fun isFlat(): Boolean {
			return false
		}

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			return false
		}

		private fun setupFort(random: Random) {
			var farmX: Int
			var wallZ: Int
			var wallX: Int
			addStructure(LOTRWorldGenRohanFortress(false), 0, -13, 0, true)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClasses(LOTREntityRohirrimWarrior::class.java, LOTREntityRohirrimArcher::class.java)
					spawner.setCheckRanges(40, -12, 12, 30)
					spawner.setSpawnRanges(32, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(LOTRWorldGenRohanGatehouse(false), 0, -53, 0, true)
			val towerX = 46
			for (i1 in intArrayOf(-towerX, towerX)) {
				addStructure(LOTRWorldGenRohanWatchtower(false), i1, -towerX, 0, true)
				addStructure(LOTRWorldGenRohanWatchtower(false), i1, towerX, 2, true)
			}
			for (i1 in intArrayOf(-35, 35)) {
				addStructure(LOTRWorldGenRohanStables(false), i1, -14, 0, true)
			}
			var farmZ = -20
			var l2: Int = 0
			while (l2 <= 1) {
				farmX = 30 - l2 * 12
				addStructure(LOTRWorldGenRohanVillageFarm(false), -farmX, farmZ, 2)
				addStructure(LOTRWorldGenRohanVillageFarm(false), farmX, farmZ, 2)
				++l2
			}
			farmZ = 26
			l2 = -2
			while (l2 <= 2) {
				farmX = l2 * 12
				addStructure(LOTRWorldGenRohanVillageFarm(false), -farmX, farmZ, 0)
				addStructure(LOTRWorldGenRohanVillageFarm(false), farmX, farmZ, 0)
				++l2
			}
			for (i1 in intArrayOf(-51, 51)) {
				for (k1 in intArrayOf(-51, 51)) {
					addStructure(LOTRWorldGenRohanFortCorner(false), i1, k1, 0, true)
				}
			}
			var l: Int = 0
			while (l <= 4) {
				wallX = 13 + l * 8
				wallZ = -51
				addStructure(LOTRWorldGenRohanFortWall(false, -3, 4), -wallX, wallZ, 0, true)
				addStructure(LOTRWorldGenRohanFortWall(false, -4, 3), wallX, wallZ, 0, true)
				++l
			}
			l = -5
			while (l <= 5) {
				wallX = l * 9
				wallZ = 51
				addStructure(LOTRWorldGenRohanFortWall(false), wallX, wallZ, 2, true)
				addStructure(LOTRWorldGenRohanFortWall(false), -wallZ, wallX, 3, true)
				addStructure(LOTRWorldGenRohanFortWall(false), wallZ, wallX, 1, true)
				++l
			}
		}

		private fun setupVillage(random: Random) {
			addStructure(LOTRWorldGenMeadHall(false), 0, 2, 0, true)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityRohanMan::class.java)
					spawner.setCheckRanges(40, -12, 12, 40)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityRohirrimWarrior::class.java)
					spawner.setCheckRanges(40, -12, 12, 16)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			val houses = 20
			val frac = 1.0f / houses
			var turn = 0.0f
			while (turn < 1.0f) {
				var k: Int
				var l: Int
				var i: Int
				val turnR = Math.toRadians((frac.let { turn += it; turn } * 360.0f).toDouble()).toFloat()
				val sin = MathHelper.sin(turnR)
				val cos = MathHelper.cos(turnR)
				var r = 0
				val turn8 = turn * 8.0f
				if (turn8 >= 1.0f && turn8 < 3.0f) {
					r = 0
				} else if (turn8 >= 3.0f && turn8 < 5.0f) {
					r = 1
				} else if (turn8 >= 5.0f && turn8 < 7.0f) {
					r = 2
				} else if (turn8 >= 7.0f || turn8 < 1.0f) {
					r = 3
				}
				if (palisade && sin < 0.0f && abs(cos.toDouble()) <= 0.25f) {
					continue
				}
				if (random.nextBoolean()) {
					l = 57
					i = Math.round(l * cos)
					k = Math.round(l * sin)
					addStructure(getRandomHouse(random), i, k, r)
					continue
				}
				if (random.nextInt(3) == 0) {
					continue
				}
				l = 61
				i = Math.round(l * cos)
				k = Math.round(l * sin)
				addStructure(LOTRWorldGenHayBales(false), i, k, r)
			}
			val farmX = 25
			for (k in -1..1) {
				val farmZ = k * 14
				addStructure(getRandomFarm(random), -farmX, farmZ, 1)
				addStructure(getRandomFarm(random), farmX, farmZ, 3)
			}
			var gardenX = 14
			for (k in 0..2) {
				val gardenZ = 24 + k * 8
				addStructure(LOTRWorldGenRohanVillageGarden(false), -gardenX, gardenZ, 3)
				addStructure(LOTRWorldGenRohanVillageGarden(false), gardenX, gardenZ, 1)
			}
			val gardenZ = 41
			for (i in -1..1) {
				gardenX = i * 6
				if (i == 0) {
					continue
				}
				addStructure(LOTRWorldGenRohanVillageGarden(false), gardenX, gardenZ, 0)
			}
			addStructure(LOTRWorldGenRohanWell(false), 0, -23, 2, true)
			addStructure(LOTRWorldGenRohanVillageSign(false).setSignText(villageName), 0, -11, 0, true)
			if (random.nextBoolean()) {
				val marketX = 8
				for (k in 0..1) {
					val marketZ = 25 + k * 10
					if (random.nextBoolean()) {
						addStructure(LOTRWorldGenRohanMarketStall.getRandomStall(random, false), -marketX, -marketZ, 1)
					}
					if (!random.nextBoolean()) {
						continue
					}
					addStructure(LOTRWorldGenRohanMarketStall.getRandomStall(random, false), marketX, -marketZ, 3)
				}
			}
			if (palisade) {
				val rPalisade = 81
				val rSq = rPalisade * rPalisade
				val rMax = rPalisade + 1
				val rSqMax = rMax * rMax
				for (i in -rPalisade..rPalisade) {
					for (k in -rPalisade..rPalisade) {
						if (abs(i) <= 9 && k < 0) {
							continue
						}
						val dSq: Int = i * i + k * k
						if (dSq < rSq || dSq >= rSqMax) {
							continue
						}
						addStructure(LOTRWorldGenRohanVillagePalisade(false), i, k, 0)
					}
				}
				addStructure(LOTRWorldGenRohanGatehouse(false), 0, -rPalisade - 2, 0)
			}
		}

		override fun setupVillageProperties(random: Random) {
			villageName = LOTRNames.getRohanVillageName(random)
			villageType = if (random.nextInt(3) == 0) VillageType.FORT else VillageType.VILLAGE
			palisade = random.nextBoolean()
		}
	}
}
