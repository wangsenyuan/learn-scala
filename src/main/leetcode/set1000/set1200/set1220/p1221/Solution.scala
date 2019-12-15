package set1000.set1200.set1220.p1221

object Solution {
  def balancedStringSplit(s: String): Int = {
    var res = 0
    var cnt = 0

    for {
      x <- s
    } {
      if (x == 'L') {
        cnt += 1
      } else {
        cnt -= 1
      }
      if (cnt == 0) {
        res += 1
      }
    }
    res
  }
}
