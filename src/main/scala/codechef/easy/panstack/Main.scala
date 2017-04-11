package codechef.easy.panstack

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/4/11.
  */
object Main {

  val N = 1000
  val MOD = 1000000007

  def preCompute() = {
    val f = Array.fill(N + 1, N + 1)(0L)

    f(1)(1) = 1

    var i = 2
    while (i <= N) {

      var j = 1
      while (j <= i) {
        f(i)(j) = (j * f(i - 1)(j) + f(i - 1)(j - 1)) % MOD
        j += 1
      }

      i += 1
    }

    f
  }

  def main(args: Array[String]): Unit = {
    val f = preCompute()

    var t = StdIn.readInt()
    while (t > 0) {
      val n = StdIn.readInt()

      val fn = f(n)
      val ans = fn.foldLeft(0L)((ans, x) => (ans + x) % MOD)

      println(ans)

      t -= 1
    }

  }
}
