package com.github.hummel.genst.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityDolGuldurOrcChieftain

class StructureDolGuldurTower : StructureBaseTower(
	LOTRMod.brick2 to 8,
	LOTRMod.scorchedStone to 0,
	LOTRMod.wall2 to 8,
	LOTRMod.stairsDolGuldurBrick,
	LOTRMod.orcSteelBars,
	LOTREntityDolGuldurOrcChieftain::class.java,
	7,
	true
)