package set0000.set000.set080.p081

object Solution {
  def search(nums: Array[Int], target: Int): Boolean = {
    def go(left: Int, right: Int): Boolean = {
      if (left > right) {
        false
      } else {
        val mid = (left + right) / 2
        if (nums(mid) == target) {
          true
        } else if (nums(left) <= target && nums(mid) > target) {
          go(left, mid - 1)
        } else if (nums(right) >= target && nums(mid) < target) {
          go(mid + 1, right)
        } else if (nums(right) >= target && nums(mid) > target) {
          go(left + 1, right)
        } else {
          go(left, right - 1)
        }
      }
    }
    val n = nums.length
    if (n == 0) {
      false
    } else if (nums(0) == target || nums(n - 1) == target) {
      true
    } else {
      go(0, nums.length - 1)
    }
  }
}
