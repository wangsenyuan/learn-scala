package set700.set770.p775

object Solution {
  def isIdealPermutation(A: Array[Int]): Boolean = {
    val n = A.length
    var i = 0
    var valid = true
    while (i < n && valid) {
      // i can be at position i - 1 or i or i + 1
      valid = (i > 0 && A(i - 1) == i) || A(i) == i || (i < n - 1 && A(i + 1) == i)
      i += 1
    }

    valid
  }
}
