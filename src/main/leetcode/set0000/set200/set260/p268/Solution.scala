package set0000.set200.set260.p268

object Solution {
  def missingNumber(nums: Array[Int]): Int = {
    val zeroFound = nums.find(_ == 0)
    val n = nums.length
    zeroFound match {
      case None => 0
      case Some(_) =>
        var i = 0
        while (i < n) {
          val num = nums(i).abs
          if (num > 0 && num <= n) {
            nums(num - 1) = if (nums(num - 1) == 0) {
              -(n + 1)
            } else {
              -nums(num - 1)
            }
          }
          i += 1
        }
        i = 0
        while (i < n && nums(i) < 0) {
          i += 1
        }

        i + 1
    }
  }
}
