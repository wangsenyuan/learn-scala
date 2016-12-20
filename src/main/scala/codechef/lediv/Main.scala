package codechef.lediv

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 20/12/2016.
  */
object Main {

  def sieve(n: Int): Array[Int] = {
    val primes = (0 to n).toArray

    var r = 2
    while (r * r <= n) {
      if (primes(r) == r) {
        var x = 2 * r
        while (x <= n) {
          primes(x) = primes(x) min r
          x += r
        }
      }
      r += 1
    }

    primes
  }

  def main(args: Array[String]): Unit = {
    val ps = sieve(100000)
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      val n = StdIn.readInt()

      val nums = StdIn.readLine().split("\\s+").map(_.toInt)

      val ans = search(nums, ps)

      println(ans)
    }
  }

  def search(nums: Array[Int], ps: Array[Int]): Int = {
    val div = gcd(nums)
    if (div == 1) {
      -1
    } else {
      ps(div)
    }
  }

  def gcd(nums: Array[Int]): Int = {
    @tailrec
    def gcd(a: Int, b: Int): Int = {
      if (b == 0) {
        a
      } else {
        gcd(b, a % b)
      }
    }

    def go(i: Int, div: Int): Int = {
      if (i == nums.length || div == 1) {
        div
      } else {
        go(i + 1, gcd(div, nums(i)))
      }
    }

    go(1, nums(0))
  }
}
