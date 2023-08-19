package genst.command

import lotr.common.world.map.LOTRWaypoint
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import java.util.*

object GenstLogger : CommandBase() {
	val skip: MutableSet<LOTRWaypoint> = EnumSet.noneOf(LOTRWaypoint::class.java)

	override fun addTabCompletionOptions(sender: ICommandSender, args: Array<String>): List<String> = emptyList()

	override fun getCommandName(): String = "genst"

	override fun getCommandUsage(sender: ICommandSender): String = "Something went wrong."

	override fun processCommand(sender: ICommandSender, args: Array<String>) {
		val world = sender.entityWorld
		for (wp in LOTRWaypoint.values()) {
			if (!skip.contains(wp)) {
				val x = wp.xCoord.toDouble()
				val z = wp.zCoord.toDouble()
				val bm = world.getBiomeGenForCoords(x.toInt(), z.toInt())
				println(wp.displayName + " " + bm.biomeName)
			}
		}
	}

	fun postInit() {
		//mevans has already done this
		skip.add(LOTRWaypoint.BREE)
		skip.add(LOTRWaypoint.COMBE)
		skip.add(LOTRWaypoint.STADDLE)
		skip.add(LOTRWaypoint.ARCHET)

		//skip
		skip.add(LOTRWaypoint.WELLINGHALL)
		skip.add(LOTRWaypoint.TREEBEARD_HILL)
		skip.add(LOTRWaypoint.DERNDINGLE)
		skip.add(LOTRWaypoint.CAPE_OF_FOROCHEL)
		skip.add(LOTRWaypoint.SOUTH_FOROCHEL)
		skip.add(LOTRWaypoint.BRANDYWINE_BRIDGE)
		skip.add(LOTRWaypoint.SARN_FORD)
		skip.add(LOTRWaypoint.LAST_BRIDGE)
		skip.add(LOTRWaypoint.EAGLES_EYRIE)
		skip.add(LOTRWaypoint.CARROCK)
		skip.add(LOTRWaypoint.OLD_FORD)
		skip.add(LOTRWaypoint.WEST_GATE)
		skip.add(LOTRWaypoint.BELEGOST)
		skip.add(LOTRWaypoint.NOGROD)
		skip.add(LOTRWaypoint.THORIN_HALLS)
		skip.add(LOTRWaypoint.ARVEDUI_MINES)
		skip.add(LOTRWaypoint.THRAIN_HALLS)
		skip.add(LOTRWaypoint.DAINS_HALLS)
		skip.add(LOTRWaypoint.DIMRILL_DALE)
		skip.add(LOTRWaypoint.RAUROS)
		skip.add(LOTRWaypoint.FOREST_GATE)
		skip.add(LOTRWaypoint.ENCHANTED_RIVER)
		skip.add(LOTRWaypoint.RIVER_GATE)
		skip.add(LOTRWaypoint.EREBOR)
		skip.add(LOTRWaypoint.WEST_PEAK)
		skip.add(LOTRWaypoint.EAST_PEAK)
		skip.add(LOTRWaypoint.THRANDUIL_HALLS)
		skip.add(LOTRWaypoint.CARAS_GALADHON)
		skip.add(LOTRWaypoint.CERIN_AMROTH)
		skip.add(LOTRWaypoint.NIMRODEL)
		skip.add(LOTRWaypoint.CROSSINGS_ERUI)
		skip.add(LOTRWaypoint.ARGONATH)
		skip.add(LOTRWaypoint.MORANNON)
		skip.add(LOTRWaypoint.MOUNT_DOOM)
		skip.add(LOTRWaypoint.BARAZ_DUM)
		skip.add(LOTRWaypoint.CROSSINGS_OF_HARAD)
	}
}