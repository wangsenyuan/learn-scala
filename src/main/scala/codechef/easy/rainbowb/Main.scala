package codechef.easy.rainbowb

import scala.io.StdIn

/**
  * Created by wangsenyuan on 09/04/2017.
  */
object Main {

  val MOD = 1000000007

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val comb = Array.fill(n + 1, 6)(0)
    comb(0)(0) = 1
    var i = 1
    while (i <= n) {
      comb(i)(0) = 1
      var j = 1
      while (j <= 5) {
        comb(i)(j) = ((0L + comb(i - 1)(j) + comb(i - 1)(j - 1)) % MOD).toInt
        j += 1
      }

      i += 1
    }
    var ans = 0L
    var a7 = 1
    while (a7 <= n) {
      val m = n - a7
      if (m % 2 == 0 && m / 2 >= 6) {
        ans = (ans + comb(m / 2 - 1)(5)) % MOD
      }
      a7 += 1
    }

    println(ans)
  }
}
