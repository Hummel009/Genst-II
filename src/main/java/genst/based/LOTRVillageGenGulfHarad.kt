package genst.based

import lotr.common.LOTRMod
import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityGulfHaradArcher
import lotr.common.entity.npc.LOTREntityGulfHaradWarrior
import lotr.common.entity.npc.LOTREntityGulfHaradrim
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

class LOTRVillageGenGulfHarad(biome: LOTRBiome?, f: Float) : LOTRVillageGen(biome) {
	init {
		gridScale = 14
		gridRandomDisplace = 1
		spawnChance = f
		villageChunkRadius = 6
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> {
		return Instance(this, world, i, k, random, loc)
	}

	enum class VillageType {
		VILLAGE, TOWN, FORT
	}

	class Instance(
		village: LOTRVillageGenGulfHarad?, world: World?, i: Int, k: Int, random: Random?, loc: LocationInfo?
	) : AbstractInstance<LOTRVillageGenGulfHarad?>(village, world, i, k, random, loc) {
		private var villageType: VillageType? = null
		private lateinit var villageName: Array<String>
		private var rTownTower: Int = 90
		private var numOuterHouses = 0
		override fun addVillageStructures(random: Random) {
			if (villageType == VillageType.VILLAGE) {
				setupVillage(random)
			} else if (villageType == VillageType.TOWN) {
				setupTown(random)
			} else if (villageType == VillageType.FORT) {
				setupFort(random)
			}
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			var dSq: Int
			val i1 = abs(i.toDouble()).toInt()
			val k1 = abs(k.toDouble()).toInt()
			if (villageType == VillageType.VILLAGE) {
				dSq = i * i + k * k
				val imn = 16 - random.nextInt(3)
				val imx = 21 + random.nextInt(3)
				if (dSq > imn * imn && dSq < imx * imx) {
					return LOTRRoadType.PATH
				}
			}
			if (villageType == VillageType.TOWN) {
				dSq = i * i + k * k
				if (dSq < 576) {
					return LOTRRoadType.GULF_HARAD
				}
				if (k1 <= 3 && i1 <= 74 || i1 <= 3 && k <= 74) {
					return LOTRRoadType.GULF_HARAD
				}
			}
			return null
		}

		private fun getRandomFarm(random: Random): LOTRWorldGenStructureBase2 {
			return if (random.nextBoolean()) {
				LOTRWorldGenGulfFarm(false)
			} else LOTRWorldGenGulfPasture(false)
		}

		private fun getRandomHouse(random: Random): LOTRWorldGenStructureBase2 {
			return if (random.nextInt(5) == 0) {
				LOTRWorldGenGulfSmithy(false)
			} else LOTRWorldGenGulfHouse(false)
		}

		override fun isFlat(): Boolean {
			return false
		}

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			if (villageType == VillageType.TOWN) {
				val block = world.getBlock(i, j, k)
				val meta = world.getBlockMetadata(i, j, k)
				return block === LOTRMod.brick3 && (meta == 13 || meta == 14)
			}
			return false
		}

		private fun setupFort(random: Random) {
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityGulfHaradrim::class.java)
					spawner.setCheckRanges(40, -12, 12, 16)
					spawner.setSpawnRanges(24, -6, 6, 32)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(LOTRWorldGenGulfWarCamp(false), 0, -15, 0, true)
			val towerX = 36
			addStructure(LOTRWorldGenGulfTower(false), -towerX, -towerX + 4, 2, true)
			addStructure(LOTRWorldGenGulfTower(false), towerX, -towerX + 4, 2, true)
			addStructure(LOTRWorldGenGulfTower(false), -towerX, towerX - 4, 0, true)
			addStructure(LOTRWorldGenGulfTower(false), towerX, towerX - 4, 0, true)
			for (l in -1..1) {
				val i = l * 16
				val k = 28
				addStructure(getRandomFarm(random), i, k, 0)
				addStructure(getRandomFarm(random), -k, i, 1)
				addStructure(getRandomFarm(random), k, i, 3)
			}
		}

		private fun setupTown(random: Random) {
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityGulfHaradrim::class.java)
					spawner.setCheckRanges(80, -12, 12, 100)
					spawner.setSpawnRanges(40, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			for (i1 in intArrayOf(-40, 40)) {
				for (k1 in intArrayOf(-40, 40)) {
					addStructure(object : LOTRWorldGenNPCRespawner(false) {
						override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
							spawner.setSpawnClasses(
								LOTREntityGulfHaradWarrior::class.java, LOTREntityGulfHaradArcher::class.java
							)
							spawner.setCheckRanges(64, -12, 12, 20)
							spawner.setSpawnRanges(20, -6, 6, 64)
							spawner.setBlockEnemySpawnRange(64)
						}
					}, i1, k1, 0)
				}
			}
			addStructure(LOTRWorldGenGulfPyramid(false), 0, -11, 0, true)
			val lightR = 15
			addStructure(LOTRWorldGenGulfVillageLight(false), -lightR, -lightR, 0, true)
			addStructure(LOTRWorldGenGulfVillageLight(false), lightR, -lightR, 0, true)
			addStructure(LOTRWorldGenGulfVillageLight(false), -lightR, lightR, 0, true)
			addStructure(LOTRWorldGenGulfVillageLight(false), lightR, lightR, 0, true)
			addStructure(LOTRWorldGenGulfBazaar(false), -74, 0, 1, true)
			addStructure(LOTRWorldGenGulfAltar(false), 74, 0, 3, true)
			addStructure(LOTRWorldGenGulfTotem(false), 0, 79, 0, true)
			for (l in 0..2) {
				val i = 5
				val k = 32 + l * 20
				addStructure(LOTRWorldGenGulfHouse(false), -i, -k, 1, true)
				addStructure(LOTRWorldGenGulfHouse(false), i, -k, 3, true)
				addStructure(LOTRWorldGenGulfHouse(false), -i, k, 1, true)
				addStructure(LOTRWorldGenGulfHouse(false), i, k, 3, true)
				addStructure(LOTRWorldGenGulfHouse(false), k, -i, 2, true)
				addStructure(LOTRWorldGenGulfHouse(false), k, i, 0, true)
				if (l != 0) {
					continue
				}
				addStructure(LOTRWorldGenGulfSmithy(false), -k - 6, -i, 2, true)
				addStructure(LOTRWorldGenGulfTavern(false), -k - 6, i, 0, true)
			}
			val xzTownTower = (rTownTower / 1.4142135623730951).toInt()
			addStructure(LOTRWorldGenGulfTower(false), -xzTownTower, -xzTownTower + 4, 2, true)
			addStructure(LOTRWorldGenGulfTower(false), xzTownTower, -xzTownTower + 4, 2, true)
			addStructure(LOTRWorldGenGulfTower(false), -xzTownTower, xzTownTower - 4, 0, true)
			addStructure(LOTRWorldGenGulfTower(false), xzTownTower, xzTownTower - 4, 0, true)
			var turn = 0
			val numTurns = 24
			while (turn <= numTurns) {
				turn++
				if (turn % 3 == 0) {
					continue
				}
				val turnF = turn.toFloat() / numTurns
				val turnR = Math.toRadians((turnF * 360.0f).toDouble()).toFloat()
				val sin = MathHelper.sin(turnR)
				val cos = MathHelper.cos(turnR)
				var r = 0
				val turn8 = turnF * 8.0f
				if (turn8 >= 1.0f && turn8 < 3.0f) {
					r = 0
				} else if (turn8 >= 3.0f && turn8 < 5.0f) {
					r = 1
				} else if (turn8 >= 5.0f && turn8 < 7.0f) {
					r = 2
				} else if (turn8 >= 7.0f || turn8 < 1.0f) {
					r = 3
				}
				val l = rTownTower - 6
				val i = Math.round(l * cos)
				val k = Math.round(l * sin)
				if (random.nextInt(3) == 0) {
					addStructure(LOTRWorldGenHayBales(false), i, k, r)
					continue
				}
				addStructure(getRandomFarm(random), i, k, r)
			}
			addStructure(LOTRWorldGenGulfVillageSign(false).setSignText(villageName), -5, -96, 0, true)
			addStructure(LOTRWorldGenGulfVillageSign(false).setSignText(villageName), 5, -96, 0, true)
			val townWall = true
			val rSq = 9604
			val rMax = 99
			val rSqMax = rMax * rMax
			for (i in -98..98) {
				for (k in -98..98) {
					val i1 = abs(i.toDouble()).toInt()
					if (i1 <= 6 && k < 0) {
						continue
					}

					val dSq: Int = i * i + k * k
					if (dSq < rSq || dSq >= rSqMax) {
						continue
					}
					val wall = LOTRWorldGenGulfTownWall(false)
					if (i1 == 7 && k < 0) {
						wall.setTall()
					}
					addStructure(wall, i, k, 0)
				}
			}
		}

		private fun setupVillage(random: Random) {
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityGulfHaradrim::class.java)
					spawner.setCheckRanges(64, -12, 12, 24)
					spawner.setSpawnRanges(32, -6, 6, 32)
					spawner.setBlockEnemySpawnRange(64)
				}
			}, 0, 0, 0)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClasses(
						LOTREntityGulfHaradWarrior::class.java, LOTREntityGulfHaradArcher::class.java
					)
					spawner.setCheckRanges(64, -12, 12, 12)
					spawner.setSpawnRanges(32, -6, 6, 32)
					spawner.setBlockEnemySpawnRange(64)
				}
			}, 0, 0, 0)
			addStructure(LOTRWorldGenGulfTotem(false), 0, -2, 0, true)
			addStructure(LOTRWorldGenGulfTavern(false), 0, 24, 0, true)
			val rSignsInner = 11
			addStructure(LOTRWorldGenGulfVillageSign(false).setSignText(villageName), -rSignsInner, 0, 1, true)
			addStructure(LOTRWorldGenGulfVillageSign(false).setSignText(villageName), rSignsInner, 0, 3, true)
			for (h in 0 until numOuterHouses) {
				val turn = h.toFloat() / (numOuterHouses - 1)
				val turnMin = 0.15f
				val turnMax = 1.0f - turnMin
				val turnInRange = turnMin + (turnMax - turnMin) * turn
				val turnCorrected = (turnInRange + 0.25f) % 1.0f
				val turnR = Math.toRadians((turnCorrected * 360.0f).toDouble()).toFloat()
				val sin = MathHelper.sin(turnR)
				val cos = MathHelper.cos(turnR)
				var r = 0
				val turn8 = turnCorrected * 8.0f
				if (turn8 >= 1.0f && turn8 < 3.0f) {
					r = 0
				} else if (turn8 >= 3.0f && turn8 < 5.0f) {
					r = 1
				} else if (turn8 >= 5.0f && turn8 < 7.0f) {
					r = 2
				} else if (turn8 >= 7.0f || turn8 < 1.0f) {
					r = 3
				}
				val l = 24
				val i = Math.round(l * cos)
				val k = Math.round(l * sin)
				addStructure(getRandomHouse(random), i, k, r)
			}
			val numFarms = numOuterHouses * 2
			val frac = 1.0f / numFarms
			var turn = 0.0f
			while (turn < 1.0f) {
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
				val l = 52
				val i = Math.round(l * cos)
				val k = Math.round(l * sin)
				if (random.nextInt(3) == 0) {
					addStructure(LOTRWorldGenHayBales(false), i, k, r)
					continue
				}
				addStructure(getRandomFarm(random), i, k, r)
			}
		}

		override fun setupVillageProperties(random: Random) {
			villageType =
				if (random.nextInt(4) == 0) VillageType.FORT else if (random.nextInt(3) == 0) VillageType.TOWN else VillageType.VILLAGE
			villageName = LOTRNames.getHaradVillageName(random)
			numOuterHouses = MathHelper.getRandomIntegerInRange(random, 5, 8)
		}
	}
}
