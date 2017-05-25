package codechef.easy.kspheres

import scala.io.StdIn

/**
  * Created by wangsenyuan on 25/05/2017.
  */
object Main {


  val MOD = 1000000007


  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)
    val C = firstLine(2)

    val us = StdIn.readLine().split("\\s+").map(_.toInt).sorted
    val ls = StdIn.readLine().split("\\s+").map(_.toInt).sorted

    val a = Array.fill(C + 1)(0L)
    val b = Array.fill(C + 1)(0L)

    var i = 0
    while (i < n) {
      a(us(i)) += 1
      i += 1
    }

    i = 0
    while (i < m) {
      b(ls(i)) += 1
      i += 1
    }
    val dp = Array.fill(C + 1)(0L)

    i = 1
    while (i <= C) {
      a(i) = (a(i) * b(i)) % MOD
      dp(i) = a(i)
      b(i) = (b(i - 1) + dp(i)) % MOD
      i += 1
    }


    val res = Array.fill(C)(0L)

    var len = 1
    while (len <= C) {
      var i = 1
      while (i <= C) {
        dp(i) = (a(i) * b(i - 1)) % MOD
        i += 1
      }

      i = 1
      while (i <= C) {
        b(i) = (b(i - 1) + dp(i)) % MOD
        i += 1
      }
      res(len - 1) = b(C)
      len += 1
    }


    println(res.mkString(" "))
  }
}
