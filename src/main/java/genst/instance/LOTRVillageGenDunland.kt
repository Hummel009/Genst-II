package genst.instance

import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityDunlending
import lotr.common.entity.npc.LOTREntityDunlendingArcher
import lotr.common.entity.npc.LOTREntityDunlendingWarrior
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.*
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs

class LOTRVillageGenDunland : LOTRVillageGen(LOTRBiome.forodwaith) {
	init {
		gridScale = 14
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = 6
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> {
		return Instance(this, world, i, k, random, loc)
	}

	class Instance(
		village: LOTRVillageGenDunland?, world: World?, i: Int, k: Int, random: Random?, loc: LocationInfo?
	) : AbstractInstance<LOTRVillageGenDunland?>(village, world, i, k, random, loc) {

		override fun addVillageStructures(random: Random) {
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityDunlending::class.java)
					spawner.setCheckRanges(40, -12, 12, 40)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClasses(
						LOTREntityDunlendingWarrior::class.java, LOTREntityDunlendingArcher::class.java
					)
					spawner.setCheckRanges(40, -12, 12, 16)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			val pathEnd = 68
			val pathSide = 7
			val centreSide = 19
			addStructure(LOTRWorldGenBreeWell(false), 0, -2, 0, true)
			addStructure(LOTRWorldGenDunlandHillFort(false), 0, -centreSide, 2, true)
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenDunlendingTavern(false), -pathEnd, 0, 1, true)
				addStructure(getOtherVillageStructure(), pathEnd, 0, 3, true)
			} else {
				addStructure(getOtherVillageStructure(), -pathEnd, 0, 1, true)
				addStructure(LOTRWorldGenDunlendingTavern(false), pathEnd, 0, 3, true)
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
				}
				addStructure(getRandomHouse(), i1, k1, 0)
				val k2 = k1 + 20
				if (l != 0) {
					addStructure(LOTRWorldGenHayBales(false), i1, -k2, 2)
				}
				if (random.nextInt(3) == 0) {
					addStructure(getRandomVillageFarm(), i1, k2, 0)
					continue
				}
				addStructure(LOTRWorldGenHayBales(false), i1, k2, 0)
			}
		}

		private fun getOtherVillageStructure(): LOTRWorldGenStructureBase2 {
			return LOTRWorldGenDunlendingHouse(false)
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			val i1 = abs(i.toDouble()).toInt()
			val k1 = abs(k.toDouble()).toInt()
			val dSq = i * i + k * k
			val imn = 15 + random.nextInt(4)
			return if (dSq < imn * imn || i1 <= 64 && k1 <= 3 + random.nextInt(2)) {
				LOTRRoadType.PATH
			} else null
		}

		private fun getRandomHouse(): LOTRWorldGenStructureBase2 {
			return LOTRWorldGenDunlendingHouse(false)
		}

		private fun getRandomVillageFarm(): LOTRWorldGenStructureBase2 {
			return LOTRWorldGenDunlendingHouse(false)
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
