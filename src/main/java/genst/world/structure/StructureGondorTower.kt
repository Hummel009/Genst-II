package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityDolGuldurOrcChieftain
import lotr.common.entity.npc.LOTREntityGondorianCaptain
import lotr.common.entity.npc.LOTREntityMordorOrcMercenaryCaptain
import net.minecraft.block.Block
import net.minecraft.entity.EntityCreature
import net.minecraft.init.Blocks
import net.minecraft.world.World

class StructureGondorTower(flag: Boolean) : StructureTowerBase(flag) {
	override fun getBarsBlock(): Block = Blocks.iron_bars

	override fun getBrickBlock(): Block = LOTRMod.brick

	override fun getBrickMeta() = 1

	override fun getWallBlock(): Block = LOTRMod.wall

	override fun getWallMeta() = 3

	override fun getCaptain(world: World): EntityCreature = LOTREntityGondorianCaptain(world)

	override fun getSecondaryBrick(): Block = LOTRMod.scorchedStone

	override fun getStairsBlock(): Block = LOTRMod.stairsGondorBrick

	override fun getSections() = 5
}