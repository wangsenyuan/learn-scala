package set300.set300.p300

/**
  * Created by senyuanwang on 2016/10/22.
  */
object Solution {

  def lengthOfLIS(nums: Array[Int]): Int = {
    val n = nums.length
    val stack = Array.ofDim[Int](n)
    var p = 0

    var i = 0
    while (i < n) {
      val j = search(p, stack(_) >= nums(i))
      if (j == p) {
        stack(p) = nums(i)
        p += 1
      } else {
        stack(j) = nums(i)
      }
      i += 1
    }

    p
  }

  private def search(n: Int, fn: Int => Boolean): Int = {
    var left = 0
    var right = n
    while (left < right) {
      val mid = (left + right) / 2
      if (fn(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    left
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(10, 9, 2, 5, 3, 7, 101, 18)
    val ans = lengthOfLIS(nums)
    println(ans)
    println(lengthOfLIS(Array(1, 2, 3, 4, 5)))
  }
}
