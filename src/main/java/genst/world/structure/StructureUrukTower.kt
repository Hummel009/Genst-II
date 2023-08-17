package genst.world.structure

import lotr.common.LOTRMod
import net.minecraft.block.Block
import net.minecraft.world.World
import java.util.*

object StructureUrukTower : StructureTowerBase() {
	override fun getSections(): Int = 4

	override fun placeWall(world: World, i: Int, j: Int, k: Int) {
		setBlockAndMetadata(world, i, j, k, LOTRMod.wall2, 7)
	}

	override fun placeBrick(world: World, random: Random, i: Int, j: Int, k: Int) {
		setBlockAndMetadata(world, i, j, k, LOTRMod.brick2, 7)
	}

	override fun placeStairs(world: World, random: Random, i: Int, j: Int, k: Int, meta: Int) {
		setBlockAndMetadata(world, i, j, k, LOTRMod.stairsUrukBrick, meta)
	}
}