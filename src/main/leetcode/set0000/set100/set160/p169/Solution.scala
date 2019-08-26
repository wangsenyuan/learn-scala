package set0000.set100.set160.p169

object Solution {
  def majorityElement(nums: Array[Int]): Int = {
    var res = nums(0)
    var count = 1
    var i = 1
    while (i < nums.length) {
      if (count == 0 || res == nums(i)) {
        res = nums(i)
        count += 1
      } else {
        count -= 1
      }

      i += 1
    }
    res
  }
}
