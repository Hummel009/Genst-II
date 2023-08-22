package genst.world

import genst.utils.linkTo
import genst.utils.registerRoad
import genst.utils.registerRoadI
import lotr.common.LOTRMod
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.map.LOTRWaypoint
import net.minecraft.init.Blocks
import net.minecraft.world.biome.BiomeGenBase
import java.util.*

object GenstRoads {
	val PATH_COBBLE: LOTRRoadType = object : LOTRRoadType() {
		override fun getBlock(rand: Random, biome: BiomeGenBase, top: Boolean, slab: Boolean): RoadBlock {
			val blockTypes = if (slab) {
				arrayOf(
					RoadBlock(Blocks.stone_slab, 5),
					RoadBlock(Blocks.stone_slab, 3),
					RoadBlock(Blocks.stone_slab, 3),
					RoadBlock(LOTRMod.slabSingleV, 4)
				)
			} else {
				arrayOf(
					RoadBlock(Blocks.stonebrick, 0),
					RoadBlock(Blocks.cobblestone, 0),
					RoadBlock(Blocks.cobblestone, 0),
					RoadBlock(Blocks.mossy_cobblestone, 0)
				)
			}
			return blockTypes[rand.nextInt(blockTypes.size)]
		}
	}

	fun postInit() {
		val gondorTown = 44.0 / 128.0
		val gondorFort = 89.0 / 128.0
		val rhunTown = 34.0 / 128.0
		val rhunFort = 67.0 / 128.0
		val rohanFort = 77.0 / 128.0
		val basicVillage = 111.0 / 128.0
		val ruinedCity = 42.0 / 128.0
		val harnennor = 65.0 / 128.0
		val haradTown = 82.0 / 128.0
		val kopazul = 30.0 / 128.0

		registerRoad(LOTRWaypoint.AIN_AL_HARAD.linkTo(-haradTown + 0.5, 0.0))
		registerRoad(LOTRWaypoint.ANDUIN_CROSSROADS.linkTo(-ruinedCity + 0.2, 0.0))
		registerRoad(LOTRWaypoint.ANNUMINAS.linkTo(-ruinedCity + 0.2, 0.0))
		registerRoad(LOTRWaypoint.BUCKLEBURY.linkTo(basicVillage - 0.6, 0.0))
		registerRoad(LOTRWaypoint.BYWATER.linkTo(0.0, basicVillage - 0.6))
		registerRoad(LOTRWaypoint.CAIR_ANDROS.linkTo(-gondorTown + 0.1, 0.0))
		registerRoad(LOTRWaypoint.DALE_CITY.linkTo(-basicVillage + 0.7, 0.0))
		registerRoad(LOTRWaypoint.DALE_PORT.linkTo(basicVillage - 0.7, 0.0))
		registerRoad(LOTRWaypoint.DEEPHALLOW.linkTo(basicVillage - 0.7, 0.0))
		registerRoad(LOTRWaypoint.DOL_AMROTH.linkTo(-gondorTown + 0.2, 0.0))
		registerRoad(LOTRWaypoint.DORWINION_FORD.linkTo(-basicVillage + 0.7, 0.0))
		registerRoad(LOTRWaypoint.DORWINION_PORT.linkTo(basicVillage - 0.7, 0.0))
		registerRoad(LOTRWaypoint.ENEDWAITH_ROAD.linkTo(ruinedCity, 0.0))
		registerRoad(LOTRWaypoint.FORNOST.linkTo(0.0, -ruinedCity + 0.2))
		registerRoad(LOTRWaypoint.FRAMSBURG.linkTo(-ruinedCity + 0.1, 0.0))
		registerRoad(LOTRWaypoint.FROGMORTON.linkTo(0.0, basicVillage - 0.6))
		registerRoad(LOTRWaypoint.GATE_FUINUR.linkTo(-haradTown + 0.4, 0.0))
		registerRoad(LOTRWaypoint.GATE_HERUMOR.linkTo(-haradTown + 0.5, 0.0))
		registerRoad(LOTRWaypoint.GREENHOLM.linkTo(0.0, -basicVillage + 0.7))
		registerRoad(LOTRWaypoint.GREENWAY_CROSSROADS.linkTo(0.0, ruinedCity - 0.1))
		registerRoad(LOTRWaypoint.GULF_EAST_PORT.linkTo(kopazul - 0.1, 0.0))
		registerRoad(LOTRWaypoint.GULF_NORTH_TOWN.linkTo(0.0, -kopazul + 0.1))
		registerRoad(LOTRWaypoint.GULF_TRADE_TOWN.linkTo(kopazul - 0.1, 0.0))
		registerRoad(LOTRWaypoint.HARNEN_BLACK_TOWN.linkTo(0.0, harnennor - 0.4))
		registerRoad(LOTRWaypoint.HARNEN_RIVER_TOWN.linkTo(0.0, harnennor - 0.4))
		registerRoad(LOTRWaypoint.HARNEN_SEA_TOWN.linkTo(0.0, harnennor - 0.4))
		registerRoad(LOTRWaypoint.HAYSEND.linkTo(0.0, basicVillage - 0.8))
		registerRoad(LOTRWaypoint.HAY_GATE.linkTo(0.0, -basicVillage + 0.8))
		registerRoad(LOTRWaypoint.HOBBITON.linkTo(-basicVillage + 0.7, 0.0))
		registerRoad(LOTRWaypoint.LITTLE_DELVING.linkTo(0.0, -basicVillage + 0.6))
		registerRoad(LOTRWaypoint.LOND_DAER.linkTo(-ruinedCity + 0.2, 0.0))
		registerRoad(LOTRWaypoint.LONG_LAKE.linkTo(0.0, basicVillage - 0.7))
		registerRoad(LOTRWaypoint.MICHEL_DELVING.linkTo(0.0, basicVillage - 0.5))
		registerRoad(LOTRWaypoint.MINAS_TIRITH.linkTo(-gondorTown + 0.1, 0.0))
		registerRoad(LOTRWaypoint.NEEDLEHOLE.linkTo(basicVillage - 0.8, 0.0))
		registerRoad(LOTRWaypoint.NORTH_ITHILIEN.linkTo(ruinedCity - 0.2, 0.0))
		registerRoad(LOTRWaypoint.OATBARTON.linkTo(0.0, -basicVillage + 0.8))
		registerRoad(LOTRWaypoint.OLD_ELF_WAY.linkTo(0.0, -ruinedCity + 0.2))
		registerRoad(LOTRWaypoint.OLD_RHOVANION.linkTo(-ruinedCity, 0.0))
		registerRoad(LOTRWaypoint.OST_IN_EDHIL.linkTo(0.0, -ruinedCity + 0.2))
		registerRoad(LOTRWaypoint.OVERHILL.linkTo(0.0, -basicVillage + 0.8))
		registerRoad(LOTRWaypoint.RHUN_NORTHEAST.linkTo(0.0, -basicVillage + 0.5))
		registerRoad(LOTRWaypoint.RHUN_NORTH_FORD.linkTo(0.0, basicVillage - 0.5))
		registerRoad(LOTRWaypoint.RUNNING_FORD.linkTo(-basicVillage + 0.7, 0.0))
		registerRoad(LOTRWaypoint.SCARY.linkTo(0.0, -basicVillage + 0.8))
		registerRoad(LOTRWaypoint.TARNOST.linkTo(0.0, -gondorTown + 0.1))
		registerRoad(LOTRWaypoint.THARBAD.linkTo(-ruinedCity - 0.4, 0.0))
		registerRoad(LOTRWaypoint.TIGHFIELD.linkTo(0.0, -basicVillage + 0.8))
		registerRoad(LOTRWaypoint.TOWN_BONES.linkTo(0.0, basicVillage - 0.8))
		registerRoad(LOTRWaypoint.TUCKBOROUGH.linkTo(-basicVillage + 0.8, 0.0))
		registerRoad(LOTRWaypoint.WILLOWBOTTOM.linkTo(-basicVillage + 0.8, 0.0))
		registerRoad(LOTRWaypoint.WOLD.linkTo(0.0, -rohanFort + 0.5))

		registerRoadI(LOTRWaypoint.ALDBURG.linkTo(-0.15, rohanFort - 0.4), false)
		registerRoadI(LOTRWaypoint.BAZYLAN.linkTo(0.3, rhunTown + 0.1), false)
		registerRoadI(LOTRWaypoint.BORDER_TOWN.linkTo(0.3, rhunTown + 0.1), false)
		registerRoadI(LOTRWaypoint.CALEMBEL.linkTo(0.2, -gondorTown - 0.1), false)
		registerRoadI(LOTRWaypoint.COAST_FORTRESS.linkTo(-haradTown + 0.4, -0.3), true)
		registerRoadI(LOTRWaypoint.DALE_CROSSROADS.linkTo(-0.3, -basicVillage + 0.1), false)
		registerRoadI(LOTRWaypoint.DORWINION_COURT.linkTo(0.3, -basicVillage + 0.5), false)
		registerRoadI(LOTRWaypoint.DORWINION_CROSSROADS.linkTo(0.5, -basicVillage + 0.5), false)
		registerRoadI(LOTRWaypoint.EAST_RHOVANION_ROAD.linkTo(-ruinedCity + 0.1, 0.3), true)
		registerRoadI(LOTRWaypoint.EDHELLOND.linkTo(-0.2, -ruinedCity + 0.2), false)
		registerRoadI(LOTRWaypoint.EDORAS.linkTo(-0.3, rohanFort - 0.4), false)
		registerRoadI(LOTRWaypoint.ENTWADE.linkTo(-rohanFort + 0.3, -0.1), true)
		registerRoadI(LOTRWaypoint.ETHRING.linkTo(gondorTown, -0.2), true)
		registerRoadI(LOTRWaypoint.FERTILE_VALLEY.linkTo(-haradTown + 0.4, -0.1), true)
		registerRoadI(LOTRWaypoint.GARDENS_BERUTHIEL.linkTo(-haradTown + 0.4, -0.3), true)
		registerRoadI(LOTRWaypoint.GRIMSLADE.linkTo(-0.2, rohanFort - 0.4), false)
		registerRoadI(LOTRWaypoint.GULF_CITY.linkTo(kopazul, -0.1), true)
		registerRoadI(LOTRWaypoint.GULF_OF_HARAD.linkTo(kopazul, -0.3), true)
		registerRoadI(LOTRWaypoint.HARNEN_ROAD_TOWN.linkTo(0.2, -harnennor + 0.2), false)
		registerRoadI(LOTRWaypoint.HELMS_CROSSROADS.linkTo(0.4, -rohanFort + 0.3), false)
		registerRoadI(LOTRWaypoint.HELMS_DEEP.linkTo(-0.4, rohanFort - 0.3), false)
		registerRoadI(LOTRWaypoint.LINHIR.linkTo(-0.2, gondorTown - 0.1), false)
		registerRoadI(LOTRWaypoint.LONGBOTTOM.linkTo(0.5, -basicVillage + 0.5), false)
		registerRoadI(LOTRWaypoint.MERING_STREAM.linkTo(-0.4, rohanFort - 0.3), false)
		registerRoadI(LOTRWaypoint.MORDOR_FORD.linkTo(-0.4, -rhunFort + 0.2), false)
		registerRoadI(LOTRWaypoint.NOBOTTLE.linkTo(-0.1, -basicVillage + 0.5), false)
		registerRoadI(LOTRWaypoint.PELARGIR.linkTo(-0.1, -gondorTown), false)
		registerRoadI(LOTRWaypoint.REDWATER_FORD.linkTo(-0.2, basicVillage - 0.6), false)
		registerRoadI(LOTRWaypoint.RHUN_CAPITAL.linkTo(-rhunTown - 0.2, 0.5), true)
		registerRoadI(LOTRWaypoint.RHUN_EAST_CITY.linkTo(0.0, rhunTown - 0.1), false)
		registerRoadI(LOTRWaypoint.RHUN_EAST_TOWN.linkTo(0.3, -rhunTown), false)
		registerRoadI(LOTRWaypoint.RHUN_NORTH_CITY.linkTo(-rhunTown + 0.1, 0.0), true)
		registerRoadI(LOTRWaypoint.RHUN_SEA_CITY.linkTo(0.0, -rhunTown + 0.1), false)
		registerRoadI(LOTRWaypoint.RHUN_SOUTHEAST.linkTo(rhunFort - 0.2, -0.1), true)
		registerRoadI(LOTRWaypoint.RHUN_SOUTH_PASS.linkTo(rhunTown, 0.2), true)
		registerRoadI(LOTRWaypoint.STOCK.linkTo(basicVillage - 0.6, -0.1), true)
		registerRoadI(LOTRWaypoint.TARLANG.linkTo(-0.1, gondorFort - 0.4), false)
		registerRoadI(LOTRWaypoint.UMBAR_GATE.linkTo(-0.2, haradTown - 0.4), false)
		registerRoadI(LOTRWaypoint.UMBAR_CITY.linkTo(-haradTown + 0.4, -0.2), true)
		registerRoadI(LOTRWaypoint.WAYMEET.linkTo(-basicVillage, -0.5), true)
		registerRoadI(LOTRWaypoint.WHITFURROWS.linkTo(0.6, -basicVillage + 0.4), false)
	}
}