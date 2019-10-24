package set1000.set1000.set1010.p1014

object Solution {
  def maxScoreSightseeingPair(A: Array[Int]): Int = {
    val n = A.length
    var x = -A(0)
    var best = Int.MinValue
    var j = 1
    while (j < n) {
      val y = A(j) - j
      if (y - x > best) {
        best = y - x
      }

      if (-(A(j) + j) < x) {
        x = -(A(j) + j)
      }

      j += 1
    }

    best
  }
}
