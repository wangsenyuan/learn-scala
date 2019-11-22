package set1000.set1100.set1140.p1144

object Solution {
  val INF = 1 << 20

  def movesToMakeZigzag(nums: Array[Int]): Int = {
    process(nums, 0) min process(nums, 1)
  }

  private def process(nums: Array[Int], start: Int): Int = {
    val n = nums.length
    var ans = 0
    var i = start
    while (i < n) {
      val prev = if (i > 0) {
        nums(i - 1)
      } else {
        INF
      }
      val next = if (i < n - 1) {
        nums(i + 1)
      } else {
        INF
      }
      val cur = (prev min next) - 1
      if (cur < nums(i)) {
        ans += nums(i) - cur
      }
      i += 2
    }
    ans
  }
}
