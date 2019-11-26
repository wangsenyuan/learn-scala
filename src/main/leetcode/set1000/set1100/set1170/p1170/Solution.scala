package set1000.set1100.set1170.p1170

import scala.util.Sorting

object Solution {
  def numSmallerByFrequency(queries: Array[String], words: Array[String]): Array[Int] = {
    val qs = queries.map(f)
    val ws = words.map(f)
    Sorting.quickSort(ws)

    val ans = Array.ofDim[Int](qs.length)

    for {
      i <- 0 until qs.length
    } {
      val q = qs(i)
      val j = search(ws.length, ws(_) > q)
      ans(i) = ws.length - j
    }
    ans
  }

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

  private def f(s: String): Int = {
    val x = s.min
    s.count(_ == x)
  }
}
