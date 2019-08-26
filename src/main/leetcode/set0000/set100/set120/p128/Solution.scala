package set0000.set100.set120.p128

object Solution {
  def longestConsecutive(nums: Array[Int]): Int = {
    val set = nums.toSet

    var best = 0
    for {
      num <- set
      if !set.contains(num - 1)
    } {
      var cnt = 0
      var tmp = num
      while (set.contains(tmp)) {
        cnt += 1
        tmp += 1
      }
      best = best max cnt
    }

    best
  }

  def longestConsecutive1(nums: Array[Int]): Int = {
    val xs = nums.sorted.distinct
    val ys = xs.zipWithIndex.map(x => x._1 - x._2)
    var i = 1
    var j = 0
    var best = 0
    while (i <= ys.length) {
      if (i == ys.length || ys(i) != ys(i - 1)) {
        best = (i - j) max best
        j = i
      }
      i += 1
    }
    best
  }
}
