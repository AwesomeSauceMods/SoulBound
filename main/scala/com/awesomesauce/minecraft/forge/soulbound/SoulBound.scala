package com.awesomesauce.minecraft.forge.soulbound

import com.awesomesauce.minecraft.forge.core.components.AwesomeSauceComponents
import com.awesomesauce.minecraft.forge.core.lib.TAwesomeSauceMod
import com.awesomesauce.minecraft.forge.core.lib.util.ItemUtil
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.{Mod, ModMetadata}
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.item.{Item, ItemStack}

import scala.collection.mutable.ArrayBuffer

@Mod(modid="SoulBound", modLanguage="scala")
object SoulBound extends TAwesomeSauceMod {

  var decorativeCount = 3
  var soulLockCount = 2
  @Mod.Metadata("SoulBound")
  var metadata: ModMetadata = null
  var soulKey: ArrayBuffer[Item] = ArrayBuffer[Item]()
  var soulLock: ArrayBuffer[Block] = ArrayBuffer[Block]()
  var decorative: ArrayBuffer[Block] = ArrayBuffer[Block]()

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
  def init() = {
  }

  def preInit() = {
    decorativeCount = config.get("general", "decorativeCount", 3).getInt
    soulLockCount = config.get("general", "soulLockCount", 2).getInt
    for (i <- Range(0, decorativeCount))
      decorative append ItemUtil.makeBlock(this, "decorative" + (i + 1).toString, Material.rock).setBlockUnbreakable().setResistance(-1)
    for (i <- Range(0, soulLockCount)) {
      val key = ItemUtil.makeItem(this, "soulKey" + (i + 1).toString)
      soulKey append key
      soulLock append ItemUtil.makeBlock(this, "soulLock" + (i + 1).toString, Material.rock, () => new TileEntitySoulLock(new ItemStack(key))).setBlockUnbreakable().setResistance(-1)
    }
  }

  def postInit() = {


  }
}
