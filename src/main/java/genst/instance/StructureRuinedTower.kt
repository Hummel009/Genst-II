package genst.instance

import lotr.common.LOTRMod
import lotr.common.world.structure.LOTRChestContents
import lotr.common.world.structure2.LOTRWorldGenStructureBase2
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*


class StructureRuinedTower(flag: Boolean) : LOTRWorldGenStructureBase2(flag) {
	override fun generateWithSetRotation(world: World, random: Random, i: Int, j: Int, k: Int, rot: Int): Boolean {
		var iShad = i
		var jShad = j
		var kShad = k
		var k1: Int
		var i1: Int
		--jShad
		var rotation = random.nextInt(4)
		val radius = 4 + random.nextInt(2)
		if (!restrictions && usingPlayer != null) {
			rotation = usingPlayerRotation()
			when (rotation) {
				0 -> {
					kShad += radius
				}

				1 -> {
					iShad -= radius
				}

				2 -> {
					kShad -= radius
				}

				3 -> {
					iShad += radius
				}
			}
		}
		val sections = 4 + random.nextInt(3)
		val sectionHeight = 4 + random.nextInt(4)
		val maxHeight = (sections - 1) * sectionHeight
		var wallThresholdMin = radius
		wallThresholdMin *= wallThresholdMin
		var wallThresholdMax = radius + 1
		wallThresholdMax *= wallThresholdMax
		i1 = iShad - radius
		while (i1 <= iShad + radius) {
			for (k12 in kShad - radius..kShad + radius) {
				var j1: Int
				val i2 = i1 - iShad
				val k2 = k12 - kShad
				val distSq = i2 * i2 + k2 * k2
				if (distSq >= wallThresholdMax) {
					continue
				}
				if (distSq >= wallThresholdMin) {
					j1 = jShad - 1
					while (j1 >= 0) {
						val block = world.getBlock(i1, j1, k12)
						placeRandomBrick(world, random, i1, j1, k12)
						if (block === Blocks.grass || block === Blocks.dirt || block === Blocks.stone || !restrictions && block.isOpaqueCube) {
							break
						}
						--j1
					}
					val j2 = jShad + maxHeight
					for (j12 in jShad..j2) {
						if (random.nextInt(20) == 0) {
							continue
						}
						placeRandomBrick(world, random, i1, j12, k12)
					}
					val j3 = j2 + 1 + random.nextInt(3)
					for (j13 in j2..j3) {
						placeRandomBrick(world, random, i1, j13, k12)
					}
					continue
				}
				j1 = jShad + sectionHeight
				while (j1 <= jShad + maxHeight) {
					if (random.nextInt(6) == 0) {
						j1 += sectionHeight
						continue
					}
					setBlockAndNotifyAdequately(world, i1, j1, k12, Blocks.stone_slab, 8)
					j1 += sectionHeight
				}
			}
			++i1
		}
		var j1 = jShad + sectionHeight
		while (j1 < jShad + maxHeight) {
			for (j2 in j1 + 2..j1 + 3) {
				for (i12 in iShad - 1..iShad + 1) {
					placeIronBars(world, random, i12, j2, kShad - radius)
					placeIronBars(world, random, i12, j2, kShad + radius)
				}
				k1 = kShad - 1
				while (k1 <= kShad + 1) {
					placeIronBars(world, random, iShad - radius, j2, k1)
					placeIronBars(world, random, iShad + radius, j2, k1)
					++k1
				}
			}
			j1 += sectionHeight
		}
		setBlockAndNotifyAdequately(world, iShad, jShad + maxHeight, kShad, Blocks.stone_slab, 8)
		setBlockAndNotifyAdequately(world, iShad, jShad + maxHeight + 1, kShad, LOTRMod.chestStone, rotation + 2)
		LOTRChestContents.fillChest(
			world,
			random,
			iShad,
			jShad + maxHeight + 1,
			kShad,
			LOTRChestContents.BARROW_DOWNS
		)
		when (rotation) {
			0 -> {
				var j1shad: Int
				var height: Int
				i1 = iShad - 1
				while (i1 <= iShad + 1) {
					height = jShad + 1 + random.nextInt(3)
					j1shad = jShad
					while (j1shad <= height) {
						setBlockAndNotifyAdequately(world, i1, j1shad, kShad - radius, Blocks.air, 0)
						++j1shad
					}
					++i1
				}
			}

			1 -> {
				var j1shad: Int
				var height: Int
				var k13: Int = kShad - 1
				while (k13 <= kShad + 1) {
					height = jShad + 1 + random.nextInt(3)
					j1shad = jShad
					while (j1shad <= height) {
						setBlockAndNotifyAdequately(world, iShad + radius, j1shad, k13, Blocks.air, 0)
						++j1shad
					}
					++k13
				}
			}

			2 -> {
				var j1shad: Int
				var height: Int
				i1 = iShad - 1
				while (i1 <= iShad + 1) {
					height = jShad + 1 + random.nextInt(3)
					j1shad = jShad
					while (j1shad <= height) {
						setBlockAndNotifyAdequately(world, i1, j1shad, kShad + radius, Blocks.air, 0)
						++j1shad
					}
					++i1
				}
			}

			3 -> {
				var j1shad: Int
				var height: Int
				var k13: Int = kShad - 1
				while (k13 <= kShad + 1) {
					height = jShad + 1 + random.nextInt(3)
					j1shad = jShad
					while (j1shad <= height) {
						setBlockAndNotifyAdequately(world, iShad - radius, j1shad, k13, Blocks.air, 0)
						++j1shad
					}
					++k13
				}
			}
		}
		for (l in 0..15) {
			var j1shad: Int
			val i13 = iShad - random.nextInt(radius * 2) + random.nextInt(radius * 2)
			if (world.getBlock(
					i13,
					world.getHeightValue(i13, (kShad - random.nextInt(radius * 2) + random.nextInt(radius * 2)).also {
						k1 = it
					}).also { j1shad = it } - 1,
					k1) !== Blocks.grass
			) {
				continue
			}
			val randomFeature = random.nextInt(4)
			var flag = true
			if (randomFeature == 0) {
				if (!LOTRMod.isOpaque(world, i13, j1shad, k1)) {
					setBlockAndNotifyAdequately(
						world,
						i13,
						j1shad,
						k1,
						Blocks.stone_slab,
						if (random.nextBoolean()) 0 else 5
					)
				}
			} else {
				var j2: Int
				j2 = j1shad
				while (j2 < j1shad + randomFeature && flag) {
					flag = !LOTRMod.isOpaque(world, i13, j2, k1)
					++j2
				}
				if (flag) {
					j2 = j1shad
					while (j2 < j1shad + randomFeature) {
						placeRandomBrick(world, random, i13, j2, k1)
						++j2
					}
				}
			}
			if (!flag) {
				continue
			}
			world.getBlock(i13, j1shad - 1, k1).onPlantGrow(world, i13, j1shad - 1, k1, i13, j1shad, k1)
		}
		return true
	}

	private fun placeIronBars(world: World?, random: Random, i: Int, j: Int, k: Int) {
		if (random.nextInt(4) == 0) {
			setBlockAndNotifyAdequately(world, i, j, k, Blocks.air, 0)
		} else {
			setBlockAndNotifyAdequately(world, i, j, k, Blocks.iron_bars, 0)
		}
	}

	private fun placeRandomBrick(world: World?, random: Random, i: Int, j: Int, k: Int) {
		if (random.nextInt(5) == 0) {
			setBlockAndNotifyAdequately(world, i, j, k, Blocks.stonebrick, 1 + random.nextInt(2))
		} else {
			setBlockAndNotifyAdequately(world, i, j, k, Blocks.stonebrick, 0)
		}
	}
}