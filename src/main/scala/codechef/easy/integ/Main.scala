package codechef.easy.integ

import scala.io.StdIn

/**
  * Created by wangsenyuan on 16/02/2017.
  */
object Main {

  def play(nums: Array[Int], x: Int): Long = {
    if (x == 0) {
      0L
    } else {
      val sorted = nums.sorted.takeWhile(_ < 0)
      val n = sorted.length

      if (n < x) {
        sorted.foldLeft(0L)((r, x) => r - x)
      } else {
        val pivot = -sorted(x - 1)
        val res = 1L * pivot * x
        sorted.map(_ + pivot).takeWhile(_ < 0).foldLeft(res)((r, x) => r - x)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val nums = StdIn.readLine().split("\\s+").map(_.toInt)
    val c = StdIn.readInt()
    val r = play(nums, c)
    println(r)
  }


}
