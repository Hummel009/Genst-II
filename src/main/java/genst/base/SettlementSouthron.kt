package genst.base

import com.google.common.math.IntMath
import lotr.common.LOTRMod
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

@Suppress("unused")
class SettlementSouthron(biome: LOTRBiome?, f: Float) : LOTRVillageGen(biome) {
	init {
		gridScale = 14
		gridRandomDisplace = 1
		spawnChance = f
		villageChunkRadius = 5
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> = Instance(this, world, i, k, random, loc)

	enum class VillageType {
		VILLAGE, TOWN, FORT
	}

	class Instance(
		village: SettlementSouthron?, world: World?, i: Int, k: Int, random: Random?, loc: LocationInfo?
	) : AbstractInstance<SettlementSouthron?>(village, world, i, k, random, loc) {
		private var villageType: VillageType? = null
		private lateinit var villageName: Array<String>

		override fun addVillageStructures(random: Random) {
			when (villageType) {
				VillageType.VILLAGE -> setupVillage(random)
				VillageType.TOWN -> setupTown()
				VillageType.FORT -> setupFort(random)
				null -> {}
			}
		}

		private fun getBarracks(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronBarracks(false)

		private fun getBazaar(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronBazaar(false)

		private fun getFlowers(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronTownFlowers(false)

		private fun getFortCorner(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronFortCorner(false)

		private fun getFortGate(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronFortGate(false)

		private fun getFortress(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronFortress(false)

		private fun getFortWallLong(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronFortWall.Long(false)

		private fun getHouse(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronHouse(false)

		private fun getLamp(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronLamp(false)

		private fun getMansion(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronMansion(false)

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			val i1 = abs(i.toDouble()).toInt()
			val k1 = abs(k.toDouble()).toInt()
			if (villageType == VillageType.VILLAGE) {
				var imn = 2
				var imx = 14 + random.nextInt(3)
				var kmn = 2
				var kmx = 14 + random.nextInt(3)
				if (i1 <= imx && k1 <= kmx && (i1 > imn || k1 > kmn)) {
					return LOTRRoadType.PATH
				}
				imn = 45 - random.nextInt(3)
				imx = 50 + random.nextInt(3)
				kmn = 45 - random.nextInt(3)
				kmx = 50 + random.nextInt(3)
				if (i1 <= imx && k1 <= kmx && (i1 > imn || k1 > kmn) && (k < 0 || i1 > 7)) {
					return LOTRRoadType.PATH
				}
				if (k < 0) {
					imn = 14
					imx = 45
					if (i1 + k1 >= imn + imn && i1 + k1 <= imx + imx && abs((i1 - k1).toDouble()) <= (2.5f + random.nextInt(
							3
						) * 2.0f).toInt()
					) {
						return LOTRRoadType.PATH
					}
				}
				if (k > 0) {
					imn = 10
					imx = imn + 5 + random.nextInt(3)
					kmn = 14
					kmx = 45
					if (k1 in kmn..kmx && i1 >= imn - random.nextInt(3) && i1 <= imx) {
						return LOTRRoadType.PATH
					}
				}
			}
			if (villageType == VillageType.TOWN && i1 <= 72 && k1 <= 42) {
				return LOTRRoadType.HARAD_TOWN
			}
			if (villageType == VillageType.FORT) {
				if (i1 <= 3 && k >= -45 && k <= -15) {
					return LOTRRoadType.PATH
				}
				if (i1 <= 36 && k >= -27 && k <= -20) {
					return LOTRRoadType.PATH
				}
				if (i1 in 29..36 && k >= -27 && k <= 39 && (k < -7 || k > 7)) {
					return LOTRRoadType.PATH
				}
				if (i1 <= 36 && k >= 20 && k <= 27) {
					return LOTRRoadType.PATH
				}
			}
			return null
		}

		private fun getRandomFarm(random: Random): LOTRWorldGenStructureBase2 {
			return if (random.nextBoolean()) {
				LOTRWorldGenSouthronFarm(false)
			} else LOTRWorldGenSouthronPasture(false)
		}

		private fun getRandomHouse(random: Random): LOTRWorldGenStructureBase2 {
			if (random.nextInt(6) == 0) {
				return LOTRWorldGenSouthronSmithy(false)
			}
			return if (random.nextInt(6) == 0) {
				LOTRWorldGenSouthronStables(false)
			} else LOTRWorldGenSouthronHouse(false)
		}

		private fun getSignpost(): LOTRWorldGenSouthronVillageSign = LOTRWorldGenSouthronVillageSign(false)

		private fun getSmithy(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronSmithy(false)

		private fun getStables(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronStables(false)

		private fun getStatue(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronStatue(false)

		private fun getTavern(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronTavern(false)

		private fun getTower(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronTower(false)

		private fun getTownGate(): LOTRWorldGenSouthronTownGate = LOTRWorldGenSouthronTownGate(false)

		private fun getTownWallCorner(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronTownCorner(false)

		private fun getTownWallExtra(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronTownWall.Extra(false)

		private fun getTownWallLong(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronTownWall.Long(false)

		private fun getTownWallShort(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronTownWall.Short(false)

		private fun getTownWallSideMid(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronTownWall.SideMid(false)

		private fun getTraining(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronTraining(false)

		private fun getTree(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronTownTree(false)

		private fun getWell(): LOTRWorldGenStructureBase2 = LOTRWorldGenSouthronWell(false)

		override fun isFlat(): Boolean = false

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			if (villageType == VillageType.TOWN) {
				val block = world.getBlock(i, j, k)
				val meta = world.getBlockMetadata(i, j, k)
				return block === LOTRMod.brick && meta == 15 || block === LOTRMod.brick3 && meta == 11 || block === LOTRMod.pillar && meta == 5
			}
			return false
		}

		private fun placeChampionRespawner() {
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntitySouthronChampion::class.java)
					spawner.setCheckRanges(60, -12, 12, 4)
					spawner.setSpawnRanges(24, -6, 6, 32)
				}
			}, 0, 0, 0)
		}

		private fun setCivilianSpawnClass(spawner: LOTREntityNPCRespawner) {
			spawner.setSpawnClass(LOTREntityNearHaradrim::class.java)
		}

		private fun setupFort(random: Random) {
			var i: Int
			var r: Int
			var k: Int
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					setCivilianSpawnClass(spawner)
					spawner.setCheckRanges(60, -12, 12, 16)
					spawner.setSpawnRanges(24, -6, 6, 40)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			for (i1 in intArrayOf(-25, 25)) {
				for (k1 in intArrayOf(-25, 25)) {
					addStructure(object : LOTRWorldGenNPCRespawner(false) {
						override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
							setWarriorSpawnClasses(spawner)
							spawner.setCheckRanges(35, -12, 12, 16)
							spawner.setSpawnRanges(15, -6, 6, 40)
							spawner.setBlockEnemySpawnRange(35)
						}
					}, i1, k1, 0)
				}
			}
			placeChampionRespawner()
			addStructure(getFortress(), 0, -15, 0, true)
			addStructure(getBarracks(), -33, -8, 0, true)
			addStructure(getBarracks(), 32, -8, 0, true)
			addStructure(getTower(), -43, -36, 2, true)
			addStructure(getTower(), 43, -36, 2, true)
			addStructure(getTower(), -43, 36, 0, true)
			addStructure(getTower(), 43, 36, 0, true)
			var l = 0
			while (l <= 2) {
				i = 10 + l * 11
				k = -28
				r = 2
				addStructure(getRandomFarm(random), i, k, r)
				addStructure(getRandomFarm(random), -i, k, r)
				++l
			}
			addStructure(getTraining(), 0, 27, 0, true)
			addStructure(getStables(), -29, 33, 3, true)
			addStructure(getStables(), 29, 37, 1, true)
			addStructure(getFortGate(), 0, -47, 0, true)
			l = 0
			while (l <= 9) {
				i = 8 + l * 4
				k = -46
				r = 0
				addStructure(getFortWallLong(), -i, k, r, true)
				addStructure(getFortWallLong(), i, k, r, true)
				++l
			}
			l = -11
			while (l <= 11) {
				i = l * 4
				k = 46
				r = 2
				addStructure(getFortWallLong(), i, k, r, true)
				++l
			}
			l = -10
			while (l <= 10) {
				i = -50
				k = l * 4
				r = 3
				addStructure(getFortWallLong(), i, k, r, true)
				r = 1
				addStructure(getFortWallLong(), -i, k, r, true)
				++l
			}
			addStructure(getFortCorner(), -50, -46, 0, true)
			addStructure(getFortCorner(), 50, -46, 1, true)
			addStructure(getFortCorner(), -50, 46, 3, true)
			addStructure(getFortCorner(), 50, 46, 2, true)
		}

		private fun setupTown() {
			var i: Int
			var r: Int
			var k: Int
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					setCivilianSpawnClass(spawner)
					spawner.setCheckRanges(80, -12, 12, 100)
					spawner.setSpawnRanges(40, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			for (i1 in intArrayOf(-30, 30)) {
				for (k1 in intArrayOf(-30, 30)) {
					addStructure(object : LOTRWorldGenNPCRespawner(false) {
						override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
							setWarriorSpawnClasses(spawner)
							spawner.setCheckRanges(40, -12, 12, 16)
							spawner.setSpawnRanges(20, -6, 6, 64)
							spawner.setBlockEnemySpawnRange(60)
						}
					}, i1, k1, 0)
				}
			}
			addStructure(getBazaar(), 1, -2, 0, true)
			addStructure(getLamp(), 15, -2, 0, true)
			addStructure(getLamp(), -13, -2, 0, true)
			addStructure(getLamp(), 15, 18, 0, true)
			addStructure(getLamp(), -13, 18, 0, true)
			addStructure(getWell(), -16, 12, 1, true)
			addStructure(getWell(), -16, 4, 1, true)
			addStructure(getFlowers(), 18, 13, 3, true)
			addStructure(getFlowers(), 18, 3, 3, true)
			var l = 0
			while (l <= 3) {
				i = -41 + l * 19
				k = -7
				r = 2
				addStructure(getMansion(), i, k, r, true)
				addStructure(getLamp(), i + 6, k - 1, r, true)
				i = 24 - l * 19
				k = 23
				r = 0
				addStructure(getMansion(), i, k, r, true)
				addStructure(getLamp(), i - 6, k + 1, r, true)
				++l
			}
			addStructure(getSmithy(), -25, 9, 1, true)
			addStructure(getHouse(), -25, 18, 1, true)
			addStructure(getHouse(), -25, -2, 1, true)
			addStructure(getTree(), -45, 8, 1, true)
			addStructure(getHouse(), -50, 18, 3, true)
			addStructure(getHouse(), -50, -2, 3, true)
			addStructure(getWell(), -51, -14, 2, true)
			addStructure(getTree(), -46, -29, 2, true)
			addStructure(getFlowers(), -42, -32, 3, true)
			addStructure(getTree(), -50, 30, 0, true)
			l = -3
			while (l <= 3) {
				i = -56
				k = -2 + l * 10
				r = 1
				addStructure(getHouse(), i, k, r, true)
				++l
			}
			addStructure(getStatue(), 26, 8, 3, true)
			addStructure(getHouse(), 26, 18, 3, true)
			addStructure(getHouse(), 26, -2, 3, true)
			l = -3
			while (l <= 2) {
				i = 52
				k = 8 + l * 10
				r = 1
				addStructure(getHouse(), i, k, r, true)
				++l
			}
			addStructure(getSmithy(), 41, -33, 3, true)
			l = -2
			while (l <= 2) {
				i = 65
				k = 3 + l * 14
				r = 2
				addStructure(getHouse(), i, k, r, true)
				++l
			}
			addStructure(getWell(), 57, -19, 2, true)
			addStructure(getLamp(), 57, -16, 2, true)
			addStructure(getLamp(), 57, -8, 2, true)
			addStructure(getTree(), 57, 1, 2, true)
			addStructure(getLamp(), 57, 4, 2, true)
			addStructure(getLamp(), 57, 12, 2, true)
			addStructure(getTree(), 57, 21, 2, true)
			addStructure(getLamp(), 57, 24, 2, true)
			addStructure(getLamp(), 57, 32, 2, true)
			l = 0
			while (l <= 3) {
				i = 41 + l * 8
				k = 34
				r = 0
				addStructure(getFlowers(), i, k, r, true)
				++l
			}
			addStructure(getTree(), 34, 25, 0, true)
			addStructure(getStables(), -20, -30, 1, true)
			addStructure(getTavern(), 17, -32, 1, true)
			addStructure(getLamp(), 19, -28, 1, true)
			addStructure(getLamp(), 19, -36, 1, true)
			addStructure(getLamp(), -16, -32, 3, true)
			addStructure(getFlowers(), 25, -32, 3, true)
			addStructure(getTree(), 34, -29, 2, true)
			addStructure(getLamp(), 34, -26, 2, true)
			addStructure(getLamp(), 34, -18, 2, true)
			addStructure(getTree(), 34, -9, 2, true)
			addStructure(getTownGate().setSignText(villageName), 34, -47, 0, true)
			addStructure(getTownWallCorner(), 73, -47, 0, true)
			addStructure(getTownWallCorner(), -77, -43, 3, true)
			addStructure(getTownWallCorner(), -73, 47, 2, true)
			addStructure(getTownWallCorner(), 77, 43, 1, true)
			l = 0
			while (l <= 6) {
				i = 68 - l * 4
				k = -44
				r = 0
				if (l % 2 == 0) {
					addStructure(getTownWallShort(), i, k, r, true)
					++l
					continue
				}
				addStructure(getTownWallLong(), i, k, r, true)
				++l
			}
			addStructure(getTownWallExtra(), 24, -44, 0, true)
			l = 0
			while (l <= 22) {
				i = 20 - l * 4
				k = -44
				r = 0
				if (l % 2 == 0) {
					addStructure(getTownWallShort(), i, k, r, true)
					++l
					continue
				}
				addStructure(getTownWallLong(), i, k, r, true)
				++l
			}
			addStructure(getTownWallSideMid(), 74, 0, 1, true)
			addStructure(getTownWallSideMid(), -74, 0, 3, true)
			l = 1
			while (l <= 9) {
				i = 74
				k = 2 + l * 4
				if (l % 2 == 1) {
					addStructure(getTownWallShort(), i, k, 1, true)
					addStructure(getTownWallShort(), i, -k, 1, true)
					addStructure(getTownWallShort(), -i, k, 3, true)
					addStructure(getTownWallShort(), -i, -k, 3, true)
					++l
					continue
				}
				addStructure(getTownWallLong(), i, k, 1, true)
				addStructure(getTownWallLong(), i, -k, 1, true)
				addStructure(getTownWallLong(), -i, k, 3, true)
				addStructure(getTownWallLong(), -i, -k, 3, true)
				++l
			}
			l = -17
			while (l <= 17) {
				i = l * 4
				k = 44
				r = 2
				if (IntMath.mod(l, 2) == 1) {
					addStructure(getTownWallShort(), i, k, r, true)
					++l
					continue
				}
				addStructure(getTownWallLong(), i, k, r, true)
				++l
			}
		}

		private fun setupVillage(random: Random) {
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					setCivilianSpawnClass(spawner)
					spawner.setCheckRanges(64, -12, 12, 24)
					spawner.setSpawnRanges(32, -6, 6, 32)
					spawner.setBlockEnemySpawnRange(64)
				}
			}, 0, 0, 0)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					setWarriorSpawnClasses(spawner)
					spawner.setCheckRanges(64, -12, 12, 12)
					spawner.setSpawnRanges(32, -6, 6, 32)
					spawner.setBlockEnemySpawnRange(64)
				}
			}, 0, 0, 0)
			addStructure(getWell(), 0, -2, 0, true)
			addStructure(getSignpost().setSignText(villageName), 0, -8, 0, true)
			val rSquareEdge = 17
			addStructure(getTavern(), 0, rSquareEdge, 0, true)
			addStructure(getMansion(), -3, -rSquareEdge, 2, true)
			addStructure(getMansion(), -rSquareEdge, 3, 1, true)
			addStructure(getMansion(), rSquareEdge, -3, 3, true)
			val backFenceX = 0
			val backFenceZ = rSquareEdge + 19
			val backFenceWidth = 12
			val sideFenceX = 13
			val sideFenceZ = rSquareEdge + 11
			val sideFenceWidth = 8
			val frontPostZ = sideFenceZ - sideFenceWidth - 1
			addStructure(
				LOTRWorldGenSouthronVillageFence(false).setLeftRightExtent(backFenceWidth, backFenceWidth),
				backFenceX,
				-backFenceZ,
				0
			)
			addStructure(
				LOTRWorldGenSouthronVillageFence(false).setLeftRightExtent(sideFenceWidth, sideFenceWidth - 1),
				-sideFenceX,
				-sideFenceZ,
				1
			)
			addStructure(
				LOTRWorldGenSouthronVillageFence(false).setLeftRightExtent(sideFenceWidth - 1, sideFenceWidth),
				sideFenceX,
				-sideFenceZ,
				3
			)
			addStructure(LOTRWorldGenSouthronVillagePost(false), -sideFenceX, -frontPostZ, 0)
			addStructure(LOTRWorldGenSouthronVillagePost(false), sideFenceX, -frontPostZ, 0)
			addStructure(LOTRWorldGenSouthronVillagePost(false), -sideFenceX, -backFenceZ, 0)
			addStructure(LOTRWorldGenSouthronVillagePost(false), sideFenceX, -backFenceZ, 0)
			addStructure(
				LOTRWorldGenSouthronVillageFence(false).setLeftRightExtent(backFenceWidth, backFenceWidth),
				-backFenceZ,
				backFenceX,
				1
			)
			addStructure(
				LOTRWorldGenSouthronVillageFence(false).setLeftRightExtent(sideFenceWidth, sideFenceWidth - 1),
				-sideFenceZ,
				sideFenceX,
				0
			)
			addStructure(
				LOTRWorldGenSouthronVillageFence(false).setLeftRightExtent(sideFenceWidth - 1, sideFenceWidth),
				-sideFenceZ,
				-sideFenceX,
				2
			)
			addStructure(LOTRWorldGenSouthronVillagePost(false), -frontPostZ, sideFenceX, 0)
			addStructure(LOTRWorldGenSouthronVillagePost(false), -frontPostZ, -sideFenceX, 0)
			addStructure(LOTRWorldGenSouthronVillagePost(false), -backFenceZ, sideFenceX, 0)
			addStructure(LOTRWorldGenSouthronVillagePost(false), -backFenceZ, -sideFenceX, 0)
			addStructure(
				LOTRWorldGenSouthronVillageFence(false).setLeftRightExtent(backFenceWidth, backFenceWidth),
				backFenceZ,
				backFenceX,
				3
			)
			addStructure(
				LOTRWorldGenSouthronVillageFence(false).setLeftRightExtent(sideFenceWidth, sideFenceWidth - 1),
				sideFenceZ,
				-sideFenceX,
				2
			)
			addStructure(
				LOTRWorldGenSouthronVillageFence(false).setLeftRightExtent(sideFenceWidth - 1, sideFenceWidth),
				sideFenceZ,
				sideFenceX,
				0
			)
			addStructure(LOTRWorldGenSouthronVillagePost(false), frontPostZ, -sideFenceX, 0)
			addStructure(LOTRWorldGenSouthronVillagePost(false), frontPostZ, sideFenceX, 0)
			addStructure(LOTRWorldGenSouthronVillagePost(false), backFenceZ, -sideFenceX, 0)
			addStructure(LOTRWorldGenSouthronVillagePost(false), backFenceZ, sideFenceX, 0)
			val farmRange = 3
			val farmStep = 14
			val farmX = 55
			for (l in -farmRange..farmRange) {
				val k = l * farmStep
				var i = -farmX
				var r = 1
				if (random.nextInt(3) == 0) {
					addStructure(LOTRWorldGenHayBales(false), i, k, r)
				} else {
					addStructure(getRandomFarm(random), i, k, r)
				}
				i = farmX
				r = 3
				if (random.nextInt(3) == 0) {
					addStructure(LOTRWorldGenHayBales(false), i, k, r)
					continue
				}
				addStructure(getRandomFarm(random), i, k, r)
			}
			val houseRange = 3
			val houseStep = 17
			val houseZ = 55
			for (l in -houseRange..houseRange) {
				val i = l * houseStep
				var k = -houseZ
				var r = 2
				addStructure(getRandomHouse(random), i, k, r)
				k = houseZ
				r = 0
				if (abs(i.toDouble()) < 7) {
					continue
				}
				addStructure(getRandomHouse(random), i, k, r)
			}
		}

		override fun setupVillageProperties(random: Random) {
			villageType =
				if (random.nextInt(4) == 0) VillageType.FORT else if (random.nextInt(3) == 0) VillageType.TOWN else VillageType.VILLAGE
			villageName = LOTRNames.getHaradVillageName(random)
		}

		private fun setWarriorSpawnClasses(spawner: LOTREntityNPCRespawner) {
			spawner.setSpawnClasses(LOTREntityNearHaradrimWarrior::class.java, LOTREntityNearHaradrimArcher::class.java)
		}
	}
}
