package Assignment1

object Ex1 extends App {
  //**** 1st Method ****
  val array1:Array[String] = Array("jan", "feb", "march", "april", "may")
  //val array1 = Array(1,2,3)
  //**** 2nd Method ****
    var array2 = new Array[String](5)
    array2(0) = "jan"
    array2(1) = "feb"
    array2(2) = "march"
    array2(3) = "April"
    array2(4) = "may"

  println(array1)
  println(array2.mkString(" "))

  }