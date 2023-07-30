package genst.instance

import lotr.common.LOTRMod
import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityRivendellElf
import lotr.common.entity.npc.LOTREntityRivendellWarrior
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.LOTRWorldGenNPCRespawner
import lotr.common.world.structure2.LOTRWorldGenRivendellForge
import lotr.common.world.structure2.LOTRWorldGenRivendellHouse
import lotr.common.world.structure2.LOTRWorldGenStructureBase2
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs

class LOTRVillageGenRivendell(biome: LOTRBiome?, f: Float) : LOTRVillageGen(biome) {
	init {
		gridScale = 14
		gridRandomDisplace = 1
		spawnChance = f
		villageChunkRadius = 6
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

	class Instance(
		village: LOTRVillageGenRivendell?,
		world: World?,
		i: Int,
		k: Int,
		random: Random?,
		loc: LocationInfo?
	) : AbstractInstance<LOTRVillageGenRivendell?>(village, world, i, k, random, loc) {
		override fun addVillageStructures(random: Random) {
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityRivendellElf::class.java)
					spawner.setCheckRanges(40, -12, 12, 40)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityRivendellWarrior::class.java)
					spawner.setCheckRanges(40, -12, 12, 16)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			val pathEnd = 68
			val pathSide = 7
			val centreSide = 19
			addStructure(LOTRWorldGenRivendellForge(false), 0, -2, 0, true)
			addStructure(LOTRWorldGenRivendellHouse(false), 0, -centreSide, 2, true)
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenRivendellHouse(false), -pathEnd, 0, 1, true)
				addStructure(getOtherVillageStructure(random), pathEnd, 0, 3, true)
			} else {
				addStructure(getOtherVillageStructure(random), -pathEnd, 0, 1, true)
				addStructure(LOTRWorldGenRivendellHouse(false), pathEnd, 0, 3, true)
			}
			val rowHouses = 3
			for (l in -rowHouses..rowHouses) {
				val i1 = l * 18
				var k1 = pathSide
				if (abs(i1.toDouble()) <= 15) {
					k1 += 15 - pathSide
				}
				if (abs(l.toDouble()) >= 1) {
					addStructure(getRandomHouse(random), i1, -k1, 2)
				}
				addStructure(getRandomHouse(random), i1, k1, 0)
				if (l != 0) {
					addStructure(getRandomHouse(random), i1, -k1, 2)
				}
				if (random.nextInt(3) == 0) {
					addStructure(getRandomHouse(random), i1, -k1, 2)
				}
			}
		}

		private fun getOtherVillageStructure(random: Random): LOTRWorldGenStructureBase2 {
			return if (random.nextBoolean()) {
				LOTRWorldGenRivendellHouse(false)
			} else LOTRWorldGenRivendellForge(false)
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			val i1 = abs(i.toDouble()).toInt()
			val k1 = abs(k.toDouble()).toInt()
			val dSq = i * i + k * k
			val imn = 15 + random.nextInt(4)
			return if (dSq < imn * imn || i1 <= 64 && k1 <= 3 + random.nextInt(2)) {
				LOTRRoadType.HIGH_ELVEN
			} else null
		}

		private fun getRandomHouse(random: Random): LOTRWorldGenStructureBase2 {
			return LOTRWorldGenRivendellHouse(false)
		}

		override fun isFlat(): Boolean {
			return false
		}

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			return block === LOTRMod.brick3
		}

		override fun setupVillageProperties(random: Random) {}
	}
}
