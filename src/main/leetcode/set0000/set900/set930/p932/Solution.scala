package set0000.set900.set930.p932

object Solution {
  def beautifulArray(N: Int): Array[Int] = {
    if (N == 1) {
      Array(1)
    } else if (N == 2) {
      Array(1, 2)
    } else {
      val mid = N / 2
      val left = beautifulArray(mid)
      val right = beautifulArray(N - mid)
      left.map(i => 2 * i) ++ right.map(i => 2 * i - 1)
    }

  }
}
