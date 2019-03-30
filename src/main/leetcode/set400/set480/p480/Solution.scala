package set400.set480.p480

import scala.collection.mutable

object Solution {
  def medianSlidingWindow(nums: Array[Int], k: Int): Array[Double] = {
    // 3, 2, 1
    val first = new mutable.PriorityQueue[Int]()
    //4, 5, 6
    val second = new mutable.PriorityQueue[Int]()(Ordering.Int.reverse)

    val back = new mutable.PriorityQueue[Int]()

    def add(num: Int): Double = {
      // suppose first if 3, 2, 1, and second is 5, 6, now need to insert 4
      if (!second.isEmpty && num >= second.head) {
        second.enqueue(num)
      } else {
        first.enqueue(num)
      }

      while (second.size > first.size + 1) {
        first.enqueue(second.dequeue())
      }
      // first.size + 1 >= second.size

      while (first.size > second.size) {
        second.enqueue(first.dequeue())
      }

      //first.size <= second.size
      if (first.size < second.size) {
        second.head.toDouble
      } else {
        (first.head.toDouble + second.head.toDouble) * 0.5
      }
    }

    def remove(num: Int): Unit = {
      if (!first.isEmpty && num <= first.head) {
        //in the first half
        while (first.head != num) {
          back.enqueue(first.dequeue())
        }
        first.dequeue()
        while (!back.isEmpty) {
          first.enqueue(back.dequeue())
        }
      } else if (!second.isEmpty && num >= second.head) {
        while (second.head != num) {
          back.enqueue(second.dequeue())
        }
        second.dequeue()
        while (!back.isEmpty) {
          second.enqueue(back.dequeue())
        }
      }
    }

    val n = nums.length
    val res = Array.fill(n - k + 1)(0.0d)
    var i = 0
    while (i < k) {
      res(0) = add(nums(i))
      i += 1
    }
    while (i < n) {
      remove(nums(i - k))
      res(i - k + 1) = add(nums(i))
      i += 1
    }

    res
  }
}
