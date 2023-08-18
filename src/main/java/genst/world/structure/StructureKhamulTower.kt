package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityEasterlingWarlord
import net.minecraft.block.Block
import net.minecraft.entity.EntityCreature
import net.minecraft.world.World

object StructureKhamulTower : StructureTowerBase(false) {
	override fun getBarsBlock(): Block = LOTRMod.goldBars

	override fun getStairsBlock(): Block = LOTRMod.stairsRhunBrick

	override fun getBrickBlock(): Block = LOTRMod.brick5

	override fun getBrickMeta() = 11

	override fun getWallBlock(): Block = LOTRMod.wall3

	override fun getWallMeta() = 15

	override fun getCaptain(world: World): EntityCreature = LOTREntityEasterlingWarlord(world)

	override fun getSecondaryBrick(): Block = LOTRMod.brick6

	override fun getSections() = 9
}