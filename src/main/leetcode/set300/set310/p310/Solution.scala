package set300.set310.p310

object Solution {
  def findMinHeightTrees(n: Int, edges: Array[Array[Int]]): List[Int] = {
    if (n == 0) {
      Nil
    } else if (n == 1) {
      List(0)
    } else if (n == 2) {
      List(0, 1)
    } else {
      val lines = Array.fill[Vector[Int]](n)(null)

      (0 until n) foreach (i => lines(i) = Vector.empty[Int])

      for {
        edge <- edges
      } {
        val u = edge(0)
        val v = edge(1)
        lines(u) :+= v
        lines(v) :+= u
      }

      val parent = Array.ofDim[Int](n)
      val heights = Array.ofDim[Int](n)

      def dfs(p: Int, u: Int, level: Int): Unit = {
        parent(u) = p
        heights(u) = level
        lines(u) foreach (v => {
          if (p != v) {
            dfs(u, v, level + 1)
          }
        })
      }

      dfs(-1, 0, 0)

      def findMaxHeightAt(): Int = {
        var res = 0
        var i = 1
        while (i < n) {
          if (heights(i) > heights(res)) {
            res = i
          }
          i += 1
        }
        res
      }

      val first = findMaxHeightAt()

      var i = 0
      while (i < n) {
        heights(i) = 0
        i += 1
      }

      dfs(-1, first, 0)


      def findMidAt(from: Int, h: Int): Int = {
        var i = from
        while (heights(i) > h) {
          i = parent(i)
        }
        i
      }

      val second = findMaxHeightAt()

      if (heights(second) % 2 == 1) {
        //two
        val a = findMidAt(second, heights(second) / 2 + 1)
        List(a, parent(a))
      } else {
        val a = findMidAt(second, heights(second) / 2)
        List(a)
      }
    }
  }
}
