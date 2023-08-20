package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityEasterlingWarlord
import lotr.common.entity.npc.LOTREntityNPC
import net.minecraft.block.Block
import net.minecraft.world.World

object StructureKhamulTower : StructureTowerBase(false) {
	override fun getBrick(): Pair<Block, Int> = Pair(LOTRMod.brick5, 11)

	override fun getSecondaryBrick(): Pair<Block, Int> = Pair(LOTRMod.brick6, 0)

	override fun getWall(): Pair<Block, Int> = Pair(LOTRMod.wall3, 15)

	override fun getStairs(): Block = LOTRMod.stairsRhunBrick

	override fun getBars(): Block = LOTRMod.goldBars

	override fun getCaptain(world: World): LOTREntityNPC = LOTREntityEasterlingWarlord(world)

	override fun getSections(): Int = 9

	override fun enableSpires(): Boolean = true
}