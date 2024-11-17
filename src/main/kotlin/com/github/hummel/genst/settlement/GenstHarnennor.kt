package com.github.hummel.genst.settlement

import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityHarnedhrim
import lotr.common.entity.npc.LOTREntityHarnedorArcher
import lotr.common.entity.npc.LOTREntityHarnedorWarrior
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.*
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.util.MathHelper
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs
import kotlin.math.roundToInt

class GenstHarnennor : LOTRVillageGen(LOTRBiome.forodwaith) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = 5
		fixedVillageChunkRadius = 3
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> = Instance(this, world, i, k, random, loc)

	class Instance(
		village: GenstHarnennor, world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	) : AbstractInstance<GenstHarnennor>(village, world, i, k, random, loc) {
		private var palisade = false

		override fun addVillageStructures(random: Random) {
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
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenHarnedorMarket(false), 0, -8, 0, true)
			} else {
				addStructure(LOTRWorldGenHarnedorTavern(false), 3, -7, 0, true)
			}
			var frac = 1.0f / 8
			var turn = 0.0f
			while (turn < 1.0f) {
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
				val l = 25
				val i = (l * cos).roundToInt()
				val k = (l * sin).roundToInt()
				if (!(palisade && k < 0 && abs(i) < 10)) {
					addStructure(getRandomHouse(random), i, k, r)
				}
			}
			val numFarms = 8 * 2
			frac = 1.0f / numFarms
			turn = 0.0f
			while (turn < 1.0f) {
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
				val l = 45
				val i = (l * cos).roundToInt()
				val k = (l * sin).roundToInt()
				if (!(palisade && k < 0 && abs(i) < 10)) {
					if (random.nextInt(3) == 0) {
						addStructure(LOTRWorldGenHayBales(false), i, k, r)
					} else {
						if (random.nextInt(3) == 0) {
							addStructure(LOTRWorldGenHarnedorPasture(false), i, k, r)
						} else {
							addStructure(LOTRWorldGenHarnedorFarm(false), i, k, r)
						}
					}
				}
			}
			if (palisade) {
				val rSq = 3721
				val rMax = 62
				val rSqMax = rMax * rMax
				for (i in -61..61) {
					for (k in -61..61) {
						val i1 = abs(i)
						if (!(i1 <= 4 && k < 0)) {
							val dSq: Int = i * i + k * k
							if (!(dSq < rSq || dSq >= rSqMax)) {
								val palisade = LOTRWorldGenHarnedorPalisade(false)
								if (i1 == 5 && k < 0) {
									palisade.setTall()
								}
								addStructure(palisade, i, k, 0)
							}
						}
					}
				}
			}
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			val i1 = abs(i)
			val dSq = i * i + k * k
			val imn = 17 - random.nextInt(3)
			val imx = 22 + random.nextInt(3)
			if (dSq > imn * imn && dSq < imx * imx) {
				return LOTRRoadType.HARAD_PATH
			}
			if (palisade && k <= -imx && k >= -66 && i1 < 2 + random.nextInt(3)) {
				return LOTRRoadType.HARAD_PATH
			}
			return null
		}

		private fun getRandomHouse(random: Random): LOTRWorldGenStructureBase2 {
			if (random.nextInt(5) == 0) {
				return LOTRWorldGenHarnedorSmithy(false)
			}
			return if (random.nextInt(4) == 0) {
				LOTRWorldGenHarnedorStables(false)
			} else LOTRWorldGenHarnedorHouse(false)
		}

		override fun isFlat(): Boolean = false

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean = false

		override fun setupVillageProperties(random: Random) {
			palisade = random.nextInt(3) != 0
		}
	}
}