package genst.world.structure

import lotr.common.world.structure2.LOTRWorldGenStructureBase2
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*

@Suppress("LoopToCallChain")
object StructureErech : LOTRWorldGenStructureBase2(true) {
	override fun generateWithSetRotation(world: World, random: Random, x: Int, y: Int, z: Int, rot: Int): Boolean {
		val radius = 8
		for (i in x - radius..x + radius) {
			for (j in y - radius..y + radius) {
				for (k in z - radius..z + radius) {
					if ((i - x) * (i - x) + (j - y) * (j - y) + (k - z) * (k - z) <= radius * radius) {
						setBlockAndNotifyAdequately(world, i, j, k, Blocks.stained_hardened_clay, 15)
					}
				}
			}
		}
		return true
	}
}