package set300.set390.p399

import scala.collection.mutable

object Solution {
  def calcEquation(equations: Array[Array[String]], values: Array[Double], queries: Array[Array[String]]): Array[Double] = {
    val graph = mutable.Map.empty[String, mutable.Map[String, Double]]

    var i = 0
    while (i < equations.length) {
      val equ = equations(i)
      val a = equ(0)
      val b = equ(1)
      val v = values(i)

      if (!graph.contains(a)) {
        graph += a -> mutable.Map.empty[String, Double]
      }
      graph(a) += b -> v

      if (!graph.contains(b)) {
        graph += b -> mutable.Map.empty[String, Double]
      }
      graph(b) += a -> (1.0 / v)

      i += 1
    }

    def dfs(cur: String, target: String, ans: Double, vis: Set[String]): Double = {
      if (cur == target) {
        ans
      } else if (isEmpty(graph, cur)) {
        -1.0
      } else {
        graph(cur).filterNot(item => vis.contains(item._1)).foldLeft(-1.0)((res, item) => {
          if (res >= 0.0) {
            res
          } else {
            dfs(item._1, target, ans * item._2, vis + cur)
          }
        })
      }
    }

    val n = queries.length
    val ans = Array.ofDim[Double](n)

    i = 0
    while (i < n) {
      val query = queries(i)
      val a = query(0)
      val b = query(1)

      ans(i) =
        if (isEmpty(graph, a)) {
          -1.0
        } else {
          dfs(a, b, 1.0, Set.empty)
        }

      i += 1
    }

    ans

  }

  private def isEmpty(map: mutable.Map[String, mutable.Map[String, Double]], key: String): Boolean = {
    !map.contains(key) || map(key).isEmpty
  }
}
