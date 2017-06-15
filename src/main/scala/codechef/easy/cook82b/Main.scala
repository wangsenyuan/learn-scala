package codechef.easy.cook82b

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/6/15.
  */
object Main {

  val MAX = 1001
  val MOD = 1000000007

  def power(x: Int, n: Int): Long = {
    var res = 1L
    var m = n
    var y = x % MOD
    while (m > 0) {
      if ((m & 1) == 1) {
        res = (res * y) % MOD
      }
      m = m >> 1
      y = (y * y) % MOD
    }

    res
  }

  def main(args: Array[String]): Unit = {
    val isPrime = Array.fill(MAX + 1)(true)
    val primeBuffer = ListBuffer.empty[Int]

    var i = 2
    while (i <= MAX) {
      if (isPrime(i)) {
        primeBuffer += i
        var j = 2 * i
        while (j < MAX) {
          isPrime(j) = false
          j += i
        }
      }

      i += 1
    }

    val primes = primeBuffer.toArray

    val n = StdIn.readInt()
    val nums = StdIn.readLine().split("\\s+").map(_.toInt)
    val counts = mutable.Map.empty[Int, Int].withDefaultValue(0)

    i = 0
    while (i < n) {
      var num = nums(i)

      var j = 0
      while (j < primes.length && num >= primes(j)) {
        while (num % primes(j) == 0) {
          counts(primes(j)) += 1
          num /= primes(j)
        }

        j += 1
      }

      if (num > 1) {
        counts(num) += 1
      }

      i += 1
    }

    val justDoIt = counts.forall {
      case (_, cnt) => cnt % n == 0
    }

    if (justDoIt) {
      println("justdoit")
    } else {
      val ans = counts.foldLeft(1L) {
        case (ans, (x, cnt)) =>
          if (cnt % (n + 1) == 0) {
            ans
          } else {
            (ans * power(x, (n + 1) - cnt % (n + 1))) % MOD
          }
      }

      println(ans)
    }
  }
}
