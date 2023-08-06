package genst.instance

import lotr.common.LOTRFoods
import lotr.common.LOTRMod
import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityRivendellLord
import lotr.common.entity.npc.LOTREntityRivendellWarrior
import lotr.common.item.LOTRItemBanner
import lotr.common.world.structure2.LOTRWorldGenStructureBase2
import net.minecraft.block.Block
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs

class StructureRivendellTower(flag: Boolean) : LOTRWorldGenStructureBase2(flag) {
	private var brickBlock: Block = LOTRMod.brick3
	private var brickMeta = 2
	private var brickSlabBlock: Block = LOTRMod.slabSingle5
	private var brickSlabMeta = 5
	private var brickStairBlock: Block = LOTRMod.stairsHighElvenBrick
	private var brickWallBlock: Block = LOTRMod.wall2
	private var brickWallMeta: Int = 11
	private var pillarBlock: Block = LOTRMod.pillar
	private var pillarMeta: Int = 10
	private var floorBlock: Block = Blocks.double_stone_slab
	private var floorMeta: Int = 0
	private var roofBlock: Block = LOTRMod.clayTileDyed
	private var roofMeta: Int = 3
	private var roofSlabBlock: Block = LOTRMod.slabClayTileDyedSingle
	private var roofSlabMeta: Int = 3
	private var roofStairBlock: Block = LOTRMod.stairsClayTileDyedLightBlue
	private var plankBlock: Block = Blocks.planks
	private var plankMeta: Int = 2
	private var plankSlabBlock: Block = Blocks.wooden_slab
	private var plankSlabMeta: Int = 2
	private var plankStairBlock: Block = Blocks.birch_stairs
	private var fenceBlock: Block = Blocks.fence
	private var fenceMeta: Int = 2
	private var plateBlock: Block = LOTRMod.plateBlock
	private var leafBlock: Block = Blocks.leaves
	private var leafMeta: Int = 6

	override fun generateWithSetRotation(world: World, random: Random, i: Int, j: Int, k: Int, rotation: Int): Boolean {
		var k2: Int
		var j1: Int
		var distSq: Int
		var i1: Int
		var j12: Int
		var i13: Int
		var i14: Int
		var i2: Int
		var k12: Int
		var i22: Int
		var k13: Int
		var k142: Int
		var i15: Int
		val radius = 7
		val radiusPlusOne = radius + 1
		val sections = 2 + random.nextInt(3)
		val sectionHeight = 8
		this.setOriginAndRotation(world, i, j, k, rotation, radius + 3)
		val radiusD = radius - 0.5
		val radiusDPlusOne = radiusD + 1.0
		val wallThresholdMin = (radiusD * radiusD).toInt()
		val wallThresholdMax = (radiusDPlusOne * radiusDPlusOne).toInt()
		if (restrictions) {
			var minHeight = 0
			var maxHeight = 0
			for (i17 in -radiusPlusOne..radiusPlusOne) {
				k142 = -radiusPlusOne
				while (k142 <= radiusPlusOne) {
					distSq = i17 * i17 + k142 * k142
					if (distSq >= wallThresholdMax) {
						++k142
						continue
					}
					j1 = getTopBlock(world, i17, k142) - 1
					if (!isSurface(world, i17, j1, k142)) {
						return false
					}
					if (j1 < minHeight) {
						minHeight = j1
					}
					if (j1 > maxHeight) {
						maxHeight = j1
					}
					if (maxHeight - minHeight <= 16) {
						++k142
						continue
					}
					return false
				}
			}
		}
		i1 = -radius
		while (i1 <= radius) {
			k13 = -radius
			while (k13 <= radius) {
				i22 = abs(i1.toDouble()).toInt()
				k2 = abs(k13.toDouble()).toInt()
				distSq = i1 * i1 + k13 * k13
				if (distSq >= wallThresholdMax) {
					++k13
					continue
				}
				layFoundation(world, i1, k13)
				if (distSq >= wallThresholdMin) {
					setBlockAndMetadata(world, i1, 1, k13, pillarBlock, pillarMeta)
					j1 = 2
					while (j1 <= 6) {
						if (i22 == 5 && k2 == 5 || i22 == radius && k2 == 2 || k2 == radius && i22 == 2) {
							setBlockAndMetadata(world, i1, j1, k13, pillarBlock, pillarMeta)
							++j1
							continue
						}
						setBlockAndMetadata(world, i1, j1, k13, brickBlock, brickMeta)
						++j1
					}
					setBlockAndMetadata(world, i1, 7, k13, pillarBlock, pillarMeta)
					++k13
					continue
				}
				setBlockAndMetadata(world, i1, 1, k13, brickBlock, brickMeta)
				j1 = 2
				while (j1 <= 6) {
					setAir(world, i1, j1, k13)
					++j1
				}
				setBlockAndMetadata(world, i1, 7, k13, brickBlock, brickMeta)
				++k13
			}
			++i1
		}
		i1 = -4
		while (i1 <= 4) {
			k13 = -4
			while (k13 <= 4) {
				i22 = abs(i1.toDouble()).toInt()
				k2 = abs(k13.toDouble()).toInt()
				if (i22 == 4 || k2 == 4) {
					setBlockAndMetadata(world, i1, 1, k13, floorBlock, floorMeta)
					++k13
					continue
				}
				setBlockAndMetadata(world, i1, 1, k13, pillarBlock, pillarMeta)
				++k13
			}
			++i1
		}
		i1 = -1
		while (i1 <= 1) {
			for (j13 in 2..4) {
				setBlockAndMetadata(world, i1, j13, -radius, LOTRMod.gateHighElven, 2)
			}
			k13 = -radius
			while (k13 <= -4) {
				setBlockAndMetadata(world, i1, 1, k13, pillarBlock, pillarMeta)
				++k13
			}
			++i1
		}
		for (k16 in -6..-5) {
			setBlockAndMetadata(world, -2, 1, k16, floorBlock, floorMeta)
			setBlockAndMetadata(world, 2, 1, k16, floorBlock, floorMeta)
		}
		setBlockAndMetadata(world, 0, 1, -radius - 1, brickBlock, brickMeta)
		layFoundation(world, 0, -radius - 1)
		setBlockAndMetadata(world, 0, 1, -radius - 2, brickStairBlock, 2)
		setBlockAndMetadata(world, -1, 1, -radius - 1, brickStairBlock, 2)
		setBlockAndMetadata(world, 1, 1, -radius - 1, brickStairBlock, 2)
		layFoundation(world, 0, -radius - 2)
		layFoundation(world, -1, -radius - 1)
		layFoundation(world, 1, -radius - 1)
		setBlockAndMetadata(world, -2, 1, -radius - 1, brickStairBlock, 1)
		setBlockAndMetadata(world, -1, 1, -radius - 2, brickStairBlock, 1)
		setBlockAndMetadata(world, 1, 1, -radius - 2, brickStairBlock, 0)
		setBlockAndMetadata(world, 2, 1, -radius - 1, brickStairBlock, 0)
		layFoundation(world, -2, -radius - 1)
		layFoundation(world, -1, -radius - 2)
		layFoundation(world, 1, -radius - 2)
		layFoundation(world, 2, -radius - 1)
		for (i18 in intArrayOf(-radius + 1, radius - 1)) {
			setBlockAndMetadata(world, i18, 2, -2, plankStairBlock, 7)
			setBlockAndMetadata(world, i18, 2, 2, plankStairBlock, 6)
			for (k17 in -1..1) {
				setBlockAndMetadata(world, i18, 2, k17, plankSlabBlock, plankSlabMeta or 8)
			}
		}
		setBlockAndMetadata(world, -2, 2, radius - 1, plankStairBlock, 4)
		setBlockAndMetadata(world, 2, 2, radius - 1, plankStairBlock, 5)
		for (i19 in -1..1) {
			setBlockAndMetadata(world, i19, 2, radius - 1, plankSlabBlock, plankSlabMeta or 8)
		}
		for (i18 in intArrayOf(-radius + 2, radius - 2)) {
			setBlockAndMetadata(world, i18, 2, -4, plankStairBlock, 7)
			setBlockAndMetadata(world, i18, 2, -3, plankStairBlock, 6)
			setBlockAndMetadata(world, i18, 2, 3, plankStairBlock, 7)
			setBlockAndMetadata(world, i18, 2, 4, plankStairBlock, 6)
		}
		val i19 = intArrayOf(-radius + 2, radius - 2)
		k13 = i19.size
		i22 = 0
		while (i22 < k13) {
			k142 = i19[i22]
			setBlockAndMetadata(world, -4, 2, k142, plankStairBlock, 4)
			setBlockAndMetadata(world, -3, 2, k142, plankStairBlock, 5)
			setBlockAndMetadata(world, 3, 2, k142, plankStairBlock, 4)
			setBlockAndMetadata(world, 4, 2, k142, plankStairBlock, 5)
			++i22
		}
		i15 = -radius
		while (i15 <= radius) {
			k13 = -radius
			while (k13 <= radius) {
				i22 = abs(i15.toDouble()).toInt()
				k2 = abs(k13.toDouble()).toInt()
				if ((i22 == radius - 1 && k2 <= 2 || k13 == radius - 1 && i22 <= 2 || i22 == radius - 2 && k2 >= 3 && k2 <= 4 || k2 == radius - 2 && i22 >= 3 && i22 <= 4) && random.nextInt(
						3
					) == 0
				) {
					if (random.nextInt(3) == 0) {
						this.placeMug(world, random, i15, 3, k13, random.nextInt(4), LOTRFoods.ELF_DRINK)
					} else {
						placePlate(world, random, i15, 3, k13, plateBlock, LOTRFoods.ELF)
					}
				}
				if (k13 == -radius + 1 && i22 == 2) {
					for (j14 in 2..4) {
						setBlockAndMetadata(world, i15, j14, k13, brickWallBlock, brickWallMeta)
					}
					setBlockAndMetadata(world, i15, 5, k13, LOTRMod.highElvenTorch, 5)
				}
				if (i22 == radius && k2 == 0 || k13 == radius && i22 == 0) {
					setBlockAndMetadata(world, i15, 3, k13, LOTRMod.highElfWoodBars, 0)
					setBlockAndMetadata(world, i15, 4, k13, LOTRMod.highElfWoodBars, 0)
				}
				if ((i22 != radius - 1 || k2 != 1) && (k13 != radius - 1 || i22 != 1)) {
					++k13
					continue
				}
				setBlockAndMetadata(world, i15, 4, k13, fenceBlock, fenceMeta)
				setBlockAndMetadata(world, i15, 5, k13, LOTRMod.highElvenTorch, 5)
				++k13
			}
			++i15
		}
		i15 = -2
		while (i15 <= 2) {
			setBlockAndMetadata(world, i15, 6, -radius + 1, brickStairBlock, 7)
			setBlockAndMetadata(world, i15, 6, radius - 1, brickStairBlock, 6)
			++i15
		}
		for (k18 in -2..2) {
			setBlockAndMetadata(world, -radius + 1, 6, k18, brickStairBlock, 4)
			setBlockAndMetadata(world, radius - 1, 6, k18, brickStairBlock, 5)
		}
		i15 = -4
		while (i15 <= -3) {
			setBlockAndMetadata(world, i15, 6, -radius + 2, brickStairBlock, 7)
			setBlockAndMetadata(world, i15, 6, radius - 2, brickStairBlock, 6)
			++i15
		}
		i15 = 3
		while (i15 <= 4) {
			setBlockAndMetadata(world, i15, 6, -radius + 2, brickStairBlock, 7)
			setBlockAndMetadata(world, i15, 6, radius - 2, brickStairBlock, 6)
			++i15
		}
		setBlockAndMetadata(world, -radius + 2, 6, -4, brickStairBlock, 7)
		setBlockAndMetadata(world, -radius + 2, 6, -3, brickStairBlock, 4)
		setBlockAndMetadata(world, radius - 2, 6, -4, brickStairBlock, 7)
		setBlockAndMetadata(world, radius - 2, 6, -3, brickStairBlock, 5)
		setBlockAndMetadata(world, -radius + 2, 6, 3, brickStairBlock, 4)
		setBlockAndMetadata(world, -radius + 2, 6, 4, brickStairBlock, 6)
		setBlockAndMetadata(world, radius - 2, 6, 3, brickStairBlock, 5)
		setBlockAndMetadata(world, radius - 2, 6, 4, brickStairBlock, 6)
		for (k1421 in intArrayOf(-radius + 2, radius - 2)) {
			setBlockAndMetadata(world, -2, 6, k1421, brickStairBlock, 4)
			setBlockAndMetadata(world, 2, 6, k1421, brickStairBlock, 5)
		}
		for (i18 in intArrayOf(-radius + 2, radius - 2)) {
			setBlockAndMetadata(world, i18, 6, -2, brickStairBlock, 7)
			setBlockAndMetadata(world, i18, 6, 2, brickStairBlock, 6)
		}
		for (k1421 in intArrayOf(-4, 4)) {
			setBlockAndMetadata(world, -4, 6, k1421, brickStairBlock, 4)
			setBlockAndMetadata(world, 4, 6, k1421, brickStairBlock, 5)
		}
		var i12 = -2
		while (i12 <= 2) {
			setBlockAndMetadata(world, i12, 8, -radius, roofStairBlock, 2)
			setBlockAndMetadata(world, i12, 8, radius, roofStairBlock, 3)
			++i12
		}
		for (k19 in -2..2) {
			setBlockAndMetadata(world, -radius, 8, k19, roofStairBlock, 1)
			setBlockAndMetadata(world, radius, 8, k19, roofStairBlock, 0)
		}
		i12 = -4
		while (i12 <= -3) {
			setBlockAndMetadata(world, i12, 8, -radius + 1, roofStairBlock, 2)
			setBlockAndMetadata(world, i12, 8, radius - 1, roofStairBlock, 3)
			++i12
		}
		i12 = 3
		while (i12 <= 4) {
			setBlockAndMetadata(world, i12, 8, -radius + 1, roofStairBlock, 2)
			setBlockAndMetadata(world, i12, 8, radius - 1, roofStairBlock, 3)
			++i12
		}
		setBlockAndMetadata(world, -radius + 1, 8, -3, roofStairBlock, 1)
		setBlockAndMetadata(world, -radius + 1, 8, 3, roofStairBlock, 1)
		setBlockAndMetadata(world, radius - 1, 8, -3, roofStairBlock, 0)
		setBlockAndMetadata(world, radius - 1, 8, 3, roofStairBlock, 0)
		setBlockAndMetadata(world, -radius + 1, 8, -2, roofStairBlock, 2)
		setBlockAndMetadata(world, -radius + 1, 8, -4, roofStairBlock, 2)
		setBlockAndMetadata(world, -radius + 2, 8, -5, roofStairBlock, 2)
		setBlockAndMetadata(world, radius - 1, 8, -2, roofStairBlock, 2)
		setBlockAndMetadata(world, radius - 1, 8, -4, roofStairBlock, 2)
		setBlockAndMetadata(world, radius - 2, 8, -5, roofStairBlock, 2)
		setBlockAndMetadata(world, -radius + 1, 8, 2, roofStairBlock, 3)
		setBlockAndMetadata(world, -radius + 1, 8, 4, roofStairBlock, 3)
		setBlockAndMetadata(world, -radius + 2, 8, 5, roofStairBlock, 3)
		setBlockAndMetadata(world, radius - 1, 8, 2, roofStairBlock, 3)
		setBlockAndMetadata(world, radius - 1, 8, 4, roofStairBlock, 3)
		setBlockAndMetadata(world, radius - 2, 8, 5, roofStairBlock, 3)
		setBlockAndMetadata(world, -radius + 2, 8, -4, roofStairBlock, 1)
		setBlockAndMetadata(world, -4, 8, -radius + 2, roofStairBlock, 1)
		setBlockAndMetadata(world, -2, 8, -radius + 1, roofStairBlock, 1)
		setBlockAndMetadata(world, radius - 2, 8, -4, roofStairBlock, 0)
		setBlockAndMetadata(world, 4, 8, -radius + 2, roofStairBlock, 0)
		setBlockAndMetadata(world, 2, 8, -radius + 1, roofStairBlock, 0)
		setBlockAndMetadata(world, -radius + 2, 8, 4, roofStairBlock, 1)
		setBlockAndMetadata(world, -4, 8, radius - 2, roofStairBlock, 1)
		setBlockAndMetadata(world, -2, 8, radius - 1, roofStairBlock, 1)
		setBlockAndMetadata(world, radius - 2, 8, 4, roofStairBlock, 0)
		setBlockAndMetadata(world, 4, 8, radius - 2, roofStairBlock, 0)
		setBlockAndMetadata(world, 2, 8, radius - 1, roofStairBlock, 0)
		val sRadius = radius - 1
		val sRadiusD = sRadius - 0.7
		val sRadiusDPlusOne = sRadiusD + 1.0
		val sWallThresholdMin = (sRadiusD * sRadiusD).toInt()
		val sWallThresholdMax = (sRadiusDPlusOne * sRadiusDPlusOne).toInt()
		for (l in 0 until sections) {
			val sectionBase = 7 + l * sectionHeight
			var i110 = -sRadius
			while (i110 <= sRadius) {
				k12 = -sRadius
				while (k12 <= sRadius) {
					val i23 = abs(i110.toDouble()).toInt()
					val k22 = abs(k12.toDouble()).toInt()
					val distSq2 = i110 * i110 + k12 * k12
					if (distSq2 < sWallThresholdMax) {
						for (j15 in sectionBase + 1..sectionBase + sectionHeight) {
							if (distSq2 >= sWallThresholdMin) {
								if (i23 == 4 && k22 == 4 || i23 == sRadius && k22 == 1 || k22 == sRadius && i23 == 1) {
									setBlockAndMetadata(world, i110, j15, k12, pillarBlock, pillarMeta)
									continue
								}
								setBlockAndMetadata(world, i110, j15, k12, brickBlock, brickMeta)
								continue
							}
							if (j15 == sectionBase + sectionHeight) {
								setBlockAndMetadata(world, i110, j15, k12, brickBlock, brickMeta)
								continue
							}
							setAir(world, i110, j15, k12)
						}
					}
					if (i23 == 0 && k22 == sRadius || k22 == 0 && i23 == sRadius) {
						setBlockAndMetadata(world, i110, sectionBase + 1, k12, pillarBlock, pillarMeta)
						setBlockAndMetadata(world, i110, sectionBase + 3, k12, LOTRMod.highElfWoodBars, 0)
						setBlockAndMetadata(world, i110, sectionBase + 4, k12, LOTRMod.highElfWoodBars, 0)
						setBlockAndMetadata(world, i110, sectionBase + 6, k12, pillarBlock, pillarMeta)
					}
					if (i23 == 1 && k22 == sRadius - 1 || k22 == 1 && i23 == sRadius - 1) {
						setBlockAndMetadata(world, i110, sectionBase + 4, k12, fenceBlock, fenceMeta)
						setBlockAndMetadata(world, i110, sectionBase + 5, k12, LOTRMod.highElvenTorch, 5)
					}
					if ((i23 != 3 || k22 != 4) && (k22 != 3 || i23 != 4)) {
						++k12
						continue
					}
					setBlockAndMetadata(world, i110, sectionBase + 1, k12, plankBlock, plankMeta)
					if (random.nextInt(4) == 0) {
						if (random.nextBoolean()) {
							this.placeMug(
								world, random, i110, sectionBase + 2, k12, random.nextInt(4), LOTRFoods.ELF_DRINK
							)
						} else {
							placePlate(world, random, i110, sectionBase + 2, k12, plateBlock, LOTRFoods.ELF)
						}
					}
					setBlockAndMetadata(world, i110, sectionBase + 6, k12, fenceBlock, fenceMeta)
					setBlockAndMetadata(world, i110, sectionBase + 7, k12, leafBlock, leafMeta)
					++k12
				}
				++i110
			}
			i110 = -1
			while (i110 <= 1) {
				setBlockAndMetadata(world, i110, sectionBase + 1, -sRadius + 1, brickStairBlock, 3)
				setBlockAndMetadata(world, i110, sectionBase + 1, sRadius - 1, brickStairBlock, 2)
				setBlockAndMetadata(world, i110, sectionBase + 7, -sRadius + 1, plankStairBlock, 7)
				setBlockAndMetadata(world, i110, sectionBase + 7, sRadius - 1, plankStairBlock, 6)
				++i110
			}
			for (k110 in -1..1) {
				setBlockAndMetadata(world, -sRadius + 1, sectionBase + 1, k110, brickStairBlock, 0)
				setBlockAndMetadata(world, sRadius - 1, sectionBase + 1, k110, brickStairBlock, 1)
				setBlockAndMetadata(world, -sRadius + 1, sectionBase + 7, k110, plankStairBlock, 4)
				setBlockAndMetadata(world, sRadius - 1, sectionBase + 7, k110, plankStairBlock, 5)
			}
			setBlockAndMetadata(world, -sRadius, sectionBase + 2, 0, brickStairBlock, 0)
			setBlockAndMetadata(world, sRadius, sectionBase + 2, 0, brickStairBlock, 1)
			setBlockAndMetadata(world, 0, sectionBase + 2, -sRadius, brickStairBlock, 3)
			setBlockAndMetadata(world, 0, sectionBase + 2, sRadius, brickStairBlock, 2)
			setBlockAndMetadata(world, -sRadius, sectionBase + 5, 0, brickStairBlock, 4)
			setBlockAndMetadata(world, sRadius, sectionBase + 5, 0, brickStairBlock, 5)
			setBlockAndMetadata(world, 0, sectionBase + 5, -sRadius, brickStairBlock, 7)
			setBlockAndMetadata(world, 0, sectionBase + 5, sRadius, brickStairBlock, 6)
			val warrior = LOTREntityRivendellWarrior(world)
			warrior.spawnRidingHorse = false
			spawnNPCAndSetHome(warrior, world, 3, sectionBase + 1, 0, 16)
		}
		val sectionTopHeight = 7 + sections * sectionHeight
		for (j16 in 2..sectionTopHeight) {
			var i111: Int
			var j2: Int
			setBlockAndMetadata(world, 0, j16, 0, pillarBlock, pillarMeta)
			val step = (j16 + 2) % 4
			when (step) {
				0 -> {
					i111 = -2
					while (i111 <= -1) {
						setBlockAndMetadata(world, i111, j16, 0, brickSlabBlock, brickSlabMeta)
						setBlockAndMetadata(world, i111, j16, 1, brickSlabBlock, brickSlabMeta or 8)
						setBlockAndMetadata(world, i111, j16, 2, brickSlabBlock, brickSlabMeta or 8)
						j2 = j16 + 1
						while (j2 <= j16 + 3) {
							setAir(world, i111, j2, 0)
							setAir(world, i111, j2, 1)
							setAir(world, i111, j2, 2)
							++j2
						}
						++i111
					}
					setBlockAndMetadata(world, 0, j16, 1, LOTRMod.highElvenTorch, 3)
					continue
				}

				1 -> {
					k12 = 1
					while (k12 <= 2) {
						setBlockAndMetadata(world, 0, j16, k12, brickSlabBlock, brickSlabMeta)
						setBlockAndMetadata(world, 1, j16, k12, brickSlabBlock, brickSlabMeta or 8)
						setBlockAndMetadata(world, 2, j16, k12, brickSlabBlock, brickSlabMeta or 8)
						j2 = j16 + 1
						while (j2 <= j16 + 3) {
							setAir(world, 0, j2, k12)
							setAir(world, 1, j2, k12)
							setAir(world, 2, j2, k12)
							++j2
						}
						++k12
					}
					continue
				}

				2 -> {
					i111 = 1
					while (i111 <= 2) {
						setBlockAndMetadata(world, i111, j16, 0, brickSlabBlock, brickSlabMeta)
						setBlockAndMetadata(world, i111, j16, -1, brickSlabBlock, brickSlabMeta or 8)
						setBlockAndMetadata(world, i111, j16, -2, brickSlabBlock, brickSlabMeta or 8)
						j2 = j16 + 1
						while (j2 <= j16 + 3) {
							setAir(world, i111, j2, 0)
							setAir(world, i111, j2, -1)
							setAir(world, i111, j2, -2)
							++j2
						}
						++i111
					}
					setBlockAndMetadata(world, 0, j16, -1, LOTRMod.highElvenTorch, 4)
					continue
				}

				else -> {}
			}
			if (step != 3) {
				continue
			}
			k12 = -2
			while (k12 <= -1) {
				setBlockAndMetadata(world, 0, j16, k12, brickSlabBlock, brickSlabMeta)
				setBlockAndMetadata(world, -1, j16, k12, brickSlabBlock, brickSlabMeta or 8)
				setBlockAndMetadata(world, -2, j16, k12, brickSlabBlock, brickSlabMeta or 8)
				j2 = j16 + 1
				while (j2 <= j16 + 3) {
					setAir(world, 0, j2, k12)
					setAir(world, -1, j2, k12)
					setAir(world, -2, j2, k12)
					++j2
				}
				++k12
			}
		}
		i14 = -radius
		while (i14 <= radius) {
			for (k111 in -radius..radius) {
				var j17: Int
				i2 = abs(i14.toDouble()).toInt()
				val k23 = abs(k111.toDouble()).toInt()
				val distSq3 = i14 * i14 + k111 * k111
				if (distSq3 >= wallThresholdMax) {
					continue
				}
				if (distSq3 >= wallThresholdMin) {
					setBlockAndMetadata(world, i14, sectionTopHeight + 1, k111, pillarBlock, pillarMeta)
					j17 = sectionTopHeight + 2
					while (j17 <= sectionTopHeight + 5) {
						if (i2 == 5 && k23 == 5 || i2 == radius && k23 == 2 || k23 == radius && i2 == 2) {
							setBlockAndMetadata(world, i14, j17, k111, pillarBlock, pillarMeta)
							++j17
							continue
						}
						setBlockAndMetadata(world, i14, j17, k111, brickBlock, brickMeta)
						++j17
					}
					setBlockAndMetadata(world, i14, sectionTopHeight + 6, k111, pillarBlock, pillarMeta)
					setBlockAndMetadata(world, i14, sectionTopHeight + 7, k111, roofBlock, roofMeta)
					setBlockAndMetadata(world, i14, sectionTopHeight + 8, k111, roofBlock, roofMeta)
				} else {
					j17 = sectionTopHeight + 1
					while (j17 <= sectionTopHeight + 6) {
						setAir(world, i14, j17, k111)
						++j17
					}
				}
				if (i2 == 2 && k23 == radius - 1 || k23 == 2 && i2 == radius - 1) {
					setBlockAndMetadata(world, i14, sectionTopHeight + 4, k111, fenceBlock, fenceMeta)
					setBlockAndMetadata(world, i14, sectionTopHeight + 5, k111, LOTRMod.highElvenTorch, 5)
				}
				if ((i2 > 1 || k23 != radius - 1) && (k23 > 1 || i2 != radius - 1) && (i2 < 3 || i2 > 4 || k23 != radius - 2) && (k23 < 3 || k23 > 4 || i2 != radius - 2)) {
					continue
				}
				setBlockAndMetadata(world, i14, sectionTopHeight + 6, k111, fenceBlock, fenceMeta)
				setBlockAndMetadata(world, i14, sectionTopHeight + 7, k111, leafBlock, leafMeta)
			}
			++i14
		}
		setBlockAndMetadata(world, 0, sectionTopHeight + 1, 0, pillarBlock, pillarMeta)
		setBlockAndMetadata(world, 0, sectionTopHeight + 2, 0, pillarBlock, pillarMeta)
		setBlockAndMetadata(world, 0, sectionTopHeight + 3, 0, roofSlabBlock, roofSlabMeta)
		i14 = -2
		while (i14 <= 2) {
			setBlockAndMetadata(world, i14, sectionTopHeight, -radius, roofStairBlock, 6)
			setBlockAndMetadata(world, i14, sectionTopHeight, radius, roofStairBlock, 7)
			++i14
		}
		var k15 = -2
		while (k15 <= 2) {
			setBlockAndMetadata(world, -radius, sectionTopHeight, k15, roofStairBlock, 5)
			setBlockAndMetadata(world, radius, sectionTopHeight, k15, roofStairBlock, 4)
			++k15
		}
		i14 = -4
		while (i14 <= -3) {
			setBlockAndMetadata(world, i14, sectionTopHeight, -radius + 1, roofStairBlock, 6)
			setBlockAndMetadata(world, i14, sectionTopHeight, radius - 1, roofStairBlock, 7)
			++i14
		}
		i14 = 3
		while (i14 <= 4) {
			setBlockAndMetadata(world, i14, sectionTopHeight, -radius + 1, roofStairBlock, 6)
			setBlockAndMetadata(world, i14, sectionTopHeight, radius - 1, roofStairBlock, 7)
			++i14
		}
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight, -3, roofStairBlock, 5)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight, 3, roofStairBlock, 5)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight, -3, roofStairBlock, 4)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight, 3, roofStairBlock, 4)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight, -2, roofStairBlock, 6)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight, -4, roofStairBlock, 6)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight, -5, roofStairBlock, 6)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight, -2, roofStairBlock, 6)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight, -4, roofStairBlock, 6)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight, -5, roofStairBlock, 6)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight, 2, roofStairBlock, 7)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight, 4, roofStairBlock, 7)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight, 5, roofStairBlock, 7)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight, 2, roofStairBlock, 7)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight, 4, roofStairBlock, 7)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight, 5, roofStairBlock, 7)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight, -4, roofStairBlock, 5)
		setBlockAndMetadata(world, -4, sectionTopHeight, -radius + 2, roofStairBlock, 5)
		setBlockAndMetadata(world, -2, sectionTopHeight, -radius + 1, roofStairBlock, 5)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight, -4, roofStairBlock, 4)
		setBlockAndMetadata(world, 4, sectionTopHeight, -radius + 2, roofStairBlock, 4)
		setBlockAndMetadata(world, 2, sectionTopHeight, -radius + 1, roofStairBlock, 4)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight, 4, roofStairBlock, 5)
		setBlockAndMetadata(world, -4, sectionTopHeight, radius - 2, roofStairBlock, 5)
		setBlockAndMetadata(world, -2, sectionTopHeight, radius - 1, roofStairBlock, 5)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight, 4, roofStairBlock, 4)
		setBlockAndMetadata(world, 4, sectionTopHeight, radius - 2, roofStairBlock, 4)
		setBlockAndMetadata(world, 2, sectionTopHeight, radius - 1, roofStairBlock, 4)
		i14 = -2
		while (i14 <= 2) {
			setBlockAndMetadata(world, i14, sectionTopHeight + 1, -radius + 1, brickStairBlock, 3)
			setBlockAndMetadata(world, i14, sectionTopHeight + 1, radius - 1, brickStairBlock, 2)
			++i14
		}
		k15 = -2
		while (k15 <= 2) {
			setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 1, k15, brickStairBlock, 0)
			setBlockAndMetadata(world, radius - 1, sectionTopHeight + 1, k15, brickStairBlock, 1)
			++k15
		}
		i14 = -4
		while (i14 <= -3) {
			setBlockAndMetadata(world, i14, sectionTopHeight + 1, -radius + 2, brickStairBlock, 3)
			setBlockAndMetadata(world, i14, sectionTopHeight + 1, radius - 2, brickStairBlock, 2)
			++i14
		}
		i14 = 3
		while (i14 <= 4) {
			setBlockAndMetadata(world, i14, sectionTopHeight + 1, -radius + 2, brickStairBlock, 3)
			setBlockAndMetadata(world, i14, sectionTopHeight + 1, radius - 2, brickStairBlock, 2)
			++i14
		}
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 1, -4, brickStairBlock, 3)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 1, -3, brickStairBlock, 0)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 1, -4, brickStairBlock, 3)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 1, -3, brickStairBlock, 1)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 1, 3, brickStairBlock, 0)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 1, 4, brickStairBlock, 2)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 1, 3, brickStairBlock, 1)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 1, 4, brickStairBlock, 2)
		for (k112 in intArrayOf(-radius + 2, radius - 2)) {
			setBlockAndMetadata(world, -2, sectionTopHeight + 1, k112, brickStairBlock, 0)
			setBlockAndMetadata(world, 2, sectionTopHeight + 1, k112, brickStairBlock, 1)
		}
		for (i112 in intArrayOf(-radius + 2, radius - 2)) {
			setBlockAndMetadata(world, i112, sectionTopHeight + 1, -2, brickStairBlock, 3)
			setBlockAndMetadata(world, i112, sectionTopHeight + 1, 2, brickStairBlock, 2)
		}
		val i113 = intArrayOf(-4, 4)
		var k111 = i113.size
		i2 = 0
		while (i2 < k111) {
			val k112 = i113[i2]
			setBlockAndMetadata(world, -4, sectionTopHeight + 1, k112, brickStairBlock, 0)
			setBlockAndMetadata(world, 4, sectionTopHeight + 1, k112, brickStairBlock, 1)
			++i2
		}
		var i16 = -1
		while (i16 <= 1) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 2, -radius, brickStairBlock, 3)
			setBlockAndMetadata(world, i16, sectionTopHeight + 3, -radius, LOTRMod.highElfWoodBars, 0)
			setBlockAndMetadata(world, i16, sectionTopHeight + 4, -radius, LOTRMod.highElfWoodBars, 0)
			setBlockAndMetadata(world, i16, sectionTopHeight + 5, -radius, brickStairBlock, 7)
			setBlockAndMetadata(world, i16, sectionTopHeight + 2, radius, brickStairBlock, 2)
			setBlockAndMetadata(world, i16, sectionTopHeight + 3, radius, LOTRMod.highElfWoodBars, 0)
			setBlockAndMetadata(world, i16, sectionTopHeight + 4, radius, LOTRMod.highElfWoodBars, 0)
			setBlockAndMetadata(world, i16, sectionTopHeight + 5, radius, brickStairBlock, 6)
			++i16
		}
		var k1 = -1
		while (k1 <= 1) {
			setBlockAndMetadata(world, -radius, sectionTopHeight + 2, k1, brickStairBlock, 0)
			setBlockAndMetadata(world, -radius, sectionTopHeight + 3, k1, LOTRMod.highElfWoodBars, 0)
			setBlockAndMetadata(world, -radius, sectionTopHeight + 4, k1, LOTRMod.highElfWoodBars, 0)
			setBlockAndMetadata(world, -radius, sectionTopHeight + 5, k1, brickStairBlock, 4)
			setBlockAndMetadata(world, radius, sectionTopHeight + 2, k1, brickStairBlock, 1)
			setBlockAndMetadata(world, radius, sectionTopHeight + 3, k1, LOTRMod.highElfWoodBars, 0)
			setBlockAndMetadata(world, radius, sectionTopHeight + 4, k1, LOTRMod.highElfWoodBars, 0)
			setBlockAndMetadata(world, radius, sectionTopHeight + 5, k1, brickStairBlock, 5)
			++k1
		}
		placeWallBanner(world, -radius + 1, sectionTopHeight + 4, -4, LOTRItemBanner.BannerType.HIGH_ELF, 1)
		placeWallBanner(world, -radius + 1, sectionTopHeight + 4, 4, LOTRItemBanner.BannerType.HIGH_ELF, 1)
		placeWallBanner(world, radius - 1, sectionTopHeight + 4, -4, LOTRItemBanner.BannerType.HIGH_ELF, 3)
		placeWallBanner(world, radius - 1, sectionTopHeight + 4, 4, LOTRItemBanner.BannerType.HIGH_ELF, 3)
		i16 = -3
		while (i16 <= 3) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 7, -radius - 1, roofStairBlock, 2)
			setBlockAndMetadata(world, i16, sectionTopHeight + 7, radius + 1, roofStairBlock, 3)
			++i16
		}
		k1 = -3
		while (k1 <= 3) {
			setBlockAndMetadata(world, -radius - 1, sectionTopHeight + 7, k1, roofStairBlock, 1)
			setBlockAndMetadata(world, radius + 1, sectionTopHeight + 7, k1, roofStairBlock, 0)
			++k1
		}
		setBlockAndMetadata(world, -radius, sectionTopHeight + 7, -3, roofStairBlock, 2)
		setBlockAndMetadata(world, -radius, sectionTopHeight + 7, -4, roofStairBlock, 1)
		setBlockAndMetadata(world, -radius, sectionTopHeight + 7, -radius + 2, roofStairBlock, 2)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 7, -radius + 2, roofStairBlock, 2)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 7, -radius + 1, roofStairBlock, 1)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 7, -radius + 1, roofStairBlock, 2)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 7, -radius, roofStairBlock, 1)
		setBlockAndMetadata(world, -4, sectionTopHeight + 7, -radius, roofStairBlock, 2)
		setBlockAndMetadata(world, -3, sectionTopHeight + 7, -radius, roofStairBlock, 1)
		setBlockAndMetadata(world, radius, sectionTopHeight + 7, -3, roofStairBlock, 2)
		setBlockAndMetadata(world, radius, sectionTopHeight + 7, -4, roofStairBlock, 0)
		setBlockAndMetadata(world, radius, sectionTopHeight + 7, -radius + 2, roofStairBlock, 2)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 7, -radius + 2, roofStairBlock, 2)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 7, -radius + 1, roofStairBlock, 0)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 7, -radius + 1, roofStairBlock, 2)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 7, -radius, roofStairBlock, 0)
		setBlockAndMetadata(world, 4, sectionTopHeight + 7, -radius, roofStairBlock, 2)
		setBlockAndMetadata(world, 3, sectionTopHeight + 7, -radius, roofStairBlock, 0)
		setBlockAndMetadata(world, -radius, sectionTopHeight + 7, 3, roofStairBlock, 3)
		setBlockAndMetadata(world, -radius, sectionTopHeight + 7, 4, roofStairBlock, 1)
		setBlockAndMetadata(world, -radius, sectionTopHeight + 7, radius - 2, roofStairBlock, 3)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 7, radius - 2, roofStairBlock, 3)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 7, radius - 1, roofStairBlock, 1)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 7, radius - 1, roofStairBlock, 3)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 7, radius, roofStairBlock, 1)
		setBlockAndMetadata(world, -4, sectionTopHeight + 7, radius, roofStairBlock, 3)
		setBlockAndMetadata(world, -3, sectionTopHeight + 7, radius, roofStairBlock, 1)
		setBlockAndMetadata(world, radius, sectionTopHeight + 7, 3, roofStairBlock, 3)
		setBlockAndMetadata(world, radius, sectionTopHeight + 7, 4, roofStairBlock, 0)
		setBlockAndMetadata(world, radius, sectionTopHeight + 7, radius - 2, roofStairBlock, 3)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 7, radius - 2, roofStairBlock, 3)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 7, radius - 1, roofStairBlock, 0)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 7, radius - 1, roofStairBlock, 3)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 7, radius, roofStairBlock, 0)
		setBlockAndMetadata(world, 4, sectionTopHeight + 7, radius, roofStairBlock, 3)
		setBlockAndMetadata(world, 3, sectionTopHeight + 7, radius, roofStairBlock, 0)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 8, -4, roofBlock, roofMeta)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 8, -2, roofBlock, roofMeta)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 8, 2, roofBlock, roofMeta)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 8, 4, roofBlock, roofMeta)
		setBlockAndMetadata(world, -4, sectionTopHeight + 8, radius - 2, roofBlock, roofMeta)
		setBlockAndMetadata(world, -2, sectionTopHeight + 8, radius - 1, roofBlock, roofMeta)
		setBlockAndMetadata(world, 2, sectionTopHeight + 8, radius - 1, roofBlock, roofMeta)
		setBlockAndMetadata(world, 4, sectionTopHeight + 8, radius - 2, roofBlock, roofMeta)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 8, 4, roofBlock, roofMeta)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 8, 2, roofBlock, roofMeta)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 8, -2, roofBlock, roofMeta)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 8, -4, roofBlock, roofMeta)
		setBlockAndMetadata(world, 4, sectionTopHeight + 8, -radius + 2, roofBlock, roofMeta)
		setBlockAndMetadata(world, 2, sectionTopHeight + 8, -radius + 1, roofBlock, roofMeta)
		setBlockAndMetadata(world, -2, sectionTopHeight + 8, -radius + 1, roofBlock, roofMeta)
		setBlockAndMetadata(world, -4, sectionTopHeight + 8, -radius + 2, roofBlock, roofMeta)
		setBlockAndMetadata(world, -1, sectionTopHeight + 8, -radius + 1, roofStairBlock, 7)
		setBlockAndMetadata(world, 0, sectionTopHeight + 8, -radius + 1, roofStairBlock, 7)
		setBlockAndMetadata(world, 1, sectionTopHeight + 8, -radius + 1, roofStairBlock, 7)
		setBlockAndMetadata(world, 1, sectionTopHeight + 8, -radius + 2, roofStairBlock, 5)
		setBlockAndMetadata(world, 2, sectionTopHeight + 8, -radius + 2, roofStairBlock, 7)
		setBlockAndMetadata(world, 3, sectionTopHeight + 8, -radius + 2, roofStairBlock, 5)
		setBlockAndMetadata(world, 3, sectionTopHeight + 8, -4, roofStairBlock, 7)
		setBlockAndMetadata(world, 4, sectionTopHeight + 8, -4, roofStairBlock, 5)
		setBlockAndMetadata(world, 4, sectionTopHeight + 8, -3, roofStairBlock, 7)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 8, -3, roofStairBlock, 5)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 8, -2, roofStairBlock, 5)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 8, -1, roofStairBlock, 7)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 8, -1, roofStairBlock, 5)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 8, 0, roofStairBlock, 5)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 8, 1, roofStairBlock, 5)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 8, 1, roofStairBlock, 6)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 8, 2, roofStairBlock, 5)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 8, 3, roofStairBlock, 6)
		setBlockAndMetadata(world, 4, sectionTopHeight + 8, 3, roofStairBlock, 5)
		setBlockAndMetadata(world, 4, sectionTopHeight + 8, 4, roofStairBlock, 6)
		setBlockAndMetadata(world, 3, sectionTopHeight + 8, 4, roofStairBlock, 5)
		setBlockAndMetadata(world, 3, sectionTopHeight + 8, radius - 2, roofStairBlock, 6)
		setBlockAndMetadata(world, 2, sectionTopHeight + 8, radius - 2, roofStairBlock, 6)
		setBlockAndMetadata(world, 1, sectionTopHeight + 8, radius - 2, roofStairBlock, 5)
		setBlockAndMetadata(world, 1, sectionTopHeight + 8, radius - 1, roofStairBlock, 6)
		setBlockAndMetadata(world, 0, sectionTopHeight + 8, radius - 1, roofStairBlock, 6)
		setBlockAndMetadata(world, -1, sectionTopHeight + 8, radius - 1, roofStairBlock, 6)
		setBlockAndMetadata(world, -1, sectionTopHeight + 8, radius - 2, roofStairBlock, 4)
		setBlockAndMetadata(world, -2, sectionTopHeight + 8, radius - 2, roofStairBlock, 6)
		setBlockAndMetadata(world, -3, sectionTopHeight + 8, radius - 2, roofStairBlock, 4)
		setBlockAndMetadata(world, -3, sectionTopHeight + 8, 4, roofStairBlock, 6)
		setBlockAndMetadata(world, -4, sectionTopHeight + 8, 4, roofStairBlock, 4)
		setBlockAndMetadata(world, -4, sectionTopHeight + 8, 3, roofStairBlock, 6)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 8, 3, roofStairBlock, 4)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 8, 2, roofStairBlock, 4)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 8, 1, roofStairBlock, 6)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 8, 1, roofStairBlock, 4)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 8, 0, roofStairBlock, 4)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 8, -1, roofStairBlock, 4)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 8, -1, roofStairBlock, 7)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 8, -2, roofStairBlock, 4)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 8, -3, roofStairBlock, 7)
		setBlockAndMetadata(world, -4, sectionTopHeight + 8, -3, roofStairBlock, 4)
		setBlockAndMetadata(world, -4, sectionTopHeight + 8, -4, roofStairBlock, 7)
		setBlockAndMetadata(world, -3, sectionTopHeight + 8, -4, roofStairBlock, 4)
		setBlockAndMetadata(world, -3, sectionTopHeight + 8, -radius + 2, roofStairBlock, 7)
		setBlockAndMetadata(world, -2, sectionTopHeight + 8, -radius + 2, roofStairBlock, 7)
		setBlockAndMetadata(world, -1, sectionTopHeight + 8, -radius + 2, roofStairBlock, 4)
		i16 = -2
		while (i16 <= 2) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 9, -radius, roofStairBlock, 2)
			setBlockAndMetadata(world, i16, sectionTopHeight + 9, radius, roofStairBlock, 3)
			++i16
		}
		k1 = -2
		while (k1 <= 2) {
			setBlockAndMetadata(world, -radius, sectionTopHeight + 9, k1, roofStairBlock, 1)
			setBlockAndMetadata(world, radius, sectionTopHeight + 9, k1, roofStairBlock, 0)
			++k1
		}
		i16 = -4
		while (i16 <= -3) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 9, -radius + 1, roofStairBlock, 2)
			setBlockAndMetadata(world, i16, sectionTopHeight + 9, radius - 1, roofStairBlock, 3)
			++i16
		}
		i16 = 3
		while (i16 <= 4) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 9, -radius + 1, roofStairBlock, 2)
			setBlockAndMetadata(world, i16, sectionTopHeight + 9, radius - 1, roofStairBlock, 3)
			++i16
		}
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 9, -3, roofStairBlock, 1)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 9, -3, roofStairBlock, 0)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 9, 3, roofStairBlock, 1)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 9, 3, roofStairBlock, 0)
		setBlockAndMetadata(world, -2, sectionTopHeight + 9, -radius + 1, roofStairBlock, 1)
		setBlockAndMetadata(world, 2, sectionTopHeight + 9, -radius + 1, roofStairBlock, 0)
		setBlockAndMetadata(world, -2, sectionTopHeight + 9, radius - 1, roofStairBlock, 1)
		setBlockAndMetadata(world, 2, sectionTopHeight + 9, radius - 1, roofStairBlock, 0)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 9, -2, roofStairBlock, 2)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 9, 2, roofStairBlock, 3)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 9, -2, roofStairBlock, 2)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 9, 2, roofStairBlock, 3)
		setBlockAndMetadata(world, -4, sectionTopHeight + 9, -radius + 2, roofStairBlock, 1)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 9, -radius + 2, roofStairBlock, 2)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 9, -4, roofStairBlock, 1)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 9, -4, roofStairBlock, 2)
		setBlockAndMetadata(world, 4, sectionTopHeight + 9, -radius + 2, roofStairBlock, 0)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 9, -radius + 2, roofStairBlock, 2)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 9, -4, roofStairBlock, 0)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 9, -4, roofStairBlock, 2)
		setBlockAndMetadata(world, -4, sectionTopHeight + 9, radius - 2, roofStairBlock, 1)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 9, radius - 2, roofStairBlock, 3)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 9, 4, roofStairBlock, 1)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 9, 4, roofStairBlock, 3)
		setBlockAndMetadata(world, 4, sectionTopHeight + 9, radius - 2, roofStairBlock, 0)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 9, radius - 2, roofStairBlock, 3)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 9, 4, roofStairBlock, 0)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 9, 4, roofStairBlock, 3)
		j12 = sectionTopHeight + 9
		while (j12 <= sectionTopHeight + 10) {
			i13 = -1
			while (i13 <= 1) {
				setBlockAndMetadata(world, i13, j12, -radius + 1, roofBlock, roofMeta)
				setBlockAndMetadata(world, i13, j12, radius - 1, roofBlock, roofMeta)
				++i13
			}
			k111 = -1
			while (k111 <= 1) {
				setBlockAndMetadata(world, -radius + 1, j12, k111, roofBlock, roofMeta)
				setBlockAndMetadata(world, radius - 1, j12, k111, roofBlock, roofMeta)
				++k111
			}
			i13 = -3
			while (i13 <= 3) {
				setBlockAndMetadata(world, i13, j12, -radius + 2, roofBlock, roofMeta)
				setBlockAndMetadata(world, i13, j12, radius - 2, roofBlock, roofMeta)
				++i13
			}
			k111 = -3
			while (k111 <= 3) {
				setBlockAndMetadata(world, -radius + 2, j12, k111, roofBlock, roofMeta)
				setBlockAndMetadata(world, radius - 2, j12, k111, roofBlock, roofMeta)
				++k111
			}
			setBlockAndMetadata(world, -4, j12, -3, roofBlock, roofMeta)
			setBlockAndMetadata(world, -4, j12, -4, roofBlock, roofMeta)
			setBlockAndMetadata(world, -3, j12, -4, roofBlock, roofMeta)
			setBlockAndMetadata(world, 4, j12, -3, roofBlock, roofMeta)
			setBlockAndMetadata(world, 4, j12, -4, roofBlock, roofMeta)
			setBlockAndMetadata(world, 3, j12, -4, roofBlock, roofMeta)
			setBlockAndMetadata(world, -4, j12, 3, roofBlock, roofMeta)
			setBlockAndMetadata(world, -4, j12, 4, roofBlock, roofMeta)
			setBlockAndMetadata(world, -3, j12, 4, roofBlock, roofMeta)
			setBlockAndMetadata(world, 4, j12, 3, roofBlock, roofMeta)
			setBlockAndMetadata(world, 4, j12, 4, roofBlock, roofMeta)
			setBlockAndMetadata(world, 3, j12, 4, roofBlock, roofMeta)
			++j12
		}
		i16 = -2
		while (i16 <= 2) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 10, -4, roofStairBlock, 7)
			setBlockAndMetadata(world, i16, sectionTopHeight + 10, 4, roofStairBlock, 6)
			++i16
		}
		k1 = -1
		while (k1 <= 1) {
			setBlockAndMetadata(world, -4, sectionTopHeight + 10, k1, roofStairBlock, 4)
			setBlockAndMetadata(world, 4, sectionTopHeight + 10, k1, roofStairBlock, 5)
			++k1
		}
		setBlockAndMetadata(world, -2, sectionTopHeight + 10, -3, roofStairBlock, 4)
		setBlockAndMetadata(world, -3, sectionTopHeight + 10, -3, roofStairBlock, 7)
		setBlockAndMetadata(world, -3, sectionTopHeight + 10, -2, roofStairBlock, 4)
		setBlockAndMetadata(world, -4, sectionTopHeight + 10, -2, roofStairBlock, 7)
		setBlockAndMetadata(world, 2, sectionTopHeight + 10, -3, roofStairBlock, 5)
		setBlockAndMetadata(world, 3, sectionTopHeight + 10, -3, roofStairBlock, 7)
		setBlockAndMetadata(world, 3, sectionTopHeight + 10, -2, roofStairBlock, 5)
		setBlockAndMetadata(world, 4, sectionTopHeight + 10, -2, roofStairBlock, 7)
		setBlockAndMetadata(world, -2, sectionTopHeight + 10, 3, roofStairBlock, 4)
		setBlockAndMetadata(world, -3, sectionTopHeight + 10, 3, roofStairBlock, 6)
		setBlockAndMetadata(world, -3, sectionTopHeight + 10, 2, roofStairBlock, 4)
		setBlockAndMetadata(world, -4, sectionTopHeight + 10, 2, roofStairBlock, 6)
		setBlockAndMetadata(world, 2, sectionTopHeight + 10, 3, roofStairBlock, 5)
		setBlockAndMetadata(world, 3, sectionTopHeight + 10, 3, roofStairBlock, 6)
		setBlockAndMetadata(world, 3, sectionTopHeight + 10, 2, roofStairBlock, 5)
		setBlockAndMetadata(world, 4, sectionTopHeight + 10, 2, roofStairBlock, 6)
		setBlockAndMetadata(world, 0, sectionTopHeight + 11, -radius + 1, roofStairBlock, 2)
		setBlockAndMetadata(world, 1, sectionTopHeight + 11, -radius + 1, roofStairBlock, 0)
		setBlockAndMetadata(world, 1, sectionTopHeight + 11, -radius + 2, roofStairBlock, 2)
		setBlockAndMetadata(world, 2, sectionTopHeight + 11, -radius + 2, roofStairBlock, 2)
		setBlockAndMetadata(world, 3, sectionTopHeight + 11, -radius + 2, roofStairBlock, 0)
		setBlockAndMetadata(world, 3, sectionTopHeight + 11, -4, roofStairBlock, 2)
		setBlockAndMetadata(world, 4, sectionTopHeight + 11, -4, roofStairBlock, 0)
		setBlockAndMetadata(world, 4, sectionTopHeight + 11, -3, roofStairBlock, 2)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 11, -3, roofStairBlock, 0)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 11, -2, roofStairBlock, 0)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 11, -1, roofStairBlock, 2)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 11, -1, roofStairBlock, 2)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 11, 0, roofStairBlock, 0)
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 11, 1, roofStairBlock, 3)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 11, 1, roofStairBlock, 3)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 11, 2, roofStairBlock, 0)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 11, 3, roofStairBlock, 0)
		setBlockAndMetadata(world, 4, sectionTopHeight + 11, 3, roofStairBlock, 3)
		setBlockAndMetadata(world, 4, sectionTopHeight + 11, 4, roofStairBlock, 0)
		setBlockAndMetadata(world, 3, sectionTopHeight + 11, 4, roofStairBlock, 3)
		setBlockAndMetadata(world, 3, sectionTopHeight + 11, radius - 2, roofStairBlock, 0)
		setBlockAndMetadata(world, 2, sectionTopHeight + 11, radius - 2, roofStairBlock, 3)
		setBlockAndMetadata(world, 1, sectionTopHeight + 11, radius - 2, roofStairBlock, 3)
		setBlockAndMetadata(world, 1, sectionTopHeight + 11, radius - 1, roofStairBlock, 0)
		setBlockAndMetadata(world, 0, sectionTopHeight + 11, radius - 1, roofStairBlock, 3)
		setBlockAndMetadata(world, -1, sectionTopHeight + 11, radius - 1, roofStairBlock, 1)
		setBlockAndMetadata(world, -1, sectionTopHeight + 11, radius - 2, roofStairBlock, 3)
		setBlockAndMetadata(world, -2, sectionTopHeight + 11, radius - 2, roofStairBlock, 3)
		setBlockAndMetadata(world, -3, sectionTopHeight + 11, radius - 2, roofStairBlock, 1)
		setBlockAndMetadata(world, -3, sectionTopHeight + 11, 4, roofStairBlock, 3)
		setBlockAndMetadata(world, -4, sectionTopHeight + 11, 4, roofStairBlock, 1)
		setBlockAndMetadata(world, -4, sectionTopHeight + 11, 3, roofStairBlock, 3)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 11, 3, roofStairBlock, 1)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 11, 2, roofStairBlock, 1)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 11, 1, roofStairBlock, 3)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 11, 1, roofStairBlock, 3)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 11, 0, roofStairBlock, 1)
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 11, -1, roofStairBlock, 2)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 11, -1, roofStairBlock, 2)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 11, -2, roofStairBlock, 1)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 11, -3, roofStairBlock, 1)
		setBlockAndMetadata(world, -4, sectionTopHeight + 11, -3, roofStairBlock, 2)
		setBlockAndMetadata(world, -4, sectionTopHeight + 11, -4, roofStairBlock, 1)
		setBlockAndMetadata(world, -3, sectionTopHeight + 11, -4, roofStairBlock, 2)
		setBlockAndMetadata(world, -3, sectionTopHeight + 11, -radius + 2, roofStairBlock, 1)
		setBlockAndMetadata(world, -2, sectionTopHeight + 11, -radius + 2, roofStairBlock, 2)
		setBlockAndMetadata(world, -1, sectionTopHeight + 11, -radius + 2, roofStairBlock, 2)
		setBlockAndMetadata(world, -1, sectionTopHeight + 11, -radius + 1, roofStairBlock, 1)
		j12 = sectionTopHeight + 11
		while (j12 <= sectionTopHeight + 12) {
			i13 = -2
			while (i13 <= 2) {
				setBlockAndMetadata(world, i13, j12, -4, roofBlock, roofMeta)
				setBlockAndMetadata(world, i13, j12, 4, roofBlock, roofMeta)
				++i13
			}
			k111 = -2
			while (k111 <= 2) {
				setBlockAndMetadata(world, -4, j12, k111, roofBlock, roofMeta)
				setBlockAndMetadata(world, 4, j12, k111, roofBlock, roofMeta)
				++k111
			}
			setBlockAndMetadata(world, -3, j12, -2, roofBlock, roofMeta)
			setBlockAndMetadata(world, -3, j12, -3, roofBlock, roofMeta)
			setBlockAndMetadata(world, -2, j12, -3, roofBlock, roofMeta)
			setBlockAndMetadata(world, 3, j12, -2, roofBlock, roofMeta)
			setBlockAndMetadata(world, 3, j12, -3, roofBlock, roofMeta)
			setBlockAndMetadata(world, 2, j12, -3, roofBlock, roofMeta)
			setBlockAndMetadata(world, -3, j12, 2, roofBlock, roofMeta)
			setBlockAndMetadata(world, -3, j12, 3, roofBlock, roofMeta)
			setBlockAndMetadata(world, -2, j12, 3, roofBlock, roofMeta)
			setBlockAndMetadata(world, 3, j12, 2, roofBlock, roofMeta)
			setBlockAndMetadata(world, 3, j12, 3, roofBlock, roofMeta)
			setBlockAndMetadata(world, 2, j12, 3, roofBlock, roofMeta)
			++j12
		}
		setBlockAndMetadata(world, 0, sectionTopHeight + 11, -radius + 2, roofBlock, roofMeta)
		setBlockAndMetadata(world, 0, sectionTopHeight + 12, -radius + 2, roofSlabBlock, roofSlabMeta)
		setBlockAndMetadata(world, 0, sectionTopHeight + 11, radius - 2, roofBlock, roofMeta)
		setBlockAndMetadata(world, 0, sectionTopHeight + 12, radius - 2, roofSlabBlock, roofSlabMeta)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 11, 0, roofBlock, roofMeta)
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 12, 0, roofSlabBlock, roofSlabMeta)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 11, 0, roofBlock, roofMeta)
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 12, 0, roofSlabBlock, roofSlabMeta)
		setBlockAndMetadata(world, 0, sectionTopHeight + 12, -3, roofStairBlock, 7)
		setBlockAndMetadata(world, 1, sectionTopHeight + 12, -3, roofStairBlock, 7)
		setBlockAndMetadata(world, 1, sectionTopHeight + 12, -2, roofStairBlock, 5)
		setBlockAndMetadata(world, 2, sectionTopHeight + 12, -2, roofStairBlock, 7)
		setBlockAndMetadata(world, 2, sectionTopHeight + 12, -1, roofStairBlock, 5)
		setBlockAndMetadata(world, 3, sectionTopHeight + 12, -1, roofStairBlock, 7)
		setBlockAndMetadata(world, 3, sectionTopHeight + 12, 0, roofStairBlock, 5)
		setBlockAndMetadata(world, 3, sectionTopHeight + 12, 1, roofStairBlock, 6)
		setBlockAndMetadata(world, 2, sectionTopHeight + 12, 1, roofStairBlock, 5)
		setBlockAndMetadata(world, 2, sectionTopHeight + 12, 2, roofStairBlock, 6)
		setBlockAndMetadata(world, 1, sectionTopHeight + 12, 2, roofStairBlock, 5)
		setBlockAndMetadata(world, 1, sectionTopHeight + 12, 3, roofStairBlock, 6)
		setBlockAndMetadata(world, 0, sectionTopHeight + 12, 3, roofStairBlock, 6)
		setBlockAndMetadata(world, -1, sectionTopHeight + 12, 3, roofStairBlock, 6)
		setBlockAndMetadata(world, -1, sectionTopHeight + 12, 2, roofStairBlock, 4)
		setBlockAndMetadata(world, -2, sectionTopHeight + 12, 2, roofStairBlock, 6)
		setBlockAndMetadata(world, -2, sectionTopHeight + 12, 1, roofStairBlock, 4)
		setBlockAndMetadata(world, -3, sectionTopHeight + 12, 1, roofStairBlock, 6)
		setBlockAndMetadata(world, -3, sectionTopHeight + 12, 0, roofStairBlock, 4)
		setBlockAndMetadata(world, -3, sectionTopHeight + 12, -1, roofStairBlock, 7)
		setBlockAndMetadata(world, -2, sectionTopHeight + 12, -1, roofStairBlock, 4)
		setBlockAndMetadata(world, -2, sectionTopHeight + 12, -2, roofStairBlock, 7)
		setBlockAndMetadata(world, -1, sectionTopHeight + 12, -2, roofStairBlock, 4)
		setBlockAndMetadata(world, -1, sectionTopHeight + 12, -3, roofStairBlock, 7)
		i16 = -2
		while (i16 <= 2) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 13, -4, roofStairBlock, 2)
			setBlockAndMetadata(world, i16, sectionTopHeight + 13, 4, roofStairBlock, 3)
			++i16
		}
		k1 = -1
		while (k1 <= 1) {
			setBlockAndMetadata(world, -4, sectionTopHeight + 13, k1, roofStairBlock, 1)
			setBlockAndMetadata(world, 4, sectionTopHeight + 13, k1, roofStairBlock, 0)
			++k1
		}
		setBlockAndMetadata(world, -2, sectionTopHeight + 13, -3, roofStairBlock, 1)
		setBlockAndMetadata(world, -3, sectionTopHeight + 13, -3, roofStairBlock, 2)
		setBlockAndMetadata(world, -3, sectionTopHeight + 13, -2, roofStairBlock, 1)
		setBlockAndMetadata(world, -4, sectionTopHeight + 13, -2, roofStairBlock, 2)
		setBlockAndMetadata(world, 2, sectionTopHeight + 13, -3, roofStairBlock, 0)
		setBlockAndMetadata(world, 3, sectionTopHeight + 13, -3, roofStairBlock, 2)
		setBlockAndMetadata(world, 3, sectionTopHeight + 13, -2, roofStairBlock, 0)
		setBlockAndMetadata(world, 4, sectionTopHeight + 13, -2, roofStairBlock, 2)
		setBlockAndMetadata(world, -2, sectionTopHeight + 13, 3, roofStairBlock, 1)
		setBlockAndMetadata(world, -3, sectionTopHeight + 13, 3, roofStairBlock, 3)
		setBlockAndMetadata(world, -3, sectionTopHeight + 13, 2, roofStairBlock, 1)
		setBlockAndMetadata(world, -4, sectionTopHeight + 13, 2, roofStairBlock, 3)
		setBlockAndMetadata(world, 2, sectionTopHeight + 13, 3, roofStairBlock, 0)
		setBlockAndMetadata(world, 3, sectionTopHeight + 13, 3, roofStairBlock, 3)
		setBlockAndMetadata(world, 3, sectionTopHeight + 13, 2, roofStairBlock, 0)
		setBlockAndMetadata(world, 4, sectionTopHeight + 13, 2, roofStairBlock, 3)
		j12 = sectionTopHeight + 13
		while (j12 <= sectionTopHeight + 14) {
			i13 = -1
			while (i13 <= 1) {
				setBlockAndMetadata(world, i13, j12, -3, roofBlock, roofMeta)
				setBlockAndMetadata(world, i13, j12, 3, roofBlock, roofMeta)
				++i13
			}
			i13 = -2
			while (i13 <= 2) {
				setBlockAndMetadata(world, i13, j12, -2, roofBlock, roofMeta)
				setBlockAndMetadata(world, i13, j12, 2, roofBlock, roofMeta)
				++i13
			}
			k111 = -1
			while (k111 <= 1) {
				setBlockAndMetadata(world, -3, j12, k111, roofBlock, roofMeta)
				setBlockAndMetadata(world, -2, j12, k111, roofBlock, roofMeta)
				setBlockAndMetadata(world, 2, j12, k111, roofBlock, roofMeta)
				setBlockAndMetadata(world, 3, j12, k111, roofBlock, roofMeta)
				++k111
			}
			++j12
		}
		i16 = -1
		while (i16 <= 1) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 14, -1, roofStairBlock, 7)
			setBlockAndMetadata(world, i16, sectionTopHeight + 14, 1, roofStairBlock, 6)
			++i16
		}
		setBlockAndMetadata(world, -1, sectionTopHeight + 14, 0, roofStairBlock, 4)
		setBlockAndMetadata(world, 1, sectionTopHeight + 14, 0, roofStairBlock, 5)
		i16 = -1
		while (i16 <= 1) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 15, -3, roofStairBlock, 2)
			setBlockAndMetadata(world, i16, sectionTopHeight + 15, 3, roofStairBlock, 3)
			++i16
		}
		setBlockAndMetadata(world, -1, sectionTopHeight + 15, -2, roofStairBlock, 1)
		setBlockAndMetadata(world, -2, sectionTopHeight + 15, -2, roofStairBlock, 2)
		setBlockAndMetadata(world, -2, sectionTopHeight + 15, -1, roofStairBlock, 1)
		setBlockAndMetadata(world, -3, sectionTopHeight + 15, -1, roofStairBlock, 2)
		setBlockAndMetadata(world, -3, sectionTopHeight + 15, 0, roofStairBlock, 1)
		setBlockAndMetadata(world, -3, sectionTopHeight + 15, 1, roofStairBlock, 3)
		setBlockAndMetadata(world, -2, sectionTopHeight + 15, 1, roofStairBlock, 1)
		setBlockAndMetadata(world, -2, sectionTopHeight + 15, 2, roofStairBlock, 3)
		setBlockAndMetadata(world, -1, sectionTopHeight + 15, 2, roofStairBlock, 1)
		setBlockAndMetadata(world, 1, sectionTopHeight + 15, -2, roofStairBlock, 0)
		setBlockAndMetadata(world, 2, sectionTopHeight + 15, -2, roofStairBlock, 2)
		setBlockAndMetadata(world, 2, sectionTopHeight + 15, -1, roofStairBlock, 0)
		setBlockAndMetadata(world, 3, sectionTopHeight + 15, -1, roofStairBlock, 2)
		setBlockAndMetadata(world, 3, sectionTopHeight + 15, 0, roofStairBlock, 0)
		setBlockAndMetadata(world, 3, sectionTopHeight + 15, 1, roofStairBlock, 3)
		setBlockAndMetadata(world, 2, sectionTopHeight + 15, 1, roofStairBlock, 0)
		setBlockAndMetadata(world, 2, sectionTopHeight + 15, 2, roofStairBlock, 3)
		setBlockAndMetadata(world, 1, sectionTopHeight + 15, 2, roofStairBlock, 0)
		j12 = sectionTopHeight + 15
		while (j12 <= sectionTopHeight + 16) {
			i13 = -1
			while (i13 <= 1) {
				k12 = -1
				while (k12 <= 1) {
					setBlockAndMetadata(world, i13, j12, k12, roofBlock, roofMeta)
					++k12
				}
				++i13
			}
			++j12
		}
		setBlockAndMetadata(world, 0, sectionTopHeight + 15, -2, roofBlock, roofMeta)
		setBlockAndMetadata(world, 0, sectionTopHeight + 16, -2, roofSlabBlock, roofSlabMeta)
		setBlockAndMetadata(world, 0, sectionTopHeight + 15, 2, roofBlock, roofMeta)
		setBlockAndMetadata(world, 0, sectionTopHeight + 16, 2, roofSlabBlock, roofSlabMeta)
		setBlockAndMetadata(world, -2, sectionTopHeight + 15, 0, roofBlock, roofMeta)
		setBlockAndMetadata(world, -2, sectionTopHeight + 16, 0, roofSlabBlock, roofSlabMeta)
		setBlockAndMetadata(world, 2, sectionTopHeight + 15, 0, roofBlock, roofMeta)
		setBlockAndMetadata(world, 2, sectionTopHeight + 16, 0, roofSlabBlock, roofSlabMeta)
		i16 = -1
		while (i16 <= 1) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 17, -1, roofStairBlock, 2)
			setBlockAndMetadata(world, i16, sectionTopHeight + 17, 1, roofStairBlock, 3)
			++i16
		}
		setBlockAndMetadata(world, -1, sectionTopHeight + 17, 0, roofStairBlock, 1)
		setBlockAndMetadata(world, 1, sectionTopHeight + 17, 0, roofStairBlock, 0)
		setBlockAndMetadata(world, 0, sectionTopHeight + 17, 0, roofBlock, roofMeta)
		setBlockAndMetadata(world, 0, sectionTopHeight + 18, 0, roofSlabBlock, roofSlabMeta)
		j12 = sectionTopHeight + 10
		while (j12 <= sectionTopHeight + 14) {
			setBlockAndMetadata(world, 0, j12, 0, Blocks.fence, 2)
			++j12
		}
		i16 = -2
		while (i16 <= 2) {
			k111 = -2
			while (k111 <= 2) {
				if (i16 == 0 || k111 == 0) {
					setBlockAndMetadata(world, i16, sectionTopHeight + 10, k111, Blocks.fence, 2)
				}
				if ((i16 != 0 || abs(k111) != 2) && (k111 != 0 || abs(i16) != 2)) {
					++k111
					continue
				}
				setBlockAndMetadata(world, i16, sectionTopHeight + 9, k111, LOTRMod.chandelier, 10)
				++k111
			}
			++i16
		}
		setBlockAndMetadata(world, -1, sectionTopHeight + 1, 6, Blocks.crafting_table, 0)
		setBlockAndMetadata(world, 0, sectionTopHeight + 1, 6, brickBlock, brickMeta)
		setBlockAndMetadata(world, 1, sectionTopHeight + 1, 6, LOTRMod.highElvenTable, 0)
		setBlockAndMetadata(world, 0, sectionTopHeight + 1, -4, LOTRMod.commandTable, 0)
		val elfLord = LOTREntityRivendellLord(world)
		elfLord.spawnRidingHorse = false
		spawnNPCAndSetHome(elfLord, world, 0, sectionTopHeight + 1, 1, 16)
		val respawner = LOTREntityNPCRespawner(world)
		respawner.setSpawnClass(LOTREntityRivendellWarrior::class.java)
		respawner.setCheckRanges(12, -16, 50, 12)
		respawner.setSpawnRanges(6, 0, 20, 16)
		placeNPCRespawner(respawner, world, 0, 0, 0)
		return true
	}

	private fun layFoundation(world: World?, i: Int, k: Int) {
		var j = 0
		while ((j == 0 || !isOpaque(world, i, j, k)) && getY(j) >= 0) {
			setBlockAndMetadata(world, i, j, k, brickBlock, brickMeta)
			setGrassToDirt(world, i, j - 1, k)
			--j
		}
	}
}