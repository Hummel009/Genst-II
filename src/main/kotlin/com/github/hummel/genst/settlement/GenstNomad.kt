package com.github.hummel.genst.settlement

import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityNomad
import lotr.common.entity.npc.LOTREntityNomadArcher
import lotr.common.entity.npc.LOTREntityNomadWarrior
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.*
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.util.MathHelper
import net.minecraft.world.World
import java.util.*
import kotlin.math.roundToInt

open class GenstNomad : LOTRVillageGen(LOTRBiome.forodwaith) {
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
		village: GenstNomad, world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	) : AbstractInstance<GenstNomad>(village, world, i, k, random, loc) {
		override fun addVillageStructures(random: Random) {
			setupVillage(random)
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? = null

		override fun setupVillageProperties(rand: Random) {
		}

		override fun isFlat(): Boolean = false

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean = false

		private fun setupVillage(random: Random) {
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityNomad::class.java)
					spawner.setCheckRanges(80, -12, 12, 50)
					spawner.setSpawnRanges(40, -8, 8, 40)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClasses(LOTREntityNomadWarrior::class.java, LOTREntityNomadArcher::class.java)
					spawner.setCheckRanges(80, -12, 12, 24)
					spawner.setSpawnRanges(40, -8, 8, 40)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(LOTRWorldGenNomadWell(false), 0, 0, 0, true)
			addStructure(LOTRWorldGenNomadChieftainTent(false), 0, 14, 0, true)
			addStructure(LOTRWorldGenNomadBazaarTent(false), 0, -14, 2, true)
			addStructure(LOTRWorldGenNomadTentLarge(false), -14, 0, 1, true)
			addStructure(LOTRWorldGenNomadTentLarge(false), 14, 0, 3, true)
			val minOuterSize = 45
			val frac = 1.0f / 14
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
				val l = minOuterSize + random.nextInt(5)
				val i = (l * cos).roundToInt()
				val k = (l * sin).roundToInt()
				addStructure(LOTRWorldGenNomadTent(false), i, k, r)
			}
		}
	}
}