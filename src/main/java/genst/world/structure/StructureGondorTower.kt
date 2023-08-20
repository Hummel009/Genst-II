package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityGondorianCaptain
import lotr.common.entity.npc.LOTREntityNPC
import net.minecraft.block.Block
import net.minecraft.init.Blocks
import net.minecraft.world.World

class StructureGondorTower(flag: Boolean) : StructureTowerBase(flag) {
	override fun getBrick(): Pair<Block, Int> = Pair(LOTRMod.brick, 1)

	override fun getSecondaryBrick(): Pair<Block, Int> = Pair(LOTRMod.scorchedStone, 0)

	override fun getWall(): Pair<Block, Int> = Pair(LOTRMod.wall, 3)

	override fun getStairs(): Block = LOTRMod.stairsGondorBrick

	override fun getBars(): Block = Blocks.iron_bars

	override fun getCaptain(world: World): LOTREntityNPC = LOTREntityGondorianCaptain(world)

	override fun getSections(): Int = 7

	override fun enableSpires(): Boolean = false
}