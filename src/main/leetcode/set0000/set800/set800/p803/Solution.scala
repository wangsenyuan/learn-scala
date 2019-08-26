package set0000.set800.set800.p803

object Solution {
  def hitBricks(grid: Array[Array[Int]], hits: Array[Array[Int]]): Array[Int] = {
    val hn = hits.length
    val res = Array.ofDim[Int](hn)
    val m = grid.length
    if(m == 0) {
        res
    } else {
      val n = grid(0).length
      if(n == 0) {
        res
      } else {
        val size = m * n

        val at = Array.ofDim[Int](m, n)
        var i = 0
        while(i < hn) {
          val a = hits(i)(0)
          val b = hits(i)(1)

          if(at(a)(b) == 0 && grid(a)(b) == 1) {
            at(a)(b) = i + 1
          }

          i += 1
        }

        i = 0

        while(i < m) {
          var j = 0
          while(j < n) {
            if(grid(i)(j) == 1 && at(i)(j) > 0) {
              grid(i)(j) = 0
            }
            j += 1
          }

          i += 1
        }

        val set = new UF(size + 1)
        val top = m * n

        i = 0
        while(i < m) {
          var j = 0
          while(j < n) {
            if(grid(i)(j) == 1) {
              if(i == 0) {
                set.union(i * n + j, top)
              }
              if(i > 0 && grid(i - 1)(j) == 1) {
                set.union(i * n + j, (i - 1) * n + j)
              }
              if(j > 0 && grid(i)(j - 1) == 1) {
                set.union(i * n + j, i * n + j - 1)
              }
            }

            j += 1
          }

          i += 1
        }

        var total = set.count(top)
        i = hn - 1
        while(i >= 0) {
          val hit = hits(i)
          val a = hit(0)
          val b = hit(1)
          if(at(a)(b) == i + 1) {
            // erasure at hit i
            if(a == 0) {
              set.union(a * n + b, top)
            }
            if(a > 0 && grid(a - 1)(b) == 1) {
              set.union(a * n + b, (a - 1) * n + b)
            }
            if(a < m - 1 && grid(a + 1)(b) == 1) {
              set.union(a * n + b, (a + 1) * n + b)
            }
            if(b > 0 && grid(a)(b - 1) == 1) {
              set.union(a * n + b, a * n + b - 1)
            }
            if(b < n - 1 && grid(a)(b + 1) == 1) {
              set.union(a * n + b, a * n + b + 1)
            }
            grid(a)(b) = 1
          }
          val cur = set.count(top)
          if(cur > total) {
            res(i) = cur - total - 1
            total = cur
          }
          i -= 1
        }

        res
      }
    }
  }

  class UF(val sizeHint: Int) {
    val arr = Array.ofDim[Int](sizeHint)
    val cnt = Array.ofDim[Int](sizeHint)

    var i = 0
    while(i < sizeHint) {
      arr(i) = i
      cnt(i) = 1
      i += 1
    }

    def find(x: Int): Int = {
      if(arr(x) != x) {
        arr(x) = find(arr(x))
      }
      arr(x)
    }

    def union(x: Int, y: Int): Boolean = {
      val px = find(x)
      val py = find(y)
      if(px == py) {
        false
      } else {
        if(cnt(px) > cnt(py)) {
          arr(py) = px
          cnt(px) += cnt(py)

        } else {
          arr(px) = py
          cnt(py) += cnt(px)
        }
        true
      }
    }

    def count(x: Int): Int = {
      val px = find(x)
      cnt(px)
    }
  }
}
