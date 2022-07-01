package com

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure,Success}

object Futures2 extends App {
  val firstNum: Int = 5
  val secondNum: Int= 0
  val addition = Future {
    Thread.sleep(500)
    firstNum/secondNum
  }
  new Job
  Thread.sleep(1000)
  addition.onComplete {
    case Success(value) => println("addition=" + value)
    case Failure(e) => println("not complete yet"+ e)
  }
  new Job
}
