package com

object Lab1 extends App{
  var x: Array[Array[Int]]=Array(Array(1,7),Array(2,9))
  var y: Array[Int] = x.flatten
  println(x.map(i=>i.toBuffer).toBuffer)


  var z: Int = x.flatten.reduce((x,y)=>x max y)
  println(z)

  import scala.collection.mutable.ListBuffer
  var LB1:ListBuffer[Int] = ListBuffer[Int]()
  y.foreach(elem => LB1 += elem)
  var qq= y.map(elem=>elem+1).filter(elem=>elem>2).foreach(elem => LB1 += elem)
  println(LB1)
  var List1:List[Int]= LB1.toList

  import scala.collection.mutable.ArrayBuffer
  var a: Array[Array[String]]=Array(Array("hello1", "hello2"), Array("hello with space", "hello again"))

  a.flatMap(e=>e++Array(" added to each of 2 Arrays"))
  a.map(e=>e++Array(" added to each of 2 Arrays")).flatten
}
