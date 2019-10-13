package set0000.set900.set990.p991

object Solution {
  def brokenCalc(X: Int, Y: Int): Int = {
    if (X >= Y) {
      X - Y
    } else {
      var ans = 0
      var y = Y
      while (y > X) {
        ans += 1
        if ((y & 1) == 0) {
          y >>= 1
        } else {
          y += 1
        }
      }
      ans + X - y
    }
  }
}
