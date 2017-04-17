package codechef.easy.banrob

import scala.io.StdIn

/**
  * Created by wangsenyuan on 17/04/2017.
  */
object Main {

  /*def pow(a: Double, n: Int): Double = {
    if (n == 0) {
      1.0
    } else {
      val b = pow(a, n >> 1)
      val c = b * b
      if ((n & 1) == 1) {
        c * a
      } else {
        c
      }
    }
  }*/

  def pow(a: Double, n: Int): Double = {
    var m = n
    var b = a
    var res = 1.0d
    while (m > 0) {
      if (m % 2 == 1) {
        res *= b
      }
      b *= b
      m >>= 1
    }

    res
  }

  def solve() = {
    val line = StdIn.readLine().split("\\s+")
    val m = line(0).toInt
    val p = line(1).toDouble

    val a = 1L * 1000000000 * (pow(-p, m) - 1) / (-p - 1)
    val b = 1000000000.0d - a

    println(f"$a%.3f $b%.3f")
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }
}
