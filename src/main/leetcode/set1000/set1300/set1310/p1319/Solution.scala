package set1000.set1300.set1310.p1319

object Solution {
  def makeConnected(n: Int, connections: Array[Array[Int]]): Int = {
    if (connections.size < n - 1) {
      -1
    } else {
      val uf = new UF(n)
      connections.foreach(conn => {
        uf.union(conn(0), conn(1))
      })

      uf.size - 1
    }
  }

  class UF(n: Int) {
    val arr = Array.ofDim[Int](n)
    val cnt = Array.ofDim[Int](n)
    (0 until n).foreach(i => {
      arr(i) = i
      cnt(i) = 1
    })

    var size = n

    def find(x: Int): Int = {
      if (x != arr(x)) {
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
        size -= 1
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
  }

}
