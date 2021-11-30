package Assignment1

object Task5 extends  App{
  var lst = List(1,2,3,4,5)
  def func(x:Int): Boolean =
    x % 2 == 0
 // Map(lst,func)
  def buildMap[A,B](data: Seq[A],f:A=>B) = {
    //val bmap = Map(data ->f)
    val bmap = data.map(f)
    println(bmap)
  }
  val result = buildMap(lst,func)

}
