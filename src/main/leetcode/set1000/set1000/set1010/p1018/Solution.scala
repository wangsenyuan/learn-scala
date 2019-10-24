package set1000.set1000.set1010.p1018

object Solution {
  def prefixesDivBy5(A: Array[Int]): Array[Boolean] = {
    var sum = 0
    val n = A.length
    val ans = Array.ofDim[Boolean](n)
    var i = 0
    while (i < n) {
      sum = sum * 2 + A(i)

      sum %= 5

      ans(i) = sum == 0

      i += 1
    }

    ans
  }
}
