package com.github.hummel.genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityRivendellLord

class RivendellTower : BaseTower(
	LOTRMod.brick3 to 2,
	LOTRMod.scorchedStone to 0,
	LOTRMod.wall2 to 11,
	LOTRMod.stairsHighElvenBrick,
	LOTRMod.highElfBars,
	LOTREntityRivendellLord::class.java,
	7,
	false
)