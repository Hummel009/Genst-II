package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityDolGuldurOrcChieftain
import lotr.common.entity.npc.LOTREntityNPC
import net.minecraft.block.Block
import net.minecraft.world.World

class StructureDolGuldurTower(flag: Boolean) : StructureTowerBase(flag) {
	override fun getBrick(): Pair<Block, Int> = Pair(LOTRMod.brick2, 8)

	override fun getSecondaryBrick(): Pair<Block, Int> = Pair(LOTRMod.scorchedStone, 0)

	override fun getWall(): Pair<Block, Int> = Pair(LOTRMod.wall2, 8)

	override fun getStairs(): Block = LOTRMod.stairsDolGuldurBrick

	override fun getBars(): Block = LOTRMod.orcSteelBars

	override fun getCaptain(world: World): LOTREntityNPC = LOTREntityDolGuldurOrcChieftain(world)

	override fun getSections(): Int = 7

	override fun enableSpires(): Boolean = true
}