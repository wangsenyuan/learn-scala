package set100.set190.p198

/**
  * Created by senyuanwang on 15/4/6.
  */
object Solution extends App {
  def rob(nums: Array[Int]): Int = {
    val n = nums.length
    if (n == 0) {
      0
    } else if (n == 1) {
      nums(0)
    } else {
      var a = nums(0)
      var b = nums(1) max nums(0)
      var i = 2
      while (i < n) {
        val c = b max (a + nums(i))
        a = b
        b = c
        i += 1
      }
      a max b
    }
  }
}
