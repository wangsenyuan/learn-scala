package set1000.set1100.set1110.p1111

object Solution {
  def maxDepthAfterSplit(seq: String): Array[Int] = {
    val n = seq.length
    var pa = 0
    var pb = 0
    val res = Array.ofDim[Int](n)

    var i = 0
    while (i < n) {
      if (seq(i) == '(') {
        if (pa <= pb) {
          res(i) = 0
          pa += 1
        } else {
          res(i) = 1
          pb += 1
        }
      } else {
        if (pa > 0) {
          res(i) = 0
          pa -= 1
        } else {
          res(i) = 1
          pb -= 1
        }
      }

      i += 1
    }

    res
  }
}
