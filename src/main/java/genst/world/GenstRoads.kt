package genst.world

import genst.utils.*
import lotr.common.world.map.LOTRWaypoint

object GenstRoads {
	fun postInit() {
		registerRoad(LOTRWaypoint.AIN_AL_HARAD.linkTo((-0.5).toHaradTown(), 0.0))
		registerRoad(LOTRWaypoint.ANDUIN_CROSSROADS.linkTo((-0.8).toBasicTown(), 0.0))
		registerRoad(LOTRWaypoint.ANNUMINAS.linkTo((-0.8).toBasicTown(), 0.0))
		registerRoad(LOTRWaypoint.BUCKLEBURY.linkTo((0.4).toBasicVillage(), 0.0))
		registerRoad(LOTRWaypoint.BYWATER.linkTo(0.0, (0.4).toBasicVillage()))
		registerRoad(LOTRWaypoint.CAIR_ANDROS.linkTo((-1.0).toGondorTown(), 0.0))
		registerRoad(LOTRWaypoint.DALE_CITY.linkTo((-0.3).toBasicVillage(), 0.0))
		registerRoad(LOTRWaypoint.DALE_PORT.linkTo((0.3).toBasicVillage(), 0.0))
		registerRoad(LOTRWaypoint.DEEPHALLOW.linkTo((0.3).toBasicVillage(), 0.0))
		registerRoad(LOTRWaypoint.DOL_AMROTH.linkTo((-0.8).toGondorTown(), 0.0))
		registerRoad(LOTRWaypoint.DORWINION_FORD.linkTo((-0.3).toBasicVillage(), 0.0))
		registerRoad(LOTRWaypoint.DORWINION_PORT.linkTo((0.3).toBasicVillage(), 0.0))
		registerRoad(LOTRWaypoint.ENEDWAITH_ROAD.linkTo((0.9).toBasicTown(), 0.0))
		registerRoad(LOTRWaypoint.FORNOST.linkTo(0.0, (-0.8).toBasicTown()))
		registerRoad(LOTRWaypoint.FRAMSBURG.linkTo((-0.9).toBasicTown(), 0.0))
		registerRoad(LOTRWaypoint.FROGMORTON.linkTo(0.0, (0.4).toBasicVillage()))
		registerRoad(LOTRWaypoint.GATE_FUINUR.linkTo((-0.6).toHaradTown(), 0.0))
		registerRoad(LOTRWaypoint.GATE_HERUMOR.linkTo((-0.5).toHaradTown(), 0.0))
		registerRoad(LOTRWaypoint.GREENHOLM.linkTo(0.0, (-0.3).toBasicVillage()))
		registerRoad(LOTRWaypoint.GREENWAY_CROSSROADS.linkTo(0.0, (0.9).toBasicTown()))
		registerRoad(LOTRWaypoint.GULF_EAST_PORT.linkTo((0.9).toGulf(), 0.0))
		registerRoad(LOTRWaypoint.GULF_NORTH_TOWN.linkTo(0.0, (-0.9).toGulf()))
		registerRoad(LOTRWaypoint.GULF_TRADE_TOWN.linkTo((0.9).toGulf(), 0.0))
		registerRoad(LOTRWaypoint.HARNEN_BLACK_TOWN.linkTo(0.0, (0.6).toHarnennor()))
		registerRoad(LOTRWaypoint.HARNEN_RIVER_TOWN.linkTo(0.0, (0.6).toHarnennor()))
		registerRoad(LOTRWaypoint.HARNEN_SEA_TOWN.linkTo(0.0, (0.6).toHarnennor()))
		registerRoad(LOTRWaypoint.HAYSEND.linkTo(0.0, (0.2).toBasicVillage()))
		registerRoad(LOTRWaypoint.HAY_GATE.linkTo(0.0, (-0.2).toBasicVillage()))
		registerRoad(LOTRWaypoint.HELMS_DEEP.linkTo(0.0, (0.5).toRohanFort()))
		registerRoad(LOTRWaypoint.HOBBITON.linkTo((-0.3).toBasicVillage(), 0.0))
		registerRoad(LOTRWaypoint.JUNGLE_CITY_DEEP.linkTo(0.0, (0.8).toBasicTown()))
		registerRoad(LOTRWaypoint.JUNGLE_CITY_NORTH.linkTo(0.0, (-0.8).toBasicTown()))
		registerRoad(LOTRWaypoint.JUNGLE_CITY_OLD.linkTo(0.0, (-0.8).toBasicTown()))
		registerRoad(LOTRWaypoint.JUNGLE_CITY_TRADE.linkTo((-0.8).toBasicTown(), 0.0))
		registerRoad(LOTRWaypoint.JUNGLE_CITY_WATCH.linkTo(0.0, (0.8).toBasicTown()))
		registerRoad(LOTRWaypoint.JUNGLE_LAKES.linkTo(0.0, (0.8).toBasicTown()))
		registerRoad(LOTRWaypoint.LITTLE_DELVING.linkTo(0.0, (-0.4).toBasicVillage()))
		registerRoad(LOTRWaypoint.LOND_DAER.linkTo((-0.8).toBasicTown(), 0.0))
		registerRoad(LOTRWaypoint.LONG_LAKE.linkTo(0.0, (0.3).toBasicVillage()))
		registerRoad(LOTRWaypoint.MINAS_TIRITH.linkTo((-0.9).toGondorTown(), 0.0))
		registerRoad(LOTRWaypoint.NEEDLEHOLE.linkTo((0.2).toBasicVillage(), 0.0))
		registerRoad(LOTRWaypoint.NORTH_ITHILIEN.linkTo((0.8).toBasicTown(), 0.0))
		registerRoad(LOTRWaypoint.OATBARTON.linkTo(0.0, (-0.2).toBasicVillage()))
		registerRoad(LOTRWaypoint.OLD_ELF_WAY.linkTo(0.0, (-0.8).toBasicTown()))
		registerRoad(LOTRWaypoint.OLD_JUNGLE_RUIN.linkTo((0.8).toBasicTown(), 0.0))
		registerRoad(LOTRWaypoint.OLD_RHOVANION.linkTo((-1.0).toBasicTown(), 0.0))
		registerRoad(LOTRWaypoint.OST_IN_EDHIL.linkTo(0.0, (-0.8).toBasicTown()))
		registerRoad(LOTRWaypoint.OVERHILL.linkTo(0.0, (-0.2).toBasicVillage()))
		registerRoad(LOTRWaypoint.RHUN_NORTHEAST.linkTo(0.0, (-0.6).toRhunFort()))
		registerRoad(LOTRWaypoint.RHUN_NORTH_FORD.linkTo(0.0, (0.6).toRhunFort()))
		registerRoad(LOTRWaypoint.RUNNING_FORD.linkTo((-0.3).toBasicVillage(), 0.0))
		registerRoad(LOTRWaypoint.SCARY.linkTo(0.0, (-0.2).toBasicVillage()))
		registerRoad(LOTRWaypoint.TARNOST.linkTo(0.0, (-0.9).toGondorTown()))
		registerRoad(LOTRWaypoint.THARBAD.linkTo((-1.0).toBasicTown(), -0.3))
		registerRoad(LOTRWaypoint.TIGHFIELD.linkTo(0.0, (-0.2).toBasicVillage()))
		registerRoad(LOTRWaypoint.TOWN_BONES.linkTo(0.0, (0.2).toBasicVillage()))
		registerRoad(LOTRWaypoint.TUCKBOROUGH.linkTo((-0.2).toBasicVillage(), 0.0))
		registerRoad(LOTRWaypoint.WILLOWBOTTOM.linkTo((-0.2).toBasicVillage(), 0.0))
		registerRoad(LOTRWaypoint.WOLD.linkTo(0.0, (-0.5).toRohanFort()))

		registerRoadI(LOTRWaypoint.ALDBURG.linkTo(-0.15, (0.6).toRohanFort()), false)
		registerRoadI(LOTRWaypoint.BAZYLAN.linkTo(0.3, (1.1).toRhunTown()), false)
		registerRoadI(LOTRWaypoint.BORDER_TOWN.linkTo(0.3, (1.1).toRhunTown()), false)
		registerRoadI(LOTRWaypoint.CALEMBEL.linkTo(0.2, (-1.1).toGondorTown()), false)
		registerRoadI(LOTRWaypoint.COAST_FORTRESS.linkTo((-0.6).toHaradTown(), -0.3), true)
		registerRoadI(LOTRWaypoint.DALE_CROSSROADS.linkTo(-0.3, (-0.9).toBasicVillage()), false)
		registerRoadI(LOTRWaypoint.DORWINION_COURT.linkTo(0.3, (-0.5).toBasicVillage()), false)
		registerRoadI(LOTRWaypoint.DORWINION_CROSSROADS.linkTo(0.5, (-0.5).toBasicVillage()), false)
		registerRoadI(LOTRWaypoint.EAST_RHOVANION_ROAD.linkTo((-0.9).toBasicTown(), 0.3), true)
		registerRoadI(LOTRWaypoint.EDHELLOND.linkTo(-0.2, (-0.8).toBasicTown()), false)
		registerRoadI(LOTRWaypoint.EDORAS.linkTo(-0.3, (0.6).toRohanFort()), false)
		registerRoadI(LOTRWaypoint.ENTWADE.linkTo((-0.7).toRohanFort(), -0.1), true)
		registerRoadI(LOTRWaypoint.ETHRING.linkTo((1.0).toGondorTown(), -0.2), true)
		registerRoadI(LOTRWaypoint.FERTILE_VALLEY.linkTo((-0.6).toHaradTown(), -0.1), true)
		registerRoadI(LOTRWaypoint.GARDENS_BERUTHIEL.linkTo((-0.6).toHaradTown(), -0.3), true)
		registerRoadI(LOTRWaypoint.GRIMSLADE.linkTo(-0.2, (0.6).toRohanFort()), false)
		registerRoadI(LOTRWaypoint.GULF_CITY.linkTo((1.0).toGulf(), -0.1), true)
		registerRoadI(LOTRWaypoint.GULF_OF_HARAD.linkTo((1.0).toGulf(), -0.3), true)
		registerRoadI(LOTRWaypoint.HARNEN_ROAD_TOWN.linkTo(0.2, (-0.8).toHarnennor()), false)
		registerRoadI(LOTRWaypoint.HELMS_CROSSROADS.linkTo(0.3, (-0.7).toRohanFort()), false)
		registerRoadI(LOTRWaypoint.JUNGLE_CITY_CAPITAL.linkTo(-0.5, (-1.0).toBasicTown()), false)
		registerRoadI(LOTRWaypoint.JUNGLE_CITY_CAVES.linkTo((-0.9).toBasicTown(), -0.1), true)
		registerRoadI(LOTRWaypoint.JUNGLE_CITY_EAST.linkTo((1.0).toBasicTown(), -0.4), true)
		registerRoadI(LOTRWaypoint.JUNGLE_CITY_STONE.linkTo(0.2, (-0.9).toBasicTown()), false)
		registerRoadI(LOTRWaypoint.LINHIR.linkTo(-0.2, (0.9).toGondorTown()), false)
		registerRoadI(LOTRWaypoint.LONGBOTTOM.linkTo(0.5, (-0.5).toBasicVillage()), false)
		registerRoadI(LOTRWaypoint.MICHEL_DELVING.linkTo(0.1, (0.4).toBasicVillage()), false)
		registerRoadI(LOTRWaypoint.MORDOR_FORD.linkTo(-0.4, (-0.8).toRhunFort()), false)
		registerRoadI(LOTRWaypoint.NOBOTTLE.linkTo(-0.1, (-0.5).toBasicVillage()), false)
		registerRoadI(LOTRWaypoint.PELARGIR.linkTo(-0.1, (-1.0).toGondorTown()), false)
		registerRoadI(LOTRWaypoint.REDWATER_FORD.linkTo(-0.2, (0.4).toBasicVillage()), false)
		registerRoadI(LOTRWaypoint.RHUN_CAPITAL.linkTo((-1.2).toRhunTown(), 0.5), true)
		registerRoadI(LOTRWaypoint.RHUN_EAST_CITY.linkTo(0.0, (0.9).toRhunTown()), false)
		registerRoadI(LOTRWaypoint.RHUN_EAST_TOWN.linkTo(0.3, (-1.0).toRhunTown()), false)
		registerRoadI(LOTRWaypoint.RHUN_NORTH_CITY.linkTo((-0.9).toRhunTown(), 0.0), true)
		registerRoadI(LOTRWaypoint.RHUN_SEA_CITY.linkTo(0.0, (-0.9).toRhunTown()), false)
		registerRoadI(LOTRWaypoint.RHUN_SOUTHEAST.linkTo((0.8).toRhunFort(), -0.1), true)
		registerRoadI(LOTRWaypoint.RHUN_SOUTH_PASS.linkTo((1.0).toRhunTown(), 0.2), true)
		registerRoadI(LOTRWaypoint.STOCK.linkTo((0.4).toBasicVillage(), -0.1), true)
		registerRoadI(LOTRWaypoint.TARLANG.linkTo(-0.1, (0.6).toGondorFort()), false)
		registerRoadI(LOTRWaypoint.UMBAR_CITY.linkTo((-0.6).toHaradTown(), -0.2), true)
		registerRoadI(LOTRWaypoint.UMBAR_GATE.linkTo(-0.2, (0.6).toHaradTown()), false)
		registerRoadI(LOTRWaypoint.WAYMEET.linkTo((-0.7).toBasicVillage(), -0.55), true)
		registerRoadI(LOTRWaypoint.WHITFURROWS.linkTo(0.6, (-0.6).toBasicVillage()), false)
	}
}
