package com.github.hummel.genst.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityBlueDwarfCommander

class StructureBlueDwarvenTower : StructureBaseTower(
	LOTRMod.brick to 14,
	LOTRMod.scorchedStone to 0,
	LOTRMod.wall to 14,
	LOTRMod.stairsBlueRockBrick,
	LOTRMod.blueDwarfBars,
	LOTREntityBlueDwarfCommander::class.java,
	7,
	false
)