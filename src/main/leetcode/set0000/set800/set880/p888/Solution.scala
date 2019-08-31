package set0000.set800.set880.p888

object Solution {
  def fairCandySwap(A: Array[Int], B: Array[Int]): Array[Int] = {
    val as = A.sum
    val bs = B.sum
    val d = as - bs
    // as - a + b = bs - b + a
    // as + 2 * b = bs + 2 * a
    val set = A.toSet
    var i = 0
    while (i < B.length) {
      val b = B(i)
      val x = as + 2 * b - bs
      if ((x & 1) == 0) {
        val a = x >> 1
        if (set.contains(a)) {
          return Array(a, b)
        }
      }
      i += 1
    }
    Array()
  }
}
