package genst.world.settlement

import genst.world.GenstRoads
import genst.world.structure.StructureRuinedTower
import lotr.common.block.*
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.LOTRWorldGenNumenorRuin
import lotr.common.world.structure2.LOTRWorldGenStoneRuin.STONE
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.block.BlockStone
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs

open class GenstRuinedCity(
	radius: Int = 6
) : LOTRVillageGen(LOTRBiome.forodwaith) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = radius
		fixedVillageChunkRadius = radius
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> {
		return Instance(this, world, i, k, random, loc)
	}

	open class Instance(
		village: GenstRuinedCity?, world: World?, i: Int, k: Int, random: Random?, loc: LocationInfo?
	) : AbstractInstance<GenstRuinedCity?>(village, world, i, k, random, loc) {

		override fun addVillageStructures(random: Random) {
			var marketZ: Int
			if (random.nextBoolean()) {
				addStructure(STONE(5, 7), 0, 10, 2, true)
			} else {
				addStructure(STONE(5, 7), 0, 6, 2, true)
			}
			val mansionX = 12
			val mansionZ = 20
			addStructure(StructureRuinedTower(false), 0, 0, 2, true)
			addStructure(LOTRWorldGenNumenorRuin(false), -mansionX, -mansionZ, 2, true)
			addStructure(LOTRWorldGenNumenorRuin(false), mansionX, -mansionZ, 2, true)
			addStructure(LOTRWorldGenNumenorRuin(false), -mansionX, mansionZ, 0, true)
			addStructure(LOTRWorldGenNumenorRuin(false), mansionX, mansionZ, 0, true)
			addStructure(LOTRWorldGenNumenorRuin(false), -mansionZ, -mansionX, 1, true)
			addStructure(LOTRWorldGenNumenorRuin(false), -mansionZ, mansionX, 1, true)
			addStructure(LOTRWorldGenNumenorRuin(false), mansionZ, -mansionX, 3, true)
			addStructure(LOTRWorldGenNumenorRuin(false), mansionZ, mansionX, 3, true)
			for (l in 0..3) {
				val houseX = 10 + 14 * l
				val houseZ1 = 58
				val houseZ2 = 68
				if (l <= 2) {
					if (l >= 1) {
						if (l == 1) {
							addStructure(LOTRWorldGenNumenorRuin(false), -houseX - 7, -houseZ1, 0, true)
						}
					} else {
						addStructure(LOTRWorldGenNumenorRuin(false), -houseX, -houseZ1, 0, true)
					}
					addStructure(LOTRWorldGenNumenorRuin(false), houseX, -houseZ1, 0, true)
					if (l >= 1) {
						addStructure(LOTRWorldGenNumenorRuin(false), -houseX, houseZ1, 2, true)
						addStructure(LOTRWorldGenNumenorRuin(false), houseX, houseZ1, 2, true)
					}
					addStructure(LOTRWorldGenNumenorRuin(false), -houseZ1, -houseX, 3, true)
					addStructure(LOTRWorldGenNumenorRuin(false), -houseZ1, houseX, 3, true)
					addStructure(LOTRWorldGenNumenorRuin(false), houseZ1, -houseX, 1, true)
					addStructure(LOTRWorldGenNumenorRuin(false), houseZ1, houseX, 1, true)
				}
				if (l == 1) {
					addStructure(STONE(5, 7), -houseX, -houseZ2, 2, true)
					addStructure(STONE(5, 7), houseX, -houseZ2, 2, true)
					addStructure(STONE(5, 7), -houseX, houseZ2, 0, true)
					addStructure(STONE(5, 7), houseX, houseZ2, 0, true)
					addStructure(STONE(5, 7), -houseZ2, -houseX, 1, true)
					addStructure(STONE(5, 7), -houseZ2, houseX, 1, true)
					addStructure(STONE(5, 7), houseZ2, -houseX, 3, true)
					addStructure(STONE(5, 7), houseZ2, houseX, 3, true)
					continue
				}
				addStructure(LOTRWorldGenNumenorRuin(false), -houseX, -houseZ2, 2, true)
				addStructure(LOTRWorldGenNumenorRuin(false), houseX, -houseZ2, 2, true)
				addStructure(LOTRWorldGenNumenorRuin(false), -houseX, houseZ2, 0, true)
				addStructure(LOTRWorldGenNumenorRuin(false), houseX, houseZ2, 0, true)
				addStructure(LOTRWorldGenNumenorRuin(false), -houseZ2, -houseX, 1, true)
				addStructure(LOTRWorldGenNumenorRuin(false), -houseZ2, houseX, 1, true)
				addStructure(LOTRWorldGenNumenorRuin(false), houseZ2, -houseX, 3, true)
				addStructure(LOTRWorldGenNumenorRuin(false), houseZ2, houseX, 3, true)
			}
			var marketX = 4
			for (l in 0..2) {
				marketZ = 56 - l * 7
				addStructure(STONE(5, 7), -marketX, marketZ, 1, true)
				addStructure(STONE(5, 7), marketX, marketZ, 3, true)
			}
			marketX = 14
			marketZ = 59
			addStructure(STONE(5, 7), -marketX, marketZ, 2, true)
			addStructure(STONE(5, 7), marketX, marketZ, 2, true)
			val gardenX = 58
			addStructure(STONE(5, 7), -gardenX + 5, -gardenX, 0, true)
			addStructure(STONE(5, 7), gardenX - 5, -gardenX, 0, true)
			addStructure(STONE(5, 7), -gardenX + 5, gardenX, 2, true)
			addStructure(STONE(5, 7), gardenX - 5, gardenX, 2, true)
			val wellX = 69
			val wellZ = 63
			addStructure(STONE(5, 7), -wellX, -wellZ, 1, true)
			addStructure(STONE(5, 7), -wellZ, -wellX, 2, true)
			addStructure(STONE(5, 7), wellX, -wellZ, 3, true)
			addStructure(STONE(5, 7), wellZ, -wellX, 2, true)
			addStructure(STONE(5, 7), -wellX, wellZ, 1, true)
			addStructure(STONE(5, 7), -wellZ, wellX, 0, true)
			addStructure(STONE(5, 7), wellX, wellZ, 3, true)
			addStructure(STONE(5, 7), wellZ, wellX, 0, true)
		}

		open fun getRoadType(): LOTRRoadType = GenstRoads.PATH_COBBLE

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			val i1 = abs(i.toDouble()).toInt()
			val k1 = abs(k.toDouble()).toInt()
			val innerOut = 18
			if (i1 <= innerOut && k1 <= innerOut && (i1 >= 12 || k1 >= 12)) {
				return getRoadType()
			}
			if (i1 <= 3 && k1 >= innerOut && k1 <= 86 || k1 <= 3 && i1 >= innerOut && i1 <= 86) {
				return getRoadType()
			}
			val outerOut = 66
			return if (i1 <= outerOut && k1 <= outerOut && (i1 >= 60 || k1 >= 60)) {
				getRoadType()
			} else null
		}

		override fun isFlat() = false

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			return block is LOTRBlockBrickBase || block is LOTRBlockSlabBase || block is LOTRBlockRock || block is LOTRBlockGrass || block is LOTRBlockDirtPath || block is BlockStone || block == Blocks.cobblestone
		}

		override fun setupVillageProperties(random: Random) {}
	}
}
