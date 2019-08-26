package set0000.set700.set700.p703

import scala.collection.mutable

class KthLargest1(_k: Int, _nums: Array[Int]) {
  val heap = new mutable.PriorityQueue[Int]()(Ordering.Int.reverse)

  heap ++= _nums.sorted.reverse.take(_k)

  def add(`val`: Int): Int = {
    if (heap.size < _k) {
      heap += `val`
    } else {
      val min = heap.head
      if (min < `val`) {
        heap.dequeue()
        heap += `val`
      }
    }
    heap.head
  }
}
