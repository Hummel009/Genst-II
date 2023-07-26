package genst.instances;

import lotr.common.LOTRMod;
import lotr.common.entity.LOTREntityNPCRespawner;
import lotr.common.entity.npc.LOTREntityRivendellElf;
import lotr.common.entity.npc.LOTREntityRivendellWarrior;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.map.LOTRRoadType;
import lotr.common.world.structure2.LOTRWorldGenNPCRespawner;
import lotr.common.world.structure2.LOTRWorldGenRivendellForge;
import lotr.common.world.structure2.LOTRWorldGenRivendellHouse;
import lotr.common.world.structure2.LOTRWorldGenStructureBase2;
import lotr.common.world.village.LOTRVillageGen;
import lotr.common.world.village.LocationInfo;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.Random;

public class LOTRVillageGenRivendell extends LOTRVillageGen {
	public LOTRVillageGenRivendell(LOTRBiome biome, float f) {
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

	public static class Instance extends LOTRVillageGen.AbstractInstance<LOTRVillageGenRivendell> {
		public Instance(LOTRVillageGenRivendell village, World world, int i, int k, Random random, LocationInfo loc) {
			super(village, world, i, k, random, loc);
		}

		@Override
		protected void addVillageStructures(Random random) {
			addStructure(new LOTRWorldGenNPCRespawner(false) {

				@Override
				public void setupRespawner(LOTREntityNPCRespawner spawner) {
					spawner.setSpawnClass(LOTREntityRivendellElf.class);
					spawner.setCheckRanges(40, -12, 12, 40);
					spawner.setSpawnRanges(20, -6, 6, 64);
					spawner.setBlockEnemySpawnRange(60);
				}
			}, 0, 0, 0);
			addStructure(new LOTRWorldGenNPCRespawner(false) {

				@Override
				public void setupRespawner(LOTREntityNPCRespawner spawner) {
					spawner.setSpawnClass(LOTREntityRivendellWarrior.class);
					spawner.setCheckRanges(40, -12, 12, 16);
					spawner.setSpawnRanges(20, -6, 6, 64);
					spawner.setBlockEnemySpawnRange(60);
				}
			}, 0, 0, 0);
			int pathEnd = 68;
			int pathSide = 7;
			int centreSide = 19;
			addStructure(new LOTRWorldGenRivendellForge(false), 0, -2, 0, true);
			addStructure(new LOTRWorldGenRivendellHouse(false), 0, -centreSide, 2, true);
			if (random.nextBoolean()) {
				addStructure(new LOTRWorldGenRivendellHouse(false), -pathEnd, 0, 1, true);
				addStructure(getOtherVillageStructure(random), pathEnd, 0, 3, true);
			} else {
				addStructure(getOtherVillageStructure(random), -pathEnd, 0, 1, true);
				addStructure(new LOTRWorldGenRivendellHouse(false), pathEnd, 0, 3, true);
			}
			int rowHouses = 3;
			for (int l = -rowHouses; l <= rowHouses; ++l) {
				int i1 = l * 18;
				int k1 = pathSide;
				if (Math.abs(i1) <= 15) {
					k1 += 15 - pathSide;
				}
				if (Math.abs(l) >= 1) {
					addStructure(getRandomHouse(random), i1, -k1, 2);
				}
				addStructure(getRandomHouse(random), i1, k1, 0);
				if (l != 0) {
					addStructure(getRandomHouse(random), i1, -k1, 2);
				}
				if (random.nextInt(3) == 0) {
					addStructure(getRandomHouse(random), i1, -k1, 2);
				}
			}
		}

		private LOTRWorldGenStructureBase2 getOtherVillageStructure(Random random) {
			if (random.nextBoolean()) {
				return new LOTRWorldGenRivendellHouse(false);
			}
			return new LOTRWorldGenRivendellForge(false);
		}

		@Override
		protected LOTRRoadType getPath(Random random, int i, int k) {
			int i1 = Math.abs(i);
			int k1 = Math.abs(k);
			int dSq = i * i + k * k;
			int imn = 15 + random.nextInt(4);
			if (dSq < imn * imn || i1 <= 64 && k1 <= 3 + random.nextInt(2)) {
				return LOTRRoadType.HIGH_ELVEN;
			}

			return null;
		}

		private LOTRWorldGenStructureBase2 getRandomHouse(Random random) {
			return new LOTRWorldGenRivendellHouse(false);
		}

		@Override
		public boolean isFlat() {
			return false;
		}

		@Override
		public boolean isVillageSpecificSurface(World world, int i, int j, int k) {
			Block block = world.getBlock(i, j, k);
			return block == LOTRMod.brick3;
		}

		@Override
		protected void setupVillageProperties(Random random) {
		}

	}

}
