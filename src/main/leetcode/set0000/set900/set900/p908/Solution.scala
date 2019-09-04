package set0000.set900.set900.p908

object Solution {
  def smallestRangeI(A: Array[Int], K: Int): Int = {
    val x = A.min
    val y = A.max

    if (x + K < y - K) {
      y - x - 2 * K
    } else {
      0
    }
  }
}
