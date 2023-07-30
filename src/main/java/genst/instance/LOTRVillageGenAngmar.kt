package genst.instance

import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityAngmarOrc
import lotr.common.entity.npc.LOTREntityAngmarOrcArcher
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.*
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.util.MathHelper
import net.minecraft.world.World
import java.util.*

class LOTRVillageGenAngmar(biome: LOTRBiome?, f: Float) : LOTRVillageGen(biome) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = f
		villageChunkRadius = 4
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

	class Instance(village: LOTRVillageGenAngmar?, world: World?, i: Int, k: Int, random: Random?, loc: LocationInfo?) :
		AbstractInstance<LOTRVillageGenAngmar?>(village, world, i, k, random, loc) {
		private var numOuterHouses = 0
		override fun addVillageStructures(random: Random) {
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityAngmarOrc::class.java)
					spawner.setCheckRanges(80, -12, 12, 50)
					spawner.setSpawnRanges(40, -8, 8, 40)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClasses(LOTREntityAngmarOrc::class.java, LOTREntityAngmarOrcArcher::class.java)
					spawner.setCheckRanges(80, -12, 12, 24)
					spawner.setSpawnRanges(40, -8, 8, 40)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(LOTRWorldGenAngmarTower2(false), 0, 0, 0, true)
			addStructure(LOTRWorldGenAngmarHillmanChieftainHouse(false), 0, 14, 0, true)
			addStructure(LOTRWorldGenAngmarHillmanHouse(false), 0, -14, 2, true)
			addStructure(LOTRWorldGenAngmarForgeTent(false), -14, 0, 1, true)
			addStructure(LOTRWorldGenAngmarForgeTent(false), 14, 0, 3, true)
			val minOuterSize = MathHelper.getRandomIntegerInRange(random, 35, 45)
			val frac = 1.0f / numOuterHouses
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
				val l = minOuterSize + random.nextInt(5)
				val i = Math.round(l * cos)
				val k = Math.round(l * sin)
				addStructure(LOTRWorldGenAngmarTent(false), i, k, r)
			}
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			return null
		}

		override fun isFlat(): Boolean {
			return false
		}

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			return false
		}

		override fun setupVillageProperties(random: Random) {
			numOuterHouses = MathHelper.getRandomIntegerInRange(random, 8, 14)
		}
	}
}
