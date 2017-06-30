package codechef.easy.mxmedian

import scala.io.StdIn

/**
  * Created by wangsenyuan on 30/06/2017.
  */
object Main {

  def solve() = {
    val n = StdIn.readInt()
    val nums = StdIn.readLine().split("\\s+").map(_.toInt).sorted

    val res = Array.fill(2 * n)(0)
    var i = 0
    while (i < n) {
      res(2 * i) = nums(i)
      res(2 * i + 1) = nums(i + n)
      i += 1
    }

    val median = nums(n + n / 2)
    println(median)
    println(res.mkString(" "))
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
