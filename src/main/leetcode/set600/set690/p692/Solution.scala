package set600.set690.p692

import scala.collection.mutable

object Solution {
  def topKFrequent(words: Array[String], k: Int): List[String] = {
    val count = mutable.Map.empty[String, Int].withDefaultValue(0)

    words.foreach(word => count(word) += 1)

    val pq = mutable.PriorityQueue.empty(new Ordering[(String, Int)]() {
      override def compare(x: (String, Int), y: (String, Int)): Int =  {
        if(x._2 < y._2) {
          // go to end
          1
        } else if(x._2 > y._2) {
          -1
        } else if(x._1.compareTo(y._1) < 0) {
          -1
        } else if(x._1.compareTo(y._1) > 0) {
          1
        } else {
          0
        }
      }

    })

    count.foreach(e => {
      if(pq.size < k) {
        pq.enqueue(e)
      } else {
        val head = pq.head
        if(e._2 > head._2 || (e._2 == head._2 && e._1.compareTo(head._1) < 0)) {
          pq.dequeue()
          pq.enqueue(e)
        }
      }
    })
    val left = pq.dequeueAll
    left.map(_._1).reverse.toList
  }
}
