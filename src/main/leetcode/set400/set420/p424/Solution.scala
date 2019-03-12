package set400.set420.p424

object Solution {

  def characterReplacement(s: String, k: Int): Int = {
    val cnt = Array.ofDim[Int](26)
    var max = 0
    var j = 0
    var best = 0
    for {
      i <- s.indices
    } {
      cnt(s(i) - 'A') += 1
      if (cnt(s(i) - 'A') > max) {
        max = cnt(s(i) - 'A')
      }

      if (i - j + 1 - max > k) {
        cnt(s(j) - 'A') -= 1
        j += 1
      }

      best = best max (i - j + 1)
    }

    best
  }

  def characterReplacement1(s: String, k: Int): Int = {
    val n = s.length
    val sum = Array.ofDim[Int](n + 1, 26)
    for {
      i <- 0 until n
      x = s(i) - 'A'
    } {
      for {
        j <- 0 until 26
      } {
        sum(i + 1)(j) = sum(i)(j)
      }
      sum(i + 1)(x) += 1
    }

    def search2(i: Int, x: Int): Int = {
      val a = i - sum(i)(x)
      var left = i
      var right = n
      while (left < right) {
        val mid = (left + right) / 2
        val b = mid + 1 - sum(mid + 1)(x)
        if (b - a > k) {
          right = mid
        } else {
          left = mid + 1
        }
      }
      right - 1
    }

    def search(i: Int): Int = {
      var best = 0
      for {
        x <- 0 until 26
      } {
        best = best max search2(i, x)
      }
      best
    }

    var best = 0
    for {
      i <- 0 until n
    } {
      val j = search(i)
      best = (j - i + 1) max best
    }

    best
  }
}
