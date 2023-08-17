package genst.world.structure

import lotr.common.LOTRMod
import net.minecraft.world.World
import java.util.*

object StructureIsengard : StructureTowerBase() {
	override fun getSections(): Int = 9

	override fun placeWall(world: World, i: Int, j: Int, k: Int) {
		setBlockAndMetadata(world, i, j, k, LOTRMod.wall2, 10)
	}

	override fun placeBrick(world: World, random: Random, i: Int, j: Int, k: Int) {
		setBlockAndMetadata(world, i, j, k, LOTRMod.brick2, 11)
	}

	override fun placeStairs(world: World, random: Random, i: Int, j: Int, k: Int, meta: Int) {
		setBlockAndMetadata(world, i, j, k, LOTRMod.stairsBlackGondorBrick, meta)
	}
}