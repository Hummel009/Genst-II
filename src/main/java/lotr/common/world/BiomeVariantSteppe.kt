package lotr.common.world

import lotr.common.world.biome.variant.LOTRBiomeVariant

object BiomeVariantSteppe : LOTRBiomeVariant(52, "steppe", VariantScale.LARGE) {
	init {
		setTemperatureRainfall(0.0F, -0.1F)
		setHeight(0.0F, 0.1F)
		setTrees(0.01F)
		setGrass(3.0F)
		setFlowers(0.8F)
		disableStructures = true
	}
}