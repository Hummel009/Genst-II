package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.entity.npc.*
import lotr.common.world.structure2.LOTRWorldGenStructureBase2
import net.minecraft.entity.IEntityLivingData
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs


class StructureNorthernOrcTower(flag: Boolean) : LOTRWorldGenStructureBase2(flag) {
	override fun generateWithSetRotation(world: World, random: Random, i: Int, j: Int, k: Int, rot: Int): Boolean {
		var iShad = i
		var jShad = j
		var kShad = k
		val height = 5 + random.nextInt(4)
		jShad += height
		var rotation = random.nextInt(4)
		if (!restrictions && usingPlayer != null) {
			rotation = usingPlayerRotation()
		}
		when (rotation) {
			0 -> ++kShad
			1 -> --iShad
			2 -> --kShad
			3 -> ++iShad
		}
		var j1: Int
		var orcs: Int
		var l: Int
		if (restrictions) {
			j1 = iShad - 3
			while (j1 <= iShad + 3) {
				orcs = kShad - 3
				while (orcs <= kShad + 3) {
					l = world.getHeightValue(j1, orcs) - 1
					val lShad = world.getBlock(j1, l, orcs)
					if (lShad !== Blocks.grass) {
						return false
					}
					++orcs
				}
				++j1
			}
		}
		j1 = iShad - 3
		while (j1 <= iShad + 3) {
			orcs = kShad - 3
			while (orcs <= kShad + 3) {
				setBlockAndNotifyAdequately(world, j1, jShad, orcs, LOTRMod.planks, 3)
				setBlockAndNotifyAdequately(world, j1, jShad + 6, orcs, LOTRMod.planks, 3)
				if (abs(1 - iShad) == 3 || abs(orcs - kShad) == 3) {
					setBlockAndNotifyAdequately(world, j1, jShad + 1, orcs, LOTRMod.fence, 3)
					setBlockAndNotifyAdequately(world, j1, jShad + 5, orcs, LOTRMod.fence, 3)
					setBlockAndNotifyAdequately(world, j1, jShad + 7, orcs, LOTRMod.fence, 3)
				}
				++orcs
			}
			++j1
		}
		j1 = iShad - 3
		while (j1 <= iShad + 3) {
			orcs = kShad - 3
			while (orcs <= kShad + 3) {
				l = jShad + 5
				while ((l >= jShad || !LOTRMod.isOpaque(world, j1, l, orcs)) && l >= 0) {
					setBlockAndNotifyAdequately(world, j1, l, orcs, LOTRMod.wood, 3)
					setGrassToDirt(world, j1, l - 1, orcs)
					--l
				}
				orcs += 6
			}
			j1 += 6
		}
		j1 = jShad + 2
		while (j1 <= jShad + 4) {
			setBlockAndNotifyAdequately(world, iShad - 2, j1, kShad - 3, LOTRMod.fence, 3)
			setBlockAndNotifyAdequately(world, iShad - 2, j1, kShad + 3, LOTRMod.fence, 3)
			setBlockAndNotifyAdequately(world, iShad + 2, j1, kShad - 3, LOTRMod.fence, 3)
			setBlockAndNotifyAdequately(world, iShad + 2, j1, kShad + 3, LOTRMod.fence, 3)
			setBlockAndNotifyAdequately(world, iShad - 3, j1, kShad - 2, LOTRMod.fence, 3)
			setBlockAndNotifyAdequately(world, iShad + 3, j1, kShad - 2, LOTRMod.fence, 3)
			setBlockAndNotifyAdequately(world, iShad - 3, j1, kShad + 2, LOTRMod.fence, 3)
			setBlockAndNotifyAdequately(world, iShad + 3, j1, kShad + 2, LOTRMod.fence, 3)
			++j1
		}
		j1 = jShad + 11
		while ((j1 >= jShad || !LOTRMod.isOpaque(world, iShad, j1, kShad)) && j1 >= 0) {
			setBlockAndNotifyAdequately(world, iShad, j1, kShad, LOTRMod.wood, 3)
			setGrassToDirt(world, iShad, j1 - 1, kShad)
			if (j1 <= jShad + 6) {
				setBlockAndNotifyAdequately(world, iShad, j1, kShad - 1, Blocks.ladder, 2)
			}
			--j1
		}
		setBlockAndNotifyAdequately(world, iShad, jShad + 1, kShad - 1, LOTRMod.trapdoorCharred, 0)
		setBlockAndNotifyAdequately(world, iShad, jShad + 7, kShad - 1, LOTRMod.trapdoorCharred, 0)
		placeOrcTorch(world, iShad - 3, jShad + 8, kShad - 3)
		placeOrcTorch(world, iShad - 3, jShad + 8, kShad + 3)
		placeOrcTorch(world, iShad + 3, jShad + 8, kShad - 3)
		placeOrcTorch(world, iShad + 3, jShad + 8, kShad + 3)
		setBlockAndNotifyAdequately(world, iShad, jShad + 12, kShad, LOTRMod.fence, 3)
		setBlockAndNotifyAdequately(world, iShad, jShad + 13, kShad, LOTRMod.fence, 3)
		setBlockAndNotifyAdequately(world, iShad, jShad + 12, kShad - 1, LOTRMod.fence, 3)
		setBlockAndNotifyAdequately(world, iShad, jShad + 12, kShad + 1, LOTRMod.fence, 3)
		setBlockAndNotifyAdequately(world, iShad - 1, jShad + 12, kShad, LOTRMod.fence, 3)
		setBlockAndNotifyAdequately(world, iShad + 1, jShad + 12, kShad, LOTRMod.fence, 3)
		placeOrcTorch(world, iShad, jShad + 14, kShad)
		placeOrcTorch(world, iShad, jShad + 13, kShad - 1)
		placeOrcTorch(world, iShad, jShad + 13, kShad + 1)
		placeOrcTorch(world, iShad - 1, jShad + 13, kShad)
		placeOrcTorch(world, iShad + 1, jShad + 13, kShad)
		var slaver: LOTREntityNPC = LOTREntityAngmarOrcMercenaryCaptain(world)
		slaver.setLocationAndAngles(iShad.toDouble() + 1.5, (jShad + 7).toDouble(), kShad.toDouble() + 1.5, 0.0f, 0.0f)
		slaver.onSpawnWithEgg(null as IEntityLivingData?)
		slaver.setPersistentAndTraderShouldRespawn()
		world.spawnEntityInWorld(slaver)
		slaver.setHomeArea(iShad, jShad + 6, kShad, 12)
		slaver = LOTREntityGundabadOrcMercenaryCaptain(world)
		slaver.setLocationAndAngles(iShad.toDouble() + 1.5, (jShad + 7).toDouble(), kShad.toDouble() + 1.5, 0.0f, 0.0f)
		slaver.onSpawnWithEgg(null as IEntityLivingData?)
		slaver.setPersistentAndTraderShouldRespawn()
		world.spawnEntityInWorld(slaver)
		slaver.setHomeArea(iShad, jShad + 6, kShad, 12)
		orcs = 2 + random.nextInt(3)
		l = 0
		while (l < orcs) {
			val orc = if (random.nextInt(2) == 0) LOTREntityAngmarOrc(world) else LOTREntityGundabadOrc(world)
			orc.setLocationAndAngles(iShad.toDouble() + 1.5, (jShad + 1).toDouble(), kShad.toDouble() + 1.5, 0.0f, 0.0f)
			orc.onSpawnWithEgg(null as IEntityLivingData?)
			orc.isNPCPersistent = true
			world.spawnEntityInWorld(orc)
			orc.setHomeArea(iShad, jShad + 1, kShad, 8)
			++l
		}
		return true
	}
}

