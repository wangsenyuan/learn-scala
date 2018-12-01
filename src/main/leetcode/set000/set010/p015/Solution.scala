package set000.set010.p015

import scala.collection.mutable.ListBuffer

object Solution {

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    if (nums == null || nums.size == 0) {
      return List.empty
    } else {
      val xs = nums.sorted
      val res = ListBuffer.empty[List[Int]]
      val n = xs.length

      def twoSum(num: Int, left: Int) = {
        var i = left + 1
        var j = n - 1
        while (i < j) {
          if (i > left + 1 && xs(i) == xs(i - 1)) {
            i += 1
          } else if (j < n - 1 && xs(j) == xs(j + 1)) {
            j -= 1
          } else {
            val sum = xs(i) + xs(j)
            if (sum > num) {
              j -= 1
            } else if (sum < num) {
              i += 1
            } else {
              res += List(-num, xs(i), xs(j))
              i += 1
              j -= 1
            }
          }

        }
      }

      for {
        i <- 0 until n
        if (i == 0 || xs(i) > xs(i - 1))
      } {
        twoSum(-xs(i), i)
      }
      res.toList
    }
  }

  def threeSum1(nums: Array[Int]): List[List[Int]] = {
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
              //first value that greater than s
              val k = binarySearch(xs.length, xs(_) > s) - 1
              if (k < xs.length && k > j && xs(k) == s) {
                res += List(xs(i), xs(j), xs(k))
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
