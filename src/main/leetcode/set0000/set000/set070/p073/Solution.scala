package set0000.set000.set070.p073

object Solution {

  def setZeroes(matrix: Array[Array[Int]]): Unit = {
    val m = matrix.length
    if (m > 0) {
      val n = matrix(0).length
      if (n > 0) {
        val row = Array.fill(m)(false)
        val col = Array.fill(n)(false)
        for {
          i <- 0 until m
          j <- 0 until n
          if (matrix(i)(j) == 0)
        } {
          row(i) = true
          col(j) = true
        }

        for {
          i <- 0 until m
          if row(i)
          j <- 0 until n
        } {
          matrix(i)(j) = 0
        }

        for {
          j <- 0 until n
          if col(j)
          i <- 0 until m
        } {
          matrix(i)(j) = 0
        }
      }
    }
  }

}
