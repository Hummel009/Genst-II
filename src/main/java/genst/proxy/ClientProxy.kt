package genst.proxy

import genst.update.ClientTickHandler

@Suppress("unused")
open class ClientProxy : CommonProxy() {
	override fun preInit() {
		ClientTickHandler.preInit()
	}
}