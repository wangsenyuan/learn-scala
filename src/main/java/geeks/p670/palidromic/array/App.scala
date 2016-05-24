package geeks.p670.palidromic.array

/**
  * Created by wangsenyuan on 5/24/16.
  */
object App {

  def minOperations(nums: Array[Int]): Int = {
    var i = 0
    var j = nums.length - 1
    var ans = 0
    while (i < j) {
      if (nums(i) == nums(j)) {
        i += 1
        j -= 1
      } else if (nums(i) < nums(j)) {
        nums(i + 1) += nums(i)
        i += 1
        ans += 1
      } else {
        nums(j - 1) += nums(j)
        j -= 1
        ans += 1
      }
    }
    ans
  }
}
