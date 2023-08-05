package genst.world

import genst.instance.*
import genst.utils.affix
import lotr.common.LOTRDimension
import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRWaypoint
import lotr.common.world.structure2.LOTRWorldGenGondorStructure
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*

object GenstLocations {
	var locations: MutableSet<LOTRVillageGen> = HashSet()

	fun postInit() {
		val gondorFortPG =
			object : GenstGondor(LOTRBiome.forodwaith, LOTRWorldGenGondorStructure.GondorFiefdom.PINNATH_GELIN, 0.0f) {
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
		affix(gondorFortPG, LOTRWaypoint.GREEN_HILLS, 0.0, 0.0, Dir.NORTH)

		val gondorFort =
			object : GenstGondor(LOTRBiome.forodwaith, LOTRWorldGenGondorStructure.GondorFiefdom.GONDOR, 0.0f) {
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
		affix(gondorFort, LOTRWaypoint.TOLFALAS_ISLAND, 0.0, 0.0, Dir.NORTH)

		val gondorVillage =
			object : GenstGondor(LOTRBiome.forodwaith, LOTRWorldGenGondorStructure.GondorFiefdom.GONDOR, 0.0f) {
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
		affix(gondorVillage, LOTRWaypoint.ANDUIN_MOUTH, 0.0, 0.0, Dir.NORTH)

		val gondorVillagePel =
			object : GenstGondor(LOTRBiome.forodwaith, LOTRWorldGenGondorStructure.GondorFiefdom.PELARGIR, 0.0f) {
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
		affix(gondorVillagePel, LOTRWaypoint.PELARGIR, -0.1, -1.0, Dir.NORTH)

		val gondorVillageLeb =
			object : GenstGondor(LOTRBiome.forodwaith, LOTRWorldGenGondorStructure.GondorFiefdom.LEBENNIN, 0.0f) {
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
		affix(gondorVillageLeb, LOTRWaypoint.LINHIR, -0.1, 1.0, Dir.SOUTH)

		val gondorVillageLam =
			object : GenstGondor(LOTRBiome.forodwaith, LOTRWorldGenGondorStructure.GondorFiefdom.LAMEDON, 0.0f) {
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
		affix(gondorVillageLam, LOTRWaypoint.ETHRING, 1.1, -0.2, Dir.EAST)

		val gondorTownLam =
			object : GenstGondor(LOTRBiome.forodwaith, LOTRWorldGenGondorStructure.GondorFiefdom.LAMEDON, 0.0f) {
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
		affix(gondorTownLam, LOTRWaypoint.CALEMBEL, 0.2, -1.1, Dir.NORTH)

		val gondorCityDA =
			object : GenstGondor(LOTRBiome.forodwaith, LOTRWorldGenGondorStructure.GondorFiefdom.DOL_AMROTH, 0.0f) {
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
		affix(gondorCityDA, LOTRWaypoint.TARNOST, 0.0, -1.0, Dir.NORTH)
		affix(gondorCityDA, LOTRWaypoint.DOL_AMROTH, -1.0, 0.0, Dir.WEST)

		val gondorCity =
			object : GenstGondor(LOTRBiome.forodwaith, LOTRWorldGenGondorStructure.GondorFiefdom.GONDOR, 0.0f) {
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
		affix(gondorCity, LOTRWaypoint.MINAS_TIRITH, -1.0, 0.0, Dir.WEST)

		val erech = GenstErech(LOTRBiome.forodwaith, 0.0f)
		affix(erech, LOTRWaypoint.ERECH, -0.07, 0.0, Dir.WEST)

		/* READY */
		val angmar = LOTRVillageGenAngmar(LOTRBiome.forodwaith, 0.0f)
		affix(angmar, LOTRWaypoint.CARN_DUM, 0.0, 0.0, Dir.NORTH)
		affix(angmar, LOTRWaypoint.MOUNT_GRAM, 0.0, 0.0, Dir.NORTH)

		/* READY */
		val ruinsMedium = LOTRVillageGenRuinsMedium(LOTRBiome.forodwaith, 0.0f)
		affix(ruinsMedium, LOTRWaypoint.ARVEDUI_MINES, 0.0, 0.0, Dir.NORTH)
		affix(ruinsMedium, LOTRWaypoint.HIMLING, 0.0, 0.0, Dir.NORTH)
		affix(ruinsMedium, LOTRWaypoint.TOL_FUIN, 0.0, 0.0, Dir.NORTH)
		affix(ruinsMedium, LOTRWaypoint.MENELTARMA_SUMMIT, 0.0, 0.0, Dir.NORTH)
		affix(ruinsMedium, LOTRWaypoint.WITHERED_HEATH, 0.0, 0.0, Dir.NORTH)
		affix(ruinsMedium, LOTRWaypoint.FIELD_OF_CELEBRANT, 0.0, 0.0, Dir.NORTH)
		affix(ruinsMedium, LOTRWaypoint.CORSAIRS_LANDING, 0.0, 0.0, Dir.NORTH)
		affix(ruinsMedium, LOTRWaypoint.MOUTHS_ISEN, 0.0, 0.0, Dir.NORTH)
		affix(ruinsMedium, LOTRWaypoint.FORDS_OF_ISEN, 0.0, 0.0, Dir.NORTH)
		affix(ruinsMedium, LOTRWaypoint.ENEDWAITH_ROAD, 1.0, 0.0, Dir.NORTH)
		affix(ruinsMedium, LOTRWaypoint.GREENWAY_CROSSROADS, 0.0, 1.0, Dir.NORTH)
		affix(ruinsMedium, LOTRWaypoint.SARN_FORD, 2.0, 2.0, Dir.NORTH)

		val hobbit = LOTRVillageGenHobbit(LOTRBiome.forodwaith, 0.0f)
		affix(hobbit, LOTRWaypoint.BROCKENBORINGS, 0.0, 0.0, Dir.EAST)
		affix(hobbit, LOTRWaypoint.BUCKLEBURY, 0.0, 0.0, Dir.NORTH)
		affix(hobbit, LOTRWaypoint.BYWATER, 0.0, 0.0, Dir.EAST)
		affix(hobbit, LOTRWaypoint.DEEPHALLOW, 0.0, 0.0, Dir.NORTH)
		affix(hobbit, LOTRWaypoint.FROGMORTON, 0.0, 0.0, Dir.NORTH)
		affix(hobbit, LOTRWaypoint.GREENHOLM, 0.0, 0.0, Dir.EAST)
		affix(hobbit, LOTRWaypoint.HAYSEND, 0.0, 0.0, Dir.NORTH)
		affix(hobbit, LOTRWaypoint.HAY_GATE, 0.0, 0.0, Dir.NORTH)
		affix(hobbit, LOTRWaypoint.HOBBITON, 0.0, 0.0, Dir.NORTH)
		affix(hobbit, LOTRWaypoint.LITTLE_DELVING, 0.0, 0.0, Dir.EAST)
		affix(hobbit, LOTRWaypoint.LONGBOTTOM, 0.0, 0.0, Dir.NORTH)
		affix(hobbit, LOTRWaypoint.MICHEL_DELVING, 0.0, 0.0, Dir.EAST)
		affix(hobbit, LOTRWaypoint.NEEDLEHOLE, 0.0, 0.0, Dir.EAST)
		affix(hobbit, LOTRWaypoint.NOBOTTLE, 0.0, 0.0, Dir.EAST)
		affix(hobbit, LOTRWaypoint.OATBARTON, 0.0, 0.0, Dir.NORTH)
		affix(hobbit, LOTRWaypoint.OVERHILL, 0.0, 0.0, Dir.NORTH)
		affix(hobbit, LOTRWaypoint.SCARY, 0.0, 0.0, Dir.NORTH)
		affix(hobbit, LOTRWaypoint.STOCK, 0.0, 0.0, Dir.NORTH)
		affix(hobbit, LOTRWaypoint.TIGHFIELD, 0.0, 0.0, Dir.NORTH)
		affix(hobbit, LOTRWaypoint.TUCKBOROUGH, 0.0, 0.0, Dir.EAST)
		affix(hobbit, LOTRWaypoint.WAYMEET, 0.0, 0.0, Dir.NORTH)
		affix(hobbit, LOTRWaypoint.WHITFURROWS, 0.0, 0.0, Dir.NORTH)
		affix(hobbit, LOTRWaypoint.WILLOWBOTTOM, 0.0, 0.0, Dir.EAST)

		/* READY */
		val highElven = LOTRVillageGenHighElven(LOTRBiome.forodwaith, 0.0f)
		affix(highElven, LOTRWaypoint.FORLOND, 0.0, 0.0, Dir.NORTH)
		affix(highElven, LOTRWaypoint.HARLOND, 0.0, 0.0, Dir.NORTH)
		affix(highElven, LOTRWaypoint.AMON_EREB, 0.0, 0.0, Dir.NORTH)
		affix(highElven, LOTRWaypoint.MITHLOND_NORTH, 0.0, 0.0, Dir.NORTH)
		affix(highElven, LOTRWaypoint.MITHLOND_SOUTH, 0.0, 0.0, Dir.NORTH)
		affix(highElven, LOTRWaypoint.FORLINDON, 0.0, 0.0, Dir.NORTH)
		affix(highElven, LOTRWaypoint.HARLINDON, 0.0, 0.0, Dir.NORTH)
		affix(highElven, LOTRWaypoint.TOWER_HILLS, 0.0, 0.0, Dir.NORTH)
		affix(highElven, LOTRWaypoint.TOWER_HILLS, 0.0, 0.0, Dir.NORTH)

		/* READY */
		val ruinsCity = LOTRVillageGenRuinsCity(LOTRBiome.forodwaith, 0.0f)
		affix(ruinsCity, LOTRWaypoint.THARBAD, 0.0, 0.0, Dir.NORTH)
		affix(ruinsCity, LOTRWaypoint.FORNOST, 0.0, 0.0, Dir.NORTH)
		affix(ruinsCity, LOTRWaypoint.ANNUMINAS, 0.0, 0.0, Dir.NORTH)
		affix(ruinsCity, LOTRWaypoint.OST_IN_EDHIL, 0.0, 0.0, Dir.NORTH)
		affix(ruinsCity, LOTRWaypoint.ERYN_VORN, 0.0, 0.0, Dir.NORTH)
		affix(ruinsCity, LOTRWaypoint.LOND_DAER, 0.0, 0.0, Dir.NORTH)
		affix(ruinsCity, LOTRWaypoint.FRAMSBURG, 0.0, 0.0, Dir.NORTH)
		affix(ruinsCity, LOTRWaypoint.EAST_BIGHT, 0.0, 0.0, Dir.NORTH)
		affix(ruinsCity, LOTRWaypoint.OLD_RHOVANION, -1.0, 0.0, Dir.NORTH)
		affix(ruinsCity, LOTRWaypoint.DORWINION_CROSSROADS, 0.0, 1.0, Dir.NORTH)
		affix(ruinsCity, LOTRWaypoint.OLD_ELF_WAY, 0.0, 1.0, Dir.NORTH)
		affix(ruinsCity, LOTRWaypoint.THE_TROLLSHAWS, 0.0, 0.0, Dir.NORTH)
		affix(ruinsCity, LOTRWaypoint.EDHELLOND, 0.0, 1.0, Dir.NORTH)

		/* READY */
		val ruinsSmallWooden = LOTRVillageGenRuinsSmallWooden(LOTRBiome.forodwaith, 0.0f)
		affix(ruinsSmallWooden, LOTRWaypoint.FORSAKEN_INN, 0.0, 0.0, Dir.NORTH)

		/* READY */
		val ruinsSmallStone = LOTRVillageGenRuinsSmallStone(LOTRBiome.forodwaith, 0.0f)
		affix(ruinsSmallStone, LOTRWaypoint.WEATHERTOP, 0.0, -1.0, Dir.NORTH)

		/* READY */
		val rivendell = LOTRVillageGenRivendell(LOTRBiome.forodwaith, 0.0f)
		affix(rivendell, LOTRWaypoint.RIVENDELL, 0.0, 0.0, Dir.NORTH)

		/* READY */
		val barrow = LOTRVillageGenBarrow(LOTRBiome.forodwaith, 0.0f)
		affix(barrow, LOTRWaypoint.TOL_MORWEN, 0.0, 0.0, Dir.NORTH)
		affix(barrow, LOTRWaypoint.GLADDEN_FIELDS, 0.0, 0.0, Dir.NORTH)
		affix(barrow, LOTRWaypoint.CROSSINGS_OF_POROS, 11.0, 1.0, Dir.NORTH)

		/* READY */
		val dunland = LOTRVillageGenDunland(LOTRBiome.forodwaith, 0.0f)
		affix(dunland, LOTRWaypoint.NORTH_DUNLAND, 0.0, 0.0, Dir.NORTH)
		affix(dunland, LOTRWaypoint.SOUTH_DUNLAND, 0.0, 0.0, Dir.NORTH)
		affix(dunland, LOTRWaypoint.DWARROWVALE, 0.0, 0.0, Dir.NORTH)
		affix(dunland, LOTRWaypoint.WULFBURG, 0.0, 0.0, Dir.NORTH)
		affix(dunland, LOTRWaypoint.FRECA_HOLD, 0.0, 0.0, Dir.NORTH)

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