package genst.update

import genst.Genst
import net.minecraft.client.Minecraft
import net.minecraft.util.ChatComponentText
import net.minecraft.util.ChatComponentTranslation
import net.minecraft.util.EnumChatFormatting
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.nio.charset.StandardCharsets

object VersionChecker {
	private var versionURL: String = "https://raw.githubusercontent.com/Hummel009/Genst-II/master/version.txt"
	private var checkedUpdate: Boolean = false

	fun checkForUpdates() {
		if (!checkedUpdate) {
			val checkThread = object : Thread("Genst Update Checker") {
				override fun run() {
					try {
						var line: String?
						val url = URL(versionURL)
						val updateReader = BufferedReader(InputStreamReader(url.openStream(), StandardCharsets.UTF_8))
						var updateVersion = StringBuilder()
						while (updateReader.readLine().also { line = it } != null) {
							updateVersion.append(line)
						}
						updateReader.close()
						updateVersion = StringBuilder("$updateVersion".trim { it <= ' ' })
						val currentVersion = Genst.VERSION
						if ("$updateVersion" != currentVersion) {
							val component = ChatComponentText("Genst II:")
							component.getChatStyle().setColor(EnumChatFormatting.YELLOW)
							val entityplayer = Minecraft.getMinecraft().thePlayer
							entityplayer?.addChatMessage(
								ChatComponentTranslation(
									"genst.chat.update", component, "$updateVersion"
								)
							)
						}
					} catch (e: Exception) {
						e.printStackTrace()
					}
				}
			}
			checkedUpdate = true
			checkThread.isDaemon = true
			checkThread.start()
		}
	}
}