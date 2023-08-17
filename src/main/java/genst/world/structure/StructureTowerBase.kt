package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.LOTREntityDolGuldurOrcChieftain
import lotr.common.item.LOTRItemBanner
import lotr.common.world.structure.LOTRChestContents
import lotr.common.world.structure2.LOTRWorldGenStructureBase2
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs
import kotlin.math.pow

abstract class StructureTowerBase : LOTRWorldGenStructureBase2(false) {
	override fun generateWithSetRotation(world: World, random: Random, i: Int, j: Int, k: Int, rotation: Int): Boolean {
		var i1: Int
		var j1: Int
		var i12: Int
		var k12: Int
		var i13: Int
		var k13: Int
		var step: Int
		var j12: Int
		var distSq: Int
		var k14: Int
		var j2: Int
		var j13: Int
		val radius = 6
		val radiusPlusOne = radius + 1
		this.setOriginAndRotation(world, i, j, k, rotation, radiusPlusOne)
		val sections = 3 + random.nextInt(3)
		val sectionHeight = 6
		val topHeight = sections * sectionHeight
		val radiusD = radius - 0.5
		val radiusDPlusOne = radiusD + 1.0
		val wallThresholdMin = (radiusD * radiusD).toInt()
		val wallThresholdMax = (radiusDPlusOne * radiusDPlusOne).toInt()
		if (restrictions) {
			var minHeight = 0
			var maxHeight = 0
			i1 = -radiusPlusOne
			while (i1 <= radiusPlusOne) {
				k12 = -radiusPlusOne
				while (k12 <= radiusPlusOne) {
					val distSq2 = i1 * i1 + k12 * k12
					if (distSq2 >= wallThresholdMax) {
						++k12
						continue
					}
					val j14 = getTopBlock(world, i1, k12) - 1
					val block = getBlock(world, i1, j14, k12)
					if (block !== Blocks.grass && block !== Blocks.dirt && block !== Blocks.stone) {
						return false
					}
					if (j14 < minHeight) {
						minHeight = j14
					}
					if (j14 > maxHeight) {
						maxHeight = j14
					}
					if (maxHeight - minHeight <= 16) {
						++k12
						continue
					}
					return false
				}
				++i1
			}
		}
		i13 = -radius
		while (i13 <= radius) {
			k13 = -radius
			while (k13 <= radius) {
				distSq = i13 * i13 + k13 * k13
				if (distSq >= wallThresholdMax) {
					++k13
					continue
				}
				j13 = 0
				while ((j13 == 0 || !isOpaque(world, i13, j13, k13)) && getY(j13) >= 0) {
					if (distSq >= wallThresholdMin) {
						placeRandomBrick(world, random, i13, j13, k13)
					} else {
						setBlockAndMetadata(world, i13, j13, k13, Blocks.stonebrick, 0)
					}
					setGrassToDirt(world, i13, j13 - 1, k13)
					--j13
				}
				++k13
			}
			++i13
		}
		for (l in 0 until sections) {
			val sectionBase = l * sectionHeight
			j12 = sectionBase + 1
			while (j12 <= sectionBase + sectionHeight) {
				i12 = -radius
				while (i12 <= radius) {
					for (k15 in -radius..radius) {
						val distSq3 = i12 * i12 + k15 * k15
						if (distSq3 >= wallThresholdMax) {
							continue
						}
						if (distSq3 >= wallThresholdMin) {
							placeRandomBrick(world, random, i12, j12, k15)
							continue
						}
						if (j12 == sectionBase + sectionHeight) {
							setBlockAndMetadata(world, i12, j12, k15, Blocks.stonebrick, 0)
							continue
						}
						setAir(world, i12, j12, k15)
					}
					++i12
				}
				++j12
			}
			j12 = sectionBase + 2
			while (j12 <= sectionBase + 3) {
				k12 = -1
				while (k12 <= 1) {
					setBlockAndMetadata(world, -radius, j12, k12, LOTRMod.orcSteelBars, 0)
					setBlockAndMetadata(world, radius, j12, k12, LOTRMod.orcSteelBars, 0)
					++k12
				}
				i12 = -1
				while (i12 <= 1) {
					setBlockAndMetadata(world, i12, j12, -radius, LOTRMod.orcSteelBars, 0)
					++i12
				}
				++j12
			}
			if (l > 0) {
				setAir(world, 0, sectionBase, 0)
				i1 = -1
				while (i1 <= 1) {
					k12 = -1
					while (k12 <= 1) {
						val i2 = abs(i1.toDouble()).toInt()
						val k2 = abs(k12.toDouble()).toInt()
						if (i2 == 1 || k2 == 1) {
							setBlockAndMetadata(world, i1, sectionBase + 1, k12, LOTRMod.wall2, 8)
						}
						if (i2 != 1 || k2 != 1) {
							++k12
							continue
						}
						setBlockAndMetadata(world, i1, sectionBase + 2, k12, LOTRMod.wall2, 8)
						this.placeSkull(world, random, i1, sectionBase + 2, k12)
						++k12
					}
					++i1
				}
			} else {
				i1 = -1
				while (i1 <= 1) {
					j13 = sectionBase + 1
					while (j13 <= sectionBase + 3) {
						setAir(world, i1, j13, -radius)
						++j13
					}
					setBlockAndMetadata(world, i1, sectionBase, -radius, Blocks.stonebrick, 0)
					++i1
				}
				placeRandomStairs(world, random, -1, sectionBase + 3, -radius, 4)
				placeRandomStairs(world, random, 1, sectionBase + 3, -radius, 5)
				placeWallBanner(world, 0, sectionBase + 6, -radius, LOTRItemBanner.BannerType.DOL_GULDUR, 2)
				i1 = -5
				while (i1 <= 5) {
					setBlockAndMetadata(world, i1, sectionBase, 0, LOTRMod.guldurilBrick, 4)
					++i1
				}
				k14 = -6
				while (k14 <= 3) {
					setBlockAndMetadata(world, 0, sectionBase, k14, LOTRMod.guldurilBrick, 4)
					++k14
				}
				setBlockAndMetadata(world, 0, sectionBase + 1, 0, LOTRMod.guldurilBrick, 4)
				setBlockAndMetadata(world, 0, sectionBase + 2, 0, LOTRMod.wall2, 8)
				this.placeSkull(world, random, 0, sectionBase + 3, 0)
			}
			j12 = sectionBase + 1
			while (j12 <= sectionBase + 5) {
				setBlockAndMetadata(world, -2, j12, -5, LOTRMod.wood, 2)
				setBlockAndMetadata(world, 2, j12, -5, LOTRMod.wood, 2)
				setBlockAndMetadata(world, 5, j12, -2, LOTRMod.wood, 2)
				setBlockAndMetadata(world, 5, j12, 2, LOTRMod.wood, 2)
				setBlockAndMetadata(world, -3, j12, 4, LOTRMod.wood, 2)
				setBlockAndMetadata(world, 3, j12, 4, LOTRMod.wood, 2)
				setBlockAndMetadata(world, -5, j12, -2, LOTRMod.wood, 2)
				setBlockAndMetadata(world, -5, j12, 2, LOTRMod.wood, 2)
				++j12
			}
			setBlockAndMetadata(world, -3, sectionBase + 4, 3, LOTRMod.morgulTorch, 4)
			setBlockAndMetadata(world, 3, sectionBase + 4, 3, LOTRMod.morgulTorch, 4)
			setBlockAndMetadata(world, 4, sectionBase + 4, -2, LOTRMod.morgulTorch, 1)
			setBlockAndMetadata(world, 4, sectionBase + 4, 2, LOTRMod.morgulTorch, 1)
			setBlockAndMetadata(world, -2, sectionBase + 4, -4, LOTRMod.morgulTorch, 3)
			setBlockAndMetadata(world, 2, sectionBase + 4, -4, LOTRMod.morgulTorch, 3)
			setBlockAndMetadata(world, -4, sectionBase + 4, -2, LOTRMod.morgulTorch, 2)
			setBlockAndMetadata(world, -4, sectionBase + 4, 2, LOTRMod.morgulTorch, 2)
			setBlockAndMetadata(world, -3, sectionBase + 5, 3, Blocks.stone_brick_stairs, 6)
			setBlockAndMetadata(world, 3, sectionBase + 5, 3, Blocks.stone_brick_stairs, 6)
			setBlockAndMetadata(world, 4, sectionBase + 5, -2, Blocks.stone_brick_stairs, 5)
			setBlockAndMetadata(world, 5, sectionBase + 5, -1, Blocks.stone_brick_stairs, 7)
			setBlockAndMetadata(world, 5, sectionBase + 5, 1, Blocks.stone_brick_stairs, 6)
			setBlockAndMetadata(world, 4, sectionBase + 5, 2, Blocks.stone_brick_stairs, 5)
			setBlockAndMetadata(world, -2, sectionBase + 5, -4, Blocks.stone_brick_stairs, 7)
			setBlockAndMetadata(world, -1, sectionBase + 5, -5, Blocks.stone_brick_stairs, 4)
			setBlockAndMetadata(world, 1, sectionBase + 5, -5, Blocks.stone_brick_stairs, 5)
			setBlockAndMetadata(world, 2, sectionBase + 5, -4, Blocks.stone_brick_stairs, 7)
			setBlockAndMetadata(world, -4, sectionBase + 5, -2, Blocks.stone_brick_stairs, 4)
			setBlockAndMetadata(world, -5, sectionBase + 5, -1, Blocks.stone_brick_stairs, 7)
			setBlockAndMetadata(world, -5, sectionBase + 5, 1, Blocks.stone_brick_stairs, 6)
			setBlockAndMetadata(world, -4, sectionBase + 5, 2, Blocks.stone_brick_stairs, 4)
			var step2 = 0
			while (step2 <= 2) {
				setBlockAndMetadata(world, 1 - step2, sectionBase + 1 + step2, 4, Blocks.stone_brick_stairs, 0)
				j13 = sectionBase + 1
				while (j13 <= sectionBase + step2) {
					setBlockAndMetadata(world, 1 - step2, j13, 4, Blocks.stonebrick, 0)
					++j13
				}
				++step2
			}
			k14 = 4
			while (k14 <= 5) {
				j13 = sectionBase + 1
				while (j13 <= sectionBase + 3) {
					setBlockAndMetadata(world, -2, j13, k14, Blocks.stonebrick, 0)
					++j13
				}
				++k14
			}
			i1 = -2
			while (i1 <= 0) {
				setAir(world, i1, sectionBase + sectionHeight, 5)
				++i1
			}
			step2 = 0
			while (step2 <= 2) {
				setBlockAndMetadata(world, -1 + step2, sectionBase + 4 + step2, 5, Blocks.stone_brick_stairs, 1)
				setBlockAndMetadata(world, -1 + step2, sectionBase + 3 + step2, 5, Blocks.stonebrick, 0)
				setBlockAndMetadata(world, -1 + step2, sectionBase + 2 + step2, 5, Blocks.stone_brick_stairs, 4)
				++step2
			}
			setBlockAndMetadata(world, 2, sectionBase + 5, 5, Blocks.stone_brick_stairs, 4)
		}
		this.placeChest(world, random, -1, 1, 5, 0, LOTRChestContents.DOL_GULDUR_TOWER)
		var k1: Int = -3
		while (k1 <= 3) {
			step = 0
			while (step <= 3) {
				placeBrickSupports(world, random, -9 + step, k1)
				placeBrickSupports(world, random, 9 - step, k1)
				placeRandomStairs(world, random, -9 + step, 1 + step * 2, k1, 1)
				placeRandomStairs(world, random, 9 - step, 1 + step * 2, k1, 0)
				j12 = 1
				while (j12 <= step * 2) {
					placeRandomBrick(world, random, -9 + step, j12, k1)
					placeRandomBrick(world, random, 9 - step, j12, k1)
					++j12
				}
				++step
			}
			k1 += 6
		}
		i13 = -3
		while (i13 <= 3) {
			step = 0
			while (step <= 3) {
				placeBrickSupports(world, random, i13, -9 + step)
				placeBrickSupports(world, random, i13, 9 - step)
				placeRandomStairs(world, random, i13, 1 + step * 2, -9 + step, 2)
				placeRandomStairs(world, random, i13, 1 + step * 2, 9 - step, 3)
				j12 = 1
				while (j12 <= step * 2) {
					placeRandomBrick(world, random, i13, j12, -9 + step)
					placeRandomBrick(world, random, i13, j12, 9 - step)
					++j12
				}
				++step
			}
			i13 += 6
		}
		i13 = -radius
		while (i13 <= radius) {
			k13 = -radius
			while (k13 <= radius) {
				distSq = i13 * i13 + k13 * k13
				if (distSq >= wallThresholdMax || distSq < (radiusD - 0.25).pow(2.0).toInt()) {
					++k13
					continue
				}
				val i2 = abs(i13.toDouble()).toInt()
				val k2 = abs(k13.toDouble()).toInt()
				setBlockAndMetadata(world, i13, topHeight + 1, k13, LOTRMod.wall2, 8)
				if (i2 < 3 || k2 < 3) {
					++k13
					continue
				}
				setBlockAndMetadata(world, i13, topHeight + 2, k13, LOTRMod.wall2, 8)
				if (i2 != 4 || k2 != 4) {
					++k13
					continue
				}
				setBlockAndMetadata(world, i13, topHeight + 3, k13, LOTRMod.wall2, 8)
				setBlockAndMetadata(world, i13, topHeight + 4, k13, LOTRMod.wall2, 8)
				setBlockAndMetadata(world, i13, topHeight + 5, k13, LOTRMod.morgulTorch, 5)
				++k13
			}
			++i13
		}
		setAir(world, -2, topHeight + 1, 5)
		i13 = -2
		while (i13 <= 2) {
			step = 0
			while (step <= 4) {
				j12 = topHeight + 1 + step * 2
				k12 = -9 + step
				placeRandomStairs(world, random, i13, j12 - 2, k12, 7)
				j2 = j12 - 1
				while (j2 <= j12 + 1) {
					placeRandomBrick(world, random, i13, j2, k12)
					++j2
				}
				placeRandomStairs(world, random, i13, j12 + 2, k12, 2)
				k12 = 9 - step
				placeRandomStairs(world, random, i13, j12 - 2, k12, 6)
				j2 = j12 - 1
				while (j2 <= j12 + 1) {
					placeRandomBrick(world, random, i13, j2, k12)
					++j2
				}
				placeRandomStairs(world, random, i13, j12 + 2, k12, 3)
				++step
			}
			j1 = topHeight - 4
			while (j1 <= topHeight + 2) {
				k14 = -9
				while (k14 <= -8) {
					placeRandomBrick(world, random, i13, j1, k14)
					++k14
				}
				k14 = 8
				while (k14 <= 9) {
					placeRandomBrick(world, random, i13, j1, k14)
					++k14
				}
				++j1
			}
			placeRandomBrick(world, random, i13, topHeight - 1, -7)
			placeRandomBrick(world, random, i13, topHeight, -7)
			setBlockAndMetadata(world, i13, topHeight + 1, -7, LOTRMod.wall2, 8)
			placeRandomBrick(world, random, i13, topHeight - 1, 7)
			placeRandomBrick(world, random, i13, topHeight, 7)
			setBlockAndMetadata(world, i13, topHeight + 1, 7, LOTRMod.wall2, 8)
			placeRandomStairs(world, random, i13, topHeight - 4, -9, 6)
			placeRandomStairs(world, random, i13, topHeight - 5, -8, 6)
			placeRandomStairs(world, random, i13, topHeight - 4, 9, 7)
			placeRandomStairs(world, random, i13, topHeight - 5, 8, 7)
			i13 += 4
		}
		k1 = -2
		while (k1 <= 2) {
			step = 0
			while (step <= 4) {
				j12 = topHeight + 1 + step * 2
				i12 = -9 + step
				placeRandomStairs(world, random, i12, j12 - 2, k1, 4)
				j2 = j12 - 1
				while (j2 <= j12 + 1) {
					placeRandomBrick(world, random, i12, j2, k1)
					++j2
				}
				placeRandomStairs(world, random, i12, j12 + 2, k1, 1)
				i12 = 9 - step
				placeRandomStairs(world, random, i12, j12 - 2, k1, 5)
				j2 = j12 - 1
				while (j2 <= j12 + 1) {
					placeRandomBrick(world, random, i12, j2, k1)
					++j2
				}
				placeRandomStairs(world, random, i12, j12 + 2, k1, 0)
				++step
			}
			j1 = topHeight - 4
			while (j1 <= topHeight + 2) {
				i1 = -9
				while (i1 <= -8) {
					placeRandomBrick(world, random, i1, j1, k1)
					++i1
				}
				i1 = 8
				while (i1 <= 9) {
					placeRandomBrick(world, random, i1, j1, k1)
					++i1
				}
				++j1
			}
			placeRandomBrick(world, random, -7, topHeight - 1, k1)
			placeRandomBrick(world, random, -7, topHeight, k1)
			setBlockAndMetadata(world, -7, topHeight + 1, k1, LOTRMod.wall2, 8)
			placeRandomBrick(world, random, 7, topHeight - 1, k1)
			placeRandomBrick(world, random, 7, topHeight, k1)
			setBlockAndMetadata(world, 7, topHeight + 1, k1, LOTRMod.wall2, 8)
			placeRandomStairs(world, random, -9, topHeight - 4, k1, 5)
			placeRandomStairs(world, random, -8, topHeight - 5, k1, 5)
			placeRandomStairs(world, random, 9, topHeight - 4, k1, 4)
			placeRandomStairs(world, random, 8, topHeight - 5, k1, 4)
			k1 += 4
		}
		spawnNPCAndSetHome(LOTREntityDolGuldurOrcChieftain(world), world, 0, topHeight + 1, 0, 16)
		setBlockAndMetadata(world, 0, topHeight + 1, -4, LOTRMod.commandTable, 0)
		return true
	}

	private fun placeBrickSupports(world: World?, random: Random, i: Int, k: Int) {
		var j = 0
		while (!isOpaque(world, i, j, k) && getY(j) >= 0) {
			placeRandomBrick(world, random, i, j, k)
			setGrassToDirt(world, i, j - 1, k)
			--j
		}
	}

	abstract fun placeRandomBrick(world: World?, random: Random, i: Int, j: Int, k: Int)

	abstract fun placeRandomStairs(world: World?, random: Random, i: Int, j: Int, k: Int, meta: Int)
}