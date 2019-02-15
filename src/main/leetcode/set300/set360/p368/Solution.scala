package set300.set360.p368


object Solution {

  import scala.util.Sorting

  def largestDivisibleSubset(nums: Array[Int]): List[Int] = {
    if (nums.isEmpty) {
      Nil
    } else {

      Sorting.quickSort(nums)

      val n = nums.length
      val dp = Array.ofDim[Int](n)

      var i = 0
      while (i < n) {
        val num = nums(i)
        dp(i) = 1

        var j = i - 1
        while (j >= 0) {
          if (nums(i) % nums(j) == 0) {
            dp(i) = dp(i) max (dp(j) + 1)
          }
          j -= 1
        }

        i += 1
      }

      var mx = dp.max
      var res = List.empty[Int]
      i = n - 1
      while (i >= 0) {
        if (dp(i) == mx) {
          if (res.isEmpty || res.head % nums(i) == 0) {
            res = nums(i) :: res
            mx -= 1
          }
        }
        i -= 1
      }

      res
    }
  }
}
