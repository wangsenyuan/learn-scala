package set1000.set1000.set1090.p1092

object Solution {
  def shortestCommonSupersequence(str1: String, str2: String): String = {
    val m = str1.length
    val n = str2.length

    val dp = Array.fill(m + 1, n + 1)(Int.MaxValue)

    dp(0)(0) = 0

    for {
      i <- 0 until m
    } {
      dp(i + 1)(0) = i + 1
    }

    for {
      j <- 0 until n
    } {
      dp(0)(j + 1) = j + 1
    }

    for {
      i <- 0 until m
      j <- 0 until n
    } {
      if (str1(i) == str2(j)) {
        dp(i + 1)(j + 1) = dp(i)(j) + 1
      } else {
        dp(i + 1)(j + 1) = (dp(i + 1)(j) min dp(i)(j + 1)) + 1
      }
    }

    var a = m
    var b = n
    val buf = new StringBuilder

    while (a > 0 && b > 0) {
      if (str1(a - 1) == str2(b - 1)) {
        buf.append(str1(a - 1))
        a -= 1
        b -= 1
      } else if (dp(a - 1)(b) < dp(a)(b - 1)) {
        buf.append(str1(a - 1))
        a -= 1
      } else {
        buf.append(str2(b - 1))
        b -= 1
      }
    }

    while (a > 0) {
      buf.append(str1(a - 1))
      a -= 1
    }
    while (b > 0) {
      buf.append(str2(b - 1))
      b -= 1
    }

    buf.reverse.toString()
  }
}
