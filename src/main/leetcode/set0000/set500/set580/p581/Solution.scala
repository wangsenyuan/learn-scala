package set0000.set500.set580.p581

import scala.collection.mutable

object Solution {

  def findUnsortedSubarray(nums: Array[Int]): Int = {
    val ii = nums.zipWithIndex
    val xs = ii.sortBy(_._1)
    var a = -1
    var end = -1
    for {
      x <- xs
      i = x._2
    } {
      if (a > i) {
        end = end max a
      }
      a = a max i
    }
    val n = ii.length
    var b = n
    var start = n
    val ys = ii.sortBy(_._1).reverse
    for {
      y <- ys
      i = y._2
    } {
      if (b < i) {
        start = start min b
      }
      b = b min i
    }
    0 max (end - start + 1)
  }

  def findUnsortedSubarray3(nums: Array[Int]): Int = {
    val n = nums.length
    var a = Int.MaxValue
    for {
      i <- 1 until n
      if (nums(i) < nums(i - 1))
    } {
      a = a min nums(i)
    }

    var b = Int.MinValue
    for {
      i <- n - 2 to 0 by -1
      if (nums(i) > nums(i + 1))
    } {
      b = b max nums(i)
    }

    val x = (0 until n).find(a < nums(_))
    val y = (n - 1 to 0 by -1).find(b > nums(_))
    if (x.isEmpty || y.isEmpty) {
      0
    } else {
      y.get - x.get + 1
    }
  }


  def findUnsortedSubarray2(nums: Array[Int]): Int = {
    val snums = nums.sorted
    var start = nums.length
    var end = 0
    for {
      i <- nums.indices
      if (snums(i) != nums(i))
    } {
      start = start min i
      end = end max i
    }
    (end - start + 1) max 0
  }

  def findUnsortedSubarray1(nums: Array[Int]): Int = {
    val n = nums.length

    val xs = nums.zipWithIndex
    val ps = xs.sortBy(_._1)

    var pq = new mutable.PriorityQueue[Int]()

    val right = Array.ofDim[Int](n)

    for {
      i <- 0 until n
      p = ps(i)
      k = p._2
    } {
      right(k) = -1
      if (!pq.isEmpty && pq.head > k) {
        right(k) = pq.head
      }
      pq.enqueue(k)
    }

    pq = new mutable.PriorityQueue[Int]()(Ordering.Int.reverse)

    val qs = xs.sortBy(_._1).reverse

    val left = Array.ofDim[Int](n)

    for {
      i <- 0 until n
      q = qs(i)
      k = q._2
    } {
      left(k) = n
      if (!pq.isEmpty && pq.head < k) {
        left(k) = pq.head
      }
      pq.enqueue(k)
    }

    var a = n
    var b = -1
    for {
      i <- 0 until n
    } {
      a = a min left(i)
      b = b max right(i)
    }

    0 max (b - a + 1)
  }

}
