package com.Revature

import java.util.Scanner
import scala.io.StdIn

object ReadInp extends App{
  var scanner = new Scanner(System.in)
  println("Enter Username")

  var userName:String = scanner.nextLine()

  println("Username is: "+ userName)

  var line = StdIn.readLine()
  println(line)
}
