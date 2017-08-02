package codechef.easy.cballs

import java.util

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val primes = preComputePrimes(10000)
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve(primes)
      i += 1
    }
  }

  def preComputePrimes(N: Int): Array[Int] = {
    val ps = ListBuffer.empty[Int]
    val nums = new util.BitSet()
    var x = 2
    while (x <= N) {
      x = nums.nextClearBit(x)
      ps += x
      var y = x + x
      while (y <= N) {
        nums.set(y)
        y += x
      }
      x += 1
    }

    ps.toArray
  }

  def solve(primes: Array[Int]): Unit = {
    val n = StdIn.readInt()
    val nums = StdIn.readLine().split("\\s+").map(_.toInt)

    var ans = Int.MaxValue
    var i = 0
    while (i < primes.length) {
      val prime = primes(i)

      var currentMultiple = 0

      var tmp = 0
      var j = 0
      while (j < n) {
        val num = nums(j)

        if (num > currentMultiple) {
          currentMultiple = (num + prime - 1) / prime * prime
        }

        tmp += currentMultiple - num

        j += 1
      }

      if (tmp < ans) {
        ans = tmp
      }
      i += 1
    }

    println(ans)
  }
}
