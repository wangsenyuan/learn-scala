package set800.set850.p852

object Solution {
  def peakIndexInMountainArray(A: Array[Int]): Int = {
    val n = A.length
    var left = 0
    var right = n - 1
    while (left < right) {
      val mid = (left + right) / 2
      if (A(mid) < A(mid + 1)) {
        // climbing
        left = mid + 1
      } else if (A(mid) > A(mid + 1)) {
        right = mid
      }
    }

    right
  }
}
