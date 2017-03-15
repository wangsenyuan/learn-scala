package codechef.easy.egbobrd

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/3/15.
  */
object Main {

  def solve() = {
    val line = StdIn.readLine().split("\\s+")
    val n = line(0).toInt
    val k = line(1).toLong
    val as = StdIn.readLine().split("\\s+").map(_.toLong)

    var left = 0L
    var ans = 0L

    var i = 0
    while (i < n) {
      val need = as(i) - left
      if (need > 0) {
        //m * k >= need
        var m = need / k
        if (m * k < need) {
          m += 1
        }
        ans += m

        left = m * k - need
      } else {
        left = left - as(i)
      }

      if (left > 0) {
        left -= 1
      }

      i += 1
    }

    println(ans)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
