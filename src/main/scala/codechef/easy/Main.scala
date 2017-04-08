package codechef.easy

import scala.io.StdIn

/**
  * Created by wangsenyuan on 08/04/2017.
  */
object Main {

  def solve() = {
    val trees = Array.fill[Array[Int]](3)(null)
    var i = 0
    while (i < 3) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      trees(i) = line
      i += 1
    }

    def nice(x: Long): Long =
      if ((x & 1) == 0) {
        x - 1
      } else {
        x
      }

    def row(i: Int): Long = {
      val sum = 0L + trees(i)(0) + trees(i)(1) + trees(i)(2)
      nice(sum)
    }

    def column(i: Int): Long = {
      val sum = 0L + trees(0)(i) + trees(1)(i) + trees(2)(i)
      nice(sum)
    }

    var ans = 0L
    i = 0
    while (i < 3) {
      ans = ans max row(i) max column(i)
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
