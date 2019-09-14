package set0000.set900.set920.p928

import scala.util.Sorting

object Solution {
  def minMalwareSpread(graph: Array[Array[Int]], initial: Array[Int]): Int = {
    Sorting.quickSort(initial)
    val n = graph.length
    val m = initial.length
    val que = Array.ofDim[Int](n)

    val affected = Array.ofDim[Boolean](n)

    def spread(removed: Int): Int = {

      (0 until n).foreach(i => affected(i) = false)

      var end = 0

      (0 until m).foreach(i => {
        if (initial(i) != removed) {
          affected(initial(i)) = true
          que(end) = initial(i)
          end += 1
        }
      })

      var front = 0
      while (front < end) {
        val u = que(front)
        front += 1

//        val outs = graph(u)

        var i = 0
        while (i < n) {
          if (i != removed && !affected(i) && graph(u)(i) == 1) {
            que(end) = i
            end += 1
            affected(i) = true
          }
          i += 1
        }
      }

      affected.count(identity)
    }

    var ans = -1
    var save = 0

    initial.foreach(u => {
      val tmp = spread(u)
      if (ans < 0 || n - tmp > save) {
        save = n - tmp
        ans = u
      }
    })
    ans
  }
}
