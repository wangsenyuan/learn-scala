package set200.set220.p228

object Solution {
  def summaryRanges(nums: Array[Int]): List[String] = {
    val n = nums.length
    var j = 0
    var i = 1
    var res = List.empty[String]
    while (i <= n) {
      if (i == n || nums(i - 1) + 1 < nums(i)) {
        if (j < i - 1) {
          res = s"${nums(j)}->${nums(i - 1)}" :: res
        } else {
          res = s"${nums(j)}" :: res
        }
        j = i
      }

      i += 1
    }
    res.reverse
  }
}
