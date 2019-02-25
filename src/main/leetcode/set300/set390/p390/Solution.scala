package set300.set390.p390

object Solution {
  def lastRemaining(n: Int): Int = {
    if (n == 1) {
      1
    } else {
      2 * (1 + n / 2 - lastRemaining(n / 2))
    }
  }
}
