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
		val rhunTown = 34.0 / 128.0
		val rhunFort = 67.0 / 128.0
		val rohanFort = 77.0 / 128.0
		val basicVillage = 113.0 / 128.0

		registerRoad(LOTRWaypoint.DOL_AMROTH.linkTo(-gondorTown, 0.0))
		registerRoad(LOTRWaypoint.TARNOST.linkTo(0.0, -gondorTown + 0.1))
		registerRoad(LOTRWaypoint.MINAS_TIRITH.linkTo(-gondorTown + 0.1, 0.0))
		registerRoad(LOTRWaypoint.TIGHFIELD.linkTo(0.0, -basicVillage + 0.8))
		registerRoad(LOTRWaypoint.GREENHOLM.linkTo(0.0, -basicVillage + 0.7))
		registerRoad(LOTRWaypoint.MICHEL_DELVING.linkTo(0.0, basicVillage - 0.5))
		registerRoad(LOTRWaypoint.LITTLE_DELVING.linkTo(0.0, -basicVillage + 0.6))
		registerRoad(LOTRWaypoint.NEEDLEHOLE.linkTo(basicVillage - 0.8, 0.0))
		registerRoad(LOTRWaypoint.TUCKBOROUGH.linkTo(-basicVillage + 0.8, 0.0))
		registerRoad(LOTRWaypoint.BYWATER.linkTo(0.0, basicVillage - 0.6))
		registerRoad(LOTRWaypoint.FROGMORTON.linkTo(0.0, basicVillage - 0.6))
		registerRoad(LOTRWaypoint.OATBARTON.linkTo(0.0, -basicVillage + 0.8))
		registerRoad(LOTRWaypoint.SCARY.linkTo(0.0, -basicVillage + 0.8))
		registerRoad(LOTRWaypoint.HAY_GATE.linkTo(0.0, -basicVillage + 0.8))
		registerRoad(LOTRWaypoint.HAYSEND.linkTo(0.0, basicVillage - 0.8))
		registerRoad(LOTRWaypoint.BUCKLEBURY.linkTo(basicVillage - 0.6, 0.0))
		registerRoad(LOTRWaypoint.DEEPHALLOW.linkTo(basicVillage - 0.7, 0.0))
		registerRoad(LOTRWaypoint.HOBBITON.linkTo(-basicVillage + 0.7, 0.0))
		registerRoad(LOTRWaypoint.OVERHILL.linkTo(0.0, -basicVillage + 0.8))
		registerRoad(LOTRWaypoint.WILLOWBOTTOM.linkTo(-basicVillage + 0.8, 0.0))
		registerRoad(LOTRWaypoint.THARBAD.linkTo(-0.75, 0.0))
		registerRoad(LOTRWaypoint.FORNOST.linkTo(0.0, -0.15))
		registerRoad(LOTRWaypoint.ANNUMINAS.linkTo(-0.15, 0.0))
		registerRoad(LOTRWaypoint.OST_IN_EDHIL.linkTo(0.0, -0.15))
		registerRoad(LOTRWaypoint.LOND_DAER.linkTo(-0.15, 0.0))
		registerRoad(LOTRWaypoint.EDHELLOND.linkTo(0.0, -0.45))
		registerRoad(LOTRWaypoint.DALE_CITY.linkTo(-basicVillage + 0.7, 0.0))
		registerRoad(LOTRWaypoint.LONG_LAKE.linkTo(0.0, basicVillage - 0.7))
		registerRoad(LOTRWaypoint.DALE_PORT.linkTo(basicVillage - 0.7, 0.0))
		registerRoad(LOTRWaypoint.RUNNING_FORD.linkTo(-basicVillage + 0.7, 0.0))
		registerRoad(LOTRWaypoint.REDWATER_FORD.linkTo(0.0, basicVillage - 0.5))
		registerRoad(LOTRWaypoint.DORWINION_PORT.linkTo(basicVillage - 0.7, 0.0))
		registerRoad(LOTRWaypoint.DORWINION_FORD.linkTo(-basicVillage + 0.7, 0.0))
		registerRoad(LOTRWaypoint.RHUN_NORTH_FORD.linkTo(0.0, basicVillage - 0.5))
		registerRoad(LOTRWaypoint.RHUN_NORTHEAST.linkTo(0.0, -basicVillage + 0.5))
		registerRoad(LOTRWaypoint.WOLD.linkTo(0.0, -rohanFort + 0.5))

		registerRoadI(LOTRWaypoint.STOCK.linkTo(basicVillage - 0.6, -0.1), true)
		registerRoadI(LOTRWaypoint.PELARGIR.linkTo(-0.1, -gondorTown), false)
		registerRoadI(LOTRWaypoint.LINHIR.linkTo(-0.2, gondorTown - 0.1), false)
		registerRoadI(LOTRWaypoint.ETHRING.linkTo(gondorTown, -0.2), true)
		registerRoadI(LOTRWaypoint.CALEMBEL.linkTo(0.2, -gondorTown - 0.1), false)
		registerRoadI(LOTRWaypoint.NOBOTTLE.linkTo(-0.1, -basicVillage + 0.5), false)
		registerRoadI(LOTRWaypoint.BORDER_TOWN.linkTo(0.3, rhunTown + 0.1), false)
		registerRoadI(LOTRWaypoint.RHUN_SEA_CITY.linkTo(0.0, -rhunTown + 0.1), false)
		registerRoadI(LOTRWaypoint.RHUN_CAPITAL.linkTo(-rhunTown - 0.2, 0.5), true)
		registerRoadI(LOTRWaypoint.RHUN_SOUTH_PASS.linkTo(rhunTown, 0.2), true)
		registerRoadI(LOTRWaypoint.RHUN_NORTH_CITY.linkTo(-rhunTown + 0.1, 0.0), true)
		registerRoadI(LOTRWaypoint.RHUN_EAST_CITY.linkTo(0.0, rhunTown - 0.1), false)
		registerRoadI(LOTRWaypoint.RHUN_EAST_TOWN.linkTo(0.3, -rhunTown), false)
		registerRoadI(LOTRWaypoint.BAZYLAN.linkTo(0.3, rhunTown + 0.1), false)
		registerRoadI(LOTRWaypoint.RHUN_SOUTHEAST.linkTo(rhunFort - 0.2, -0.1), true)
		registerRoadI(LOTRWaypoint.MORDOR_FORD.linkTo(-0.4, -rhunFort + 0.1), false)
		registerRoadI(LOTRWaypoint.DORWINION_CROSSROADS.linkTo(0.5, -0.5), false)
		registerRoadI(LOTRWaypoint.DORWINION_COURT.linkTo(0.5, -0.5), false)
		registerRoadI(LOTRWaypoint.DALE_CROSSROADS.linkTo(-0.3, -0.9), false)
		registerRoadI(LOTRWaypoint.LONGBOTTOM.linkTo(0.5, -basicVillage + 0.5), false)
		registerRoadI(LOTRWaypoint.WAYMEET.linkTo(-basicVillage, -0.5), true)
		registerRoadI(LOTRWaypoint.WHITFURROWS.linkTo(0.6, -basicVillage + 0.4), false)
	}
}