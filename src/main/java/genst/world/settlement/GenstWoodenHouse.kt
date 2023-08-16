package genst.world.settlement

import genst.world.structure.StructureWoodenHouse
import lotr.common.block.*
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.block.BlockStone
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*

class GenstWoodenHouse : LOTRVillageGen(LOTRBiome.forodwaith) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = 2
		fixedVillageChunkRadius = 0
	}

	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> {
		return Instance(this, world, i, k, random, loc)
	}

	class Instance(
		village: GenstWoodenHouse?, world: World?, i: Int, k: Int, random: Random?, loc: LocationInfo?
	) : AbstractInstance<GenstWoodenHouse?>(village, world, i, k, random, loc) {
		override fun addVillageStructures(random: Random) {
			addStructure(StructureWoodenHouse(false), 0, 0, 0, true)
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

		override fun setupVillageProperties(random: Random) {}
	}
}