package genst

import genst.utils.editWaypoint
import lotr.common.world.map.LOTRWaypoint

object GenstTweaks {
	fun preInit() {
		editWaypoint(LOTRWaypoint.UMBAR_CITY, 1.0, -2.0)
		editWaypoint(LOTRWaypoint.HELMS_DEEP, 1.0, -1.0)
	}
}