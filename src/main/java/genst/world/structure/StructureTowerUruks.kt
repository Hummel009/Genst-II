package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityNPC
import lotr.common.entity.npc.LOTREntityUrukHaiMercenaryCaptain
import net.minecraft.block.Block
import net.minecraft.world.World

class StructureTowerUruks(flag: Boolean) : StructureTowerBase(flag) {
	override fun getBrick(): Pair<Block, Int> = Pair(LOTRMod.brick2, 7)

	override fun getSecondaryBrick(): Pair<Block, Int> = Pair(LOTRMod.scorchedStone, 0)

	override fun getWall(): Pair<Block, Int> = Pair(LOTRMod.wall2, 7)

	override fun getStairs(): Block = LOTRMod.stairsUrukBrick

	override fun getBars(): Block = LOTRMod.urukBars

	override fun getCaptain(world: World): LOTREntityNPC = LOTREntityUrukHaiMercenaryCaptain(world)

	override fun getSections(): Int = 7

	override fun enableSpires(): Boolean = true
}