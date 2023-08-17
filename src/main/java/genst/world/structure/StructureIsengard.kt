package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityDolGuldurOrcChieftain
import lotr.common.entity.npc.LOTREntityUrukHaiMercenaryCaptain
import net.minecraft.block.Block
import net.minecraft.entity.EntityCreature
import net.minecraft.world.World

object StructureIsengard : StructureTowerBase(false) {
	override fun getCommander(world: World): EntityCreature = LOTREntityUrukHaiMercenaryCaptain(world)

	override fun getSecondaryBrick(): Block = LOTRMod.scorchedStone

	override fun getSections(): Int = 9

	override fun placeWall(world: World, i: Int, j: Int, k: Int) {
		setBlockAndMetadata(world, i, j, k, LOTRMod.wall2, 10)
	}

	override fun placeBrick(world: World, i: Int, j: Int, k: Int) {
		setBlockAndMetadata(world, i, j, k, LOTRMod.brick2, 11)
	}

	override fun placeStairs(world: World, i: Int, j: Int, k: Int, meta: Int) {
		setBlockAndMetadata(world, i, j, k, LOTRMod.stairsBlackGondorBrick, meta)
	}
}