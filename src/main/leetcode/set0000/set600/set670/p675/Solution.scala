package set0000.set600.set670.p675

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

object Solution {

  val dd = Array(-1, 0, 1, 0, -1)

  def process(grid: Array[Array[Int]], m: Int, n: Int, trees: Array[(Int, Int)]): Int = {
    Sorting.quickSort(trees)(new Ordering[(Int, Int)]() {
      override def compare(x: (Int, Int), y: (Int, Int)): Int = Ordering.Int.compare(x._2, y._2)
    })

    val que = Array.ofDim[Int](m * n)
    val dist = Array.ofDim[Int](m * n)

    def distance(src: Int, dst: Int): Int = {

      (0 until m).foreach(r => (0 until n).foreach(c => dist(r * n + c) = -1))

      var front = 0
      var tail = 0
      que(tail) = src
      tail += 1
      dist(src) = 0

      while (front < tail && que(front) != dst) {
        val cur = que(front)
        front += 1
        val x = cur / n
        val y = cur % n

        (0 until 4) foreach (k => {
          val u = x + dd(k)
          val v = y + dd(k + 1)
          if (u >= 0 && u < m && v >= 0 && v < n && grid(u)(v) != 0 && dist(u * n + v) == -1) {
            dist(u * n + v) = dist(cur) + 1
            que(tail) = u * n + v
            tail += 1
          }
        })

      }

      dist(dst)
    }


    var ans = 0
    var prev =0
    var i = 0
    while (i < trees.length) {
      val d = distance(prev, trees(i)._1)
      if (d < 0) {
        return -1
      }
      prev = trees(i)._1
      ans += d
      i += 1
    }
    ans
  }

  def cutOffTree(forest: List[List[Int]]): Int = {
    if (forest.isEmpty) {
      0
    } else {
      val treeBuf = ArrayBuffer.empty[(Int, Int)]
      val grid = forest.map(_.toArray).toArray
      val n = grid(0).length
      (0 until grid.length).foreach(r => {
        (0 until n).foreach(c => {
          if (grid(r)(c) > 1) {
            treeBuf += (r * n + c -> grid(r)(c))
          }
        })
      })

      if (treeBuf.isEmpty) {
        0
      } else {
        process(grid, grid.length, n, treeBuf.toArray)
      }
    }
  }
}
