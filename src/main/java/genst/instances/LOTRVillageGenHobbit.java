package genst.instances;

import lotr.common.entity.LOTREntityNPCRespawner;
import lotr.common.entity.npc.LOTREntityHobbit;
import lotr.common.entity.npc.LOTREntityHobbitBounder;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.map.LOTRRoadType;
import lotr.common.world.structure2.*;
import lotr.common.world.village.LOTRVillageGen;
import lotr.common.world.village.LocationInfo;
import net.minecraft.world.World;

import java.util.Random;

public class LOTRVillageGenHobbit extends LOTRVillageGen {
	public LOTRVillageGenHobbit(LOTRBiome biome, float f) {
		super(biome);
		gridScale = 14;
		gridRandomDisplace = 1;
		spawnChance = f;
		villageChunkRadius = 6;
	}

	@Override
	protected LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
		return new Instance(this, world, i, k, random, loc);
	}

	public static class Instance extends LOTRVillageGen.AbstractInstance<LOTRVillageGenHobbit> {
		public Instance(LOTRVillageGenHobbit village, World world, int i, int k, Random random, LocationInfo loc) {
			super(village, world, i, k, random, loc);
		}

		@Override
		protected void addVillageStructures(Random random) {
			addStructure(new LOTRWorldGenNPCRespawner(false) {

				@Override
				public void setupRespawner(LOTREntityNPCRespawner spawner) {
					spawner.setSpawnClass(LOTREntityHobbit.class);
					spawner.setCheckRanges(40, -12, 12, 40);
					spawner.setSpawnRanges(20, -6, 6, 64);
					spawner.setBlockEnemySpawnRange(60);
				}
			}, 0, 0, 0);
			addStructure(new LOTRWorldGenNPCRespawner(false) {

				@Override
				public void setupRespawner(LOTREntityNPCRespawner spawner) {
					spawner.setSpawnClass(LOTREntityHobbitBounder.class);
					spawner.setCheckRanges(40, -12, 12, 16);
					spawner.setSpawnRanges(20, -6, 6, 64);
					spawner.setBlockEnemySpawnRange(60);
				}
			}, 0, 0, 0);
			int pathEnd = 68;
			int pathSide = 7;
			addStructure(new LOTRWorldGenBreeWell(false), 0, -2, 0, true);
			if (random.nextBoolean()) {
				addStructure(new LOTRWorldGenHobbitTavern(false), -pathEnd, 0, 1, true);
				addStructure(getOtherVillageStructure(random), pathEnd, 0, 3, true);
			} else {
				addStructure(getOtherVillageStructure(random), -pathEnd, 0, 1, true);
				addStructure(new LOTRWorldGenHobbitTavern(false), pathEnd, 0, 3, true);
			}
			int rowHouses = 3;
			for (int l = -rowHouses; l <= rowHouses; ++l) {
				int i1 = l * 18;
				int k1 = pathSide;
				if (Math.abs(i1) <= 15) {
					k1 += 15 - pathSide;
				}
				if (Math.abs(l) >= 1) {
					addStructure(new LOTRWorldGenHobbitBurrow(false), i1, -k1, 2);
				}
				addStructure(new LOTRWorldGenHobbitBurrow(false), i1, k1, 0);
				int k2 = k1 + 20;
				if (l != 0) {
					addStructure(new LOTRWorldGenHayBales(false), i1, -k2, 2);
				}
				addStructure(new LOTRWorldGenHayBales(false), i1, k2, 0);
			}
		}

		private LOTRWorldGenStructureBase2 getOtherVillageStructure(Random random) {
			if (random.nextBoolean()) {
				return new LOTRWorldGenHobbitFarm(false);
			}
			return new LOTRWorldGenHobbitWindmill(false);
		}

		@Override
		protected LOTRRoadType getPath(Random random, int i, int k) {
			int i1 = Math.abs(i);
			int k1 = Math.abs(k);
			int dSq = i * i + k * k;
			int imn = 15 + random.nextInt(4);
			if (dSq < imn * imn || i1 <= 64 && k1 <= 3 + random.nextInt(2)) {
				return LOTRRoadType.PATH;
			}
			return null;
		}

		@Override
		public boolean isFlat() {
			return false;
		}

		@Override
		public boolean isVillageSpecificSurface(World world, int i, int j, int k) {
			return false;
		}

		@Override
		protected void setupVillageProperties(Random random) {
		}

	}

}
