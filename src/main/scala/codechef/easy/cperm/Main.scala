package codechef.easy.cperm

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/7/8.
  */
object Main {

  val MOD = 1000000007

  def fastPower(n: Int): Long = {
    if (n == 0) {
      1L
    } else {
      val y = fastPower(n / 2)
      val z = (y * y) % MOD
      if (n % 2 == 1) {
        (2 * z) % MOD
      } else {
        z
      }
    }
  }

  def solve() = {
    val n = StdIn.readInt()
    val ans =
      if (n == 1) {
        0
      } else {
        val tmp = fastPower(n - 1)
        (tmp - 2 + MOD) % MOD
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
