package set400.set480.p485

object Solution {
  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    val n = nums.length
    var ans = 0
    var i = 0
    while (i < n) {
      if (nums(i) == 1) {
        var j = i
        while (j < n && nums(j) == 1) {
          j += 1
        }
        ans = ans max (j - i)
        i = j
      } else {
        i += 1
      }
    }
    ans
  }
}
