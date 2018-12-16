package set000.set070.p075

object Solution {
  def sortColors(nums: Array[Int]): Unit = {
    def swap(i: Int, j: Int): Unit = {
      nums(i) ^= nums(j)
      nums(j) ^= nums(i)
      nums(i) ^= nums(j)
    }

    val n = nums.length

    var left = 0
    var right = n - 1

    while (left < right) {
      if (nums(left) == 0) {
        left += 1
      } else if (nums(right) == 2) {
        right -= 1
      } else if (nums(left) == 2) {
        swap(left, right)
        right -= 1
      } else if (nums(right) == 0) {
        swap(left, right)
        left += 1
      } else {
        // both ends are one
        var i = left + 1
        while (i < right && nums(i) == 1) {
          i += 1
        }
        if (i == right) {
          //all ones are between
          left = right
        } else {
          //nums(i) != 1
          swap(left, i)
        }
        //don't proceed until next time
      }
    }
  }
}
