package codechef.easy.chefelec

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/5/29.
  */
object Main {

  def solve() = {
    val n = StdIn.readInt()
    val s = StdIn.readLine()
    val x = StdIn.readLine().split("\\s+").map(_.toLong)
    var ans = x(n - 1) - x(0)
    var j = -1
    var i = 0
    var longest = 0L
    while (i < n) {
      if (i > 0 && x(i) - x(i - 1) > longest) {
        longest = x(i) - x(i - 1)
      }

      if (s(i) == '1') {
        if (j >= 0) {
          ans -= longest
        }
        j = i
        longest = 0
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
