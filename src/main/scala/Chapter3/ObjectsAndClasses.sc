//3.1.6.1
class Cat(val name: String, val color: String, val food: String)

val oswald = new Cat("Oswald", "Black", "Milk")
val henderson = new Cat("Henderson", "Ginger", "Chips")
val quentin = new Cat("Quentin", "Tabby and white", "Curry")

//3.1.6.2
object ChipShop {
  def willServe(c: Cat): Boolean = if(c.food == "Chips") true else false
}

//3.1.6.3
class Director(val firstName: String, val lastName: String, val yearOfBirth: Int) {
  def name(): String = s"$firstName $lastName"
  def copy(fn: String = firstName, ln: String = lastName, y: Int = yearOfBirth) = new Director(fn,ln,y)
}

class Film(val name: String, val yearOfRelease: Int, val imbdRating: Double, val filmDirector: Director){
  def directorsAge(): Int = yearOfRelease - filmDirector.yearOfBirth
  def isDirectedBy(d: Director): Boolean = if(d.name == filmDirector.name) true else false
  def copy(n: String = name, y: Int = yearOfRelease, r: Double = imbdRating, d: Director = filmDirector): Film = new Film(n,y,r,d)
}

val eastwood = new Director("Clint", "Eastwood", 1930)
val mcTiernan = new Director("John", "McTiernan", 1951)
val nolan = new Director("Christopher", "Nolan", 1970)
val someBody = new Director("Just", "Some Body", 1990)
val memento = new Film("Memento", 2000, 8.5, nolan)
val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
val inception = new Film("Inception", 2010, 8.8, nolan)
val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
val invictus = new Film("Invictus", 2009, 7.4, eastwood)
val predator = new Film("Predator", 1987, 7.9, mcTiernan)
val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

println(eastwood.yearOfBirth == 1930)
println(dieHard.filmDirector.name == "John McTiernan")
println(!invictus.isDirectedBy(nolan))

//3.1.6.4
class Counter(val count: Int) {
  //3.1.6.5
  def inc(i: Int = 1): Counter = new Counter(count+i)
  def dec(i: Int = 1): Counter = new Counter(count-i)

  //3.1.6.6
  def adjust(a: Adder): Counter = new Counter(a.add(count))
}

class Adder(amount: Int) {
  def add(in: Int) = in + amount
}

//3.2.3.1
// It's missing types for the functions

//3.3.2.1
class Person(val firstName: String, val lastName: String)

object Person {
  def apply(fullName: String): Person = {
    val names = fullName.split(" ")
    new Person(names(0), names(1))
  }
}

//3.3.2.2
object Director {
  def apply(fn: String, ln: String, yob: Int): Director = new Director(fn,ln,yob)
  def older(d1: Director, d2: Director): Director = if(d1.yearOfBirth < d2.yearOfBirth) d1 else d2
}

object Film {
  def apply(n: String, yor: Int, r: Double, d: Director) = new Film(n,yor,r,d)
  def highestRating(f1: Film, f2: Film): Film = if(f1.imbdRating > f2.imbdRating) f1 else f2
  def oldestDirectorAtTheTime(f1: Film, f2: Film): Director = if(f1.directorsAge > f2.directorsAge) f1.filmDirector else f2.filmDirector
}

//3.3.2.3
/*
* val prestige: Film = bestFilmByChristopherNolan() : TYPE
* new Film("Last Action Hero", 1993, mcTiernan) : TYPE
* Film("Last Action Hero", 1993, mcTiernan) : VALUE
* Film.newer(highPlainsDrifter, thomasCrownAffair) : VALUE
* Film.type : VALUE
* */

//3.4.5.1
case class Cats(name: String, color: String, food: String)

//3.4.5.2
case class Directors(firstName: String, lastName: String, yearOfBirth: Int) {
  def name(): String = s"$firstName $lastName"
}
object Directors {
  def older(d1: Directors, d2: Directors): Directors = if(d1.yearOfBirth < d2.yearOfBirth) d1 else d2
}

case class Films(name: String, yearOfRelease: Int, imbdRating: Double, filmDirector: Directors) {
  def directorsAge(): Int = yearOfRelease - filmDirector.yearOfBirth
  def isDirectedBy(d: Directors): Boolean = if(d.name == filmDirector.name) true else false
}

object Films {
  def highestRating(f1: Films, f2: Films): Films = if(f1.imbdRating > f2.imbdRating) f1 else f2
  def oldestDirectorAtTheTime(f1: Films, f2: Films): Directors = if(f1.directorsAge > f2.directorsAge) f1.filmDirector else f2.filmDirector
}

//3.4.5.3
case class Counter2(count: Int = 0) {
  def inc(i: Int = 1): Counter2 = copy(count+i)
  def dec(i: Int = 1): Counter2 = copy(count-i)

  def adjust(a: Adder): Counter2 = copy(a.add(count))
}

//3.4.5.4
case class Persons(firstName: String, lastName: String) {
  def name = firstName + " " + lastName
}
object Persons {
  def apply(name: String): Persons = {
    val parts = name.split(" ")
    apply(parts(0), parts(1))
  }
}

//3.5.3.1
object ChipShop2 {
  def willServe(c: Cats): Boolean = c match {
    case Cats(_,_,"Chips") => true
    case _ => false
  }
}

//3.5.3.2
object Dad {
  def rate(film: Films): Double = film.filmDirector match {
    case Directors("Clint","Eastwood",_) => 10.0
    case Directors("John", "McTiernan", _) => 7.0
    case _ => 3.0
  }
}

