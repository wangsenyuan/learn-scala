package set200.set270.p275

object Solution {
  def hIndex(citations: Array[Int]): Int = {
    val n = citations.length

    def go(left: Int, right: Int): Int = {
      if (left == right) {
        n - right
      } else {
        val mid = (left + right) / 2
        if (citations(mid) == n - mid) {
          citations(mid)
        } else if (citations(mid) > n - mid) {
          go(left, mid)
        } else {
          go(mid + 1, right)
        }
      }
    }

    go(0, n)
  }
}
