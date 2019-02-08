package set300.set330.p330

object Solution {
  def minPatches(nums: Array[Int], n: Int): Int = {
    def go(miss: Long, count: Int, i: Int): Int = {
      if (miss > n) {
        count
      } else if (i < nums.length && nums(i) <= miss) {
        go(miss + nums(i), count, i + 1)
      } else {
        go(miss * 2, count + 1, i)
      }
    }

    go(1, 0, 0)
  }
}
