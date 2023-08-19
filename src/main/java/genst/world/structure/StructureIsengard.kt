package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityUrukHaiMercenaryCaptain
import net.minecraft.block.Block
import net.minecraft.entity.EntityCreature
import net.minecraft.init.Blocks
import net.minecraft.world.World

object StructureIsengard : StructureTowerBase(false) {
	override fun getBarsBlock(): Block = Blocks.iron_bars

	override fun getStairsBlock(): Block = LOTRMod.stairsBlackGondorBrick

	override fun getBrickBlock(): Block = LOTRMod.brick2

	override fun getBrickMeta(): Int = 11

	override fun getWallBlock(): Block = LOTRMod.wall2

	override fun getWallMeta(): Int = 10

	override fun getCaptain(world: World): EntityCreature = LOTREntityUrukHaiMercenaryCaptain(world)

	override fun getSecondaryBrick(): Block = LOTRMod.scorchedStone

	override fun getSections(): Int = 9
}