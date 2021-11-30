package Assignment1

object Task3 extends App{
  def summ (param1: Array[Int],param2: Array[Int]) ={

   val sum_arrays = param1.zip(param2).map{case(i,j) => i + j}
    if(param1.length == param2.length)
    println(sum_arrays.mkString(" "))
    else println("Sum can not be performed ")
  }
  val arr1 = Array(1,2,3)
  val arr2 = Array(4,5,6)
  //val sum_of_lists = List(1,2,3).flatMap(num => List(4,5,6).map(num2 => num + num2))
  val result1 = summ(arr1,arr2)

 // def summ(val arr1:Array[Int],val arr2: Array[Int]): Array[Int]{

}
