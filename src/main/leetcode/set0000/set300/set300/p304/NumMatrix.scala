package set0000.set300.set300.p304

class NumMatrix(_matrix: Array[Array[Int]]) {

  def init() = {
    val m = _matrix.length
    if (m == 0) {
      Array.ofDim[Int](1, 1)
    } else {
      val n = _matrix(0).length
      if (n == 0) {
        Array.ofDim[Int](1, n + 1)
      } else {
        val sum = Array.ofDim[Int](m + 1, n + 1)

        for {
          i <- 0 until m
          j <- 0 until n
        } {
          sum(i + 1)(j + 1) = _matrix(i)(j) + sum(i)(j + 1) + sum(i + 1)(j) - sum(i)(j)
        }

        sum
      }
    }
  }

  val sum = init()

  def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = {
    val a = sum(row2 + 1)(col2 + 1)
    val b = sum(row2 + 1)(col1)
    val c = sum(row1)(col2 + 1)
    val d = sum(row1)(col1)
    a - b - c + d
  }

}
