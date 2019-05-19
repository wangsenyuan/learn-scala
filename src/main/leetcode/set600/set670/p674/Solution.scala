package set600.set670.p674

object Solution {
  def findLengthOfLCIS(nums: Array[Int]): Int = {
    var j = 0
    var i = 1
    var ans = 0
    while(i <= nums.length) {
      if(i == nums.length || nums(i) <= nums(i - 1)) {
        ans = ans max (i - j)
        j = i
      }

      i += 1
    }
    ans
  }
}
