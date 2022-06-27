package com.Revature

object TaskRunner {
  def createPerson(person:Person): List[Any] ={
    val pList=List(person.name,person.age)
    pList
  }
  def main(args:Array[String]): Unit = {
    //println("hello world")
    val T1 = Task.apply("1st task to complete")
    println(T1.description)
    println(T1.status())

    val x=Person("Jon",22)
    println(createPerson(x))
  }


}
