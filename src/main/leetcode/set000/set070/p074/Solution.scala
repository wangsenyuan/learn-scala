package set000.set070.p074

object Solution {


  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    val m = matrix.length
    if (m == 0) {
      false
    } else {
      val n = matrix(0).length
      if (n == 0) {
        false
      } else {
        def findInRow(r: Int): Boolean = {
          var left = 0
          var right = n
          while (left < right) {
            val mid = (left + right) / 2
            if (matrix(r)(mid) >= target) {
              right = mid
            } else {
              left = mid + 1
            }
          }
          right < n && matrix(r)(right) == target
        }

        var found = false
        var i = 0
        while (i < m && !found && matrix(i)(0) <= target) {
          found = findInRow(i)
          i += 1
        }
        found
      }
    }
  }
}
