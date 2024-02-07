package com.github.hummel.genst.world.map

import com.github.hummel.genst.util.editWaypoint
import lotr.common.world.map.LOTRWaypoint

object Waypoints {
	fun preInit() {
		editWaypoint(LOTRWaypoint.UMBAR_CITY, 1.0, -2.0)
		editWaypoint(LOTRWaypoint.HELMS_DEEP, 1.0, -1.0)
	}
}