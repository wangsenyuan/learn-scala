package set600.set680.p689

object Solution {
  def maxSumOfThreeSubarrays(nums: Array[Int], k: Int): Array[Int] = {
    val n = nums.length
    val right = Array.ofDim[Int](n + 1)
    right(n) = n
    val sum = Array.ofDim[Int](n + 1)
    var i = n - 1
    while (i >= 0) {
      sum(i) = sum(i + 1) + nums(i)

      val a = sum(i) - sum(n min (i + k))
      val j = right(i + 1)
      val b = sum(j) - sum(n min (j + k))
      if (a >= b) {
        right(i) = i
      } else {
        right(i) = j
      }
      i -= 1
    }

    val left = Array.ofDim[Int](n + 1)
    sum(0) = 0
    i = 0
    while (i < n) {
      sum(i + 1) = sum(i) + nums(i)
      val a = sum(i + 1) - sum(0 max (i + 1 - k))
      val j = left(i)
      val b = sum(j + 1) - sum(0 max (j + 1 - k))
      if (a > b) {
        left(i + 1) = i
      } else {
        left(i + 1) = j
      }
      i += 1
    }
    var best = 0
    val ans = Array(0, 0, 0)
    i = k
    while(i + k < n) {
      val u = left(i)
      val v = right(i + k)

      val a = sum(u + 1) - sum(u + 1 - k)
      val b = sum(i + k) - sum(i)
      val c = sum((v + k) min n) - sum(v)
      if(a + b + c > best) {
        best = a + b + c
        ans(0) = u - k + 1
        ans(1) = i
        ans(2) = v
      }

      i += 1
    }

    ans
  }
}
