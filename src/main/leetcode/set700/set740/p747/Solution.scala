package set700.set740.p747

object Solution {
  def dominantIndex(nums: Array[Int]): Int = {
    if(nums.length == 1) {
      0
    } else {
      var first = 0
      var i = 1
      while(i < nums.length) {
        if(nums(i) > nums(first)) {
          first = i
        }
        i += 1
      }

      var second = -1
      i = 0
      while(i < nums.length) {
        if(i != first) {
          if(second == -1 || nums(i) > nums(second)) {
            second = i
          }
        }
        i += 1
      }

      if(second == -1) {
        -1
      } else if(nums(second) * 2 > nums(first)) {
        -1
      } else {
        first
      }
    }
  }
}
