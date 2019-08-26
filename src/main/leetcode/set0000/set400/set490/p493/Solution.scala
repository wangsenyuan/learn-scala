package set0000.set400.set490.p493

object Solution {
  def reversePairs(nums: Array[Int]): Int = {
    val n = nums.length

    val ss = nums.sorted.reverse

    val bits = Array.ofDim[Int](n + 1)

    def update(pos: Int): Unit = {
      var p = pos + 1
      while (p <= n) {
        bits(p) += 1
        p += p & -p
      }
    }

    def query(pos: Int): Int = {
      var p = pos + 1
      var res = 0
      while (p > 0) {
        res += bits(p)
        p -= p & -p
      }
      res
    }

    var res = 0

    for {
      i <- nums.indices
    } {
      val j = binarySearch(n, ss(_) <= 2L * nums(i)) - 1
      res += query(j)
      val k = binarySearch(n, ss(_) <= nums(i))
      update(k)
    }

    res
  }

  private def binarySearch(n: Int, fn: Int => Boolean): Int = {
    var left = 0
    var right = n
    while (left < right) {
      val mid = left + (right - left) / 2
      if (fn(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    left
  }

}

