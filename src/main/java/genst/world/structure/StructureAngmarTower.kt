package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityAngmarOrcMercenaryCaptain
import net.minecraft.block.Block
import net.minecraft.entity.EntityCreature
import net.minecraft.world.World

class StructureAngmarTower(flag: Boolean) : StructureTowerBase(flag) {
	override fun getBrick(): Pair<Block, Int> = Pair(LOTRMod.brick2, 0)

	override fun getSecondaryBrick(): Pair<Block, Int> = Pair(LOTRMod.scorchedStone, 0)

	override fun getWall(): Pair<Block, Int> = Pair(LOTRMod.wall2, 0)

	override fun getStairs(): Block = LOTRMod.stairsAngmarBrick

	override fun getBars(): Block = LOTRMod.orcSteelBars

	override fun getCaptain(world: World): EntityCreature = LOTREntityAngmarOrcMercenaryCaptain(world)

	override fun getSections(): Int = 5
}