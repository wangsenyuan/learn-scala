package set1000.set1200.set1200.p1209

object Solution {
  def removeDuplicates(s: String, k: Int): String = {
    val n = s.length
    val rem = Array.ofDim[Int](n)
    val stack = Array.ofDim[Int](n)
    var l = 0
    var p = 0
    var i = 1
    while (i <= n) {
      l += 1
      if (i == n || s(i) != s(i - 1)) {
        // need to process s(i - 1)
        l %= k
        rem(i - 1) = l
        if (l > 0) {
          stack(p) = i - 1
          p += 1
          l = 0
        } else if (p > 0) {
          if (i < n && s(i) == s(stack(p - 1))) {
            l = rem(stack(p - 1))
            p -= 1
          }
        }
      } else {
        rem(i - 1) = l
      }
      i += 1
    }

    val buf = new StringBuffer()

    i = 0
    while (i < p) {
      val j = stack(i)
      while (rem(j) > 0) {
        buf.append(s(j))
        rem(j) -= 1
      }
      i += 1
    }

    buf.toString
  }
}
