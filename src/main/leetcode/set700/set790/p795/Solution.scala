package set700.set790.p795

object Solution {
  def numSubarrayBoundedMax(A: Array[Int], L: Int, R: Int): Int = {
    val n = A.length
    val stack = Array.ofDim[Int](n)
    var p = 0

    val dp = Array.ofDim[Int](n)

    var i = 0
    while(i < n) {
      dp(i) = n
      while(p > 0 && A(stack(p - 1)) <= A(i)) {
        dp(stack(p - 1)) = i
        p -= 1
      }

      stack(p) = i
      p += 1

      i += 1
    }

    val fp = Array.ofDim[Int](n)
    p = 0
    i = n - 1
    while(i >= 0) {
      fp(i) = -1
      while(p > 0 && A(stack(p - 1)) < A(i)) {
        fp(stack(p - 1)) = i
        p -= 1
      }
      stack(p) = i
      p += 1
      i -= 1
    }

    var res = 0
    i = 0
    while(i < n) {
      if(A(i) >= L && A(i) <= R) {
        res += (dp(i) - i) * (i - fp(i))
      }
      i += 1
    }

    res
  }
}
