package set300.set370.p373

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution {
  def kSmallestPairs(nums1: Array[Int], nums2: Array[Int], k: Int): List[Array[Int]] = {
    if (nums1.isEmpty || nums2.isEmpty) {
      Nil
    } else {
      val que = new mutable.PriorityQueue[Array[Int]]()(ord = new Ordering[Array[Int]]() {
        override def compare(x: Array[Int], y: Array[Int]): Int = {
          val a = nums1(x(0))
          val b = nums2(x(1))
          val c = nums1(y(0))
          val d = nums2(y(1))

          c - a + d - b
        }
      })

      for {
        i <- 0 until nums1.length
      } {
        que.enqueue(Array(i, 0))
      }


      val res = ListBuffer.empty[Array[Int]]
      var kk = k
      while (kk > 0 && que.size > 0) {
        val cur = que.dequeue()
        val x = cur(0)
        val y = cur(1)
        res += Array(nums1(x), nums2(y))
        if (y + 1 < nums2.length) {
          que.enqueue(Array(x, y + 1))
        }
        kk -= 1
      }

      res.toList
    }
  }
}
