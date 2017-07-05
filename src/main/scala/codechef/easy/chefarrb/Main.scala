package codechef.easy.chefarrb

import scala.io.StdIn

/**
  * Created by wangsenyuan on 05/07/2017.
  */
object Main {

  def compare(k: Int, cnt: Array[Int]): Int = {
    var i = 31
    while (i >= 0) {
      if ((k & (1 << i)) > 0) {
        if (cnt(i) == 0) {
          // k > cnt
          return 1
        }
      } else {
        if (cnt(i) > 0) {
          // k < cnt
          return -1
        }
      }

      i -= 1
    }
    return 0
  }

  def solve() = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val K = firstLine(1)

    val nums = StdIn.readLine().split("\\s+").map(_.toInt)

    var i = 0
    var j = 0

    var ans = 0L
    val cnt = Array.fill(32)(0)

    while (i < n) {
      while (j < n && compare(K, cnt) > 0) {
        val num = nums(j)
        var k = 0

        while (k < 32) {
          if ((num & (1 << k)) > 0) {
            cnt(k) += 1
          }

          k += 1
        }
        j += 1
      }

      if (compare(K, cnt) <= 0) {
        ans += n - j + 1
      }

      var k = 0
      while (k < 32) {
        if ((nums(i) & (1 << k)) > 0) {
          cnt(k) -= 1
        }
        k += 1
      }

      i += 1
    }

    println(ans)
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
