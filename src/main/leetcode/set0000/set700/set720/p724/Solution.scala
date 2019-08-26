package set0000.set700.set720.p724

object Solution {
  def pivotIndex(nums: Array[Int]): Int = {
    val n = nums.length
    if(n == 0) {
      -1
    } else {
      val sum = nums.sum
      var left = 0
      var i = 0
      while(i < n) {
        val right = sum - left - nums(i)
        if(left == right) {
          return i
        }
        left += nums(i)
        i += 1
      }
      return -1
    }
  }
}
