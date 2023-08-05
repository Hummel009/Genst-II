package genst.instance

import lotr.common.LOTRMod
import lotr.common.entity.npc.*
import lotr.common.world.structure.LOTRWorldGenStructureBase
import lotr.common.world.structure2.LOTRWorldGenStructureBase2
import net.minecraft.entity.IEntityLivingData
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs


class LOTRWorldGenNorthernOrcTower(flag: Boolean) : LOTRWorldGenStructureBase2(flag) {
	override fun generateWithSetRotation(world: World, random: Random, i: Int, j: Int, k: Int, rot: Int): Boolean {
		var i = i
		var j = j
		var k = k
		val height = 5 + random.nextInt(4)
		j += height
		var rotation = random.nextInt(4)
		if (!restrictions && usingPlayer != null) {
			rotation = usingPlayerRotation()
		}
		when (rotation) {
			0 -> ++k
			1 -> --i
			2 -> --k
			3 -> ++i
		}
		var j1: Int
		var orcs: Int
		var l: Int
		if (restrictions) {
			j1 = i - 3
			while (j1 <= i + 3) {
				orcs = k - 3
				while (orcs <= k + 3) {
					l = world.getHeightValue(j1, orcs) - 1
					val l = world.getBlock(j1, l, orcs)
					if (l !== Blocks.grass) {
						return false
					}
					++orcs
				}
				++j1
			}
		}
		j1 = i - 3
		while (j1 <= i + 3) {
			orcs = k - 3
			while (orcs <= k + 3) {
				setBlockAndNotifyAdequately(world, j1, j, orcs, LOTRMod.planks, 3)
				setBlockAndNotifyAdequately(world, j1, j + 6, orcs, LOTRMod.planks, 3)
				if (abs(1 - i) == 3 || abs(orcs - k) == 3) {
					setBlockAndNotifyAdequately(world, j1, j + 1, orcs, LOTRMod.fence, 3)
					setBlockAndNotifyAdequately(world, j1, j + 5, orcs, LOTRMod.fence, 3)
					setBlockAndNotifyAdequately(world, j1, j + 7, orcs, LOTRMod.fence, 3)
				}
				++orcs
			}
			++j1
		}
		j1 = i - 3
		while (j1 <= i + 3) {
			orcs = k - 3
			while (orcs <= k + 3) {
				l = j + 5
				while ((l >= j || !LOTRMod.isOpaque(world, j1, l, orcs)) && l >= 0) {
					setBlockAndNotifyAdequately(world, j1, l, orcs, LOTRMod.wood, 3)
					setGrassToDirt(world, j1, l - 1, orcs)
					--l
				}
				orcs += 6
			}
			j1 += 6
		}
		j1 = j + 2
		while (j1 <= j + 4) {
			setBlockAndNotifyAdequately(world, i - 2, j1, k - 3, LOTRMod.fence, 3)
			setBlockAndNotifyAdequately(world, i - 2, j1, k + 3, LOTRMod.fence, 3)
			setBlockAndNotifyAdequately(world, i + 2, j1, k - 3, LOTRMod.fence, 3)
			setBlockAndNotifyAdequately(world, i + 2, j1, k + 3, LOTRMod.fence, 3)
			setBlockAndNotifyAdequately(world, i - 3, j1, k - 2, LOTRMod.fence, 3)
			setBlockAndNotifyAdequately(world, i + 3, j1, k - 2, LOTRMod.fence, 3)
			setBlockAndNotifyAdequately(world, i - 3, j1, k + 2, LOTRMod.fence, 3)
			setBlockAndNotifyAdequately(world, i + 3, j1, k + 2, LOTRMod.fence, 3)
			++j1
		}
		j1 = j + 11
		while ((j1 >= j || !LOTRMod.isOpaque(world, i, j1, k)) && j1 >= 0) {
			setBlockAndNotifyAdequately(world, i, j1, k, LOTRMod.wood, 3)
			setGrassToDirt(world, i, j1 - 1, k)
			if (j1 <= j + 6) {
				setBlockAndNotifyAdequately(world, i, j1, k - 1, Blocks.ladder, 2)
			}
			--j1
		}
		setBlockAndNotifyAdequately(world, i, j + 1, k - 1, LOTRMod.trapdoorCharred, 0)
		setBlockAndNotifyAdequately(world, i, j + 7, k - 1, LOTRMod.trapdoorCharred, 0)
		placeOrcTorch(world, i - 3, j + 8, k - 3)
		placeOrcTorch(world, i - 3, j + 8, k + 3)
		placeOrcTorch(world, i + 3, j + 8, k - 3)
		placeOrcTorch(world, i + 3, j + 8, k + 3)
		setBlockAndNotifyAdequately(world, i, j + 12, k, LOTRMod.fence, 3)
		setBlockAndNotifyAdequately(world, i, j + 13, k, LOTRMod.fence, 3)
		setBlockAndNotifyAdequately(world, i, j + 12, k - 1, LOTRMod.fence, 3)
		setBlockAndNotifyAdequately(world, i, j + 12, k + 1, LOTRMod.fence, 3)
		setBlockAndNotifyAdequately(world, i - 1, j + 12, k, LOTRMod.fence, 3)
		setBlockAndNotifyAdequately(world, i + 1, j + 12, k, LOTRMod.fence, 3)
		placeOrcTorch(world, i, j + 14, k)
		placeOrcTorch(world, i, j + 13, k - 1)
		placeOrcTorch(world, i, j + 13, k + 1)
		placeOrcTorch(world, i - 1, j + 13, k)
		placeOrcTorch(world, i + 1, j + 13, k)
		var slaver: LOTREntityNPC = LOTREntityAngmarOrcMercenaryCaptain(world)
		slaver.setLocationAndAngles(i.toDouble() + 1.5, (j + 7).toDouble(), k.toDouble() + 1.5, 0.0f, 0.0f)
		slaver.onSpawnWithEgg(null as IEntityLivingData?)
		slaver.setPersistentAndTraderShouldRespawn()
		world.spawnEntityInWorld(slaver)
		slaver.setHomeArea(i, j + 6, k, 12)
		slaver = LOTREntityGundabadOrcMercenaryCaptain(world)
		slaver.setLocationAndAngles(i.toDouble() + 1.5, (j + 7).toDouble(), k.toDouble() + 1.5, 0.0f, 0.0f)
		slaver.onSpawnWithEgg(null as IEntityLivingData?)
		slaver.setPersistentAndTraderShouldRespawn()
		world.spawnEntityInWorld(slaver)
		slaver.setHomeArea(i, j + 6, k, 12)
		orcs = 2 + random.nextInt(3)
		l = 0
		while (l < orcs) {
			val orc = if (random.nextInt(2) == 0) LOTREntityAngmarOrc(world) else LOTREntityGundabadOrc(world)
			orc.setLocationAndAngles(i.toDouble() + 1.5, (j + 1).toDouble(), k.toDouble() + 1.5, 0.0f, 0.0f)
			orc.onSpawnWithEgg(null as IEntityLivingData?)
			orc.isNPCPersistent = true
			world.spawnEntityInWorld(orc)
			orc.setHomeArea(i, j + 1, k, 8)
			++l
		}
		return true
	}
}

