package Assignment1

object Ex2 extends App{
  //MUTABLE MAP FUNCTION
  var person_age1 : Map[String , Int] = {
    Map(("Alina",18), ("Urwah",17),("Maheen",14))

  }
  person_age1 += ("Ahmed"->15)

  //IMMUTABLE MAP FUNCTION
  val person_age : Map[String, Int] = {
    Map(("Nabah",20), ("Ayesha", 5),("Bilal",19))
      }
  println(person_age)
  println((person_age1))

  //*** IMMUTABLE SET FUNCTION ***
  val setss = Set(5,6,7,8,6,7)
  println(setss)
  //It will promt an error
  //setss += 10

  //But we can do it by initializing a new variable
  val addedset = setss + 10
  println(addedset)

  //*** MUTABLE SET FUNCTION ***
  var sets2 = Set(7,8,9)
  sets2 += 10
  println(sets2)
}

