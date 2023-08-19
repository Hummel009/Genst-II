package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityDolGuldurOrcChieftain
import net.minecraft.block.Block
import net.minecraft.entity.EntityCreature
import net.minecraft.world.World

class StructureDolGuldurTower(flag: Boolean) : StructureTowerBase(flag) {
	override fun getBarsBlock(): Block = LOTRMod.orcSteelBars

	override fun getBrickBlock(): Block = LOTRMod.brick2

	override fun getBrickMeta(): Int = 8

	override fun getWallBlock(): Block = LOTRMod.wall2

	override fun getWallMeta(): Int = 8

	override fun getCaptain(world: World): EntityCreature = LOTREntityDolGuldurOrcChieftain(world)

	override fun getSecondaryBrick(): Block = LOTRMod.scorchedStone

	override fun getStairsBlock(): Block = LOTRMod.stairsDolGuldurBrick

	override fun getSections(): Int = 7
}