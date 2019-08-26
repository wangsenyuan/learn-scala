package set0000.set400.set450.p455

import scala.util.Sorting

object Solution {
  def findContentChildren(g: Array[Int], s: Array[Int]): Int = {
    Sorting.quickSort(g)
    Sorting.quickSort(s)

    var i = 0
    var j = 0
    var res = 0
    while(i < g.length && j < s.length) {
      if(s(j) >= g(i)) {
        res += 1
        j += 1
        i += 1
      } else {
        j += 1
      }
    }

    res
  }
}
