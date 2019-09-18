package set0000.set900.set940.p944

object Solution {
  def minDeletionSize(A: Array[String]): Int = {
    val n = A(0).length
    (0 until n).count(c => needDelete(A, c))
  }

  private def needDelete(A: Array[String], c: Int): Boolean = {
    var i = 1
    while (i < A.length && A(i)(c) >= A(i - 1)(c)) {
      i += 1
    }

    i < A.length
  }
}
