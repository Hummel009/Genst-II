package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityAngmarOrcMercenaryCaptain
import net.minecraft.block.Block
import net.minecraft.entity.EntityCreature
import net.minecraft.world.World

class StructureAngmarTower(flag: Boolean) : StructureTowerBase(flag) {
	override fun getBrickBlock(): Block = LOTRMod.brick2

	override fun getBrickMeta() = 0

	override fun getWallBlock(): Block = LOTRMod.wall2

	override fun getWallMeta() = 0

	override fun getCaptain(world: World): EntityCreature = LOTREntityAngmarOrcMercenaryCaptain(world)

	override fun getSecondaryBrick(): Block = LOTRMod.scorchedStone

	override fun getStairsBlock(): Block = LOTRMod.stairsAngmarBrick

	override fun getSections(): Int = 5
}