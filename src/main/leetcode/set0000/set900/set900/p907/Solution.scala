package set0000.set900.set900.p907

object Solution {
  def sumSubarrayMins(A: Array[Int]): Int = {
    val n = A.length
    val stack = Array.ofDim[Int](n)
    var p = 0
    val dp = Array.ofDim[Int](n)
    var i = 0
    while (i < n) {
      dp(i) = i
      while (p > 0 && A(stack(p - 1)) > A(i)) {
        dp(stack(p - 1)) = i
        p -= 1
      }
      stack(p) = i
      p += 1
      i += 1
    }

    while (p > 0) {
      dp(stack(p - 1)) = n
      p -= 1
    }

    val fp = Array.ofDim[Int](n)
    p = 0
    i = n - 1
    while (i >= 0) {
      fp(i) = i
      while (p > 0 && A(stack(p - 1)) >= A(i)) {
        fp(stack(p - 1)) = i
        p -= 1
      }

      stack(p) = i
      p += 1

      i -= 1
    }

    while (p > 0) {
      fp(stack(p - 1)) = -1
      p -= 1
    }


    val MOD = 1000000007
    var res = 0

    i = 0
    while (i < n) {
      val a = i - fp(i)
      val b = dp(i) - i

      val c = ((1L * A(i) * a * b) % MOD).toInt

      res += c
      if (res >= MOD) {
        res -= MOD
      }

      i += 1
    }

    res
  }
}
