package set0000.set600.set630.p632

import scala.collection.mutable

object Solution {
  def smallestRange(nums: List[List[Int]]): Array[Int] = {
    val set = mutable.TreeSet.empty[(Int, Int)](new Ordering[(Int, Int)] {
      override def compare(x: (Int, Int), y: (Int, Int)): Int = {
        if (x._1 < y._1) {
          -1
        } else if (x._1 > y._1) {
          1
        } else if (x._2 < y._2) {
          -1
        } else if (x._2 > y._2) {
          1
        } else {
          0
        }
      }
    })

    val arr = nums.toArray

    val n = arr.length

    var i = 0
    while (i < n) {
      val h = arr(i).head
      arr(i) = arr(i).tail
      set += h -> i
      i += 1
    }

    var a = set.firstKey._1
    var b = set.lastKey._1

    while (set.size == n) {
      val x = set.firstKey
      set -= x
      val j = x._2
      if (!arr(j).isEmpty) {
        set += arr(j).head -> j
        arr(j) = arr(j).tail
        val c = set.firstKey._1
        val d = set.lastKey._1
        if (d - c < b - a) {
          a = c
          b = d
        }
      }
    }

    Array(a, b)
  }

}
