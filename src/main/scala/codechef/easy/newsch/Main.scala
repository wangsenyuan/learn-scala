package codechef.easy.newsch

import scala.io.StdIn

/**
  * Created by wangsenyuan on 11/04/2017.
  */
object Main {

  val MOD = 1000000007

  def pow(a: Int, n: Int): Long = {
    if (n == 0) {
      1
    } else {
      val b = pow(a, n >> 1)
      val c = (b * b) % MOD
      if ((n & 1) == 1) {
        (c * a) % MOD
      } else {
        c
      }
    }
  }

  def fastPowSolve(n: Int) = {
    var ans = pow(3, n)

    if (n % 2 == 1) {
      ans -= 3
    } else {
      ans += 3
    }

    ans = (ans + MOD) % MOD
  }

  def dpSolve(n: Int) = {
    def go(n: Int, x: Int, y: Int): Long = {
      if (n == 0) {
        0L
      } else if (n == 1) {
        if (x == y) {
          1L
        } else {
          0L
        }
      } else if (n % 2 == 1) {
        var tmp = 0L
        var a = 0
        while (a < 4) {
          var b = 0
          while (b < 4) {
            if (a != b) {
              tmp = (tmp + go(1, x, a) * go(n - 1, b, y)) % MOD
            }
            b += 1
          }

          a += 1
        }
        tmp
      } else {
        var tmp = 0L
        var a = 0
        while (a < 4) {
          var b = 0
          while (b < 4) {
            if (a != b) {
              tmp = (tmp + go(n / 2, x, a) * go(n / 2, b, y)) % MOD
            }
            b += 1
          }

          a += 1
        }
        tmp
      }
    }

    var ans = 0L
    var a = 0
    while (a < 4) {
      var b = 0
      while (b < 4) {
        if (a != b) {
          ans = (ans + go(n, a, b)) % MOD
        }
        b += 1
      }

      a += 1
    }
    ans

  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val n = StdIn.readInt()

      val ans = fastPowSolve(n)
      //val ans = dpSolve(n)

      println(ans)

      t -= 1
    }
  }
}
