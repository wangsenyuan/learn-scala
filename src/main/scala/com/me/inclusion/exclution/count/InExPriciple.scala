package com.me.inclusion.exclution.count

/**
 * Created by senyuanwang on 15/5/29.
 */
trait InExPriciple {

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def count(a: Array[Int], n: Int): Long = {
    val m = a.length
    require(m < 32)
    val M = 1 << m

    def onesInComb(i: Int, count: Int): Int =
      if (i == 0) count
      else {
        onesInComb(i >> 1, count + (i & 1))
      }

    def comb(i: Int, res: Long): Long = {
      if (i == M) res
      else {
        val num = onesInComb(i, 0)
        var lcm = 1
        for {
          j <- 0 until m
          if (lcm <= n)
          if ((i >> j & 1) == 1)
        } {
          lcm = lcm / gcd(lcm, a(j)) * a(j)
        }
        if (num % 2 == 0) {
          comb(i + 1, res - n / lcm)
        } else {
          comb(i + 1, res + n / lcm)
        }
      }
    }

    comb(1, 0L)
  }
}
