package set0000.set900.set910.p918

object Solution {
  def maxSubarraySumCircular(A: Array[Int]): Int = {
    val n = A.length
    var sum = 0
    var ans = Int.MinValue
    var i = 0
    while (i < n) {
      sum += A(i)
      ans = ans max sum
      if (sum < 0) {
        sum = 0
      }
      i += 1
    }

    val dp = Array.ofDim[Int](n)
    sum = A(0)

    dp(0) = A(0)
    i = 1
    while (i < n) {
      sum += A(i)

      dp(i) = sum max dp(i - 1)

      i += 1
    }

    val fp = Array.ofDim[Int](n)
    fp(n - 1) = A(n - 1)
    i = n - 2
    sum = A(n - 1)
    while (i >= 0) {
      sum += A(i)
      fp(i) = sum max fp(i + 1)
      i -= 1
    }

    i = 0

    while (i < n - 1) {
      ans = ans max (dp(i) + fp(i + 1))
      i += 1
    }
    ans
  }
}
