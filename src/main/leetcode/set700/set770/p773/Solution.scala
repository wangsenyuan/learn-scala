package set700.set770.p773

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution {
  def slidingPuzzle(board: Array[Array[Int]]): Int = {
    //543210
    // 6 * 6 * 6 * 6 * 6 * 6 = 46656
    val bs = Array(7776, 1296, 216, 36, 6, 1)

    val arr = Array.ofDim[Int](6)
    val res = ArrayBuffer.empty[Int]

    def swapAndGetNum(j: Int, k: Int) = {
      swap(arr, j, k)
      res += toNum(arr)
      swap(arr, j, k)
    }

    def slide(num: Int): Array[Int] = {
      var x = num
      var i = 0
      var j = 0
      while (i < 6) {
        arr(i) = x / bs(i)
        x %= bs(i)
        if (arr(i) == 0) {
          j = i
        }
        i += 1
      }

      res.clear()

      var k = (j + 3) % 6

      swapAndGetNum(j, k)

      if (j != 0 && j != 3) {
        k = j - 1
        swapAndGetNum(j, k)
      }

      if (j != 2 && j != 5) {
        k = j + 1
        swapAndGetNum(j, k)
      }

      res.toArray
    }

    def toNum(arr: Array[Int]): Int = {
      arr.zip(bs).map(x => x._1 * x._2).sum
    }

    val target = toNum(board.flatten)

    val src = toNum(Array(1, 2, 3, 4, 5, 0))

    val que = Array.ofDim[Int](720)
    var front = 0
    var end = 0
    val dist = mutable.Map.empty[Int, Int].withDefaultValue(-1)
    dist(src) = 0
    que(end) = src
    end += 1
    while (front < end) {
      val cur = que(front)
      front += 1

      val nexts = slide(cur)

      nexts.foreach(num => {
        if (dist(num) < 0) {
          que(end) = num
          end += 1
          dist(num) = dist(cur) + 1
        }
      })
    }

    dist(target)
  }

  private def swap(arr: Array[Int], i: Int, j: Int) = {
    arr(i) ^= arr(j)
    arr(j) ^= arr(i)
    arr(i) ^= arr(j)
  }
}
