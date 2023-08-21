package genst

import genst.utils.editWaypoint
import lotr.common.world.map.LOTRWaypoint

object GenstTwicks {
	fun preInit() {
		editWaypoint(LOTRWaypoint.UMBAR_CITY, 2.0, -2.0)
	}
}