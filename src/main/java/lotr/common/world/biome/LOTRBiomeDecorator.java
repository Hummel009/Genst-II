package lotr.common.world.biome;

import lotr.common.LOTRMod;
import lotr.common.world.LOTRChunkProvider;
import lotr.common.world.LOTRWorldChunkManager;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.LOTRRoads;
import lotr.common.world.structure.LOTRWorldGenMarshHut;
import lotr.common.world.structure.LOTRWorldGenOrcDungeon;
import lotr.common.world.structure.LOTRWorldGenStructureBase;
import lotr.common.world.structure2.LOTRWorldGenGrukHouse;
import lotr.common.world.structure2.LOTRWorldGenStructureBase2;
import lotr.common.world.structure2.LOTRWorldGenTicketBooth;
import lotr.common.world.village.LOTRVillageGen;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@SuppressWarnings("all")
public class LOTRBiomeDecorator {
	private World worldObj;
	private Random rand;
	private int chunkX;
	private int chunkZ;
	private LOTRBiome biome;
	private List<OreGenerant> biomeSoils = new ArrayList();
	private List<OreGenerant> biomeOres = new ArrayList();
	private List<OreGenerant> biomeGems = new ArrayList();
	public float biomeOreFactor = 1.0F;
	public float biomeGemFactor = 0.5F;
	protected WorldGenerator clayGen;
	private WorldGenerator sandGen;
	private WorldGenerator whiteSandGen;
	private WorldGenerator quagmireGen;
	private WorldGenerator surfaceGravelGen;
	private WorldGenerator flowerGen;
	private WorldGenerator logGen;
	private WorldGenerator mushroomBrownGen;
	private WorldGenerator mushroomRedGen;
	private WorldGenerator caneGen;
	private WorldGenerator reedGen;
	private WorldGenerator dryReedGen;
	private WorldGenerator cornGen;
	private WorldGenerator pumpkinGen;
	private WorldGenerator waterlilyGen;
	private WorldGenerator cobwebGen;
	private WorldGenerator stalactiteGen;
	private WorldGenerator vinesGen;
	private WorldGenerator cactusGen;
	private WorldGenerator melonGen;
	public int sandPerChunk;
	public int clayPerChunk;
	public int quagmirePerChunk;
	public int treesPerChunk;
	public int willowPerChunk;
	public int logsPerChunk;
	public int vinesPerChunk;
	public int flowersPerChunk;
	public int doubleFlowersPerChunk;
	public int grassPerChunk;
	public int doubleGrassPerChunk;
	public boolean enableFern;
	public boolean enableSpecialGrasses;
	public int deadBushPerChunk;
	public int waterlilyPerChunk;
	public int mushroomsPerChunk;
	public boolean enableRandomMushroom;
	public int canePerChunk;
	public int reedPerChunk;
	public float dryReedChance;
	public int cornPerChunk;
	public int cactiPerChunk;
	public float melonPerChunk;
	public boolean generateWater;
	public boolean generateLava;
	public boolean generateCobwebs;
	public boolean generateAthelas;
	public boolean whiteSand;
	private int treeClusterSize;
	private int treeClusterChance;
	private WorldGenerator orcDungeonGen;
	private WorldGenerator trollHoardGen;
	public boolean generateOrcDungeon;
	public boolean generateTrollHoard;
	private List<LOTRTreeType.WeightedTreeType> treeTypes;
	private Random structureRand;
	private List<RandomStructure> randomStructures;
	private List<LOTRVillageGen> villages;

	public void addSoil(WorldGenerator gen, float f, int min, int max) {
		this.biomeSoils.add(new OreGenerant(gen, f, min, max));
	}

	public void addOre(WorldGenerator gen, float f, int min, int max) {
		this.biomeOres.add(new OreGenerant(gen, f, min, max));
	}

	public void addGem(WorldGenerator gen, float f, int min, int max) {
		this.biomeGems.add(new OreGenerant(gen, f, min, max));
	}

	public void clearOres() {
		this.biomeSoils.clear();
		this.biomeOres.clear();
		this.biomeGems.clear();
	}

	private void addDefaultOres() {
		this.addSoil(new WorldGenMinable(Blocks.dirt, 32), 40.0F, 0, 256);
		this.addSoil(new WorldGenMinable(Blocks.gravel, 32), 20.0F, 0, 256);
		this.addOre(new WorldGenMinable(Blocks.coal_ore, 16), 40.0F, 0, 128);
		this.addOre(new WorldGenMinable(LOTRMod.oreCopper, 8), 16.0F, 0, 128);
		this.addOre(new WorldGenMinable(LOTRMod.oreTin, 8), 16.0F, 0, 128);
		this.addOre(new WorldGenMinable(Blocks.iron_ore, 8), 20.0F, 0, 64);
		this.addOre(new WorldGenMinable(LOTRMod.oreSulfur, 8), 2.0F, 0, 64);
		this.addOre(new WorldGenMinable(LOTRMod.oreSaltpeter, 8), 2.0F, 0, 64);
		this.addOre(new WorldGenMinable(LOTRMod.oreSalt, 12), 2.0F, 0, 64);
		this.addOre(new WorldGenMinable(Blocks.gold_ore, 8), 2.0F, 0, 32);
		this.addOre(new WorldGenMinable(LOTRMod.oreSilver, 8), 3.0F, 0, 32);
		this.addGem(new WorldGenMinable(LOTRMod.oreGem, 1, 6, Blocks.stone), 2.0F, 0, 64);
		this.addGem(new WorldGenMinable(LOTRMod.oreGem, 0, 6, Blocks.stone), 2.0F, 0, 64);
		this.addGem(new WorldGenMinable(LOTRMod.oreGem, 4, 5, Blocks.stone), 1.5F, 0, 48);
		this.addGem(new WorldGenMinable(LOTRMod.oreGem, 6, 5, Blocks.stone), 1.5F, 0, 48);
		this.addGem(new WorldGenMinable(LOTRMod.oreGem, 2, 4, Blocks.stone), 1.0F, 0, 32);
		this.addGem(new WorldGenMinable(LOTRMod.oreGem, 3, 4, Blocks.stone), 1.0F, 0, 32);
		this.addGem(new WorldGenMinable(LOTRMod.oreGem, 7, 4, Blocks.stone), 0.75F, 0, 24);
		this.addGem(new WorldGenMinable(LOTRMod.oreGem, 5, 4, Blocks.stone), 0.5F, 0, 16);
	}

	public LOTRBiomeDecorator(LOTRBiome lotrbiome) {
		this.clayGen = new LOTRWorldGenSand(Blocks.clay, 5, 1);
		this.sandGen = new LOTRWorldGenSand(Blocks.sand, 7, 2);
		this.whiteSandGen = new LOTRWorldGenSand(LOTRMod.whiteSand, 7, 2);
		this.quagmireGen = new LOTRWorldGenSand(LOTRMod.quagmire, 7, 2);
		this.surfaceGravelGen = new LOTRWorldGenSurfaceGravel();
		this.flowerGen = new LOTRWorldGenBiomeFlowers();
		this.logGen = new LOTRWorldGenLogs();
		this.mushroomBrownGen = new WorldGenFlowers(Blocks.brown_mushroom);
		this.mushroomRedGen = new WorldGenFlowers(Blocks.red_mushroom);
		this.caneGen = new WorldGenReed();
		this.reedGen = new LOTRWorldGenReeds(LOTRMod.reeds);
		this.dryReedGen = new LOTRWorldGenReeds(LOTRMod.driedReeds);
		this.cornGen = new LOTRWorldGenCorn();
		this.pumpkinGen = new WorldGenPumpkin();
		this.waterlilyGen = new WorldGenWaterlily();
		this.cobwebGen = new LOTRWorldGenCaveCobwebs();
		this.stalactiteGen = new LOTRWorldGenStalactites();
		this.vinesGen = new WorldGenVines();
		this.cactusGen = new WorldGenCactus();
		this.melonGen = new WorldGenMelon();
		this.sandPerChunk = 4;
		this.clayPerChunk = 3;
		this.quagmirePerChunk = 0;
		this.treesPerChunk = 0;
		this.willowPerChunk = 0;
		this.logsPerChunk = 0;
		this.vinesPerChunk = 0;
		this.flowersPerChunk = 2;
		this.doubleFlowersPerChunk = 0;
		this.grassPerChunk = 1;
		this.doubleGrassPerChunk = 0;
		this.enableFern = false;
		this.enableSpecialGrasses = true;
		this.deadBushPerChunk = 0;
		this.waterlilyPerChunk = 0;
		this.mushroomsPerChunk = 0;
		this.enableRandomMushroom = true;
		this.canePerChunk = 0;
		this.reedPerChunk = 1;
		this.dryReedChance = 0.1F;
		this.cornPerChunk = 0;
		this.cactiPerChunk = 0;
		this.melonPerChunk = 0.0F;
		this.generateWater = true;
		this.generateLava = true;
		this.generateCobwebs = true;
		this.generateAthelas = false;
		this.whiteSand = false;
		this.treeClusterChance = -1;
		this.orcDungeonGen = new LOTRWorldGenOrcDungeon(false);
		this.trollHoardGen = new LOTRWorldGenTrollHoard();
		this.generateOrcDungeon = false;
		this.generateTrollHoard = false;
		this.treeTypes = new ArrayList();
		this.structureRand = new Random();
		this.randomStructures = new ArrayList();
		this.villages = new ArrayList();
		this.biome = lotrbiome;
		this.addDefaultOres();
	}

	public void addTree(LOTRTreeType type, int weight) {
		this.treeTypes.add(new LOTRTreeType.WeightedTreeType(type, weight));
	}

	public void clearTrees() {
		this.treeTypes.clear();
	}

	public LOTRTreeType getRandomTree(Random random) {
		if (this.treeTypes.isEmpty()) {
			return LOTRTreeType.OAK;
		} else {
			WeightedRandom.Item item = WeightedRandom.getRandomItem(random, this.treeTypes);
			return ((LOTRTreeType.WeightedTreeType) item).treeType;
		}
	}

	public LOTRTreeType getRandomTreeForVariant(Random random, LOTRBiomeVariant variant) {
		if (variant.treeTypes.isEmpty()) {
			return this.getRandomTree(random);
		} else {
			float f = variant.variantTreeChance;
			return random.nextFloat() < f ? variant.getRandomTree(random) : this.getRandomTree(random);
		}
	}

	public void genTree(World world, Random random, int i, int j, int k) {
		WorldGenerator treeGen = this.biome.getTreeGen(world, random, i, j, k);
		treeGen.generate(world, random, i, j, k);
	}

	public void setTreeCluster(int size, int chance) {
		this.treeClusterSize = size;
		this.treeClusterChance = chance;
	}

	public void resetTreeCluster() {
		this.setTreeCluster(0, -1);
	}

	public void addRandomStructure(WorldGenerator structure, int chunkChance) {
		this.randomStructures.add(new RandomStructure(structure, chunkChance));
	}

	public void clearRandomStructures() {
		this.randomStructures.clear();
	}

	public void addVillage(LOTRVillageGen village) {
		this.villages.add(village);
	}

	public void clearVillages() {
		this.villages.clear();
	}

	public void checkForVillages(World world, int i, int k, LOTRChunkProvider.ChunkFlags chunkFlags) {
		chunkFlags.isVillage = false;
		chunkFlags.isFlatVillage = false;
		Iterator var5 = this.villages.iterator();

		while (true) {
			List instances;
			do {
				if (!var5.hasNext()) {
					return;
				}

				LOTRVillageGen village = (LOTRVillageGen) var5.next();
				instances = village.getNearbyVillagesAtPosition(world, i, k);
			} while (instances.isEmpty());

			chunkFlags.isVillage = true;
			Iterator var8 = instances.iterator();

			while (var8.hasNext()) {
				LOTRVillageGen.AbstractInstance<?> inst = (LOTRVillageGen.AbstractInstance) var8.next();
				if (inst.isFlat()) {
					chunkFlags.isFlatVillage = true;
				}
			}
		}
	}

	public boolean anyFixedVillagesAt(World world, int i, int k) {
		Iterator var4 = this.villages.iterator();

		LOTRVillageGen village;
		do {
			if (!var4.hasNext()) {
				return false;
			}

			village = (LOTRVillageGen) var4.next();
		} while (!village.anyFixedVillagesAt(world, i, k));

		return true;
	}

	public int getVariantTreesPerChunk(LOTRBiomeVariant variant) {
		int trees = this.treesPerChunk;
		if (variant.treeFactor > 1.0F) {
			trees = Math.max(trees, 1);
		}

		trees = Math.round((float) trees * variant.treeFactor);
		return trees;
	}

	public void decorate(World world, Random random, int i, int k) {
		this.worldObj = world;
		this.rand = random;
		this.chunkX = i;
		this.chunkZ = k;
		this.decorate();
	}

	private void decorate() {
		LOTRBiomeVariant biomeVariant = ((LOTRWorldChunkManager) this.worldObj.getWorldChunkManager()).getBiomeVariantAt(this.chunkX + 8, this.chunkZ + 8);
		this.generateOres();
		biomeVariant.decorateVariant(this.worldObj, this.rand, this.chunkX, this.chunkZ, this.biome);
		int trees;
		int k;
		int cluster;
		if (this.rand.nextBoolean() && this.generateCobwebs) {
			trees = this.chunkX + this.rand.nextInt(16) + 8;
			k = this.rand.nextInt(60);
			cluster = this.chunkZ + this.rand.nextInt(16) + 8;
			this.cobwebGen.generate(this.worldObj, this.rand, trees, k, cluster);
		}

		int flowers;
		for (trees = 0; trees < 3; ++trees) {
			k = this.chunkX + this.rand.nextInt(16) + 8;
			cluster = this.rand.nextInt(60);
			flowers = this.chunkZ + this.rand.nextInt(16) + 8;
			this.stalactiteGen.generate(this.worldObj, this.rand, k, cluster, flowers);
		}

		for (trees = 0; trees < this.quagmirePerChunk; ++trees) {
			k = this.chunkX + this.rand.nextInt(16) + 8;
			cluster = this.chunkZ + this.rand.nextInt(16) + 8;
			this.quagmireGen.generate(this.worldObj, this.rand, k, this.worldObj.getTopSolidOrLiquidBlock(k, cluster), cluster);
		}

		for (trees = 0; trees < this.sandPerChunk; ++trees) {
			k = this.chunkX + this.rand.nextInt(16) + 8;
			cluster = this.chunkZ + this.rand.nextInt(16) + 8;
			WorldGenerator biomeSandGenerator = this.sandGen;
			if (this.whiteSand) {
				biomeSandGenerator = this.whiteSandGen;
			}

			biomeSandGenerator.generate(this.worldObj, this.rand, k, this.worldObj.getTopSolidOrLiquidBlock(k, cluster), cluster);
		}

		for (trees = 0; trees < this.clayPerChunk; ++trees) {
			k = this.chunkX + this.rand.nextInt(16) + 8;
			cluster = this.chunkZ + this.rand.nextInt(16) + 8;
			this.clayGen.generate(this.worldObj, this.rand, k, this.worldObj.getTopSolidOrLiquidBlock(k, cluster), cluster);
		}

		if (this.rand.nextInt(60) == 0) {
			trees = this.chunkX + this.rand.nextInt(16) + 8;
			k = this.chunkZ + this.rand.nextInt(16) + 8;
			this.surfaceGravelGen.generate(this.worldObj, this.rand, trees, 0, k);
		}

		int grasses;
		int doubleGrasses;
		int boulders;
		if (!biomeVariant.disableStructures && Math.abs(this.chunkX) > 32 && Math.abs(this.chunkZ) > 32) {
			long seed = (long) (this.chunkX * 1879267) ^ (long) this.chunkZ * 67209689L;
			seed = seed * seed * 5829687L + seed * 2876L;
			this.structureRand.setSeed(seed);
			boolean roadNear = LOTRRoads.isRoadNear(this.chunkX + 8, this.chunkZ + 8, 16) >= 0.0F;
			Iterator var19;
			if (!roadNear && !anyFixedVillagesAt(worldObj, chunkX, chunkZ)) {
				var19 = this.randomStructures.iterator();

				while (var19.hasNext()) {
					RandomStructure randomstructure = (RandomStructure) var19.next();
					if (this.structureRand.nextInt(randomstructure.chunkChance) == 0) {
						grasses = this.chunkX + this.rand.nextInt(16) + 8;
						doubleGrasses = this.chunkZ + this.rand.nextInt(16) + 8;
						boulders = this.worldObj.getTopSolidOrLiquidBlock(grasses, doubleGrasses);
						randomstructure.structureGen.generate(this.worldObj, this.rand, grasses, boulders, doubleGrasses);
					}
				}
			}

			var19 = this.villages.iterator();

			while (var19.hasNext()) {
				LOTRVillageGen village = (LOTRVillageGen) var19.next();
				village.generateInChunk(this.worldObj, this.chunkX, this.chunkZ);
			}
		}

		if (LOTRWorldGenMarshHut.generatesAt(this.worldObj, this.chunkX, this.chunkZ)) {
			trees = this.chunkX + 8;
			k = this.chunkZ + 8;
			cluster = this.worldObj.getTopSolidOrLiquidBlock(trees, k);
			LOTRWorldGenStructureBase house = new LOTRWorldGenMarshHut();
			house.restrictions = false;
			house.generate(this.worldObj, this.rand, trees, cluster, k);
		}

		if (LOTRWorldGenGrukHouse.generatesAt(this.worldObj, this.chunkX, this.chunkZ)) {
			trees = this.chunkX + 8;
			k = this.chunkZ + 8;
			cluster = this.worldObj.getTopSolidOrLiquidBlock(trees, k);
			LOTRWorldGenStructureBase2 house = new LOTRWorldGenGrukHouse(false);
			house.restrictions = false;
			house.generateWithSetRotation(this.worldObj, this.rand, trees, cluster, k, 2);
		}

		if (LOTRWorldGenTicketBooth.generatesAt(this.worldObj, this.chunkX, this.chunkZ)) {
			trees = this.chunkX + 8;
			k = this.chunkZ + 8;
			cluster = this.worldObj.getTopSolidOrLiquidBlock(trees, k);
			LOTRWorldGenStructureBase2 booth = new LOTRWorldGenTicketBooth(false);
			booth.restrictions = false;
			booth.generateWithSetRotation(this.worldObj, this.rand, trees, cluster, k, 3);
		}

		trees = this.getVariantTreesPerChunk(biomeVariant);
		if (this.rand.nextFloat() < this.biome.getTreeIncreaseChance() * biomeVariant.treeFactor) {
			++trees;
		}

		float reciprocalTreeFactor = 1.0F / Math.max(biomeVariant.treeFactor, 0.001F);
		cluster = Math.round((float) this.treeClusterChance * reciprocalTreeFactor);
		if (cluster > 0) {
			Random chunkRand = new Random();
			long seed = (long) (this.chunkX / this.treeClusterSize * 3129871) ^ (long) (this.chunkZ / this.treeClusterSize) * 116129781L;
			seed = seed * seed * 42317861L + seed * 11L;
			chunkRand.setSeed(seed);
			if (chunkRand.nextInt(cluster) == 0) {
				trees += 6 + this.rand.nextInt(5);
			}
		}

		int doubleFlowers;
		WorldGenAbstractTree treeGen;
		for (flowers = 0; flowers < trees; ++flowers) {
			doubleFlowers = this.chunkX + this.rand.nextInt(16) + 8;
			grasses = this.chunkZ + this.rand.nextInt(16) + 8;
			treeGen = this.getRandomTreeForVariant(this.rand, biomeVariant).create(false, this.rand);
			treeGen.generate(this.worldObj, this.rand, doubleFlowers, this.worldObj.getHeightValue(doubleFlowers, grasses), grasses);
		}

		for (flowers = 0; flowers < this.willowPerChunk; ++flowers) {
			doubleFlowers = this.chunkX + this.rand.nextInt(16) + 8;
			grasses = this.chunkZ + this.rand.nextInt(16) + 8;
			treeGen = LOTRTreeType.WILLOW_WATER.create(false, this.rand);
			treeGen.generate(this.worldObj, this.rand, doubleFlowers, this.worldObj.getHeightValue(doubleFlowers, grasses), grasses);
		}

		int l;
		float bushesR;
		float bushes;
		if (trees > 0) {
			bushes = (float) trees / 2.0F;
			doubleFlowers = (int) bushes;
			bushesR = bushes - (float) doubleFlowers;
			if (this.rand.nextFloat() < bushesR) {
				++doubleFlowers;
			}

			for (doubleGrasses = 0; (float) doubleGrasses < bushes; ++doubleGrasses) {
				boulders = this.chunkX + this.rand.nextInt(16) + 8;
				l = this.chunkZ + this.rand.nextInt(16) + 8;
				(new LOTRWorldGenFallenLeaves()).generate(this.worldObj, this.rand, boulders, this.worldObj.getTopSolidOrLiquidBlock(boulders, l), l);
			}
		}

		if (trees > 0) {
			bushes = (float) trees / 3.0F;
			doubleFlowers = (int) bushes;
			bushesR = bushes - (float) doubleFlowers;
			if (this.rand.nextFloat() < bushesR) {
				++doubleFlowers;
			}

			for (doubleGrasses = 0; (float) doubleGrasses < bushes; ++doubleGrasses) {
				boulders = this.chunkX + this.rand.nextInt(16) + 8;
				l = this.chunkZ + this.rand.nextInt(16) + 8;
				(new LOTRWorldGenBushes()).generate(this.worldObj, this.rand, boulders, this.worldObj.getTopSolidOrLiquidBlock(boulders, l), l);
			}
		}

		for (flowers = 0; flowers < this.logsPerChunk; ++flowers) {
			doubleFlowers = this.chunkX + this.rand.nextInt(16) + 8;
			grasses = this.chunkZ + this.rand.nextInt(16) + 8;
			this.logGen.generate(this.worldObj, this.rand, doubleFlowers, this.worldObj.getHeightValue(doubleFlowers, grasses), grasses);
		}

		for (flowers = 0; flowers < this.vinesPerChunk; ++flowers) {
			doubleFlowers = this.chunkX + this.rand.nextInt(16) + 8;
			int j = 64;
			doubleGrasses = this.chunkZ + this.rand.nextInt(16) + 8;
			this.vinesGen.generate(this.worldObj, this.rand, doubleFlowers, j, doubleGrasses);
		}

		flowers = this.flowersPerChunk;
		flowers = Math.round((float) flowers * biomeVariant.flowerFactor);

		for (doubleFlowers = 0; doubleFlowers < flowers; ++doubleFlowers) {
			grasses = this.chunkX + this.rand.nextInt(16) + 8;
			doubleGrasses = this.rand.nextInt(128);
			boulders = this.chunkZ + this.rand.nextInt(16) + 8;
			this.flowerGen.generate(this.worldObj, this.rand, grasses, doubleGrasses, boulders);
		}

		doubleFlowers = this.doubleFlowersPerChunk;
		doubleFlowers = Math.round((float) doubleFlowers * biomeVariant.flowerFactor);

		for (grasses = 0; grasses < doubleFlowers; ++grasses) {
			doubleGrasses = this.chunkX + this.rand.nextInt(16) + 8;
			boulders = this.rand.nextInt(128);
			l = this.chunkZ + this.rand.nextInt(16) + 8;
			WorldGenerator doubleFlowerGen = this.biome.getRandomWorldGenForDoubleFlower(this.rand);
			doubleFlowerGen.generate(this.worldObj, this.rand, doubleGrasses, boulders, l);
		}

		grasses = this.grassPerChunk;
		grasses = Math.round((float) grasses * biomeVariant.grassFactor);

		int i;
		for (doubleGrasses = 0; doubleGrasses < grasses; ++doubleGrasses) {
			boulders = this.chunkX + this.rand.nextInt(16) + 8;
			l = this.rand.nextInt(128);
			i = this.chunkZ + this.rand.nextInt(16) + 8;
			WorldGenerator grassGen = this.biome.getRandomWorldGenForGrass(this.rand);
			grassGen.generate(this.worldObj, this.rand, boulders, l, i);
		}

		doubleGrasses = this.doubleGrassPerChunk;
		doubleGrasses = Math.round((float) doubleGrasses * biomeVariant.grassFactor);

		int k1;
		for (boulders = 0; boulders < doubleGrasses; ++boulders) {
			l = this.chunkX + this.rand.nextInt(16) + 8;
			i = this.rand.nextInt(128);
			k1 = this.chunkZ + this.rand.nextInt(16) + 8;
			WorldGenerator grassGen = this.biome.getRandomWorldGenForDoubleGrass(this.rand);
			grassGen.generate(this.worldObj, this.rand, l, i, k1);
		}

		for (boulders = 0; boulders < this.deadBushPerChunk; ++boulders) {
			l = this.chunkX + this.rand.nextInt(16) + 8;
			i = this.rand.nextInt(128);
			k1 = this.chunkZ + this.rand.nextInt(16) + 8;
			(new WorldGenDeadBush(Blocks.deadbush)).generate(this.worldObj, this.rand, l, i, k1);
		}

		for (boulders = 0; boulders < this.waterlilyPerChunk; ++boulders) {
			l = this.chunkX + this.rand.nextInt(16) + 8;
			i = this.chunkZ + this.rand.nextInt(16) + 8;

			for (k1 = this.rand.nextInt(128); k1 > 0 && this.worldObj.getBlock(l, k1 - 1, i) == Blocks.air; --k1) {
			}

			this.waterlilyGen.generate(this.worldObj, this.rand, l, k1, i);
		}

		for (boulders = 0; boulders < this.mushroomsPerChunk; ++boulders) {
			if (this.rand.nextInt(4) == 0) {
				l = this.chunkX + this.rand.nextInt(16) + 8;
				i = this.chunkZ + this.rand.nextInt(16) + 8;
				k1 = this.worldObj.getHeightValue(l, i);
				this.mushroomBrownGen.generate(this.worldObj, this.rand, l, k1, i);
			}

			if (this.rand.nextInt(8) == 0) {
				l = this.chunkX + this.rand.nextInt(16) + 8;
				i = this.chunkZ + this.rand.nextInt(16) + 8;
				k1 = this.worldObj.getHeightValue(l, i);
				this.mushroomRedGen.generate(this.worldObj, this.rand, l, k1, i);
			}
		}

		if (this.enableRandomMushroom) {
			if (this.rand.nextInt(4) == 0) {
				boulders = this.chunkX + this.rand.nextInt(16) + 8;
				l = this.rand.nextInt(128);
				i = this.chunkZ + this.rand.nextInt(16) + 8;
				this.mushroomBrownGen.generate(this.worldObj, this.rand, boulders, l, i);
			}

			if (this.rand.nextInt(8) == 0) {
				boulders = this.chunkX + this.rand.nextInt(16) + 8;
				l = this.rand.nextInt(128);
				i = this.chunkZ + this.rand.nextInt(16) + 8;
				this.mushroomRedGen.generate(this.worldObj, this.rand, boulders, l, i);
			}
		}

		for (boulders = 0; boulders < this.canePerChunk; ++boulders) {
			l = this.chunkX + this.rand.nextInt(16) + 8;
			i = this.rand.nextInt(128);
			k1 = this.chunkZ + this.rand.nextInt(16) + 8;
			this.caneGen.generate(this.worldObj, this.rand, l, i, k1);
		}

		for (boulders = 0; boulders < 10; ++boulders) {
			l = this.chunkX + this.rand.nextInt(16) + 8;
			i = this.rand.nextInt(128);
			k1 = this.chunkZ + this.rand.nextInt(16) + 8;
			this.caneGen.generate(this.worldObj, this.rand, l, i, k1);
		}

		for (boulders = 0; boulders < this.reedPerChunk; ++boulders) {
			l = this.chunkX + this.rand.nextInt(16) + 8;
			i = this.chunkZ + this.rand.nextInt(16) + 8;

			for (k1 = this.rand.nextInt(128); k1 > 0 && this.worldObj.getBlock(l, k1 - 1, i) == Blocks.air; --k1) {
			}

			if (this.rand.nextFloat() < this.dryReedChance) {
				this.dryReedGen.generate(this.worldObj, this.rand, l, k1, i);
			} else {
				this.reedGen.generate(this.worldObj, this.rand, l, k1, i);
			}
		}

		for (boulders = 0; boulders < this.cornPerChunk; ++boulders) {
			l = this.chunkX + this.rand.nextInt(16) + 8;
			i = this.rand.nextInt(128);
			k1 = this.chunkZ + this.rand.nextInt(16) + 8;
			this.cornGen.generate(this.worldObj, this.rand, l, i, k1);
		}

		for (boulders = 0; boulders < this.cactiPerChunk; ++boulders) {
			l = this.chunkX + this.rand.nextInt(16) + 8;
			i = this.rand.nextInt(128);
			k1 = this.chunkZ + this.rand.nextInt(16) + 8;
			this.cactusGen.generate(this.worldObj, this.rand, l, i, k1);
		}

		int k3;
		if (this.melonPerChunk > 0.0F) {
			boulders = MathHelper.floor_double((double) this.melonPerChunk);
			float melonF = this.melonPerChunk - (float) boulders;

			for (i = 0; i < boulders; ++i) {
				k3 = this.chunkX + this.rand.nextInt(16) + 8;
				k3 = this.chunkZ + this.rand.nextInt(16) + 8;
				k3 = this.worldObj.getHeightValue(k3, k3);
				this.melonGen.generate(this.worldObj, this.rand, k3, k3, k3);
			}

			if (this.rand.nextFloat() < melonF) {
				i = this.chunkX + this.rand.nextInt(16) + 8;
				k3 = this.chunkZ + this.rand.nextInt(16) + 8;
				k3 = this.worldObj.getHeightValue(i, k3);
				this.melonGen.generate(this.worldObj, this.rand, i, k3, k3);
			}
		}

		if (this.flowersPerChunk > 0 && this.rand.nextInt(32) == 0) {
			boulders = this.chunkX + this.rand.nextInt(16) + 8;
			l = this.rand.nextInt(128);
			i = this.chunkZ + this.rand.nextInt(16) + 8;
			this.pumpkinGen.generate(this.worldObj, this.rand, boulders, l, i);
		}

		if (this.flowersPerChunk > 0 && this.rand.nextInt(4) == 0) {
			boulders = this.chunkX + this.rand.nextInt(16) + 8;
			l = this.rand.nextInt(128);
			i = this.chunkZ + this.rand.nextInt(16) + 8;
			(new LOTRWorldGenBerryBush()).generate(this.worldObj, this.rand, boulders, l, i);
		}

		if (this.generateAthelas && this.rand.nextInt(30) == 0) {
			boulders = this.chunkX + this.rand.nextInt(16) + 8;
			l = this.rand.nextInt(128);
			i = this.chunkZ + this.rand.nextInt(16) + 8;
			(new WorldGenFlowers(LOTRMod.athelas)).generate(this.worldObj, this.rand, boulders, l, i);
		}

		LOTRWorldGenStreams waterGen;
		if (this.generateWater) {
			waterGen = new LOTRWorldGenStreams(Blocks.flowing_water);

			for (l = 0; l < 50; ++l) {
				i = this.chunkX + this.rand.nextInt(16) + 8;
				k3 = this.rand.nextInt(this.rand.nextInt(120) + 8);
				k3 = this.chunkZ + this.rand.nextInt(16) + 8;
				waterGen.generate(this.worldObj, this.rand, i, k3, k3);
			}

			if (this.biome.rootHeight > 1.0F) {
				for (l = 0; l < 50; ++l) {
					i = this.chunkX + this.rand.nextInt(16) + 8;
					k3 = 100 + this.rand.nextInt(150);
					k3 = this.chunkZ + this.rand.nextInt(16) + 8;
					waterGen.generate(this.worldObj, this.rand, i, k3, k3);
				}
			}
		}

		if (this.generateLava) {
			waterGen = new LOTRWorldGenStreams(Blocks.flowing_lava);
			int lava = 20;
			if (this.biome instanceof LOTRBiomeGenMordor) {
				lava = 50;
			}

			for (i = 0; i < lava; ++i) {
				k3 = this.chunkX + this.rand.nextInt(16) + 8;
				k3 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(112) + 8) + 8);
				k3 = this.chunkZ + this.rand.nextInt(16) + 8;
				waterGen.generate(this.worldObj, this.rand, k3, k3, k3);
			}
		}

		if (this.generateOrcDungeon) {
			for (boulders = 0; boulders < 6; ++boulders) {
				l = this.chunkX + this.rand.nextInt(16) + 8;
				i = this.rand.nextInt(128);
				k3 = this.chunkZ + this.rand.nextInt(16) + 8;
				this.orcDungeonGen.generate(this.worldObj, this.rand, l, i, k3);
			}
		}

		if (this.generateTrollHoard) {
			for (boulders = 0; boulders < 2; ++boulders) {
				l = this.chunkX + this.rand.nextInt(16) + 8;
				i = MathHelper.getRandomIntegerInRange(this.rand, 36, 90);
				k3 = this.chunkZ + this.rand.nextInt(16) + 8;
				this.trollHoardGen.generate(this.worldObj, this.rand, l, i, k3);
			}
		}

		if (biomeVariant.boulderGen != null && this.rand.nextInt(biomeVariant.boulderChance) == 0) {
			boulders = MathHelper.getRandomIntegerInRange(this.rand, 1, biomeVariant.boulderMax);

			for (l = 0; l < boulders; ++l) {
				i = this.chunkX + this.rand.nextInt(16) + 8;
				k3 = this.chunkZ + this.rand.nextInt(16) + 8;
				biomeVariant.boulderGen.generate(this.worldObj, this.rand, i, this.worldObj.getHeightValue(i, k3), k3);
			}
		}

	}

	private void generateOres() {
		Iterator var1 = this.biomeSoils.iterator();

		OreGenerant gem;
		while (var1.hasNext()) {
			gem = (OreGenerant) var1.next();
			this.genStandardOre(gem.oreChance, gem.oreGen, gem.minHeight, gem.maxHeight);
		}

		var1 = this.biomeOres.iterator();

		float f;
		while (var1.hasNext()) {
			gem = (OreGenerant) var1.next();
			f = gem.oreChance * this.biomeOreFactor;
			this.genStandardOre(f, gem.oreGen, gem.minHeight, gem.maxHeight);
		}

		var1 = this.biomeGems.iterator();

		while (var1.hasNext()) {
			gem = (OreGenerant) var1.next();
			f = gem.oreChance * this.biomeGemFactor;
			this.genStandardOre(f, gem.oreGen, gem.minHeight, gem.maxHeight);
		}

	}

	private void genStandardOre(float ores, WorldGenerator oreGen, int minHeight, int maxHeight) {
		while (ores > 0.0F) {
			boolean generate;
			if (ores >= 1.0F) {
				generate = true;
			} else {
				generate = this.rand.nextFloat() < ores;
			}

			--ores;
			if (generate) {
				int i = this.chunkX + this.rand.nextInt(16);
				int j = MathHelper.getRandomIntegerInRange(this.rand, minHeight, maxHeight);
				int k = this.chunkZ + this.rand.nextInt(16);
				oreGen.generate(this.worldObj, this.rand, i, j, k);
			}
		}

	}

	private class RandomStructure {
		public WorldGenerator structureGen;
		public int chunkChance;

		public RandomStructure(WorldGenerator w, int i) {
			this.structureGen = w;
			this.chunkChance = i;
		}
	}

	private class OreGenerant {
		private WorldGenerator oreGen;
		private float oreChance;
		private int minHeight;
		private int maxHeight;

		public OreGenerant(WorldGenerator gen, float f, int min, int max) {
			this.oreGen = gen;
			this.oreChance = f;
			this.minHeight = min;
			this.maxHeight = max;
		}
	}
}
