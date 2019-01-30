package set200.set290.p295

import scala.collection.mutable

class MedianFinder() {

  /** initialize your data structure here. */
  val lt = mutable.PriorityQueue.empty[Int]
  val gt = new mutable.PriorityQueue()(Ordering.ordered[Int].reverse)
  var median = 0.0d

  def addNum(num: Int) {
    val n = num.toDouble
    if (n <= median) {
      lt += num
    } else {
      gt += num
    }

    if (lt.size > gt.size) {
      gt += lt.dequeue()
    } else if (lt.size < gt.size) {
      lt += gt.dequeue()
    }

    median = if (lt.size == gt.size) {
      (lt.head + gt.head).toDouble / 2.0
    } else if (lt.size > gt.size) {
      lt.head.toDouble
    } else {
      gt.head.toDouble
    }
  }

  def findMedian(): Double = {
    median
  }

}
