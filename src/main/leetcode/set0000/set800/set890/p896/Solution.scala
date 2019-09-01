package set0000.set800.set890.p896

object Solution {
  def isMonotonic(A: Array[Int]): Boolean = {
    val n = A.length
    var can = true
    var i = 1
    while (i < n && can) {
      can = A(i) >= A(i - 1)
      i += 1
    }
    if (can) {
      true
    } else {
      can = true
      i = 1
      while (i < n && can) {
        can = A(i) <= A(i - 1)
        i += 1
      }
      can
    }
  }
}
