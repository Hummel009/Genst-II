package genst.update

import cpw.mods.fml.common.FMLCommonHandler
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.TickEvent
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent
import net.minecraft.client.Minecraft
import net.minecraftforge.common.MinecraftForge

@Suppress("unused")
object ClientTickHandler {
	fun preInit() {
		FMLCommonHandler.instance().bus().register(this)
		MinecraftForge.EVENT_BUS.register(this)
	}

	@SubscribeEvent
	fun onClientTick(event: ClientTickEvent) {
		val minecraft = Minecraft.getMinecraft()
		val entityplayer = minecraft.thePlayer
		val world = minecraft.theWorld
		if (event.phase == TickEvent.Phase.END) {
			entityplayer?.let { world?.let { VersionChecker.checkForUpdates() } }
		}
	}
}