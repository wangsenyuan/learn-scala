package set0000.set300.set390.p397

object Solution {
  def integerReplacement(n: Int): Int = {
    def go(n: Long, res: Int): Int = {
      if(n == 1) {
        res
      } else if((n & 1) == 0) {
        go(n >> 1, res + 1)
      } else if(n == 3 || ((n >> 1) & 1) == 0) {
        go(n - 1, res + 1)
      } else {
        go(n + 1, res + 1)
      }
    }

    go(n.toLong, 0)
  }
}
