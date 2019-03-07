package set400.set410.p414

object Solution {
  def thirdMax(nums: Array[Int]): Int = {
    var first = Long.MinValue
    var second = Long.MinValue
    var third = Long.MinValue

    var i = 0
    while (i < nums.length) {
      if(nums(i) == first) {
        // no change
      } else if (nums(i) > first) {
        third = second
        second = first
        first = nums(i)
      } else if(nums(i) == second) {
        // no change
      } else if (nums(i) > second) {
        third = second
        second = nums(i)
      } else if (nums(i) > third) {
        third = nums(i)
      }

      i += 1
    }
    if (third == Long.MinValue) {
      first.toInt
    } else {
      third.toInt
    }
  }
}
