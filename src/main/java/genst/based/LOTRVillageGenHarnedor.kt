package genst.based

import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityHarnedhrim
import lotr.common.entity.npc.LOTREntityHarnedorArcher
import lotr.common.entity.npc.LOTREntityHarnedorWarrior
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

class LOTRVillageGenHarnedor(biome: LOTRBiome?, f: Float) : LOTRVillageGen(biome) {
	private var isRuinedVillage = false

	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = f
		villageChunkRadius = 4
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> {
		return Instance(this, world, i, k, random, loc)
	}

	enum class VillageType {
		VILLAGE, FORTRESS
	}

	class Instance(
		village: LOTRVillageGenHarnedor, world: World?, i: Int, k: Int, random: Random?, loc: LocationInfo?
	) : AbstractInstance<LOTRVillageGenHarnedor?>(village, world, i, k, random, loc) {
		private var villageType: VillageType? = null
		private lateinit var villageName: Array<String>
		private val isRuined: Boolean
		private var numOuterHouses = 0
		private var palisade = false

		init {
			isRuined = village.isRuinedVillage
		}

		override fun addVillageStructures(random: Random) {
			if (villageType == VillageType.VILLAGE) {
				setupVillage(random)
			} else {
				setupFortress()
			}
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			val i1 = abs(i.toDouble()).toInt()
			if (villageType == VillageType.VILLAGE) {
				if (isRuined && random.nextInt(4) == 0) {
					return null
				}
				val dSq = i * i + k * k
				val imn = 17 - random.nextInt(3)
				val imx = 22 + random.nextInt(3)
				if (dSq > imn * imn && dSq < imx * imx) {
					return LOTRRoadType.PATH
				}
				if (palisade && k <= -imx && k >= -66 && i1 < 2 + random.nextInt(3)) {
					return LOTRRoadType.PATH
				}
			}
			return null
		}

		private fun getRandomHouse(random: Random): LOTRWorldGenStructureBase2 {
			if (isRuined) {
				return LOTRWorldGenHarnedorHouseRuined(false)
			}
			if (random.nextInt(5) == 0) {
				return LOTRWorldGenHarnedorSmithy(false)
			}
			return if (random.nextInt(4) == 0) {
				LOTRWorldGenHarnedorStables(false)
			} else LOTRWorldGenHarnedorHouse(false)
		}

		override fun isFlat(): Boolean {
			return false
		}

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			return false
		}

		private fun setupFortress() {
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityHarnedhrim::class.java)
					spawner.setCheckRanges(64, -12, 12, 16)
					spawner.setSpawnRanges(24, -6, 6, 32)
					spawner.setBlockEnemySpawnRange(50)
				}
			}, 0, 0, 0)
			addStructure(LOTRWorldGenHarnedorFort(false), 0, -12, 0, true)
			addStructure(LOTRWorldGenHarnedorTower(false), -24, -24, 0, true)
			addStructure(LOTRWorldGenHarnedorTower(false), 24, -24, 0, true)
			addStructure(LOTRWorldGenHarnedorTower(false), -24, 24, 2, true)
			addStructure(LOTRWorldGenHarnedorTower(false), 24, 24, 2, true)
			for (l in -1..1) {
				val k = l * 10
				val i = 24
				addStructure(LOTRWorldGenNearHaradTent(false), -i, k, 1, true)
				addStructure(LOTRWorldGenNearHaradTent(false), i, k, 3, true)
			}
			val rSq = 1764
			val rMax = 43
			val rSqMax = rMax * rMax
			for (i in -42..42) {
				for (k in -42..42) {
					val i1 = abs(i)

					if (i1 <= 4 && k < 0) {
						continue
					}

					val dSq: Int = i * i + k * k
					if (dSq < rSq || dSq >= rSqMax) {
						continue
					}
					val palisade = LOTRWorldGenHarnedorPalisade(false)
					if (i1 == 5 && k < 0) {
						palisade.setTall()
					}
					addStructure(palisade, i, k, 0)
				}
			}
		}

		private fun setupVillage(random: Random) {
			if (!isRuined) {
				addStructure(object : LOTRWorldGenNPCRespawner(false) {
					override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
						spawner.setSpawnClass(LOTREntityHarnedhrim::class.java)
						spawner.setCheckRanges(64, -12, 12, 24)
						spawner.setSpawnRanges(32, -6, 6, 32)
						spawner.setBlockEnemySpawnRange(64)
					}
				}, 0, 0, 0)
				addStructure(object : LOTRWorldGenNPCRespawner(false) {
					override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
						spawner.setSpawnClasses(
							LOTREntityHarnedorWarrior::class.java, LOTREntityHarnedorArcher::class.java
						)
						spawner.setCheckRanges(64, -12, 12, 12)
						spawner.setSpawnRanges(32, -6, 6, 32)
						spawner.setBlockEnemySpawnRange(64)
					}
				}, 0, 0, 0)
			}
			if (isRuined) {
				addStructure(LOTRWorldGenHarnedorTavernRuined(false), 3, -7, 0, true)
			} else if (random.nextBoolean()) {
				addStructure(LOTRWorldGenHarnedorMarket(false), 0, -8, 0, true)
			} else {
				addStructure(LOTRWorldGenHarnedorTavern(false), 3, -7, 0, true)
			}
			var frac = 1.0f / numOuterHouses
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
				val l = 25
				val i = Math.round(l * cos)
				val k = Math.round(l * sin)
				if (palisade && k < 0 && abs(i.toDouble()) < 10) {
					continue
				}
				addStructure(getRandomHouse(random), i, k, r)
			}
			if (!isRuined) {
				val numFarms = numOuterHouses * 2
				frac = 1.0f / numFarms
				turn = 0.0f
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
					val l = 45
					val i = Math.round(l * cos)
					val k = Math.round(l * sin)
					if (palisade && k < 0 && abs(i.toDouble()) < 10) {
						continue
					}
					if (random.nextInt(3) == 0) {
						addStructure(LOTRWorldGenHayBales(false), i, k, r)
						continue
					}
					if (random.nextInt(3) == 0) {
						addStructure(LOTRWorldGenHarnedorPasture(false), i, k, r)
						continue
					}
					addStructure(LOTRWorldGenHarnedorFarm(false), i, k, r)
				}
			}
			if (!isRuined) {
				if (palisade) {
					addStructure(
						LOTRWorldGenHarnedorVillageSign(false).setSignText(villageName),
						5 * if (random.nextBoolean()) 1 else -1,
						-56,
						0,
						true
					)
				} else {
					addStructure(LOTRWorldGenHarnedorVillageSign(false).setSignText(villageName), 0, -16, 0, true)
				}
			}
			if (palisade) {
				val rSq = 3721
				val rMax = 62
				val rSqMax = rMax * rMax
				for (i in -61..61) {
					for (k in -61..61) {
						val i1 = abs(i)
						if (i1 <= 4 && k < 0) {
							continue
						}
						val dSq: Int = i * i + k * k
						if (dSq < rSq || dSq >= rSqMax) {
							continue
						}
						val palisade: LOTRWorldGenHarnedorPalisade = if (isRuined) {
							if (random.nextBoolean()) {
								continue
							}
							LOTRWorldGenHarnedorPalisadeRuined(false)
						} else {
							LOTRWorldGenHarnedorPalisade(false)
						}
						if (i1 == 5 && k < 0) {
							palisade.setTall()
						}
						addStructure(palisade, i, k, 0)
					}
				}
			}
		}

		override fun setupVillageProperties(random: Random) {
			villageType = if (random.nextInt(4) == 0) VillageType.FORTRESS else VillageType.VILLAGE
			villageName = LOTRNames.getHaradVillageName(random)
			numOuterHouses = MathHelper.getRandomIntegerInRange(random, 5, 8)
			palisade = random.nextInt(3) != 0
		}
	}
}
