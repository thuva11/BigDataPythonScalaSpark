package com.Revature

trait DonutInventoryService[A] {

  def checkStockQuantity(donut: A): Int

}
