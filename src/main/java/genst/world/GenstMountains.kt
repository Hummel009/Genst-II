package genst.world

import genst.utils.addMountain
import genst.utils.shift
import lotr.common.world.map.LOTRWaypoint

object GenstMountains {
	fun postInit() {
		addMountain(LOTRWaypoint.ANDUIN_MOUTH, 0.5f, 100, 0)
		addMountain(LOTRWaypoint.TOLFALAS_ISLAND, 1.0f, 100, 0)
		addMountain(LOTRWaypoint.HIMLING, 1.0f, 100, 0)
		addMountain(LOTRWaypoint.TOL_FUIN, 1.0f, 100, 0)
		addMountain(LOTRWaypoint.MENELTARMA_SUMMIT, 1.0f, 100, 0)
		addMountain(LOTRWaypoint.GREEN_HILLS, 1.0f, 100, 0)
		addMountain(LOTRWaypoint.TOL_MORWEN, 1.0f, 100, 0)
		addMountain(LOTRWaypoint.GLADDEN_FIELDS, 1.0f, 100, 0)
		addMountain(LOTRWaypoint.KHAMUL_TOWER, 2.0f, 100, 0)
		addMountain(LOTRWaypoint.CROSSINGS_OF_POROS.shift(1.0, 1.0), 1.0f, 100, 0)
		addMountain(LOTRWaypoint.DUNHARROW, 1.0f, 100, 0)
		addMountain(LOTRWaypoint.OSGILIATH_WEST.shift(3.0 - 0.15, 0.35), 1.0f, 50, 0)
	}
}