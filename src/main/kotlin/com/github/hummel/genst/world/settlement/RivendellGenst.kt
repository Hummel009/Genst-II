package com.github.hummel.genst.world.settlement

import com.github.hummel.genst.world.structure.RivendellTower
import lotr.common.world.structure2.LOTRWorldGenRivendellForge
import lotr.common.world.structure2.LOTRWorldGenRivendellHouse
import lotr.common.world.structure2.LOTRWorldGenStructureBase2
import lotr.common.world.village.LocationInfo
import net.minecraft.world.World
import java.util.*

class RivendellGenst : LindonGenst() {
	override fun createVillageInstance(
		world: World, i: Int, k: Int, random: Random, loc: LocationInfo
	): AbstractInstance<*> {
		return object : Instance(this, world, i, k, random, loc) {
			override fun getForge(): LOTRWorldGenStructureBase2 = LOTRWorldGenRivendellForge(false)

			override fun getHouse(): LOTRWorldGenStructureBase2 = LOTRWorldGenRivendellHouse(false)

			override fun getTower(): LOTRWorldGenStructureBase2 = RivendellTower()
		}
	}
}