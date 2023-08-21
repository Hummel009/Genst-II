package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityMordorOrcMercenaryCaptain
import lotr.common.entity.npc.LOTREntityNPC
import net.minecraft.block.Block
import net.minecraft.world.World

class StructureTowerMordor(flag: Boolean) : StructureTowerBase(flag) {
	override fun getBrick(): Pair<Block, Int> = Pair(LOTRMod.brick, 0)

	override fun getSecondaryBrick(): Pair<Block, Int> = Pair(LOTRMod.guldurilBrick, 0)

	override fun getWall(): Pair<Block, Int> = Pair(LOTRMod.wall, 1)

	override fun getStairs(): Block = LOTRMod.stairsMordorBrick

	override fun getBars(): Block = LOTRMod.orcSteelBars

	override fun getCaptain(world: World): LOTREntityNPC = LOTREntityMordorOrcMercenaryCaptain(world)

	override fun getSections(): Int = 7

	override fun enableSpires(): Boolean = true
}