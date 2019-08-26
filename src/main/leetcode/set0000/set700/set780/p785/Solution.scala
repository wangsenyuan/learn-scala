package set0000.set700.set780.p785

object Solution {
  def isBipartite(graph: Array[Array[Int]]): Boolean = {
    val n = graph.length
    val color = Array.ofDim[Int](n)

    def dfs(u: Int, c: Int): Boolean = {
      if (color(u) == c) {
        true
      } else if (color(u) == -c) {
        false
      } else {
        color(u) = c
        var can = true
        var i = 0
        while (i < graph(u).length && can) {
          can = dfs(graph(u)(i), -c)
          i += 1
        }
        can
      }
    }

    var can = true
    var u = 0
    while (u < n && can) {
      if (color(u) == 0) {
        can = dfs(u, 1)
      }
      u += 1
    }
    can
  }
}
