package genst.world

import genst.utils.addMountain
import genst.utils.shift
import lotr.common.world.map.LOTRWaypoint

object GenstMountains {
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