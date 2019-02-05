package set300.set320.p321

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
      var best = ""
      for {
        a <- 0 to (k min nums1.length)
        b = k - a
        if b <= nums2.length
      } {
        best = max(best, merge(x(0)(a), y(0)(b)))
      }
      best
    }

    res.map(x => (x - '0')).toArray
  }

  private def merge(a: String, b: String): String = {
    var i = 0
    var j = 0
    var res = ""

    while (i < a.length) {
      while (j < b.length && compare(a.substring(i), b.substring(j)) <= 0) {
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

  private def compare(a: String, b: String): Int = {
    def go(i: Int, j: Int): Int = {
      if (i == a.length && j == b.length) {
        0
      } else if (i == a.length) {
        -1
      } else if (j == b.length) {
        1
      } else if (a(i) < b(j)) {
        -1
      } else if (a(i) > b(j)) {
        1
      } else {
        go(i + 1, j + 1)
      }
    }

    go(0, 0)
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
