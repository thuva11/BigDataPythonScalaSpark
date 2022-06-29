package com.Revature

object RunStack extends App{
  val stack = new Stack[Int]
  stack.push(1)
  stack.push(2)
  println(stack.pop())  // prints 2
  println(stack.pop())  // prints 1
}
