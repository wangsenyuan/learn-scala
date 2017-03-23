package codechef.easy.sgarden

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by wangsenyuan on 23/03/2017.
  */
object Main {

  val N = 100000
  val MOD = 1000000007


  def fastPow(a: Int, n: Int): Long = {
    if (n == 0) {
      1L
    } else {
      val b = fastPow(a, n / 2)
      val c = (b * b) % MOD
      if (n % 2 == 1) {
        (a * c) % MOD
      } else {
        c
      }
    }
  }

  def solve(): Unit = {
    val n = StdIn.readInt()
    val as = StdIn.readLine().split("\\s+").map(_.toInt - 1)
    val maxpw = new mutable.HashMap[Int, Int]()
    var i = 0
    while (i < as.length) {
      if (as(i) >= 0) {
        var len = 0
        var x = as(i)
        while (x >= 0 && as(x) >= 0) {
          val y = as(x)
          as(x) -= n
          x = y
          len += 1
        }

        var d = 2
        while (d * d <= len) {
          var st = 0
          while (len % d == 0) {
            len /= d
            st += 1
          }

          if (st > 0) {
            if (maxpw.contains(d)) {
              maxpw(d) = maxpw(d) max st
            } else {
              maxpw(d) = st
            }
          }
          d += 1
        }

        if (len > 1 && !maxpw.contains(len)) {
          maxpw(len) = 1
        }
      }
      i += 1
    }

    val ans = maxpw.toArray.map(x => (fastPow(x._1, x._2))).foldLeft(1L) {
      (res, x) => (res * x) % MOD
    }

    println(ans)
  }


  def countPrimeFactors(primes: Array[Int], n: Int): Array[Array[Int]] = {
    val m = primes.length
    val res = Array.fill(n + 1, m)(0)

    var i = 0
    while (i < m) {
      val p = primes(i)
      var cnt = 1
      while (p * cnt <= n) {
        res(p * cnt)(i) = cnt
        cnt += 1
      }

      i += 1
    }

    res
  }

  def main(args: Array[String]): Unit = {

    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
