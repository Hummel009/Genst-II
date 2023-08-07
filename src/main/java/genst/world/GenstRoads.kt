package genst.world

import genst.utils.info
import genst.utils.isNotForbidden
import genst.utils.linkTo
import genst.utils.registerRoad
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
		val gondorTown = 0.3359375
		registerRoad(LOTRWaypoint.ETHRING.linkTo(gondorTown + 0.1, -0.2))
		registerRoad(LOTRWaypoint.CALEMBEL.linkTo(0.2, -gondorTown - 0.1))
		registerRoad(LOTRWaypoint.DOL_AMROTH.linkTo(-gondorTown, 0.0))
		registerRoad(LOTRWaypoint.TARNOST.linkTo(0.0, -gondorTown))
		registerRoad(LOTRWaypoint.MINAS_TIRITH.linkTo(-gondorTown, 0.0))
		registerRoad(LOTRWaypoint.TIGHFIELD.linkTo(0.0, -0.2))
		registerRoad(LOTRWaypoint.GREENHOLM.linkTo(0.0, -0.3))
		registerRoad(LOTRWaypoint.MICHEL_DELVING.linkTo(0.0, 0.5))
		registerRoad(LOTRWaypoint.LITTLE_DELVING.linkTo(0.0, -0.5))
		registerRoad(LOTRWaypoint.NOBOTTLE.linkTo(-0.1, -0.5))
		registerRoad(LOTRWaypoint.NEEDLEHOLE.linkTo(0.2, 0.0))
		registerRoad(LOTRWaypoint.TUCKBOROUGH.linkTo(-0.2, 0.0))
		registerRoad(LOTRWaypoint.BYWATER.linkTo(0.0, 0.4))
		registerRoad(LOTRWaypoint.FROGMORTON.linkTo(0.0, 0.4))
		registerRoad(LOTRWaypoint.OATBARTON.linkTo(0.0, -0.2))
		registerRoad(LOTRWaypoint.SCARY.linkTo(0.0, -0.2))
		registerRoad(LOTRWaypoint.HAY_GATE.linkTo(0.0, -0.2))
		registerRoad(LOTRWaypoint.HAYSEND.linkTo(0.0, 0.2))
		registerRoad(LOTRWaypoint.BUCKLEBURY.linkTo(0.4, 0.0))
		registerRoad(LOTRWaypoint.DEEPHALLOW.linkTo(0.3, 0.0))
		registerRoad(LOTRWaypoint.STOCK.linkTo(0.5, 0.0))
		registerRoad(LOTRWaypoint.HOBBITON.linkTo(-0.3, 0.0))
		registerRoad(LOTRWaypoint.OVERHILL.linkTo(0.0, -0.2))
		registerRoad(LOTRWaypoint.WILLOWBOTTOM.linkTo(-0.2, 0.0))
		registerRoad(LOTRWaypoint.THARBAD.linkTo(-0.7, 0.0))
		registerRoad(LOTRWaypoint.FORNOST.linkTo(0.0, -0.1))
		registerRoad(LOTRWaypoint.ANNUMINAS.linkTo(-0.1, 0.0))
		registerRoad(LOTRWaypoint.OST_IN_EDHIL.linkTo(0.0, -0.1))
		registerRoad(LOTRWaypoint.LOND_DAER.linkTo(-0.1, 0.0))
		registerRoad(LOTRWaypoint.EDHELLOND.linkTo(0.0, -0.4))

		if (LOTRWaypoint.LONGBOTTOM.isNotForbidden()) {
			registerRoad(LOTRWaypoint.LONGBOTTOM.linkTo(0.5, -0.5))
			registerRoad(
				arrayOf(LOTRWaypoint.LONGBOTTOM.info(0.5, -0.5), LOTRWaypoint.LONGBOTTOM.info(0.5, -0.7))
			)
		}

		if (LOTRWaypoint.WAYMEET.isNotForbidden()) {
			registerRoad(LOTRWaypoint.WAYMEET.linkTo(0.55, -0.55))
			registerRoad(
				arrayOf(LOTRWaypoint.WAYMEET.info(0.55, -0.55), LOTRWaypoint.WAYMEET.info(0.55, -0.75))
			)
		}

		if (LOTRWaypoint.WHITFURROWS.isNotForbidden()) {
			registerRoad(LOTRWaypoint.WHITFURROWS.linkTo(0.6, -0.4))
			registerRoad(
				arrayOf(LOTRWaypoint.WHITFURROWS.info(0.6, -0.4), LOTRWaypoint.WHITFURROWS.info(0.6, -0.6))
			)
		}
	}
}