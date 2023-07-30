package genst.instance

import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityHobbit
import lotr.common.entity.npc.LOTREntityHobbitBounder
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.*
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs

class LOTRVillageGenHobbit(biome: LOTRBiome?, f: Float) : LOTRVillageGen(biome) {
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

	class Instance(village: LOTRVillageGenHobbit?, world: World?, i: Int, k: Int, random: Random?, loc: LocationInfo?) :
		AbstractInstance<LOTRVillageGenHobbit?>(village, world, i, k, random, loc) {

		override fun addVillageStructures(random: Random) {
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityHobbit::class.java)
					spawner.setCheckRanges(40, -12, 12, 40)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityHobbitBounder::class.java)
					spawner.setCheckRanges(40, -12, 12, 16)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			val pathEnd = 68
			val pathSide = 7
			addStructure(LOTRWorldGenBreeWell(false), 0, -2, 0, true)
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenHobbitTavern(false), -pathEnd, 0, 1, true)
				addStructure(getOtherVillageStructure(random), pathEnd, 0, 3, true)
			} else {
				addStructure(getOtherVillageStructure(random), -pathEnd, 0, 1, true)
				addStructure(LOTRWorldGenHobbitTavern(false), pathEnd, 0, 3, true)
			}
			val rowHouses = 3
			for (l in -rowHouses..rowHouses) {
				val i1 = l * 18
				var k1 = pathSide
				if (abs(i1.toDouble()) <= 15) {
					k1 += 15 - pathSide
				}
				if (abs(l.toDouble()) >= 1) {
					addStructure(LOTRWorldGenHobbitBurrow(false), i1, -k1, 2)
				}
				addStructure(LOTRWorldGenHobbitBurrow(false), i1, k1, 0)
				val k2 = k1 + 20
				if (l != 0) {
					addStructure(LOTRWorldGenHayBales(false), i1, -k2, 2)
				}
				addStructure(LOTRWorldGenHayBales(false), i1, k2, 0)
			}
		}

		private fun getOtherVillageStructure(random: Random): LOTRWorldGenStructureBase2 {
			return if (random.nextBoolean()) {
				LOTRWorldGenHobbitFarm(false)
			} else LOTRWorldGenHobbitWindmill(false)
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

		override fun isFlat(): Boolean {
			return false
		}

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			return false
		}

		override fun setupVillageProperties(random: Random) {}
	}
}
