package genst.instances;

import lotr.common.entity.LOTREntityNPCRespawner;
import lotr.common.entity.npc.LOTREntityAngmarOrc;
import lotr.common.entity.npc.LOTREntityAngmarOrcArcher;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.map.LOTRRoadType;
import lotr.common.world.structure2.*;
import lotr.common.world.village.LOTRVillageGen;
import lotr.common.world.village.LocationInfo;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class LOTRVillageGenAngmar extends LOTRVillageGen {
	public LOTRVillageGenAngmar(LOTRBiome biome, float f) {
		super(biome);
		gridScale = 12;
		gridRandomDisplace = 1;
		spawnChance = f;
		villageChunkRadius = 4;
	}

	@Override
	protected LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
		return new Instance(this, world, i, k, random, loc);
	}

	public static class Instance extends LOTRVillageGen.AbstractInstance<LOTRVillageGenAngmar> {
		private int numOuterHouses;

		public Instance(LOTRVillageGenAngmar village, World world, int i, int k, Random random, LocationInfo loc) {
			super(village, world, i, k, random, loc);
		}

		@Override
		protected void addVillageStructures(Random random) {
			addStructure(new LOTRWorldGenNPCRespawner(false) {

				@Override
				public void setupRespawner(LOTREntityNPCRespawner spawner) {
					spawner.setSpawnClass(LOTREntityAngmarOrc.class);
					spawner.setCheckRanges(80, -12, 12, 50);
					spawner.setSpawnRanges(40, -8, 8, 40);
					spawner.setBlockEnemySpawnRange(60);
				}
			}, 0, 0, 0);
			addStructure(new LOTRWorldGenNPCRespawner(false) {

				@Override
				public void setupRespawner(LOTREntityNPCRespawner spawner) {
					spawner.setSpawnClasses(LOTREntityAngmarOrc.class, LOTREntityAngmarOrcArcher.class);
					spawner.setCheckRanges(80, -12, 12, 24);
					spawner.setSpawnRanges(40, -8, 8, 40);
					spawner.setBlockEnemySpawnRange(60);
				}
			}, 0, 0, 0);
			addStructure(new LOTRWorldGenAngmarTower2(false), 0, 0, 0, true);
			addStructure(new LOTRWorldGenAngmarHillmanChieftainHouse(false), 0, 14, 0, true);
			addStructure(new LOTRWorldGenAngmarHillmanHouse(false), 0, -14, 2, true);
			addStructure(new LOTRWorldGenAngmarForgeTent(false), -14, 0, 1, true);
			addStructure(new LOTRWorldGenAngmarForgeTent(false), 14, 0, 3, true);
			int minOuterSize = MathHelper.getRandomIntegerInRange(random, 35, 45);
			float frac = 1.0f / numOuterHouses;
			float turn = 0.0f;
			while (turn < 1.0f) {
				float turnR = (float) Math.toRadians((turn += frac) * 360.0f);
				float sin = MathHelper.sin(turnR);
				float cos = MathHelper.cos(turnR);
				int r = 0;
				float turn8 = turn * 8.0f;
				if (turn8 >= 1.0f && turn8 < 3.0f) {
					r = 0;
				} else if (turn8 >= 3.0f && turn8 < 5.0f) {
					r = 1;
				} else if (turn8 >= 5.0f && turn8 < 7.0f) {
					r = 2;
				} else if (turn8 >= 7.0f || turn8 < 1.0f) {
					r = 3;
				}
				int l = minOuterSize + random.nextInt(5);
				int i = Math.round(l * cos);
				int k = Math.round(l * sin);
				addStructure(new LOTRWorldGenAngmarTent(false), i, k, r);
			}

		}

		@Override
		protected LOTRRoadType getPath(Random random, int i, int k) {
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
			numOuterHouses = MathHelper.getRandomIntegerInRange(random, 8, 14);
		}

	}

}
