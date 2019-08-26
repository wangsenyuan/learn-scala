package set0000.set000.set010.p016

object Solution {

  def threeSumClosest(nums: Array[Int], target: Int): Int = {
    var i = 0
    val n = nums.length
    val xs = nums.sorted

    var delta1 = Int.MaxValue >> 1
    var delta2 = Int.MaxValue >> 1

    while (i < n && delta1 > 0) {
      if (i == 0 || xs(i) > xs(i - 1)) {
        var j = i + 1
        var k = n - 1
        while (j < k && delta1 > 0) {
          if (j > i + 1 && xs(j) == xs(j - 1)) {
            j += 1
          } else if (k < n - 1 && xs(k) == xs(k + 1)) {
            k -= 1
          } else {
            val sum = xs(j) + xs(k) + xs(i)
            if (sum > target) {
              delta1 = delta1 min (sum - target)
              k -= 1
            } else if (sum < target) {
              delta2 = delta2 min (target - sum)
              j += 1
            } else {
              delta1 = 0
              delta2 = 0
              j += 1
              k -= 1
            }
          }
        }
      }

      i += 1
    }
    if (delta1 <= delta2) {
      target + delta1
    } else {
      target - delta2
    }
  }

  def threeSumClosest1(nums: Array[Int], target: Int): Int = {
    val xs = nums.sorted
    val n = xs.length
    var i = 0
    var delta1 = Int.MaxValue / 2
    var delta2 = Int.MaxValue / 2
    while (i < xs.length) {
      if (i == 0 || xs(i) > xs(i - 1)) {
        //skip duplicates
        var j = i + 1
        while (j < xs.length) {
          if (j == i + 1 || xs(j) > xs(j - 1)) {
            //skip duplicates
            // find k that xs(i) + xs(j) + xs(k) >= target
            val k = binarySearch(j + 1, n, xs(_) + xs(i) + xs(j) >= target)
            if (k < n) {
              delta1 = delta1 min (xs(i) + xs(j) + xs(k) - target)
            }
            val l = k - 1
            // xs(i) + xs(j) + xs(l) < target
            if (l > j) {
              delta2 = delta2 min (target - xs(i) - xs(j) - xs(l))
            }
          }
          j += 1
        }
      }
      i += 1
    }

    if (delta1 <= delta2) {
      target + delta1
    } else {
      target - delta2
    }
  }

  def binarySearch(start: Int, end: Int, f: Int => Boolean): Int = {
    var left = start
    var right = end
    while (left < right) {
      val mid = (left + right) >> 1
      if (f(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    left
  }
}
