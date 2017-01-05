package codechef.sumpair

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 05/01/2017.
  */
object Main {

  def maxSumPair(n: Int, d: Int, nums: Array[Int]): Long = {
    if (n < 2) {
      0
    } else {
      @tailrec
      def go(i: Int, a: Long, b: Long): Long = {
        if (i == n) {
          a
        } else {
          if (nums(i) - nums(i - 1) >= d) {
            go(i + 1, a, a)
          } else {
            go(i + 1, a max (b + nums(i) + nums(i - 1)), a)
          }
        }
      }

      val a =
        if (nums(1) - nums(0) < d) {
          0L + nums(1) + nums(0)
        } else 0L

      go(2, a, 0)
    }
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = line(0)
      val d = line(1)

      val nums = StdIn.readLine().split("\\s+").map(_.toInt).sorted

      val res = maxSumPair(n, d, nums)

      println(res)

      t -= 1
    }
  }
}
