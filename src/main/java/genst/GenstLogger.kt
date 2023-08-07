package genst

import lotr.common.world.map.LOTRWaypoint
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import java.util.*

object GenstLogger : CommandBase() {
	val skip: MutableSet<LOTRWaypoint> = EnumSet.noneOf(LOTRWaypoint::class.java)

	override fun addTabCompletionOptions(sender: ICommandSender, args: Array<String>): List<String?> {
		return emptyList<String>()
	}

	override fun getCommandName(): String {
		return "genst"
	}

	override fun getCommandUsage(sender: ICommandSender): String {
		return "Something went wrong."
	}

	override fun processCommand(sender: ICommandSender, args: Array<String>) {
		val world = sender.entityWorld
		for (wp in LOTRWaypoint.values()) {
			if (!skip.contains(wp)) {
				val x = wp.xCoord.toDouble()
				val z = wp.zCoord.toDouble()
				val bm = world.getBiomeGenForCoords(x.toInt(), z.toInt())
				println(wp.codeName + " " + bm.biomeName)
			}
		}
	}

	fun postInit() {
		skip.add(LOTRWaypoint.RAS_MORTHIL)
		skip.add(LOTRWaypoint.TARLANG)
		skip.add(LOTRWaypoint.CROSSINGS_ERUI)
		skip.add(LOTRWaypoint.BREE)
		skip.add(LOTRWaypoint.COMBE)
		skip.add(LOTRWaypoint.STADDLE)
	}
}
