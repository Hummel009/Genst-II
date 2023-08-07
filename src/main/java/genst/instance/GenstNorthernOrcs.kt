package genst.instance

import lotr.common.block.LOTRBlockBrickBase
import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityAngmarOrc
import lotr.common.entity.npc.LOTREntityAngmarOrcArcher
import lotr.common.entity.npc.LOTREntityGundabadOrc
import lotr.common.entity.npc.LOTREntityGundabadOrcArcher
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.*
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.block.*
import net.minecraft.util.MathHelper
import net.minecraft.world.World
import java.util.*

class GenstNorthernOrcs : LOTRVillageGen(LOTRBiome.forodwaith) {
	init {
		gridScale = 16
		gridRandomDisplace = 2
		spawnChance = 0.0f
		villageChunkRadius = 6
		fixedVillageChunkRadius = 6
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> {
		return Instance(this, world, i, k, random, loc)
	}

	class Instance(
		village: GenstNorthernOrcs?, world: World?, i: Int, k: Int, random: Random?, loc: LocationInfo?
	) : AbstractInstance<GenstNorthernOrcs?>(village, world, i, k, random, loc) {

		override fun addVillageStructures(random: Random) {
			addStructure(StructureNorthernOrcTower(false), 0, -4, 0, true)
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
					spawner.setSpawnClasses(LOTREntityGundabadOrc::class.java, LOTREntityGundabadOrcArcher::class.java)
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
					addStructure(LOTRWorldGenGundabadTent(false), i, k, r, true)
					continue
				}
			}
			val farmX = 38
			val farmZ = 17
			val farmSize = 6
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenGundabadTent(false), -farmX + farmSize, -farmZ, 1, true)
			}
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenGundabadTent(false), -farmZ + farmSize, -farmX, 1, true)
			}
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenGundabadForgeTent(false), farmX - farmSize, -farmZ, 3, true)
			}
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenAngmarTent(false), farmZ - farmSize, -farmX, 3, true)
			}
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenAngmarTent(false), -farmX + farmSize, farmZ, 1, true)
			}
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenAngmarForgeTent(false), farmX - farmSize, farmZ, 3, true)
			}
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			return null
		}

		override fun isFlat(): Boolean {
			return false
		}

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			val set = hashSetOf(
				BlockStone::class.java,
				BlockSnow::class.java,
				BlockSnowBlock::class.java,
				BlockOre::class.java,
				BlockGravel::class.java,
				BlockDirt::class.java,
				LOTRBlockBrickBase::class.java
			)
			return set.contains(block.javaClass)
		}

		override fun setupVillageProperties(random: Random) {
		}
	}
}
