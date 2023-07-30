package genst.instance

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityAngmarOrcMercenaryCaptain
import lotr.common.item.LOTRItemBanner
import lotr.common.world.biome.LOTRBiomeGenAngmar
import lotr.common.world.structure2.LOTRWorldGenStructureBase2
import net.minecraft.block.Block
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*

class LOTRWorldGenAngmarTower2(flag: Boolean) : LOTRWorldGenStructureBase2(flag) {
	private fun generateTowerSection(
		world: World,
		random: Random,
		i: Int,
		j: Int,
		k: Int,
		section: Int,
		isTop: Boolean
	) {
		var j = j
		var i1: Int
		var j1: Int
		j1 = if (section == 0) j else (section * 8).let { j += it; j } + 1
		while (j1 <= if (isTop) j + 10 else j + 8) {
			var i12: Int
			var k1: Int
			var fillBlock: Block?
			var fillMeta: Int
			fillBlock = if (j1 == j) {
				Blocks.stonebrick
			} else {
				Blocks.air
			}
			fillMeta = 0
			val hasCeiling = j1 == j + 8 && !isTop
			k1 = k - 2
			while (k1 <= k + 2) {
				setBlockAndNotifyAdequately(world, i - 5, j1, k1, fillBlock, fillMeta)
				setBlockAndNotifyAdequately(world, i + 5, j1, k1, fillBlock, fillMeta)
				if (hasCeiling && random.nextInt(20) != 0) {
					setBlockAndNotifyAdequately(world, i - 5, j1, k1, LOTRMod.slabSingle3, 11)
				}
				if (!hasCeiling || random.nextInt(20) == 0) {
					++k1
					continue
				}
				setBlockAndNotifyAdequately(world, i + 5, j1, k1, LOTRMod.slabSingle3, 11)
				++k1
			}
			k1 = k - 4
			while (k1 <= k + 4) {
				i12 = i - 4
				while (i12 <= i - 3) {
					setBlockAndNotifyAdequately(world, i12, j1, k1, fillBlock, fillMeta)
					if (!hasCeiling || random.nextInt(20) == 0) {
						++i12
						continue
					}
					setBlockAndNotifyAdequately(world, i12, j1, k1, LOTRMod.slabSingle3, 11)
					++i12
				}
				i12 = i + 3
				while (i12 <= i + 4) {
					setBlockAndNotifyAdequately(world, i12, j1, k1, fillBlock, fillMeta)
					if (!hasCeiling || random.nextInt(20) == 0) {
						++i12
						continue
					}
					setBlockAndNotifyAdequately(world, i12, j1, k1, LOTRMod.slabSingle3, 11)
					++i12
				}
				++k1
			}
			k1 = k - 5
			while (k1 <= k + 5) {
				i12 = i - 2
				while (i12 <= i + 2) {
					setBlockAndNotifyAdequately(world, i12, j1, k1, fillBlock, fillMeta)
					if (!hasCeiling || random.nextInt(20) == 0) {
						++i12
						continue
					}
					setBlockAndNotifyAdequately(world, i12, j1, k1, LOTRMod.slabSingle3, 11)
					++i12
				}
				++k1
			}
			++j1
		}
		j1 = j + 1
		while (j1 <= if (isTop) j + 1 else j + 8) {
			for (k1 in k - 2..k + 2) {
				placeRandomBrick(world, random, i - 6, j1, k1)
				placeRandomBrick(world, random, i + 6, j1, k1)
			}
			for (i13 in i - 2..i + 2) {
				placeRandomBrick(world, random, i13, j1, k - 6)
				placeRandomBrick(world, random, i13, j1, k + 6)
			}
			placeRandomBrick(world, random, i - 5, j1, k - 4)
			placeRandomBrick(world, random, i - 5, j1, k - 3)
			placeRandomBrick(world, random, i - 5, j1, k + 3)
			placeRandomBrick(world, random, i - 5, j1, k + 4)
			placeRandomBrick(world, random, i - 4, j1, k - 5)
			placeRandomBrick(world, random, i - 4, j1, k + 5)
			placeRandomBrick(world, random, i - 3, j1, k - 5)
			placeRandomBrick(world, random, i - 3, j1, k + 5)
			placeRandomBrick(world, random, i + 3, j1, k - 5)
			placeRandomBrick(world, random, i + 3, j1, k + 5)
			placeRandomBrick(world, random, i + 4, j1, k - 5)
			placeRandomBrick(world, random, i + 4, j1, k + 5)
			placeRandomBrick(world, random, i + 5, j1, k - 4)
			placeRandomBrick(world, random, i + 5, j1, k - 3)
			placeRandomBrick(world, random, i + 5, j1, k + 3)
			placeRandomBrick(world, random, i + 5, j1, k + 4)
			++j1
		}
		if (!isTop) {
			j1 = j + 2
			while (j1 <= j + 4) {
				for (k1 in k - 1..k + 1) {
					if (random.nextInt(3) != 0) {
						setBlockAndNotifyAdequately(world, i - 6, j1, k1, LOTRMod.orcSteelBars, 0)
					} else {
						setBlockAndNotifyAdequately(world, i - 6, j1, k1, Blocks.air, 0)
					}
					if (random.nextInt(3) != 0) {
						setBlockAndNotifyAdequately(world, i + 6, j1, k1, LOTRMod.orcSteelBars, 0)
						continue
					}
					setBlockAndNotifyAdequately(world, i + 6, j1, k1, Blocks.air, 0)
				}
				for (i14 in i - 1..i + 1) {
					if (random.nextInt(3) != 0) {
						setBlockAndNotifyAdequately(world, i14, j1, k - 6, LOTRMod.orcSteelBars, 0)
					} else {
						setBlockAndNotifyAdequately(world, i14, j1, k - 6, Blocks.air, 0)
					}
					if (random.nextInt(3) != 0) {
						setBlockAndNotifyAdequately(world, i14, j1, k + 6, LOTRMod.orcSteelBars, 0)
						continue
					}
					setBlockAndNotifyAdequately(world, i14, j1, k + 6, Blocks.air, 0)
				}
				++j1
			}
			i1 = i - 2
			while (i1 <= i + 2) {
				for (k1 in k - 2..k + 2) {
					setBlockAndNotifyAdequately(world, i1, j + 8, k1, Blocks.air, 0)
				}
				++i1
			}
			setBlockAndNotifyAdequately(world, i - 2, j + 1, k + 1, LOTRMod.slabSingle3, 3)
			setBlockAndNotifyAdequately(world, i - 2, j + 1, k + 2, LOTRMod.slabSingle3, 11)
			setBlockAndNotifyAdequately(world, i - 1, j + 2, k + 2, LOTRMod.slabSingle3, 3)
			setBlockAndNotifyAdequately(world, i, j + 2, k + 2, LOTRMod.slabSingle3, 11)
			setBlockAndNotifyAdequately(world, i + 1, j + 3, k + 2, LOTRMod.slabSingle3, 3)
			setBlockAndNotifyAdequately(world, i + 2, j + 3, k + 2, LOTRMod.slabSingle3, 11)
			setBlockAndNotifyAdequately(world, i + 2, j + 4, k + 1, LOTRMod.slabSingle3, 3)
			setBlockAndNotifyAdequately(world, i + 2, j + 4, k, LOTRMod.slabSingle3, 11)
			setBlockAndNotifyAdequately(world, i + 2, j + 5, k - 1, LOTRMod.slabSingle3, 3)
			setBlockAndNotifyAdequately(world, i + 2, j + 5, k - 2, LOTRMod.slabSingle3, 11)
			setBlockAndNotifyAdequately(world, i + 1, j + 6, k - 2, LOTRMod.slabSingle3, 3)
			setBlockAndNotifyAdequately(world, i, j + 6, k - 2, LOTRMod.slabSingle3, 11)
			setBlockAndNotifyAdequately(world, i - 1, j + 7, k - 2, LOTRMod.slabSingle3, 3)
			setBlockAndNotifyAdequately(world, i - 2, j + 7, k - 2, LOTRMod.slabSingle3, 11)
			setBlockAndNotifyAdequately(world, i - 2, j + 8, k - 1, LOTRMod.slabSingle3, 3)
			setBlockAndNotifyAdequately(world, i - 2, j + 8, k, LOTRMod.slabSingle3, 11)
		}
		i1 = i - 1
		while (i1 <= i + 1) {
			for (k1 in k - 1..k + 1) {
				for (j12 in j + 1..if (isTop) j + 3 else j + 8) {
					placeRandomBrick(world, random, i1, j12, k1)
				}
			}
			++i1
		}
		if (isTop) {
			var j13: Int
			val top = 4 + random.nextInt(5)
			j13 = j + 1
			while (j13 <= j + top) {
				for (k1 in k - 1..k + 1) {
					placeRandomBrick(world, random, i - 7, j13, k1)
					placeRandomBrick(world, random, i + 7, j13, k1)
				}
				for (i15 in i - 1..i + 1) {
					placeRandomBrick(world, random, i15, j13, k - 7)
					placeRandomBrick(world, random, i15, j13, k + 7)
				}
				++j13
			}
			for (k1 in k - 1..k + 1) {
				placeRandomStairs(world, random, i - 7, j, k1, 4)
				placeRandomStairs(world, random, i - 6, j + 2, k1, 1)
				placeRandomStairs(world, random, i + 7, j, k1, 5)
				placeRandomStairs(world, random, i + 6, j + 2, k1, 0)
			}
			for (i16 in i - 1..i + 1) {
				placeRandomStairs(world, random, i16, j, k - 7, 6)
				placeRandomStairs(world, random, i16, j + 2, k - 6, 3)
				placeRandomStairs(world, random, i16, j, k + 7, 7)
				placeRandomStairs(world, random, i16, j + 2, k + 6, 2)
			}
			j13 = j
			while (j13 <= j + 4) {
				setBlockAndNotifyAdequately(world, i - 5, j13, k - 5, LOTRMod.brick2, 0)
				setBlockAndNotifyAdequately(world, i - 5, j13, k + 5, LOTRMod.brick2, 0)
				setBlockAndNotifyAdequately(world, i + 5, j13, k - 5, LOTRMod.brick2, 0)
				setBlockAndNotifyAdequately(world, i + 5, j13, k + 5, LOTRMod.brick2, 0)
				++j13
			}
			placeBanner(world, i - 5, j + 5, k - 5, LOTRItemBanner.BannerType.ANGMAR, 0)
			placeBanner(world, i - 5, j + 5, k + 5, LOTRItemBanner.BannerType.ANGMAR, 0)
			placeBanner(world, i + 5, j + 5, k - 5, LOTRItemBanner.BannerType.ANGMAR, 0)
			placeBanner(world, i + 5, j + 5, k + 5, LOTRItemBanner.BannerType.ANGMAR, 0)
			placeRandomStairs(world, random, i - 5, j + 2, k - 4, 3)
			placeRandomStairs(world, random, i - 4, j + 2, k - 5, 1)
			placeRandomStairs(world, random, i - 5, j + 2, k + 4, 2)
			placeRandomStairs(world, random, i - 4, j + 2, k + 5, 1)
			placeRandomStairs(world, random, i + 5, j + 2, k - 4, 3)
			placeRandomStairs(world, random, i + 4, j + 2, k - 5, 0)
			placeRandomStairs(world, random, i + 5, j + 2, k + 4, 2)
			placeRandomStairs(world, random, i + 4, j + 2, k + 5, 0)
		}
	}

	override fun generateWithSetRotation(world: World, random: Random, i: Int, j: Int, k: Int, rotation: Int): Boolean {
		var j = j
		var j1: Int
		var i1: Int
		var k1: Int
		var j12: Int
		var k12: Int
		if (restrictions) {
			if (world.getBiomeGenForCoords(i, k) !is LOTRBiomeGenAngmar) {
				return false
			}
			val l = world.getBlock(i, j - 1, k)
			if (l !== Blocks.grass && l !== Blocks.dirt && l !== Blocks.stone) {
				return false
			}
		}
		--j
		val sections = 2 + random.nextInt(3)
		if (restrictions) {
			for (i12 in i - 7..i + 7) {
				k12 = k - 7
				while (k12 <= k + 7) {
					j1 = world.getHeightValue(i12, k12) - 1
					val block = world.getBlock(i12, j1, k12)
					if (block === Blocks.grass || block === Blocks.stone || block === Blocks.dirt || block.isWood(
							world,
							i12,
							j1,
							k12
						) || block.isLeaves(world, i12, j1, k12)
					) {
						++k12
						continue
					}
					return false
					++k12
				}
			}
		}
		k1 = k - 2
		while (k1 <= k + 2) {
			j12 = j
			while (!LOTRMod.isOpaque(world, i - 6, j12, k1) && j12 >= 0) {
				setBlockAndNotifyAdequately(world, i - 6, j12, k1, LOTRMod.brick2, 0)
				setGrassToDirt(world, i - 6, j12 - 1, k1)
				--j12
			}
			j12 = j
			while (!LOTRMod.isOpaque(world, i + 6, j12, k1) && j12 >= 0) {
				setBlockAndNotifyAdequately(world, i + 6, j12, k1, LOTRMod.brick2, 0)
				setGrassToDirt(world, i + 6, j12 - 1, k1)
				--j12
			}
			++k1
		}
		k1 = k - 4
		while (k1 <= k + 4) {
			j12 = j
			while (!LOTRMod.isOpaque(world, i - 5, j12, k1) && j12 >= 0) {
				setBlockAndNotifyAdequately(world, i - 5, j12, k1, LOTRMod.brick2, 0)
				setGrassToDirt(world, i - 5, j12 - 1, k1)
				--j12
			}
			j12 = j
			while (!LOTRMod.isOpaque(world, i + 5, j12, k1) && j12 >= 0) {
				setBlockAndNotifyAdequately(world, i + 5, j12, k1, LOTRMod.brick2, 0)
				setGrassToDirt(world, i + 5, j12 - 1, k1)
				--j12
			}
			++k1
		}
		k1 = k - 5
		while (k1 <= k + 5) {
			i1 = i - 4
			while (i1 <= i - 3) {
				j1 = j
				while (!LOTRMod.isOpaque(world, i1, j1, k1) && j1 >= 0) {
					setBlockAndNotifyAdequately(world, i1, j1, k1, LOTRMod.brick2, 0)
					setGrassToDirt(world, i1, j1 - 1, k1)
					--j1
				}
				++i1
			}
			i1 = i + 3
			while (i1 <= i + 4) {
				j1 = j
				while (!LOTRMod.isOpaque(world, i1, j1, k1) && j1 >= 0) {
					setBlockAndNotifyAdequately(world, i1, j1, k1, LOTRMod.brick2, 0)
					setGrassToDirt(world, i1, j1 - 1, k1)
					--j1
				}
				++i1
			}
			++k1
		}
		k1 = k - 6
		while (k1 <= k + 6) {
			i1 = i - 2
			while (i1 <= i + 2) {
				j1 = j
				while (!LOTRMod.isOpaque(world, i1, j1, k1) && j1 >= 0) {
					setBlockAndNotifyAdequately(world, i1, j1, k1, LOTRMod.brick2, 0)
					setGrassToDirt(world, i1, j1 - 1, k1)
					--j1
				}
				++i1
			}
			++k1
		}
		for (l in 0..sections) {
			generateTowerSection(world, random, i, j, k, l, false)
		}
		generateTowerSection(world, random, i, j, k, sections + 1, true)
		val trader = LOTREntityAngmarOrcMercenaryCaptain(world)
		trader.setLocationAndAngles(
			i - 2 + 0.5,
			(j + (sections + 1) * 8 + 1).toDouble(),
			k + 0.5,
			world.rand.nextFloat() * 360.0f,
			0.0f
		)
		trader.onSpawnWithEgg(null)
		trader.setPersistentAndTraderShouldRespawn()
		trader.setHomeArea(i, j + (sections + 1) * 8, k, 24)
		world.spawnEntityInWorld(trader)
		when (rotation) {
			0 -> {
				i1 = i - 1
				while (i1 <= i + 1) {
					setBlockAndNotifyAdequately(world, i1, j, k - 6, Blocks.stonebrick, 0)
					j1 = j + 1
					while (j1 <= j + 4) {
						setBlockAndNotifyAdequately(world, i1, j1, k - 6, Blocks.air, 0)
						++j1
					}
					++i1
				}
				setBlockAndNotifyAdequately(world, i, j + 7, k - 6, LOTRMod.brick2, 0)
				placeWallBanner(world, i, j + 7, k - 6, LOTRItemBanner.BannerType.ANGMAR, 2)
			}

			1 -> {
				k12 = k - 1
				while (k12 <= k + 1) {
					setBlockAndNotifyAdequately(world, i + 6, j, k12, Blocks.stonebrick, 0)
					j1 = j + 1
					while (j1 <= j + 4) {
						setBlockAndNotifyAdequately(world, i + 6, j1, k12, Blocks.air, 0)
						++j1
					}
					++k12
				}
				setBlockAndNotifyAdequately(world, i + 6, j + 7, k, LOTRMod.brick2, 0)
				placeWallBanner(world, i + 6, j + 7, k, LOTRItemBanner.BannerType.ANGMAR, 3)
			}

			2 -> {
				i1 = i - 1
				while (i1 <= i + 1) {
					setBlockAndNotifyAdequately(world, i1, j, k + 6, Blocks.stonebrick, 0)
					j1 = j + 1
					while (j1 <= j + 4) {
						setBlockAndNotifyAdequately(world, i1, j1, k + 6, Blocks.air, 0)
						++j1
					}
					++i1
				}
				setBlockAndNotifyAdequately(world, i, j + 7, k + 6, LOTRMod.brick2, 0)
				placeWallBanner(world, i, j + 7, k + 6, LOTRItemBanner.BannerType.ANGMAR, 0)
			}

			3 -> {
				k12 = k - 1
				while (k12 <= k + 1) {
					setBlockAndNotifyAdequately(world, i - 6, j, k12, Blocks.stonebrick, 0)
					j1 = j + 1
					while (j1 <= j + 4) {
						setBlockAndNotifyAdequately(world, i - 6, j1, k12, Blocks.air, 0)
						++j1
					}
					++k12
				}
				setBlockAndNotifyAdequately(world, i - 6, j + 7, k, LOTRMod.brick2, 0)
				placeWallBanner(world, i - 6, j + 7, k, LOTRItemBanner.BannerType.ANGMAR, 1)
			}
		}
		val radius = 6
		for (l in 0..15) {
			var j13: Int
			var k13: Int
			val i13 = i - random.nextInt(radius * 2) + random.nextInt(radius * 2)
			val id = world.getBlock(
				i13,
				world.getHeightValue(
					i13,
					(k - random.nextInt(radius * 2) + random.nextInt(radius * 2)).also { k13 = it })
					.also { j13 = it } - 1,
				k13)
			if (id !== Blocks.grass && id !== Blocks.dirt && id !== Blocks.stone) {
				continue
			}
			val randomFeature = random.nextInt(4)
			var flag = true
			if (randomFeature == 0) {
				if (!LOTRMod.isOpaque(world, i13, j13, k13)) {
					if (random.nextInt(3) == 0) {
						setBlockAndNotifyAdequately(world, i13, j13, k13, LOTRMod.slabSingle3, 4)
					} else {
						setBlockAndNotifyAdequately(world, i13, j13, k13, LOTRMod.slabSingle3, 3)
					}
				}
			} else {
				var j2: Int
				j2 = j13
				while (j2 < j13 + randomFeature && flag) {
					flag = !LOTRMod.isOpaque(world, i13, j2, k13)
					++j2
				}
				if (flag) {
					j2 = j13
					while (j2 < j13 + randomFeature) {
						if (random.nextBoolean()) {
							setBlockAndNotifyAdequately(world, i13, j2, k13, LOTRMod.brick2, 0)
							++j2
							continue
						}
						setBlockAndNotifyAdequately(world, i13, j2, k13, LOTRMod.brick2, 1)
						++j2
					}
				}
			}
			if (world.getBlock(i13, j13 - 1, k13) !== Blocks.dirt) {
				continue
			}
			setBlockAndNotifyAdequately(world, i13, j13 - 1, k13, Blocks.dirt, 0)
		}
		return true
	}

	private fun placeRandomBrick(world: World, random: Random, i: Int, j: Int, k: Int) {
		if (random.nextInt(20) == 0) {
			return
		}
		if (random.nextInt(3) == 0) {
			setBlockAndNotifyAdequately(world, i, j, k, LOTRMod.brick2, 1)
		} else {
			setBlockAndNotifyAdequately(world, i, j, k, LOTRMod.brick2, 0)
		}
	}

	private fun placeRandomStairs(world: World, random: Random, i: Int, j: Int, k: Int, meta: Int) {
		if (random.nextInt(10) == 0) {
			return
		}
		if (random.nextInt(3) == 0) {
			setBlockAndNotifyAdequately(world, i, j, k, LOTRMod.stairsAngmarBrickCracked, meta)
		} else {
			setBlockAndNotifyAdequately(world, i, j, k, LOTRMod.stairsAngmarBrick, meta)
		}
	}
}
