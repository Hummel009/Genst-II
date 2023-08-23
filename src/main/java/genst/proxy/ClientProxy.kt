package genst.proxy

import genst.update.TickHandlerClient

open class ClientProxy : CommonProxy() {
	override fun preInit() {
		TickHandlerClient.preInit()
	}
}