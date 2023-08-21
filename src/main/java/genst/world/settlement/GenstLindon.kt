package genst.world.settlement

import genst.world.structure.StructureTowerLindon
import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityHighElf
import lotr.common.entity.npc.LOTREntityHighElfWarrior
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.LOTRWorldGenHighElfHouse
import lotr.common.world.structure2.LOTRWorldGenHighElvenForge
import lotr.common.world.structure2.LOTRWorldGenNPCRespawner
import lotr.common.world.structure2.LOTRWorldGenStructureBase2
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.util.MathHelper
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs

open class GenstLindon : LOTRVillageGen(LOTRBiome.forodwaith) {
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

	open class Instance(
		village: GenstLindon, world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	) : AbstractInstance<GenstLindon>(village, world, i, k, random, loc) {

		override fun addVillageStructures(random: Random) {
			addStructure(getTower(), 0, -7, 0, true)
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
			addStructure(getForge(), -21, 0, 1, true)
			addStructure(getForge(), 0, -21, 2, true)
			addStructure(getForge(), 21, 0, 3, true)
			addStructure(getForge(), 0, 21, 0, true)
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
					addStructure(getHouse(), i, k, r, true)
					continue
				}
			}
			val farmX = 38
			val farmZ = 17
			val farmSize = 6
			addStructure(getHouse(), -farmX + farmSize, -farmZ, 1, true)
			addStructure(getHouse(), -farmZ + farmSize, -farmX, 1, true)
			addStructure(getHouse(), farmX - farmSize, -farmZ, 3, true)
			addStructure(getHouse(), farmZ - farmSize, -farmX, 3, true)
			addStructure(getHouse(), -farmX + farmSize, farmZ, 1, true)
			addStructure(getHouse(), farmX - farmSize, farmZ, 3, true)
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			val i1 = abs(i)
			val k1 = abs(k)
			val dSq = i * i + k * k
			val imn = 20 + random.nextInt(4)
			if (dSq < imn * imn) {
				return LOTRRoadType.PATH
			}
			val omn = 53 - random.nextInt(4)
			val omx = 60 + random.nextInt(4)
			if (dSq > omn * omn && dSq < omx * omx || dSq < 2809 && abs(i1 - k1) <= 2 + random.nextInt(4)) {
				return LOTRRoadType.PATH
			}
			return null
		}

		override fun isFlat(): Boolean = false

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean = false

		override fun setupVillageProperties(random: Random) {}

		open fun getForge(): LOTRWorldGenStructureBase2 = LOTRWorldGenHighElvenForge(false)

		open fun getHouse(): LOTRWorldGenStructureBase2 = LOTRWorldGenHighElfHouse(false)

		open fun getTower(): LOTRWorldGenStructureBase2 = StructureTowerLindon(false)
	}
}