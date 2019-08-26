package set0000.set000.set020.p026

object Solution {
  def removeDuplicates(nums: Array[Int]): Int = {
    var i = 1
    var j = 0
    while (i <= nums.length) {
      if (i == nums.length || nums(i) > nums(i - 1)) {
        nums(j) = nums(i)
        j += 1
      }
      i += 1
    }
    j
  }
}
