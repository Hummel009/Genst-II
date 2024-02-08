package com.github.hummel.genst.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityGaladhrimLord

class StructureLothlorienTower : StructureBaseTower(
	LOTRMod.brick to 11,
	LOTRMod.scorchedStone to 0,
	LOTRMod.wall to 10,
	LOTRMod.stairsElvenBrick,
	LOTRMod.galadhrimBars,
	LOTREntityGaladhrimLord::class.java,
	7,
	false
)