package set0000.set900.set980.p980

object Solution {
  val dd = Array(-1, 0, 1, 0, -1)


  def uniquePathsIII(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid(0).length
    val N = m * n
    var flag = 0
    var x = 0
    var y = 0
    var u = 0
    var v = 0
    var cnt = 0
    for {
      i <- 0 until m
      j <- 0 until n
    } {
      if (grid(i)(j) == 2) {
        u = i
        v = j
      } else if (grid(i)(j) == 1) {
        x = i
        y = j
      } else if (grid(i)(j) < 0) {
        flag |= (1 << (i * n + j))
        cnt += 1
      }
    }

    flag |= 1 << (x * n + y)
    cnt += 1

    val dp = Array.ofDim[Int](1 << N, N)
    dp(flag)(x * n + y) = 1

    while (cnt < N) {
      var num = 0
      var i = 0
      while (i < cnt) {
        num |= 1 << i
        i += 1
      }

      while (num < (1 << N)) {
        var pos = 0
        while (pos < N) {
          if (dp(num)(pos) > 0) {
            val a = pos / n
            val b = pos % n
            var k = 0
            while (k < 4) {
              val c = a + dd(k)
              val d = b + dd(k + 1)
              if (c >= 0 && c < m && d >= 0 && d < n && grid(c)(d) >= 0 && (num & (1 << (c * n + d))) == 0) {
                dp(num | (1 << (c * n + d)))(c * n + d) += dp(num)(pos)
              }
              k += 1
            }
          }
          pos += 1
        }

        num = nextSameBitsNum(num)
      }

      cnt += 1
    }

    dp((1 << N) - 1)(u * n + v)
  }

  private def nextSameBitsNum(v: Int): Int = {
    val t = (v | (v - 1)) + 1
    t | ((((t & -t) / (v & -v)) >> 1) - 1)
  }

  def uniquePathsIII1(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid(0).length

    val N = 1 << (m * n)

    def dfs(x: Int, y: Int, flag: Int): Int = {
      if (grid(x)(y) == 2) {
        if (flag == N - 1) {
          1
        } else {
          0
        }
      } else {
        var res = 0

        var k = 0
        while (k < 4) {
          val u = x + dd(k)
          val v = y + dd(k + 1)
          if (u >= 0 && u < m && v >= 0 && v < n && !visited(flag, u, v, n)) {
            res += dfs(u, v, flag | (1 << (u * n + v)))
          }
          k += 1
        }

        res
      }
    }

    var flag = 0
    var x = 0
    var y = 0
    for {
      i <- 0 until m
      j <- 0 until n

    } {
      if (grid(i)(j) == 1) {
        x = i
        y = j
      } else if (grid(i)(j) < 0) {
        flag |= (1 << (i * n + j))
      }

    }

    dfs(x, y, flag | (1 << (x * n + y)))
  }

  private def visited(flag: Int, x: Int, y: Int, n: Int): Boolean = {
    val pos = x * n + y
    (flag & (1 << pos)) > 0
  }
}
