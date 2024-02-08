package com.github.hummel.genst.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityWoodElfCaptain

class StructureWoodElvenTower : StructureBaseTower(
	LOTRMod.brick3 to 5,
	LOTRMod.scorchedStone to 0,
	LOTRMod.wall3 to 0,
	LOTRMod.stairsWoodElvenBrick,
	LOTRMod.woodElfBars,
	LOTREntityWoodElfCaptain::class.java,
	7,
	false
)