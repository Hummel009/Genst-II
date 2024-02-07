package com.github.hummel.genst.world

import com.github.hummel.genst.util.affix
import com.github.hummel.genst.util.toHaradTownGate
import com.github.hummel.genst.world.settlement.*
import com.github.hummel.genst.world.structure.*
import lotr.common.LOTRDimension
import lotr.common.entity.npc.LOTRNames
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.map.LOTRWaypoint
import lotr.common.world.structure2.LOTRWorldGenBDBarrow
import lotr.common.world.structure2.LOTRWorldGenBreeInn
import lotr.common.world.structure2.LOTRWorldGenGondorStructure
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*

object Locations {
	var locations: MutableSet<LOTRVillageGen> = HashSet()

	fun postInit() {
		var location: LOTRVillageGen

		location = object : SingleGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun addVillageStructures(random: Random) {
						addStructure(Erech, 0, 0, 0, true)
					}
				}
			}
		}
		affix(location, LOTRWaypoint.ERECH, -0.07, 0.0, Dir.WEST)

		location = object : GondorGenst(LOTRWorldGenGondorStructure.GondorFiefdom.GONDOR, 1) {
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
		affix(location, LOTRWaypoint.EMYN_ARNEN, 0.0, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.HENNETH_ANNUN, 0.0, 0.0, Dir.WEST)

		location = object : GondorGenst(LOTRWorldGenGondorStructure.GondorFiefdom.GONDOR, 4) {
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

		location = object : GondorGenst(LOTRWorldGenGondorStructure.GondorFiefdom.GONDOR, 4) {
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
		affix(location, LOTRWaypoint.CAIR_ANDROS, -1.0, 0.0, Dir.WEST)

		location = object : GondorGenst(LOTRWorldGenGondorStructure.GondorFiefdom.PELARGIR, 4) {
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

		location = object : GondorGenst(LOTRWorldGenGondorStructure.GondorFiefdom.BLACKROOT_VALE, 1) {
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
		affix(location, LOTRWaypoint.TARLANG, -0.1, 0.6, Dir.SOUTH)

		location = object : GondorGenst(LOTRWorldGenGondorStructure.GondorFiefdom.LEBENNIN, 4) {
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

		location = object : GondorGenst(LOTRWorldGenGondorStructure.GondorFiefdom.LAMEDON, 4) {
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
		affix(location, LOTRWaypoint.CALEMBEL, 0.2, -1.1, Dir.NORTH)

		location = object : GondorGenst(LOTRWorldGenGondorStructure.GondorFiefdom.DOL_AMROTH, 4) {
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
		affix(location, LOTRWaypoint.DOL_AMROTH, -0.8, 0.0, Dir.WEST)

		location = object : GondorGenst(LOTRWorldGenGondorStructure.GondorFiefdom.LOSSARNACH, 1) {
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

		location = object : GondorGenst(LOTRWorldGenGondorStructure.GondorFiefdom.PINNATH_GELIN, 1) {
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

		location = object : SingleGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun addVillageStructures(random: Random) {
						addStructure(DwarvenTower(), 0, 6, 2, true)
					}
				}
			}
		}
		affix(location, LOTRWaypoint.EREBOR, 0.0, -0.1, Dir.NORTH)
		affix(location, LOTRWaypoint.WEST_PEAK, 0.0, -0.1, Dir.NORTH)
		affix(location, LOTRWaypoint.EAST_PEAK, 0.0, -0.1, Dir.NORTH)

		location = object : SingleGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun addVillageStructures(random: Random) {
						addStructure(BlueDwarvenTower(), 0, 6, 2, true)
					}
				}
			}
		}
		affix(location, LOTRWaypoint.BELEGOST, 0.0, -0.1, Dir.NORTH)
		affix(location, LOTRWaypoint.NOGROD, 0.0, 0.1, Dir.SOUTH)
		affix(location, LOTRWaypoint.THORIN_HALLS, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.THRAIN_HALLS, 0.0, 0.0, Dir.NORTH)

		location = object : SingleGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun addVillageStructures(random: Random) {
						addStructure(RedDwarvenTower(), 0, 6, 2, true)
					}
				}
			}
		}
		affix(location, LOTRWaypoint.BARAZ_DUM, 0.1, 0.0, Dir.EAST)

		location = object : SingleGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun addVillageStructures(random: Random) {
						addStructure(WoodElvenTower(), 0, 6, 2, true)
					}
				}
			}
		}
		affix(location, LOTRWaypoint.THRANDUIL_HALLS, 0.0, -0.1, Dir.NORTH)

		location = object : SingleGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun addVillageStructures(random: Random) {
						addStructure(LothlorienTower(), 0, 6, 2, true)
					}
				}
			}
		}
		affix(location, LOTRWaypoint.NIMRODEL, 0.0, 0.1, Dir.SOUTH)
		affix(location, LOTRWaypoint.CARAS_GALADHON, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.CERIN_AMROTH, 0.0, 0.0, Dir.NORTH)

		location = AngmarGenst()
		affix(location, LOTRWaypoint.CARN_DUM, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MOUNT_GRAM, 0.0, 0.0, Dir.NORTH)

		location = GundabadGenst()
		affix(location, LOTRWaypoint.MOUNT_GUNDABAD, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.GOBLIN_TOWN, 0.0, 0.0, Dir.NORTH)

		location = LindonGenst()
		affix(location, LOTRWaypoint.AMON_EREB, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.FORLINDON, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.HARLINDON, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.FORLOND, -0.6, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.HARLOND, -0.6, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.MITHLOND_NORTH, 0.5, 0.5, Dir.SOUTH)
		affix(location, LOTRWaypoint.MITHLOND_SOUTH, -0.5, -0.5, Dir.NORTH)
		affix(location, LOTRWaypoint.TOWER_HILLS, 0.0, -0.6, Dir.NORTH)

		location = RivendellGenst()
		affix(location, LOTRWaypoint.RIVENDELL, 0.0, -0.7, Dir.NORTH)
		affix(location, LOTRWaypoint.FORD_BRUINEN, 0.0, -0.7, Dir.NORTH)

		location = DunlandGenst()
		affix(location, LOTRWaypoint.NORTH_DUNLAND, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.SOUTH_DUNLAND, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.DWARROWVALE, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.WULFBURG, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.FRECA_HOLD, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.CORSAIRS_LANDING, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.FORDS_OF_ISEN, 0.0, 0.0, Dir.NORTH)

		location = ShireGenst()
		affix(location, LOTRWaypoint.BROCKENBORINGS, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.TIGHFIELD, 0.0, -0.2, Dir.NORTH)
		affix(location, LOTRWaypoint.GREENHOLM, 0.0, -0.3, Dir.NORTH)
		affix(location, LOTRWaypoint.MICHEL_DELVING, 0.1, 0.4, Dir.SOUTH)
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
		affix(location, LOTRWaypoint.WAYMEET, -0.7, -0.55, Dir.WEST)
		affix(location, LOTRWaypoint.WHITFURROWS, 0.6, -0.6, Dir.NORTH)

		location = object : SingleGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun addVillageStructures(random: Random) {
						addStructure(LOTRWorldGenBDBarrow(false), 0, 0, 0, true)
					}
				}
			}
		}
		affix(location, LOTRWaypoint.SOUTH_FOROCHEL, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.CAPE_OF_FOROCHEL, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.TOL_MORWEN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.GLADDEN_FIELDS, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.CROSSINGS_OF_POROS, 1.0, 1.0, Dir.NORTH)
		affix(location, LOTRWaypoint.HIMLING, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.TOL_FUIN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MENELTARMA_SUMMIT, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.WITHERED_HEATH, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.SCATHA, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.CROSSROADS_ITHILIEN, 0.3, 0.3, Dir.NORTH)

		location = RuinedCityGenst()
		affix(location, LOTRWaypoint.LOND_DAER, -0.8, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.ENEDWAITH_ROAD, 0.9, 0.0, Dir.EAST)
		affix(location, LOTRWaypoint.FRAMSBURG, -0.9, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.ANDUIN_CROSSROADS, -0.8, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.EAST_RHOVANION_ROAD, -0.9, 0.3, Dir.WEST)
		affix(location, LOTRWaypoint.EAST_BIGHT, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.OLD_RHOVANION, -1.0, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.NORTH_UNDEEP, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.SOUTH_UNDEEP, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.OLD_JUNGLE_RUIN, 0.8, 0.0, Dir.EAST)
		affix(location, LOTRWaypoint.ISLE_MIST, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.HARAD_HORN, 0.0, 0.0, Dir.NORTH)

		location = object : RuinedCityGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun getRoadType(): LOTRRoadType = LOTRRoadType.ARNOR
				}
			}
		}

		affix(location, LOTRWaypoint.OLD_ELF_WAY, 0.0, -0.8, Dir.NORTH)
		affix(location, LOTRWaypoint.ANNUMINAS, -0.8, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.THARBAD, -1.0, -0.3, Dir.WEST)
		affix(location, LOTRWaypoint.FORNOST, 0.0, -0.8, Dir.NORTH)
		affix(location, LOTRWaypoint.ERYN_VORN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MOUTHS_ISEN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.GREENWAY_CROSSROADS, 0.0, 0.9, Dir.SOUTH)

		location = object : RuinedCityGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun getRoadType(): LOTRRoadType = LOTRRoadType.HIGH_ELVEN_RUINED
				}
			}
		}
		affix(location, LOTRWaypoint.OST_IN_EDHIL, 0.0, -0.8, Dir.NORTH)

		location = object : RuinedCityGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun getRoadType(): LOTRRoadType = LOTRRoadType.DOL_AMROTH
				}
			}
		}
		affix(location, LOTRWaypoint.EDHELLOND, -0.2, -0.8, Dir.NORTH)

		location = object : RuinedCityGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun getRoadType(): LOTRRoadType = LOTRRoadType.GONDOR
				}
			}
		}
		affix(location, LOTRWaypoint.NORTH_ITHILIEN, 0.8, 0.0, Dir.EAST)
		affix(location, LOTRWaypoint.OSGILIATH_WEST, 0.7, 0.0, Dir.EAST)
		affix(location, LOTRWaypoint.OSGILIATH_WEST, 2.0, 0.0, Dir.EAST)
		affix(location, LOTRWaypoint.OSGILIATH_EAST, -0.6, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.OSGILIATH_EAST, -1.9, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.OSGILIATH_EAST, -3.2, 0.0, Dir.WEST)

		location = DaleGenst()
		affix(location, LOTRWaypoint.DALE_CITY, -0.3, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.LONG_LAKE, 0.0, 0.3, Dir.SOUTH)
		affix(location, LOTRWaypoint.DALE_PORT, 0.3, 0.0, Dir.EAST)
		affix(location, LOTRWaypoint.RUNNING_FORD, -0.3, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.REDWATER_FORD, -0.2, 0.4, Dir.SOUTH)
		affix(location, LOTRWaypoint.DALE_CROSSROADS, -0.3, -0.9, Dir.NORTH)

		location = DorwinionGenst()
		affix(location, LOTRWaypoint.DORWINION_PORT, 0.3, 0.0, Dir.EAST)
		affix(location, LOTRWaypoint.DORWINION_FORD, -0.3, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.DORWINION_HILLS, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.DORWINION_COURT, 0.3, -0.5, Dir.NORTH)

		location = object : DorwinionGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun getRoadType(): LOTRRoadType = LOTRRoadType.PATH
				}
			}
		}
		affix(location, LOTRWaypoint.DORWINION_CROSSROADS, 0.5, -0.5, Dir.NORTH)

		location = object : RhudelGenst(5) {
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

		location = object : RhudelGenst(5) {
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

		location = object : RhudelGenst(3) {
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
		affix(location, LOTRWaypoint.MORDOR_FORD, -0.4, -0.8, Dir.NORTH)
		affix(location, LOTRWaypoint.KHAND_NORTH_ROAD, 0.8, 0.0, Dir.EAST) //Southern Marches

		location = object : SingleGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun addVillageStructures(random: Random) {
						addStructure(KhamulTower, 0, 0, 0, true)
					}
				}
			}
		}
		affix(location, LOTRWaypoint.KHAMUL_TOWER, 0.0, 0.0, Dir.NORTH)

		location = object : RohanGenst() {
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
		affix(location, LOTRWaypoint.HELMS_DEEP, 0.0, 0.5, Dir.NORTH)
		affix(location, LOTRWaypoint.ALDBURG, -0.15, 0.6, Dir.NORTH)
		affix(location, LOTRWaypoint.HELMS_CROSSROADS, 0.3, -0.7, Dir.SOUTH)
		affix(location, LOTRWaypoint.DUNHARROW, 0.0, 0.0, Dir.SOUTH)

		location = object : RohanGenst() {
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
		affix(location, LOTRWaypoint.FIELD_OF_CELEBRANT, 0.0, 0.0, Dir.SOUTH)

		location = object : SingleGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun addVillageStructures(random: Random) {
						addStructure(GondorTower(), 0, 6, 2, true)
					}
				}
			}
		}
		affix(location, LOTRWaypoint.HALIFIRIEN, 0.0, 1.0, Dir.SOUTH)
		affix(location, LOTRWaypoint.CALENHAD, 0.0, 1.0, Dir.SOUTH)
		affix(location, LOTRWaypoint.MINRIMMON, 0.0, 1.0, Dir.SOUTH)
		affix(location, LOTRWaypoint.ERELAS, 0.0, 1.0, Dir.SOUTH)
		affix(location, LOTRWaypoint.NARDOL, 0.0, 1.0, Dir.SOUTH)
		affix(location, LOTRWaypoint.EILENACH, 0.0, 1.0, Dir.SOUTH)
		affix(location, LOTRWaypoint.AMON_DIN, 1.0, 0.0, Dir.EAST)
		affix(location, LOTRWaypoint.MINAS_TIRITH, -4.0, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.MINAS_TIRITH, -2.5, 0.0, Dir.WEST)

		location = object : SingleGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun addVillageStructures(random: Random) {
						addStructure(RuinedTower(false), 0, 0, 0, true)
					}
				}
			}
		}
		affix(location, LOTRWaypoint.OSGILIATH_WEST, 3.0 - 0.15, 0.35, Dir.NORTH)
		affix(location, LOTRWaypoint.DAINS_HALLS, 0.0, -0.1, Dir.NORTH)
		affix(location, LOTRWaypoint.ARVEDUI_MINES, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.WEATHERTOP, 0.0, -1.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MOUNT_RERIR, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MOUNT_DOLMED, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.NORTH_DOWNS, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.SOUTH_DOWNS, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.HIGH_PASS, 0.0, -0.2, Dir.NORTH)
		affix(location, LOTRWaypoint.MOUNT_CARADHRAS, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MOUNT_CELEBDIL, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MOUNT_FANUIDHOL, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MOUNT_METHEDRAS, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.RAS_MORTHIL, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.THE_TROLLSHAWS, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.AMON_LHAW, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.AMON_HEN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MOUNT_SAND, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MOUNT_GREEN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MOUNT_THUNDER, 0.0, 0.0, Dir.NORTH)

		location = object : SingleGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun addVillageStructures(random: Random) {
						addStructure(LOTRWorldGenBreeInn(false), 0, 0, 0, true)
					}
				}
			}
		}
		affix(location, LOTRWaypoint.FORSAKEN_INN, 0.0, -0.1, Dir.NORTH)

		location = DolGuldurGenst()
		affix(location, LOTRWaypoint.DOL_GULDUR, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MIRKWOOD_MOUNTAINS, 0.0, 0.0, Dir.NORTH)

		location = MordorGenst()
		affix(location, LOTRWaypoint.UDUN, 0.6, 0.0, Dir.EAST)
		affix(location, LOTRWaypoint.BARAD_DUR, 0.4, -0.6, Dir.NORTH)
		affix(location, LOTRWaypoint.MINAS_MORGUL, 0.0, 0.6, Dir.SOUTH)
		affix(location, LOTRWaypoint.DURTHANG, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.CARACH_ANGREN, 0.0, -0.6, Dir.NORTH)
		affix(location, LOTRWaypoint.CIRITH_UNGOL, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.MORIGOST, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.NARGROTH, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.AMON_ANGREN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.SEREGOST, 0.0, -0.6, Dir.NORTH)
		affix(location, LOTRWaypoint.FELLBEASTS, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.EASTERN_GUARD, 0.6, 0.0, Dir.EAST)
		affix(location, LOTRWaypoint.NURNEN_NORTHERN_SHORE, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.NURNEN_SOUTHERN_SHORE, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.NURNEN_WESTERN_SHORE, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.NURNEN_EASTERN_SHORE, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.THAURBAND, 0.0, 0.6, Dir.SOUTH)
		affix(location, LOTRWaypoint.VALLEY_OF_SPIDERS, 0.0, 0.0, Dir.NORTH)

		location = object : SingleGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun addVillageStructures(random: Random) {
						addStructure(WoodenHouse(false), 0, 0, 0, true)
					}
				}
			}
		}
		affix(location, LOTRWaypoint.WITHYWINDLE_VALLEY, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.BEORN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.RHOSGOBEL, 0.0, 0.0, Dir.NORTH)

		location = object : SingleGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun addVillageStructures(random: Random) {
						addStructure(IsengardTower, 0, 0, 2, true)
					}
				}
			}
		}
		affix(location, LOTRWaypoint.ISENGARD, 0.0, -3.5, Dir.NORTH)

		location = UrukGenst()
		affix(location, LOTRWaypoint.URUK_HIGHLANDS, 0.0, 0.0, Dir.NORTH)

		/* HARAD */
		location = HarnennorGenst()
		affix(location, LOTRWaypoint.HARNEN_SEA_TOWN, 0.0, 0.6, Dir.NORTH)
		affix(location, LOTRWaypoint.HARNEN_BLACK_TOWN, 0.0, 0.6, Dir.NORTH)
		affix(location, LOTRWaypoint.HARNEN_RIVER_TOWN, 0.0, 0.6, Dir.NORTH)
		affix(location, LOTRWaypoint.HARNEN_ROAD_TOWN, 0.2, -0.8, Dir.SOUTH)

		location = object : UmbarGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun setupVillageProperties(random: Random) {
						villageType = VillageType.TOWN
						villageName = LOTRNames.getHaradVillageName(random)
					}
				}
			}
		}
		affix(location, LOTRWaypoint.UMBAR_CITY, -0.6, (-0.2).toHaradTownGate(false), Dir.EAST)
		affix(location, LOTRWaypoint.UMBAR_GATE, (-0.2).toHaradTownGate(true), 0.6, Dir.NORTH)
		affix(location, LOTRWaypoint.GATE_HERUMOR, -0.5, (0.0).toHaradTownGate(false), Dir.EAST)

		location = object : SouthronGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun setupVillageProperties(random: Random) {
						villageType = VillageType.TOWN
						villageName = LOTRNames.getHaradVillageName(random)
					}
				}
			}
		}
		affix(location, LOTRWaypoint.CEDAR_ROAD, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.COAST_RIVER_TOWN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.COAST_CITY, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.FERTILE_VALLEY, -0.6, (-0.1).toHaradTownGate(false), Dir.EAST)
		affix(location, LOTRWaypoint.GARDENS_BERUTHIEL, -0.6, (-0.3).toHaradTownGate(false), Dir.EAST)
		affix(location, LOTRWaypoint.COAST_FORTRESS, -0.6, (-0.3).toHaradTownGate(false), Dir.EAST)
		affix(location, LOTRWaypoint.GATE_FUINUR, -0.6, (0.0).toHaradTownGate(false), Dir.EAST)
		affix(location, LOTRWaypoint.AIN_AL_HARAD, -0.5, (0.0).toHaradTownGate(false), Dir.EAST)

		location = object : SouthronGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun setupVillageProperties(random: Random) {
						villageType = VillageType.FORT
						villageName = LOTRNames.getHaradVillageName(random)
					}
				}
			}
		}
		affix(location, LOTRWaypoint.SANDHILL_TOWN, 0.0, 0.0, Dir.NORTH)

		location = NomadGenst()
		affix(location, LOTRWaypoint.DESERT_RIVER_TOWN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.SOUTH_DESERT_TOWN, 0.0, 0.5, Dir.SOUTH)
		affix(location, LOTRWaypoint.DESERT_TOWN, 0.0, 0.5, Dir.SOUTH)

		location = object : MorwaithGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun hasSymmetry(): Boolean = false
				}
			}
		}
		affix(location, LOTRWaypoint.TOWN_BONES, 0.0, 0.2, Dir.SOUTH)

		location = MorwaithGenst()
		affix(location, LOTRWaypoint.DESERT_RIVER_TOWN, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.GREAT_PLAINS_NORTH, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.GREAT_PLAINS_SOUTH, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.GREAT_PLAINS_WEST, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.GREAT_PLAINS_EAST, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.GREEN_VALLEY, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.HARAD_LAKES, 0.0, 0.0, Dir.NORTH)

		location = HalfTrollsGenst()
		affix(location, LOTRWaypoint.TROLL_ISLAND, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.BLACK_COAST, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.BLOOD_RIVER, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.SHADOW_POINT, 0.0, 0.0, Dir.NORTH)

		location = GulfGenst()
		affix(location, LOTRWaypoint.GULF_TRADE_TOWN, 0.9, 0.0, Dir.WEST) //Bakrîzad
		affix(location, LOTRWaypoint.GULF_CITY, 1.0, -0.1, Dir.WEST) //Khôpakadar
		affix(location, LOTRWaypoint.GULF_NORTH_TOWN, 0.0, -0.9, Dir.SOUTH) //Yaphurushi
		affix(location, LOTRWaypoint.GULF_OF_HARAD, 1.0, -0.3, Dir.WEST) //Arminazûl
		affix(location, LOTRWaypoint.GULF_EAST_PORT, 0.9, 0.0, Dir.WEST) //Ephalôn
		affix(location, LOTRWaypoint.GULF_EAST_BAY, 0.0, 0.0, Dir.NORTH) //Topaz Bay

		location = TaurethrimGenst()
		affix(location, LOTRWaypoint.JUNGLE_CITY_TRADE, -0.8, 0.0, Dir.WEST)
		affix(location, LOTRWaypoint.TAURELONDE, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.LAKE_HARAD, 0.0, 0.0, Dir.NORTH)
		affix(location, LOTRWaypoint.JUNGLE_CITY_NORTH, 0.0, -0.8, Dir.NORTH)
		affix(location, LOTRWaypoint.JUNGLE_CITY_DEEP, 0.0, 0.8, Dir.SOUTH)
		affix(location, LOTRWaypoint.JUNGLE_CITY_WATCH, 0.0, 0.8, Dir.SOUTH)
		affix(location, LOTRWaypoint.JUNGLE_LAKES, 0.0, 0.8, Dir.SOUTH)
		affix(location, LOTRWaypoint.JUNGLE_CITY_STONE, 0.2, -0.9, Dir.NORTH)
		affix(location, LOTRWaypoint.JUNGLE_CITY_CAVES, -0.9, -0.1, Dir.WEST)

		affix(location, LOTRWaypoint.JUNGLE_CITY_CAPITAL, -0.5, -1.0, Dir.NORTH)
		affix(location, LOTRWaypoint.JUNGLE_CITY_EAST, 1.0, -0.4, Dir.EAST)

		location = object : TaurethrimGenst() {
			override fun createVillageInstance(
				world: World, i: Int, k: Int, random: Random, loc: LocationInfo
			): AbstractInstance<*> {
				return object : Instance(this, world, i, k, random, loc) {
					override fun getRoadType(): LOTRRoadType = LOTRRoadType.PATH
				}
			}
		}
		affix(location, LOTRWaypoint.JUNGLE_CITY_OLD, 0.0, -0.8, Dir.NORTH)

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