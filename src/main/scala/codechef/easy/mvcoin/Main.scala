package codechef.easy.mvcoin

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/5/7.
  */
object Main {

  def solve() = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val k = firstLine(1)

    val xs = StdIn.readLine().split("\\s+").map(_.toInt)
    var res = 0
    var i = n - 1
    while (i >= 0) {

      if (i > 0) {
        res += (xs(i) - xs(i - 1) - 1) * ((n - 1 - i) / k + 1)
      } else {
        res += (xs(i) - 1) * ((n - 1 - i) / k + 1)
      }

      i -= 1
    }

    println(res)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
