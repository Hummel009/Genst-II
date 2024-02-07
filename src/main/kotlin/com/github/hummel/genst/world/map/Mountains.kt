package com.github.hummel.genst.world.map

import com.github.hummel.genst.util.addMountain
import com.github.hummel.genst.util.shift
import lotr.common.world.map.LOTRWaypoint

object Mountains {
	fun postInit() {
		addMountain(LOTRWaypoint.TOLFALAS_ISLAND, 1.0f, 100, 0)
		addMountain(LOTRWaypoint.GREEN_HILLS, 1.0f, 100, 0)
		addMountain(LOTRWaypoint.HENNETH_ANNUN, 1.0f, 100, 0)
		addMountain(LOTRWaypoint.EMYN_ARNEN, 1.0f, 100, 0)
		addMountain(LOTRWaypoint.IMLOTH_MELUI, 1.0f, 100, 0)
		addMountain(LOTRWaypoint.KHAMUL_TOWER, 2.0f, 100, 0)
		addMountain(LOTRWaypoint.DUNHARROW, 1.0f, 100, 0)
		addMountain(LOTRWaypoint.TARLANG.shift(-0.1, 0.6), 1.0f, 100, 0)
		addMountain(LOTRWaypoint.OSGILIATH_WEST.shift(3.0 - 0.15, 0.35), 1.0f, 50, 0)
	}
}