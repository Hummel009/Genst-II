package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityBlueDwarfCommander
import lotr.common.entity.npc.LOTREntityNPC
import net.minecraft.block.Block
import net.minecraft.world.World

class StructureBlueDwarvenTower(flag: Boolean) : StructureTowerBase(flag) {
	override fun getBrick(): Pair<Block, Int> = Pair(LOTRMod.brick, 14)

	override fun getSecondaryBrick(): Pair<Block, Int> = Pair(LOTRMod.scorchedStone, 0)

	override fun getWall(): Pair<Block, Int> = Pair(LOTRMod.wall, 14)

	override fun getStairs(): Block = LOTRMod.stairsBlueRockBrick

	override fun getBars(): Block = LOTRMod.blueDwarfBars

	override fun getCaptain(world: World): LOTREntityNPC = LOTREntityBlueDwarfCommander(world)

	override fun getSections(): Int = 7

	override fun enableSpires(): Boolean = false
}