package codechef.easy.maxpr

import scala.io.StdIn

/**
  * Created by wangsenyuan on 21/06/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }

  val MOD = 1000000007

  def solve(): Unit = {
    val n = StdIn.readInt()
    val a = StdIn.readLine().split("\\s+").map(_.toInt)
    val cnt = Array.fill(105, 205)(0)

    var ans = n + 1

    var i = 0
    while (i < n) {
      val x = a(i)
      var j = 0
      while (j <= 100) {
        cnt(x)(x - j + 100) += cnt(j)(x - j + 100)
        cnt(x)(x - j + 100) %= MOD
        j += 1
      }

      j = -100
      while (j <= 100) {
        cnt(x)(j + 100) += 1
        cnt(x)(j + 100) %= MOD
        ans -= 1
        j += 1
      }

      i += 1
    }

    ans = (ans + MOD) % MOD
    i = 1
    while (i <= 100) {
      var j = -100
      while (j <= 100) {
        ans = (ans + cnt(i)(j + 100)) % MOD
        j += 1
      }
      i += 1
    }
    ans = power(2, n) - ans
    ans = (ans + MOD) % MOD
    println(ans)
  }

  def power(a: Int, n: Int): Int = {
    if (n == 0) {
      1
    } else {
      val b = power(a, n >> 1)
      val c = (b * b) % MOD
      if ((n & 1) == 1) {
        (c * a) % MOD
      } else {
        c
      }
    }
  }
}
