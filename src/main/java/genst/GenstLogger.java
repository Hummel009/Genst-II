package genst;

import lotr.common.world.map.LOTRWaypoint;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class GenstLogger extends CommandBase {
	public static Set<LOTRWaypoint> skip = EnumSet.noneOf(LOTRWaypoint.class);

	public static void postInit() {
		skip.add(LOTRWaypoint.BREE);
		skip.add(LOTRWaypoint.COMBE);
		skip.add(LOTRWaypoint.STADDLE);
		skip.add(LOTRWaypoint.BRANDYWINE_BRIDGE);
		skip.add(LOTRWaypoint.LAST_BRIDGE);
		skip.add(LOTRWaypoint.FORD_BRUINEN);
		skip.add(LOTRWaypoint.WEST_GATE);
		skip.add(LOTRWaypoint.HIGH_PASS);
		skip.add(LOTRWaypoint.WITHYWINDLE_VALLEY);
		skip.add(LOTRWaypoint.MOUNT_CARADHRAS);
		skip.add(LOTRWaypoint.MOUNT_CELEBDIL);
		skip.add(LOTRWaypoint.MOUNT_FANUIDHOL);
		skip.add(LOTRWaypoint.MOUNT_METHEDRAS);
		skip.add(LOTRWaypoint.GOBLIN_TOWN);
		skip.add(LOTRWaypoint.EAGLES_EYRIE);
		skip.add(LOTRWaypoint.SCATHA);
		skip.add(LOTRWaypoint.CARROCK);
		skip.add(LOTRWaypoint.OLD_FORD);
		skip.add(LOTRWaypoint.DIMRILL_DALE);
		skip.add(LOTRWaypoint.RAUROS);
		skip.add(LOTRWaypoint.FOREST_GATE);
		skip.add(LOTRWaypoint.ANDUIN_CROSSROADS);
		skip.add(LOTRWaypoint.EAST_RHOVANION_ROAD);
	}

	@Override
	public List<String> addTabCompletionOptions(ICommandSender sender, String[] args) {
		return Collections.emptyList();
	}

	@Override
	public String getCommandName() {
		return "genst";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "Something went wrong.";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		World world = sender.getEntityWorld();
		for (LOTRWaypoint wp : LOTRWaypoint.values()) {
			if (!skip.contains(wp)) {
				double x = wp.getXCoord();
				double z = wp.getZCoord();
				BiomeGenBase bm = world.getBiomeGenForCoords((int) x, (int) z);
				System.out.println(wp.getCodeName() + " " + bm.biomeName);
			}
		}
	}
}
