package set400.set470.p475

import scala.util.Sorting

object Solution {
  def findRadius(houses: Array[Int], heaters: Array[Int]): Int = {
    Sorting.quickSort(houses)
    Sorting.quickSort(heaters)

    var res = 0
    var i = 0
    var j = 0
    while (j < heaters.length) {
      val h = heaters(j)
      // find the radius for this heater
      while (i < houses.length && houses(i) < h) {
        // before pos
        res = res max (h - houses(i))
        i += 1
      }

      val k = j + 1
      while (i < houses.length && (k == heaters.length || (heaters(k) - houses(i) > houses(i) - h))) {
        res = res max (houses(i) - h)
        i += 1
      }

      j += 1
    }

    res
  }
}
