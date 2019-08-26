package set0000.set300.set330.p334

object Solution {
  def increasingTriplet(nums: Array[Int]): Boolean = {
    val n = nums.length
    if (n < 3) {
      false
    } else {
      var first = -1
      var second = -1
      var found = false
      var i = 0
      while (i < n && !found) {
        if (first == -1 || nums(i) <= nums(first)) {
          first = i
        } else if (second == -1 || nums(i) <= nums(second)) {
          second = i
        } else {
          found = true
        }
        i += 1
      }
      found
    }
  }
}
