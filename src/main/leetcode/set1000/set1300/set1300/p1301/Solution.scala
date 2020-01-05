package set1000.set1300.set1300.p1301

object Solution {
  val MOD = 1000000007

  def pathsWithMaxScore(board: List[String]): Array[Int] = {
    val n = board.length
    val grid = board.toArray

    val dp = Array.fill(2, n)(-1)
    val vis = Array.fill(2, n)(false)
    val cnt = Array.fill(2, n)(0)

    def update(x: Char, i: Int, j: Int, c: Int, v: Int): Unit = {
      val y =
        if (x == 'E') {
          0
        } else {
          x - '0'
        }
      val z = v + y
      if (dp(i)(j) == z) {
        cnt(i)(j) += c
        if (cnt(i)(j) >= MOD) {
          cnt(i)(j) -= MOD
        }
      } else if (dp(i)(j) < z) {
        cnt(i)(j) = c
        dp(i)(j) = z
      }
      vis(i)(j) = true
    }

    dp(1)(n - 1) = 0
    vis(1)(n - 1) = true
    cnt(1)(n - 1) = 1
    var p = 1
    var i = n - 1
    while (i >= 0) {
      val q = 1 - p

      var j = 0

      while (j < n) {
        dp(q)(j) = -1
        vis(q)(j) = false
        cnt(q)(j) = 0
        j += 1
      }

      j = n - 1

      while (j >= 0) {
        if (vis(p)(j)) {
          // top
          if (i > 0 && grid(i - 1)(j) != 'X') {
            update(grid(i - 1)(j), q, j, cnt(p)(j), dp(p)(j))
          }
          if (j > 0 && grid(i)(j - 1) != 'X') {
            update(grid(i)(j - 1), p, j - 1, cnt(p)(j), dp(p)(j))
          }
          if (i > 0 && j > 0 && grid(i - 1)(j - 1) != 'X') {
            update(grid(i - 1)(j - 1), q, j - 1, cnt(p)(j), dp(p)(j))
          }
        }

        j -= 1
      }

      p = q

      i -= 1
    }

    p = 1 - p
    if (!vis(p)(0)) {
      Array(0, 0)
    } else {
      Array(dp(p)(0), cnt(p)(0))
    }
  }
}
