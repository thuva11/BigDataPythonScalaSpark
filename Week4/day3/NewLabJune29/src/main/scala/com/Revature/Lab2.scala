package com.Revature

object Lab2 {
  def main(args: Array[String])
  {
    val name = Map("abc" -> "author","pqr" -> "coder")


    val x = name.get("abc")
    val y = name.get("xyz")


    println(x)
    println(y)
    println(name("abc"))
    println(name("xyz"))
  }

}
