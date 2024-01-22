package genst.base

import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityDunedain
import lotr.common.entity.npc.LOTREntityRangerNorth
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.*
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.util.MathHelper
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs

@Suppress("unused")
class SettlementDunedain(biome: LOTRBiome?, f: Float) : LOTRVillageGen(biome) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = f
		villageChunkRadius = 4
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> = Instance(this, world, i, k, random, loc)

	enum class VillageType {
		VILLAGE
	}

	class Instance(
		village: SettlementDunedain?, world: World?, i: Int, k: Int, random: Random?, loc: LocationInfo?
	) : AbstractInstance<SettlementDunedain?>(village, world, i, k, random, loc) {
		private var villageType: VillageType? = null
		private var innerSize = 0
		private var palisade = false

		override fun addVillageStructures(random: Random) {
			if (villageType == VillageType.VILLAGE) {
				setupVillage(random)
			}
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			val i1 = abs(i.toDouble()).toInt()
			val k1 = abs(k.toDouble()).toInt()
			if (villageType == VillageType.VILLAGE) {
				val dSq = i * i + k * k
				if (i1 <= 2 && k1 <= 2) {
					return null
				}
				val imn = innerSize + random.nextInt(3)
				if (dSq < imn * imn) {
					return LOTRRoadType.PATH
				}
				if (palisade && k < 0 && k > -(innerSize + 12 + 16) && i1 <= 2 + random.nextInt(3)) {
					return LOTRRoadType.PATH
				}
			}
			return null
		}

		private fun getRandomHouse(random: Random): LOTRWorldGenStructureBase2 {
			if (random.nextInt(3) == 0) {
				val i = random.nextInt(3)
				when (i) {
					0 -> return LOTRWorldGenRangerSmithy(false)
					1 -> return LOTRWorldGenRangerStables(false)
					2 -> return LOTRWorldGenRangerLodge(false)
					else -> {}
				}
			}
			return LOTRWorldGenRangerHouse(false)
		}

		override fun isFlat(): Boolean = false

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean = false

		private fun setupVillage(random: Random) {
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityDunedain::class.java)
					spawner.setCheckRanges(40, -12, 12, 30)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityRangerNorth::class.java)
					spawner.setCheckRanges(40, -12, 12, 12)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(LOTRWorldGenRangerWell(false), 0, -2, 0, true)
			val lampX = 8
			for (i in intArrayOf(-lampX, lampX)) {
				for (k in intArrayOf(-lampX, lampX)) {
					addStructure(LOTRWorldGenRangerVillageLight(false), i, k, 0)
				}
			}
			val houses = 20
			val frac = 1.0f / houses
			var turn = 0.0f
			while (turn < 1.0f) {
				var l: Int
				var k: Int
				var i: Int
				val turnR = Math.toRadians((frac.let { turn += it; turn } * 360.0f).toDouble()).toFloat()
				val sin = MathHelper.sin(turnR)
				val cos = MathHelper.cos(turnR)
				val turn8 = turn * 8.0f
				val r = when {
					turn8 >= 1.0f && turn8 < 3.0f -> 0
					turn8 >= 3.0f && turn8 < 5.0f -> 1
					turn8 >= 5.0f && turn8 < 7.0f -> 2
					turn8 >= 7.0f || turn8 < 1.0f -> 3
					else -> 0
				}
				if (palisade && sin < 0.0f && abs(cos.toDouble()) <= 0.5f) {
					continue
				}
				if (random.nextInt(3) != 0) {
					l = innerSize + 3
					if (random.nextInt(3) == 0) {
						l += 12
					}
					i = Math.round(l * cos)
					k = Math.round(l * sin)
					addStructure(getRandomHouse(random), i, k, r)
					continue
				}
				if (random.nextInt(4) != 0) {
					continue
				}
				l = innerSize + 5
				if (random.nextInt(3) == 0) {
					l += 12
				}
				i = Math.round(l * cos)
				k = Math.round(l * sin)
				addStructure(LOTRWorldGenHayBales(false), i, k, r)
			}
			if (palisade) {
				val rPalisade = innerSize + 12 + 16
				val rSq = rPalisade * rPalisade
				val rMax = rPalisade + 1
				val rSqMax = rMax * rMax
				for (i in -rPalisade..rPalisade) {
					for (k in -rPalisade..rPalisade) {
						if (abs(i) <= 5 && k < 0) {
							continue
						}

						val dSq: Int = i * i + k * k
						if (dSq < rSq || dSq >= rSqMax) {
							continue
						}
						addStructure(LOTRWorldGenRangerVillagePalisade(false), i, k, 0)
					}
				}
			}
		}

		override fun setupVillageProperties(random: Random) {
			villageType = VillageType.VILLAGE
			innerSize = MathHelper.getRandomIntegerInRange(random, 12, 20)
			palisade = random.nextBoolean()
		}
	}
}