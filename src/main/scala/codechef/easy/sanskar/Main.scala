package codechef.easy.sanskar

import java.util

import scala.io.StdIn

/**
  * Created by wangsenyuan on 06/03/2017.
  */
object Main {

  val N = 21

  def pow(x: Int, n: Int): Int = {
    if (n == 0) {
      1
    } else {
      val y = pow(x, n / 2)
      val z = y * y
      if (n % 2 == 1) {
        z * x
      } else {
        z
      }
    }
  }

  def canDivideEqually(sanskars: Array[Long], n: Int, K: Int, dp: Array[Array[Boolean]]): Boolean = {
    val sum = sanskars.sum
    if (sum % K != 0) {
      false
    } else {
      val avg = sum / K
      val M = pow(2, n)

      var k = 0
      while (k <= K) {
        util.Arrays.fill(dp(k), false)
        k += 1
      }

      dp(0)(0) = true

      k = 0
      while (k < K) {
        var bitMask = 0
        while (bitMask < M) {
          if (dp(k)(bitMask)) {
            var sum = 0L

            var i = 0
            while (i < n) {
              if ((bitMask & (1 << i)) > 0) {
                sum += sanskars(i)
              }
              i += 1
            }

            sum -= k * avg

            i = 0
            while (i < n) {
              if ((bitMask & (1 << i)) == 0) {
                val newMask = bitMask | (1 << i)
                if (sum + sanskars(i) == avg) {
                  dp(k + 1)(newMask) = true
                } else if (sum + sanskars(i) < avg) {
                  dp(k)(newMask) = true
                }
              }
              i += 1
            }
          }
          bitMask += 1
        }

        k += 1
      }


      dp(K)(M - 1)
    }
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    val dp = Array.fill(9, pow(2, 21))(false)

    (0 until t) foreach {
      _ =>
        val line = StdIn.readLine().split("\\s+").map(_.toInt)
        val n = line(0)
        val k = line(1)
        val sanskars = StdIn.readLine().split("\\s+").map(_.toLong)

        val res = canDivideEqually(sanskars, n, k, dp)

        if (res) {
          println("yes")
        } else {
          println("no")
        }
    }
  }
}
