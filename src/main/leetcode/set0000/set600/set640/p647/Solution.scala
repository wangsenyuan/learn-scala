package set0000.set600.set640.p647

import scala.collection.mutable.ArrayBuffer

object Solution {
  def countSubstrings(s: String): Int = {
    val n = s.length
    val buf = ArrayBuffer.empty[Char]
    buf.append('@')
    buf.append('#')

    s.foreach(c => {
      buf.append(c)
      buf.append('#')
    })

    buf.append('$')

    val S = buf.mkString("")

    val Z = Array.ofDim[Int](S.length)
    var center = 0
    var right = 0
    var i = 1
    while (i < Z.length - 1) {
      if (i < right) {
        Z(i) = (right - i) min Z(2 * center - i)
      }

      while (S(i + Z(i) + 1) == S(i - Z(i) - 1)) {
        Z(i) += 1
      }

      if (i + Z(i) > right) {
        center = i
        right = i + Z(i)
      }

      i += 1
    }

    Z.map(v => (v + 1) / 2).sum
  }

  def countSubstrings1(s: String): Int = {
    val n = s.length

    val pal = Array.ofDim[Int](n, n + 1)

    var i = 0

    while (i < n) {
      pal(i)(i + 1) = 1

      if (i + 1 < n && s(i) == s(i + 1)) {
        pal(i)(i + 2) = 1
      }

      i += 1
    }

    var len = 3
    while (len <= n) {
      i = 0
      while (i + len <= n) {
        val j = i + len - 1
        if (s(i) == s(j)) {
          pal(i)(i + len) = pal(i + 1)(i + len - 1)
        }
        i += 1
      }

      len += 1
    }

    val dp = Array.ofDim[Int](n, n + 1)

    i = 0
    while (i < n) {
      dp(i)(i + 1) = 1
      i += 1
    }

    len = 2
    while (len <= n) {
      i = 0
      while (i + len <= n) {
        val j = i + len - 1

        dp(i)(i + len) = dp(i)(j) + dp(i + 1)(i + len) - dp(i + 1)(j) + pal(i)(i + len)

        i += 1
      }

      len += 1
    }

    dp(0)(n)
  }
}
