package genst.instance

import lotr.common.world.biome.LOTRBiome
import lotr.common.world.map.LOTRRoadType
import lotr.common.world.structure2.LOTRWorldGenStructureBase2
import lotr.common.world.village.LOTRVillageGen
import lotr.common.world.village.LocationInfo
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*

class GenstErech(biome: LOTRBiome, f: Float) : LOTRVillageGen(biome) {
	init {
		gridScale = 10
		gridRandomDisplace = 1
		spawnChance = f
		villageChunkRadius = 2
	}

	override fun createVillageInstance(
		world: World,
		i: Int,
		k: Int,
		random: Random,
		loc: LocationInfo
	): AbstractInstance<*> {
		return Instance(this, world, i, k, random, loc)
	}

	class Instance(
		village: GenstErech?,
		world: World?,
		i: Int,
		k: Int,
		random: Random?,
		loc: LocationInfo?
	) : AbstractInstance<GenstErech?>(village, world, i, k, random, loc) {
		override fun addVillageStructures(random: Random) {
			addStructure(Erech, 0, 0, 0, true)
		}

		override fun getPath(random: Random, i: Int, k: Int): LOTRRoadType? {
			return null
		}

		override fun isFlat(): Boolean {
			return false
		}

		override fun isVillageSpecificSurface(world: World, i: Int, j: Int, k: Int): Boolean {
			return false
		}

		override fun setupVillageProperties(random: Random) {}
	}

	object Erech : LOTRWorldGenStructureBase2(true) {
		override fun generateWithSetRotation(world: World, random: Random, x: Int, y: Int, z: Int, rot: Int): Boolean {
			val radius = 10
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
}