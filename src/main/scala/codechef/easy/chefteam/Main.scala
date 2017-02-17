package codechef.easy.chefteam

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 17/02/2017.
  */
object Main {

  @tailrec
  private final def gcd(a: Long, b: Long): Long = {
    if (b == 0) {
      a
    } else {
      gcd(b, a % b)
    }
  }

  def bin(n: Int, k: Int): Long = {
    if (k > n) {
      0
    } else if (k > n - k) {
      bin(n, n - k)
    } else {
      var c = 1L
      var j = 1
      while (j <= k) {
        val d = gcd(c, j)
        c /= d
        c *= (n - j + 1) / (j / d)
        j += 1
      }
      c
    }
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = line(0)
      val k = line(1)
      val r = bin(n, k)
      println(r)
      t -= 1
    }
  }
}
