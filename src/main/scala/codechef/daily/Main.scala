package codechef.daily

import scala.io.StdIn

/**
  * Created by wangsenyuan on 30/12/2016.
  */
object Main {

  val C = Array.fill(7, 7)(0)

  C(0)(0) = 1

  var i = 1
  while (i <= 6) {
    C(i)(0) = 1
    var j = 1
    while (j < i) {
      C(i)(j) = C(i - 1)(j - 1) + C(i - 1)(j)
      j += 1
    }

    C(i)(i) = 1

    i += 1
  }

  class Compartment(val i: Int, val allSeats: String) {
    private val start = 4 * i + 1
    private val end = 54 - 2 * i
    private val places = Array(start, start + 1, start + 2, start + 3, end - 1, end)

    def freePlaceNumber = places.map(x => allSeats(x - 1)).count(_ == '0')
  }

  class Car(val places: String) {
    private val compartment = (0 until 9).map(new Compartment(_, places)).toArray

    def groupSellWays(x: Int): Int = {
      val free = compartment.map(_.freePlaceNumber).filter(_ >= x)
      free.foldLeft(0) {
        (res, y) => res + C(y)(x)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val x = firstLine(0)
    var n = firstLine(1)
    var cars = List.empty[Car]

    while (n > 0) {
      cars = (new Car(StdIn.readLine())) :: cars
      n -= 1
    }

    val y = cars.foldLeft(0)(_ + _.groupSellWays(x))

    println(y)
  }
}
