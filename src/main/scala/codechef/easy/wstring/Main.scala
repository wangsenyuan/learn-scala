package codechef.easy.wstring

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()

      i += 1
    }
  }

  def solve(): Unit = {
    val str = StdIn.readLine() + '#'

    val n = str.length
    val cnt = Array.fill(26, n)(0)
    val pos = Array.fill(n)(0)
    var j = 0
    var i = 0
    while (i < str.length) {
      val c = str(i)
      if (c == '#') {
        pos(j) = i
        j += 1
      }

      var k = 0
      while (k < 26) {
        if (i > 0) {
          cnt(k)(i) = cnt(k)(i - 1)
        }

        if (k + 'a' == c) {
          cnt(k)(i) += 1
        }

        k += 1
      }

      i += 1
    }

    def mostFreq(i: Int, j: Int): Int = {
      var ans = 0
      var k = 0
      while (k < 26) {
        val tmp =
          if (j == -1) {
            cnt(k)(i)
          } else if (i == n) {
            cnt(k)(n - 1) - cnt(k)(j)
          } else {
            cnt(k)(i) - cnt(k)(j)
          }
        if (tmp > ans) {
          ans = tmp
        }
        k += 1
      }
      ans
    }

    var ans = 0
    i = 0
    while (i + 3 < j) {
      val a = mostFreq(pos(i), -1)
      if (a > 0) {
        val b = mostFreq(pos(i + 1), pos(i))
        if (b > 0) {
          val c = mostFreq(pos(i + 2), pos(i + 1))
          if (c > 0) {
            val d = mostFreq(n, pos(i + 2))
            if (d > 0) {
              val tmp = a + b + c + d + 3
              ans = tmp max ans
            }
          }
        }
      }

      i += 1
    }

    println(ans)
  }
}
