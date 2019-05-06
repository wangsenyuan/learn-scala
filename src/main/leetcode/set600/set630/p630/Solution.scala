package set600.set630.p630

import scala.collection.mutable
import scala.util.Sorting

object Solution {
  def scheduleCourse(courses: Array[Array[Int]]): Int = {
    val pq = mutable.PriorityQueue.empty[Int]

    // order by deadline
    Sorting.quickSort(courses)(new Ordering[Array[Int]]() {
      override def compare(x: Array[Int], y: Array[Int]): Int = {
        Ordering.Int.compare(x(1), y(1))
      }
    })

    var best = 0
    var cur = 0
    courses.foreach(course => {
      val t = course(0)
      val d = course(1)
      // d - cur + 1 >= t => d + 1 - t >= cur
      if(cur + t <= d) {
        cur += t
        pq.enqueue(t)
      } else if(!pq.isEmpty && pq.head > t) {
        val h = pq.dequeue()
        cur += t - h
        pq.enqueue(t)
      }

      best = best max pq.size
    })

    best
  }
}
