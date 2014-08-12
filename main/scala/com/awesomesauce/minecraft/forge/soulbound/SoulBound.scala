package com.awesomesauce.minecraft.forge.soulbound

import com.awesomesauce.minecraft.forge.core.components.AwesomeSauceComponents
import com.awesomesauce.minecraft.forge.core.lib.TAwesomeSauceMod
import com.awesomesauce.minecraft.forge.core.lib.util.ItemUtil
import cpw.mods.fml.common.{ModMetadata, Mod}
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.item.{ItemStack, Item}

@Mod(modid="SoulBound", modLanguage="scala")
object SoulBound extends TAwesomeSauceMod {

  @EventHandler
  def aspri(e: FMLPreInitializationEvent) = super.awesomesaucepreinit(e)

  @EventHandler
  def asi(e: FMLInitializationEvent) = super.awesomesauceinit(e)

  @EventHandler
  def aspoi(e: FMLPostInitializationEvent) = super.awesomesaucepostinit(e)

  def getModID = "SoulBound"

  def getModName = "SoulBound"

  def getTextureDomain = "soulbound"

  def getTabIconItem = () => AwesomeSauceComponents.ingotPureAwesomeite

  @Mod.Metadata("SoulBound")
  var metadata: ModMetadata = null
  var soulKey: Item = null
  var pureSoulKey: Item = null
  var soulLock: Block = null
  var pureSoulLock: Block = null
  var decorative1: Block = null
  var decorative2: Block = null
  var decorative3: Block = null

  def init() = {
    decorative1 = ItemUtil.makeBlock(this, "decorative1", Material.rock).setBlockUnbreakable().setResistance(-1)
    decorative2 = ItemUtil.makeBlock(this, "decorative2", Material.rock).setBlockUnbreakable().setResistance(-1)
    decorative3 = ItemUtil.makeBlock(this, "decorative3", Material.rock).setBlockUnbreakable().setResistance(-1)
    soulKey = ItemUtil.makeItem(this, "soulKey")
    pureSoulKey = ItemUtil.makeItem(this, "pureSoulKey")
    soulLock = ItemUtil.makeBlock(this, "soulLock", Material.rock, () => new TileEntitySoulLock(new ItemStack(soulKey))).setBlockUnbreakable().setResistance(-1)
    pureSoulLock = ItemUtil.makeBlock(this, "pureSoulLock", Material.rock, () => new TileEntitySoulLock(new ItemStack(pureSoulKey))).setBlockUnbreakable().setResistance(-1)
  }

  def preInit() = {

  }

  def postInit() = {


  }
}
