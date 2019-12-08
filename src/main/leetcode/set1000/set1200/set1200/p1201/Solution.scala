package set1000.set1200.set1200.p1201

import scala.annotation.tailrec

object Solution {
  val INF = Long.MaxValue >> 1

  def nthUglyNumber(n: Int, a: Int, b: Int, c: Int): Int = {

    val ab = lcm(a, b)
    val bc = lcm(b, c)
    val ac = lcm(a, c)

    val abc = lcm3(a, b, c)

    def count(num: Long): Long = {
      num / a + num / b + num / c - num / ab - num / bc - num / ac + num / abc
    }

    var left = 1L
    var right = INF

    while (left < right) {
      val mid = left + (right - left) / 2
      if (count(mid) > n) {
        right = mid
      } else {
        left = mid + 1
      }
    }

    right -= 1
    while (right % a != 0 && right % b != 0 && right % c != 0) {
      right -= 1
    }
    right.toInt
  }

  private def lcm3(a: Int, b: Int, c: Int): Long = {
    // min num divides a, and b, and c
    var A = a.toLong
    var B = b.toLong
    var C = c.toLong

    var res = 1L
    var g = 1L
    do {
      val x = gcd(A, B)
      val y = gcd(B, C)
      val z = gcd(A, C)
      g = x max y max z

      if (A % g == 0) {
        A /= g
      }

      if (B % g == 0) {
        B /= g
      }

      if (C % g == 0) {
        C /= g
      }

      res *= g
    } while (g > 1)

    res * A * B * C
  }

  private def lcm(a: Int, b: Int): Long = {
    (a.toLong * b) / gcd(a, b)
  }

  @tailrec
  private def gcd(a: Long, b: Long): Long = {
    if (b == 0) {
      a
    } else {
      gcd(b, a % b)
    }
  }
}
