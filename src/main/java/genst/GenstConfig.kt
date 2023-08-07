package genst

import lotr.common.world.map.LOTRWaypoint
import net.minecraftforge.common.config.Configuration
import java.io.File
import java.util.*

object GenstConfig {
	private var configuration: Configuration? = null
	private var isNotForbidden: MutableMap<LOTRWaypoint, Boolean?> = EnumMap(LOTRWaypoint::class.java)

	fun load() {
		isNotForbidden[LOTRWaypoint.HIMLING] = configuration?.get("waypoints", "Enable HIMLING", true)?.boolean
		isNotForbidden[LOTRWaypoint.TOL_FUIN] = configuration?.get("waypoints", "Enable TOL_FUIN", true)?.boolean
		isNotForbidden[LOTRWaypoint.TOL_MORWEN] = configuration?.get("waypoints", "Enable TOL_MORWEN", true)?.boolean
		isNotForbidden[LOTRWaypoint.MENELTARMA_SUMMIT] =
			configuration?.get("waypoints", "Enable MENELTARMA_SUMMIT", true)?.boolean
		isNotForbidden[LOTRWaypoint.HOBBITON] = configuration?.get("waypoints", "Enable HOBBITON", true)?.boolean
		isNotForbidden[LOTRWaypoint.BRANDYWINE_BRIDGE] =
			configuration?.get("waypoints", "Enable BRANDYWINE_BRIDGE", true)?.boolean
		isNotForbidden[LOTRWaypoint.SARN_FORD] = configuration?.get("waypoints", "Enable SARN_FORD", true)?.boolean
		isNotForbidden[LOTRWaypoint.LONGBOTTOM] = configuration?.get("waypoints", "Enable LONGBOTTOM", true)?.boolean
		isNotForbidden[LOTRWaypoint.MICHEL_DELVING] =
			configuration?.get("waypoints", "Enable MICHEL_DELVING", true)?.boolean
		isNotForbidden[LOTRWaypoint.WILLOWBOTTOM] =
			configuration?.get("waypoints", "Enable WILLOWBOTTOM", true)?.boolean
		isNotForbidden[LOTRWaypoint.BUCKLEBURY] = configuration?.get("waypoints", "Enable BUCKLEBURY", true)?.boolean
		isNotForbidden[LOTRWaypoint.WHITFURROWS] = configuration?.get("waypoints", "Enable WHITFURROWS", true)?.boolean
		isNotForbidden[LOTRWaypoint.FROGMORTON] = configuration?.get("waypoints", "Enable FROGMORTON", true)?.boolean
		isNotForbidden[LOTRWaypoint.OATBARTON] = configuration?.get("waypoints", "Enable OATBARTON", true)?.boolean
		isNotForbidden[LOTRWaypoint.SCARY] = configuration?.get("waypoints", "Enable SCARY", true)?.boolean
		isNotForbidden[LOTRWaypoint.NEEDLEHOLE] = configuration?.get("waypoints", "Enable NEEDLEHOLE", true)?.boolean
		isNotForbidden[LOTRWaypoint.LITTLE_DELVING] =
			configuration?.get("waypoints", "Enable LITTLE_DELVING", true)?.boolean
		isNotForbidden[LOTRWaypoint.WAYMEET] = configuration?.get("waypoints", "Enable WAYMEET", true)?.boolean
		isNotForbidden[LOTRWaypoint.TUCKBOROUGH] = configuration?.get("waypoints", "Enable TUCKBOROUGH", true)?.boolean
		isNotForbidden[LOTRWaypoint.NOBOTTLE] = configuration?.get("waypoints", "Enable NOBOTTLE", true)?.boolean
		isNotForbidden[LOTRWaypoint.TIGHFIELD] = configuration?.get("waypoints", "Enable TIGHFIELD", true)?.boolean
		isNotForbidden[LOTRWaypoint.BROCKENBORINGS] =
			configuration?.get("waypoints", "Enable BROCKENBORINGS", true)?.boolean
		isNotForbidden[LOTRWaypoint.DEEPHALLOW] = configuration?.get("waypoints", "Enable DEEPHALLOW", true)?.boolean
		isNotForbidden[LOTRWaypoint.STOCK] = configuration?.get("waypoints", "Enable STOCK", true)?.boolean
		isNotForbidden[LOTRWaypoint.BYWATER] = configuration?.get("waypoints", "Enable BYWATER", true)?.boolean
		isNotForbidden[LOTRWaypoint.OVERHILL] = configuration?.get("waypoints", "Enable OVERHILL", true)?.boolean
		isNotForbidden[LOTRWaypoint.HAYSEND] = configuration?.get("waypoints", "Enable HAYSEND", true)?.boolean
		isNotForbidden[LOTRWaypoint.HAY_GATE] = configuration?.get("waypoints", "Enable HAY_GATE", true)?.boolean
		isNotForbidden[LOTRWaypoint.GREENHOLM] = configuration?.get("waypoints", "Enable GREENHOLM", true)?.boolean
		isNotForbidden[LOTRWaypoint.WITHYWINDLE_VALLEY] =
			configuration?.get("waypoints", "Enable WITHYWINDLE_VALLEY", true)?.boolean
		isNotForbidden[LOTRWaypoint.FORLOND] = configuration?.get("waypoints", "Enable FORLOND", true)?.boolean
		isNotForbidden[LOTRWaypoint.HARLOND] = configuration?.get("waypoints", "Enable HARLOND", true)?.boolean
		isNotForbidden[LOTRWaypoint.MITHLOND_NORTH] =
			configuration?.get("waypoints", "Enable MITHLOND_NORTH", true)?.boolean
		isNotForbidden[LOTRWaypoint.MITHLOND_SOUTH] =
			configuration?.get("waypoints", "Enable MITHLOND_SOUTH", true)?.boolean
		isNotForbidden[LOTRWaypoint.FORLINDON] = configuration?.get("waypoints", "Enable FORLINDON", true)?.boolean
		isNotForbidden[LOTRWaypoint.HARLINDON] = configuration?.get("waypoints", "Enable HARLINDON", true)?.boolean
		isNotForbidden[LOTRWaypoint.TOWER_HILLS] = configuration?.get("waypoints", "Enable TOWER_HILLS", true)?.boolean
		isNotForbidden[LOTRWaypoint.AMON_EREB] = configuration?.get("waypoints", "Enable AMON_EREB", true)?.boolean
		isNotForbidden[LOTRWaypoint.BELEGOST] = configuration?.get("waypoints", "Enable BELEGOST", true)?.boolean
		isNotForbidden[LOTRWaypoint.NOGROD] = configuration?.get("waypoints", "Enable NOGROD", true)?.boolean
		isNotForbidden[LOTRWaypoint.MOUNT_RERIR] = configuration?.get("waypoints", "Enable MOUNT_RERIR", true)?.boolean
		isNotForbidden[LOTRWaypoint.MOUNT_DOLMED] =
			configuration?.get("waypoints", "Enable MOUNT_DOLMED", true)?.boolean
		isNotForbidden[LOTRWaypoint.THORIN_HALLS] =
			configuration?.get("waypoints", "Enable THORIN_HALLS", true)?.boolean
		isNotForbidden[LOTRWaypoint.ARVEDUI_MINES] =
			configuration?.get("waypoints", "Enable ARVEDUI_MINES", true)?.boolean
		isNotForbidden[LOTRWaypoint.THRAIN_HALLS] =
			configuration?.get("waypoints", "Enable THRAIN_HALLS", true)?.boolean
		isNotForbidden[LOTRWaypoint.NORTH_DOWNS] = configuration?.get("waypoints", "Enable NORTH_DOWNS", true)?.boolean
		isNotForbidden[LOTRWaypoint.SOUTH_DOWNS] = configuration?.get("waypoints", "Enable SOUTH_DOWNS", true)?.boolean
		isNotForbidden[LOTRWaypoint.ERYN_VORN] = configuration?.get("waypoints", "Enable ERYN_VORN", true)?.boolean
		isNotForbidden[LOTRWaypoint.THARBAD] = configuration?.get("waypoints", "Enable THARBAD", true)?.boolean
		isNotForbidden[LOTRWaypoint.FORNOST] = configuration?.get("waypoints", "Enable FORNOST", true)?.boolean
		isNotForbidden[LOTRWaypoint.ANNUMINAS] = configuration?.get("waypoints", "Enable ANNUMINAS", true)?.boolean
		isNotForbidden[LOTRWaypoint.GREENWAY_CROSSROADS] =
			configuration?.get("waypoints", "Enable GREENWAY_CROSSROADS", true)?.boolean
		isNotForbidden[LOTRWaypoint.BREE] = configuration?.get("waypoints", "Enable BREE", true)?.boolean
		isNotForbidden[LOTRWaypoint.STADDLE] = configuration?.get("waypoints", "Enable STADDLE", true)?.boolean
		isNotForbidden[LOTRWaypoint.COMBE] = configuration?.get("waypoints", "Enable COMBE", true)?.boolean
		isNotForbidden[LOTRWaypoint.ARCHET] = configuration?.get("waypoints", "Enable ARCHET", true)?.boolean
		isNotForbidden[LOTRWaypoint.FORSAKEN_INN] =
			configuration?.get("waypoints", "Enable FORSAKEN_INN", true)?.boolean
		isNotForbidden[LOTRWaypoint.WEATHERTOP] = configuration?.get("waypoints", "Enable WEATHERTOP", true)?.boolean
		isNotForbidden[LOTRWaypoint.LAST_BRIDGE] = configuration?.get("waypoints", "Enable LAST_BRIDGE", true)?.boolean
		isNotForbidden[LOTRWaypoint.OLD_ELF_WAY] = configuration?.get("waypoints", "Enable OLD_ELF_WAY", true)?.boolean
		isNotForbidden[LOTRWaypoint.RIVENDELL] = configuration?.get("waypoints", "Enable RIVENDELL", true)?.boolean
		isNotForbidden[LOTRWaypoint.FORD_BRUINEN] =
			configuration?.get("waypoints", "Enable FORD_BRUINEN", true)?.boolean
		isNotForbidden[LOTRWaypoint.THE_TROLLSHAWS] =
			configuration?.get("waypoints", "Enable THE_TROLLSHAWS", true)?.boolean
		isNotForbidden[LOTRWaypoint.CARN_DUM] = configuration?.get("waypoints", "Enable CARN_DUM", true)?.boolean
		isNotForbidden[LOTRWaypoint.WEST_GATE] = configuration?.get("waypoints", "Enable WEST_GATE", true)?.boolean
		isNotForbidden[LOTRWaypoint.OST_IN_EDHIL] =
			configuration?.get("waypoints", "Enable OST_IN_EDHIL", true)?.boolean
		isNotForbidden[LOTRWaypoint.NORTH_DUNLAND] =
			configuration?.get("waypoints", "Enable NORTH_DUNLAND", true)?.boolean
		isNotForbidden[LOTRWaypoint.SOUTH_DUNLAND] =
			configuration?.get("waypoints", "Enable SOUTH_DUNLAND", true)?.boolean
		isNotForbidden[LOTRWaypoint.FORDS_OF_ISEN] =
			configuration?.get("waypoints", "Enable FORDS_OF_ISEN", true)?.boolean
		isNotForbidden[LOTRWaypoint.DWARROWVALE] = configuration?.get("waypoints", "Enable DWARROWVALE", true)?.boolean
		isNotForbidden[LOTRWaypoint.WULFBURG] = configuration?.get("waypoints", "Enable WULFBURG", true)?.boolean
		isNotForbidden[LOTRWaypoint.LOND_DAER] = configuration?.get("waypoints", "Enable LOND_DAER", true)?.boolean
		isNotForbidden[LOTRWaypoint.ENEDWAITH_ROAD] =
			configuration?.get("waypoints", "Enable ENEDWAITH_ROAD", true)?.boolean
		isNotForbidden[LOTRWaypoint.MOUTHS_ISEN] = configuration?.get("waypoints", "Enable MOUTHS_ISEN", true)?.boolean
		isNotForbidden[LOTRWaypoint.ISENGARD] = configuration?.get("waypoints", "Enable ISENGARD", true)?.boolean
		isNotForbidden[LOTRWaypoint.CAPE_OF_FOROCHEL] =
			configuration?.get("waypoints", "Enable CAPE_OF_FOROCHEL", true)?.boolean
		isNotForbidden[LOTRWaypoint.SOUTH_FOROCHEL] =
			configuration?.get("waypoints", "Enable SOUTH_FOROCHEL", true)?.boolean
		isNotForbidden[LOTRWaypoint.WITHERED_HEATH] =
			configuration?.get("waypoints", "Enable WITHERED_HEATH", true)?.boolean
		isNotForbidden[LOTRWaypoint.MOUNT_GUNDABAD] =
			configuration?.get("waypoints", "Enable MOUNT_GUNDABAD", true)?.boolean
		isNotForbidden[LOTRWaypoint.MOUNT_GRAM] = configuration?.get("waypoints", "Enable MOUNT_GRAM", true)?.boolean
		isNotForbidden[LOTRWaypoint.HIGH_PASS] = configuration?.get("waypoints", "Enable HIGH_PASS", true)?.boolean
		isNotForbidden[LOTRWaypoint.MOUNT_CARADHRAS] =
			configuration?.get("waypoints", "Enable MOUNT_CARADHRAS", true)?.boolean
		isNotForbidden[LOTRWaypoint.MOUNT_CELEBDIL] =
			configuration?.get("waypoints", "Enable MOUNT_CELEBDIL", true)?.boolean
		isNotForbidden[LOTRWaypoint.MOUNT_FANUIDHOL] =
			configuration?.get("waypoints", "Enable MOUNT_FANUIDHOL", true)?.boolean
		isNotForbidden[LOTRWaypoint.MOUNT_METHEDRAS] =
			configuration?.get("waypoints", "Enable MOUNT_METHEDRAS", true)?.boolean
		isNotForbidden[LOTRWaypoint.GOBLIN_TOWN] = configuration?.get("waypoints", "Enable GOBLIN_TOWN", true)?.boolean
		isNotForbidden[LOTRWaypoint.EAGLES_EYRIE] =
			configuration?.get("waypoints", "Enable EAGLES_EYRIE", true)?.boolean
		isNotForbidden[LOTRWaypoint.DAINS_HALLS] = configuration?.get("waypoints", "Enable DAINS_HALLS", true)?.boolean
		isNotForbidden[LOTRWaypoint.SCATHA] = configuration?.get("waypoints", "Enable SCATHA", true)?.boolean
		isNotForbidden[LOTRWaypoint.CARROCK] = configuration?.get("waypoints", "Enable CARROCK", true)?.boolean
		isNotForbidden[LOTRWaypoint.OLD_FORD] = configuration?.get("waypoints", "Enable OLD_FORD", true)?.boolean
		isNotForbidden[LOTRWaypoint.GLADDEN_FIELDS] =
			configuration?.get("waypoints", "Enable GLADDEN_FIELDS", true)?.boolean
		isNotForbidden[LOTRWaypoint.DIMRILL_DALE] =
			configuration?.get("waypoints", "Enable DIMRILL_DALE", true)?.boolean
		isNotForbidden[LOTRWaypoint.FIELD_OF_CELEBRANT] =
			configuration?.get("waypoints", "Enable FIELD_OF_CELEBRANT", true)?.boolean
		isNotForbidden[LOTRWaypoint.RAUROS] = configuration?.get("waypoints", "Enable RAUROS", true)?.boolean
		isNotForbidden[LOTRWaypoint.BEORN] = configuration?.get("waypoints", "Enable BEORN", true)?.boolean
		isNotForbidden[LOTRWaypoint.FOREST_GATE] = configuration?.get("waypoints", "Enable FOREST_GATE", true)?.boolean
		isNotForbidden[LOTRWaypoint.FRAMSBURG] = configuration?.get("waypoints", "Enable FRAMSBURG", true)?.boolean
		isNotForbidden[LOTRWaypoint.ANDUIN_CROSSROADS] =
			configuration?.get("waypoints", "Enable ANDUIN_CROSSROADS", true)?.boolean
		isNotForbidden[LOTRWaypoint.EAST_RHOVANION_ROAD] =
			configuration?.get("waypoints", "Enable EAST_RHOVANION_ROAD", true)?.boolean
		isNotForbidden[LOTRWaypoint.THRANDUIL_HALLS] =
			configuration?.get("waypoints", "Enable THRANDUIL_HALLS", true)?.boolean
		isNotForbidden[LOTRWaypoint.DOL_GULDUR] = configuration?.get("waypoints", "Enable DOL_GULDUR", true)?.boolean
		isNotForbidden[LOTRWaypoint.MIRKWOOD_MOUNTAINS] =
			configuration?.get("waypoints", "Enable MIRKWOOD_MOUNTAINS", true)?.boolean
		isNotForbidden[LOTRWaypoint.RHOSGOBEL] = configuration?.get("waypoints", "Enable RHOSGOBEL", true)?.boolean
		isNotForbidden[LOTRWaypoint.ENCHANTED_RIVER] =
			configuration?.get("waypoints", "Enable ENCHANTED_RIVER", true)?.boolean
		isNotForbidden[LOTRWaypoint.RIVER_GATE] = configuration?.get("waypoints", "Enable RIVER_GATE", true)?.boolean
		isNotForbidden[LOTRWaypoint.EAST_BIGHT] = configuration?.get("waypoints", "Enable EAST_BIGHT", true)?.boolean
		isNotForbidden[LOTRWaypoint.OLD_RHOVANION] =
			configuration?.get("waypoints", "Enable OLD_RHOVANION", true)?.boolean
		isNotForbidden[LOTRWaypoint.DORWINION_CROSSROADS] =
			configuration?.get("waypoints", "Enable DORWINION_CROSSROADS", true)?.boolean
		isNotForbidden[LOTRWaypoint.EREBOR] = configuration?.get("waypoints", "Enable EREBOR", true)?.boolean
		isNotForbidden[LOTRWaypoint.DALE_CITY] = configuration?.get("waypoints", "Enable DALE_CITY", true)?.boolean
		isNotForbidden[LOTRWaypoint.LONG_LAKE] = configuration?.get("waypoints", "Enable LONG_LAKE", true)?.boolean
		isNotForbidden[LOTRWaypoint.RUNNING_FORD] =
			configuration?.get("waypoints", "Enable RUNNING_FORD", true)?.boolean
		isNotForbidden[LOTRWaypoint.REDWATER_FORD] =
			configuration?.get("waypoints", "Enable REDWATER_FORD", true)?.boolean
		isNotForbidden[LOTRWaypoint.DALE_CROSSROADS] =
			configuration?.get("waypoints", "Enable DALE_CROSSROADS", true)?.boolean
		isNotForbidden[LOTRWaypoint.DALE_PORT] = configuration?.get("waypoints", "Enable DALE_PORT", true)?.boolean
		isNotForbidden[LOTRWaypoint.WEST_PEAK] = configuration?.get("waypoints", "Enable WEST_PEAK", true)?.boolean
		isNotForbidden[LOTRWaypoint.EAST_PEAK] = configuration?.get("waypoints", "Enable EAST_PEAK", true)?.boolean
		isNotForbidden[LOTRWaypoint.CARAS_GALADHON] =
			configuration?.get("waypoints", "Enable CARAS_GALADHON", true)?.boolean
		isNotForbidden[LOTRWaypoint.CERIN_AMROTH] =
			configuration?.get("waypoints", "Enable CERIN_AMROTH", true)?.boolean
		isNotForbidden[LOTRWaypoint.NIMRODEL] = configuration?.get("waypoints", "Enable NIMRODEL", true)?.boolean
		isNotForbidden[LOTRWaypoint.DERNDINGLE] = configuration?.get("waypoints", "Enable DERNDINGLE", true)?.boolean
		isNotForbidden[LOTRWaypoint.WELLINGHALL] = configuration?.get("waypoints", "Enable WELLINGHALL", true)?.boolean
		isNotForbidden[LOTRWaypoint.TREEBEARD_HILL] =
			configuration?.get("waypoints", "Enable TREEBEARD_HILL", true)?.boolean
		isNotForbidden[LOTRWaypoint.WOLD] = configuration?.get("waypoints", "Enable WOLD", true)?.boolean
		isNotForbidden[LOTRWaypoint.EDORAS] = configuration?.get("waypoints", "Enable EDORAS", true)?.boolean
		isNotForbidden[LOTRWaypoint.HELMS_DEEP] = configuration?.get("waypoints", "Enable HELMS_DEEP", true)?.boolean
		isNotForbidden[LOTRWaypoint.HELMS_CROSSROADS] =
			configuration?.get("waypoints", "Enable HELMS_CROSSROADS", true)?.boolean
		isNotForbidden[LOTRWaypoint.URUK_HIGHLANDS] =
			configuration?.get("waypoints", "Enable URUK_HIGHLANDS", true)?.boolean
		isNotForbidden[LOTRWaypoint.MERING_STREAM] =
			configuration?.get("waypoints", "Enable MERING_STREAM", true)?.boolean
		isNotForbidden[LOTRWaypoint.ENTWADE] = configuration?.get("waypoints", "Enable ENTWADE", true)?.boolean
		isNotForbidden[LOTRWaypoint.EASTMARK] = configuration?.get("waypoints", "Enable EASTMARK", true)?.boolean
		isNotForbidden[LOTRWaypoint.ALDBURG] = configuration?.get("waypoints", "Enable ALDBURG", true)?.boolean
		isNotForbidden[LOTRWaypoint.GRIMSLADE] = configuration?.get("waypoints", "Enable GRIMSLADE", true)?.boolean
		isNotForbidden[LOTRWaypoint.CORSAIRS_LANDING] =
			configuration?.get("waypoints", "Enable CORSAIRS_LANDING", true)?.boolean
		isNotForbidden[LOTRWaypoint.FRECA_HOLD] = configuration?.get("waypoints", "Enable FRECA_HOLD", true)?.boolean
		isNotForbidden[LOTRWaypoint.DUNHARROW] = configuration?.get("waypoints", "Enable DUNHARROW", true)?.boolean
		isNotForbidden[LOTRWaypoint.TARLANG] = configuration?.get("waypoints", "Enable TARLANG", true)?.boolean
		isNotForbidden[LOTRWaypoint.RAS_MORTHIL] = configuration?.get("waypoints", "Enable RAS_MORTHIL", true)?.boolean
		isNotForbidden[LOTRWaypoint.MINAS_TIRITH] =
			configuration?.get("waypoints", "Enable MINAS_TIRITH", true)?.boolean
		isNotForbidden[LOTRWaypoint.CAIR_ANDROS] = configuration?.get("waypoints", "Enable CAIR_ANDROS", true)?.boolean
		isNotForbidden[LOTRWaypoint.HALIFIRIEN] = configuration?.get("waypoints", "Enable HALIFIRIEN", true)?.boolean
		isNotForbidden[LOTRWaypoint.CALENHAD] = configuration?.get("waypoints", "Enable CALENHAD", true)?.boolean
		isNotForbidden[LOTRWaypoint.MINRIMMON] = configuration?.get("waypoints", "Enable MINRIMMON", true)?.boolean
		isNotForbidden[LOTRWaypoint.ERELAS] = configuration?.get("waypoints", "Enable ERELAS", true)?.boolean
		isNotForbidden[LOTRWaypoint.NARDOL] = configuration?.get("waypoints", "Enable NARDOL", true)?.boolean
		isNotForbidden[LOTRWaypoint.EILENACH] = configuration?.get("waypoints", "Enable EILENACH", true)?.boolean
		isNotForbidden[LOTRWaypoint.AMON_DIN] = configuration?.get("waypoints", "Enable AMON_DIN", true)?.boolean
		isNotForbidden[LOTRWaypoint.OSGILIATH_WEST] =
			configuration?.get("waypoints", "Enable OSGILIATH_WEST", true)?.boolean
		isNotForbidden[LOTRWaypoint.OSGILIATH_EAST] =
			configuration?.get("waypoints", "Enable OSGILIATH_EAST", true)?.boolean
		isNotForbidden[LOTRWaypoint.EMYN_ARNEN] = configuration?.get("waypoints", "Enable EMYN_ARNEN", true)?.boolean
		isNotForbidden[LOTRWaypoint.HENNETH_ANNUN] =
			configuration?.get("waypoints", "Enable HENNETH_ANNUN", true)?.boolean
		isNotForbidden[LOTRWaypoint.CROSSROADS_ITHILIEN] =
			configuration?.get("waypoints", "Enable CROSSROADS_ITHILIEN", true)?.boolean
		isNotForbidden[LOTRWaypoint.NORTH_ITHILIEN] =
			configuration?.get("waypoints", "Enable NORTH_ITHILIEN", true)?.boolean
		isNotForbidden[LOTRWaypoint.CROSSINGS_OF_POROS] =
			configuration?.get("waypoints", "Enable CROSSINGS_OF_POROS", true)?.boolean
		isNotForbidden[LOTRWaypoint.PELARGIR] = configuration?.get("waypoints", "Enable PELARGIR", true)?.boolean
		isNotForbidden[LOTRWaypoint.LINHIR] = configuration?.get("waypoints", "Enable LINHIR", true)?.boolean
		isNotForbidden[LOTRWaypoint.ANDUIN_MOUTH] =
			configuration?.get("waypoints", "Enable ANDUIN_MOUTH", true)?.boolean
		isNotForbidden[LOTRWaypoint.IMLOTH_MELUI] =
			configuration?.get("waypoints", "Enable IMLOTH_MELUI", true)?.boolean
		isNotForbidden[LOTRWaypoint.CROSSINGS_ERUI] =
			configuration?.get("waypoints", "Enable CROSSINGS_ERUI", true)?.boolean
		isNotForbidden[LOTRWaypoint.CALEMBEL] = configuration?.get("waypoints", "Enable CALEMBEL", true)?.boolean
		isNotForbidden[LOTRWaypoint.ETHRING] = configuration?.get("waypoints", "Enable ETHRING", true)?.boolean
		isNotForbidden[LOTRWaypoint.ERECH] = configuration?.get("waypoints", "Enable ERECH", true)?.boolean
		isNotForbidden[LOTRWaypoint.GREEN_HILLS] = configuration?.get("waypoints", "Enable GREEN_HILLS", true)?.boolean
		isNotForbidden[LOTRWaypoint.DOL_AMROTH] = configuration?.get("waypoints", "Enable DOL_AMROTH", true)?.boolean
		isNotForbidden[LOTRWaypoint.EDHELLOND] = configuration?.get("waypoints", "Enable EDHELLOND", true)?.boolean
		isNotForbidden[LOTRWaypoint.TARNOST] = configuration?.get("waypoints", "Enable TARNOST", true)?.boolean
		isNotForbidden[LOTRWaypoint.TOLFALAS_ISLAND] =
			configuration?.get("waypoints", "Enable TOLFALAS_ISLAND", true)?.boolean
		isNotForbidden[LOTRWaypoint.AMON_HEN] = configuration?.get("waypoints", "Enable AMON_HEN", true)?.boolean
		isNotForbidden[LOTRWaypoint.AMON_LHAW] = configuration?.get("waypoints", "Enable AMON_LHAW", true)?.boolean
		isNotForbidden[LOTRWaypoint.ARGONATH] = configuration?.get("waypoints", "Enable ARGONATH", true)?.boolean
		isNotForbidden[LOTRWaypoint.NORTH_UNDEEP] =
			configuration?.get("waypoints", "Enable NORTH_UNDEEP", true)?.boolean
		isNotForbidden[LOTRWaypoint.SOUTH_UNDEEP] =
			configuration?.get("waypoints", "Enable SOUTH_UNDEEP", true)?.boolean
		isNotForbidden[LOTRWaypoint.MORANNON] = configuration?.get("waypoints", "Enable MORANNON", true)?.boolean
		isNotForbidden[LOTRWaypoint.UDUN] = configuration?.get("waypoints", "Enable UDUN", true)?.boolean
		isNotForbidden[LOTRWaypoint.MOUNT_DOOM] = configuration?.get("waypoints", "Enable MOUNT_DOOM", true)?.boolean
		isNotForbidden[LOTRWaypoint.BARAD_DUR] = configuration?.get("waypoints", "Enable BARAD_DUR", true)?.boolean
		isNotForbidden[LOTRWaypoint.MINAS_MORGUL] =
			configuration?.get("waypoints", "Enable MINAS_MORGUL", true)?.boolean
		isNotForbidden[LOTRWaypoint.DURTHANG] = configuration?.get("waypoints", "Enable DURTHANG", true)?.boolean
		isNotForbidden[LOTRWaypoint.CARACH_ANGREN] =
			configuration?.get("waypoints", "Enable CARACH_ANGREN", true)?.boolean
		isNotForbidden[LOTRWaypoint.CIRITH_UNGOL] =
			configuration?.get("waypoints", "Enable CIRITH_UNGOL", true)?.boolean
		isNotForbidden[LOTRWaypoint.MORIGOST] = configuration?.get("waypoints", "Enable MORIGOST", true)?.boolean
		isNotForbidden[LOTRWaypoint.NARGROTH] = configuration?.get("waypoints", "Enable NARGROTH", true)?.boolean
		isNotForbidden[LOTRWaypoint.AMON_ANGREN] = configuration?.get("waypoints", "Enable AMON_ANGREN", true)?.boolean
		isNotForbidden[LOTRWaypoint.SEREGOST] = configuration?.get("waypoints", "Enable SEREGOST", true)?.boolean
		isNotForbidden[LOTRWaypoint.FELLBEASTS] = configuration?.get("waypoints", "Enable FELLBEASTS", true)?.boolean
		isNotForbidden[LOTRWaypoint.EASTERN_GUARD] =
			configuration?.get("waypoints", "Enable EASTERN_GUARD", true)?.boolean
		isNotForbidden[LOTRWaypoint.NURNEN_NORTHERN_SHORE] =
			configuration?.get("waypoints", "Enable NURNEN_NORTHERN_SHORE", true)?.boolean
		isNotForbidden[LOTRWaypoint.NURNEN_SOUTHERN_SHORE] =
			configuration?.get("waypoints", "Enable NURNEN_SOUTHERN_SHORE", true)?.boolean
		isNotForbidden[LOTRWaypoint.NURNEN_WESTERN_SHORE] =
			configuration?.get("waypoints", "Enable NURNEN_WESTERN_SHORE", true)?.boolean
		isNotForbidden[LOTRWaypoint.NURNEN_EASTERN_SHORE] =
			configuration?.get("waypoints", "Enable NURNEN_EASTERN_SHORE", true)?.boolean
		isNotForbidden[LOTRWaypoint.THAURBAND] = configuration?.get("waypoints", "Enable THAURBAND", true)?.boolean
		isNotForbidden[LOTRWaypoint.VALLEY_OF_SPIDERS] =
			configuration?.get("waypoints", "Enable VALLEY_OF_SPIDERS", true)?.boolean
		isNotForbidden[LOTRWaypoint.DORWINION_PORT] =
			configuration?.get("waypoints", "Enable DORWINION_PORT", true)?.boolean
		isNotForbidden[LOTRWaypoint.DORWINION_COURT] =
			configuration?.get("waypoints", "Enable DORWINION_COURT", true)?.boolean
		isNotForbidden[LOTRWaypoint.DORWINION_FORD] =
			configuration?.get("waypoints", "Enable DORWINION_FORD", true)?.boolean
		isNotForbidden[LOTRWaypoint.DORWINION_HILLS] =
			configuration?.get("waypoints", "Enable DORWINION_HILLS", true)?.boolean
		isNotForbidden[LOTRWaypoint.RHUN_ROAD_WAY] =
			configuration?.get("waypoints", "Enable RHUN_ROAD_WAY", true)?.boolean
		isNotForbidden[LOTRWaypoint.BALCARAS] = configuration?.get("waypoints", "Enable BALCARAS", true)?.boolean
		isNotForbidden[LOTRWaypoint.KHAND_NORTH_ROAD] =
			configuration?.get("waypoints", "Enable KHAND_NORTH_ROAD", true)?.boolean
		isNotForbidden[LOTRWaypoint.RHUN_CAPITAL] =
			configuration?.get("waypoints", "Enable RHUN_CAPITAL", true)?.boolean
		isNotForbidden[LOTRWaypoint.KHAMUL_TOWER] =
			configuration?.get("waypoints", "Enable KHAMUL_TOWER", true)?.boolean
		isNotForbidden[LOTRWaypoint.MORDOR_FORD] = configuration?.get("waypoints", "Enable MORDOR_FORD", true)?.boolean
		isNotForbidden[LOTRWaypoint.RHUN_NORTH_CITY] =
			configuration?.get("waypoints", "Enable RHUN_NORTH_CITY", true)?.boolean
		isNotForbidden[LOTRWaypoint.BAZYLAN] = configuration?.get("waypoints", "Enable BAZYLAN", true)?.boolean
		isNotForbidden[LOTRWaypoint.BORDER_TOWN] = configuration?.get("waypoints", "Enable BORDER_TOWN", true)?.boolean
		isNotForbidden[LOTRWaypoint.RHUN_SEA_CITY] =
			configuration?.get("waypoints", "Enable RHUN_SEA_CITY", true)?.boolean
		isNotForbidden[LOTRWaypoint.RHUN_NORTH_FORD] =
			configuration?.get("waypoints", "Enable RHUN_NORTH_FORD", true)?.boolean
		isNotForbidden[LOTRWaypoint.RHUN_NORTHEAST] =
			configuration?.get("waypoints", "Enable RHUN_NORTHEAST", true)?.boolean
		isNotForbidden[LOTRWaypoint.RHUN_SOUTH_PASS] =
			configuration?.get("waypoints", "Enable RHUN_SOUTH_PASS", true)?.boolean
		isNotForbidden[LOTRWaypoint.RHUN_EAST_CITY] =
			configuration?.get("waypoints", "Enable RHUN_EAST_CITY", true)?.boolean
		isNotForbidden[LOTRWaypoint.RHUN_EAST_TOWN] =
			configuration?.get("waypoints", "Enable RHUN_EAST_TOWN", true)?.boolean
		isNotForbidden[LOTRWaypoint.RHUN_SOUTHEAST] =
			configuration?.get("waypoints", "Enable RHUN_SOUTHEAST", true)?.boolean
		isNotForbidden[LOTRWaypoint.BARAZ_DUM] = configuration?.get("waypoints", "Enable BARAZ_DUM", true)?.boolean
		isNotForbidden[LOTRWaypoint.CROSSINGS_OF_HARAD] =
			configuration?.get("waypoints", "Enable CROSSINGS_OF_HARAD", true)?.boolean
		isNotForbidden[LOTRWaypoint.HARNEN_SEA_TOWN] =
			configuration?.get("waypoints", "Enable HARNEN_SEA_TOWN", true)?.boolean
		isNotForbidden[LOTRWaypoint.HARNEN_ROAD_TOWN] =
			configuration?.get("waypoints", "Enable HARNEN_ROAD_TOWN", true)?.boolean
		isNotForbidden[LOTRWaypoint.HARNEN_BLACK_TOWN] =
			configuration?.get("waypoints", "Enable HARNEN_BLACK_TOWN", true)?.boolean
		isNotForbidden[LOTRWaypoint.CROSSINGS_OF_LITHNEN] =
			configuration?.get("waypoints", "Enable CROSSINGS_OF_LITHNEN", true)?.boolean
		isNotForbidden[LOTRWaypoint.HARNEN_RIVER_TOWN] =
			configuration?.get("waypoints", "Enable HARNEN_RIVER_TOWN", true)?.boolean
		isNotForbidden[LOTRWaypoint.KHAND_FORD] = configuration?.get("waypoints", "Enable KHAND_FORD", true)?.boolean
		isNotForbidden[LOTRWaypoint.UMBAR_CITY] = configuration?.get("waypoints", "Enable UMBAR_CITY", true)?.boolean
		isNotForbidden[LOTRWaypoint.UMBAR_GATE] = configuration?.get("waypoints", "Enable UMBAR_GATE", true)?.boolean
		isNotForbidden[LOTRWaypoint.GATE_HERUMOR] =
			configuration?.get("waypoints", "Enable GATE_HERUMOR", true)?.boolean
		isNotForbidden[LOTRWaypoint.CEDAR_ROAD] = configuration?.get("waypoints", "Enable CEDAR_ROAD", true)?.boolean
		isNotForbidden[LOTRWaypoint.FERTILE_VALLEY] =
			configuration?.get("waypoints", "Enable FERTILE_VALLEY", true)?.boolean
		isNotForbidden[LOTRWaypoint.GARDENS_BERUTHIEL] =
			configuration?.get("waypoints", "Enable GARDENS_BERUTHIEL", true)?.boolean
		isNotForbidden[LOTRWaypoint.AIN_AL_HARAD] =
			configuration?.get("waypoints", "Enable AIN_AL_HARAD", true)?.boolean
		isNotForbidden[LOTRWaypoint.GATE_FUINUR] = configuration?.get("waypoints", "Enable GATE_FUINUR", true)?.boolean
		isNotForbidden[LOTRWaypoint.COAST_FORTRESS] =
			configuration?.get("waypoints", "Enable COAST_FORTRESS", true)?.boolean
		isNotForbidden[LOTRWaypoint.SANDHILL_TOWN] =
			configuration?.get("waypoints", "Enable SANDHILL_TOWN", true)?.boolean
		isNotForbidden[LOTRWaypoint.COAST_RIVER_TOWN] =
			configuration?.get("waypoints", "Enable COAST_RIVER_TOWN", true)?.boolean
		isNotForbidden[LOTRWaypoint.COAST_CITY] = configuration?.get("waypoints", "Enable COAST_CITY", true)?.boolean
		isNotForbidden[LOTRWaypoint.DESERT_TOWN] = configuration?.get("waypoints", "Enable DESERT_TOWN", true)?.boolean
		isNotForbidden[LOTRWaypoint.SOUTH_DESERT_TOWN] =
			configuration?.get("waypoints", "Enable SOUTH_DESERT_TOWN", true)?.boolean
		isNotForbidden[LOTRWaypoint.DESERT_RIVER_TOWN] =
			configuration?.get("waypoints", "Enable DESERT_RIVER_TOWN", true)?.boolean
		isNotForbidden[LOTRWaypoint.GULF_OF_HARAD] =
			configuration?.get("waypoints", "Enable GULF_OF_HARAD", true)?.boolean
		isNotForbidden[LOTRWaypoint.GULF_CITY] = configuration?.get("waypoints", "Enable GULF_CITY", true)?.boolean
		isNotForbidden[LOTRWaypoint.GULF_FORD] = configuration?.get("waypoints", "Enable GULF_FORD", true)?.boolean
		isNotForbidden[LOTRWaypoint.GULF_TRADE_TOWN] =
			configuration?.get("waypoints", "Enable GULF_TRADE_TOWN", true)?.boolean
		isNotForbidden[LOTRWaypoint.GULF_NORTH_TOWN] =
			configuration?.get("waypoints", "Enable GULF_NORTH_TOWN", true)?.boolean
		isNotForbidden[LOTRWaypoint.GULF_EAST_BAY] =
			configuration?.get("waypoints", "Enable GULF_EAST_BAY", true)?.boolean
		isNotForbidden[LOTRWaypoint.GULF_EAST_PORT] =
			configuration?.get("waypoints", "Enable GULF_EAST_PORT", true)?.boolean
		isNotForbidden[LOTRWaypoint.MOUNT_SAND] = configuration?.get("waypoints", "Enable MOUNT_SAND", true)?.boolean
		isNotForbidden[LOTRWaypoint.MOUNT_GREEN] = configuration?.get("waypoints", "Enable MOUNT_GREEN", true)?.boolean
		isNotForbidden[LOTRWaypoint.MOUNT_THUNDER] =
			configuration?.get("waypoints", "Enable MOUNT_THUNDER", true)?.boolean
		isNotForbidden[LOTRWaypoint.GREAT_PLAINS_NORTH] =
			configuration?.get("waypoints", "Enable GREAT_PLAINS_NORTH", true)?.boolean
		isNotForbidden[LOTRWaypoint.GREAT_PLAINS_SOUTH] =
			configuration?.get("waypoints", "Enable GREAT_PLAINS_SOUTH", true)?.boolean
		isNotForbidden[LOTRWaypoint.GREAT_PLAINS_WEST] =
			configuration?.get("waypoints", "Enable GREAT_PLAINS_WEST", true)?.boolean
		isNotForbidden[LOTRWaypoint.GREAT_PLAINS_EAST] =
			configuration?.get("waypoints", "Enable GREAT_PLAINS_EAST", true)?.boolean
		isNotForbidden[LOTRWaypoint.GREEN_VALLEY] =
			configuration?.get("waypoints", "Enable GREEN_VALLEY", true)?.boolean
		isNotForbidden[LOTRWaypoint.HARAD_LAKES] = configuration?.get("waypoints", "Enable HARAD_LAKES", true)?.boolean
		isNotForbidden[LOTRWaypoint.LAKE_HARAD] = configuration?.get("waypoints", "Enable LAKE_HARAD", true)?.boolean
		isNotForbidden[LOTRWaypoint.HARADUIN_MOUTH] =
			configuration?.get("waypoints", "Enable HARADUIN_MOUTH", true)?.boolean
		isNotForbidden[LOTRWaypoint.ISLE_MIST] = configuration?.get("waypoints", "Enable ISLE_MIST", true)?.boolean
		isNotForbidden[LOTRWaypoint.TAURELONDE] = configuration?.get("waypoints", "Enable TAURELONDE", true)?.boolean
		isNotForbidden[LOTRWaypoint.HARAD_HORN] = configuration?.get("waypoints", "Enable HARAD_HORN", true)?.boolean
		isNotForbidden[LOTRWaypoint.TOWN_BONES] = configuration?.get("waypoints", "Enable TOWN_BONES", true)?.boolean
		isNotForbidden[LOTRWaypoint.HARADUIN_BRIDGE] =
			configuration?.get("waypoints", "Enable HARADUIN_BRIDGE", true)?.boolean
		isNotForbidden[LOTRWaypoint.JUNGLE_CITY_TRADE] =
			configuration?.get("waypoints", "Enable JUNGLE_CITY_TRADE", true)?.boolean
		isNotForbidden[LOTRWaypoint.JUNGLE_CITY_OLD] =
			configuration?.get("waypoints", "Enable JUNGLE_CITY_OLD", true)?.boolean
		isNotForbidden[LOTRWaypoint.JUNGLE_CITY_NORTH] =
			configuration?.get("waypoints", "Enable JUNGLE_CITY_NORTH", true)?.boolean
		isNotForbidden[LOTRWaypoint.JUNGLE_CITY_EAST] =
			configuration?.get("waypoints", "Enable JUNGLE_CITY_EAST", true)?.boolean
		isNotForbidden[LOTRWaypoint.JUNGLE_CITY_CAPITAL] =
			configuration?.get("waypoints", "Enable JUNGLE_CITY_CAPITAL", true)?.boolean
		isNotForbidden[LOTRWaypoint.JUNGLE_CITY_DEEP] =
			configuration?.get("waypoints", "Enable JUNGLE_CITY_DEEP", true)?.boolean
		isNotForbidden[LOTRWaypoint.JUNGLE_CITY_WATCH] =
			configuration?.get("waypoints", "Enable JUNGLE_CITY_WATCH", true)?.boolean
		isNotForbidden[LOTRWaypoint.JUNGLE_CITY_CAVES] =
			configuration?.get("waypoints", "Enable JUNGLE_CITY_CAVES", true)?.boolean
		isNotForbidden[LOTRWaypoint.JUNGLE_CITY_STONE] =
			configuration?.get("waypoints", "Enable JUNGLE_CITY_STONE", true)?.boolean
		isNotForbidden[LOTRWaypoint.JUNGLE_LAKES] =
			configuration?.get("waypoints", "Enable JUNGLE_LAKES", true)?.boolean
		isNotForbidden[LOTRWaypoint.TROLL_ISLAND] =
			configuration?.get("waypoints", "Enable TROLL_ISLAND", true)?.boolean
		isNotForbidden[LOTRWaypoint.BLACK_COAST] = configuration?.get("waypoints", "Enable BLACK_COAST", true)?.boolean
		isNotForbidden[LOTRWaypoint.BLOOD_RIVER] = configuration?.get("waypoints", "Enable BLOOD_RIVER", true)?.boolean
		isNotForbidden[LOTRWaypoint.SHADOW_POINT] =
			configuration?.get("waypoints", "Enable SHADOW_POINT", true)?.boolean
		isNotForbidden[LOTRWaypoint.OLD_JUNGLE_RUIN] =
			configuration?.get("waypoints", "Enable OLD_JUNGLE_RUIN", true)?.boolean
		if ((configuration ?: return).hasChanged()) {
			(configuration ?: return).save()
		}
	}

	fun preInit() {
		configuration = Configuration(File("config", "Genst II.cfg"))
		load()
	}

	fun isNotForbidden(wp: LOTRWaypoint): Boolean? {
		return isNotForbidden[wp]
	}
}