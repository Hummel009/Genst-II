package genst.world.settlement

import lotr.common.block.*
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.block.BlockStone
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*

open class GenstSingle : LOTRVillageGen(LOTRBiome.forodwaith) {
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

	open class Instance(
		village: GenstSingle, world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	) : AbstractInstance<GenstSingle>(village, world, i, k, random, loc) {

		override fun addVillageStructures(random: Random) {}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? = null

		override fun isFlat(): Boolean = false

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			return block is LOTRBlockBrickBase || block is LOTRBlockSlabBase || block is LOTRBlockRock || block is LOTRBlockGrass || block is LOTRBlockDirtPath || block is BlockStone || block is LOTRBlockWaste || block == Blocks.cobblestone
		}

		override fun setupVillageProperties(random: Random) {}
	}
}