package lotr.common.world;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lotr.common.LOTRDimension;
import lotr.common.LOTRMod;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.biome.LOTRBiomeGenFarHaradJungle;
import lotr.common.world.biome.LOTRBiomeGenFarHaradMangrove;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.biome.variant.LOTRBiomeVariantList;
import lotr.common.world.biome.variant.LOTRBiomeVariantStorage;
import lotr.common.world.genlayer.*;
import lotr.common.world.map.LOTRFixedStructures;
import lotr.common.world.village.LOTRVillageGen;
import lotr.common.world.village.LOTRVillagePositionCache;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.structure.MapGenStructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@SuppressWarnings("all")
public class LOTRWorldChunkManager extends WorldChunkManager {
	private World worldObj;
	private LOTRDimension lotrDimension;
	private LOTRGenLayer[] chunkGenLayers;
	private LOTRGenLayer[] worldLayers;
	private BiomeCache biomeCache;
	private static int LAYER_BIOME = 0;
	private static int LAYER_VARIANTS_LARGE = 1;
	private static int LAYER_VARIANTS_SMALL = 2;
	private static int LAYER_VARIANTS_LAKES = 3;
	private static int LAYER_VARIANTS_RIVERS = 4;
	private Map<LOTRVillageGen, LOTRVillagePositionCache> villageCacheMap = new HashMap();
	private Map<MapGenStructure, LOTRVillagePositionCache> structureCacheMap = new HashMap();

	public LOTRWorldChunkManager(World world, LOTRDimension dim) {
		this.worldObj = world;
		this.biomeCache = new BiomeCache(this);
		this.lotrDimension = dim;
		this.setupGenLayers();
	}

	private void setupGenLayers() {
		long seed = this.worldObj.getSeed() + 1954L;
		this.chunkGenLayers = LOTRGenLayerWorld.createWorld(this.lotrDimension, this.worldObj.getWorldInfo().getTerrainType());
		this.worldLayers = new LOTRGenLayer[this.chunkGenLayers.length];

		int i;
		for (i = 0; i < this.worldLayers.length; ++i) {
			LOTRGenLayer layer = this.chunkGenLayers[i];
			this.worldLayers[i] = new LOTRGenLayerZoomVoronoi(10L, layer);
		}

		for (i = 0; i < this.worldLayers.length; ++i) {
			this.chunkGenLayers[i].initWorldGenSeed(seed);
			this.worldLayers[i].initWorldGenSeed(seed);
		}

	}

	public BiomeGenBase getBiomeGenAt(int i, int k) {
		return this.biomeCache.getBiomeGenAt(i, k);
	}

	public float[] getRainfall(float[] rainfall, int i, int k, int xSize, int zSize) {
		LOTRIntCache.get(this.worldObj).resetIntCache();
		if (rainfall == null || rainfall.length < xSize * zSize) {
			rainfall = new float[xSize * zSize];
		}

		int[] ints = this.worldLayers[LAYER_BIOME].getInts(this.worldObj, i, k, xSize, zSize);

		for (int l = 0; l < xSize * zSize; ++l) {
			int biomeID = ints[l];
			float f = (float) this.lotrDimension.biomeList[biomeID].getIntRainfall() / 65536.0F;
			if (f > 1.0F) {
				f = 1.0F;
			}

			rainfall[l] = f;
		}

		return rainfall;
	}

	@SideOnly(Side.CLIENT)
	public float getTemperatureAtHeight(float f, int height) {
		return this.worldObj.isRemote && LOTRMod.isChristmas() ? 0.0F : f;
	}

	public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] biomes, int i, int k, int xSize, int zSize) {
		LOTRIntCache.get(this.worldObj).resetIntCache();
		if (biomes == null || biomes.length < xSize * zSize) {
			biomes = new BiomeGenBase[xSize * zSize];
		}

		int[] ints = this.chunkGenLayers[LAYER_BIOME].getInts(this.worldObj, i, k, xSize, zSize);

		for (int l = 0; l < xSize * zSize; ++l) {
			int biomeID = ints[l];
			biomes[l] = this.lotrDimension.biomeList[biomeID];
		}

		return biomes;
	}

	public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] biomes, int i, int k, int xSize, int zSize) {
		return this.getBiomeGenAt(biomes, i, k, xSize, zSize, true);
	}

	public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] biomes, int i, int k, int xSize, int zSize, boolean useCache) {
		LOTRIntCache.get(this.worldObj).resetIntCache();
		if (biomes == null || biomes.length < xSize * zSize) {
			biomes = new BiomeGenBase[xSize * zSize];
		}

		if (useCache && xSize == 16 && zSize == 16 && (i & 15) == 0 && (k & 15) == 0) {
			BiomeGenBase[] cachedBiomes = this.biomeCache.getCachedBiomes(i, k);
			System.arraycopy(cachedBiomes, 0, biomes, 0, xSize * zSize);
			return biomes;
		} else {
			int[] ints = this.worldLayers[LAYER_BIOME].getInts(this.worldObj, i, k, xSize, zSize);

			for (int l = 0; l < xSize * zSize; ++l) {
				int biomeID = ints[l];
				biomes[l] = this.lotrDimension.biomeList[biomeID];
			}

			return biomes;
		}
	}

	public LOTRBiomeVariant[] getVariantsChunkGen(LOTRBiomeVariant[] variants, int i, int k, int xSize, int zSize, BiomeGenBase[] biomeSource) {
		return this.getBiomeVariantsFromLayers(variants, i, k, xSize, zSize, biomeSource, true);
	}

	public LOTRBiomeVariant[] getBiomeVariants(LOTRBiomeVariant[] variants, int i, int k, int xSize, int zSize) {
		return this.getBiomeVariantsFromLayers(variants, i, k, xSize, zSize, (BiomeGenBase[]) null, false);
	}

	private LOTRBiomeVariant[] getBiomeVariantsFromLayers(LOTRBiomeVariant[] variants, int i, int k, int xSize, int zSize, BiomeGenBase[] biomeSource, boolean isChunkGeneration) {
		LOTRIntCache.get(this.worldObj).resetIntCache();
		BiomeGenBase[] biomes = new BiomeGenBase[xSize * zSize];
		if (biomeSource != null) {
			biomes = biomeSource;
		} else {
			for (int k1 = 0; k1 < zSize; ++k1) {
				for (int i1 = 0; i1 < xSize; ++i1) {
					int index = i1 + k1 * xSize;
					biomes[index] = this.worldObj.getBiomeGenForCoords(i + i1, k + k1);
				}
			}
		}

		if (variants == null || variants.length < xSize * zSize) {
			variants = new LOTRBiomeVariant[xSize * zSize];
		}

		LOTRGenLayer[] sourceGenLayers = isChunkGeneration ? this.chunkGenLayers : this.worldLayers;
		LOTRGenLayer variantsLarge = sourceGenLayers[LAYER_VARIANTS_LARGE];
		LOTRGenLayer variantsSmall = sourceGenLayers[LAYER_VARIANTS_SMALL];
		LOTRGenLayer variantsLakes = sourceGenLayers[LAYER_VARIANTS_LAKES];
		LOTRGenLayer variantsRivers = sourceGenLayers[LAYER_VARIANTS_RIVERS];
		int[] variantsLargeInts = variantsLarge.getInts(this.worldObj, i, k, xSize, zSize);
		int[] variantsSmallInts = variantsSmall.getInts(this.worldObj, i, k, xSize, zSize);
		int[] variantsLakesInts = variantsLakes.getInts(this.worldObj, i, k, xSize, zSize);
		int[] variantsRiversInts = variantsRivers.getInts(this.worldObj, i, k, xSize, zSize);

		for (int k1 = 0; k1 < zSize; ++k1) {
			for (int i1 = 0; i1 < xSize; ++i1) {
				int index = i1 + k1 * xSize;
				LOTRBiome biome = (LOTRBiome) biomes[index];
				LOTRBiomeVariant variant = LOTRBiomeVariant.STANDARD;
				int xPos = i + i1;
				int zPos = k + k1;
				if (isChunkGeneration) {
					xPos <<= 2;
					zPos <<= 2;
				}

				boolean[] flags = LOTRFixedStructures._mountainNear_structureNear(this.worldObj, xPos, zPos);
				boolean mountainNear = flags[0];
				boolean structureNear = flags[1];
				boolean fixedVillageNear = biome.decorator.anyFixedVillagesAt(this.worldObj, xPos, zPos);
				if (fixedVillageNear) {
					variant = BiomeVariantSteppe.INSTANCE;
				} else if (!mountainNear) {
					float variantChance = biome.variantChance;
					int lakeCode;
					if (variantChance > 0.0F) {
						for (lakeCode = 0; lakeCode <= 1; ++lakeCode) {
							LOTRBiomeVariantList variantList = lakeCode == 0 ? biome.getBiomeVariantsLarge() : biome.getBiomeVariantsSmall();
							if (!variantList.isEmpty()) {
								int[] sourceInts = lakeCode == 0 ? variantsLargeInts : variantsSmallInts;
								int variantCode = sourceInts[index];
								float variantF = (float) variantCode / (float) LOTRGenLayerBiomeVariants.RANDOM_MAX;
								if (variantF < variantChance) {
									float variantFNormalised = variantF / variantChance;
									variant = variantList.get(variantFNormalised);
									break;
								}

								variant = LOTRBiomeVariant.STANDARD;
							}
						}
					}

					if (!structureNear && biome.getEnableRiver()) {
						lakeCode = variantsLakesInts[index];
						if (LOTRGenLayerBiomeVariantsLake.getFlag(lakeCode, 1)) {
							variant = LOTRBiomeVariant.LAKE;
						}

						if (LOTRGenLayerBiomeVariantsLake.getFlag(lakeCode, 2) && biome instanceof LOTRBiomeGenFarHaradJungle && ((LOTRBiomeGenFarHaradJungle) biome).hasJungleLakes()) {
							variant = LOTRBiomeVariant.LAKE;
						}

						if (LOTRGenLayerBiomeVariantsLake.getFlag(lakeCode, 4) && biome instanceof LOTRBiomeGenFarHaradMangrove) {
							variant = LOTRBiomeVariant.LAKE;
						}
					}
				}

				int riverCode = variantsRiversInts[index];
				if (riverCode == 2) {
					variant = LOTRBiomeVariant.RIVER;
				} else if (riverCode == 1 && biome.getEnableRiver() && !structureNear && !mountainNear) {
					variant = LOTRBiomeVariant.RIVER;
				}

				variants[index] = variant;
			}
		}

		return variants;
	}

	public LOTRBiomeVariant getBiomeVariantAt(int i, int k) {
		Chunk chunk = this.worldObj.getChunkFromBlockCoords(i, k);
		if (chunk != null) {
			byte[] variants = LOTRBiomeVariantStorage.getChunkBiomeVariants(this.worldObj, chunk);
			if (variants != null) {
				if (variants.length == 256) {
					int chunkX = i & 15;
					int chunkZ = k & 15;
					byte variantID = variants[chunkX + chunkZ * 16];
					return LOTRBiomeVariant.getVariantForID(variantID);
				}

				FMLLog.severe("Found chunk biome variant array of unexpected length " + variants.length, new Object[0]);
			}
		}

		return !this.worldObj.isRemote ? this.getBiomeVariants((LOTRBiomeVariant[]) null, i, k, 1, 1)[0] : LOTRBiomeVariant.STANDARD;
	}

	public boolean areBiomesViable(int i, int k, int range, List list) {
		LOTRIntCache.get(this.worldObj).resetIntCache();
		int i1 = i - range >> 2;
		int k1 = k - range >> 2;
		int i2 = i + range >> 2;
		int k2 = k + range >> 2;
		int i3 = i2 - i1 + 1;
		int k3 = k2 - k1 + 1;
		int[] ints = this.chunkGenLayers[LAYER_BIOME].getInts(this.worldObj, i1, k1, i3, k3);

		for (int l = 0; l < i3 * k3; ++l) {
			BiomeGenBase biome = this.lotrDimension.biomeList[ints[l]];
			if (!list.contains(biome)) {
				return false;
			}
		}

		return true;
	}

	public boolean areVariantsSuitableVillage(int i, int k, int range, boolean requireFlat) {
		int i1 = i - range >> 2;
		int k1 = k - range >> 2;
		int i2 = i + range >> 2;
		int k2 = k + range >> 2;
		int i3 = i2 - i1 + 1;
		int k3 = k2 - k1 + 1;
		BiomeGenBase[] biomes = this.getBiomesForGeneration((BiomeGenBase[]) null, i1, k1, i3, k3);
		LOTRBiomeVariant[] variants = this.getVariantsChunkGen((LOTRBiomeVariant[]) null, i1, k1, i3, k3, biomes);
		LOTRBiomeVariant[] var13 = variants;
		int var14 = variants.length;

		for (int var15 = 0; var15 < var14; ++var15) {
			LOTRBiomeVariant v = var13[var15];
			if (v.hillFactor > 1.6F || requireFlat && v.hillFactor > 1.0F) {
				return false;
			}

			if (v.treeFactor > 1.0F) {
				return false;
			}

			if (v.disableVillages) {
				return false;
			}

			if (v.absoluteHeight && v.absoluteHeightLevel < 0.0F) {
				return false;
			}
		}

		return true;
	}

	public LOTRVillagePositionCache getVillageCache(LOTRVillageGen village) {
		LOTRVillagePositionCache cache = (LOTRVillagePositionCache) this.villageCacheMap.get(village);
		if (cache == null) {
			cache = new LOTRVillagePositionCache();
			this.villageCacheMap.put(village, cache);
		}

		return cache;
	}

	public LOTRVillagePositionCache getStructureCache(MapGenStructure structure) {
		LOTRVillagePositionCache cache = (LOTRVillagePositionCache) this.structureCacheMap.get(structure);
		if (cache == null) {
			cache = new LOTRVillagePositionCache();
			this.structureCacheMap.put(structure, cache);
		}

		return cache;
	}

	public ChunkPosition findBiomePosition(int i, int k, int range, List list, Random random) {
		LOTRIntCache.get(this.worldObj).resetIntCache();
		int i1 = i - range >> 2;
		int k1 = k - range >> 2;
		int i2 = i + range >> 2;
		int k2 = k + range >> 2;
		int i3 = i2 - i1 + 1;
		int k3 = k2 - k1 + 1;
		int[] ints = this.chunkGenLayers[LAYER_BIOME].getInts(this.worldObj, i1, k1, i3, k3);
		ChunkPosition chunkpos = null;
		int j = 0;

		for (int l = 0; l < i3 * k3; ++l) {
			int xPos = i1 + l % i3 << 2;
			int zPos = k1 + l / i3 << 2;
			BiomeGenBase biome = this.lotrDimension.biomeList[ints[l]];
			if (list.contains(biome) && (chunkpos == null || random.nextInt(j + 1) == 0)) {
				chunkpos = new ChunkPosition(xPos, 0, zPos);
				++j;
			}
		}

		return chunkpos;
	}

	public void cleanupCache() {
		this.biomeCache.cleanupCache();
	}
}
