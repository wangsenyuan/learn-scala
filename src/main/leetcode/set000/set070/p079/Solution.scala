package set000.set070.p079

object Solution {
  val dd = Array(-1, 0, 1, 0, -1)

  def exist(board: Array[Array[Char]], word: String): Boolean = {
    val m = board.length
    if (m == 0) {
      false
    } else {
      val n = board(0).length
      if (n == 0) {
        false
      } else {
        val labels = Array.fill(m, n)(-1)

        def dfs(x: Int, y: Int, s: String, label: Int): Boolean = {
          if (s.isEmpty) {
            true
          } else if (x < 0 || x >= m || y < 0 || y >= n) {
            false
          } else if (labels(x)(y) == label) {
            false
          } else if (board(x)(y) != s.head) {
            false
          } else {
            labels(x)(y) = label
            val res = (0 until 4).exists(k => {
              val u = x + dd(k)
              val v = y + dd(k + 1)
              dfs(u, v, s.tail, label)
            })
            labels(x)(y) = -1
            res
          }
        }

        var label = 0
        var found = false
        var i = 0
        while (i < m && !found) {
          var j = 0
          while (j < n && !found) {
            found = dfs(i, j, word, label)
            label += 1
            j += 1
          }

          i += 1
        }
        found
      }
    }

  }
}
