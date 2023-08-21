package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityDwarfCommander
import lotr.common.entity.npc.LOTREntityNPC
import net.minecraft.block.Block
import net.minecraft.world.World

class StructureTowerDwarven(flag: Boolean) : StructureTowerBase(flag) {
	override fun getBrick(): Pair<Block, Int> = Pair(LOTRMod.brick, 6)

	override fun getSecondaryBrick(): Pair<Block, Int> = Pair(LOTRMod.scorchedStone, 0)

	override fun getWall(): Pair<Block, Int> = Pair(LOTRMod.wall, 7)

	override fun getStairs(): Block = LOTRMod.stairsDwarvenBrick

	override fun getBars(): Block = LOTRMod.dwarfBars

	override fun getCaptain(world: World): LOTREntityNPC = LOTREntityDwarfCommander(world)

	override fun getSections(): Int = 7

	override fun enableSpires(): Boolean = false
}