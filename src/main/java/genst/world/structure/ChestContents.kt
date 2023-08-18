package genst.world.structure

import lotr.common.LOTRMod
import lotr.common.world.structure.LOTRChestContents
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraft.util.WeightedRandomChestContent

object ChestContents {
	val TREASURE = LOTRChestContents(
		4, 8, arrayOf<WeightedRandomChestContent?>(
			WeightedRandomChestContent(ItemStack(LOTRMod.silverCoin, 1, 0), 1, 20, 200),
			WeightedRandomChestContent(ItemStack(LOTRMod.silverCoin, 1, 1), 1, 8, 20),
			WeightedRandomChestContent(ItemStack(LOTRMod.silverCoin, 1, 2), 1, 2, 5),
			WeightedRandomChestContent(ItemStack(Items.gold_nugget), 1, 5, 100),
			WeightedRandomChestContent(ItemStack(Items.gold_ingot), 1, 4, 75),
			WeightedRandomChestContent(ItemStack(LOTRMod.silverNugget), 1, 5, 100),
			WeightedRandomChestContent(ItemStack(LOTRMod.silver), 1, 4, 75),
			WeightedRandomChestContent(ItemStack(LOTRMod.mithrilNugget), 1, 3, 5),
			WeightedRandomChestContent(ItemStack(LOTRMod.daggerBronze), 1, 1, 25),
			WeightedRandomChestContent(ItemStack(LOTRMod.swordBronze), 1, 1, 25),
			WeightedRandomChestContent(ItemStack(LOTRMod.helmetBronze), 1, 1, 10),
			WeightedRandomChestContent(ItemStack(LOTRMod.bodyBronze), 1, 1, 10),
			WeightedRandomChestContent(ItemStack(LOTRMod.legsBronze), 1, 1, 10),
			WeightedRandomChestContent(ItemStack(LOTRMod.bootsBronze), 1, 1, 10),
			WeightedRandomChestContent(ItemStack(LOTRMod.daggerIron), 1, 1, 25),
			WeightedRandomChestContent(ItemStack(Items.iron_sword), 1, 1, 25),
			WeightedRandomChestContent(ItemStack(Items.iron_helmet), 1, 1, 10),
			WeightedRandomChestContent(ItemStack(Items.iron_chestplate), 1, 1, 10),
			WeightedRandomChestContent(ItemStack(Items.iron_leggings), 1, 1, 10),
			WeightedRandomChestContent(ItemStack(Items.iron_boots), 1, 1, 10),
			WeightedRandomChestContent(ItemStack(LOTRMod.daggerMithril), 1, 1, 1),
			WeightedRandomChestContent(ItemStack(LOTRMod.swordMithril), 1, 1, 1),
			WeightedRandomChestContent(ItemStack(LOTRMod.battleaxeMithril), 1, 1, 1),
			WeightedRandomChestContent(ItemStack(LOTRMod.hammerMithril), 1, 1, 1),
			WeightedRandomChestContent(ItemStack(LOTRMod.helmetMithril), 1, 1, 1),
			WeightedRandomChestContent(ItemStack(LOTRMod.bodyMithril), 1, 1, 1),
			WeightedRandomChestContent(ItemStack(LOTRMod.legsMithril), 1, 1, 1),
			WeightedRandomChestContent(ItemStack(LOTRMod.bootsMithril), 1, 1, 1),
			WeightedRandomChestContent(ItemStack(Items.arrow), 1, 8, 100),
			WeightedRandomChestContent(ItemStack(Items.skull), 1, 1, 100),
			WeightedRandomChestContent(ItemStack(Items.bone), 1, 4, 100),
			WeightedRandomChestContent(ItemStack(Items.glass_bottle), 1, 3, 20),
			WeightedRandomChestContent(ItemStack(Items.book), 1, 2, 20),
			WeightedRandomChestContent(ItemStack(LOTRMod.goldRing), 1, 1, 20),
			WeightedRandomChestContent(ItemStack(LOTRMod.silverRing), 1, 1, 20),
			WeightedRandomChestContent(ItemStack(LOTRMod.gobletGold), 1, 3, 20),
			WeightedRandomChestContent(ItemStack(LOTRMod.gobletSilver), 1, 3, 20),
			WeightedRandomChestContent(ItemStack(LOTRMod.gobletCopper), 1, 3, 20)
		)
	)
}