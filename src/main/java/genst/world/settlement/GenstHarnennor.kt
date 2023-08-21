package genst.world.settlement

import lotr.common.block.*
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.village.LOTRVillageGenHarnedor
import lotr.common.world.village.LocationInfo
import net.minecraft.block.BlockDirt
import net.minecraft.block.BlockSand
import net.minecraft.block.BlockSandStone
import net.minecraft.block.BlockStone
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*

open class GenstHarnennor : LOTRVillageGenHarnedor(LOTRBiome.forodwaith, 0.0f) {
	init {
		gridScale = 12
		gridRandomDisplace = 1
		spawnChance = 0.0f
		villageChunkRadius = 6
		fixedVillageChunkRadius = 6
	}

	open class Instance(
		village: LOTRVillageGenHarnedor, world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	) : LOTRVillageGenHarnedor.Instance(village, world, i, k, random, loc) {

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			val block = world.getBlock(i, j, k)
			return block is LOTRBlockBrickBase || block is LOTRBlockSlabBase || block is LOTRBlockRock || block is LOTRBlockGrass || block is LOTRBlockDirtPath || block is BlockStone || block is BlockSand || block is BlockDirt || block is BlockSandStone || block == Blocks.cobblestone
		}

		override fun isFlat(): Boolean = false
	}
}