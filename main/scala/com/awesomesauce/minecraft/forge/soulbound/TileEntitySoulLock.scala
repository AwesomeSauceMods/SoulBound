package com.awesomesauce.minecraft.forge.soulbound

import com.awesomesauce.minecraft.forge.core.lib.item.TActivatedTileEntity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.item.{ItemStack, Item}
import net.minecraft.tileentity.TileEntity

class TileEntitySoulLock(key: ItemStack) extends TileEntity with TActivatedTileEntity {
  def activate(player:EntityPlayer, side:Int, partx: Float, party: Float, partz: Float) : Boolean = {
    if (key.isItemEqual(player.inventory.getCurrentItem))
    {
      player.inventory.getCurrentItem.stackSize -= 1
      worldObj.setBlock(xCoord, yCoord, zCoord, Blocks.air)
      return true
    }
    return false
  }
}
