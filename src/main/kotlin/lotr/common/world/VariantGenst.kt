package lotr.common.world

import lotr.common.world.biome.LOTRBiome
import lotr.common.world.biome.LOTRBiomeDecorator
import lotr.common.world.biome.variant.LOTRBiomeVariant
import lotr.common.world.village.LOTRVillageGen
import net.minecraft.world.World
import java.util.*
import kotlin.math.abs


object VariantGenst : LOTRBiomeVariant(52, "steppe", VariantScale.LARGE) {
	init {
		setTemperatureRainfall(0.0f, -0.1f)
		setHeight(0.0f, 0.1f)
		disableStructuresVillages()
		setTrees(0.01F)
		setGrass(3.0F)
		setFlowers(0.8F)
	}

	@Suppress("UNCHECKED_CAST")
	override fun decorateVariant(world: World, random: Random, i: Int, k: Int, biome: LOTRBiome) {
		if (abs(i) > 32 && abs(k) > 32) {
			val decorator = biome.decorator
			val villagesField = LOTRBiomeDecorator::class.java.getDeclaredField("villages")
			villagesField.isAccessible = true
			val villagesValue = villagesField.get(decorator) as ArrayList<LOTRVillageGen>

			for (village in villagesValue) {
				village.generateInChunk(world, i, k)
			}
		}
	}
}