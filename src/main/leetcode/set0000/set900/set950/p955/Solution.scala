package set0000.set900.set950.p955

object Solution {
  def minDeletionSize(A: Array[String]): Int = {
    val n = A.length
    // gt[i] = 1 if A[i] > A[i-1], 0 if A[i] == A[i-1] for now
    val gt = Array.ofDim[Int](n)
    val back = Array.ofDim[Int](n)

    A(0).length - (0 until A(0).length).count(j => check(n, j, gt, back, A))
  }


  def check(n: Int, j: Int, gt: Array[Int], back: Array[Int], A: Array[String]): Boolean = {
    var i = 1
    while (i < n) {
      back(i) = gt(i)
      if (back(i) == 0) {
        if (A(i)(j) < A(i - 1)(j)) {
          // need to delete
          return false
        } else if (A(i)(j) > A(i - 1)(j)) {
          back(i) = 1
        }
      }
      i += 1
    }
    (0 until n).foreach(k => gt(k) = back(k))
    true
  }
}
