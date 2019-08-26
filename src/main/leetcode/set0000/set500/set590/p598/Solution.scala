package set0000.set500.set590.p598

object Solution {
  def maxCount(m: Int, n: Int, ops: Array[Array[Int]]): Int = {
    var row = m
    var col = n
    for {
      op <- ops
    } {
      row = row min op(0)
      col = col min op(1)
    }

    row * col
  }
}
