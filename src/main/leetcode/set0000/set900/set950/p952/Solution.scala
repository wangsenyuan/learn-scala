package set0000.set900.set950.p952

import java.util

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution {

  def seive(N: Int): Array[Int] = {
    val set = new util.BitSet()
    val res = ArrayBuffer.empty[Int]

    var x = 2
    while (x < N) {
      res += x
      var y = x * x
      while (y <= N) {
        set.set(y)
        y += x
      }
      x = set.nextClearBit(x + 1)
    }
    res.toArray
  }

  def largestComponentSize(A: Array[Int]): Int = {
    val primes = seive(10000)
    val m = primes.length

    val set = mutable.Map.empty[Int, Int]
    val cnt = mutable.Map.empty[Int, Int].withDefaultValue(1)

    def find(x: Int): Int = {
      if (!set.contains(x)) {
        set(x) = x
      } else if (set(x) != x) {
        set(x) = find(set(x))
      }
      set(x)
    }

    def union(x: Int, y: Int): Unit = {
      val px = find(x)
      val py = find(y)
      if (px != py) {
        val a = cnt(px)
        val b = cnt(py)
        if (a >= b) {
          set(py) = px
          cnt(px) += b
        } else {
          set(px) = py
          cnt(py) += a
        }
      }
    }

    val n = A.length

    val ps = ArrayBuffer.empty[Int]

    val fs = Array.ofDim[Int](n)

    var i = 0
    while (i < n) {
      ps.clear()
      var num = A(i)
      if (num > 1) {
        var j = 0
        while (j < m && num >= primes(j)) {
          if (num % primes(j) == 0) {
            ps += primes(j)
            while (num % primes(j) == 0) {
              num /= primes(j)
            }
          }
          j += 1
        }

        if (num > 1) {
          ps += num
        }

        for {
          a <- 0 until ps.length
          b <- a + 1 until ps.length
        } {
          union(ps(a), ps(b))
        }
        // fist factor
        fs(i) = ps(0)
      }

      i += 1
    }
    val cc = mutable.Map.empty[Int, Int].withDefaultValue(0)
    var best = 0
    i = 0

    while (i < n) {
      if (A(i) > 1) {
        val r = find(fs(i))
        cc(r) += 1
        if (cc(r) > best) {
          best = cc(r)
        }
      }
      i += 1
    }

    best
  }
}
