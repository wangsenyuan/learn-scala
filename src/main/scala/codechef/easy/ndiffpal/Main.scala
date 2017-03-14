package codechef.easy.ndiffpal

import scala.io.StdIn

/**
  * Created by wangsenyuan on 14/03/2017.
  */
object Main {

  def calculate(n: Int) = {
    var l = 1
    var r = n + 1
    while (l < r) {
      val k = l + (r - l) / 2
      if (l != k) {
        if (k * (k + 1) > 2 * n) {
          r = k
        } else {
          l = k
        }
      } else {
        r = k - 1
      }
    }
    l
  }

  def solve() = {
    val n = StdIn.readInt()

    def go(n: Int, res: String, ch: Char): String = {
      if (n == 0) {
        res
      } else {
        val m = calculate(n)
        val x = m * (m + 1) / 2
        go(n - x, res + (ch.toString * m), (ch + 1).toChar)
      }
    }

    println(go(n, "", 'a'))
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
