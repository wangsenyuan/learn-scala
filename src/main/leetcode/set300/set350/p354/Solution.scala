package set300.set350.p354

object Solution {
  def maxEnvelopes(envelopes: Array[Array[Int]]): Int = {
    val n = envelopes.length

    if (n == 0) {
      0
    } else {
      val ss = envelopes.sortWith((a, b) => {
        if (a(0) != b(0)) {
          a(0) < b(0)
        } else {
          a(1) > b(1)
        }
      })

      val stack = Array.fill(n + 1)(-1)
      var p = 0
      var best = 0
      var i = 0
      while (i < n) {
        val w = ss(i)(0)
        val h = ss(i)(1)
        val j = search(p, k => {
          val env = ss(stack(k))
          env(0) >= w || env(1) >= h
        })

        stack(j) = i
        if (p == j) {
          p += 1
        }

        best = best max j

        i += 1
      }

      best + 1
    }
  }

  private def search(n: Int, fn: Int => Boolean): Int = {
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
    right
  }

}
