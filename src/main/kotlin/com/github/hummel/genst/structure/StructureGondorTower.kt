package com.github.hummel.genst.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityGondorianCaptain
import net.minecraft.init.Blocks

class StructureGondorTower : StructureBaseTower(
	LOTRMod.brick to 1,
	LOTRMod.scorchedStone to 0,
	LOTRMod.wall to 3,
	LOTRMod.stairsGondorBrick,
	Blocks.iron_bars,
	LOTREntityGondorianCaptain::class.java,
	7,
	false
)