package genst.world

import genst.utils.info
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
		registerRoad("Linker", arrayOf(LOTRWaypoint.PELARGIR, LOTRWaypoint.PELARGIR.info(-0.1, -gondorTown)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.LINHIR, LOTRWaypoint.LINHIR.info(-0.1, gondorTown)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.ETHRING, LOTRWaypoint.ETHRING.info(gondorTown + 0.1, -0.2)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.CALEMBEL, LOTRWaypoint.CALEMBEL.info(0.2, -gondorTown - 0.1)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.DOL_AMROTH, LOTRWaypoint.DOL_AMROTH.info(-gondorTown, 0.0)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.TARNOST, LOTRWaypoint.TARNOST.info(0.0, -gondorTown)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.MINAS_TIRITH, LOTRWaypoint.MINAS_TIRITH.info(-gondorTown, 0.0)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.TIGHFIELD, LOTRWaypoint.TIGHFIELD.info(0.0, -0.2)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.GREENHOLM, LOTRWaypoint.GREENHOLM.info(0.0, -0.3)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.MICHEL_DELVING, LOTRWaypoint.MICHEL_DELVING.info(0.0, 0.5)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.LITTLE_DELVING, LOTRWaypoint.LITTLE_DELVING.info(0.0, -0.5)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.NOBOTTLE, LOTRWaypoint.NOBOTTLE.info(-0.1, -0.5)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.NEEDLEHOLE, LOTRWaypoint.NEEDLEHOLE.info(0.2, 0.0)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.TUCKBOROUGH, LOTRWaypoint.TUCKBOROUGH.info(-0.2, 0.0)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.BYWATER, LOTRWaypoint.BYWATER.info(0.0, 0.4)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.FROGMORTON, LOTRWaypoint.FROGMORTON.info(0.0, 0.4)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.OATBARTON, LOTRWaypoint.OATBARTON.info(0.0, -0.2)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.SCARY, LOTRWaypoint.SCARY.info(0.0, -0.2)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.HAY_GATE, LOTRWaypoint.HAY_GATE.info(0.0, -0.2)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.HAYSEND, LOTRWaypoint.HAYSEND.info(0.0, 0.2)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.BUCKLEBURY, LOTRWaypoint.BUCKLEBURY.info(0.4, 0.0)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.DEEPHALLOW, LOTRWaypoint.DEEPHALLOW.info(0.3, 0.0)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.STOCK, LOTRWaypoint.STOCK.info(0.5, 0.0)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.HOBBITON, LOTRWaypoint.HOBBITON.info(-0.3, 0.0)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.OVERHILL, LOTRWaypoint.OVERHILL.info(0.0, -0.2)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.WILLOWBOTTOM, LOTRWaypoint.WILLOWBOTTOM.info(-0.2, 0.0)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.LONGBOTTOM, LOTRWaypoint.LONGBOTTOM.info(0.5, -0.5)))
		registerRoad(
			"Linker", arrayOf(LOTRWaypoint.LONGBOTTOM.info(0.5, -0.5), LOTRWaypoint.LONGBOTTOM.info(0.5, -0.7))
		)
		registerRoad("Linker", arrayOf(LOTRWaypoint.WAYMEET, LOTRWaypoint.WAYMEET.info(0.55, -0.55)))
		registerRoad(
			"Linker", arrayOf(LOTRWaypoint.WAYMEET.info(0.55, -0.55), LOTRWaypoint.WAYMEET.info(0.55, -0.75))
		)
		registerRoad("Linker", arrayOf(LOTRWaypoint.WHITFURROWS, LOTRWaypoint.WHITFURROWS.info(0.6, -0.4)))
		registerRoad(
			"Linker", arrayOf(LOTRWaypoint.WHITFURROWS.info(0.6, -0.4), LOTRWaypoint.WHITFURROWS.info(0.6, -0.6))
		)
		registerRoad("Linker", arrayOf(LOTRWaypoint.THARBAD, LOTRWaypoint.THARBAD.info(-0.7, 0.0)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.FORNOST, LOTRWaypoint.FORNOST.info(0.0, -0.1)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.ANNUMINAS, LOTRWaypoint.ANNUMINAS.info(-0.1, 0.0)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.OST_IN_EDHIL, LOTRWaypoint.OST_IN_EDHIL.info(0.0, -0.1)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.LOND_DAER, LOTRWaypoint.LOND_DAER.info(-0.1, 0.0)))
		registerRoad("Linker", arrayOf(LOTRWaypoint.EDHELLOND, LOTRWaypoint.EDHELLOND.info(0.0, -0.5)))
	}
}