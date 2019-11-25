package set1000.set1100.set1150.p1156

object Solution {
  def maxRepOpt1(text: String): Int = {
    val n = text.length
    if (n <= 0) {
      n
    } else {
      val cnt = Array.ofDim[Int](26)
      for {
        x <- text
      } {
        cnt(x - 'a') += 1
      }


      val left = Array.ofDim[Int](n)
      left(0) = 1
      for {
        i <- 1 until n
      } {
        left(i) = 1
        if (text(i) == text(i - 1)) {
          left(i) += left(i - 1)
        }
      }

      val right = Array.ofDim[Int](n)
      right(n - 1) = 1
      for {
        i <- (n - 2) to 0 by -1
      } {
        right(i) = 1
        if (text(i) == text(i + 1)) {
          right(i) += right(i + 1)
        }
      }

      var best = left.max

      for {
        i <- 0 until n
      } {
        if (i > 0 && left(i) == 1 && cnt(text(i - 1) - 'a') > left(i - 1)) {
          best = best max (left(i - 1) + 1)
        }
        if (i < n - 1 && right(i) == 1 && cnt(text(i + 1) - 'a') > right(i + 1)) {
          best = best max (right(i + 1) + 1)
        }
        if (i > 0 && i < n - 1 && left(i) == 1 && right(i) == 1 && text(i - 1) == text(i + 1)) {
          // can connect both
          if (cnt(text(i - 1) - 'a') > left(i - 1) + right(i + 1)) {
            best = best max (left(i - 1) + right(i + 1) + 1)
          } else {
            best = best max (left(i - 1) + right(i + 1))
          }
        }
      }
      best
    }
  }
}
