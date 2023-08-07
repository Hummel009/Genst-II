package genst

import lotr.common.world.map.LOTRWaypoint
import net.minecraftforge.common.config.Configuration
import java.io.File
import java.util.*

object GenstConfig {
	private var cfg: Configuration? = null
	private var on: MutableMap<LOTRWaypoint, Boolean?> = EnumMap(LOTRWaypoint::class.java)

	fun load() {
		on[LOTRWaypoint.HIMLING] = cfg?.get("waypoints", "Enable HIMLING", true)?.boolean
		on[LOTRWaypoint.TOL_FUIN] = cfg?.get("waypoints", "Enable TOL_FUIN", true)?.boolean
		on[LOTRWaypoint.TOL_MORWEN] = cfg?.get("waypoints", "Enable TOL_MORWEN", true)?.boolean
		on[LOTRWaypoint.MENELTARMA_SUMMIT] = cfg?.get("waypoints", "Enable MENELTARMA_SUMMIT", true)?.boolean
		on[LOTRWaypoint.HOBBITON] = cfg?.get("waypoints", "Enable HOBBITON", true)?.boolean
		on[LOTRWaypoint.BRANDYWINE_BRIDGE] = cfg?.get("waypoints", "Enable BRANDYWINE_BRIDGE", true)?.boolean
		on[LOTRWaypoint.SARN_FORD] = cfg?.get("waypoints", "Enable SARN_FORD", true)?.boolean
		on[LOTRWaypoint.LONGBOTTOM] = cfg?.get("waypoints", "Enable LONGBOTTOM", true)?.boolean
		on[LOTRWaypoint.MICHEL_DELVING] = cfg?.get("waypoints", "Enable MICHEL_DELVING", true)?.boolean
		on[LOTRWaypoint.WILLOWBOTTOM] = cfg?.get("waypoints", "Enable WILLOWBOTTOM", true)?.boolean
		on[LOTRWaypoint.BUCKLEBURY] = cfg?.get("waypoints", "Enable BUCKLEBURY", true)?.boolean
		on[LOTRWaypoint.WHITFURROWS] = cfg?.get("waypoints", "Enable WHITFURROWS", true)?.boolean
		on[LOTRWaypoint.FROGMORTON] = cfg?.get("waypoints", "Enable FROGMORTON", true)?.boolean
		on[LOTRWaypoint.OATBARTON] = cfg?.get("waypoints", "Enable OATBARTON", true)?.boolean
		on[LOTRWaypoint.SCARY] = cfg?.get("waypoints", "Enable SCARY", true)?.boolean
		on[LOTRWaypoint.NEEDLEHOLE] = cfg?.get("waypoints", "Enable NEEDLEHOLE", true)?.boolean
		on[LOTRWaypoint.LITTLE_DELVING] = cfg?.get("waypoints", "Enable LITTLE_DELVING", true)?.boolean
		on[LOTRWaypoint.WAYMEET] = cfg?.get("waypoints", "Enable WAYMEET", true)?.boolean
		on[LOTRWaypoint.TUCKBOROUGH] = cfg?.get("waypoints", "Enable TUCKBOROUGH", true)?.boolean
		on[LOTRWaypoint.NOBOTTLE] = cfg?.get("waypoints", "Enable NOBOTTLE", true)?.boolean
		on[LOTRWaypoint.TIGHFIELD] = cfg?.get("waypoints", "Enable TIGHFIELD", true)?.boolean
		on[LOTRWaypoint.BROCKENBORINGS] = cfg?.get("waypoints", "Enable BROCKENBORINGS", true)?.boolean
		on[LOTRWaypoint.DEEPHALLOW] = cfg?.get("waypoints", "Enable DEEPHALLOW", true)?.boolean
		on[LOTRWaypoint.STOCK] = cfg?.get("waypoints", "Enable STOCK", true)?.boolean
		on[LOTRWaypoint.BYWATER] = cfg?.get("waypoints", "Enable BYWATER", true)?.boolean
		on[LOTRWaypoint.OVERHILL] = cfg?.get("waypoints", "Enable OVERHILL", true)?.boolean
		on[LOTRWaypoint.HAYSEND] = cfg?.get("waypoints", "Enable HAYSEND", true)?.boolean
		on[LOTRWaypoint.HAY_GATE] = cfg?.get("waypoints", "Enable HAY_GATE", true)?.boolean
		on[LOTRWaypoint.GREENHOLM] = cfg?.get("waypoints", "Enable GREENHOLM", true)?.boolean
		on[LOTRWaypoint.WITHYWINDLE_VALLEY] = cfg?.get("waypoints", "Enable WITHYWINDLE_VALLEY", true)?.boolean
		on[LOTRWaypoint.FORLOND] = cfg?.get("waypoints", "Enable FORLOND", true)?.boolean
		on[LOTRWaypoint.HARLOND] = cfg?.get("waypoints", "Enable HARLOND", true)?.boolean
		on[LOTRWaypoint.MITHLOND_NORTH] = cfg?.get("waypoints", "Enable MITHLOND_NORTH", true)?.boolean
		on[LOTRWaypoint.MITHLOND_SOUTH] = cfg?.get("waypoints", "Enable MITHLOND_SOUTH", true)?.boolean
		on[LOTRWaypoint.FORLINDON] = cfg?.get("waypoints", "Enable FORLINDON", true)?.boolean
		on[LOTRWaypoint.HARLINDON] = cfg?.get("waypoints", "Enable HARLINDON", true)?.boolean
		on[LOTRWaypoint.TOWER_HILLS] = cfg?.get("waypoints", "Enable TOWER_HILLS", true)?.boolean
		on[LOTRWaypoint.AMON_EREB] = cfg?.get("waypoints", "Enable AMON_EREB", true)?.boolean
		on[LOTRWaypoint.BELEGOST] = cfg?.get("waypoints", "Enable BELEGOST", true)?.boolean
		on[LOTRWaypoint.NOGROD] = cfg?.get("waypoints", "Enable NOGROD", true)?.boolean
		on[LOTRWaypoint.MOUNT_RERIR] = cfg?.get("waypoints", "Enable MOUNT_RERIR", true)?.boolean
		on[LOTRWaypoint.MOUNT_DOLMED] = cfg?.get("waypoints", "Enable MOUNT_DOLMED", true)?.boolean
		on[LOTRWaypoint.THORIN_HALLS] = cfg?.get("waypoints", "Enable THORIN_HALLS", true)?.boolean
		on[LOTRWaypoint.ARVEDUI_MINES] = cfg?.get("waypoints", "Enable ARVEDUI_MINES", true)?.boolean
		on[LOTRWaypoint.THRAIN_HALLS] = cfg?.get("waypoints", "Enable THRAIN_HALLS", true)?.boolean
		on[LOTRWaypoint.NORTH_DOWNS] = cfg?.get("waypoints", "Enable NORTH_DOWNS", true)?.boolean
		on[LOTRWaypoint.SOUTH_DOWNS] = cfg?.get("waypoints", "Enable SOUTH_DOWNS", true)?.boolean
		on[LOTRWaypoint.ERYN_VORN] = cfg?.get("waypoints", "Enable ERYN_VORN", true)?.boolean
		on[LOTRWaypoint.THARBAD] = cfg?.get("waypoints", "Enable THARBAD", true)?.boolean
		on[LOTRWaypoint.FORNOST] = cfg?.get("waypoints", "Enable FORNOST", true)?.boolean
		on[LOTRWaypoint.ANNUMINAS] = cfg?.get("waypoints", "Enable ANNUMINAS", true)?.boolean
		on[LOTRWaypoint.GREENWAY_CROSSROADS] = cfg?.get("waypoints", "Enable GREENWAY_CROSSROADS", true)?.boolean
		on[LOTRWaypoint.BREE] = cfg?.get("waypoints", "Enable BREE", true)?.boolean
		on[LOTRWaypoint.STADDLE] = cfg?.get("waypoints", "Enable STADDLE", true)?.boolean
		on[LOTRWaypoint.COMBE] = cfg?.get("waypoints", "Enable COMBE", true)?.boolean
		on[LOTRWaypoint.ARCHET] = cfg?.get("waypoints", "Enable ARCHET", true)?.boolean
		on[LOTRWaypoint.FORSAKEN_INN] = cfg?.get("waypoints", "Enable FORSAKEN_INN", true)?.boolean
		on[LOTRWaypoint.WEATHERTOP] = cfg?.get("waypoints", "Enable WEATHERTOP", true)?.boolean
		on[LOTRWaypoint.LAST_BRIDGE] = cfg?.get("waypoints", "Enable LAST_BRIDGE", true)?.boolean
		on[LOTRWaypoint.OLD_ELF_WAY] = cfg?.get("waypoints", "Enable OLD_ELF_WAY", true)?.boolean
		on[LOTRWaypoint.RIVENDELL] = cfg?.get("waypoints", "Enable RIVENDELL", true)?.boolean
		on[LOTRWaypoint.FORD_BRUINEN] = cfg?.get("waypoints", "Enable FORD_BRUINEN", true)?.boolean
		on[LOTRWaypoint.THE_TROLLSHAWS] = cfg?.get("waypoints", "Enable THE_TROLLSHAWS", true)?.boolean
		on[LOTRWaypoint.CARN_DUM] = cfg?.get("waypoints", "Enable CARN_DUM", true)?.boolean
		on[LOTRWaypoint.WEST_GATE] = cfg?.get("waypoints", "Enable WEST_GATE", true)?.boolean
		on[LOTRWaypoint.OST_IN_EDHIL] = cfg?.get("waypoints", "Enable OST_IN_EDHIL", true)?.boolean
		on[LOTRWaypoint.NORTH_DUNLAND] = cfg?.get("waypoints", "Enable NORTH_DUNLAND", true)?.boolean
		on[LOTRWaypoint.SOUTH_DUNLAND] = cfg?.get("waypoints", "Enable SOUTH_DUNLAND", true)?.boolean
		on[LOTRWaypoint.FORDS_OF_ISEN] = cfg?.get("waypoints", "Enable FORDS_OF_ISEN", true)?.boolean
		on[LOTRWaypoint.DWARROWVALE] = cfg?.get("waypoints", "Enable DWARROWVALE", true)?.boolean
		on[LOTRWaypoint.WULFBURG] = cfg?.get("waypoints", "Enable WULFBURG", true)?.boolean
		on[LOTRWaypoint.LOND_DAER] = cfg?.get("waypoints", "Enable LOND_DAER", true)?.boolean
		on[LOTRWaypoint.ENEDWAITH_ROAD] = cfg?.get("waypoints", "Enable ENEDWAITH_ROAD", true)?.boolean
		on[LOTRWaypoint.MOUTHS_ISEN] = cfg?.get("waypoints", "Enable MOUTHS_ISEN", true)?.boolean
		on[LOTRWaypoint.ISENGARD] = cfg?.get("waypoints", "Enable ISENGARD", true)?.boolean
		on[LOTRWaypoint.CAPE_OF_FOROCHEL] = cfg?.get("waypoints", "Enable CAPE_OF_FOROCHEL", true)?.boolean
		on[LOTRWaypoint.SOUTH_FOROCHEL] = cfg?.get("waypoints", "Enable SOUTH_FOROCHEL", true)?.boolean
		on[LOTRWaypoint.WITHERED_HEATH] = cfg?.get("waypoints", "Enable WITHERED_HEATH", true)?.boolean
		on[LOTRWaypoint.MOUNT_GUNDABAD] = cfg?.get("waypoints", "Enable MOUNT_GUNDABAD", true)?.boolean
		on[LOTRWaypoint.MOUNT_GRAM] = cfg?.get("waypoints", "Enable MOUNT_GRAM", true)?.boolean
		on[LOTRWaypoint.HIGH_PASS] = cfg?.get("waypoints", "Enable HIGH_PASS", true)?.boolean
		on[LOTRWaypoint.MOUNT_CARADHRAS] = cfg?.get("waypoints", "Enable MOUNT_CARADHRAS", true)?.boolean
		on[LOTRWaypoint.MOUNT_CELEBDIL] = cfg?.get("waypoints", "Enable MOUNT_CELEBDIL", true)?.boolean
		on[LOTRWaypoint.MOUNT_FANUIDHOL] = cfg?.get("waypoints", "Enable MOUNT_FANUIDHOL", true)?.boolean
		on[LOTRWaypoint.MOUNT_METHEDRAS] = cfg?.get("waypoints", "Enable MOUNT_METHEDRAS", true)?.boolean
		on[LOTRWaypoint.GOBLIN_TOWN] = cfg?.get("waypoints", "Enable GOBLIN_TOWN", true)?.boolean
		on[LOTRWaypoint.EAGLES_EYRIE] = cfg?.get("waypoints", "Enable EAGLES_EYRIE", true)?.boolean
		on[LOTRWaypoint.DAINS_HALLS] = cfg?.get("waypoints", "Enable DAINS_HALLS", true)?.boolean
		on[LOTRWaypoint.SCATHA] = cfg?.get("waypoints", "Enable SCATHA", true)?.boolean
		on[LOTRWaypoint.CARROCK] = cfg?.get("waypoints", "Enable CARROCK", true)?.boolean
		on[LOTRWaypoint.OLD_FORD] = cfg?.get("waypoints", "Enable OLD_FORD", true)?.boolean
		on[LOTRWaypoint.GLADDEN_FIELDS] = cfg?.get("waypoints", "Enable GLADDEN_FIELDS", true)?.boolean
		on[LOTRWaypoint.DIMRILL_DALE] = cfg?.get("waypoints", "Enable DIMRILL_DALE", true)?.boolean
		on[LOTRWaypoint.FIELD_OF_CELEBRANT] = cfg?.get("waypoints", "Enable FIELD_OF_CELEBRANT", true)?.boolean
		on[LOTRWaypoint.RAUROS] = cfg?.get("waypoints", "Enable RAUROS", true)?.boolean
		on[LOTRWaypoint.BEORN] = cfg?.get("waypoints", "Enable BEORN", true)?.boolean
		on[LOTRWaypoint.FOREST_GATE] = cfg?.get("waypoints", "Enable FOREST_GATE", true)?.boolean
		on[LOTRWaypoint.FRAMSBURG] = cfg?.get("waypoints", "Enable FRAMSBURG", true)?.boolean
		on[LOTRWaypoint.ANDUIN_CROSSROADS] = cfg?.get("waypoints", "Enable ANDUIN_CROSSROADS", true)?.boolean
		on[LOTRWaypoint.EAST_RHOVANION_ROAD] = cfg?.get("waypoints", "Enable EAST_RHOVANION_ROAD", true)?.boolean
		on[LOTRWaypoint.THRANDUIL_HALLS] = cfg?.get("waypoints", "Enable THRANDUIL_HALLS", true)?.boolean
		on[LOTRWaypoint.DOL_GULDUR] = cfg?.get("waypoints", "Enable DOL_GULDUR", true)?.boolean
		on[LOTRWaypoint.MIRKWOOD_MOUNTAINS] = cfg?.get("waypoints", "Enable MIRKWOOD_MOUNTAINS", true)?.boolean
		on[LOTRWaypoint.RHOSGOBEL] = cfg?.get("waypoints", "Enable RHOSGOBEL", true)?.boolean
		on[LOTRWaypoint.ENCHANTED_RIVER] = cfg?.get("waypoints", "Enable ENCHANTED_RIVER", true)?.boolean
		on[LOTRWaypoint.RIVER_GATE] = cfg?.get("waypoints", "Enable RIVER_GATE", true)?.boolean
		on[LOTRWaypoint.EAST_BIGHT] = cfg?.get("waypoints", "Enable EAST_BIGHT", true)?.boolean
		on[LOTRWaypoint.OLD_RHOVANION] = cfg?.get("waypoints", "Enable OLD_RHOVANION", true)?.boolean
		on[LOTRWaypoint.DORWINION_CROSSROADS] = cfg?.get("waypoints", "Enable DORWINION_CROSSROADS", true)?.boolean
		on[LOTRWaypoint.EREBOR] = cfg?.get("waypoints", "Enable EREBOR", true)?.boolean
		on[LOTRWaypoint.DALE_CITY] = cfg?.get("waypoints", "Enable DALE_CITY", true)?.boolean
		on[LOTRWaypoint.LONG_LAKE] = cfg?.get("waypoints", "Enable LONG_LAKE", true)?.boolean
		on[LOTRWaypoint.RUNNING_FORD] = cfg?.get("waypoints", "Enable RUNNING_FORD", true)?.boolean
		on[LOTRWaypoint.REDWATER_FORD] = cfg?.get("waypoints", "Enable REDWATER_FORD", true)?.boolean
		on[LOTRWaypoint.DALE_CROSSROADS] = cfg?.get("waypoints", "Enable DALE_CROSSROADS", true)?.boolean
		on[LOTRWaypoint.DALE_PORT] = cfg?.get("waypoints", "Enable DALE_PORT", true)?.boolean
		on[LOTRWaypoint.WEST_PEAK] = cfg?.get("waypoints", "Enable WEST_PEAK", true)?.boolean
		on[LOTRWaypoint.EAST_PEAK] = cfg?.get("waypoints", "Enable EAST_PEAK", true)?.boolean
		on[LOTRWaypoint.CARAS_GALADHON] = cfg?.get("waypoints", "Enable CARAS_GALADHON", true)?.boolean
		on[LOTRWaypoint.CERIN_AMROTH] = cfg?.get("waypoints", "Enable CERIN_AMROTH", true)?.boolean
		on[LOTRWaypoint.NIMRODEL] = cfg?.get("waypoints", "Enable NIMRODEL", true)?.boolean
		on[LOTRWaypoint.DERNDINGLE] = cfg?.get("waypoints", "Enable DERNDINGLE", true)?.boolean
		on[LOTRWaypoint.WELLINGHALL] = cfg?.get("waypoints", "Enable WELLINGHALL", true)?.boolean
		on[LOTRWaypoint.TREEBEARD_HILL] = cfg?.get("waypoints", "Enable TREEBEARD_HILL", true)?.boolean
		on[LOTRWaypoint.WOLD] = cfg?.get("waypoints", "Enable WOLD", true)?.boolean
		on[LOTRWaypoint.EDORAS] = cfg?.get("waypoints", "Enable EDORAS", true)?.boolean
		on[LOTRWaypoint.HELMS_DEEP] = cfg?.get("waypoints", "Enable HELMS_DEEP", true)?.boolean
		on[LOTRWaypoint.HELMS_CROSSROADS] = cfg?.get("waypoints", "Enable HELMS_CROSSROADS", true)?.boolean
		on[LOTRWaypoint.URUK_HIGHLANDS] = cfg?.get("waypoints", "Enable URUK_HIGHLANDS", true)?.boolean
		on[LOTRWaypoint.MERING_STREAM] = cfg?.get("waypoints", "Enable MERING_STREAM", true)?.boolean
		on[LOTRWaypoint.ENTWADE] = cfg?.get("waypoints", "Enable ENTWADE", true)?.boolean
		on[LOTRWaypoint.EASTMARK] = cfg?.get("waypoints", "Enable EASTMARK", true)?.boolean
		on[LOTRWaypoint.ALDBURG] = cfg?.get("waypoints", "Enable ALDBURG", true)?.boolean
		on[LOTRWaypoint.GRIMSLADE] = cfg?.get("waypoints", "Enable GRIMSLADE", true)?.boolean
		on[LOTRWaypoint.CORSAIRS_LANDING] = cfg?.get("waypoints", "Enable CORSAIRS_LANDING", true)?.boolean
		on[LOTRWaypoint.FRECA_HOLD] = cfg?.get("waypoints", "Enable FRECA_HOLD", true)?.boolean
		on[LOTRWaypoint.DUNHARROW] = cfg?.get("waypoints", "Enable DUNHARROW", true)?.boolean
		on[LOTRWaypoint.TARLANG] = cfg?.get("waypoints", "Enable TARLANG", true)?.boolean
		on[LOTRWaypoint.RAS_MORTHIL] = cfg?.get("waypoints", "Enable RAS_MORTHIL", true)?.boolean
		on[LOTRWaypoint.MINAS_TIRITH] = cfg?.get("waypoints", "Enable MINAS_TIRITH", true)?.boolean
		on[LOTRWaypoint.CAIR_ANDROS] = cfg?.get("waypoints", "Enable CAIR_ANDROS", true)?.boolean
		on[LOTRWaypoint.HALIFIRIEN] = cfg?.get("waypoints", "Enable HALIFIRIEN", true)?.boolean
		on[LOTRWaypoint.CALENHAD] = cfg?.get("waypoints", "Enable CALENHAD", true)?.boolean
		on[LOTRWaypoint.MINRIMMON] = cfg?.get("waypoints", "Enable MINRIMMON", true)?.boolean
		on[LOTRWaypoint.ERELAS] = cfg?.get("waypoints", "Enable ERELAS", true)?.boolean
		on[LOTRWaypoint.NARDOL] = cfg?.get("waypoints", "Enable NARDOL", true)?.boolean
		on[LOTRWaypoint.EILENACH] = cfg?.get("waypoints", "Enable EILENACH", true)?.boolean
		on[LOTRWaypoint.AMON_DIN] = cfg?.get("waypoints", "Enable AMON_DIN", true)?.boolean
		on[LOTRWaypoint.OSGILIATH_WEST] = cfg?.get("waypoints", "Enable OSGILIATH_WEST", true)?.boolean
		on[LOTRWaypoint.OSGILIATH_EAST] = cfg?.get("waypoints", "Enable OSGILIATH_EAST", true)?.boolean
		on[LOTRWaypoint.EMYN_ARNEN] = cfg?.get("waypoints", "Enable EMYN_ARNEN", true)?.boolean
		on[LOTRWaypoint.HENNETH_ANNUN] = cfg?.get("waypoints", "Enable HENNETH_ANNUN", true)?.boolean
		on[LOTRWaypoint.CROSSROADS_ITHILIEN] = cfg?.get("waypoints", "Enable CROSSROADS_ITHILIEN", true)?.boolean
		on[LOTRWaypoint.NORTH_ITHILIEN] = cfg?.get("waypoints", "Enable NORTH_ITHILIEN", true)?.boolean
		on[LOTRWaypoint.CROSSINGS_OF_POROS] = cfg?.get("waypoints", "Enable CROSSINGS_OF_POROS", true)?.boolean
		on[LOTRWaypoint.PELARGIR] = cfg?.get("waypoints", "Enable PELARGIR", true)?.boolean
		on[LOTRWaypoint.LINHIR] = cfg?.get("waypoints", "Enable LINHIR", true)?.boolean
		on[LOTRWaypoint.ANDUIN_MOUTH] = cfg?.get("waypoints", "Enable ANDUIN_MOUTH", true)?.boolean
		on[LOTRWaypoint.IMLOTH_MELUI] = cfg?.get("waypoints", "Enable IMLOTH_MELUI", true)?.boolean
		on[LOTRWaypoint.CROSSINGS_ERUI] = cfg?.get("waypoints", "Enable CROSSINGS_ERUI", true)?.boolean
		on[LOTRWaypoint.CALEMBEL] = cfg?.get("waypoints", "Enable CALEMBEL", true)?.boolean
		on[LOTRWaypoint.ETHRING] = cfg?.get("waypoints", "Enable ETHRING", true)?.boolean
		on[LOTRWaypoint.ERECH] = cfg?.get("waypoints", "Enable ERECH", true)?.boolean
		on[LOTRWaypoint.GREEN_HILLS] = cfg?.get("waypoints", "Enable GREEN_HILLS", true)?.boolean
		on[LOTRWaypoint.DOL_AMROTH] = cfg?.get("waypoints", "Enable DOL_AMROTH", true)?.boolean
		on[LOTRWaypoint.EDHELLOND] = cfg?.get("waypoints", "Enable EDHELLOND", true)?.boolean
		on[LOTRWaypoint.TARNOST] = cfg?.get("waypoints", "Enable TARNOST", true)?.boolean
		on[LOTRWaypoint.TOLFALAS_ISLAND] = cfg?.get("waypoints", "Enable TOLFALAS_ISLAND", true)?.boolean
		on[LOTRWaypoint.AMON_HEN] = cfg?.get("waypoints", "Enable AMON_HEN", true)?.boolean
		on[LOTRWaypoint.AMON_LHAW] = cfg?.get("waypoints", "Enable AMON_LHAW", true)?.boolean
		on[LOTRWaypoint.ARGONATH] = cfg?.get("waypoints", "Enable ARGONATH", true)?.boolean
		on[LOTRWaypoint.NORTH_UNDEEP] = cfg?.get("waypoints", "Enable NORTH_UNDEEP", true)?.boolean
		on[LOTRWaypoint.SOUTH_UNDEEP] = cfg?.get("waypoints", "Enable SOUTH_UNDEEP", true)?.boolean
		on[LOTRWaypoint.MORANNON] = cfg?.get("waypoints", "Enable MORANNON", true)?.boolean
		on[LOTRWaypoint.UDUN] = cfg?.get("waypoints", "Enable UDUN", true)?.boolean
		on[LOTRWaypoint.MOUNT_DOOM] = cfg?.get("waypoints", "Enable MOUNT_DOOM", true)?.boolean
		on[LOTRWaypoint.BARAD_DUR] = cfg?.get("waypoints", "Enable BARAD_DUR", true)?.boolean
		on[LOTRWaypoint.MINAS_MORGUL] = cfg?.get("waypoints", "Enable MINAS_MORGUL", true)?.boolean
		on[LOTRWaypoint.DURTHANG] = cfg?.get("waypoints", "Enable DURTHANG", true)?.boolean
		on[LOTRWaypoint.CARACH_ANGREN] = cfg?.get("waypoints", "Enable CARACH_ANGREN", true)?.boolean
		on[LOTRWaypoint.CIRITH_UNGOL] = cfg?.get("waypoints", "Enable CIRITH_UNGOL", true)?.boolean
		on[LOTRWaypoint.MORIGOST] = cfg?.get("waypoints", "Enable MORIGOST", true)?.boolean
		on[LOTRWaypoint.NARGROTH] = cfg?.get("waypoints", "Enable NARGROTH", true)?.boolean
		on[LOTRWaypoint.AMON_ANGREN] = cfg?.get("waypoints", "Enable AMON_ANGREN", true)?.boolean
		on[LOTRWaypoint.SEREGOST] = cfg?.get("waypoints", "Enable SEREGOST", true)?.boolean
		on[LOTRWaypoint.FELLBEASTS] = cfg?.get("waypoints", "Enable FELLBEASTS", true)?.boolean
		on[LOTRWaypoint.EASTERN_GUARD] = cfg?.get("waypoints", "Enable EASTERN_GUARD", true)?.boolean
		on[LOTRWaypoint.NURNEN_NORTHERN_SHORE] = cfg?.get("waypoints", "Enable NURNEN_NORTHERN_SHORE", true)?.boolean
		on[LOTRWaypoint.NURNEN_SOUTHERN_SHORE] = cfg?.get("waypoints", "Enable NURNEN_SOUTHERN_SHORE", true)?.boolean
		on[LOTRWaypoint.NURNEN_WESTERN_SHORE] = cfg?.get("waypoints", "Enable NURNEN_WESTERN_SHORE", true)?.boolean
		on[LOTRWaypoint.NURNEN_EASTERN_SHORE] = cfg?.get("waypoints", "Enable NURNEN_EASTERN_SHORE", true)?.boolean
		on[LOTRWaypoint.THAURBAND] = cfg?.get("waypoints", "Enable THAURBAND", true)?.boolean
		on[LOTRWaypoint.VALLEY_OF_SPIDERS] = cfg?.get("waypoints", "Enable VALLEY_OF_SPIDERS", true)?.boolean
		on[LOTRWaypoint.DORWINION_PORT] = cfg?.get("waypoints", "Enable DORWINION_PORT", true)?.boolean
		on[LOTRWaypoint.DORWINION_COURT] = cfg?.get("waypoints", "Enable DORWINION_COURT", true)?.boolean
		on[LOTRWaypoint.DORWINION_FORD] = cfg?.get("waypoints", "Enable DORWINION_FORD", true)?.boolean
		on[LOTRWaypoint.DORWINION_HILLS] = cfg?.get("waypoints", "Enable DORWINION_HILLS", true)?.boolean
		on[LOTRWaypoint.RHUN_ROAD_WAY] = cfg?.get("waypoints", "Enable RHUN_ROAD_WAY", true)?.boolean
		on[LOTRWaypoint.BALCARAS] = cfg?.get("waypoints", "Enable BALCARAS", true)?.boolean
		on[LOTRWaypoint.KHAND_NORTH_ROAD] = cfg?.get("waypoints", "Enable KHAND_NORTH_ROAD", true)?.boolean
		on[LOTRWaypoint.RHUN_CAPITAL] = cfg?.get("waypoints", "Enable RHUN_CAPITAL", true)?.boolean
		on[LOTRWaypoint.KHAMUL_TOWER] = cfg?.get("waypoints", "Enable KHAMUL_TOWER", true)?.boolean
		on[LOTRWaypoint.MORDOR_FORD] = cfg?.get("waypoints", "Enable MORDOR_FORD", true)?.boolean
		on[LOTRWaypoint.RHUN_NORTH_CITY] = cfg?.get("waypoints", "Enable RHUN_NORTH_CITY", true)?.boolean
		on[LOTRWaypoint.BAZYLAN] = cfg?.get("waypoints", "Enable BAZYLAN", true)?.boolean
		on[LOTRWaypoint.BORDER_TOWN] = cfg?.get("waypoints", "Enable BORDER_TOWN", true)?.boolean
		on[LOTRWaypoint.RHUN_SEA_CITY] = cfg?.get("waypoints", "Enable RHUN_SEA_CITY", true)?.boolean
		on[LOTRWaypoint.RHUN_NORTH_FORD] = cfg?.get("waypoints", "Enable RHUN_NORTH_FORD", true)?.boolean
		on[LOTRWaypoint.RHUN_NORTHEAST] = cfg?.get("waypoints", "Enable RHUN_NORTHEAST", true)?.boolean
		on[LOTRWaypoint.RHUN_SOUTH_PASS] = cfg?.get("waypoints", "Enable RHUN_SOUTH_PASS", true)?.boolean
		on[LOTRWaypoint.RHUN_EAST_CITY] = cfg?.get("waypoints", "Enable RHUN_EAST_CITY", true)?.boolean
		on[LOTRWaypoint.RHUN_EAST_TOWN] = cfg?.get("waypoints", "Enable RHUN_EAST_TOWN", true)?.boolean
		on[LOTRWaypoint.RHUN_SOUTHEAST] = cfg?.get("waypoints", "Enable RHUN_SOUTHEAST", true)?.boolean
		on[LOTRWaypoint.BARAZ_DUM] = cfg?.get("waypoints", "Enable BARAZ_DUM", true)?.boolean
		on[LOTRWaypoint.CROSSINGS_OF_HARAD] = cfg?.get("waypoints", "Enable CROSSINGS_OF_HARAD", true)?.boolean
		on[LOTRWaypoint.HARNEN_SEA_TOWN] = cfg?.get("waypoints", "Enable HARNEN_SEA_TOWN", true)?.boolean
		on[LOTRWaypoint.HARNEN_ROAD_TOWN] = cfg?.get("waypoints", "Enable HARNEN_ROAD_TOWN", true)?.boolean
		on[LOTRWaypoint.HARNEN_BLACK_TOWN] = cfg?.get("waypoints", "Enable HARNEN_BLACK_TOWN", true)?.boolean
		on[LOTRWaypoint.CROSSINGS_OF_LITHNEN] = cfg?.get("waypoints", "Enable CROSSINGS_OF_LITHNEN", true)?.boolean
		on[LOTRWaypoint.HARNEN_RIVER_TOWN] = cfg?.get("waypoints", "Enable HARNEN_RIVER_TOWN", true)?.boolean
		on[LOTRWaypoint.KHAND_FORD] = cfg?.get("waypoints", "Enable KHAND_FORD", true)?.boolean
		on[LOTRWaypoint.UMBAR_CITY] = cfg?.get("waypoints", "Enable UMBAR_CITY", true)?.boolean
		on[LOTRWaypoint.UMBAR_GATE] = cfg?.get("waypoints", "Enable UMBAR_GATE", true)?.boolean
		on[LOTRWaypoint.GATE_HERUMOR] = cfg?.get("waypoints", "Enable GATE_HERUMOR", true)?.boolean
		on[LOTRWaypoint.CEDAR_ROAD] = cfg?.get("waypoints", "Enable CEDAR_ROAD", true)?.boolean
		on[LOTRWaypoint.FERTILE_VALLEY] = cfg?.get("waypoints", "Enable FERTILE_VALLEY", true)?.boolean
		on[LOTRWaypoint.GARDENS_BERUTHIEL] = cfg?.get("waypoints", "Enable GARDENS_BERUTHIEL", true)?.boolean
		on[LOTRWaypoint.AIN_AL_HARAD] = cfg?.get("waypoints", "Enable AIN_AL_HARAD", true)?.boolean
		on[LOTRWaypoint.GATE_FUINUR] = cfg?.get("waypoints", "Enable GATE_FUINUR", true)?.boolean
		on[LOTRWaypoint.COAST_FORTRESS] = cfg?.get("waypoints", "Enable COAST_FORTRESS", true)?.boolean
		on[LOTRWaypoint.SANDHILL_TOWN] = cfg?.get("waypoints", "Enable SANDHILL_TOWN", true)?.boolean
		on[LOTRWaypoint.COAST_RIVER_TOWN] = cfg?.get("waypoints", "Enable COAST_RIVER_TOWN", true)?.boolean
		on[LOTRWaypoint.COAST_CITY] = cfg?.get("waypoints", "Enable COAST_CITY", true)?.boolean
		on[LOTRWaypoint.DESERT_TOWN] = cfg?.get("waypoints", "Enable DESERT_TOWN", true)?.boolean
		on[LOTRWaypoint.SOUTH_DESERT_TOWN] = cfg?.get("waypoints", "Enable SOUTH_DESERT_TOWN", true)?.boolean
		on[LOTRWaypoint.DESERT_RIVER_TOWN] = cfg?.get("waypoints", "Enable DESERT_RIVER_TOWN", true)?.boolean
		on[LOTRWaypoint.GULF_OF_HARAD] = cfg?.get("waypoints", "Enable GULF_OF_HARAD", true)?.boolean
		on[LOTRWaypoint.GULF_CITY] = cfg?.get("waypoints", "Enable GULF_CITY", true)?.boolean
		on[LOTRWaypoint.GULF_FORD] = cfg?.get("waypoints", "Enable GULF_FORD", true)?.boolean
		on[LOTRWaypoint.GULF_TRADE_TOWN] = cfg?.get("waypoints", "Enable GULF_TRADE_TOWN", true)?.boolean
		on[LOTRWaypoint.GULF_NORTH_TOWN] = cfg?.get("waypoints", "Enable GULF_NORTH_TOWN", true)?.boolean
		on[LOTRWaypoint.GULF_EAST_BAY] = cfg?.get("waypoints", "Enable GULF_EAST_BAY", true)?.boolean
		on[LOTRWaypoint.GULF_EAST_PORT] = cfg?.get("waypoints", "Enable GULF_EAST_PORT", true)?.boolean
		on[LOTRWaypoint.MOUNT_SAND] = cfg?.get("waypoints", "Enable MOUNT_SAND", true)?.boolean
		on[LOTRWaypoint.MOUNT_GREEN] = cfg?.get("waypoints", "Enable MOUNT_GREEN", true)?.boolean
		on[LOTRWaypoint.MOUNT_THUNDER] = cfg?.get("waypoints", "Enable MOUNT_THUNDER", true)?.boolean
		on[LOTRWaypoint.GREAT_PLAINS_NORTH] = cfg?.get("waypoints", "Enable GREAT_PLAINS_NORTH", true)?.boolean
		on[LOTRWaypoint.GREAT_PLAINS_SOUTH] = cfg?.get("waypoints", "Enable GREAT_PLAINS_SOUTH", true)?.boolean
		on[LOTRWaypoint.GREAT_PLAINS_WEST] = cfg?.get("waypoints", "Enable GREAT_PLAINS_WEST", true)?.boolean
		on[LOTRWaypoint.GREAT_PLAINS_EAST] = cfg?.get("waypoints", "Enable GREAT_PLAINS_EAST", true)?.boolean
		on[LOTRWaypoint.GREEN_VALLEY] = cfg?.get("waypoints", "Enable GREEN_VALLEY", true)?.boolean
		on[LOTRWaypoint.HARAD_LAKES] = cfg?.get("waypoints", "Enable HARAD_LAKES", true)?.boolean
		on[LOTRWaypoint.LAKE_HARAD] = cfg?.get("waypoints", "Enable LAKE_HARAD", true)?.boolean
		on[LOTRWaypoint.HARADUIN_MOUTH] = cfg?.get("waypoints", "Enable HARADUIN_MOUTH", true)?.boolean
		on[LOTRWaypoint.ISLE_MIST] = cfg?.get("waypoints", "Enable ISLE_MIST", true)?.boolean
		on[LOTRWaypoint.TAURELONDE] = cfg?.get("waypoints", "Enable TAURELONDE", true)?.boolean
		on[LOTRWaypoint.HARAD_HORN] = cfg?.get("waypoints", "Enable HARAD_HORN", true)?.boolean
		on[LOTRWaypoint.TOWN_BONES] = cfg?.get("waypoints", "Enable TOWN_BONES", true)?.boolean
		on[LOTRWaypoint.HARADUIN_BRIDGE] = cfg?.get("waypoints", "Enable HARADUIN_BRIDGE", true)?.boolean
		on[LOTRWaypoint.JUNGLE_CITY_TRADE] = cfg?.get("waypoints", "Enable JUNGLE_CITY_TRADE", true)?.boolean
		on[LOTRWaypoint.JUNGLE_CITY_OLD] = cfg?.get("waypoints", "Enable JUNGLE_CITY_OLD", true)?.boolean
		on[LOTRWaypoint.JUNGLE_CITY_NORTH] = cfg?.get("waypoints", "Enable JUNGLE_CITY_NORTH", true)?.boolean
		on[LOTRWaypoint.JUNGLE_CITY_EAST] = cfg?.get("waypoints", "Enable JUNGLE_CITY_EAST", true)?.boolean
		on[LOTRWaypoint.JUNGLE_CITY_CAPITAL] = cfg?.get("waypoints", "Enable JUNGLE_CITY_CAPITAL", true)?.boolean
		on[LOTRWaypoint.JUNGLE_CITY_DEEP] = cfg?.get("waypoints", "Enable JUNGLE_CITY_DEEP", true)?.boolean
		on[LOTRWaypoint.JUNGLE_CITY_WATCH] = cfg?.get("waypoints", "Enable JUNGLE_CITY_WATCH", true)?.boolean
		on[LOTRWaypoint.JUNGLE_CITY_CAVES] = cfg?.get("waypoints", "Enable JUNGLE_CITY_CAVES", true)?.boolean
		on[LOTRWaypoint.JUNGLE_CITY_STONE] = cfg?.get("waypoints", "Enable JUNGLE_CITY_STONE", true)?.boolean
		on[LOTRWaypoint.JUNGLE_LAKES] = cfg?.get("waypoints", "Enable JUNGLE_LAKES", true)?.boolean
		on[LOTRWaypoint.TROLL_ISLAND] = cfg?.get("waypoints", "Enable TROLL_ISLAND", true)?.boolean
		on[LOTRWaypoint.BLACK_COAST] = cfg?.get("waypoints", "Enable BLACK_COAST", true)?.boolean
		on[LOTRWaypoint.BLOOD_RIVER] = cfg?.get("waypoints", "Enable BLOOD_RIVER", true)?.boolean
		on[LOTRWaypoint.SHADOW_POINT] = cfg?.get("waypoints", "Enable SHADOW_POINT", true)?.boolean
		on[LOTRWaypoint.OLD_JUNGLE_RUIN] = cfg?.get("waypoints", "Enable OLD_JUNGLE_RUIN", true)?.boolean
		if ((cfg ?: return).hasChanged()) {
			(cfg ?: return).save()
		}
	}

	fun preInit() {
		cfg = Configuration(File("config", "Genst II.cfg"))
		load()
	}

	fun isNotForbidden(wp: LOTRWaypoint): Boolean? {
		return on[wp]
	}
}