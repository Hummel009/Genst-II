package genst.instance

import lotr.common.world.structure2.LOTRWorldGenHighElvenTower
import lotr.common.world.structure2.LOTRWorldGenRivendellForge
import lotr.common.world.structure2.LOTRWorldGenRivendellHouse
import lotr.common.world.structure2.LOTRWorldGenStructureBase2
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*

class GenstRivendell : GenstLindon() {
	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> {
		return object : Instance(this, world, i, k, random, loc) {
			override fun getForge(): LOTRWorldGenStructureBase2 {
				return LOTRWorldGenRivendellForge(false)
			}

			override fun getHouse(): LOTRWorldGenStructureBase2 {
				return LOTRWorldGenRivendellHouse(false)
			}

			override fun getTower(): LOTRWorldGenStructureBase2 {
				return LOTRWorldGenHighElvenTower(false)
			}
		}
	}
}