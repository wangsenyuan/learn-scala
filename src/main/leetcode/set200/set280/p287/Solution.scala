package set200.set280.p287

object Solution {
  def findDuplicate(nums: Array[Int]): Int = {

    def loop(slow: Int, fast: Int): Int = {
      if (nums(slow) == nums(nums(fast))) {
        nums(slow)
      } else {
        loop(nums(slow), nums(nums(fast)))
      }
    }

    val fast = loop(nums(0), nums(0))

    def go(a: Int, b: Int): Int = {
      if (a == b) {
        a
      } else {
        go(nums(a), nums(b))
      }
    }

    go(nums(0), fast)
  }
}
