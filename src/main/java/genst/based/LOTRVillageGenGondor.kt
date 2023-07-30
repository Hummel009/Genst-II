package genst.based

import com.google.common.math.IntMath
import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityGondorMan
import lotr.common.entity.npc.LOTRNames
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.*
import lotr.common.world.structure2.LOTRWorldGenGondorStructure.GondorFiefdom
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.init.Blocks
import net.minecraft.util.MathHelper
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs

class LOTRVillageGenGondor(biome: LOTRBiome?, fief: GondorFiefdom, f: Float) : LOTRVillageGen(biome) {
	private val villageFief: GondorFiefdom

	init {
		gridScale = 16
		gridRandomDisplace = 2
		spawnChance = f
		villageChunkRadius = 5
		villageFief = fief
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> {
		return Instance(this, world, i, k, random, loc)
	}

	enum class VillageType {
		VILLAGE, TOWN, FORT
	}

	class Instance(village: LOTRVillageGenGondor, world: World?, i: Int, k: Int, random: Random?, loc: LocationInfo?) :
		AbstractInstance<LOTRVillageGenGondor?>(village, world, i, k, random, loc) {
		private var villageType: VillageType? = null
		private val villageFief: GondorFiefdom
		private lateinit var villageName: Array<String>

		init {
			villageFief = village.villageFief
		}

		override fun addStructure(structure: LOTRWorldGenStructureBase2, x: Int, z: Int, r: Int, force: Boolean) {
			super.addStructure(structure, x, z, r, force)
			if (structure is LOTRWorldGenGondorStructure) {
				structure.strFief = villageFief
			}
		}

		override fun addVillageStructures(random: Random) {
			if (villageType == VillageType.VILLAGE) {
				setupVillage(random)
			} else if (villageType == VillageType.TOWN) {
				setupTown(random)
			} else if (villageType == VillageType.FORT) {
				setupFortVillage(random)
			}
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			val i1 = abs(i.toDouble()).toInt()
			val k1 = abs(k.toDouble()).toInt()
			if (villageType == VillageType.VILLAGE) {
				val dSq = i * i + k * k
				val imn = 20 + random.nextInt(4)
				if (dSq < imn * imn) {
					return LOTRRoadType.PATH
				}
				val omn = 53 - random.nextInt(4)
				val omx = 60 + random.nextInt(4)
				if (dSq > omn * omn && dSq < omx * omx || dSq < 2809 && abs((i1 - k1).toDouble()) <= 2 + random.nextInt(
						4
					)
				) {
					return LOTRRoadType.PATH
				}
			}
			if (villageType == VillageType.TOWN && i1 <= 80 && k1 <= 80) {
				return LOTRRoadType.COBBLESTONE
			}
			if (villageType == VillageType.FORT) {
				if (i1 <= 1 && (k >= 13 || k <= -12) && k1 <= 36) {
					return instanceVillageBiome.roadBlock
				}
				if (k1 <= 1 && i1 >= 12 && i1 <= 36) {
					return instanceVillageBiome.roadBlock
				}
				if (k in 26..28 && i1 <= 12) {
					return instanceVillageBiome.roadBlock
				}
			}
			return null
		}

		private fun getRandomFarm(random: Random): LOTRWorldGenStructureBase2 {
			return if (random.nextBoolean()) {
				if (random.nextBoolean()) {
					LOTRWorldGenGondorVillageFarm.Animals(false)
				} else LOTRWorldGenGondorVillageFarm.Crops(false)
			} else LOTRWorldGenGondorVillageFarm.Tree(false)
		}

		private fun getRandomHouse(random: Random): LOTRWorldGenStructureBase2 {
			if (random.nextInt(5) == 0) {
				val i = random.nextInt(3)
				when (i) {
					0 -> return LOTRWorldGenGondorStables(false)
					1 -> return LOTRWorldGenGondorSmithy(false)
					2 -> return LOTRWorldGenGondorBarn(false)
					else -> {}
				}
			}
			return LOTRWorldGenGondorHouse(false)
		}

		private val villageFortress: LOTRWorldGenStructureBase2?
			get() {
				if (villageFief == GondorFiefdom.GONDOR) {
					return LOTRWorldGenGondorFortress(false)
				}
				if (villageFief == GondorFiefdom.LOSSARNACH) {
					return LOTRWorldGenLossarnachFortress(false)
				}
				if (villageFief == GondorFiefdom.LEBENNIN) {
					return LOTRWorldGenLebenninFortress(false)
				}
				if (villageFief == GondorFiefdom.PELARGIR) {
					return LOTRWorldGenPelargirFortress(false)
				}
				if (villageFief == GondorFiefdom.PINNATH_GELIN) {
					return LOTRWorldGenPinnathGelinFortress(false)
				}
				if (villageFief == GondorFiefdom.BLACKROOT_VALE) {
					return LOTRWorldGenBlackrootFortress(false)
				}
				if (villageFief == GondorFiefdom.LAMEDON) {
					return LOTRWorldGenLamedonFortress(false)
				}
				return if (villageFief == GondorFiefdom.DOL_AMROTH) {
					LOTRWorldGenDolAmrothStables(false)
				} else null
			}

		private val villageWatchtower: LOTRWorldGenStructureBase2?
			get() {
				if (villageFief == GondorFiefdom.GONDOR) {
					return LOTRWorldGenGondorWatchtower(false)
				}
				if (villageFief == GondorFiefdom.LOSSARNACH) {
					return LOTRWorldGenLossarnachWatchtower(false)
				}
				if (villageFief == GondorFiefdom.LEBENNIN) {
					return LOTRWorldGenLebenninWatchtower(false)
				}
				if (villageFief == GondorFiefdom.PELARGIR) {
					return LOTRWorldGenPelargirWatchtower(false)
				}
				if (villageFief == GondorFiefdom.PINNATH_GELIN) {
					return LOTRWorldGenPinnathGelinWatchtower(false)
				}
				if (villageFief == GondorFiefdom.BLACKROOT_VALE) {
					return LOTRWorldGenBlackrootWatchtower(false)
				}
				if (villageFief == GondorFiefdom.LAMEDON) {
					return LOTRWorldGenLamedonWatchtower(false)
				}
				return if (villageFief == GondorFiefdom.DOL_AMROTH) {
					LOTRWorldGenDolAmrothWatchtower(false)
				} else null
			}

		override fun isFlat(): Boolean {
			return villageType == VillageType.TOWN
		}

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			return villageType == VillageType.TOWN && block === Blocks.cobblestone
		}

		private fun setupFortVillage(random: Random) {
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityGondorMan::class.java)
					spawner.setCheckRanges(50, -12, 12, 16)
					spawner.setSpawnRanges(30, -6, 6, 40)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)

			for (i1 in intArrayOf(-20, 20)) {
				for (k1 in intArrayOf(-20, 20)) {
					addStructure(object : LOTRWorldGenNPCRespawner(false) {
						override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
							spawner.setSpawnClasses(villageFief.soldierClasses[0], villageFief.soldierClasses[1])
							spawner.setCheckRanges(20, -12, 12, 16)
							spawner.setSpawnRanges(20, -6, 6, 40)
							spawner.setBlockEnemySpawnRange(40)
						}
					}, i1, k1, 0)
				}
			}

			addStructure(villageFortress ?: return, 0, 12, 2, true)
			addStructure(LOTRWorldGenGondorFortGate(false), 0, -37, 0, true)
			addStructure(LOTRWorldGenGondorFortWall.Right(false), -11, -37, 0, true)
			addStructure(LOTRWorldGenGondorFortWall.Left(false), 11, -37, 0, true)
			addStructure(villageWatchtower ?: return, -23, -33, 2, true)
			addStructure(villageWatchtower ?: return, 23, -33, 2, true)
			addStructure(LOTRWorldGenGondorFortGate(false), -37, 0, 3, true)
			addStructure(LOTRWorldGenGondorFortWall.Left(false), -37, -11, 3, true)
			addStructure(LOTRWorldGenGondorFortWall.Right(false), -37, 11, 3, true)
			addStructure(villageWatchtower ?: return, -33, -23, 1, true)
			addStructure(villageWatchtower ?: return, -33, 23, 1, true)
			addStructure(LOTRWorldGenGondorFortGate(false), 0, 37, 2, true)
			addStructure(LOTRWorldGenGondorFortWall.Left(false), -11, 37, 2, true)
			addStructure(LOTRWorldGenGondorFortWall.Right(false), 11, 37, 2, true)
			addStructure(villageWatchtower ?: return, -23, 33, 0, true)
			addStructure(villageWatchtower ?: return, 23, 33, 0, true)
			addStructure(LOTRWorldGenGondorFortGate(false), 37, 0, 1, true)
			addStructure(LOTRWorldGenGondorFortWall.Right(false), 37, -11, 1, true)
			addStructure(LOTRWorldGenGondorFortWall.Left(false), 37, 11, 1, true)
			addStructure(villageWatchtower ?: return, 33, -23, 3, true)
			addStructure(villageWatchtower ?: return, 33, 23, 3, true)
			addStructure(LOTRWorldGenGondorFortWallCorner(false), -30, -30, 3)
			addStructure(LOTRWorldGenGondorFortWallCorner(false), -30, 30, 2)
			addStructure(LOTRWorldGenGondorFortWallCorner(false), 30, 30, 1)
			addStructure(LOTRWorldGenGondorFortWallCorner(false), 30, -30, 0)
			addStructure(LOTRWorldGenGondorStables(false), -24, 2, 0)
			addStructure(LOTRWorldGenGondorStables(false), -24, -2, 2)
			addStructure(LOTRWorldGenGondorSmithy(false), 24, 1, 0)
			addStructure(LOTRWorldGenGondorSmithy(false), 24, -1, 2)
			addStructure(LOTRWorldGenGondorStoneHouse(false), -3, -25, 1)
			addStructure(LOTRWorldGenGondorStoneHouse(false), 3, -25, 3)
			addStructure(LOTRWorldGenGondorVillageFarm.Crops(false), -18, -21, 1)
			addStructure(LOTRWorldGenGondorVillageFarm.Crops(false), 18, -21, 3)
			addStructure(LOTRWorldGenGondorWell(false), -12, 27, 1)
			addStructure(LOTRWorldGenGondorWell(false), 12, 27, 3)
		}

		private fun setupTown(random: Random) {
			var wallX: Int
			val outerTavern = random.nextBoolean()
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityGondorMan::class.java)
					spawner.setCheckRanges(80, -12, 12, 100)
					spawner.setSpawnRanges(60, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			for (i1 in intArrayOf(-40, 40)) {
				val arrn = intArrayOf(-40, 40)
				val n = arrn.size
				for (k1 in arrn) {
					addStructure(object : LOTRWorldGenNPCRespawner(false) {
						override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
							spawner.setSpawnClasses(villageFief.levyClasses[0], villageFief.levyClasses[1])
							spawner.setCheckRanges(40, -12, 12, 16)
							spawner.setSpawnRanges(20, -6, 6, 64)
							spawner.setBlockEnemySpawnRange(60)
						}
					}, i1, k1, 0)
				}
			}
			addStructure(LOTRWorldGenGondorWell(false), 0, -4, 0, true)
			val stallPos = 12
			for (k1 in -1..1) {
				val k2 = k1 * stallPos
				if (random.nextInt(3) != 0) {
					addStructure(
						LOTRWorldGenGondorMarketStall.getRandomStall(random, false), -stallPos + 3, k2, 1, true
					)
				}
				if (random.nextInt(3) == 0) {
					continue
				}
				addStructure(LOTRWorldGenGondorMarketStall.getRandomStall(random, false), stallPos - 3, k2, 3, true)
			}
			if (random.nextInt(3) != 0) {
				addStructure(LOTRWorldGenGondorMarketStall.getRandomStall(random, false), 0, stallPos - 3, 0, true)
			}
			if (random.nextInt(3) != 0) {
				addStructure(LOTRWorldGenGondorMarketStall.getRandomStall(random, false), 0, -stallPos + 3, 2, true)
			}
			val flowerX = 12
			val flowerZ = 18
			for (i1 in intArrayOf(-flowerX, flowerX)) {
				addStructure(LOTRWorldGenGondorTownGarden(false), i1, flowerZ, 0, true)
				addStructure(LOTRWorldGenGondorTownGarden(false), i1, -flowerZ, 2, true)
				addStructure(LOTRWorldGenGondorTownGarden(false), -flowerZ, i1, 1, true)
				addStructure(LOTRWorldGenGondorTownGarden(false), flowerZ, i1, 3, true)
			}
			val lampZ = 21
			for (i1 in intArrayOf(-1, 1)) {
				val lampX = i1 * 6
				addStructure(LOTRWorldGenGondorLampPost(false), lampX, lampZ, 0, true)
				addStructure(LOTRWorldGenGondorLampPost(false), lampX, -lampZ, 2, true)
				if (i1 != -1) {
					addStructure(LOTRWorldGenGondorLampPost(false), -lampZ, lampX, 1, true)
				}
				addStructure(LOTRWorldGenGondorLampPost(false), lampZ, lampX, 3, true)
			}
			var houseX = 24
			for (k1 in -1..1) {
				val houseZ = k1 * 12
				if (k1 == 1) {
					addStructure(LOTRWorldGenGondorStoneHouse(false), -houseX, houseZ, 1, true)
					addStructure(LOTRWorldGenGondorStoneHouse(false), houseX, houseZ, 3, true)
				}
				if (k1 == 0) {
					continue
				}
				addStructure(LOTRWorldGenGondorStoneHouse(false), houseZ, houseX, 0, true)
				addStructure(LOTRWorldGenGondorStoneHouse(false), houseZ, -houseX, 2, true)
			}
			addStructure(LOTRWorldGenGondorSmithy(false), 0, -26, 2, true)
			addStructure(LOTRWorldGenGondorObelisk(false), 0, 27, 0, true)
			addStructure(LOTRWorldGenGondorTavern(false), -houseX, -5, 1, true)
			addStructure(LOTRWorldGenGondorTownTrees(false), -47, -13, 2, true)
			addStructure(LOTRWorldGenGondorTownTrees(false), -47, 1, 0, true)
			for (i1 in intArrayOf(-43, -51)) {
				addStructure(LOTRWorldGenGondorTownBench(false), i1, -9, 2, true)
				addStructure(LOTRWorldGenGondorTownBench(false), i1, -3, 0, true)
			}
			addStructure(LOTRWorldGenGondorBath(false), houseX + 2, -6, 3, true)
			addStructure(LOTRWorldGenGondorTownGarden(false), 51, -13, 2, true)
			addStructure(LOTRWorldGenGondorTownGarden(false), 51, 1, 0, true)
			addStructure(LOTRWorldGenGondorTownGarden(false), 52, -6, 3, true)
			var wellX = 22
			var wellZ = 31
			for (i1 in intArrayOf(-wellX, wellX)) {
				addStructure(LOTRWorldGenGondorWell(false), i1, -wellZ, 2, true)
				addStructure(LOTRWorldGenGondorWell(false), i1, wellZ, 0, true)
				addStructure(LOTRWorldGenGondorWell(false), -wellZ, i1, 1, true)
				addStructure(LOTRWorldGenGondorWell(false), wellZ, i1, 3, true)
			}
			houseX = 54
			for (k1 in -2..2) {
				val houseZ = k1 * 12
				if (k1 == -2 || k1 >= 1) {
					addStructure(LOTRWorldGenGondorStoneHouse(false), -houseX, houseZ, 3, true)
					addStructure(LOTRWorldGenGondorStoneHouse(false), houseX, houseZ, 1, true)
				}
				addStructure(LOTRWorldGenGondorStoneHouse(false), houseZ, houseX, 2, true)
				addStructure(LOTRWorldGenGondorStoneHouse(false), houseZ, -houseX, 0, true)
			}
			var treeX = 47
			var treeZ = 35
			for (i1 in intArrayOf(-treeX, treeX)) {
				addStructure(LOTRWorldGenGondorTownTrees(false), i1, -treeZ, 0, true)
				addStructure(LOTRWorldGenGondorTownTrees(false), i1, treeZ, 2, true)
				addStructure(LOTRWorldGenGondorTownTrees(false), -treeZ, i1, 3, true)
				addStructure(LOTRWorldGenGondorTownTrees(false), treeZ, i1, 1, true)
			}
			houseX = 64
			val lampX = 59
			for (k1 in -4..4) {
				val houseZ = k1 * 12
				val treepiece: Boolean = IntMath.mod(k1, 2) == 1
				if (treepiece) {
					addStructure(LOTRWorldGenGondorVillageFarm.Tree(false), -houseX - 2, houseZ, 1, true)
					addStructure(LOTRWorldGenGondorVillageFarm.Tree(false), houseX + 2, houseZ, 3, true)
				} else {
					addStructure(LOTRWorldGenGondorStoneHouse(false), -houseX, houseZ, 1, true)
					addStructure(LOTRWorldGenGondorStoneHouse(false), houseX, houseZ, 3, true)
				}
				if (treepiece) {
					addStructure(LOTRWorldGenGondorVillageFarm.Tree(false), houseZ, -houseX - 2, 2, true)
				} else {
					addStructure(LOTRWorldGenGondorStoneHouse(false), houseZ, -houseX, 2, true)
				}
				if (abs(k1.toDouble()) >= 2 && (!outerTavern || k1 <= 2)) {
					if (treepiece) {
						addStructure(LOTRWorldGenGondorVillageFarm.Tree(false), houseZ, houseX + 2, 0, true)
					} else {
						addStructure(LOTRWorldGenGondorStoneHouse(false), houseZ, houseX, 0, true)
					}
				}
				addStructure(LOTRWorldGenGondorLampPost(false), -lampX, houseZ, 1, true)
				addStructure(LOTRWorldGenGondorLampPost(false), lampX, houseZ, 3, true)
				addStructure(LOTRWorldGenGondorLampPost(false), houseZ, lampX, 0, true)
				addStructure(LOTRWorldGenGondorLampPost(false), houseZ, -lampX, 2, true)
			}
			if (outerTavern) {
				addStructure(LOTRWorldGenGondorTavern(false), 44, houseX, 0, true)
			}
			val gardenX = 42
			val gardenZ = 48
			addStructure(LOTRWorldGenGondorVillageFarm.Tree(false), -gardenX, -gardenZ, 1, true)
			addStructure(LOTRWorldGenGondorVillageFarm.Tree(false), -gardenX, gardenZ, 1, true)
			addStructure(LOTRWorldGenGondorVillageFarm.Tree(false), gardenX, -gardenZ, 3, true)
			addStructure(LOTRWorldGenGondorVillageFarm.Tree(false), gardenX, gardenZ, 3, true)
			val obeliskX = 62
			val obeliskZ = 66
			addStructure(LOTRWorldGenGondorObelisk(false), -obeliskX, -obeliskZ, 1, true)
			addStructure(LOTRWorldGenGondorObelisk(false), -obeliskX, obeliskZ, 1, true)
			addStructure(LOTRWorldGenGondorObelisk(false), obeliskX, -obeliskZ, 3, true)
			addStructure(LOTRWorldGenGondorObelisk(false), obeliskX, obeliskZ, 3, true)
			wellX = 64
			wellZ = 57
			addStructure(LOTRWorldGenGondorWell(false), -wellX, -wellZ, 1, true)
			addStructure(LOTRWorldGenGondorWell(false), -wellX, wellZ, 1, true)
			addStructure(LOTRWorldGenGondorWell(false), wellX, -wellZ, 3, true)
			addStructure(LOTRWorldGenGondorWell(false), wellX, wellZ, 3, true)
			addStructure(LOTRWorldGenGondorWell(false), -wellZ, -wellX, 2, true)
			addStructure(LOTRWorldGenGondorWell(false), wellZ, -wellX, 2, true)
			addStructure(LOTRWorldGenGondorWell(false), -wellZ, wellX, 0, true)
			addStructure(LOTRWorldGenGondorWell(false), wellZ, wellX, 0, true)
			treeX = 75
			treeZ = 61
			addStructure(LOTRWorldGenGondorTownTrees(false), -treeX, -treeZ, 1, true)
			addStructure(LOTRWorldGenGondorTownTrees(false), -treeX, treeZ, 1, true)
			addStructure(LOTRWorldGenGondorTownTrees(false), treeX, -treeZ, 3, true)
			addStructure(LOTRWorldGenGondorTownTrees(false), treeX, treeZ, 3, true)
			addStructure(LOTRWorldGenGondorTownTrees(false), -treeZ, -treeX, 2, true)
			addStructure(LOTRWorldGenGondorTownTrees(false), treeZ, -treeX, 2, true)
			addStructure(LOTRWorldGenGondorTownTrees(false), -treeZ, treeX, 0, true)
			addStructure(LOTRWorldGenGondorTownTrees(false), treeZ, treeX, 0, true)
			addStructure(LOTRWorldGenGondorTownTrees(false), -14, 71, 1, true)
			addStructure(LOTRWorldGenGondorTownTrees(false), 14, 71, 3, true)
			for (k1 in intArrayOf(67, 75)) {
				addStructure(LOTRWorldGenGondorTownBench(false), -10, k1, 1, true)
				addStructure(LOTRWorldGenGondorTownBench(false), 10, k1, 3, true)
			}
			addStructure(LOTRWorldGenGondorGatehouse(false).setSignText(villageName), 0, 84, 2, true)
			addStructure(LOTRWorldGenGondorLampPost(false), -4, 73, 0, true)
			addStructure(LOTRWorldGenGondorLampPost(false), 4, 73, 0, true)
			val towerX = 78
			val towerZ = 74
			for (i1 in intArrayOf(-towerX, towerX)) {
				addStructure(villageWatchtower ?: return, i1, -towerZ, 2, true)
				addStructure(villageWatchtower ?: return, i1, towerZ, 0, true)
			}
			val wallZ = 82
			val wallEndX = 76
			var l: Int = 0
			while (l <= 3) {
				wallX = 12 + l * 16
				addStructure(LOTRWorldGenGondorTownWall.Left(false), -wallX, wallZ, 2, true)
				addStructure(LOTRWorldGenGondorTownWall.Right(false), wallX, wallZ, 2, true)
				++l
			}
			addStructure(LOTRWorldGenGondorTownWall.LeftEndShort(false), -wallEndX, wallZ, 2, true)
			addStructure(LOTRWorldGenGondorTownWall.RightEndShort(false), wallEndX, wallZ, 2, true)
			addStructure(LOTRWorldGenGondorTownWall.Centre(false), -wallZ, 0, 3, true)
			addStructure(LOTRWorldGenGondorTownWall.Centre(false), wallZ, 0, 1, true)
			addStructure(LOTRWorldGenGondorTownWall.Centre(false), 0, -wallZ, 0, true)
			l = 0
			while (l <= 3) {
				wallX = 12 + l * 16
				addStructure(LOTRWorldGenGondorTownWall.Left(false), -wallZ, -wallX, 3, true)
				addStructure(LOTRWorldGenGondorTownWall.Right(false), -wallZ, wallX, 3, true)
				addStructure(LOTRWorldGenGondorTownWall.Left(false), wallZ, wallX, 1, true)
				addStructure(LOTRWorldGenGondorTownWall.Right(false), wallZ, -wallX, 1, true)
				addStructure(LOTRWorldGenGondorTownWall.Left(false), wallX, -wallZ, 0, true)
				addStructure(LOTRWorldGenGondorTownWall.Right(false), -wallX, -wallZ, 0, true)
				++l
			}
			addStructure(LOTRWorldGenGondorTownWall.LeftEnd(false), -wallZ, -wallEndX, 3, true)
			addStructure(LOTRWorldGenGondorTownWall.RightEnd(false), -wallZ, wallEndX, 3, true)
			addStructure(LOTRWorldGenGondorTownWall.LeftEnd(false), wallZ, wallEndX, 1, true)
			addStructure(LOTRWorldGenGondorTownWall.RightEnd(false), wallZ, -wallEndX, 1, true)
			addStructure(LOTRWorldGenGondorTownWall.LeftEndShort(false), wallEndX, -wallZ, 0, true)
			addStructure(LOTRWorldGenGondorTownWall.RightEndShort(false), -wallEndX, -wallZ, 0, true)
		}

		private fun setupVillage(random: Random) {
			addStructure(LOTRWorldGenGondorWell(false), 0, -4, 0, true)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(LOTREntityGondorMan::class.java)
					spawner.setCheckRanges(40, -12, 12, 40)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(object : LOTRWorldGenNPCRespawner(false) {
				override fun setupRespawner(spawner: LOTREntityNPCRespawner) {
					spawner.setSpawnClass(villageFief.levyClasses[0])
					spawner.setCheckRanges(40, -12, 12, 16)
					spawner.setSpawnRanges(20, -6, 6, 64)
					spawner.setBlockEnemySpawnRange(60)
				}
			}, 0, 0, 0)
			addStructure(LOTRWorldGenGondorCottage(false), -21, 0, 1)
			addStructure(LOTRWorldGenGondorCottage(false), 0, -21, 2)
			addStructure(LOTRWorldGenGondorCottage(false), 21, 0, 3)
			addStructure(LOTRWorldGenGondorTavern(false), 0, 21, 0)
			if (random.nextBoolean()) {
				if (random.nextInt(3) == 0) {
					addStructure(LOTRWorldGenGondorMarketStall.getRandomStall(random, false), -9, -12, 1)
				}
				if (random.nextInt(3) == 0) {
					addStructure(LOTRWorldGenGondorMarketStall.getRandomStall(random, false), 9, -12, 3)
				}
				if (random.nextInt(3) == 0) {
					addStructure(LOTRWorldGenGondorMarketStall.getRandomStall(random, false), -9, 12, 1)
				}
				if (random.nextInt(3) == 0) {
					addStructure(LOTRWorldGenGondorMarketStall.getRandomStall(random, false), 9, 12, 3)
				}
			}
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
					addStructure(getRandomHouse(random), i, k, r)
					continue
				}
				if (random.nextInt(3) == 0) {
					continue
				}
				l = 65
				i = Math.round(l * cos)
				k = Math.round(l * sin)
				addStructure(LOTRWorldGenHayBales(false), i, k, r)
			}
			val signPos = Math.round(50.0f * MathHelper.cos(0.7853982f))
			val signDisp = Math.round(7.0f * MathHelper.cos(0.7853982f))
			addStructure(
				LOTRWorldGenGondorVillageSign(false).setSignText(villageName), -signPos, -signPos + signDisp, 1
			)
			addStructure(LOTRWorldGenGondorVillageSign(false).setSignText(villageName), signPos, -signPos + signDisp, 3)
			addStructure(LOTRWorldGenGondorVillageSign(false).setSignText(villageName), -signPos, signPos - signDisp, 1)
			addStructure(LOTRWorldGenGondorVillageSign(false).setSignText(villageName), signPos, signPos - signDisp, 3)
			val farmX = 38
			val farmZ = 17
			val farmSize = 6
			if (random.nextBoolean()) {
				addStructure(getRandomFarm(random), -farmX + farmSize, -farmZ, 1)
			}
			if (random.nextBoolean()) {
				addStructure(getRandomFarm(random), -farmZ + farmSize, -farmX, 1)
			}
			if (random.nextBoolean()) {
				addStructure(getRandomFarm(random), farmX - farmSize, -farmZ, 3)
			}
			if (random.nextBoolean()) {
				addStructure(getRandomFarm(random), farmZ - farmSize, -farmX, 3)
			}
			if (random.nextBoolean()) {
				addStructure(getRandomFarm(random), -farmX + farmSize, farmZ, 1)
			}
			if (random.nextBoolean()) {
				addStructure(getRandomFarm(random), farmX - farmSize, farmZ, 3)
			}
		}

		override fun setupVillageProperties(random: Random) {
			villageName = LOTRNames.getGondorVillageName(random)
			villageType =
				if (random.nextInt(4) == 0) VillageType.FORT else if (random.nextInt(4) == 0) VillageType.TOWN else VillageType.VILLAGE
		}
	}
}
