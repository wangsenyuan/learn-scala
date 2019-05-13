package set600.set640.p646

import scala.util.Sorting

object Solution {
  def findLongestChain(pairs: Array[Array[Int]]): Int = {


    Sorting.quickSort(pairs)(new Ordering[Array[Int]]() {
      override def compare(x: Array[Int], y: Array[Int]): Int = {
        if (x(1) < y(1)) {
          -1
        } else if (x(1) > y(1)) {
          1
        } else {
          0
        }
      }
    })
    var ans = 0
    var prev = Int.MinValue
    var i = 0
    while(i < pairs.length) {
      val x = pairs(i)(0)
      val y = pairs(i)(1)

      if(x > prev) {
        ans += 1
        prev = y
      }

      i += 1
    }

    ans
  }
}
