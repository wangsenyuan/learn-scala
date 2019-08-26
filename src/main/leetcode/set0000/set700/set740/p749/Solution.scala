package set0000.set700.set740.p749

object Solution {
  val dd = Array(-1, 0, 1, 0, -1)
  def containVirus(grid: Array[Array[Int]]): Int = {
    if(grid.length == 0 || grid(0).length == 0) {
      0
    } else {
      val m = grid.length
      val n = grid(0).length

      val flags = Array.ofDim[Int](m, n)

      val que = Array.ofDim[Int](m * n)

      def check(x: Int, y: Int, flag: Int): Int = {
        var front = 0
        var end = 0
        que(end) = x * n + y
        end += 1
        flags(x)(y) = flag
        while(front < end) {
          val cur = que(front)
          val u = cur / n
          val v = cur % n
          front += 1
          var i = 0
          while(i < 4) {
            val a = u + dd(i)
            val b = v + dd(i + 1)
            if(a >= 0 && a < m && b >= 0 && b < n && grid(a)(b) == 1 && flags(a)(b) != flag) {
              flags(a)(b) = flag
              que(end) = a * n + b
              end += 1
            }
            i += 1
          }
        }

        front = 0
        var cnt = 0
        while(front < end) {
          val cur = que(front)
          val u = cur / n
          val v = cur % n
          var i = 0
          while(i < 4) {
            val a = u + dd(i)
            val b = v + dd(i + 1)
            if(a >= 0 && a < m && b >= 0 && b < n && grid(a)(b) == 0) {
              cnt += 1
              grid(a)(b) = -1
            }
            i += 1
          }

          front += 1
        }

        for {
          i <- 0 until m
          j <- 0 until n
          if grid(i)(j) == -1
        } {
          grid(i)(j) = 0
        }

        cnt
      }

      def buildWalls(x: Int, y: Int, flag: Int): Int = {
        var front = 0
        var end = 0
        que(end) = x * n + y
        end += 1
        grid(x)(y) = flag
        while(front < end) {
          val cur = que(front)
          front += 1
          val u = cur / n
          val v = cur % n
          var i = 0
          while(i < 4) {
            val a = u + dd(i)
            val b = v + dd(i + 1)
            if(a >= 0 && a < m && b >= 0 && b < n && grid(a)(b) == 1) {
              grid(a)(b) = flag
              que(end) = a * n + b
              end += 1
            }

            i += 1
          }
        }

        var res = 0
        for {
          i <- 0 until m
          j <- 0 until n
          if grid(i)(j) == 0
          k <- 0 until 4
          u = i + dd(k)
          v = j + dd(k + 1)
          if u >= 0 && u < m && v >= 0 && v < n && grid(u)(v) == flag
        } {
          res += 1
        }
        res
      }

      def affect(): Unit = {
        for {
          i <- 0 until m
          j <- 0 until n
          if grid(i)(j) == 0
          k <- 0 until 4
          u = i + dd(k)
          v = j + dd(k + 1)
          if u >= 0 && u < m && v >=0 && v < n && grid(u)(v) == 1
        } {
          grid(i)(j) = -1
        }
        for {
          i <- 0 until m
          j <- 0 until n
          if grid(i)(j) == -1
        } {
          grid(i)(j) = 1
        }
      }

      def loop(sum: Int, flag: Int): Int = {
        var x = -1
        var y = -1
        var cnt = 0
        for {
          i <- 0 until m
          j <- 0 until n
          if(grid(i)(j) == 1 && flags(i)(j) != flag)
        } {
          val tmp = check(i, j, flag)
          if(tmp > cnt) {
            x = i
            y = j
            cnt = tmp
          }
        }

        if(cnt > 0) {
          cnt = buildWalls(x, y, Int.MaxValue - flag)

          affect()

          loop(sum + cnt, flag + 1)
        } else {
          sum
        }
      }

      loop(0, 1)
    }
  }
}
