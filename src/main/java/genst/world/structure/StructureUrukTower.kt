package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityUrukHaiMercenaryCaptain
import net.minecraft.block.Block
import net.minecraft.entity.EntityCreature
import net.minecraft.world.World

class StructureUrukTower(flag: Boolean) : StructureTowerBase(flag) {
	override fun getBarsBlock(): Block = LOTRMod.urukBars

	override fun getBrickBlock(): Block = LOTRMod.brick2

	override fun getBrickMeta() = 7

	override fun getWallBlock(): Block = LOTRMod.wall2

	override fun getWallMeta() = 7

	override fun getCaptain(world: World): EntityCreature = LOTREntityUrukHaiMercenaryCaptain(world)

	override fun getSecondaryBrick(): Block = LOTRMod.scorchedStone

	override fun getStairsBlock(): Block = LOTRMod.stairsUrukBrick

	override fun getSections() = 7
}