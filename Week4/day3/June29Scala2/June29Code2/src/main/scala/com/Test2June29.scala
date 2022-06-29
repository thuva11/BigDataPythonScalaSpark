package com

object Test2June29 extends App {
  //exception will always be thrown
  try{
    throw new Exception("Failed")
  } catch{
    case _: Throwable => println("An exception occurred")
  }

  //for Exception example
  var e = new ExceptionExample()
  try{
    e.validate(17)
  }catch{
    case e: Exception => println("Exception Occured:"+ e)
  }


}
