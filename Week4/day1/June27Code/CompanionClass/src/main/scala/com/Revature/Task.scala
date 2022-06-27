package com.Revature

class Task{
  private var _status: String = "pending"
  var description: String = ""
  def status(): String = {_status}
}
object Task {
  def apply(description:String):Task =
    {val task2 = new Task
    task2.description=description
      task2
    }

}
