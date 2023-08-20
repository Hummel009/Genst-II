package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityNPC
import lotr.common.entity.npc.LOTREntityWoodElfCaptain
import net.minecraft.block.Block
import net.minecraft.world.World

class StructureWoodElvenTower(flag: Boolean) : StructureTowerBase(flag) {
	override fun getBrick(): Pair<Block, Int> = Pair(LOTRMod.brick3, 5)

	override fun getSecondaryBrick(): Pair<Block, Int> = Pair(LOTRMod.scorchedStone, 0)

	override fun getWall(): Pair<Block, Int> = Pair(LOTRMod.wall3, 0)

	override fun getStairs(): Block = LOTRMod.stairsWoodElvenBrick

	override fun getBars(): Block = LOTRMod.woodElfBars

	override fun getCaptain(world: World): LOTREntityNPC = LOTREntityWoodElfCaptain(world)

	override fun getSections(): Int = 7

	override fun enableSpires(): Boolean = false
}