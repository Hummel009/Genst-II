package com.github.hummel.genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityGaladhrimLord

class LothlorienTower : BaseTower(
	LOTRMod.brick to 11,
	LOTRMod.scorchedStone to 0,
	LOTRMod.wall to 10,
	LOTRMod.stairsElvenBrick,
	LOTRMod.galadhrimBars,
	LOTREntityGaladhrimLord::class.java,
	7,
	false
)