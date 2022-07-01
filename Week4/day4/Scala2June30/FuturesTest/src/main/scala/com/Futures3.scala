package com

import java.time.LocalDateTime
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global

object Futures3 {
  def taskHello: Future[Unit] = {

    Future{
      Thread.sleep(10000)
      printInfo("Starting Task-Hello")
      println("Hello")
      printInfo("Finished Task-Hello")

    }

  }

  def main(args: Array[String]): Unit = {
    printInfo("Start Program")
    val task: Future[Unit] = taskHello
    printInfo("Continue")
    Await.result(task, Duration.Inf)
    printInfo("Still Continue")
    new Job()
  }
  def printInfo(txt: String): Unit = {
    val thread = Thread.currentThread.getName
    println(s"${LocalDateTime.now} [$thread] $txt")
  }
}



