package set600.set670.p675

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution1 {

  def main(args: Array[String]): Unit = {
    val forest = List(
      List(1, 2, 3),
      List(0, 0, 4),
      List(7, 6, 5)
    )

    println(cutOffTree(forest))
  }

  def findTrees(forest: Array[Array[Int]]) = {

    val trees = ListBuffer.empty[(Int, Int)]

    var i = 0
    while (i < forest.length) {
      var j = 0
      while (j < forest(i).length) {
        if (forest(i)(j) > 1) {
          trees += (i -> j)
        }
        j += 1
      }

      i += 1
    }

    trees.toArray
  }

  val dd = Array(-1, 0, 1, 0, -1)

  def bfs(forest: Array[Array[Int]], x: Int, y: Int, a: Int, b: Int): Int = {
    val n = forest.length
    val m = forest(0).length
    val dist = Array.fill(n, m)(Int.MaxValue)

    val pq = new mutable.PriorityQueue[(Int, Int)]()(
      (x: (Int, Int), y: (Int, Int)) => {
        val (a, b) = x
        val (c, d) = y
        if (dist(a)(b) < dist(c)(d)) {
          1
        } else if (dist(a)(b) > dist(c)(d)) {
          -1
        } else {
          0
        }
      }
    )

    pq.enqueue(x -> y)
    dist(x)(y) = 0

    while (!pq.isEmpty) {
      val (c, d) = pq.dequeue()
      if (c == a && d == b) {
        return dist(c)(d)
      }

      var i = 0
      while (i < 4) {
        val nc = c + dd(i)
        val nd = d + dd(i + 1)
        if (nc >= 0 && nc < n && nd >= 0 && nd < m && forest(nc)(nd) > 0 && dist(nc)(nd) > dist(c)(d) + 1) {
          dist(nc)(nd) = dist(c)(d) + 1
          pq.enqueue(nc -> nd)
        }
        i += 1
      }

    }

    -1
  }

  def cutOffTree(ff: List[List[Int]]): Int = {
    val n = ff.length
    val m = ff.head.length

    val forest = ff.map(_.toArray).toArray

    val trees = findTrees(forest).sortBy(x => forest(x._1)(x._2))

    var x = 0
    var y = 0

    var ans = 0
    var i = 0
    while (i < trees.length) {
      val (a, b) = trees(i)

      if (x != a || y != b) {
        val tmp = bfs(forest, x, y, a, b)
        if (tmp < 0) {
          return -1
        }
        ans += tmp
      }

      x = a
      y = b
      i += 1
    }

    ans
  }
}

