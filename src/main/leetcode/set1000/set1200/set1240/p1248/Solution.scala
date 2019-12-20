package set1000.set1200.set1240.p1248

object Solution {
  def numberOfSubarrays(nums: Array[Int], k: Int): Int = {
    val n = nums.length
    val pos = Array.fill(n + 1)(-1)
    pos(0) = 0
    var res = 0
    var sum = 0
    var i = 0
    while (i < n) {
      sum += nums(i) & 1

      if (pos(sum) < 0) {
        pos(sum) = i + 1
      }

      val prev = sum - k
      if (prev >= 0) {
        val j = pos(prev + 1)
        val k = pos(prev)
        res += j - k
      }

      i += 1
    }

    res
  }
}
