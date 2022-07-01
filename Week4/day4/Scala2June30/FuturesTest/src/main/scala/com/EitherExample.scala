package com

object EitherExample extends App
{
  def Name(name: String): Either[String,String]={
  if (name.isEmpty)
    Left("No Name")
  else
    Right(name)
}
  println(Name("Will"))
  println(Name(""))


  var x = Name("Will").getOrElse("right")
  println(x)
  var y =Name(name= "").getOrElse("")
  println(y)
}
