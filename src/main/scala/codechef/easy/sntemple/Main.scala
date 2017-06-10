package codechef.easy.sntemple

import scala.io.StdIn

/**
  * Created by wangsenyuan on 10/06/2017.
  */
object Main {


  def solve() = {
    val n = StdIn.readInt()
    val h = StdIn.readLine().split("\\s+").map(_.toInt)
    val sum = h.map(_.toLong).sum


    def check(m: Int): Boolean = {
      val left = Array.fill(n)(false)

      var k = 0
      var i = 0
      while (i < n) {
        if (h(i) > k) {
          k += 1
          if (k == m) {
            left(i) = true
            k -= 1
          }
        } else {
          k = h(i)
        }

        i += 1
      }
      val right = Array.fill(n)(false)
      k = 0
      i = n - 1
      while (i >= 0) {
        if (h(i) > k) {
          k += 1
          if (k == m) {
            right(i) = true
            k -= 1
          }
        } else {
          k = h(i)
        }
        i -= 1
      }
      var found = false
      i = 0
      while (i < n && !found) {
        found = left(i) && right(i)
        i += 1
      }

      found
    }

    var left = 1
    var right = n + 1
    while (left < right) {
      val mid = left + (right - left) / 2
      if (!check(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }

    val tmp = (left - 1).toLong

    println(sum - tmp * tmp)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }
}
