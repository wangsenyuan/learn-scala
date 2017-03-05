package codechef.easy.fcbarca

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/3/5.
  */
object Main {

  val MOD = 1000000007


  def main(args: Array[String]): Unit = {
    val dp = Array.fill(1001, 2)(0L)
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val line = StdIn.readLine().split("\\s+").map(_.toInt)
        val n = line(0)
        val k = line(1)

        // dp[i][0] : The number of the ways that Messi has ball after i passes
        // dp[i][1] : The number of the ways that Messi does not have ball after i passes
        dp(0)(0) = 1
        dp(0)(1) = 0
        (1 to n) foreach {
          i =>
            dp(i)(0) = dp(i - 1)(1) * k % MOD
            dp(i)(1) = (dp(i - 1)(0) + dp(i - 1)(1) * (k - 1)) % MOD
        }


        println(dp(n)(0))
    }
  }
}
