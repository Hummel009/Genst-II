package com.github.hummel.genst.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityUrukHaiMercenaryCaptain
import net.minecraft.init.Blocks

object StructureIsengardTower : StructureBaseTower(
	LOTRMod.brick2 to 11,
	LOTRMod.scorchedStone to 0,
	LOTRMod.wall2 to 10,
	LOTRMod.stairsBlackGondorBrick,
	Blocks.iron_bars,
	LOTREntityUrukHaiMercenaryCaptain::class.java,
	9,
	true
)