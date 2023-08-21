package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityGaladhrimLord
import lotr.common.entity.npc.LOTREntityNPC
import net.minecraft.block.Block
import net.minecraft.world.World

class StructureTowerLothlorien(flag: Boolean) : StructureTowerBase(flag) {
	override fun getBrick(): Pair<Block, Int> = Pair(LOTRMod.brick, 11)

	override fun getSecondaryBrick(): Pair<Block, Int> = Pair(LOTRMod.scorchedStone, 0)

	override fun getWall(): Pair<Block, Int> = Pair(LOTRMod.wall, 10)

	override fun getStairs(): Block = LOTRMod.stairsElvenBrick

	override fun getBars(): Block = LOTRMod.galadhrimBars

	override fun getCaptain(world: World): LOTREntityNPC = LOTREntityGaladhrimLord(world)

	override fun getSections(): Int = 7

	override fun enableSpires(): Boolean = false
}