package com.github.hummel.genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityWoodElfCaptain

class WoodElvenTower : BaseTower(
	LOTRMod.brick3 to 5,
	LOTRMod.scorchedStone to 0,
	LOTRMod.wall3 to 0,
	LOTRMod.stairsWoodElvenBrick,
	LOTRMod.woodElfBars,
	LOTREntityWoodElfCaptain::class.java,
	7,
	false
)