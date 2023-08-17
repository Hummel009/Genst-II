package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityUrukHaiMercenaryCaptain
import net.minecraft.block.Block
import net.minecraft.entity.EntityCreature
import net.minecraft.world.World

object StructureIsengard : StructureTowerBase(false) {
	override fun getStairsBlock(): Block = LOTRMod.stairsBlackGondorBrick

	override fun getBrickMeta() = 11

	override fun getBrickBlock(): Block = LOTRMod.brick2

	override fun getWallBlock(): Block = LOTRMod.wall2

	override fun getWallMeta() = 10

	override fun getCaptain(world: World): EntityCreature = LOTREntityUrukHaiMercenaryCaptain(world)

	override fun getSecondaryBrick(): Block = LOTRMod.scorchedStone

	override fun getSections() = 9
}