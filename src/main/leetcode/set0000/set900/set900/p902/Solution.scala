package set0000.set900.set900.p902

import scala.collection.mutable.ArrayBuffer

object Solution {
  def atMostNGivenDigitSet(D: Array[String], N: Int): Int = {
    val buf = ArrayBuffer.empty[Int]

    var num = N
    while (num > 0) {
      buf += num % 10
      num /= 10
    }

    val ns = buf.toArray.reverse

    var n = ns.length
    val digits = D.map(_.toInt)


    if (N < 10) {
      digits.count(_ < N)
    } else {
      def dfs(i: Int, less: Boolean): Int = {
        if (i == n) {
          1
        } else if (less) {
          power(digits.length, n - i)
        } else {
          var res = 0
          var j = 0
          while (j < digits.length && digits(j) <= ns(i)) {
            res += dfs(i + 1, digits(j) < ns(i))
            j += 1
          }
          res
        }
      }

      val a = dfs(0, false)

      var b = 0
      while (n > 1) {
        b += power(digits.length, n - 1)
        n -= 1
      }

      a + b
    }
  }

  private def power(a: Int, b: Int): Int = {
    var x = a
    var y = b
    var r = 1
    while (y > 0) {
      if ((y & 1) == 1) {
        r *= x
      }
      x *= x
      y >>= 1
    }
    r
  }
}
