package genst.world

import genst.instance.*
import genst.utils.affix
import lotr.common.LOTRDimension
import lotr.common.world.map.LOTRWaypoint
import lotr.common.world.structure2.LOTRWorldGenGondorStructure
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*

object GenstLocations {
	var locations: MutableSet<LOTRVillageGen> = HashSet()

	fun postInit() {
		var location: LOTRVillageGen
		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.PINNATH_GELIN) {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun setupVillageProperties(random: Random) {
						villageType = VillageType.FORT
					}
				}
			}
		}
		affix(location, LOTRWaypoint.GREEN_HILLS, 0.0, 0.0, Dir.NORTH)

		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.GONDOR) {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun setupVillageProperties(random: Random) {
						villageType = VillageType.FORT
					}
				}
			}
		}
		affix(location, LOTRWaypoint.TOLFALAS_ISLAND, 0.0, 0.0, Dir.NORTH)

		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.GONDOR) {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun setupVillageProperties(random: Random) {
						villageType = VillageType.VILLAGE
					}
				}
			}
		}
		affix(location, LOTRWaypoint.ANDUIN_MOUTH, 0.0, 0.0, Dir.NORTH)

		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.PELARGIR) {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun setupVillageProperties(random: Random) {
						villageType = VillageType.TOWN
					}
				}
			}
		}
		affix(location, LOTRWaypoint.PELARGIR, -0.1, -1.0, Dir.NORTH)

		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.LEBENNIN) {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun setupVillageProperties(random: Random) {
						villageType = VillageType.TOWN
					}
				}
			}
		}
		affix(location, LOTRWaypoint.LINHIR, -0.1, 1.0, Dir.SOUTH)

		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.LAMEDON) {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun setupVillageProperties(random: Random) {
						villageType = VillageType.TOWN
					}
				}
			}
		}
		affix(location, LOTRWaypoint.ETHRING, 1.1, -0.2, Dir.EAST)

		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.LAMEDON) {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun setupVillageProperties(random: Random) {
						villageType = VillageType.TOWN
					}
				}
			}
		}
		affix(location, LOTRWaypoint.CALEMBEL, 0.2, -1.1, Dir.NORTH)

		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.DOL_AMROTH) {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun setupVillageProperties(random: Random) {
						villageType = VillageType.TOWN
					}
				}
			}
		}
		affix(location, LOTRWaypoint.TARNOST, 0.0, -1.0, Dir.NORTH)
		affix(location, LOTRWaypoint.DOL_AMROTH, -1.0, 0.0, Dir.WEST)

		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.GONDOR) {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun setupVillageProperties(random: Random) {
						villageType = VillageType.TOWN
					}
				}
			}
		}
		affix(location, LOTRWaypoint.MINAS_TIRITH, -1.0, 0.0, Dir.WEST)

		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.LOSSARNACH) {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun setupVillageProperties(random: Random) {
						villageType = VillageType.FORT
					}
				}
			}
		}
		affix(location, LOTRWaypoint.IMLOTH_MELUI, 0.0, 0.0, Dir.WEST)

		location = GenstErech()
		affix(location, LOTRWaypoint.ERECH, -0.07, 0.0, Dir.WEST)

		/* READY */
		location = GenstNorthernOrcs()
		affix(location, LOTRWaypoint.CARN_DUM, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MOUNT_GRAM, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MOUNT_GUNDABAD, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.GOBLIN_TOWN, 0.0, 0.0, Dir.NORTH)

		/* READY */
		location = GenstLindon()
		affix(location, LOTRWaypoint.AMON_EREB, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.FORLINDON, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.HARLINDON, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.FORLOND, -0.7, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.HARLOND, -0.7, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.MITHLOND_NORTH, 0.5, 0.5, Dir.SOUTH)
		affix(location, LOTRWaypoint.MITHLOND_SOUTH, -0.5, -0.5, Dir.NORTH)
		affix(location, LOTRWaypoint.TOWER_HILLS, 0.0, -0.7, Dir.NORTH)

		/* READY */
		location = GenstRivendell()
		affix(location, LOTRWaypoint.RIVENDELL, 0.0, -0.7, Dir.NORTH)

		/* READY */
		location = GenstDunland()
		affix(location, LOTRWaypoint.NORTH_DUNLAND, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.SOUTH_DUNLAND, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.DWARROWVALE, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.WULFBURG, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.FRECA_HOLD, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.CORSAIRS_LANDING, 0.0, 0.0, Dir.NORTH)

		location = GenstShire()
		affix(location, LOTRWaypoint.BROCKENBORINGS, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.TIGHFIELD, 0.0, -0.2, Dir.NORTH)
		affix(location, LOTRWaypoint.GREENHOLM, 0.0, -0.3, Dir.NORTH)
		affix(location, LOTRWaypoint.MICHEL_DELVING, 0.0, 0.5, Dir.SOUTH)
		affix(location, LOTRWaypoint.LITTLE_DELVING, 0.0, -0.5, Dir.NORTH)
		affix(location, LOTRWaypoint.NOBOTTLE, -0.1, -0.5, Dir.NORTH)
		affix(location, LOTRWaypoint.NEEDLEHOLE, 0.2, 0.0, Dir.EAST)
		affix(location, LOTRWaypoint.TUCKBOROUGH, -0.2, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.BYWATER, 0.0, 0.4, Dir.SOUTH)
		affix(location, LOTRWaypoint.FROGMORTON, 0.0, 0.4, Dir.SOUTH)
		affix(location, LOTRWaypoint.OATBARTON, 0.0, -0.2, Dir.NORTH)
		affix(location, LOTRWaypoint.SCARY, 0.0, -0.2, Dir.NORTH)
		affix(location, LOTRWaypoint.HAY_GATE, 0.0, -0.2, Dir.NORTH)
		affix(location, LOTRWaypoint.HAYSEND, 0.0, 0.2, Dir.SOUTH)
		affix(location, LOTRWaypoint.BUCKLEBURY, 0.4, 0.0, Dir.EAST)
		affix(location, LOTRWaypoint.DEEPHALLOW, 0.3, 0.0, Dir.EAST)
		affix(location, LOTRWaypoint.STOCK, 0.5, 0.0, Dir.EAST)
		affix(location, LOTRWaypoint.HOBBITON, -0.3, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.OVERHILL, 0.0, -0.2, Dir.NORTH)
		affix(location, LOTRWaypoint.WILLOWBOTTOM, -0.2, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.LONGBOTTOM, 0.5, -0.7, Dir.NORTH)
		affix(location, LOTRWaypoint.WAYMEET, 0.55, -0.75, Dir.NORTH)
		affix(location, LOTRWaypoint.WHITFURROWS, 0.6, -0.6, Dir.NORTH)

		/* READY */
		location = LOTRVillageGenRuinsMedium()
		affix(location, LOTRWaypoint.ARVEDUI_MINES, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.HIMLING, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.TOL_FUIN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MENELTARMA_SUMMIT, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.WITHERED_HEATH, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.FIELD_OF_CELEBRANT, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.CORSAIRS_LANDING, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MOUTHS_ISEN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.FORDS_OF_ISEN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.ENEDWAITH_ROAD, 1.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.GREENWAY_CROSSROADS, 0.0, 1.0, Dir.NORTH)
		affix(location, LOTRWaypoint.SARN_FORD, 2.0, 2.0, Dir.NORTH)

		/* READY */
		location = LOTRVillageGenRuinsCity()
		affix(location, LOTRWaypoint.THARBAD, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.FORNOST, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.ANNUMINAS, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.OST_IN_EDHIL, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.ERYN_VORN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.LOND_DAER, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.FRAMSBURG, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.EAST_BIGHT, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.OLD_RHOVANION, -1.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.DORWINION_CROSSROADS, 0.0, 1.0, Dir.NORTH)
		affix(location, LOTRWaypoint.OLD_ELF_WAY, 0.0, 1.0, Dir.NORTH)
		affix(location, LOTRWaypoint.THE_TROLLSHAWS, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.EDHELLOND, 0.0, 1.0, Dir.NORTH)

		/* READY */
		location = LOTRVillageGenRuinsSmallWooden()
		affix(location, LOTRWaypoint.FORSAKEN_INN, 0.0, 0.0, Dir.NORTH)

		/* READY */
		location = LOTRVillageGenRuinsSmallStone()
		affix(location, LOTRWaypoint.WEATHERTOP, 0.0, -1.0, Dir.NORTH)

		/* READY */
		location = LOTRVillageGenBarrow()
		affix(location, LOTRWaypoint.TOL_MORWEN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.GLADDEN_FIELDS, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.CROSSINGS_OF_POROS, 1.0, 1.0, Dir.NORTH)

		for (loc in locations) {
			for (biome in LOTRDimension.MIDDLE_EARTH.biomeList) {
				biome?.decorator?.addVillage(loc)
			}
		}
	}

	enum class Dir {
		NORTH, EAST, SOUTH, WEST
	}
}