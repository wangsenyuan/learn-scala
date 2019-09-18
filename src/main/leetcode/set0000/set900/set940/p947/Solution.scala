package set0000.set900.set940.p947

object Solution {
  def removeStones(stones: Array[Array[Int]]): Int = {
    val n = stones.length

    val set = new UF(n)

    for {
      i <- 0 until n
      j <- i + 1 until n
      if stones(i)(0) == stones(j)(0) || stones(i)(1) == stones(j)(1)
    } {
      set.union(i, j)
    }

    set.roots.map(x => set.count(x) - 1).sum
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

    def union(a: Int, b: Int): Unit = {
      val pa = find(a)
      val pb = find(b)
      if (pa != pb) {
        if (cnt(pa) > cnt(pb)) {
          cnt(pa) += cnt(pb)
          arr(pb) = pa
        } else {
          cnt(pb) += cnt(pa)
          arr(pa) = pb
        }
      }
    }

    def count(x: Int): Int = cnt(find(x))

    def roots = (0 until size).filter(i => arr(i) == i).toArray
  }

}
