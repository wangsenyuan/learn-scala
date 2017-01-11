package codechef.easy.ckisshug

import scala.io.StdIn

/**
  * Created by wangsenyuan on 11/01/2017.
  */
object Main {

  val MOD = 1000000007

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val n = StdIn.readInt()

      val m = n + 1

      val m1 = m / 2
      val m2 = m - m1

      val res = pow(2, m1) + pow(2, m2) - 2

      println(res % MOD)

      t -= 1
    }
  }

  def pow(a: Long, b: Long): Long = {
    if (b == 0) {
      1L
    } else if (b == 1) {
      a
    } else {
      val x = pow(a, b / 2)
      val y = (x * x) % MOD
      if (b % 2 == 1) {
        (a * y) % MOD
      } else {
        y
      }
    }
  }
}
