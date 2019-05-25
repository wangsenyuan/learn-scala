package set600.set690.p699

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution {
  def fallingSquares(positions: Array[Array[Int]]): List[Int] = {
    val set = mutable.Set.empty[Int]

    positions.foreach(position => {
      set.add(position(0))
      set.add(position(0) + position(1))
    })

    val points = set.toArray.sorted

    val map = mutable.Map.empty[Int, Int]

    var i = 0
    while (i < points.size) {
      map += points(i) -> i
      i += 1
    }

    val size = points.size + 1

    val tree = new Tree(size)
    var ans = ListBuffer.empty[Int]

    positions.foreach(position => {
      val left = map(position(0))
      val side = position(1)
      val right = map(position(0) + position(1))
      val h = tree.query(left, right - 1)
      tree.update(left, right - 1, h + side)
      ans += tree.query(0, size - 1)
    })

    ans.toList
  }

  class Tree(size: Int) {
    val arr = Array.ofDim[Int](size * 4)

    def query(left: Int, right: Int): Int = {

      def loop(i: Int, start: Int, end: Int): Int = {
        if (end < left || start > right) {
          0
        } else if (left <= start && end <= right) {
          arr(i)
        } else {
          val mid = (start + end) / 2
          loop(2 * i + 1, start, mid) max loop(2 * i + 2, mid + 1, end)
        }
      }

      loop(0, 0, size - 1)
    }

    def update(left: Int, right: Int, value: Int): Unit = {
      def loop(i: Int, start: Int, end: Int): Unit = {
        if (start == end) {
          arr(i) = value
        } else {
          val mid = (start + end) / 2
          if (left <= mid) {
            loop(2 * i + 1, start, mid)
          }
          if (right >= mid + 1) {
            loop(2 * i + 2, mid + 1, end)
          }
          arr(i) = arr(2 * i + 1) max arr(2 * i + 2)
        }
      }

      loop(0, 0, size - 1)
    }
  }

}
