package codechef.easy.cseq

import scala.io.StdIn
import scala.language.postfixOps

/**
 * Created by senyuanwang on 2017/4/5.
 */
object Main {

  val MOD = 1000003

  val fact = Array.fill(MOD)(1)
  val inv = Array.fill(MOD)(1)

  def fastPow(a: Int, n: Int): Int = {
    if (n == 0) {
      1
    } else {
      val b = fastPow(a, n >> 1)
      val c = (1l * b * b) % MOD
      if ((n & 1) == 1) {
        ((c * a) % MOD) toInt
      } else {
        c toInt
      }
    }
  }

  def solve(fact: Array[Int], inv: Array[Int]) = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val l = line(1)
    val r = line(2)
    val k = r - l + 1

    def comb(n: Int, k: Int): Int = {
      if (k > n) {
        0
      } else {
        ((1L * fact(n) * inv(k) * inv(n - k)) % MOD) toInt
      }
    }

    val ret = 1L * comb((n + k) / MOD, n / MOD) * comb((n + k) % MOD, n % MOD)

    println((ret - 1 + MOD) % MOD)
  }

  def main(args: Array[String]): Unit = {
    fact(0) = 1
    inv(0) = 1
    var i = 1
    while (i < MOD) {
      fact(i) = ((1l * fact(i - 1) * i) % MOD).toInt
      inv(i) = fastPow(fact(i), MOD - 2)
      i += 1
    }

    val t = StdIn.readInt()

    i = 0
    while (i < t) {
      solve(fact, inv)
      i += 1
    }
  }
}
