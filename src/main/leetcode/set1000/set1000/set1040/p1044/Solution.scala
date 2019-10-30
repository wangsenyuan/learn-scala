package set1000.set1000.set1040.p1044

import scala.collection.mutable

object Solution {
  def longestDupSubstring(S: String): String = {
    val n = S.length
    val MOD = 1000000000007L

    def check(k: Int): Int = {
      val set = mutable.Set.empty[Long]
      var base = 1L
      var sum = 0L
      var i = 0
      while (i < k) {
        sum = sum * 31 + S(i) - 'a'
        sum %= MOD

        base *= 31
        base %= MOD

        i += 1
      }

      set += sum

      while (i < n) {
        sum = sum * 31 + S(i) - 'a'
        sum %= MOD

        val x = (S(i - k) - 'a').toLong
        sum -= (x * base) % MOD

        if (sum < 0) {
          sum += MOD
        }

        if (set.contains(sum)) {
          return i - k
        }

        set += sum

        i += 1
      }

      -1
    }

    var left = 1
    var right = n
    while (left < right) {
      val mid = (left + right) / 2
      if (check(mid) < 0) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    if (right <= 1) {
      ""
    } else {
      val i = check(right - 1)
      S.substring(i + 1, i + right)
    }
  }
}
