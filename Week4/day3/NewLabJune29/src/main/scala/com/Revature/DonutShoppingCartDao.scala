package com.Revature

trait DonutShoppingCartDao[A] {

  def add(donut: A): Long

  def update(donut: A): Boolean

  def search(donut: A): A

  def delete(donut: A): Boolean
}
