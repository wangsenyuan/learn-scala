package set1000.set1300.set1320.p1326

import scala.util.Sorting

object Solution {
  def minTaps(n: Int, ranges: Array[Int]): Int = {
    val taps = Array.ofDim[Tap](n + 1)

    var i = 0
    while (i <= n) {
      val left = i - ranges(i)
      val right = i + ranges(i)
      taps(i) = Tap(left, right)
      i += 1
    }

    // right asc
    Sorting.quickSort(taps)(Ordering.by(_.right))

    /**
     * following arr is for min-value segment-tree
     */
    val m = n + 1

    val arr = Array.fill(2 * (m + 1))(Int.MaxValue)

    def update(pos: Int, v: Int): Unit = {
      var p = pos + m
      arr(p) = arr(p) min v
      while (p > 1) {
        arr(p >> 1) = arr(p) min arr(p ^ 1)
        p >>= 1
      }
    }

    def getRange(left: Int, right: Int): Int = {
      var x = left + m
      var y = right + m
      var res = Int.MaxValue
      while (x < y) {

        if ((x & 1) == 1) {
          res = res min arr(x)
          x += 1
        }

        if ((y & 1) == 1) {
          y -= 1
          res = res min arr(y)
        }

        x >>= 1
        y >>= 1
      }

      res
    }

    var ans = -1

    //    val dp = Array.ofDim[Int](n + 1)
    i = 0
    while (i <= n) {
      val item = taps(i)
      var cur = -1
      if (item.left <= 0) {
        // no more item need to cover left
        cur = 1
      } else {
        val j = search(i, taps(_).right >= taps(i).left)

        if (j == i) {
          // this one is a invalid option
        } else {
          val x = getRange(j, i)
          cur = x + 1
        }
      }

      if (cur > 0) {
        update(i, cur)
      }

      if (item.right >= n && cur > 0) {
        if (ans == -1 || ans > cur) {
          ans = cur
        }
      }

      i += 1
    }

    ans
  }

  case class Tap(left: Int, right: Int)

  private def search(n: Int, fn: Int => Boolean): Int = {
    var left = 0
    var right = n
    while (left < right) {
      val mid = (left + right) / 2
      if (fn(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    right
  }
}
