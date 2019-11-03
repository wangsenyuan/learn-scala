package set1000.set1000.set1040.p1046

import scala.collection.mutable

object Solution {
  def lastStoneWeight(stones: Array[Int]): Int = {
    val n = stones.length
    if (n == 1) {
      stones(0)
    } else {
      val pq = mutable.PriorityQueue.empty[Int]
      pq ++= stones

      while (pq.size > 1) {
        val a = pq.dequeue()
        val b = pq.dequeue()
        if (b < a) {
          pq.enqueue(a - b)
        }
      }

      if (pq.isEmpty) {
        0
      } else {
        pq.head
      }
    }
  }
}
