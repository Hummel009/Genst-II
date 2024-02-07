package com.github.hummel.genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityEasterlingWarlord

object KhamulTower : BaseTower(
	LOTRMod.brick5 to 11,
	LOTRMod.brick6 to 0,
	LOTRMod.wall3 to 15,
	LOTRMod.stairsRhunBrick,
	LOTRMod.goldBars,
	LOTREntityEasterlingWarlord::class.java,
	9,
	true
)