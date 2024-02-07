package com.github.hummel.genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityUrukHaiMercenaryCaptain

class UrukTower : BaseTower(
	LOTRMod.brick2 to 7,
	LOTRMod.scorchedStone to 0,
	LOTRMod.wall2 to 7,
	LOTRMod.stairsUrukBrick,
	LOTRMod.urukBars,
	LOTREntityUrukHaiMercenaryCaptain::class.java,
	7,
	true
)