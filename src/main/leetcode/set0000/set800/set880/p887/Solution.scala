package set0000.set800.set880.p887

object Solution {
  def superEggDrop(K: Int, N: Int): Int = {
    var lo = 1
    var hi = N
    while (
      lo < hi
    ) {
      val mi = (lo + hi) / 2
      if (f(mi, K, N) < N) {
        lo = mi + 1
      } else {
        hi = mi
      }
    }
    lo
  }

  def f(x: Int, K: Int, N: Int): Int = {
    var ans = 0
    var r = 1
    var i = 1
    while (i <= K && ans < N) {
      r *= x - i + 1
      r /= i
      ans += r
      i += 1
    }
    ans
  }
}
