package com.github.hummel.genst.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityAngmarOrcMercenaryCaptain

class StructureAngmarTower : StructureBaseTower(
	LOTRMod.brick2 to 0,
	LOTRMod.scorchedStone to 0,
	LOTRMod.wall2 to 0,
	LOTRMod.stairsAngmarBrick,
	LOTRMod.orcSteelBars,
	LOTREntityAngmarOrcMercenaryCaptain::class.java,
	5,
	true
)