package set800.set820.p825

import java.util

import scala.util.Sorting

object Solution {
  def numFriendRequests(ages: Array[Int]): Int = {
    Sorting.quickSort(ages)

    val sums = new util.TreeMap[Int, Int]()
    sums.put(0, 0)

    val n = ages.length
    var i = 0
    while(i < n) {
      sums.put(ages(i), i + 1)
      i += 1
    }

    var res = 0
    i = n - 1
    while(i >= 0) {
      val a = ages(i)
      // a will only friend b, with b <= a  and b >= a * 0.5 + 7
      val c = a / 2 + 7


      if(c <= a) {
        val cy = sums.floorEntry(c)
        val cx = sums.ceilingEntry(a)

        if(cx.getValue > cy.getValue) {
          res += cx.getValue - cy.getValue - 1
        }
      }

      i -= 1
    }

    res
  }
}
