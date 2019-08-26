package set0000.set600.set680.p684

object Solution {
  def findRedundantConnection(edges: Array[Array[Int]]): Array[Int] = {
    val set = new Set(edges.length)
    var i = 0
    while(i < edges.length) {
      val a = edges(i)(0) - 1
      val b = edges(i)(1) - 1
      if(!set.union(a, b)) {
        return edges(i)
      }

      i += 1
    }

    return Array()
  }

  class Set(size: Int) {
    val arr = Array.ofDim[Int](size)
    val cnt = Array.ofDim[Int](size)

    (0 until size).foreach(i => {
      arr(i) = i
      cnt(i) = 1
    })

    def find(x: Int): Int = {
      if(arr(x) == x) {
        x
      } else {
        arr(x) = find(arr(x))
        arr(x)
      }
    }

    def union(a: Int, b: Int): Boolean = {
      val pa = find(a)
      val pb = find(b)
      if(pa == pb) {
        false
      } else {
        doUnion(pa, pb)
      }
    }

    private def doUnion(a: Int, b: Int): Boolean = {
      if(cnt(a) >= cnt(b)) {
        arr(b) = a
        cnt(a) += cnt(b)
      } else {
        arr(a) = b
        cnt(b) += cnt(a)
      }
      true
    }
  }
}
