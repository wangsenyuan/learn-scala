package set0000.set200.set240.p240

object Solution {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    if (matrix.length == 0 || matrix(0).length == 0) {
      false
    } else {
      find(matrix, target, 0, matrix(0).length - 1)
    }
  }

  private def find(mat: Array[Array[Int]], target: Int, i: Int, j: Int): Boolean = {
    if (i >= mat.length || j < 0) {
      false
    } else if (mat(i)(j) == target) {
      true
    } else if (mat(i)(j) < target) {
      find(mat, target, i + 1, j)
    } else {
      find(mat, target, i, j - 1)
    }
  }
}
