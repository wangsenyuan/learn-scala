package set300.set340.p343

object Solution {
  def integerBreak(n: Int): Int = {
    if (n == 2) {
      1
    } else if (n == 3) {
      2
    } else {
      var x = n
      var prod = 1
      while (x > 4) {
        prod *= 3
        x -= 3
      }
      prod * x
    }
  }
}
