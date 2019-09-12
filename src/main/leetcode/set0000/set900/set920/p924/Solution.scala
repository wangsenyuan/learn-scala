package set0000.set900.set920.p924

import scala.util.Sorting

object Solution {
  def minMalwareSpread(graph: Array[Array[Int]], initial: Array[Int]): Int = {
    val n = graph.length
    val set = new UF(n)

    Sorting.quickSort(initial)

    for {
      i <- 0 until n
      j <- (i + 1) until n
      if (graph(i)(j) == 1)
    } {
      set.union(i, j)
    }

    val pp = Array.fill(initial.length)(-1)
    val cnt = Array.fill(initial.length)(1)

    (0 until initial.length).foreach(i => pp(i) = i)

    for {
      i <- 0 until initial.length
      j <- (i + 1) until initial.length
    } {
      val x = initial(i)
      val y = initial(j)
      val px = set.find(x)
      val py = set.find(y)
      if (px == py) {
        // remove one of them no effect
        pp(j) = pp(i)
        cnt(pp(i)) += 1
      }
    }
    var ans = -1
    var save = 0
    for {
      i <- initial.length - 1 to 0 by -1
      if pp(i) == i
    } {
      if (cnt(i) == 1) {
        // only one infected node in its group
        val tmp = set.count(initial(i))
        if (tmp >= save) {
          ans = i
          save = tmp
        }
      } else if (save == 0) {
        // no one can be saved, just update as small index
        ans = i
      }
    }
    initial(ans)
  }

  class UF(size: Int) {
    val arr = Array.ofDim[Int](size)
    val cnt = Array.ofDim[Int](size)

    (0 until size).foreach(i => {
      arr(i) = i
      cnt(i) = 1
    })

    def find(x: Int): Int = {
      if (arr(x) != x) {
        arr(x) = find(arr(x))
      }
      arr(x)
    }

    def union(a: Int, b: Int): Boolean = {
      val pa = find(a)
      val pb = find(b)
      if (pa == pb) {
        false
      } else {
        if (cnt(pa) > cnt(pb)) {
          arr(pb) = pa
          cnt(pa) += cnt(pb)
        } else {
          arr(pa) = pb
          cnt(pb) += cnt(pa)
        }
        true
      }
    }

    def count(x: Int): Int = {
      cnt(find(x))
    }
  }

}
