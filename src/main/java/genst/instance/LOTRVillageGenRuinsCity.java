package genst.instance;

import genst.Genst;
import genst.GenstRoadType;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.map.LOTRRoadType;
import lotr.common.world.structure2.LOTRWorldGenNumenorRuin;
import lotr.common.world.structure2.LOTRWorldGenStoneRuin;
import lotr.common.world.village.LOTRVillageGen;
import lotr.common.world.village.LocationInfo;
import net.minecraft.world.World;

import java.util.Random;

public class LOTRVillageGenRuinsCity extends LOTRVillageGen {

	public LOTRVillageGenRuinsCity(LOTRBiome biome, float f) {
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

	public static class Instance extends LOTRVillageGen.AbstractInstance<LOTRVillageGenRuinsCity> {
		public Instance(LOTRVillageGenRuinsCity village, World world, int i, int k, Random random, LocationInfo loc) {
			super(village, world, i, k, random, loc);
		}

		@Override
		protected void addVillageStructures(Random random) {
			int marketZ;
			if (random.nextBoolean()) {
				addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), 0, 10, 2, true);
			} else {
				addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), 0, 6, 2, true);
			}
			int mansionX = 12;
			int mansionZ = 20;
			addStructure(new LOTRWorldGenNumenorRuin(false), -mansionX, -mansionZ, 2, true);
			addStructure(new LOTRWorldGenNumenorRuin(false), mansionX, -mansionZ, 2, true);
			addStructure(new LOTRWorldGenNumenorRuin(false), -mansionX, mansionZ, 0, true);
			addStructure(new LOTRWorldGenNumenorRuin(false), mansionX, mansionZ, 0, true);
			addStructure(new LOTRWorldGenNumenorRuin(false), -mansionZ, -mansionX, 1, true);
			addStructure(new LOTRWorldGenNumenorRuin(false), -mansionZ, mansionX, 1, true);
			addStructure(new LOTRWorldGenNumenorRuin(false), mansionZ, -mansionX, 3, true);
			addStructure(new LOTRWorldGenNumenorRuin(false), mansionZ, mansionX, 3, true);
			for (int l = 0; l <= 3; ++l) {
				int houseX = 10 + 14 * l;
				int houseZ1 = 58;
				int houseZ2 = 68;
				if (l <= 2) {
					if (l >= 1) {
						if (l == 1) {
							addStructure(new LOTRWorldGenNumenorRuin(false), -houseX - 7, -houseZ1, 0, true);
						}
					} else {
						addStructure(new LOTRWorldGenNumenorRuin(false), -houseX, -houseZ1, 0, true);
					}
					addStructure(new LOTRWorldGenNumenorRuin(false), houseX, -houseZ1, 0, true);
					if (l >= 1) {
						addStructure(new LOTRWorldGenNumenorRuin(false), -houseX, houseZ1, 2, true);
						addStructure(new LOTRWorldGenNumenorRuin(false), houseX, houseZ1, 2, true);
					}
					addStructure(new LOTRWorldGenNumenorRuin(false), -houseZ1, -houseX, 3, true);
					addStructure(new LOTRWorldGenNumenorRuin(false), -houseZ1, houseX, 3, true);
					addStructure(new LOTRWorldGenNumenorRuin(false), houseZ1, -houseX, 1, true);
					addStructure(new LOTRWorldGenNumenorRuin(false), houseZ1, houseX, 1, true);
				}
				if (l == 1) {
					addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), -houseX, -houseZ2, 2, true);
					addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), houseX, -houseZ2, 2, true);
					addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), -houseX, houseZ2, 0, true);
					addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), houseX, houseZ2, 0, true);
					addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), -houseZ2, -houseX, 1, true);
					addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), -houseZ2, houseX, 1, true);
					addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), houseZ2, -houseX, 3, true);
					addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), houseZ2, houseX, 3, true);
					continue;
				}
				addStructure(new LOTRWorldGenNumenorRuin(false), -houseX, -houseZ2, 2, true);
				addStructure(new LOTRWorldGenNumenorRuin(false), houseX, -houseZ2, 2, true);
				addStructure(new LOTRWorldGenNumenorRuin(false), -houseX, houseZ2, 0, true);
				addStructure(new LOTRWorldGenNumenorRuin(false), houseX, houseZ2, 0, true);
				addStructure(new LOTRWorldGenNumenorRuin(false), -houseZ2, -houseX, 1, true);
				addStructure(new LOTRWorldGenNumenorRuin(false), -houseZ2, houseX, 1, true);
				addStructure(new LOTRWorldGenNumenorRuin(false), houseZ2, -houseX, 3, true);
				addStructure(new LOTRWorldGenNumenorRuin(false), houseZ2, houseX, 3, true);
			}
			int marketX = 4;
			for (int l = 0; l <= 2; ++l) {
				marketZ = 56 - l * 7;
				addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), -marketX, marketZ, 1, true);
				addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), marketX, marketZ, 3, true);
			}
			marketX = 14;
			marketZ = 59;
			addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), -marketX, marketZ, 2, true);
			addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), marketX, marketZ, 2, true);
			int gardenX = 58;
			addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), -gardenX + 5, -gardenX, 0, true);
			addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), gardenX - 5, -gardenX, 0, true);
			addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), -gardenX + 5, gardenX, 2, true);
			addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), gardenX - 5, gardenX, 2, true);
			int wellX = 69;
			int wellZ = 63;
			addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), -wellX, -wellZ, 1, true);
			addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), -wellZ, -wellX, 2, true);
			addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), wellX, -wellZ, 3, true);
			addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), wellZ, -wellX, 2, true);
			addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), -wellX, wellZ, 1, true);
			addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), -wellZ, wellX, 0, true);
			addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), wellX, wellZ, 3, true);
			addStructure(new LOTRWorldGenStoneRuin.STONE(5, 7), wellZ, wellX, 0, true);
		}

		@Override
		protected LOTRRoadType getPath(Random random, int i, int k) {
			int outerOut;
			int innerOut;
			int i1 = Math.abs(i);
			int k1 = Math.abs(k);
			innerOut = 18;
			if (i1 <= innerOut && k1 <= innerOut && (i1 >= 12 || k1 >= 12)) {
				return GenstRoadType.PATH_COBBLE;
			}
			if (i1 <= 3 && k1 >= innerOut && k1 <= 86 || k1 <= 3 && i1 >= innerOut && i1 <= 86) {
				return GenstRoadType.PATH_COBBLE;
			}
			outerOut = 66;
			if (i1 <= outerOut && k1 <= outerOut && (i1 >= 60 || k1 >= 60)) {
				return GenstRoadType.PATH_COBBLE;
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
