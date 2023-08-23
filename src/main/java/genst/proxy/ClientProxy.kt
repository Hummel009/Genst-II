package genst.proxy

import genst.update.ClientTickHandler

open class ClientProxy : CommonProxy() {
	override fun preInit() {
		ClientTickHandler.preInit()
	}
}