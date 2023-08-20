package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityNPC
import lotr.common.entity.npc.LOTREntityUrukHaiMercenaryCaptain
import net.minecraft.block.Block
import net.minecraft.init.Blocks
import net.minecraft.world.World

object StructureIsengard : StructureTowerBase(false) {
	override fun getBrick(): Pair<Block, Int> = Pair(LOTRMod.brick2, 11)

	override fun getSecondaryBrick(): Pair<Block, Int> = Pair(LOTRMod.scorchedStone, 0)

	override fun getWall(): Pair<Block, Int> = Pair(LOTRMod.wall2, 10)

	override fun getStairs(): Block = LOTRMod.stairsBlackGondorBrick

	override fun getBars(): Block = Blocks.iron_bars

	override fun getCaptain(world: World): LOTREntityNPC = LOTREntityUrukHaiMercenaryCaptain(world)

	override fun getSections(): Int = 9

	override fun enableSpires(): Boolean = true
}