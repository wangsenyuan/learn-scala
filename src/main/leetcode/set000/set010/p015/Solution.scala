package set000.set010.p015

import scala.collection.mutable.ListBuffer

object Solution {

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    if (nums == null || nums.size == 0) {
      List.empty
    } else {
      val xs = nums.sorted

      val res = ListBuffer.empty[List[Int]]

      var i = 0
      while (i < xs.length) {
        if (i == 0 || xs(i) != xs(i - 1)) {
          var j = i + 1
          while (j < xs.length) {
            val s = -(xs(i) + xs(j))
            if (j == i + 1 || xs(j) != xs(j - 1)) {
              val b = binarySearch(xs.length, xs(_) > s)
              val a = binarySearch(xs.length, xs(_) >= s)
              val c = (j + 1) max a
              var k = c
              while (k < b) {
                if (k == c || xs(k) != xs(k - 1)) {
                  res += List(xs(i), xs(j), xs(k))
                }

                k += 1
              }
            }
            j += 1
          }
        }

        i += 1
      }

      res.toList
    }
  }

  def binarySearch(n: Int, f: Int => Boolean): Int = {
    var left = 0
    var right = n
    while (left < right) {
      val mid = (left + right) >> 1
      if (f(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    left
  }
}
