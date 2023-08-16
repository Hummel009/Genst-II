package genst.world.settlement

import lotr.common.block.*
import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityDolGuldurOrc
import lotr.common.entity.npc.LOTREntityDolGuldurOrcArcher
import lotr.common.entity.npc.LOTREntityMirkTroll
import lotr.common.entity.npc.LOTREntityMirkwoodSpider
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.*
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.block.BlockStone
import net.minecraft.init.Blocks
import net.minecraft.util.MathHelper
import net.minecraft.world.World
import java.util.*

class GenstDolGuldur : LOTRVillageGen(LOTRBiome.forodwaith) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
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
		village: GenstDolGuldur?, world: World?, i: Int, k: Int, random: Random?, loc: LocationInfo?
	) : AbstractInstance<GenstDolGuldur?>(village, world, i, k, random, loc) {

		override fun addVillageStructures(random: Random) {
			addStructure(LOTRWorldGenDolGuldurTower(false), 0, -4, 0, true)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClasses(
						LOTREntityDolGuldurOrc::class.java, LOTREntityDolGuldurOrcArcher::class.java
					)
					spawner.setCheckRanges(40, -12, 12, 40)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClasses(LOTREntityMirkTroll::class.java, LOTREntityMirkwoodSpider::class.java)
					spawner.setCheckRanges(40, -12, 12, 16)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(LOTRWorldGenDolGuldurSpiderPit(false), -21, 0, 1, true)
			addStructure(LOTRWorldGenDolGuldurSpiderPit(false), 0, -21, 2, true)
			addStructure(LOTRWorldGenDolGuldurSpiderPit(false), 21, 0, 3, true)
			addStructure(LOTRWorldGenDolGuldurSpiderPit(false), 0, 21, 0, true)
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
					addStructure(LOTRWorldGenDolGuldurTent(false), i, k, r, true)
					continue
				}
			}
			val farmX = 38
			val farmZ = 17
			val farmSize = 6
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenDolGuldurTent(false), -farmX + farmSize, -farmZ, 1, true)
			}
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenDolGuldurTent(false), -farmZ + farmSize, -farmX, 1, true)
			}
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenDolGuldurForgeTent(false), farmX - farmSize, -farmZ, 3, true)
			}
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenDolGuldurTent(false), farmZ - farmSize, -farmX, 3, true)
			}
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenDolGuldurTent(false), -farmX + farmSize, farmZ, 1, true)
			}
			if (random.nextBoolean()) {
				addStructure(LOTRWorldGenDolGuldurForgeTent(false), farmX - farmSize, farmZ, 3, true)
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
			return block is LOTRBlockBrickBase || block is LOTRBlockSlabBase || block is LOTRBlockRock || block is LOTRBlockGrass || block is LOTRBlockDirtPath || block is BlockStone || block == Blocks.cobblestone
		}

		override fun setupVillageProperties(random: Random) {
		}
	}
}
