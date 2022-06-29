package com

class InvalidAgeException(s:String, i: Int) extends Exception(s){
  println("this exception thrown")
  if (i == 17){
    println("so close")
  }else{
    println("not fooled")
  }
}
