package set500.set520.p526

object Solution {
  def countArrangement(N: Int): Int = {
    var res = 0

    def go(mask: Int, i: Int): Unit = {
      if (i > N) {
        res += 1
      } else {
        for {
          j <- 0 until N
          k = j + 1
          if ((mask & (1 << j)) == 0 && (k % i == 0 || i % k == 0))
        } {
          go(mask | (1 << j), i + 1)
        }
      }
    }

    go(0, 1)

    res
  }
}
