package genst.instances;

import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.map.LOTRRoadType;
import lotr.common.world.structure2.LOTRWorldGenNumenorRuin;
import lotr.common.world.structure2.LOTRWorldGenStoneRuin;
import lotr.common.world.village.LOTRVillageGen;
import lotr.common.world.village.LocationInfo;
import net.minecraft.world.World;

import java.util.Random;

public class LOTRVillageGenRuinsMedium extends LOTRVillageGen {
	public LOTRVillageGenRuinsMedium(LOTRBiome biome, float f) {
		super(biome);
		gridScale = 10;
		gridRandomDisplace = 1;
		spawnChance = f;
		villageChunkRadius = 5;
	}

	@Override
	protected LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
		return new Instance(this, world, i, k, random, loc);
	}

	public static class Instance extends LOTRVillageGen.AbstractInstance<LOTRVillageGenRuinsMedium> {
		public Instance(LOTRVillageGenRuinsMedium village, World world, int i, int k, Random random, LocationInfo loc) {
			super(village, world, i, k, random, loc);
		}

		@Override
		protected void addVillageStructures(Random random) {
			addStructure(new LOTRWorldGenNumenorRuin(false), -18, 0, 0, true);
			addStructure(new LOTRWorldGenNumenorRuin(false), +18, 0, 0, true);
			addStructure(new LOTRWorldGenNumenorRuin(false), 0, +18, 0, true);
			addStructure(new LOTRWorldGenNumenorRuin(false), 0, +18, 0, true);
			addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), -18, -18, 0, true);
			addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), +18, -18, 0, true);
			addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), -18, +18, 0, true);
			addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), +18, +18, 0, true);
			addStructure(new LOTRWorldGenNumenorRuin(false), 0, 0, 0, true);
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
		}
	}
}