package set0000.set800.set840.p840

object Solution {
  def numMagicSquaresInside(grid: Array[Array[Int]]): Int = {
    if (grid.length < 3 || grid(0).length < 3) {
      0
    } else {
      val occ = Array.ofDim[Boolean](9)

      def conditionOne(i: Int, j: Int): Boolean = {
        (0 until 9).foreach(x => occ(x) = false)
        for {
          k <- 0 until 9
          x = i + k / 3
          y = j + k % 3
          if (grid(x)(y) > 0 && grid(x)(y) <= 9)
        } {
          occ(grid(x)(y) - 1) = true
        }

        occ.forall(identity)
      }

      def sumRow(i: Int, j: Int): Int = {
        grid(i)(j) + grid(i)(j + 1) + grid(i)(j + 2)
      }

      def sumCol(i: Int, j: Int): Int = {
        grid(i)(j) + grid(i + 1)(j) + grid(i + 2)(j)
      }

      def sumDiag(i: Int, j: Int): Int = {
        grid(i)(j) + grid(i + 1)(j + 1) + grid(i + 2)(j + 2)
      }

      def sumRDiag(i: Int, j: Int): Int = {
        grid(i)(j) + grid(i + 1)(j - 1) + grid(i + 2)(j - 2)
      }

      def conditionTwo(i: Int, j: Int): Boolean = {
        val sum = sumRow(i, j)
        if (sumRow(i + 1, j) != sum) {
          false
        } else if (sumRow(i + 2, j) != sum) {
          false
        } else if (sumCol(i, j) != sum) {
          false
        } else if (sumCol(i, j + 1) != sum) {
          false
        } else if (sumCol(i, j + 2) != sum) {
          false
        } else if (sumDiag(i, j) != sum) {
          false
        } else if (sumRDiag(i, j + 2) != sum) {
          false
        } else {
          true
        }
      }

      var res = 0
      for {
        i <- 0 until grid.length
        if i + 3 <= grid.length
        j <- 0 until grid(i).length
        if j + 3 <= grid(i).length
        if conditionOne(i, j) && conditionTwo(i, j)
      } {
        res += 1
      }

      res
    }
  }
}
