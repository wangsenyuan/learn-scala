package codechef.easy.chefsoc2

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/4/13.
  */
object Main {

  val MOD = 1000000007

  def solve(): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)
    val s = firstLine(2) - 1
    val as = StdIn.readLine().split("\\s+").map(_.toInt)

    val dp = Array.fill(n, m + 1)(0L)
    dp(s)(0) = 1
    var j = 0
    while (j < m) {
      val a = as(j)
      var i = 0
      while (i < n) {
        val x = i - a
        if (x >= 0) {
          dp(x)(j + 1) = (dp(x)(j + 1) + dp(i)(j)) % MOD
        }
        val y = i + a
        if (y < n) {
          dp(y)(j + 1) = (dp(y)(j + 1) + dp(i)(j)) % MOD
        }
        i += 1
      }

      j += 1
    }
    val res = StringBuilder.newBuilder
    var i = 0
    while (i < n) {
      res.append(dp(i)(m)).append(" ")
      i += 1
    }
    res.setLength(res.length - 1)

    println(res.toString())
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    (0 until t) foreach {
      _ => solve()
    }
  }
}
