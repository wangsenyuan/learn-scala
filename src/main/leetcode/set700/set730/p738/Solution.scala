package set700.set730.p738

import scala.collection.mutable.ArrayBuffer

object Solution {
  def monotoneIncreasingDigits(N: Int): Int = {
    if (N < 10) {
      N
    } else {
      val buf = ArrayBuffer.empty[Int]

      var num = N

      while (num > 0) {
        buf += num % 10
        num /= 10
      }

      var i = buf.length - 1
      while (i > 0 && buf(i) <= buf(i - 1)) {
        i -= 1
      }
      if (i == 0) {
        N
      } else if (buf(i) == 1) {
        var res = 0
        i = buf.length - 2
        while (i >= 0) {
          res = res * 10 + 9
          i -= 1
        }
        res
      } else {
        var j = i
        while (j + 1 < buf.length && buf(j) == buf(j + 1)) {
          j += 1
        }
        buf(j) -= 1
        var k = buf.length - 1
        var res = 0
        while (k >= j) {
          res = res * 10 + buf(k)
          k -= 1
        }
        while (k >= 0) {
          res = res * 10 + 9
          k -= 1
        }
        res
      }
    }
  }
}
