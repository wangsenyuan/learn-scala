package set800.set860.p862

import java.util

import scala.util.Sorting

object Solution {
  def shortestSubarray(A: Array[Int], K: Int): Int = {
    val n = A.length
    val sums = Array.ofDim[Long](n + 1)
    var i = 0
    while (i < n) {
      sums(i + 1) = A(i) + sums(i)
      i += 1
    }

    val que = Array.ofDim[Int](n + 1)
    var front = 0
    var end = 0

    var best = n + 1

    var y = 0
    while (y < sums.length) {
      while (end > front && sums(que(end - 1)) >= sums(y)) {
        end -= 1
      }

      while (front < end && sums(y) >= sums(que(front)) + K) {
        best = best min (y - que(front))
        front += 1
      }

      que(end) = y
      end += 1

      y += 1
    }

    if (best == n + 1) {
      -1
    } else {
      best
    }
  }

  def shortestSubarray1(A: Array[Int], K: Int): Int = {
    val n = A.length
    val items = Array.ofDim[Item](n)

    var sum = 0

    var i = 0
    while (i < n) {
      sum += A(i)
      items(i) = Item(sum, i)
      i += 1
    }

    Sorting.quickSort(items)(Ordering.by(_.num))

    val set = new util.TreeMap[Int, Boolean]()
    var best = -1

    var j = 0
    i = 0
    while (i < n) {
      val cur = items(i)

      while (j < i && items(j).num + K <= cur.num) {
        set.put(items(j).index, true)
        j += 1
      }

      if (cur.num >= K) {
        if (best < 0 || best > cur.index) {
          best = cur.index + 1
        }
      }

      val k = set.floorEntry(cur.index)
      if (k != null) {
        if (best < 0 || best > cur.index - k.getKey) {
          best = cur.index - k.getKey
        }
      }

      i += 1
    }

    best
  }

  case class Item(num: Int, index: Int)

}
