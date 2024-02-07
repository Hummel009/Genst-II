package com.github.hummel.genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityDwarfCommander

class DwarvenTower : BaseTower(
	LOTRMod.brick to 6,
	LOTRMod.scorchedStone to 0,
	LOTRMod.wall to 7,
	LOTRMod.stairsDwarvenBrick,
	LOTRMod.dwarfBars,
	LOTREntityDwarfCommander::class.java,
	7,
	false
)