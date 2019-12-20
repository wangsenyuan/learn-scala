package set1000.set1200.set1240.p1247

object Solution {
  def minimumSwap(s1: String, s2: String): Int = {
    val n = s1.length
    // x -> y
    var a = 0
    // y -> x
    var b = 0

    var i = 0
    while (i < n) {
      if (s1(i) != s2(i)) {
        if (s1(i) == 'x') {
          a += 1
        } else {
          b += 1
        }
      }
      i += 1
    }

    val res = a / 2 + b / 2
    a %= 2
    b %= 2

    if (a != b) {
      -1
    } else if (a == 0) {
      res
    } else {
      res + 2
    }
  }
}
