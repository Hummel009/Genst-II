package genst.world

import genst.utils.addMountain
import genst.utils.info
import lotr.common.world.map.LOTRWaypoint

object GenstMountains {
	fun postInit() {
		addMountain(LOTRWaypoint.ANDUIN_MOUTH, 0.5f, 200, 0)
		addMountain(LOTRWaypoint.TOLFALAS_ISLAND, 1f, 100, 0)
		addMountain(LOTRWaypoint.GREEN_HILLS, 1f, 100, 0)
		addMountain(LOTRWaypoint.HIMLING, 1f, 100, 0)
		addMountain(LOTRWaypoint.TOL_FUIN, 1f, 100, 0)
		addMountain(LOTRWaypoint.TOL_MORWEN, 1f, 100, 0)
		addMountain(LOTRWaypoint.GLADDEN_FIELDS, 1f, 100, 0)
		addMountain(LOTRWaypoint.MENELTARMA_SUMMIT, 1f, 100, 0)
		addMountain(LOTRWaypoint.OATBARTON, 1f, 100, 0)
		addMountain(LOTRWaypoint.NEEDLEHOLE, 1f, 100, 0)
		addMountain(LOTRWaypoint.NOBOTTLE, 1f, 100, 0)
		addMountain(LOTRWaypoint.CROSSINGS_OF_POROS.info(1.0, 1.0), 1f, 100, 0)
	}
}