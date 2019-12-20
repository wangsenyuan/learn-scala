package set1000.set1200.set1250.p1254

object Solution {

  val dd = Array(-1, 0, 1, 0, -1)

  def closedIsland(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid(0).length

    if (m < 3 || n < 3) {
      0
    } else {
      val A = Array.ofDim[Int](m, n)
      val que = Array.ofDim[Int](m * n)

      def bfs(x: Int, y: Int, label: Int): Unit = {
        A(x)(y) = label
        var end = 0
        que(end) = x * n + y
        end += 1
        var front = 0
        while (front < end) {
          val cur = que(front)
          front += 1
          val u = cur / n
          val v = cur % n
          var i = 0
          while (i < 4) {
            val a = u + dd(i)
            val b = v + dd(i + 1)
            if (a >= 0 && a < m && b >= 0 && b < n && grid(a)(b) == 0 && A(a)(b) == 0) {
              A(a)(b) = label
              que(end) = a * n + b
              end += 1
            }
            i += 1
          }
        }
      }


      var label = 0
      for {
        i <- 0 until m
        j <- 0 until n
        if grid(i)(j) == 0 && A(i)(j) == 0
      } {
        label += 1
        bfs(i, j, label)
      }

      val checked = Array.ofDim[Boolean](label + 1)
      checked(0) = true
      for {
        i <- 0 until m
      } {
        if (grid(i)(0) == 0) {
          checked(A(i)(0)) = true
        }
        if (grid(i)(n - 1) == 0) {
          checked(A(i)(n - 1)) = true
        }
      }

      for {
        j <- 0 until n
      } {
        if (grid(0)(j) == 0) {
          checked(A(0)(j)) = true
        }

        if (grid(m - 1)(j) == 0) {
          checked(A(m - 1)(j)) = true
        }
      }

      label + 1 - checked.count(identity)
    }
  }
}
