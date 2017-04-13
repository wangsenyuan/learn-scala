package codechef.easy.chefbr

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/4/12.
  */
object Main {

  val MOD = 1000000007

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val s = StdIn.readLine().split("\\s+").map(_.toInt)

    val dp = Array.fill(n, n)(0L)

    var sz = 1
    while (sz < n) {
      var i = 0
      while (i < n - sz) {
        val j = i + sz

        dp(i)(j) = dp(i)(j - 1)

        var k = i
        while (k < j) {
          if (s(k) < 0 && s(k) + s(j) == 0) {
            if (k < 1) {
              dp(i)(j) = (dp(i)(j) + dp(k + 1)(j - 1) + 1) % MOD
            } else {
              dp(i)(j) = (dp(i)(j) + (dp(k + 1)(j - 1) + 1) * (dp(i)(k - 1) + 1)) % MOD
            }
          }

          k += 1
        }

        i += 1
      }

      sz += 1
    }

    val ans = (dp(0)(n - 1) + 1) % MOD
    println(ans)
  }
}
