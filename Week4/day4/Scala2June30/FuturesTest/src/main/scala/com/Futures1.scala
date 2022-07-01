package com

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Futures1 extends App{
  val firstNum=5
  val secondNum=6
  val addition = Future {
    Thread.sleep(500)
    firstNum+secondNum
  }
  new Job
  Thread.sleep(1000)
  println(addition.isCompleted)
  println(addition.value)
  new Job



}
