package set1000.set1300.set1310.p1318

object Solution {
  def minFlips(a: Int, b: Int, c: Int): Int = {
    var ans = 0
    var x = a
    var y = b
    var z = c

    while (z > 0 || x > 0 || y > 0) {
      if ((z & 1) == 1) {
        if ((x & 1) == 0 && (y & 1) == 0) {
          ans += 1
        }
      } else {
        if ((x & 1) == 1) {
          ans += 1
        }
        if ((y & 1) == 1) {
          ans += 1
        }
      }
      x >>= 1
      y >>= 1
      z >>= 1
    }


    ans
  }
}
