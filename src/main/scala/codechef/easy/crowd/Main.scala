package codechef.easy.crowd

import scala.io.StdIn

/**
  * Created by wangsenyuan on 13/04/2017.
  */
object Main {

  val MOD = 1000000007

  type Matrix = Array[Array[Long]]

  def mul(a: Matrix, b: Matrix, c: Matrix): Unit = {
    var i = 0
    while (i < 3) {
      var j = 0
      while (j < 3) {
        c(i)(j) = 0
        var k = 0
        while (k < 3) {
          c(i)(j) = (c(i)(j) + a(i)(k) * b(k)(j)) % MOD
          k += 1
        }
        j += 1
      }
      i += 1
    }
  }

  val id = Array(Array(1, 0, 0), Array(0, 1, 0), Array(0, 0, 1))

  def pow(a: Matrix, n: Long, x: Matrix): Unit = {
    if (n == 1) {
      var i = 0
      while (i < 3) {
        var j = 0
        while (j < 3) {
          x(i)(j) = a(i)(j)
          j += 1
        }
        i += 1
      }
    } else if (n == 0) {
      var i = 0
      while (i < 3) {
        var j = 0
        while (j < 3) {
          x(i)(j) = id(i)(j)
          j += 1
        }
        i += 1
      }
    } else {
      val b = Array(Array(0L, 0L, 0L), Array(0L, 0L, 0L), Array(0L, 0L, 0L))

      pow(a, n >> 1, b)

      val c = Array(Array(0L, 0L, 0L), Array(0L, 0L, 0L), Array(0L, 0L, 0L))

      mul(b, b, c)

      if ((n & 1) == 1) {
        mul(a, c, x)
      } else {
        var i = 0
        while (i < 3) {
          var j = 0
          while (j < 3) {
            x(i)(j) = c(i)(j)
            j += 1
          }
          i += 1
        }
      }
    }
  }

  def pow(a: Int, n: Long): Long = {
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

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    val a = Array(Array(1L, 1L, 1L), Array(1L, 0L, 0L), Array(0L, 1L, 0L))
    val b = Array(Array(0L, 0L, 0L), Array(0L, 0L, 0L), Array(0L, 0L, 0L))
    var i = 0
    while (i < t) {
      val n = StdIn.readLong()

      if (n < 3) {
        println(0)
      } else if (n == 3) {
        println(1)
      } else {
        pow(a, n - 3, b)
        val ans = (7 * b(0)(0) + 4 * b(0)(1) + 2 * b(0)(2)) % MOD
        val total = pow(2, n)
        val res = (total - ans + MOD) % MOD
        println(res)
      }

      i += 1
    }
  }
}
