package set0000.set500.set540.p540

object Solution {
  def singleNonDuplicate1(nums: Array[Int]): Int = {
    nums.reduceLeft(_ ^ _)
  }

  def singleNonDuplicate(nums: Array[Int]): Int = {
    val n = nums.length

    // n has to be 2 * k + 1
    def check(i: Int): Boolean = {
      // check whether there is 2 * k + 1 elements before nums(i)
      if(i < n - 1 && nums(i) == nums(i + 1)) {
        (i & 1) == 1
      } else if(i > 0 && nums(i) == nums(i-1)) {
        (i & 1) == 0
      } else {
        false
      }
    }

    var left = 0
    var right = n
    while (left < right) {
      val mid = (left + right) / 2
      if (check(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    nums(right - 1)
  }
}
