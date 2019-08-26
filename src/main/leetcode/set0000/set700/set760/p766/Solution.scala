package set0000.set700.set760.p766

object Solution {
  def isToeplitzMatrix(matrix: Array[Array[Int]]): Boolean = {
    val m = matrix.length
    val n = matrix(0).length

    var i = 0
    while (i < m) {
      var j = 0
      while (j < n) {

        val a = i - 1
        val b = j - 1
        if (a >= 0 && b >= 0 && matrix(i)(j) != matrix(a)(b)) {
          return false
        }

        j += 1
      }
      i += 1
    }

    return true
  }
}
