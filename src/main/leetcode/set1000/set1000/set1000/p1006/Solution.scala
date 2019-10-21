package set1000.set1000.set1000.p1006

object Solution {
  def clumsy(N: Int): Int = {
    if (N == 1) {
      1
    } else if (N == 2) {
      2
    } else if (N == 3) {
      3 * 2
    } else if (N == 4) {
      4 * 3 / 2 + 1
    } else {
      var res = N * (N - 1) / (N - 2) + N - 3
      var num = N - 4
      while (num > 0) {
        if (num == 1) {
          res -= 1
          num -= 1
        } else if (num == 2) {
          res -= 2
          num -= 2
        } else {
          res = res - num * (num - 1) / (num - 2) + num - 3
          num -= 4
        }
      }

      res
    }

  }
}
