package set300.set370.p378

import scala.collection.mutable

object Solution {
  def kthSmallest(matrix: Array[Array[Int]], k: Int): Int = {
    val pq = new mutable.PriorityQueue[(Int, Int)]()(new Ordering[(Int, Int)]() {
      override def compare(x: (Int, Int), y: (Int, Int)): Int = {
        val (a, b) = x
        val (c, d) = y
        if (matrix(a)(b) < matrix(c)(d)) {
          1
        } else if (matrix(a)(b) > matrix(c)(d)) {
          -1
        } else {
          0
        }
      }
    })

    for {
      y <- 0 until matrix(0).length
    } {
      pq.enqueue(0 -> y)
    }

    var res = 0
    (0 until k) foreach {
      _ =>
        val (x, y) = pq.dequeue()
        res = matrix(x)(y)
        if (x + 1 < matrix.length) {
          pq.enqueue((x + 1) -> y)
        }
    }
    res
  }
}
