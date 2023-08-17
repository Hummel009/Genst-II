package genst.world.structure

import lotr.common.LOTRMod
import net.minecraft.world.World
import java.util.*

object StructureUrukTower : StructureTowerBase() {
	override fun placeRandomBrick(world: World?, random: Random, i: Int, j: Int, k: Int) {
		setBlockAndMetadata(world, i, j, k, LOTRMod.brick2, 7)
	}

	override fun placeRandomStairs(world: World?, random: Random, i: Int, j: Int, k: Int, meta: Int) {
		setBlockAndMetadata(world, i, j, k, LOTRMod.stairsUrukBrick, meta)
	}
}