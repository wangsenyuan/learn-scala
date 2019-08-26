package set0000.set400.set490.p498

object Solution {
  def findDiagonalOrder(matrix: Array[Array[Int]]): Array[Int] = {
    if (matrix.length == 0 || matrix(0).length == 0) {
      Array()
    } else {
      val m = matrix.length
      val n = matrix(0).length
      val res = Array.fill(m * n)(0)

      var r = 0
      var c = 0
      var d = -1

      for {
        i <- 0 until (m * n)
      } {
        res(i) = matrix(r)(c)

        if (d == 1) {
          // right to left
          if (r + 1 < m && c - 1 >= 0) {
            r += 1
            c -= 1
          } else if (r + 1 < m && c == 0) {
            r += 1
            d = -1
          } else {
            c += 1
            d = -1
          }
        } else {
          // left to right
          if (r - 1 >= 0 && c + 1 < n) {
            r -= 1
            c += 1
          } else if (r == 0 && c + 1 < n) {
            c += 1
            d = 1
          } else {
            r += 1
            d = 1
          }
        }
      }

      res
    }
  }
}
