package set1000.set1100.set1130.p1137

object Solution {
  def tribonacci(n: Int): Int = {
    if (n == 0) {
      0
    } else if (n == 1) {
      1
    } else if (n == 2) {
      1
    } else {
      var a = 0
      var b = 1
      var c = 1
      var i = 3
      while (i <= n) {
        val d = a + b + c
        a = b
        b = c
        c = d
        i += 1
      }
      c
    }
  }
}
