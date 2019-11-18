package set1000.set1100.set1100.p1105

object Solution {
  def minHeightShelves(books: Array[Array[Int]], shelf_width: Int): Int = {
    val n = books.length
    // dp(i) = min-length when books i - 1 is at the last position
    val dp = Array.ofDim[Int](n + 1)
    dp(0) = 0

    for {
      i <- 1 to n
    } {
      var best = Int.MaxValue
      var j = i - 1
      var height = 0
      var width = 0
      while (j >= 0 && width + books(j)(0) <= shelf_width) {
        height = height max books(j)(1)
        best = best min (height + dp(j))
        width += books(j)(0)
        j -= 1
      }

      dp(i) = best
    }

    dp(n)
  }
}
