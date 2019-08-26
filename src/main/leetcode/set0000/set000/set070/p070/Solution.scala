package set0000.set000.set070.p070

object Solution {
  def climbStairs(n: Int): Int = {
    def go(a: Int, b: Int, i: Int): Int = {
      if (i == n) {
        a
      } else {
        go(b, a + b, i + 1)
      }
    }

    go(1, 2, 1)
  }
}
