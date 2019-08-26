package set0000.set000.set080.p085

object Solution {
  def maximalRectangle(matrix: Array[Array[Char]]): Int = {
    if (matrix.length == 0) {
      0
    } else if (matrix(0).length == 0) {
      0
    } else {
      calculate(matrix, matrix.length, matrix(0).length)
    }
  }

  private def calculate(array: Array[Array[Char]], m: Int, n: Int): Int = {
    val left = Array.fill(n)(0)
    val height = Array.fill(n)(0)
    val right = Array.fill(n)(n - 1)

    def go(row: Int, ans: Int): Int = {
      if (row < m) {
        for {
          j <- 0 until n
        } {
          if (array(row)(j) == '1') {
            height(j) += 1
          } else {
            height(j) = 0
          }
        }
        var pivot = 0
        //        left(0) = 0
        for {
          j <- 0 until n
        } {
          if (array(row)(j) == '1') {
            left(j) = left(j) max pivot
          } else {
            left(j) = 0
            pivot = j + 1
          }
        }

        //        right(n - 1) = n - 1
        pivot = n - 1
        for {
          j <- n - 1 to 0 by -1
        } {
          if (array(row)(j) == '1') {
            right(j) = right(j) min pivot
          } else {
            right(j) = n - 1
            pivot = j - 1
          }
        }

        var best = ans

        for {
          j <- 0 until n
        } {
          best = best max height(j) * (right(j) - left(j) + 1)
        }

        go(row + 1, best)
      } else {
        ans
      }
    }

    go(0, 0)
  }

  private def calculate1(array: Array[Array[Char]], m: Int, n: Int): Int = {
    val cnt = Array.fill(m + 1, n + 1)(0)

    for {
      i <- 1 to m
      j <- 1 to n
    } {
      cnt(i)(j) = cnt(i - 1)(j) + cnt(i)(j - 1) - cnt(i - 1)(j - 1) + (array(i - 1)(j - 1) - '0')
    }

    def check(size: Int): Boolean = {
      def check2(i: Int, j: Int, h: Int): Boolean = {
        if (i + h > m) {
          false
        } else {
          val w = (size + h - 1) / h
          if (j + w > n) {
            false
          } else {
            cnt(i + h)(j + w) - cnt(i)(j + w) - cnt(i + h)(j) + cnt(i)(j) == h * w
          }
        }
      }

      var found = false
      var i = 0
      while (i < m && !found) {
        var j = 0
        while (j < n && !found) {
          var h = 1
          while (i + h <= m && !found) {
            found = check2(i, j, h)
            h += 1
          }
          j += 1
        }

        i += 1
      }

      found
    }

    var left = 0
    var right = m * n + 1

    while (left < right) {
      val mid = (left + right) / 2
      if (check(mid)) {
        left = mid + 1
      } else {
        right = mid
      }
    }
    left - 1
  }
}
