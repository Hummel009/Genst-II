package genst.world.settlement

import lotr.common.LOTRMod
import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityGulfHaradArcher
import lotr.common.entity.npc.LOTREntityGulfHaradWarrior
import lotr.common.entity.npc.LOTREntityGulfHaradrim
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.*
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.util.MathHelper
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs

open class GenstKopazul : LOTRVillageGen(LOTRBiome.forodwaith) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = 7
		fixedVillageChunkRadius = 5
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> {
		return Instance(this, world, i, k, random, loc)
	}

	class Instance(
		village: GenstKopazul, world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	) : AbstractInstance<GenstKopazul>(village, world, i, k, random, loc) {

		override fun addVillageStructures(random: Random) {
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
				if (l == 0) {
					addStructure(LOTRWorldGenGulfSmithy(false), -k - 6, -i, 2, true)
					addStructure(LOTRWorldGenGulfTavern(false), -k - 6, i, 0, true)
				}
			}
			val xzTownTower = (90 / 1.4142135623730951).toInt()
			addStructure(LOTRWorldGenGulfTower(false), -xzTownTower, -xzTownTower + 4, 2, true)
			addStructure(LOTRWorldGenGulfTower(false), xzTownTower, -xzTownTower + 4, 2, true)
			addStructure(LOTRWorldGenGulfTower(false), -xzTownTower, xzTownTower - 4, 0, true)
			addStructure(LOTRWorldGenGulfTower(false), xzTownTower, xzTownTower - 4, 0, true)
			var turn = 0
			val numTurns = 24
			while (turn <= numTurns) {
				turn++
				if (turn % 3 != 0) {
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
					val l = 90 - 6
					val i = Math.round(l * cos)
					val k = Math.round(l * sin)
					if (random.nextInt(3) == 0) {
						addStructure(LOTRWorldGenHayBales(false), i, k, r)
					} else {
						addStructure(getRandomFarm(random), i, k, r)
					}
				}
			}
			val rSq = 9604
			val rMax = 99
			val rSqMax = rMax * rMax
			for (i in -98..98) {
				for (k in -98..98) {
					val i1 = abs(i)
					if (!(i1 <= 6 && k < 0)) {
						val dSq: Int = i * i + k * k
						if (!(dSq < rSq || dSq >= rSqMax)) {
							val wall = LOTRWorldGenGulfTownWall(false)
							if (i1 == 7 && k < 0) {
								wall.setTall()
							}
							addStructure(wall, i, k, 0)
						}
					}
				}
			}
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			val i1 = abs(i)
			val k1 = abs(k)
			val dSq: Int = i * i + k * k
			if (dSq < 576) {
				return LOTRRoadType.GULF_HARAD
			}
			if (k1 <= 3 && i1 <= 74 || i1 <= 3 && k <= 74) {
				return LOTRRoadType.GULF_HARAD
			}
			return null
		}

		private fun getRandomFarm(random: Random): LOTRWorldGenStructureBase2 {
			return if (random.nextBoolean()) LOTRWorldGenGulfFarm(false) else LOTRWorldGenGulfPasture(false)
		}

		override fun isFlat(): Boolean = false

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			val meta = world.getBlockMetadata(i, j, k)
			return block === LOTRMod.brick3 && (meta == 13 || meta == 14)
		}

		override fun setupVillageProperties(random: Random) {}
	}
}
