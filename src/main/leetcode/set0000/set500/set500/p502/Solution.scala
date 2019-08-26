package set0000.set500.set500.p502

import scala.collection.mutable

object Solution {
  def findMaximizedCapital(k: Int, W: Int, Profits: Array[Int], Capital: Array[Int]): Int = {
    // first is profit, second is capital
    val pq = mutable.PriorityQueue.empty[Int]

    val projects = Profits.zip(Capital).sortBy(_._2)
    val n = projects.length
    var gain = W
    var i = 0
    var j = 0
    while(i < k) {
      while(j < n && gain >= projects(j)._2) {
        pq.enqueue(projects(j)._1)
        j += 1
      }

      if(!pq.isEmpty) {
        gain += pq.dequeue()
      } else {
        i = k
      }

      i += 1
    }

    gain
  }
}
