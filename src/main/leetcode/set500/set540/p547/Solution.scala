package set500.set540.p547

object Solution {
  def findCircleNum(M: Array[Array[Int]]): Int = {
      val n = M.length
      val set = new UF(n)

      for {
        i <- 0 until n
        j <- i + 1 until n
        if(M(i)(j) == 1)
      } {
        set.union(i, j)
      }

      set.size()
  }

  class UF(n: Int) {
    val arr = Array.ofDim[Int](n)
    var cnt = Array.ofDim[Int](n)
    var sz = n
    for {
      i <- 0 until n
    } {
      arr(i) = i
      cnt(i) = 1
    }

    def find(x: Int): Int = {
      def loop(x: Int): Int = {
        if(arr(x) != x) {
          arr(x) = loop(arr(x))
        }
        arr(x)
      }
      loop(x)
    }

    def union(x: Int, y: Int): Boolean = {
      val px = find(x)
      val py = find(y)
      if(px == py) {
        false
      } else {
        sz -= 1
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

    def size() = sz
  }
}
