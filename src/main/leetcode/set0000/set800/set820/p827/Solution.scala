package set0000.set800.set820.p827

object Solution {
  def largestIsland(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid.length
    val set = new Set(m * n)
    for {
      i <- 0 until m
      j <- 0 until n
      if (grid(i)(j) == 1)
    } {
      if (i > 0 && grid(i - 1)(j) == 1) {
        set.union(i * n + j, (i - 1) * n + j)
      }
      if (j > 0 && grid(i)(j - 1) == 1) {
        set.union(i * n + j, i * n + j - 1)
      }
    }


    def getParent(i: Int, j: Int): Int = {
      if (i >= 0 && i < m && j >= 0 && j < n && grid(i)(j) == 1) {
        set.find(i * n + j)
      } else {
        -1
      }
    }

    var best = 0

    for {
      i <- 0 until m
      j <- 0 until n
    } {
      if (grid(i)(j) == 1) {
        best = best max set.count(i * n + j)
      } else {
        val a = getParent(i - 1, j)
        val b = getParent(i, j - 1)
        val c = getParent(i + 1, j)
        val d = getParent(i, j + 1)

        val tmp = Array(a, b, c, d).filter(_ >= 0).distinct.map(x => set.count(x)).sum
        best = best max (tmp + 1)
      }
    }

    best
  }

  class Set(size: Int) {
    val arr = Array.ofDim[Int](size)
    val cnt = Array.ofDim[Int](size)

    (0 until size).foreach(i => {
      arr(i) = i
      cnt(i) = 1
    })

    def find(x: Int): Int = {
      if (arr(x) == x) {
        x
      } else {
        arr(x) = find(arr(x))
        arr(x)
      }
    }

    def union(a: Int, b: Int): Boolean = {
      val pa = find(a)
      val pb = find(b)
      if (pa == pb) {
        false
      } else {
        doUnion(pa, pb)
      }
    }

    private def doUnion(a: Int, b: Int): Boolean = {
      if (cnt(a) >= cnt(b)) {
        arr(b) = a
        cnt(a) += cnt(b)
      } else {
        arr(a) = b
        cnt(b) += cnt(a)
      }
      true
    }

    def count(x: Int) = cnt(find(x))
  }

}
