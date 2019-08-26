package set0000.set000.set000.p001

object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = nums.groupBy(identity).mapValues(_.size).toMap

    def count(num: Int): Int = map.getOrElse(num, 0)

    var first = -1
    var second = -1
    if (((target & 1) == 0) && count(target >> 1) > 1) {
      val half = target >> 1
      first = nums.indexOf(half)
      second = nums.indexOf(half, first + 1)
    } else {
      var i = 0
      while (i < nums.length && first < 0) {
        val num = nums(i)
        val other = target - num

        if (num != other && count(other) > 0) {
          first = i
          second = nums.indexOf(other)
        }

        i += 1
      }
    }
    Array(first, second)
  }
}
