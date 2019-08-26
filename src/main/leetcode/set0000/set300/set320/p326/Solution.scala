package set0000.set300.set320.p326

object Solution {
  def isPowerOfThree(n: Int): Boolean = {
    var x = 1L
    while (x * 3 <= n) {
      x *= 3
    }
    x == n
  }
}
