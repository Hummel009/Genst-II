package genst;

import lotr.common.world.map.LOTRMountains;
import lotr.common.world.map.LOTRWaypoint;
import net.minecraftforge.common.util.EnumHelper;

public class GenstMountains {
	public static void addMountain(String name, double x, double z, float h, int r, int lava) {
		Class<?>[] classArr = {Double.TYPE, Double.TYPE, Float.TYPE, Integer.TYPE, Integer.TYPE};
		Object[] args = {x, z, h, r, lava};
		EnumHelper.addEnum(LOTRMountains.class, name, classArr, args);
	}

	public static void postInit() {
		addMountain("PLACEHOLDER", LOTRWaypoint.TOLFALAS_ISLAND.getX(), LOTRWaypoint.TOLFALAS_ISLAND.getY(), 1, 100, 0);
		addMountain("PLACEHOLDER", LOTRWaypoint.GREEN_HILLS.getX(), LOTRWaypoint.GREEN_HILLS.getY(), 1, 100, 0);
		addMountain("PLACEHOLDER", LOTRWaypoint.HIMLING.getX(), LOTRWaypoint.HIMLING.getY(), 1, 100, 0);
		addMountain("PLACEHOLDER", LOTRWaypoint.TOL_FUIN.getX(), LOTRWaypoint.TOL_FUIN.getY(), 1, 100, 0);
		addMountain("PLACEHOLDER", LOTRWaypoint.TOL_MORWEN.getX(), LOTRWaypoint.TOL_MORWEN.getY(), 1, 100, 0);
		addMountain("PLACEHOLDER", LOTRWaypoint.GLADDEN_FIELDS.getX(), LOTRWaypoint.GLADDEN_FIELDS.getY(), 1, 100, 0);
		addMountain("PLACEHOLDER", LOTRWaypoint.MENELTARMA_SUMMIT.getX(), LOTRWaypoint.MENELTARMA_SUMMIT.getY(), 1, 100, 0);
		addMountain("PLACEHOLDER", LOTRWaypoint.OATBARTON.getX(), LOTRWaypoint.OATBARTON.getY(), 1, 100, 0);
		addMountain("PLACEHOLDER", LOTRWaypoint.NEEDLEHOLE.getX(), LOTRWaypoint.NEEDLEHOLE.getY(), 1, 100, 0);
		addMountain("PLACEHOLDER", LOTRWaypoint.NOBOTTLE.getX(), LOTRWaypoint.NOBOTTLE.getY(), 1, 100, 0);
	}
}
