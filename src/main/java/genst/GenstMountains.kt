package genst

import lotr.common.world.map.LOTRMountains
import lotr.common.world.map.LOTRWaypoint
import net.minecraftforge.common.util.EnumHelper

object GenstMountains {
	private fun addMountain(name: String?, x: Double, z: Double, h: Float, r: Int, lava: Int) {
		val classArr = arrayOf<Class<*>>(
			java.lang.Double.TYPE, java.lang.Double.TYPE, java.lang.Float.TYPE, Integer.TYPE, Integer.TYPE
		)
		val args = arrayOf<Any>(x, z, h, r, lava)
		EnumHelper.addEnum(LOTRMountains::class.java, name, classArr, args)
	}

	fun postInit() {
		addMountain("PLACEHOLDER", LOTRWaypoint.TOLFALAS_ISLAND.x, LOTRWaypoint.TOLFALAS_ISLAND.y, 1f, 100, 0)
		addMountain("PLACEHOLDER", LOTRWaypoint.GREEN_HILLS.x, LOTRWaypoint.GREEN_HILLS.y, 1f, 100, 0)
		addMountain("PLACEHOLDER", LOTRWaypoint.HIMLING.x, LOTRWaypoint.HIMLING.y, 1f, 100, 0)
		addMountain("PLACEHOLDER", LOTRWaypoint.TOL_FUIN.x, LOTRWaypoint.TOL_FUIN.y, 1f, 100, 0)
		addMountain("PLACEHOLDER", LOTRWaypoint.TOL_MORWEN.x, LOTRWaypoint.TOL_MORWEN.y, 1f, 100, 0)
		addMountain("PLACEHOLDER", LOTRWaypoint.GLADDEN_FIELDS.x, LOTRWaypoint.GLADDEN_FIELDS.y, 1f, 100, 0)
		addMountain("PLACEHOLDER", LOTRWaypoint.MENELTARMA_SUMMIT.x, LOTRWaypoint.MENELTARMA_SUMMIT.y, 1f, 100, 0)
		addMountain("PLACEHOLDER", LOTRWaypoint.OATBARTON.x, LOTRWaypoint.OATBARTON.y, 1f, 100, 0)
		addMountain("PLACEHOLDER", LOTRWaypoint.NEEDLEHOLE.x, LOTRWaypoint.NEEDLEHOLE.y, 1f, 100, 0)
		addMountain("PLACEHOLDER", LOTRWaypoint.NOBOTTLE.x, LOTRWaypoint.NOBOTTLE.y, 1f, 100, 0)
	}
}
