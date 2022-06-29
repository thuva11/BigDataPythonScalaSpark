package com

class ExceptionExample {

  def validate(age:Int): Unit ={
    if(age<18){
      throw new InvalidAgeException("Not eligible", age)
    }else{
      println("You are eligible")
    }
  }
}
