package set0000.set900.set910.p915

object Solution {
  def partitionDisjoint(A: Array[Int]): Int = {
    val n = A.length
    val dp = Array.ofDim[Int](n)

    var i = 0
    while (i < n) {
      dp(i) = A(i)
      if (i > 0 && A(i) < dp(i - 1)) {
        dp(i) = dp(i - 1)
      }
      i += 1
    }

    var ceil = A(n - 1)
    var best = n - 1
    i = n - 2
    while (i >= 0) {
      if (dp(i) <= ceil) {
        best = i + 1
      }
      ceil = ceil min A(i)
      i -= 1
    }
    best
  }
}
