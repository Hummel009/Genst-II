package com.github.hummel.genst.structure

import lotr.common.LOTRMod
import lotr.common.entity.LOTREntityNPCRespawner
import lotr.common.entity.npc.LOTREntityGundabadOrc
import lotr.common.entity.npc.LOTREntityGundabadWarg
import lotr.common.entity.npc.LOTREntityNPC
import lotr.common.item.LOTRItemBanner
import lotr.common.world.structure.LOTRChestContents
import lotr.common.world.structure2.LOTRWorldGenWargPitBase
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*

class StructureGundabadWargPit(flag: Boolean) : LOTRWorldGenWargPitBase(flag) {
	override fun setupRandomBlocks(random: Random) {
		super.setupRandomBlocks(random)
		brickBlock = LOTRMod.brick
		brickMeta = 6
		brickSlabBlock = LOTRMod.slabSingle
		brickSlabMeta = 6
		brickStairBlock = LOTRMod.stairsDwarvenBrick
		brickWallBlock = LOTRMod.wall
		brickWallMeta = 7
		pillarBlock = LOTRMod.pillar
		pillarMeta = 0
		woolBlock = Blocks.wool
		woolMeta = 15
		carpetBlock = Blocks.carpet
		carpetMeta = 15
		tableBlock = LOTRMod.gundabadTable
		banner = LOTRItemBanner.BannerType.GUNDABAD
		chestContents = LOTRChestContents.GUNDABAD_TENT
	}

	override fun getOrc(world: World): LOTREntityNPC = LOTREntityGundabadOrc(world)

	override fun getWarg(world: World): LOTREntityNPC = LOTREntityGundabadWarg(world)

	override fun setOrcSpawner(spawner: LOTREntityNPCRespawner) {
		spawner.setSpawnClass(LOTREntityGundabadOrc::class.java)
	}

	override fun setWargSpawner(spawner: LOTREntityNPCRespawner) {
		spawner.setSpawnClass(LOTREntityGundabadWarg::class.java)
	}

	override fun associateGroundBlocks() {
		super.associateGroundBlocks()
		clearScanAlias("GROUND_COVER")
		addBlockMetaAliasOption("GROUND_COVER", 1, Blocks.snow_layer, 0)
		setBlockAliasChance("GROUND_COVER", 0.25f)
	}
}