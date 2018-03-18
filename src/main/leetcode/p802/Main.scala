package p802

import scala.collection.mutable.ListBuffer

object Main {

  def eventualSafeNodes(graph: Array[Array[Int]]): List[Int] = {
    val n = graph.length
    val degrees = Array.fill(n)(0)

    val rg = Array.fill(n)(Vector.empty[Int])

    (0 until n).foreach {
      i =>
        graph(i).foreach {
          j =>
            degrees(i) += 1
            rg(j) = rg(j) :+ i
        }
    }


    val que = Array.fill(n)(0)
    var head = 0
    var tail = 0

    (0 until n).filter(degrees(_) == 0).foreach {
      i =>
        que(tail) = i
        tail += 1
    }
    val ans = ListBuffer.empty[Int]
    while (head < tail) {
      val tt = tail
      while (head < tt) {
        val v = que(head)
        head += 1
        ans += v
        rg(v).foreach {
          w =>
            degrees(w) -= 1
            if (degrees(w) == 0) {
              que(tail) = w
              tail += 1
            }
        }
      }
    }
    ans.sorted.toList
  }
}
