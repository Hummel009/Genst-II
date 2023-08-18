package genst.world.structure

import lotr.common.LOTRFoods
import lotr.common.LOTRMod
import lotr.common.world.structure.LOTRChestContents
import lotr.common.world.structure2.LOTRWorldGenRohanStructure
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs

class StructureWoodenHouse(flag: Boolean) : LOTRWorldGenRohanStructure(flag) {
	override fun generateWithSetRotation(world: World, random: Random, i: Int, j: Int, k: Int, rotation: Int): Boolean {
		var roofEdge: Int
		var k16: Int
		var j1: Int
		var j12: Int
		var k12: Int
		var j13: Int
		var i13: Int
		var step: Int
		this.setOriginAndRotation(world, i, j, k, rotation, 6)
		setupRandomBlocks(random)
		if (restrictions) {
			var minHeight = 0
			var maxHeight = 0
			for (i14 in -6..5) {
				k16 = -10
				while (k16 <= 10) {
					val j14 = getTopBlock(world, i14, k16) - 1
					if (!isSurface(world, i14, j14, k16)) {
						return false
					}
					if (j14 < minHeight) {
						minHeight = j14
					}
					if (j14 > maxHeight) {
						maxHeight = j14
					}
					if (maxHeight - minHeight <= 5) {
						++k16
						continue
					}
					return false
				}
			}
		}
		var i12: Int = -3
		while (i12 <= 2) {
			k12 = -5
			while (k12 <= 4) {
				if (k12 < -4 && (i12 < -1 || i12 > 0)) {
					++k12
					continue
				}
				j1 = 0
				while ((j1 >= 0 || !isOpaque(world, i12, j1, k12)) && getY(j1) >= 0) {
					setBlockAndMetadata(world, i12, j1, k12, plank2Block, plank2Meta)
					setGrassToDirt(world, i12, j1 - 1, k12)
					--j1
				}
				++k12
			}
			++i12
		}
		i12 = -5
		while (i12 <= 4) {
			k12 = -7
			while (k12 <= 7) {
				j1 = 1
				while (j1 <= 8) {
					setAir(world, i12, j1, k12)
					++j1
				}
				++k12
			}
			++i12
		}
		i12 = -3
		while (i12 <= 2) {
			k12 = -4
			while (k12 <= 4) {
				if (!random.nextBoolean()) {
					++k12
					continue
				}
				setBlockAndMetadata(world, i12, 1, k12, LOTRMod.thatchFloor, 0)
				++k12
			}
			++i12
		}
		i12 = -4
		while (i12 <= 3) {
			k12 = -7
			while (k12 <= 5) {
				var beam = false
				if (k12 == -7 && (i12 == -4 || i12 == -2 || i12 == 1 || i12 == 3)) {
					beam = true
				} else if (abs(k12) == 5 && (i12 == -4 || i12 == 3)) {
					beam = true
				}
				if (beam) {
					j13 = 3
					while ((j13 >= 1 || !isOpaque(world, i12, j13, k12)) && getY(j13) >= 0) {
						setBlockAndMetadata(world, i12, j13, k12, woodBeamBlock, woodBeamMeta)
						setGrassToDirt(world, i12, j13 - 1, k12)
						--j13
					}
					++k12
					continue
				}
				if (k12 < -5) {
					++k12
					continue
				}
				if (i12 == -4 || i12 == 3) {
					setBlockAndMetadata(world, i12, 1, k12, plank2Block, plank2Meta)
					setGrassToDirt(world, i12, 0, k12)
					j13 = 2
					while (j13 <= 3) {
						setBlockAndMetadata(world, i12, j13, k12, plankBlock, plankMeta)
						++j13
					}
					++k12
					continue
				}
				if (abs(k12) != 5) {
					++k12
					continue
				}
				setBlockAndMetadata(world, i12, 1, k12, plank2Block, plank2Meta)
				setGrassToDirt(world, i12, 0, k12)
				j13 = 2
				while (j13 <= 3) {
					setBlockAndMetadata(world, i12, j13, k12, plankBlock, plankMeta)
					++j13
				}
				setBlockAndMetadata(world, i12, 4, k12, woodBeamBlock, woodBeamMeta or 4)
				++k12
			}
			++i12
		}
		for (k15 in -7..6) {
			roofEdge = if (k15 == -7 || k15 == 6) 1 else 0
			step = 0
			while (step <= 4) {
				j13 = 3 + step
				var stairBlock = roofStairBlock
				if (step == 4 || roofEdge != 0) {
					stairBlock = plank2StairBlock
				}
				setBlockAndMetadata(world, -5 + step, j13, k15, stairBlock, 1)
				setBlockAndMetadata(world, 4 - step, j13, k15, stairBlock, 0)
				if (roofEdge != 0 && step <= 3) {
					setBlockAndMetadata(world, -4 + step, j13, k15, stairBlock, 4)
					setBlockAndMetadata(world, 3 - step, j13, k15, stairBlock, 5)
				}
				if (k15 < -4 || k15 > 4 || step < 1 || step > 3) {
					++step
					continue
				}
				setBlockAndMetadata(world, -4 + step, j13, k15, stairBlock, 4)
				setBlockAndMetadata(world, 3 - step, j13, k15, stairBlock, 5)
				++step
			}
		}
		for (k161 in intArrayOf(-6, -5, 5)) {
			setBlockAndMetadata(world, -2, 5, k161, plankBlock, plankMeta)
			setBlockAndMetadata(world, -1, 5, k161, plankStairBlock, 4)
			setBlockAndMetadata(world, 0, 5, k161, plankStairBlock, 5)
			setBlockAndMetadata(world, 1, 5, k161, plankBlock, plankMeta)
			setBlockAndMetadata(world, -1, 6, k161, plankBlock, plankMeta)
			setBlockAndMetadata(world, 0, 6, k161, plankBlock, plankMeta)
		}
		val k15 = intArrayOf(-7, 6)
		roofEdge = k15.size
		step = 0
		while (step < roofEdge) {
			k16 = k15[step]
			setBlockAndMetadata(world, -1, 8, k16, plank2StairBlock, 0)
			setBlockAndMetadata(world, 0, 8, k16, plank2StairBlock, 1)
			++step
		}
		var i1: Int = -4
		while (i1 <= 3) {
			if (i1 == -4 || i1 == -2 || i1 == 1 || i1 == 3) {
				setBlockAndMetadata(world, i1, 3, -7, plank2Block, plank2Meta)
			} else {
				setBlockAndMetadata(world, i1, 3, -7, plank2SlabBlock, plank2SlabMeta or 8)
			}
			if (i1 < -3 || i1 > 2) {
				++i1
				continue
			}
			setBlockAndMetadata(world, i1, 3, 6, plank2SlabBlock, plank2SlabMeta or 8)
			++i1
		}
		i1 = -3
		while (i1 <= 2) {
			setBlockAndMetadata(world, i1, 4, -6, plankBlock, plankMeta)
			++i1
		}
		setBlockAndMetadata(world, -4, 3, -6, plank2SlabBlock, plank2SlabMeta or 8)
		setBlockAndMetadata(world, 3, 3, -6, plank2SlabBlock, plank2SlabMeta or 8)
		setBlockAndMetadata(world, -1, 4, -6, Blocks.stone_slab, 0)
		setBlockAndMetadata(world, 0, 4, -6, Blocks.stone_slab, 0)
		setBlockAndMetadata(world, -2, 4, -7, fenceBlock, fenceMeta)
		setBlockAndMetadata(world, 1, 4, -7, fenceBlock, fenceMeta)
		i1 = -1
		while (i1 <= 0) {
			for (j16 in 1..2) {
				setAir(world, i1, j16, -5)
			}
			++i1
		}
		setBlockAndMetadata(world, -1, 3, -5, plankStairBlock, 4)
		setBlockAndMetadata(world, 0, 3, -5, plankStairBlock, 5)
		for (i15 in intArrayOf(-5, 4)) {
			for (k17 in intArrayOf(-7, 6)) {
				j12 = 2
				while ((j12 >= 1 || !isOpaque(world, i15, j12, k17)) && getY(j12) >= 0) {
					setBlockAndMetadata(world, i15, j12, k17, fenceBlock, fenceMeta)
					--j12
				}
			}
		}
		for (i15 in intArrayOf(-4, 3)) {
			setAir(world, i15, 2, -2)
			setBlockAndMetadata(world, i15, 3, -2, plankSlabBlock, plankSlabMeta or 8)
			setBlockAndMetadata(world, i15, 4, -2, roofBlock, roofMeta)
			setBlockAndMetadata(world, i15, 2, -3, fenceBlock, fenceMeta)
			setBlockAndMetadata(world, i15, 2, -1, fenceBlock, fenceMeta)
			setBlockAndMetadata(world, i15, 3, -3, plankStairBlock, 7)
			setBlockAndMetadata(world, i15, 3, -1, plankStairBlock, 6)
		}
		for (i15 in intArrayOf(-5, 4)) {
			setBlockAndMetadata(world, i15, 1, -3, plankStairBlock, 7)
			setBlockAndMetadata(world, i15, 1, -2, plankSlabBlock, plankSlabMeta or 8)
			setBlockAndMetadata(world, i15, 1, -1, plankStairBlock, 6)
			for (k18 in -3..-1) {
				if (!random.nextBoolean()) {
					continue
				}
				placeFlowerPot(world, i15, 2, k18, getRandomFlower(world, random))
			}
			setBlockAndMetadata(world, i15, 3, -4, roofBlock, roofMeta)
			setBlockAndMetadata(world, i15, 3, -3, roofSlabBlock, roofSlabMeta or 8)
			setBlockAndMetadata(world, i15, 4, -3, roofSlabBlock, roofSlabMeta)
			setBlockAndMetadata(world, i15, 4, -2, roofBlock, roofMeta)
			setAir(world, i15, 3, -2)
			setBlockAndMetadata(world, i15, 3, -1, roofSlabBlock, roofSlabMeta or 8)
			setBlockAndMetadata(world, i15, 4, -1, roofSlabBlock, roofSlabMeta)
			setBlockAndMetadata(world, i15, 3, 0, roofBlock, roofMeta)
			for (k17 in intArrayOf(-4, 0)) {
				j12 = 2
				while ((j12 >= 1 || !isOpaque(world, i15, j12, k17)) && getY(j12) >= 0) {
					setBlockAndMetadata(world, i15, j12, k17, fenceBlock, fenceMeta)
					--j12
				}
			}
		}
		setBlockAndMetadata(world, -4, 2, 3, fenceBlock, fenceMeta)
		setBlockAndMetadata(world, -2, 2, 5, fenceBlock, fenceMeta)
		setBlockAndMetadata(world, 1, 2, 5, fenceBlock, fenceMeta)
		var k13 = 1
		while (k13 <= 3) {
			i13 = 2
			while (i13 <= 3) {
				j1 = 5
				while ((j1 >= 0 || !isOpaque(world, i13, j1, k13)) && getY(j1) >= 0) {
					setBlockAndMetadata(world, i13, j1, k13, Blocks.stonebrick, 0)
					--j1
				}
				++i13
			}
			++k13
		}
		setBlockAndMetadata(world, 3, 5, 1, Blocks.stone_brick_stairs, 2)
		setBlockAndMetadata(world, 3, 5, 3, Blocks.stone_brick_stairs, 3)
		setBlockAndMetadata(world, 2, 6, 1, Blocks.stone_brick_stairs, 2)
		setBlockAndMetadata(world, 2, 6, 3, Blocks.stone_brick_stairs, 3)
		setBlockAndMetadata(world, 3, 6, 2, Blocks.stone_brick_stairs, 0)
		setBlockAndMetadata(world, 1, 6, 2, Blocks.stonebrick, 0)
		for (j17 in 6..8) {
			setBlockAndMetadata(world, 2, j17, 2, Blocks.stonebrick, 0)
		}
		setBlockAndMetadata(world, 2, 9, 2, Blocks.stone_slab, 0)
		k13 = 0
		while (k13 <= 4) {
			setBlockAndMetadata(world, 2, 4, k13, Blocks.stonebrick, 0)
			for (step2 in 0..1) {
				setBlockAndMetadata(world, 1 - step2, 5 + step2, k13, Blocks.stone_brick_stairs, 5)
			}
			++k13
		}
		for (k161 in intArrayOf(0, 4)) {
			for (j18 in 1..3) {
				setBlockAndMetadata(world, 2, j18, k161, Blocks.cobblestone_wall, 0)
			}
		}
		setBlockAndMetadata(world, 2, 0, 2, LOTRMod.hearth, 0)
		setBlockAndMetadata(world, 2, 1, 2, Blocks.fire, 0)
		setBlockAndMetadata(world, 2, 2, 2, Blocks.furnace, 5)
		setBlockAndMetadata(world, 2, 3, 2, Blocks.stonebrick, 3)
		setBlockAndMetadata(world, 1, 0, 2, Blocks.stonebrick, 0)
		setBlockAndMetadata(world, 1, 1, 1, Blocks.stonebrick, 0)
		setBlockAndMetadata(world, 1, 1, 2, barsBlock, 0)
		setBlockAndMetadata(world, 1, 1, 3, Blocks.stonebrick, 0)
		var k14 = 1
		while (k14 <= 3) {
			setBlockAndMetadata(world, 1, 2, k14, Blocks.stone_slab, 0)
			++k14
		}
		for (i16 in -2..1) {
			setBlockAndMetadata(world, i16, 5, -4, plank2SlabBlock, plank2SlabMeta)
		}
		setBlockAndMetadata(world, -3, 1, -4, plankStairBlock, 3)
		setBlockAndMetadata(world, -3, 1, -3, plankStairBlock, 2)
		setBlockAndMetadata(world, -3, 1, -2, Blocks.crafting_table, 0)
		setBlockAndMetadata(world, -3, 1, -1, Blocks.anvil, 0)
		this.placeChest(world, random, -3, 1, 0, 4, ChestContents.TREASURE)
		setBlockAndMetadata(world, 2, 1, -4, plankStairBlock, 7)
		setBlockAndMetadata(world, 2, 1, -3, plankSlabBlock, plankSlabMeta or 8)
		setBlockAndMetadata(world, 2, 1, -2, plankStairBlock, 6)
		setBlockAndMetadata(world, 2, 1, -1, Blocks.cauldron, 3)
		this.placeBarrel(world, random, 2, 2, -4, 5, LOTRFoods.BREE_DRINK)
		this.placeMug(world, random, 2, 2, -3, 1, LOTRFoods.BREE_DRINK)
		if (random.nextBoolean()) {
			placePlateWithCertainty(world, random, 2, 2, -2, plateBlock, LOTRFoods.BREE)
		} else {
			setBlockAndMetadata(world, 2, 2, -2, plateBlock, 0)
		}
		if (random.nextBoolean()) {
			setBlockAndMetadata(world, 3, 2, -2, getRandomCakeBlock(random), 0)
		}
		k14 = 2
		while (k14 <= 3) {
			setBlockAndMetadata(world, -2, 1, k14, bedBlock, 3)
			setBlockAndMetadata(world, -3, 1, k14, bedBlock, 11)
			setBlockAndMetadata(world, -3, 3, k14, plank2SlabBlock, plank2SlabMeta or 8)
			++k14
		}
		for (k161 in intArrayOf(1, 4)) {
			for (j19 in 1..2) {
				setBlockAndMetadata(world, -3, j19, k161, fenceBlock, fenceMeta)
			}
			setBlockAndMetadata(world, -3, 3, k161, plank2Block, plank2Meta)
		}
		setBlockAndMetadata(world, -3, 3, -4, Blocks.torch, 2)
		setBlockAndMetadata(world, 2, 3, -4, Blocks.torch, 1)
		setBlockAndMetadata(world, -2, 4, 4, Blocks.torch, 4)
		setBlockAndMetadata(world, 1, 4, 4, Blocks.torch, 4)
		if (random.nextInt(3) != 0) {
			for (i17 in -1..0) {
				k12 = -3
				while (k12 <= -1) {
					setBlockAndMetadata(world, i17, 1, k12, carpetBlock, carpetMeta)
					++k12
				}
			}
		}
		if (random.nextInt(3) != 0) {
			val hayOrWood = random.nextBoolean()
			i13 = -1
			while (i13 <= 1) {
				for (k19 in 6..7) {
					if (k19 != 6 && i13 != 0) {
						continue
					}
					j13 = 1
					while (!isOpaque(world, i13, j13 - 1, k19) && getY(j13) >= 0) {
						--j13
					}
					var j2 = j13
					if (i13 == 0 && k19 == 6) {
						++j2
					}
					for (j3 in j13..j2) {
						if (hayOrWood) {
							setBlockAndMetadata(world, i13, j3, k19, Blocks.hay_block, 0)
							continue
						}
						setBlockAndMetadata(world, i13, j3, k19, woodBeamBlock, woodBeamMeta or 8)
					}
					setGrassToDirt(world, i13, j13 - 1, k19)
				}
				++i13
			}
		}
		if (random.nextBoolean()) {
			var i15: Int
			var j110 = 2
			k12 = 6
			val chestCoords = ArrayList<Int>()
			i15 = -4
			while (i15 <= 3) {
				if (isOpaque(world, i15, j110, k12)) {
					++i15
					continue
				}
				chestCoords.add(i15)
				++i15
			}
			if (chestCoords.isNotEmpty()) {
				i15 = chestCoords[random.nextInt(chestCoords.size)]
				while (!isOpaque(world, i15, j110 - 1, k12) && getY(j110) >= 0) {
					--j110
				}
				this.placeChest(world, random, i15, j110, k12, 3, ChestContents.TREASURE)
			}
		}
		return true
	}
}