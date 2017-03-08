package codechef.easy.lfeb14b

import scala.io.StdIn

/**
  * Created by wangsenyuan on 08/03/2017.
  */
object Main {

  val MOD = 1000000007

  def pow(a: Int, n: Int): Long = {
    if (n == 0) {
      1L
    } else {
      val b = pow(a, n / 2)
      val c = b * b % MOD
      if (n % 2 == 1) {
        c * a % MOD
      } else {
        c
      }
    }
  }

  def deleteToGetMaxMeanWays(nums: Array[Int], n: Int) = {
    val x = nums.max
    val m = nums.count(_ == x)
    pow(2, m) - 1
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val n = StdIn.readInt()
        val nums = StdIn.readLine().split("\\s+").map(_.toInt)
        val res = deleteToGetMaxMeanWays(nums, n)
        println(res)
    }
  }
}
