package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityNPC
import lotr.common.entity.npc.LOTREntityRivendellLord
import net.minecraft.block.Block
import net.minecraft.world.World

class StructureRivendellTower(flag: Boolean) : StructureTowerBase(flag) {
	override fun getBrick(): Pair<Block, Int> = Pair(LOTRMod.brick3, 2)

	override fun getSecondaryBrick(): Pair<Block, Int> = Pair(LOTRMod.pillar, 10)

	override fun getWall(): Pair<Block, Int> = Pair(LOTRMod.wall2, 11)

	override fun getStairs(): Block = LOTRMod.stairsHighElvenBrick

	override fun getBars(): Block = LOTRMod.highElfBars

	override fun getCaptain(world: World): LOTREntityNPC = LOTREntityRivendellLord(world)

	override fun getSections(): Int = 7

	override fun enableSpires(): Boolean = false
}