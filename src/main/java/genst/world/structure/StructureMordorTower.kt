package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityMordorOrcMercenaryCaptain
import net.minecraft.block.Block
import net.minecraft.entity.EntityCreature
import net.minecraft.world.World

class StructureMordorTower(flag: Boolean) : StructureTowerBase(flag) {
	override fun getBarsBlock(): Block = LOTRMod.orcSteelBars

	override fun getBrickBlock(): Block = LOTRMod.brick

	override fun getBrickMeta(): Int = 0

	override fun getWallBlock(): Block = LOTRMod.wall

	override fun getWallMeta(): Int = 1

	override fun getCaptain(world: World): EntityCreature = LOTREntityMordorOrcMercenaryCaptain(world)

	override fun getSecondaryBrick(): Block = LOTRMod.guldurilBrick

	override fun getStairsBlock(): Block = LOTRMod.stairsMordorBrick

	override fun getSections(): Int = 7
}