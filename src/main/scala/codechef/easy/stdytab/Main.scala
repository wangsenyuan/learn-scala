package codechef.easy.stdytab

import scala.io.StdIn

/**
  * Created by wangsenyuan on 04/07/2017.
  */
object Main {

  val MOD = 1000000000


  def preCompute(sz: Int) = {
    val C = Array.fill(sz, sz)(0)

    var i = 0
    while (i < sz) {
      C(i)(0) = 1
      i += 1
    }

    i = 1
    while (i < sz) {
      var j = 1
      while (j <= i) {
        C(i)(j) = (C(i - 1)(j - 1) + C(i - 1)(j)) % MOD
        j += 1
      }

      i += 1
    }
    C
  }

  def solve(C: Array[Array[Int]]) = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)

    val dp = Array.fill(n + 1, m + 1)(0)
    dp(0)(0) = 1

    var i = 1
    while (i <= n) {
      var tmp = 0
      var j = 0
      while (j <= m) {
        tmp += dp(i - 1)(j)
        if (tmp >= MOD) {
          tmp -= MOD
        }

        dp(i)(j) = (1l * tmp * C(j + m - 1)(m - 1) % MOD) toInt

        j += 1
      }

      i += 1
    }
    var ans = 0
    i = 0
    while (i <= m) {
      ans += dp(n)(i)
      if (ans >= MOD) {
        ans -= MOD
      }
      i += 1
    }

    println(ans)
  }

  def main(args: Array[String]): Unit = {
    val C = preCompute(4444)

    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve(C)

      i += 1
    }
  }
}
