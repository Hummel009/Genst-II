package genst.world

import genst.instance.*
import genst.utils.affix
import lotr.common.LOTRDimension
import lotr.common.world.map.LOTRRoadType
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

		/* READY */
		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.PINNATH_GELIN, 3) {
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

		/* READY */
		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.GONDOR, 3) {
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

		/* READY */
		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.GONDOR, 6) {
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

		/* READY */
		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.PELARGIR, 6) {
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

		/* READY */
		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.LEBENNIN, 6) {
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
		affix(location, LOTRWaypoint.LINHIR, -0.2, 0.9, Dir.SOUTH)

		/* READY */
		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.LAMEDON, 6) {
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
		affix(location, LOTRWaypoint.ETHRING, 1.0, -0.2, Dir.EAST)

		/* READY */
		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.LAMEDON, 6) {
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

		/* READY */
		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.DOL_AMROTH, 6) {
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
		affix(location, LOTRWaypoint.TARNOST, 0.0, -0.9, Dir.NORTH)
		affix(location, LOTRWaypoint.DOL_AMROTH, -1.0, 0.0, Dir.WEST)

		/* READY */
		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.GONDOR, 6) {
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
		affix(location, LOTRWaypoint.MINAS_TIRITH, -0.9, 0.0, Dir.WEST)

		/* READY */
		location = object : GenstGondor(LOTRWorldGenGondorStructure.GondorFiefdom.LOSSARNACH, 3) {
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

		/* READY */
		affix(GenstErech, LOTRWaypoint.ERECH, -0.07, 0.0, Dir.WEST)

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
		affix(location, LOTRWaypoint.FORD_BRUINEN, 0.0, -0.7, Dir.NORTH)

		/* READY */
		location = GenstDunland()
		affix(location, LOTRWaypoint.NORTH_DUNLAND, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.SOUTH_DUNLAND, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.DWARROWVALE, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.WULFBURG, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.FRECA_HOLD, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.CORSAIRS_LANDING, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.FORDS_OF_ISEN, 0.0, 0.0, Dir.NORTH)

		/* READY */
		location = GenstShire()
		affix(location, LOTRWaypoint.BROCKENBORINGS, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.TIGHFIELD, 0.0, -0.2, Dir.NORTH)
		affix(location, LOTRWaypoint.GREENHOLM, 0.0, -0.3, Dir.NORTH)
		affix(location, LOTRWaypoint.MICHEL_DELVING, 0.0, 0.5, Dir.SOUTH)
		affix(location, LOTRWaypoint.LITTLE_DELVING, 0.0, -0.4, Dir.NORTH)
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
		affix(location, LOTRWaypoint.STOCK, 0.4, -0.1, Dir.EAST)
		affix(location, LOTRWaypoint.HOBBITON, -0.3, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.OVERHILL, 0.0, -0.2, Dir.NORTH)
		affix(location, LOTRWaypoint.WILLOWBOTTOM, -0.2, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.LONGBOTTOM, 0.5, -0.5, Dir.NORTH)
		affix(location, LOTRWaypoint.WAYMEET, -1.0, -0.5, Dir.WEST)
		affix(location, LOTRWaypoint.WHITFURROWS, 0.6, -0.6, Dir.NORTH)

		/* READY */
		location = GenstBarrow()
		affix(location, LOTRWaypoint.TOL_MORWEN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.GLADDEN_FIELDS, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.CROSSINGS_OF_POROS, 1.0, 1.0, Dir.NORTH)
		affix(location, LOTRWaypoint.HIMLING, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.TOL_FUIN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MENELTARMA_SUMMIT, 0.0, 0.0, Dir.NORTH)

		/* READY */
		location = object : GenstRuinedCity() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun getRoadType(): LOTRRoadType {
						return LOTRRoadType.ARNOR
					}
				}
			}
		}

		affix(location, LOTRWaypoint.OLD_ELF_WAY, 0.0, -0.8, Dir.NORTH)
		affix(location, LOTRWaypoint.ANNUMINAS, -0.8, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.THARBAD, -1.4, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.FORNOST, 0.0, -0.8, Dir.NORTH)
		affix(location, LOTRWaypoint.ERYN_VORN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MOUTHS_ISEN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.GREENWAY_CROSSROADS, 0.0, 0.9, Dir.SOUTH)

		/* READY */
		location = object : GenstRuinedCity() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun getRoadType(): LOTRRoadType {
						return LOTRRoadType.PATH
					}
				}
			}
		}
		affix(location, LOTRWaypoint.LOND_DAER, -0.8, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.ENEDWAITH_ROAD, 1.0, 0.0, Dir.EAST)

		/* READY */
		location = object : GenstRuinedCity() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun getRoadType(): LOTRRoadType {
						return LOTRRoadType.HIGH_ELVEN_RUINED
					}
				}
			}
		}
		affix(location, LOTRWaypoint.OST_IN_EDHIL, 0.0, -0.8, Dir.NORTH)

		/* READY */
		location = object : GenstRuinedCity() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun getRoadType(): LOTRRoadType {
						return LOTRRoadType.DOL_AMROTH
					}
				}
			}
		}
		affix(location, LOTRWaypoint.EDHELLOND, 0.0, -1.1, Dir.NORTH)

		/* READY */
		location = GenstDale()
		affix(location, LOTRWaypoint.DALE_CITY, -0.3, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.LONG_LAKE, 0.0, 0.3, Dir.SOUTH)
		affix(location, LOTRWaypoint.DALE_PORT, 0.3, 0.0, Dir.EAST)
		affix(location, LOTRWaypoint.RUNNING_FORD, -0.3, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.REDWATER_FORD, 0.0, 0.5, Dir.SOUTH)
		affix(location, LOTRWaypoint.DALE_CROSSROADS, -0.3, -0.9, Dir.NORTH)

		/* READY */
		location = GenstDorwinion()
		affix(location, LOTRWaypoint.DORWINION_PORT, 0.3, 0.0, Dir.EAST)
		affix(location, LOTRWaypoint.DORWINION_FORD, -0.3, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.DORWINION_HILLS, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.DORWINION_COURT, 0.5, -0.5, Dir.NORTH)

		/* READY */
		location = object : GenstDorwinion() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun getRoadType(): LOTRRoadType {
						return LOTRRoadType.PATH
					}
				}
			}
		}
		affix(location, LOTRWaypoint.DORWINION_CROSSROADS, 0.5, -0.5, Dir.NORTH)

		/* READY */
		location = object : GenstRhun(6) {
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
		affix(location, LOTRWaypoint.BORDER_TOWN, 0.3, 1.1, Dir.SOUTH) //Taragal
		affix(location, LOTRWaypoint.RHUN_SEA_CITY, 0.0, -0.9, Dir.NORTH) //Belrhuk
		affix(location, LOTRWaypoint.RHUN_CAPITAL, -1.2, 0.5, Dir.WEST) //Rhunost
		affix(location, LOTRWaypoint.RHUN_SOUTH_PASS, 1.0, 0.2, Dir.EAST) //Pass of Rhudel
		affix(location, LOTRWaypoint.RHUN_NORTH_CITY, -0.9, 0.0, Dir.WEST) //Atalak
		affix(location, LOTRWaypoint.RHUN_EAST_CITY, 0.0, 0.9, Dir.SOUTH) //Karslan
		affix(location, LOTRWaypoint.RHUN_EAST_TOWN, 0.3, -1.0, Dir.NORTH) //Karanoda
		affix(location, LOTRWaypoint.BAZYLAN, 0.3, 1.1, Dir.SOUTH)

		/* READY */
		location = object : GenstRhun(6) {
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
		affix(location, LOTRWaypoint.BALCARAS, 0.0, 0.0, Dir.SOUTH)
		affix(location, LOTRWaypoint.RHUN_ROAD_WAY, 0.0, 0.4, Dir.SOUTH) //Redway

		/* READY */
		location = object : GenstRhun(6) {
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
		affix(location, LOTRWaypoint.RHUN_NORTH_FORD, 0.0, 0.6, Dir.SOUTH)
		affix(location, LOTRWaypoint.RHUN_NORTHEAST, 0.0, -0.6, Dir.NORTH) //Nortern Marches
		affix(location, LOTRWaypoint.RHUN_SOUTHEAST, 0.8, -0.1, Dir.EAST) //Southern Marches
		affix(location, LOTRWaypoint.MORDOR_FORD, -0.4, -0.9, Dir.NORTH)

		/* READY */
		affix(GenstKhamul, LOTRWaypoint.KHAMUL_TOWER, 0.0, 0.0, Dir.NORTH)

		/* READY */
		location = object : GenstRohan() {
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
		affix(location, LOTRWaypoint.WOLD, 0.0, -0.5, Dir.SOUTH)
		affix(location, LOTRWaypoint.ENTWADE, -0.7, -0.1, Dir.EAST)
		affix(location, LOTRWaypoint.EDORAS, -0.3, 0.6, Dir.NORTH)
		affix(location, LOTRWaypoint.GRIMSLADE, -0.2, 0.6, Dir.NORTH)
		affix(location, LOTRWaypoint.HELMS_DEEP, -0.4, 0.7, Dir.NORTH)
		affix(location, LOTRWaypoint.ALDBURG, -0.15, 0.6, Dir.NORTH)
		affix(location, LOTRWaypoint.MERING_STREAM, -0.4, 0.7, Dir.NORTH)
		affix(location, LOTRWaypoint.HELMS_CROSSROADS, 0.4, -0.6, Dir.SOUTH)

		/* READY */
		location = object : GenstRohan() {
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
		affix(location, LOTRWaypoint.EASTMARK, 0.0, 0.0, Dir.SOUTH)

		location = GenstLighthouse()
		affix(location, LOTRWaypoint.HALIFIRIEN, 0.0, 1.0, Dir.NORTH)
		affix(location, LOTRWaypoint.CALENHAD, 0.0, 1.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MINRIMMON, 0.0, 1.0, Dir.NORTH)
		affix(location, LOTRWaypoint.ERELAS, 0.0, 1.0, Dir.NORTH)
		affix(location, LOTRWaypoint.NARDOL, 0.0, 1.0, Dir.NORTH)
		affix(location, LOTRWaypoint.EILENACH, 0.0, 1.0, Dir.NORTH)
		affix(location, LOTRWaypoint.AMON_DIN, 1.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MINAS_TIRITH, -4.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MINAS_TIRITH, -2.5, 0.0, Dir.NORTH)

		/* READY */
		location = GenstTower()
		affix(location, LOTRWaypoint.WEATHERTOP, 0.0, -1.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MOUNT_RERIR, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MOUNT_DOLMED, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.NORTH_DOWNS, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.SOUTH_DOWNS, 0.0, 0.0, Dir.NORTH)

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