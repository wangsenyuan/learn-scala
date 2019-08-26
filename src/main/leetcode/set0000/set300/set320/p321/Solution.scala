package set0000.set300.set320.p321

object Solution {
  def maxNumber(nums1: Array[Int], nums2: Array[Int], k: Int): Array[Int] = {

    def cal(num: Array[String]): Array[Array[String]] = {
      val n = num.length
      val dp = Array.fill(n, k + 1)("")

      for {
        j <- 1 to (k min n)
        i <- (n - 1) to 0 by -1
      } {
        dp(i)(j) = if (i == n - 1) {
          num(i)
        } else if (j == 1) {
          max(num(i), dp(i + 1)(j))
        } else {
          max(dp(i + 1)(j), num(i) + dp(i + 1)(j - 1))
        }
      }
      dp
    }

    val x = cal(nums1.map(_.toString))
    val y = cal(nums2.map(_.toString))

    val res = if (x.length == 0 && y.length == 0) {
      ""
    } else if (x.length == 0) {
      y(0)(k)
    } else if (y.length == 0) {
      x(0)(k)
    } else {
      val cmp = Array.ofDim[Int](k + 1, k + 1)
      var best = ""
      for {
        a <- 0 to (k min nums1.length)
        b = k - a
        if b <= nums2.length
      } {
        best = max(best, merge(x(0)(a), y(0)(b), cmp))
      }
      best
    }

    res.map(x => (x - '0')).toArray
  }

  private def merge(a: String, b: String, cmp: Array[Array[Int]]): String = {
    val m = a.length
    val n = b.length

    initCmp(cmp, m, n)

    for {
      i <- m - 1 to 0 by -1
      j <- n - 1 to 0 by -1
    } {
      cmp(i)(j) = if (a(i) == b(j)) {
        cmp(i + 1)(j + 1)
      } else if (a(i) > b(j)) {
        1
      } else {
        -1
      }
    }


    var i = 0
    var j = 0
    var res = ""

    while (i < a.length) {
      while (j < b.length && cmp(i)(j) <= 0) {
        res += b(j)
        j += 1
      }
      res += a(i)
      i += 1
    }

    while (j < b.length) {
      res += b(j)
      j += 1
    }

    res
  }

  private def initCmp(cmp: Array[Array[Int]], m: Int, n: Int) = {
    cmp(m)(n) = 0

    for {
      i <- 0 until m
    } {
      cmp(i)(n) = 1
    }
    for {
      j <- 0 until n
    } {
      cmp(m)(j) = -1
    }
  }

  private def max(a: String, b: String): String = {
    if (a.length > b.length) {
      a
    } else if (a.length < b.length) {
      b
    } else {
      val res = a.compareTo(b)
      if (res >= 0) {
        a
      } else {
        b
      }
    }
  }

}
