package genst;

import lotr.common.LOTRMod;
import lotr.common.world.map.LOTRRoadType;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Random;

public class GenstRoadType {
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
}
