package set700.set740.p740

object Solution {
  val MAX = 100000
  def deleteAndEarn(nums: Array[Int]): Int = {
    val dp = Array.ofDim[Int](MAX + 1)
    // dp(i) = delete i (before) can get
    // dp(i) = cnt(i) * i + dp(i - 2)
    val cnt = Array.ofDim[Int](MAX + 1)
    nums.foreach(cnt(_) += 1)

    dp(1) = cnt(1)
    dp(2) = (cnt(2) * 2) max dp(1)
    var x = 3
    while(x <= MAX) {
      dp(x) = dp(x - 1) max (cnt(x) * x + dp(x - 2))
      x += 1
    }

    dp(MAX)
  }
}
