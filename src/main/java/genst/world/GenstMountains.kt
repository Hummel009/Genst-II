package genst.world

import genst.utils.addMountain
import genst.utils.shift
import lotr.common.world.map.LOTRWaypoint

object GenstMountains {
	fun postInit() {
		addMountain(LOTRWaypoint.ANDUIN_MOUTH, 0.5f, 100, 0)
		addMountain(LOTRWaypoint.TOLFALAS_ISLAND, 1.0f, 100, 0)
		addMountain(LOTRWaypoint.GREEN_HILLS, 1.0f, 100, 0)
		addMountain(LOTRWaypoint.TOL_MORWEN, 1.0f, 100, 0)
		addMountain(LOTRWaypoint.GLADDEN_FIELDS, 1.0f, 100, 0)
		addMountain(LOTRWaypoint.CROSSINGS_OF_POROS.shift(1.0, 1.0), 1.0f, 100, 0)
	}
}