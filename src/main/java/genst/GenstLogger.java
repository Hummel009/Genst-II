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
