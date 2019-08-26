package set0000.set400.set480.p480

import scala.collection.mutable

object Solution {

  // when it is a max heap, if fn(a, b), then a leading b
  class PQ(n: Int, fn: (Int, Int) => Boolean) {
    val arr = Array.fill(n + 1)(Int.MinValue)
    var cur = 0
    val ii = mutable.Map.empty[Int, Int]

    def empty = cur == 0

    def size() = cur

    def head = arr(1)

    def enqueue(num: Int): Unit = {
      cur += 1
      swimUp(cur, num)
    }

    private def swimUp(pos: Int, num: Int): Unit = {
      var p = pos
      while (p > 1 && fn(num, arr(p >> 1))) {
        arr(p) = arr(p >> 1)
        ii(arr(p)) = p
        p >>= 1
      }
      arr(p) = num
      ii(num) = p
    }

    def dequeue(): Int = {
      val num = arr(1)
      removeAt(1)
      num
    }

    def remove(num: Int): Unit = {
      removeAt(ii(num))
    }

    /**
      * remove element at pos, not the number itself
      *
      * @param pos
      */
    def removeAt(pos: Int): Unit = {
      if (pos == cur) {
        arr(cur) = Int.MinValue
        cur -= 1
      } else {
        val num = arr(cur)
        arr(cur) = Int.MinValue
        cur -= 1
        if (pos > 1 && fn(num, arr(pos >> 1))) {
          swimUp(pos, num)
        } else {
          sinkDown(pos, num)
        }
      }
    }

    private def sinkDown(pos: Int, num: Int): Unit = {
      val left = pos << 1
      if (left < cur) {
        // have left & right children
        val right = left + 1
        if (fn(arr(left), num)) {
          if (fn(arr(right), arr(left))) {
            arr(pos) = arr(right)
            sinkDown(right, num)
          } else {
            arr(pos) = arr(left)
            sinkDown(left, num)
          }
        } else if (fn(arr(right), num)) {
          arr(pos) = arr(right)
          sinkDown(right, num)
        } else {
          arr(pos) = num
        }
      } else if (left == cur) {
        if (fn(arr(left), num)) {
          arr(pos) = arr(left)
          sinkDown(left, num)
        } else {
          arr(pos) = num
        }
      } else {
        arr(pos) = num
      }

      ii(arr(pos)) = pos
    }
  }


  def medianSlidingWindow(nums: Array[Int], k: Int): Array[Double] = {
    val first = new PQ(k, _ > _)
    val second = new PQ(k, _ < _)

    def add(num: Int): Double = {
      if (!second.empty && num >= second.head) {
        second.enqueue(num)
      } else {
        first.enqueue(num)
      }

      while (second.size() > first.size() + 1) {
        first.enqueue(second.dequeue())
      }
      while (first.size() > second.size()) {
        second.enqueue(first.dequeue())
      }

      if (first.size < second.size) {
        second.head.toDouble
      } else {
        (first.head.toDouble + second.head.toDouble) * 0.5
      }
    }

    def remove(num: Int) = {
      if (!first.empty && num <= first.head) {
        first.remove(num)
      } else if (!second.empty && num >= second.head) {
        second.remove(num)
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

  def medianSlidingWindow1(nums: Array[Int], k: Int): Array[Double] = {
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
