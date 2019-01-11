package set200.set210.p213

object Solution {
  def rob(nums: Array[Int]): Int = {
    val n = nums.length
    if (n == 0) {
      0
    } else if (n == 1) {
      nums(0)
    } else if (n == 2) {
      nums(0) max nums(1)
    } else {
      //not rob 0
      var a = 0
      var b = nums(1)
      var i = 2
      while (i < n) {
        val tmp = a + nums(i)
        a = b
        b = b max tmp
        i += 1
      }

      //rob 0
      var c = nums(0)
      var d = nums(0)
      i = 2
      while (i < n - 1) {
        val tmp = c + nums(i)
        c = d
        d = d max tmp
        i += 1
      }

      b max d
    }
  }
}
