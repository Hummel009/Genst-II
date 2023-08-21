package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityNPC
import net.minecraft.block.Block
import net.minecraft.world.World

class StructureTowerRedDwarven(flag: Boolean) : StructureTowerBase(flag) {
	override fun getBrick(): Pair<Block, Int> = Pair(LOTRMod.brick2, 2)

	override fun getSecondaryBrick(): Pair<Block, Int> = Pair(LOTRMod.scorchedStone, 0)

	override fun getWall(): Pair<Block, Int> = Pair(LOTRMod.wall2, 3)

	override fun getStairs(): Block = LOTRMod.stairsRedRockBrick

	override fun getBars(): Block = LOTRMod.bronzeBars

	override fun getCaptain(world: World): LOTREntityNPC? = null

	override fun getSections(): Int = 7

	override fun enableSpires(): Boolean = false
}