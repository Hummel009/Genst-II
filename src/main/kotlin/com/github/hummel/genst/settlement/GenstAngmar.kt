package com.github.hummel.genst.settlement

import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityAngmarOrc
import lotr.common.entity.npc.LOTREntityAngmarOrcArcher
import lotr.common.entity.npc.LOTREntityAngmarWarg
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.LOTRWorldGenAngmarForgeTent
import lotr.common.world.structure2.LOTRWorldGenAngmarTent
import lotr.common.world.structure2.LOTRWorldGenAngmarWargPit
import lotr.common.world.structure2.LOTRWorldGenNPCRespawner
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.init.Blocks
import net.minecraft.util.MathHelper
import net.minecraft.world.World
import java.util.*

class GenstAngmar : LOTRVillageGen(LOTRBiome.forodwaith) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = 6
		fixedVillageChunkRadius = 4
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> = Instance(this, world, i, k, random, loc)

	class Instance(
		village: GenstAngmar,
		world: World,
		i: Int,
		k: Int,
		random: Random,
		loc: LocationInfo
	) : AbstractInstance<GenstAngmar>(village, world, i, k, random, loc) {

		override fun addVillageStructures(random: Random) {
			addStructure(com.github.hummel.genst.structure.StructureAngmarTower(), 0, 6, 2, true)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClasses(LOTREntityAngmarOrc::class.java, LOTREntityAngmarOrcArcher::class.java)
					spawner.setCheckRanges(40, -12, 12, 40)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityAngmarWarg::class.java)
					spawner.setCheckRanges(40, -12, 12, 16)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(LOTRWorldGenAngmarWargPit(false), -21, 0, 1, true)
			addStructure(LOTRWorldGenAngmarWargPit(false), 0, -21, 2, true)
			addStructure(LOTRWorldGenAngmarWargPit(false), 21, 0, 3, true)
			addStructure(LOTRWorldGenAngmarWargPit(false), 0, 21, 0, true)
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
				val turn8 = turn * 8.0f
				val r = when {
					turn8 >= 1.0f && turn8 < 3.0f -> 0
					turn8 >= 3.0f && turn8 < 5.0f -> 1
					turn8 >= 5.0f && turn8 < 7.0f -> 2
					turn8 >= 7.0f || turn8 < 1.0f -> 3
					else -> 0
				}
				if (random.nextBoolean()) {
					l = 61
					i = Math.round(l * cos)
					k = Math.round(l * sin)
					addStructure(LOTRWorldGenAngmarTent(false), i, k, r, true)
					continue
				}
			}
			val farmX = 38
			val farmZ = 17
			val farmSize = 6
			addStructure(LOTRWorldGenAngmarTent(false), -farmX + farmSize, -farmZ, 1, true)
			addStructure(LOTRWorldGenAngmarTent(false), -farmZ + farmSize, -farmX, 1, true)
			addStructure(LOTRWorldGenAngmarForgeTent(false), farmX - farmSize, -farmZ, 3, true)
			addStructure(LOTRWorldGenAngmarTent(false), farmZ - farmSize, -farmX, 3, true)
			addStructure(LOTRWorldGenAngmarTent(false), -farmX + farmSize, farmZ, 1, true)
			addStructure(LOTRWorldGenAngmarForgeTent(false), farmX - farmSize, farmZ, 3, true)
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? = null

		override fun isFlat(): Boolean = false

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			val meta = world.getBlockMetadata(i, j, k)
			val path = arrayOf(
				Blocks.snow to 0
			)
			return path.any { (pairBlock, pairMeta) ->
				block == pairBlock && meta == pairMeta
			}
		}

		override fun setupVillageProperties(random: Random) {}
	}
}