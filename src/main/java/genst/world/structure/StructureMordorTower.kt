package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityMordorOrcMercenaryCaptain
import net.minecraft.block.Block
import net.minecraft.entity.EntityCreature
import net.minecraft.world.World

class StructureMordorTower(flag: Boolean) : StructureTowerBase(flag) {
	override fun getBrick(): Pair<Block, Int> = Pair(LOTRMod.brick, 0)

	override fun getSecondaryBrick(): Pair<Block, Int> = Pair(LOTRMod.guldurilBrick, 0)

	override fun getWall(): Pair<Block, Int> = Pair(LOTRMod.wall, 1)

	override fun getStairs(): Block = LOTRMod.stairsMordorBrick

	override fun getBars(): Block = LOTRMod.orcSteelBars

	override fun getCaptain(world: World): EntityCreature = LOTREntityMordorOrcMercenaryCaptain(world)

	override fun getSections(): Int = 7
}