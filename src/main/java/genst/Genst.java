package genst;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import genst.instances.*;
import lotr.common.LOTRMod;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.genlayer.LOTRGenLayerWorld;
import lotr.common.world.map.LOTRMountains;
import lotr.common.world.map.LOTRRoadType;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.structure2.LOTRWorldGenGondorStructure;
import lotr.common.world.village.LOTRVillageGen;
import lotr.common.world.village.LOTRVillageGenGondor;
import lotr.common.world.village.LocationInfo;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Random;

@Mod(modid = "genst", dependencies = "required-after:lotr")
public class Genst {

	public static LOTRRoadType PATH_COBBLE = new LOTRRoadType() {

		@Override
		public RoadBlock getBlock(Random rand, BiomeGenBase biome, boolean top, boolean slab) {
			RoadBlock[] blockTypes;
			if (slab) {
				blockTypes = new RoadBlock[]{new RoadBlock(Blocks.stone_slab, 5), new RoadBlock(Blocks.stone_slab, 3), new RoadBlock(Blocks.stone_slab, 3), new RoadBlock(LOTRMod.slabSingleV, 4)};
			} else {
				blockTypes = new RoadBlock[]{new RoadBlock(Blocks.stonebrick, 0), new RoadBlock(Blocks.cobblestone, 0), new RoadBlock(Blocks.cobblestone, 0), new RoadBlock(Blocks.mossy_cobblestone, 0)};
			}
			return blockTypes[rand.nextInt(blockTypes.length)];
		}
	};

	public static void addMountain(String name, double x, double z, float h, int r, int lava) {
		Class<?>[] classArr = {Double.TYPE, Double.TYPE, Float.TYPE, Integer.TYPE, Integer.TYPE};
		Object[] args = {x, z, h, r, lava};
		EnumHelper.addEnum(LOTRMountains.class, name, classArr, args);
	}

	public static void lazyAffix(LOTRVillageGen vil, LOTRBiome... bios) {
		for (LOTRBiome bm : bios) {
			bm.decorator.addVillage(vil);
		}
		LOTRBiome.ocean.decorator.addVillage(vil);
		LOTRBiome.beach.decorator.addVillage(vil);
		LOTRBiome.lake.decorator.addVillage(vil);
		LOTRBiome.river.decorator.addVillage(vil);
	}

	public void addFixedLocationMapOffset(LOTRVillageGen inst, LOTRWaypoint wp, int addX, int addZ, int rotation) {
		GenstLogger.skip.add(wp);
		inst.addFixedLocation(wp, addX * LOTRGenLayerWorld.scale, addZ * LOTRGenLayerWorld.scale, rotation, "PLACEHOLDER");
	}

	@Mod.EventHandler
	public void postload(FMLPostInitializationEvent event) {
		addMountain("PLACEHOLDER", LOTRWaypoint.HIMLING.getX(), LOTRWaypoint.HIMLING.getY(), 1, 100, 0);
		addMountain("PLACEHOLDER", LOTRWaypoint.TOL_FUIN.getX(), LOTRWaypoint.TOL_FUIN.getY(), 1, 100, 0);
		addMountain("PLACEHOLDER", LOTRWaypoint.TOL_MORWEN.getX(), LOTRWaypoint.TOL_MORWEN.getY(), 1, 100, 0);
		addMountain("PLACEHOLDER", LOTRWaypoint.MENELTARMA_SUMMIT.getX(), LOTRWaypoint.MENELTARMA_SUMMIT.getY(), 1, 100, 0);
		addMountain("PLACEHOLDER", LOTRWaypoint.OATBARTON.getX(), LOTRWaypoint.OATBARTON.getY(), 1, 100, 0);
		addMountain("PLACEHOLDER", LOTRWaypoint.NEEDLEHOLE.getX(), LOTRWaypoint.NEEDLEHOLE.getY(), 1, 100, 0);
		addMountain("PLACEHOLDER", LOTRWaypoint.NOBOTTLE.getX(), LOTRWaypoint.NOBOTTLE.getY(), 1, 100, 0);
		addMountain("PLACEHOLDER", LOTRWaypoint.MOUNT_RERIR.getX(), LOTRWaypoint.MOUNT_RERIR.getY(), 1, 100, 0);
		addMountain("PLACEHOLDER", LOTRWaypoint.CARN_DUM.getX(), LOTRWaypoint.CARN_DUM.getY(), 1, 100, 0);

		LOTRVillageGenGondor gondorFortPG = new LOTRVillageGenGondor(LOTRBiome.gondor, LOTRWorldGenGondorStructure.GondorFiefdom.PINNATH_GELIN, 0.0F) {
			@Override
			protected LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
				return new Instance(this, world, i, k, random, loc) {

					@Override
					protected void setupVillageProperties(Random random) {
						villageType = VillageType.FORT;
					}
				};
			}
		};
		addFixedLocationMapOffset(gondorFortPG, LOTRWaypoint.GREEN_HILLS, 0, 0, 0);
		lazyAffix(gondorFortPG, LOTRBiome.pinnathGelin);

		LOTRVillageGenGondor gondorFort = new LOTRVillageGenGondor(LOTRBiome.gondor, LOTRWorldGenGondorStructure.GondorFiefdom.GONDOR, 0.0F) {
			@Override
			protected LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
				return new Instance(this, world, i, k, random, loc) {

					@Override
					protected void setupVillageProperties(Random random) {
						villageType = VillageType.FORT;
					}
				};
			}
		};
		addFixedLocationMapOffset(gondorFort, LOTRWaypoint.TOLFALAS_ISLAND, 0, 0, 0);
		lazyAffix(gondorFort, LOTRBiome.tolfalas);

		LOTRVillageGenGondor gondorVillage = new LOTRVillageGenGondor(LOTRBiome.gondor, LOTRWorldGenGondorStructure.GondorFiefdom.GONDOR, 0.0F) {
			@Override
			protected LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
				return new Instance(this, world, i, k, random, loc) {

					@Override
					protected void setupVillageProperties(Random random) {
						villageType = VillageType.VILLAGE;
					}
				};
			}
		};
		addFixedLocationMapOffset(gondorVillage, LOTRWaypoint.ANDUIN_MOUTH, 0, 0, 0);
		lazyAffix(gondorVillage, LOTRBiome.anduinMouth);

		LOTRVillageGenGondor gondorVillagePel = new LOTRVillageGenGondor(LOTRBiome.gondor, LOTRWorldGenGondorStructure.GondorFiefdom.PELARGIR, 0.0F) {
			@Override
			protected LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
				return new Instance(this, world, i, k, random, loc) {

					@Override
					protected void setupVillageProperties(Random random) {
						villageType = VillageType.TOWN;
					}
				};
			}
		};
		addFixedLocationMapOffset(gondorVillagePel, LOTRWaypoint.PELARGIR, 0, -1, 0);
		lazyAffix(gondorVillagePel, LOTRBiome.pelargir);

		LOTRVillageGenGondor gondorVillageLeb = new LOTRVillageGenGondor(LOTRBiome.gondor, LOTRWorldGenGondorStructure.GondorFiefdom.LEBENNIN, 0.0F) {
			@Override
			protected LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
				return new Instance(this, world, i, k, random, loc) {

					@Override
					protected void setupVillageProperties(Random random) {
						villageType = VillageType.TOWN;
					}
				};
			}
		};
		addFixedLocationMapOffset(gondorVillageLeb, LOTRWaypoint.LINHIR, 0, 1, 0);
		lazyAffix(gondorVillageLeb, LOTRBiome.lebennin);

		LOTRVillageGenGondor gondorVillageLam = new LOTRVillageGenGondor(LOTRBiome.gondor, LOTRWorldGenGondorStructure.GondorFiefdom.LAMEDON, 0.0F) {
			@Override
			protected LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
				return new Instance(this, world, i, k, random, loc) {

					@Override
					protected void setupVillageProperties(Random random) {
						villageType = VillageType.VILLAGE;
					}
				};
			}
		};
		addFixedLocationMapOffset(gondorVillageLam, LOTRWaypoint.ETHRING, 1, 0, 0);
		lazyAffix(gondorVillageLam, LOTRBiome.lamedon);

		LOTRVillageGenGondor gondorFortLam = new LOTRVillageGenGondor(LOTRBiome.gondor, LOTRWorldGenGondorStructure.GondorFiefdom.LAMEDON, 0.0F) {
			@Override
			protected LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
				return new Instance(this, world, i, k, random, loc) {

					@Override
					protected void setupVillageProperties(Random random) {
						villageType = VillageType.TOWN;
					}
				};
			}
		};
		addFixedLocationMapOffset(gondorFortLam, LOTRWaypoint.CALEMBEL, 0, 1, 0);
		lazyAffix(gondorFortLam, LOTRBiome.lamedon);

		LOTRVillageGenGondor gondorCityDA = new LOTRVillageGenGondor(LOTRBiome.gondor, LOTRWorldGenGondorStructure.GondorFiefdom.DOL_AMROTH, 0.0F) {
			@Override
			protected LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
				return new Instance(this, world, i, k, random, loc) {

					@Override
					protected void setupVillageProperties(Random random) {
						villageType = VillageType.TOWN;
					}
				};
			}
		};
		addFixedLocationMapOffset(gondorCityDA, LOTRWaypoint.TARNOST, 0, -1, 0);
		addFixedLocationMapOffset(gondorCityDA, LOTRWaypoint.DOL_AMROTH, -1, 0, 0);
		lazyAffix(gondorCityDA, LOTRBiome.dorEnErnil);

		/* READY */
		LOTRVillageGenAngmar angmar = new LOTRVillageGenAngmar(LOTRBiome.ocean, 0.0F);
		addFixedLocationMapOffset(angmar, LOTRWaypoint.CARN_DUM, 0, 0, 0);
		addFixedLocationMapOffset(angmar, LOTRWaypoint.MOUNT_GRAM, 0, 0, 0);
		addFixedLocationMapOffset(angmar, LOTRWaypoint.MOUNT_GUNDABAD, 0, 0, 0);
		lazyAffix(angmar, LOTRBiome.angmar, LOTRBiome.angmarMountains, LOTRBiome.mistyMountains);

		/* READY */
		LOTRVillageGenRuinsMedium ruinsMedium = new LOTRVillageGenRuinsMedium(LOTRBiome.ocean, 0.0F);
		addFixedLocationMapOffset(ruinsMedium, LOTRWaypoint.ARVEDUI_MINES, 0, 0, 0);
		addFixedLocationMapOffset(ruinsMedium, LOTRWaypoint.HIMLING, 0, 0, 0);
		addFixedLocationMapOffset(ruinsMedium, LOTRWaypoint.TOL_FUIN, 0, 0, 0);
		addFixedLocationMapOffset(ruinsMedium, LOTRWaypoint.MENELTARMA_SUMMIT, 0, 0, 0);
		addFixedLocationMapOffset(ruinsMedium, LOTRWaypoint.MOUNT_RERIR, 0, 0, 0);
		addFixedLocationMapOffset(ruinsMedium, LOTRWaypoint.NORTH_DOWNS, 0, 0, 0);
		addFixedLocationMapOffset(ruinsMedium, LOTRWaypoint.SOUTH_DOWNS, 0, 0, 0);
		addFixedLocationMapOffset(ruinsMedium, LOTRWaypoint.WITHERED_HEATH, 0, 0, 0);
		addFixedLocationMapOffset(ruinsMedium, LOTRWaypoint.FIELD_OF_CELEBRANT, 0, 0, 0);
		addFixedLocationMapOffset(ruinsMedium, LOTRWaypoint.CAPE_OF_FOROCHEL, 0, 0, 0);
		addFixedLocationMapOffset(ruinsMedium, LOTRWaypoint.SOUTH_FOROCHEL, 0, 0, 0);
		addFixedLocationMapOffset(ruinsMedium, LOTRWaypoint.CORSAIRS_LANDING, 0, 0, 0);
		addFixedLocationMapOffset(ruinsMedium, LOTRWaypoint.MOUTHS_ISEN, 0, 0, 0);
		addFixedLocationMapOffset(ruinsMedium, LOTRWaypoint.FORDS_OF_ISEN, 0, 0, 0);
		addFixedLocationMapOffset(ruinsMedium, LOTRWaypoint.ENEDWAITH_ROAD, 1, 0, 0);
		addFixedLocationMapOffset(ruinsMedium, LOTRWaypoint.GREENWAY_CROSSROADS, 0, 1, 0);
		addFixedLocationMapOffset(ruinsMedium, LOTRWaypoint.SARN_FORD, 2, 2, 0);
		lazyAffix(ruinsMedium, LOTRBiome.shire, LOTRBiome.eriador, LOTRBiome.dunland, LOTRBiome.minhiriath, LOTRBiome.adornland, LOTRBiome.forodwaith, LOTRBiome.enedwaith, LOTRBiome.celebrant, LOTRBiome.island, LOTRBiome.meneltarma, LOTRBiome.lindon, LOTRBiome.eriadorDowns, LOTRBiome.tundra);

		LOTRVillageGenHobbit hobbit = new LOTRVillageGenHobbit(LOTRBiome.ocean, 0.0F);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.BROCKENBORINGS, 0, 0, 1);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.BUCKLEBURY, 0, 0, 0);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.BYWATER, 0, 0, 1);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.DEEPHALLOW, 0, 0, 0);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.FROGMORTON, 0, 0, 0);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.GREENHOLM, 0, 0, 1);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.HAYSEND, 0, 0, 0);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.HAY_GATE, 0, 0, 0);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.HOBBITON, 0, 0, 0);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.LITTLE_DELVING, 0, 0, 1);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.LONGBOTTOM, 0, 0, 0);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.MICHEL_DELVING, 0, 0, 1);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.NEEDLEHOLE, 0, 0, 1);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.NOBOTTLE, 0, 0, 1);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.OATBARTON, 0, 0, 0);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.OVERHILL, 0, 0, 0);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.SCARY, 0, 0, 0);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.STOCK, 0, 0, 0);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.TIGHFIELD, 0, 0, 0);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.TUCKBOROUGH, 0, 0, 1);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.WAYMEET, 0, 0, 0);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.WHITFURROWS, 0, 0, 0);
		addFixedLocationMapOffset(hobbit, LOTRWaypoint.WILLOWBOTTOM, 0, 0, 1);
		lazyAffix(hobbit, LOTRBiome.shire, LOTRBiome.shireMoors, LOTRBiome.shireWoodlands);

		/* READY */
		LOTRVillageGenHighElven highElven = new LOTRVillageGenHighElven(LOTRBiome.ocean, 0.0F);
		addFixedLocationMapOffset(highElven, LOTRWaypoint.FORLOND, 0, 0, 0);
		addFixedLocationMapOffset(highElven, LOTRWaypoint.HARLOND, 0, 0, 0);
		addFixedLocationMapOffset(highElven, LOTRWaypoint.AMON_EREB, 0, 0, 0);
		addFixedLocationMapOffset(highElven, LOTRWaypoint.MITHLOND_NORTH, 0, 0, 0);
		addFixedLocationMapOffset(highElven, LOTRWaypoint.MITHLOND_SOUTH, 0, 0, 0);
		addFixedLocationMapOffset(highElven, LOTRWaypoint.FORLINDON, 0, 0, 0);
		addFixedLocationMapOffset(highElven, LOTRWaypoint.HARLINDON, 0, 0, 0);
		addFixedLocationMapOffset(highElven, LOTRWaypoint.TOWER_HILLS, 0, 0, 0);
		addFixedLocationMapOffset(highElven, LOTRWaypoint.TOWER_HILLS, 0, 0, 0);
		lazyAffix(highElven, LOTRBiome.lindon, LOTRBiome.towerHills);

		/* READY */
		LOTRVillageGenRuinsCity ruinsCity = new LOTRVillageGenRuinsCity(LOTRBiome.ocean, 0.0F);
		addFixedLocationMapOffset(ruinsCity, LOTRWaypoint.THARBAD, 0, 0, 0);
		addFixedLocationMapOffset(ruinsCity, LOTRWaypoint.FORNOST, 0, 0, 0);
		addFixedLocationMapOffset(ruinsCity, LOTRWaypoint.ANNUMINAS, 0, 0, 0);
		addFixedLocationMapOffset(ruinsCity, LOTRWaypoint.OST_IN_EDHIL, 0, 0, 0);
		addFixedLocationMapOffset(ruinsCity, LOTRWaypoint.ERYN_VORN, 0, 0, 0);
		addFixedLocationMapOffset(ruinsCity, LOTRWaypoint.LOND_DAER, 0, 0, 0);
		addFixedLocationMapOffset(ruinsCity, LOTRWaypoint.FRAMSBURG, 0, 0, 0);
		addFixedLocationMapOffset(ruinsCity, LOTRWaypoint.EAST_BIGHT, 0, 0, 0);
		addFixedLocationMapOffset(ruinsCity, LOTRWaypoint.OLD_RHOVANION, -1, 0, 0);
		addFixedLocationMapOffset(ruinsCity, LOTRWaypoint.DORWINION_CROSSROADS, 0, 1, 0);
		addFixedLocationMapOffset(ruinsCity, LOTRWaypoint.OLD_ELF_WAY, 0, 1, 0);
		addFixedLocationMapOffset(ruinsCity, LOTRWaypoint.THE_TROLLSHAWS, 0, 0, 0);
		addFixedLocationMapOffset(ruinsCity, LOTRWaypoint.EDHELLOND, 0, 1, 0);
		lazyAffix(ruinsCity, LOTRBiome.gondor, LOTRBiome.trollshaws, LOTRBiome.wilderland, LOTRBiome.loneLands, LOTRBiome.eastBight, LOTRBiome.anduinVale, LOTRBiome.erynVorn, LOTRBiome.minhiriath, LOTRBiome.eriador, LOTRBiome.enedwaith, LOTRBiome.eriadorDowns, LOTRBiome.eregion);

		/* READY */
		LOTRVillageGenRuinsSmallWooden ruinsSmallWooden = new LOTRVillageGenRuinsSmallWooden(LOTRBiome.ocean, 0.0F);
		addFixedLocationMapOffset(ruinsSmallWooden, LOTRWaypoint.FORSAKEN_INN, 0, 0, 0);
		lazyAffix(ruinsSmallWooden, LOTRBiome.breeland);

		/* READY */
		LOTRVillageGenRuinsSmallStone ruinsSmallStone = new LOTRVillageGenRuinsSmallStone(LOTRBiome.ocean, 0.0F);
		addFixedLocationMapOffset(ruinsSmallStone, LOTRWaypoint.WEATHERTOP, 0, -1, 0);
		lazyAffix(ruinsSmallStone, LOTRBiome.loneLands, LOTRBiome.island);

		/* READY */
		LOTRVillageGenRivendell rivendell = new LOTRVillageGenRivendell(LOTRBiome.ocean, 0.0F);
		addFixedLocationMapOffset(rivendell, LOTRWaypoint.RIVENDELL, 0, 0, 0);
		lazyAffix(rivendell, LOTRBiome.rivendell);

		/* READY */
		LOTRVillageGenBarrow barrow = new LOTRVillageGenBarrow(LOTRBiome.ocean, 0.0F);
		addFixedLocationMapOffset(barrow, LOTRWaypoint.TOL_MORWEN, 0, 0, 0);
		lazyAffix(barrow, LOTRBiome.island);

		/* READY */
		LOTRVillageGenDunland dunland = new LOTRVillageGenDunland(LOTRBiome.ocean, 0.0F);
		addFixedLocationMapOffset(dunland, LOTRWaypoint.NORTH_DUNLAND, 0, 0, 0);
		addFixedLocationMapOffset(dunland, LOTRWaypoint.SOUTH_DUNLAND, 0, 0, 0);
		addFixedLocationMapOffset(dunland, LOTRWaypoint.DWARROWVALE, 0, 0, 0);
		addFixedLocationMapOffset(dunland, LOTRWaypoint.WULFBURG, 0, 0, 0);
		addFixedLocationMapOffset(dunland, LOTRWaypoint.FRECA_HOLD, 0, 0, 0);
		lazyAffix(dunland, LOTRBiome.dunland, LOTRBiome.adornland);

		GenstLogger.skip.add(LOTRWaypoint.ARCHET);
		GenstLogger.skip.add(LOTRWaypoint.BRANDYWINE_BRIDGE);
		GenstLogger.skip.add(LOTRWaypoint.BREE);
		GenstLogger.skip.add(LOTRWaypoint.COMBE);
		GenstLogger.skip.add(LOTRWaypoint.DIMRILL_DALE);
		GenstLogger.skip.add(LOTRWaypoint.FORD_BRUINEN);
		GenstLogger.skip.add(LOTRWaypoint.GOBLIN_TOWN);
		GenstLogger.skip.add(LOTRWaypoint.HIGH_PASS);
		GenstLogger.skip.add(LOTRWaypoint.LAST_BRIDGE);
		GenstLogger.skip.add(LOTRWaypoint.MOUNT_CARADHRAS);
		GenstLogger.skip.add(LOTRWaypoint.MOUNT_CELEBDIL);
		GenstLogger.skip.add(LOTRWaypoint.MOUNT_DOLMED);
		GenstLogger.skip.add(LOTRWaypoint.MOUNT_FANUIDHOL);
		GenstLogger.skip.add(LOTRWaypoint.MOUNT_METHEDRAS);
		GenstLogger.skip.add(LOTRWaypoint.RAS_MORTHIL);
		GenstLogger.skip.add(LOTRWaypoint.STADDLE);
		GenstLogger.skip.add(LOTRWaypoint.WEST_GATE);
		GenstLogger.skip.add(LOTRWaypoint.BELEGOST);
		GenstLogger.skip.add(LOTRWaypoint.NOGROD);
		GenstLogger.skip.add(LOTRWaypoint.THORIN_HALLS);
		GenstLogger.skip.add(LOTRWaypoint.THRAIN_HALLS);
		GenstLogger.skip.add(LOTRWaypoint.EAGLES_EYRIE);
		GenstLogger.skip.add(LOTRWaypoint.SCATHA);
		GenstLogger.skip.add(LOTRWaypoint.CARROCK);
		GenstLogger.skip.add(LOTRWaypoint.DAINS_HALLS);
		GenstLogger.skip.add(LOTRWaypoint.ENCHANTED_RIVER);
		GenstLogger.skip.add(LOTRWaypoint.RIVER_GATE);
		GenstLogger.skip.add(LOTRWaypoint.EREBOR);
		GenstLogger.skip.add(LOTRWaypoint.FOREST_GATE);
		GenstLogger.skip.add(LOTRWaypoint.RAUROS);
	}

	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent e) {
		e.registerServerCommand(new GenstLogger());
	}
}
