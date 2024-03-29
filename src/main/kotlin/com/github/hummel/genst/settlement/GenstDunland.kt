package com.github.hummel.genst.settlement

import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.*
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.*
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs

class GenstDunland : LOTRVillageGen(LOTRBiome.forodwaith) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = 7
		fixedVillageChunkRadius = 5
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> = Instance(this, world, i, k, random, loc)

	class Instance(
		village: GenstDunland, world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	) : AbstractInstance<GenstDunland>(village, world, i, k, random, loc) {

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
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClasses(
						LOTREntityDunlendingBerserker::class.java, LOTREntityDunlendingAxeThrower::class.java
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
			addStructure(LOTRWorldGenDunlendingTavern(false), -pathEnd, 0, 1, true)
			addStructure(LOTRWorldGenDunlendingHouse(false), pathEnd, 0, 3, true)
			val rowHouses = 3
			for (l in -rowHouses..rowHouses) {
				val i1 = l * 18
				var k1 = pathSide
				if (abs(i1) <= 15) {
					k1 += 15 - pathSide
				}
				if (abs(l) >= 1) {
					addStructure(LOTRWorldGenDunlendingHouse(false), i1, -k1, 2, true)
				}
				addStructure(LOTRWorldGenDunlendingHouse(false), i1, k1, 0, true)
				val k2 = k1 + 20
				if (l != 0) {
					addStructure(LOTRWorldGenHayBales(false), i1, -k2, 2, true)
				}
				addStructure(LOTRWorldGenHayBales(false), i1, k2, 0, true)
			}
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			val i1 = abs(i)
			val k1 = abs(k)
			val dSq = i * i + k * k
			val imn = 15 + random.nextInt(4)
			if (dSq < imn * imn || i1 <= 64 && k1 <= 3 + random.nextInt(2)) {
				return LOTRRoadType.PATH
			}
			return null
		}

		override fun isFlat(): Boolean = false

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean = false

		override fun setupVillageProperties(random: Random) {}
	}
}
