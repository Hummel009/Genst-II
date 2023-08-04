package genst.world

import genst.utils.addMountain
import lotr.common.world.map.LOTRWaypoint

object GenstMountains {
	fun postInit() {
		addMountain(LOTRWaypoint.ANDUIN_MOUTH.x, LOTRWaypoint.ANDUIN_MOUTH.y, 0.5f, 200, 0)
		addMountain(LOTRWaypoint.TOLFALAS_ISLAND.x, LOTRWaypoint.TOLFALAS_ISLAND.y, 1f, 100, 0)
		addMountain(LOTRWaypoint.GREEN_HILLS.x, LOTRWaypoint.GREEN_HILLS.y, 1f, 100, 0)
		addMountain(LOTRWaypoint.HIMLING.x, LOTRWaypoint.HIMLING.y, 1f, 100, 0)
		addMountain(LOTRWaypoint.TOL_FUIN.x, LOTRWaypoint.TOL_FUIN.y, 1f, 100, 0)
		addMountain(LOTRWaypoint.TOL_MORWEN.x, LOTRWaypoint.TOL_MORWEN.y, 1f, 100, 0)
		addMountain(LOTRWaypoint.GLADDEN_FIELDS.x, LOTRWaypoint.GLADDEN_FIELDS.y, 1f, 100, 0)
		addMountain(LOTRWaypoint.MENELTARMA_SUMMIT.x, LOTRWaypoint.MENELTARMA_SUMMIT.y, 1f, 100, 0)
		addMountain(LOTRWaypoint.OATBARTON.x, LOTRWaypoint.OATBARTON.y, 1f, 100, 0)
		addMountain(LOTRWaypoint.NEEDLEHOLE.x, LOTRWaypoint.NEEDLEHOLE.y, 1f, 100, 0)
		addMountain(LOTRWaypoint.NOBOTTLE.x, LOTRWaypoint.NOBOTTLE.y, 1f, 100, 0)
	}
}