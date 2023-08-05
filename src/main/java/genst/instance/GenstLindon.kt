package genst.instance

import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityHighElf
import lotr.common.entity.npc.LOTREntityHighElfWarrior
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.LOTRWorldGenHighElfHouse
import lotr.common.world.structure2.LOTRWorldGenHighElvenTower
import lotr.common.world.structure2.LOTRWorldGenNPCRespawner
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.util.MathHelper
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs

class GenstLindon : LOTRVillageGen(LOTRBiome.forodwaith) {
	init {
		gridScale = 16
		gridRandomDisplace = 2
		spawnChance = 0.0f
		villageChunkRadius = 6
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> {
		return Instance(this, world, i, k, random, loc)
	}

	class Instance(
		village: GenstLindon?, world: World?, i: Int, k: Int, random: Random?, loc: LocationInfo?
	) : AbstractInstance<GenstLindon?>(village, world, i, k, random, loc) {

		override fun addVillageStructures(random: Random) {
			addStructure(LOTRWorldGenHighElvenTower(false), 0, -4, 0, true)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityHighElfWarrior::class.java)
					spawner.setCheckRanges(40, -12, 12, 40)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityHighElf::class.java)
					spawner.setCheckRanges(40, -12, 12, 16)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(LOTRWorldGenHighElfHouse(false), -21, 0, 1)
			addStructure(LOTRWorldGenHighElfHouse(false), 0, -21, 2)
			addStructure(LOTRWorldGenHighElfHouse(false), 21, 0, 3)
			addStructure(LOTRWorldGenHighElfHouse(false), 0, 21, 0)
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
				if (random.nextBoolean()) {
					l = 61
					i = Math.round(l * cos)
					k = Math.round(l * sin)
					addStructure(LOTRWorldGenHighElfHouse(false), i, k, r)
					continue
				}
			}
			val farmX = 38
			val farmZ = 17
			val farmSize = 6
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenHighElfHouse(false), -farmX + farmSize, -farmZ, 1)
			}
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenHighElfHouse(false), -farmZ + farmSize, -farmX, 1)
			}
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenHighElfHouse(false), farmX - farmSize, -farmZ, 3)
			}
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenHighElfHouse(false), farmZ - farmSize, -farmX, 3)
			}
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenHighElfHouse(false), -farmX + farmSize, farmZ, 1)
			}
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenHighElfHouse(false), farmX - farmSize, farmZ, 3)
			}
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			val i1 = abs(i.toDouble()).toInt()
			val k1 = abs(k.toDouble()).toInt()
			val dSq = i * i + k * k
			val imn = 20 + random.nextInt(4)
			if (dSq < imn * imn) {
				return LOTRRoadType.HIGH_ELVEN
			}
			val omn = 53 - random.nextInt(4)
			val omx = 60 + random.nextInt(4)
			if (dSq > omn * omn && dSq < omx * omx || dSq < 2809 && abs((i1 - k1).toDouble()) <= 2 + random.nextInt(4)) {
				return LOTRRoadType.HIGH_ELVEN
			}
			return null
		}

		override fun isFlat(): Boolean {
			return false
		}

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			return true
		}

		override fun setupVillageProperties(random: Random) {
		}
	}
}