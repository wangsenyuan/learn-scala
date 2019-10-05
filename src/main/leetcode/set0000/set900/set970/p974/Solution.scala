package set0000.set900.set970.p974

object Solution {
  def subarraysDivByK(A: Array[Int], K: Int): Int = {

    val dp = Array.ofDim[Int](K)
    dp(0) = 1

    var res = 0

    val n = A.length

    var sum = 0
    var i = 0
    while (i < n) {
      sum += A(i)
      while (sum < 0) {
        sum += K
      }

      sum %= K

      res += dp(sum)

      dp(sum) += 1

      i += 1
    }

    res
  }
}
