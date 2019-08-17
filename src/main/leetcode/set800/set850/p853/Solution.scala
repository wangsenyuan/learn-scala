package set800.set850.p853

import scala.util.Sorting

object Solution {

  case class Car(position: Double, speed: Int, time: Double)

  def carFleet(target: Int, position: Array[Int], speed: Array[Int]): Int = {
    val n = position.length

    if (n == 0) {
      0
    } else {
      val cars = position.zip(speed).map(x => Car(x._1, x._2, 0))
      Sorting.quickSort(cars)(Ordering.fromLessThan((a, b) => a.position < b.position))
      var next = cars(n - 1)
      var ans = 1
      var i = n - 2
      while (i >= 0) {
        val catchingAtPos = catchingAt(cars(i), next)

        if (catchingAtPos <= target) {
          val t = (catchingAtPos - cars(i).position) / cars(i).speed
          next = Car(catchingAtPos, next.speed, t)
        } else {
          ans += 1
          next = cars(i)
        }

        i -= 1
      }

      ans
    }

  }

  private def catchingAt(a: Car, b: Car): Double = {
    if (a.speed <= b.speed) {
      Double.MaxValue
    } else {
      val ax = a.position + a.speed * b.time
      val bx = b.position
      val as = a.speed
      val bs = b.speed
      // (x - ax)/ sa = (x - bx) / sb
      // (sa - sb) x = sa * bx - sb * ax
      (as * bx - bs * ax) / (as - bs)
    }
  }
}
