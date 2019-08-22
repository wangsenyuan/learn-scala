package set800.set860.p864

object Solution {
  val dd = Array(-1, 0, 1, 0, -1)

  def shortestPathAllKeys(grid: Array[String]): Int = {
    val m = grid.length
    val n = grid(0).length

    val (x, y) = findStart(grid)
    val keyCount = countKeys(grid)

    val N = 1 << keyCount
    val dp = Array.fill(m, n, N)(-1)
    val que = Array.ofDim[Int](m * n * N)

    dp(x)(y)(0) = 0
    var end = 0
    que(end) = x * n * N + y * N
    end += 1
    var front = 0
    while (front < end) {
      val cur = que(front)
      front += 1
      val u = cur / (n * N)
      val v = (cur / N) % n
      val s = cur % N

      var k = 0
      while (k < 4) {
        val a = u + dd(k)
        val b = v + dd(k + 1)
        if (a >= 0 && a < m && b >= 0 && b < n) {
          if (grid(a)(b) == '#') {
            // a wall
          } else if (grid(a)(b) == '.' || grid(a)(b) == '@') {
            // empty
            if (dp(a)(b)(s) == -1) {
              dp(a)(b)(s) = dp(u)(v)(s) + 1
              que(end) = a * n * N + b * N + s
              end += 1
            }
          } else if (isKey(grid(a)(b))) {
            // we can try get key at (a, b)
            val key = grid(a)(b) - 'a'
            if ((s & (1 << key)) == 0) {
              // we dont' have it
              if (dp(a)(b)(s | (1 << key)) < 0) {
                dp(a)(b)(s | (1 << key)) = dp(u)(v)(s) + 1
                que(end) = a * n * N + b * N + (s | (1 << key))
                end += 1
              }
            } else if (dp(a)(b)(s) == -1) {
              dp(a)(b)(s) = dp(u)(v)(s) + 1
              que(end) = a * n * N + b * N + s
              end += 1
            }
          } else {
            // a lock
            if (dp(a)(b)(s) == -1) {
              val key = grid(a)(b) - 'A'

              if ((s & (1 << key)) > 0) {
                // we have the key
                dp(a)(b)(s) = dp(u)(v)(s) + 1
                que(end) = a * n * N + b * N + s
                end += 1
              }
            }
          }
        }
        k += 1
      }
    }

    var ans = -1
    for {
      i <- 0 until m
      j <- 0 until n
    } {
      val tmp = dp(i)(j)(N - 1)
      if (tmp > 0) {
        if (ans < 0 || ans > tmp) {
          ans = tmp
        }
      }
    }

    ans
  }

  private def isKey(c: Char) = c >= 'a' && c <= 'z'

  private def findStart(grid: Array[String]): (Int, Int) = {
    var i = 0
    while (i < grid.length) {
      var j = 0
      while (j < grid(i).length) {
        if (grid(i)(j) == '@') {
          return i -> j
        }
        j += 1
      }
      i += 1
    }
    -1 -> -1
  }

  private def countKeys(grid: Array[String]): Int = {
    grid.map(row => row.count(isKey)).sum
  }
}
