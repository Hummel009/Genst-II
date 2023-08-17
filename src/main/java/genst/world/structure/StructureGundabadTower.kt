package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityAngmarOrcMercenaryCaptain
import lotr.common.entity.npc.LOTREntityGundabadOrcMercenaryCaptain
import net.minecraft.block.Block
import net.minecraft.entity.EntityCreature
import net.minecraft.world.World

class StructureGundabadTower(flag: Boolean) : StructureTowerBase(flag) {
	override fun getBrickBlock(): Block = LOTRMod.brick

	override fun getBrickMeta(): Int = 6

	override fun getWallBlock(): Block = LOTRMod.wall

	override fun getWallMeta(): Int = 7

	override fun getCaptain(world: World): EntityCreature = LOTREntityGundabadOrcMercenaryCaptain(world)

	override fun getSecondaryBrick(): Block = LOTRMod.scorchedStone

	override fun getStairsBlock(): Block = LOTRMod.stairsDwarvenBrick

	override fun getSections(): Int = 7
}