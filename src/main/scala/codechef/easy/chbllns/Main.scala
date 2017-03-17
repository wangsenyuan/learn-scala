package codechef.easy.chbllns

import scala.io.StdIn

/**
  * Created by wangsenyuan on 17/03/2017.
  */
object Main {

  def solve() = {
    val line = StdIn.readLine().split("\\s+").map(_.toLong).sorted
    val r = line(0)
    val g = line(1)
    val b = line(2)
    val k = StdIn.readLong()

    val res =
      if (k <= r) {
        3 * (k - 1) + 1
      } else if (k <= g) {
        r + 2 * (k - 1) + 1
      } else {
        r + g + k - 1 + 1
      }

    println(res)
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
