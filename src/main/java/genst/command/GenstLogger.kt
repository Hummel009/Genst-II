package genst.command

import lotr.common.world.map.LOTRWaypoint
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.util.ChatComponentText
import java.util.*


object GenstLogger : CommandBase() {
	val skip: MutableSet<LOTRWaypoint> = EnumSet.noneOf(LOTRWaypoint::class.java)

	override fun addTabCompletionOptions(sender: ICommandSender, args: Array<String>): List<String> = emptyList()

	override fun getCommandName(): String = "genst"

	override fun getCommandUsage(sender: ICommandSender): String = "Something went wrong."

	override fun processCommand(sender: ICommandSender, args: Array<String>) {
		val world = sender.entityWorld
		var count = 0
		for (wp in LOTRWaypoint.values()) {
			if (!skip.contains(wp)) {
				val bm = world.getBiomeGenForCoords(wp.xCoord, wp.zCoord)
				println(wp.codeName + " " + wp.displayName + " " + bm.biomeName)
				count++
			}
		}
		if (count != 0) {
			val msg = ChatComponentText(("All needed waypoints contain genst."))
			sender.addChatMessage(msg)
		}
	}

	fun postInit() {
		//mevans has already done this
		skip.add(LOTRWaypoint.BREE)
		skip.add(LOTRWaypoint.COMBE)
		skip.add(LOTRWaypoint.STADDLE)
		skip.add(LOTRWaypoint.ARCHET)

		//skip
		skip.add(LOTRWaypoint.MERING_STREAM)
		skip.add(LOTRWaypoint.WELLINGHALL)
		skip.add(LOTRWaypoint.TREEBEARD_HILL)
		skip.add(LOTRWaypoint.DERNDINGLE)
		skip.add(LOTRWaypoint.BRANDYWINE_BRIDGE)
		skip.add(LOTRWaypoint.SARN_FORD)
		skip.add(LOTRWaypoint.LAST_BRIDGE)
		skip.add(LOTRWaypoint.EAGLES_EYRIE)
		skip.add(LOTRWaypoint.CARROCK)
		skip.add(LOTRWaypoint.OLD_FORD)
		skip.add(LOTRWaypoint.WEST_GATE)
		skip.add(LOTRWaypoint.DIMRILL_DALE)
		skip.add(LOTRWaypoint.RAUROS)
		skip.add(LOTRWaypoint.FOREST_GATE)
		skip.add(LOTRWaypoint.ENCHANTED_RIVER)
		skip.add(LOTRWaypoint.RIVER_GATE)
		skip.add(LOTRWaypoint.CROSSINGS_ERUI)
		skip.add(LOTRWaypoint.ARGONATH)
		skip.add(LOTRWaypoint.MORANNON)
		skip.add(LOTRWaypoint.MOUNT_DOOM)
		skip.add(LOTRWaypoint.HARADUIN_BRIDGE)
		skip.add(LOTRWaypoint.CROSSINGS_OF_HARAD)
		skip.add(LOTRWaypoint.GULF_FORD)
		skip.add(LOTRWaypoint.KHAND_FORD)
		skip.add(LOTRWaypoint.HARADUIN_MOUTH)
		skip.add(LOTRWaypoint.CROSSINGS_OF_LITHNEN)
	}
}