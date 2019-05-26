package set600.set690.p699

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution {
  def fallingSquares(positions: Array[Array[Int]]): List[Int] = {
    val set = mutable.Set.empty[Int]

    positions.foreach(position => {
      set.add(position(0))
      set.add(position(0) + position(1) - 1)
    })

    val points = set.toArray.sorted

    val map = mutable.Map.empty[Int, Int]

    var i = 0
    while (i < points.size) {
      map += points(i) -> i
      i += 1
    }

    val size = points.size + 1

    val tree = new LazyTree(size)
    var ans = ListBuffer.empty[Int]

    positions.foreach(position => {
      val left = map(position(0))
      val side = position(1)
      val right = map(position(0) + position(1) - 1)
      val h = tree.query(left, right)
      tree.update(left, right, h + side)
      ans += tree.query(0, size - 1)
    })

    ans.toList
  }

  class LazyTree(size: Int) {
    val arr = Array.ofDim[Int](size * 2)
    val upt = Array.ofDim[Int](size)
    var h = 1
    while((1 << h) < size) {
      h += 1
    }

    private def apply(x: Int, v: Int) {
      arr(x) = arr(x) max v
      if(x < size) {
        upt(x) = upt(x) max v
      }
    }

    private def pull(x: Int): Unit = {
      var y = x
      while(y > 1) {
        y >>= 1
        arr(y) = arr(2 * y) max arr(2 * y + 1)
        arr(y) = arr(y) max upt(y)
      }
    }

    private def push(x: Int): Unit = {
      (h until 0 by -1) foreach {
        j =>
          val y = x >> j
          if(upt(y) > 0) {
            apply(2 * y, upt(y))
            apply(2 * y + 1, upt(y))
            upt(y) = 0
          }
      }
    }

    def update(left: Int, right: Int, v: Int): Unit ={
      var L = left + size
      var R = right + size
      while(L <= R) {
        if((L & 1) == 1) {
          // right child
          apply(L, v)
          L += 1
        }

        if((R & 1) == 0) {
          // left child
          apply(R, v)
          R -= 1
        }
        L >>= 1
        R >>= 1
      }
      pull(left + size)
      pull(right + size)
    }

    def query(left: Int, right: Int): Int = {
      var L = left + size
      var R = right + size
      push(L)
      push(R)
      var ans = 0
      while(L <= R) {
        if((L & 1) == 1) {
          ans = ans max arr(L)
          L += 1
        }
        if((R & 1) == 0) {
          ans = ans max arr(R)
          R -= 1
        }
        L >>= 1
        R >>= 1
      }
      ans
    }
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
