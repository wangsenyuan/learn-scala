package set1000.set1000.set1000.p1004

object Solution {
  def longestOnes(A: Array[Int], K: Int): Int = {
    val n = A.length
    val sum = Array.ofDim[Int](n + 1)

    (0 until n).foreach(i => sum(i + 1) = sum(i) + A(i))

    var ans = 0

    var j = 0
    var i = 0
    while (i < n) {
      if (A(i) == 0) {
        // need to shrink from j
        var len = i - j + 1
        var cnt = sum(i) - sum(j)
        while (len - cnt > K) {
          cnt -= A(j)
          j += 1
          len -= 1
        }
      } else {
        // safe
      }

      ans = ans max (i - j + 1)

      i += 1
    }

    ans
  }
}
