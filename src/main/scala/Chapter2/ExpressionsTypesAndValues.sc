//2.1.4.1
/*
* 1 + 2 : Int
 "3".toInt : Int
 "foo".toInt : Int but exception thrown
* */

//2.1.5.1
"foo" take 1
1.+(2).+(3)

//2.2.5.2
//Both have same result type and value but they get there in different ways.

//2.3.8.1
/*
* 42 : Int
  true : Boolean
  123L : Long
  42.0 : Double
* */

//2.3.8.2
// 'a' is a char which can only hold a single character and "a" is a string which can hold many

//2.3.8.3
/*
* "Hello world!" is a String
* println("Hello world!") is a Unit the prints out a string to console
* */

//2.3.8.4
//'Hello world!' : Doesn't compile! error thrown

//2.4.5.1
object Oswald {
  val color: String = "Black"
  val food: String = "Milk"
}
object Henderson {
  val color: String = "Ginger"
  val food: String = "Chips"
}
object Quentin {
  val color: String = "Tabby and white"
  val food: String = "Curry"
}

//2.4.5.2
object calc {
  def square(d: Double): Double = d*d
  def cube(d: Double): Double = d * square(d)

  //2.4.5.3
  def square(d: Int): Int = d*d
  def cube(d: Int): Int = d * square(d)
}

//2.4.5.4
// result is a string "3c31"
//the following sequence of println's are displayed
/*
b
a
c
a
a*/

//2.4.5.5 The type is string and no it only caters for the person class type
object Person {
  val firstName: String = "Lorenzo"
  val lastName: String = "Prinsloo"
}

object Alien {
  def greet(p: Person.type): String = {
    s"${p.firstName} ${p.lastName} all your base are belong to us!"
  }
}

//2.4.5.6
//calls to methods are expressions but methods by themselves are not expressions

//2.6.4.1
//if(1 > 2) "alien" else "predator" RESULT String value of "predator"
//2.6.4.2
//if(1 > 2) "alien" else 2001 RESULT Any value of 2001
//if(false) "hello" RESULT Any of ()



