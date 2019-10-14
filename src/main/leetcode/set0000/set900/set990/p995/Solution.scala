package set0000.set900.set990.p995

object Solution {
  def minKBitFlips(A: Array[Int], K: Int): Int = {
    val n = A.length

    val flips = Array.ofDim[Int](n)

    var i = 0
    var res = 0

    while (i <= n - K) {
      if (i > 0) {
        flips(i) += flips(i - 1)
      }

      if (A(i) == (flips(i) & 1)) {
        res += 1
        // need flips here
        flips(i) += 1
        if (i + K < n) {
          flips(i + K) -= 1
        }
      }


      i += 1
    }

    while (i < n) {
      flips(i) += flips(i - 1)
      if (A(i) == (flips(i) & 1)) {
        return -1
      }
      i += 1
    }

    res
  }
}
