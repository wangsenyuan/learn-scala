package set1000.set1100.set1170.p1175

import scala.collection.mutable.ArrayBuffer

object Solution {
  val MOD = 1000000007L

  def numPrimeArrangements(n: Int): Int = {
    val set = Array.ofDim[Boolean](100)
    val buf = ArrayBuffer.empty[Int]
    var x = 2
    while (x < 100) {
      if (!set(x)) {
        // a number number
        buf += x
        var y = x * x
        while (y < 100) {
          set(y) = true
          y += x
        }
      }
      x += 1
    }

    val fact = Array.ofDim[Long](101)
    fact(0) = 1
    x = 1
    while (x <= 100) {
      fact(x) = fact(x - 1) * x
      fact(x) %= MOD
      x += 1
    }

    val primes = buf.takeWhile(_ <= n).toArray
    val m = primes.length

    // total m primes
    ((fact(m) * fact(n - m)) % MOD).toInt
  }

}
