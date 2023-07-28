package genst;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import genst.instance.*;
import lotr.common.LOTRDimension;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.genlayer.LOTRGenLayerWorld;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.structure2.LOTRWorldGenGondorStructure;
import lotr.common.world.village.LOTRVillageGen;
import lotr.common.world.village.LOTRVillageGenGondor;
import lotr.common.world.village.LocationInfo;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Mod(modid = "genst", dependencies = "required-after:lotr")
public class Genst {
	public static Set<LOTRVillageGen> locations = new HashSet<>();

	public void affix(LOTRVillageGen inst, LOTRWaypoint wp, int addX, int addZ, int rotation) {
		GenstLogger.skip.add(wp);
		inst.addFixedLocation(wp, addX * LOTRGenLayerWorld.scale, addZ * LOTRGenLayerWorld.scale, rotation, "PLACEHOLDER");
		locations.add(inst);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		GenstMountains.postInit();

		LOTRVillageGen gondorFortPG = new LOTRVillageGenGondor(LOTRBiome.gondor, LOTRWorldGenGondorStructure.GondorFiefdom.PINNATH_GELIN, 0.0F) {
			@Override
			public LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
				return new Instance(this, world, i, k, random, loc) {

					@Override
					public void setupVillageProperties(Random random) {
						villageType = VillageType.FORT;
					}
				};
			}
		};
		affix(gondorFortPG, LOTRWaypoint.GREEN_HILLS, 0, 0, 0);

		LOTRVillageGen gondorFort = new LOTRVillageGenGondor(LOTRBiome.gondor, LOTRWorldGenGondorStructure.GondorFiefdom.GONDOR, 0.0F) {
			@Override
			public LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
				return new Instance(this, world, i, k, random, loc) {

					@Override
					public void setupVillageProperties(Random random) {
						villageType = VillageType.FORT;
					}
				};
			}
		};
		affix(gondorFort, LOTRWaypoint.TOLFALAS_ISLAND, 0, 0, 0);

		LOTRVillageGen gondorVillage = new LOTRVillageGenGondor(LOTRBiome.gondor, LOTRWorldGenGondorStructure.GondorFiefdom.GONDOR, 0.0F) {
			@Override
			public LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
				return new Instance(this, world, i, k, random, loc) {

					@Override
					public void setupVillageProperties(Random random) {
						villageType = VillageType.VILLAGE;
					}
				};
			}
		};
		affix(gondorVillage, LOTRWaypoint.ANDUIN_MOUTH, 0, 0, 0);

		LOTRVillageGen gondorVillagePel = new LOTRVillageGenGondor(LOTRBiome.gondor, LOTRWorldGenGondorStructure.GondorFiefdom.PELARGIR, 0.0F) {
			@Override
			public LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
				return new Instance(this, world, i, k, random, loc) {

					@Override
					public void setupVillageProperties(Random random) {
						villageType = VillageType.TOWN;
					}
				};
			}
		};
		affix(gondorVillagePel, LOTRWaypoint.PELARGIR, 0, -1, 0);

		LOTRVillageGen gondorVillageLeb = new LOTRVillageGenGondor(LOTRBiome.gondor, LOTRWorldGenGondorStructure.GondorFiefdom.LEBENNIN, 0.0F) {
			@Override
			public LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
				return new Instance(this, world, i, k, random, loc) {

					@Override
					public void setupVillageProperties(Random random) {
						villageType = VillageType.TOWN;
					}
				};
			}
		};
		affix(gondorVillageLeb, LOTRWaypoint.LINHIR, 0, 1, 0);

		LOTRVillageGen gondorVillageLam = new LOTRVillageGenGondor(LOTRBiome.gondor, LOTRWorldGenGondorStructure.GondorFiefdom.LAMEDON, 0.0F) {
			@Override
			public LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
				return new Instance(this, world, i, k, random, loc) {

					@Override
					public void setupVillageProperties(Random random) {
						villageType = VillageType.VILLAGE;
					}
				};
			}
		};
		affix(gondorVillageLam, LOTRWaypoint.ETHRING, 1, 0, 0);

		LOTRVillageGen gondorFortLam = new LOTRVillageGenGondor(LOTRBiome.gondor, LOTRWorldGenGondorStructure.GondorFiefdom.LAMEDON, 0.0F) {
			@Override
			public LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
				return new Instance(this, world, i, k, random, loc) {

					@Override
					public void setupVillageProperties(Random random) {
						villageType = VillageType.TOWN;
					}
				};
			}
		};
		affix(gondorFortLam, LOTRWaypoint.CALEMBEL, 0, 1, 0);

		LOTRVillageGen gondorCityDA = new LOTRVillageGenGondor(LOTRBiome.gondor, LOTRWorldGenGondorStructure.GondorFiefdom.DOL_AMROTH, 0.0F) {
			@Override
			public LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
				return new Instance(this, world, i, k, random, loc) {

					@Override
					public void setupVillageProperties(Random random) {
						villageType = VillageType.TOWN;
					}
				};
			}
		};
		affix(gondorCityDA, LOTRWaypoint.TARNOST, 0, -1, 0);
		affix(gondorCityDA, LOTRWaypoint.DOL_AMROTH, -1, 0, 0);

		/* READY */
		LOTRVillageGen angmar = new LOTRVillageGenAngmar(LOTRBiome.ocean, 0.0F);
		affix(angmar, LOTRWaypoint.CARN_DUM, 0, 0, 0);
		affix(angmar, LOTRWaypoint.MOUNT_GRAM, 0, 0, 0);
		affix(angmar, LOTRWaypoint.MOUNT_GUNDABAD, 0, 0, 0);

		/* READY */
		LOTRVillageGen ruinsMedium = new LOTRVillageGenRuinsMedium(LOTRBiome.ocean, 0.0F);
		affix(ruinsMedium, LOTRWaypoint.ARVEDUI_MINES, 0, 0, 0);
		affix(ruinsMedium, LOTRWaypoint.HIMLING, 0, 0, 0);
		affix(ruinsMedium, LOTRWaypoint.TOL_FUIN, 0, 0, 0);
		affix(ruinsMedium, LOTRWaypoint.MENELTARMA_SUMMIT, 0, 0, 0);
		affix(ruinsMedium, LOTRWaypoint.MOUNT_RERIR, 0, 0, 0);
		affix(ruinsMedium, LOTRWaypoint.NORTH_DOWNS, 0, 0, 0);
		affix(ruinsMedium, LOTRWaypoint.SOUTH_DOWNS, 0, 0, 0);
		affix(ruinsMedium, LOTRWaypoint.WITHERED_HEATH, 0, 0, 0);
		affix(ruinsMedium, LOTRWaypoint.FIELD_OF_CELEBRANT, 0, 0, 0);
		affix(ruinsMedium, LOTRWaypoint.CAPE_OF_FOROCHEL, 0, 0, 0);
		affix(ruinsMedium, LOTRWaypoint.SOUTH_FOROCHEL, 0, 0, 0);
		affix(ruinsMedium, LOTRWaypoint.CORSAIRS_LANDING, 0, 0, 0);
		affix(ruinsMedium, LOTRWaypoint.MOUTHS_ISEN, 0, 0, 0);
		affix(ruinsMedium, LOTRWaypoint.FORDS_OF_ISEN, 0, 0, 0);
		affix(ruinsMedium, LOTRWaypoint.ENEDWAITH_ROAD, 1, 0, 0);
		affix(ruinsMedium, LOTRWaypoint.GREENWAY_CROSSROADS, 0, 1, 0);
		affix(ruinsMedium, LOTRWaypoint.SARN_FORD, 2, 2, 0);

		LOTRVillageGen hobbit = new LOTRVillageGenHobbit(LOTRBiome.ocean, 0.0F);
		affix(hobbit, LOTRWaypoint.BROCKENBORINGS, 0, 0, 1);
		affix(hobbit, LOTRWaypoint.BUCKLEBURY, 0, 0, 0);
		affix(hobbit, LOTRWaypoint.BYWATER, 0, 0, 1);
		affix(hobbit, LOTRWaypoint.DEEPHALLOW, 0, 0, 0);
		affix(hobbit, LOTRWaypoint.FROGMORTON, 0, 0, 0);
		affix(hobbit, LOTRWaypoint.GREENHOLM, 0, 0, 1);
		affix(hobbit, LOTRWaypoint.HAYSEND, 0, 0, 0);
		affix(hobbit, LOTRWaypoint.HAY_GATE, 0, 0, 0);
		affix(hobbit, LOTRWaypoint.HOBBITON, 0, 0, 0);
		affix(hobbit, LOTRWaypoint.LITTLE_DELVING, 0, 0, 1);
		affix(hobbit, LOTRWaypoint.LONGBOTTOM, 0, 0, 0);
		affix(hobbit, LOTRWaypoint.MICHEL_DELVING, 0, 0, 1);
		affix(hobbit, LOTRWaypoint.NEEDLEHOLE, 0, 0, 1);
		affix(hobbit, LOTRWaypoint.NOBOTTLE, 0, 0, 1);
		affix(hobbit, LOTRWaypoint.OATBARTON, 0, 0, 0);
		affix(hobbit, LOTRWaypoint.OVERHILL, 0, 0, 0);
		affix(hobbit, LOTRWaypoint.SCARY, 0, 0, 0);
		affix(hobbit, LOTRWaypoint.STOCK, 0, 0, 0);
		affix(hobbit, LOTRWaypoint.TIGHFIELD, 0, 0, 0);
		affix(hobbit, LOTRWaypoint.TUCKBOROUGH, 0, 0, 1);
		affix(hobbit, LOTRWaypoint.WAYMEET, 0, 0, 0);
		affix(hobbit, LOTRWaypoint.WHITFURROWS, 0, 0, 0);
		affix(hobbit, LOTRWaypoint.WILLOWBOTTOM, 0, 0, 1);

		/* READY */
		LOTRVillageGen highElven = new LOTRVillageGenHighElven(LOTRBiome.ocean, 0.0F);
		affix(highElven, LOTRWaypoint.FORLOND, 0, 0, 0);
		affix(highElven, LOTRWaypoint.HARLOND, 0, 0, 0);
		affix(highElven, LOTRWaypoint.AMON_EREB, 0, 0, 0);
		affix(highElven, LOTRWaypoint.MITHLOND_NORTH, 0, 0, 0);
		affix(highElven, LOTRWaypoint.MITHLOND_SOUTH, 0, 0, 0);
		affix(highElven, LOTRWaypoint.FORLINDON, 0, 0, 0);
		affix(highElven, LOTRWaypoint.HARLINDON, 0, 0, 0);
		affix(highElven, LOTRWaypoint.TOWER_HILLS, 0, 0, 0);
		affix(highElven, LOTRWaypoint.TOWER_HILLS, 0, 0, 0);

		/* READY */
		LOTRVillageGen ruinsCity = new LOTRVillageGenRuinsCity(LOTRBiome.ocean, 0.0F);
		affix(ruinsCity, LOTRWaypoint.THARBAD, 0, 0, 0);
		affix(ruinsCity, LOTRWaypoint.FORNOST, 0, 0, 0);
		affix(ruinsCity, LOTRWaypoint.ANNUMINAS, 0, 0, 0);
		affix(ruinsCity, LOTRWaypoint.OST_IN_EDHIL, 0, 0, 0);
		affix(ruinsCity, LOTRWaypoint.ERYN_VORN, 0, 0, 0);
		affix(ruinsCity, LOTRWaypoint.LOND_DAER, 0, 0, 0);
		affix(ruinsCity, LOTRWaypoint.FRAMSBURG, 0, 0, 0);
		affix(ruinsCity, LOTRWaypoint.EAST_BIGHT, 0, 0, 0);
		affix(ruinsCity, LOTRWaypoint.OLD_RHOVANION, -1, 0, 0);
		affix(ruinsCity, LOTRWaypoint.DORWINION_CROSSROADS, 0, 1, 0);
		affix(ruinsCity, LOTRWaypoint.OLD_ELF_WAY, 0, 1, 0);
		affix(ruinsCity, LOTRWaypoint.THE_TROLLSHAWS, 0, 0, 0);
		affix(ruinsCity, LOTRWaypoint.EDHELLOND, 0, 1, 0);

		/* READY */
		LOTRVillageGen ruinsSmallWooden = new LOTRVillageGenRuinsSmallWooden(LOTRBiome.ocean, 0.0F);
		affix(ruinsSmallWooden, LOTRWaypoint.FORSAKEN_INN, 0, 0, 0);

		/* READY */
		LOTRVillageGen ruinsSmallStone = new LOTRVillageGenRuinsSmallStone(LOTRBiome.ocean, 0.0F);
		affix(ruinsSmallStone, LOTRWaypoint.WEATHERTOP, 0, -1, 0);

		/* READY */
		LOTRVillageGen rivendell = new LOTRVillageGenRivendell(LOTRBiome.ocean, 0.0F);
		affix(rivendell, LOTRWaypoint.RIVENDELL, 0, 0, 0);

		/* READY */
		LOTRVillageGen barrow = new LOTRVillageGenBarrow(LOTRBiome.ocean, 0.0F);
		affix(barrow, LOTRWaypoint.TOL_MORWEN, 0, 0, 0);

		/* READY */
		LOTRVillageGen dunland = new LOTRVillageGenDunland(LOTRBiome.ocean, 0.0F);
		affix(dunland, LOTRWaypoint.NORTH_DUNLAND, 0, 0, 0);
		affix(dunland, LOTRWaypoint.SOUTH_DUNLAND, 0, 0, 0);
		affix(dunland, LOTRWaypoint.DWARROWVALE, 0, 0, 0);
		affix(dunland, LOTRWaypoint.WULFBURG, 0, 0, 0);
		affix(dunland, LOTRWaypoint.FRECA_HOLD, 0, 0, 0);

		for (LOTRVillageGen loc : locations) {
			for (LOTRBiome biome : LOTRDimension.MIDDLE_EARTH.biomeList) {
				if (biome != null) {
					biome.decorator.addVillage(loc);
				}
			}
		}

		GenstLogger.postInit();
	}

	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent e) {
		e.registerServerCommand(new GenstLogger());
	}
}
