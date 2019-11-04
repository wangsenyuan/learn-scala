package set1000.set1000.set1050.p1052

object Solution {
  def maxSatisfied(customers: Array[Int], grumpy: Array[Int], X: Int): Int = {
    val n = customers.length
    val dp = Array.ofDim[Int](n + 1)
    var i = 0
    while (i < n) {
      dp(i + 1) = dp(i) + (1 - grumpy(i)) * customers(i)
      i += 1
    }

    // not use the secret at all
    var sum = 0
    i = 0

    while (i < X) {
      sum += customers(i)
      i += 1
    }

    var best = sum + (dp(n) - dp(i))

    while (i < n) {
      // use it at (i-x...i]
      sum += customers(i)
      sum -= customers(i - X)
      val a = dp(i - X + 1)
      val b = dp(n) - dp(i+1)
      if (a + b + sum > best) {
        best = a + b + sum
      }

      i += 1
    }

    best
  }
}
