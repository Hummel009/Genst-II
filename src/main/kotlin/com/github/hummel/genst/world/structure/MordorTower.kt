package com.github.hummel.genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityMordorOrcMercenaryCaptain

class MordorTower : BaseTower(
	LOTRMod.brick to 0,
	LOTRMod.guldurilBrick to 0,
	LOTRMod.wall to 1,
	LOTRMod.stairsMordorBrick,
	LOTRMod.orcSteelBars,
	LOTREntityMordorOrcMercenaryCaptain::class.java,
	7,
	true
)