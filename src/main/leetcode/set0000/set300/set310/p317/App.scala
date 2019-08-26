package set0000.set300.set310.p317

import scala.collection.mutable

/**
  * Created by wangsenyuan on 03/11/2016.
  */
object App {

  val dir = Array(-1, 0, 1, 0, -1)

  def shortestDistance(grid: Array[Array[Int]]): Int = {

    val m = grid.length
    val n = grid(0).length

    val marked = Array.fill(m, n)(0)
    val dist = Array.fill(m, n)(0)

    def bfs(r: Int, c: Int, cnt: Int): Unit = {
      var dist = 0
      val queue = new mutable.Queue[Int]()
      queue.enqueue(r * n + c)
      while (!queue.isEmpty) {
        val sz = queue.size
        dist += 1
        for {
          _ <- 0 until sz
          x = queue.dequeue()
          i = x / n
          j = x % n
          k <- 0 until 4
          ii = i + dir(k)
          jj = j + dir(k + 1)
          if (ii >= 0 && ii < m && jj >= 0 && jj < n && grid(ii)(jj) <= 0 && marked(ii)(jj) == cnt)
        } {
          marked(ii)(jj) += 1
          grid(ii)(jj) -= dist
          queue.enqueue(ii * n + jj)
        }
      }
    }
    var cnt = 0
    for {
      i <- 0 until m
      j <- 0 until n
      if (grid(i)(j) == 1)
    } {
      bfs(i, j, cnt)
      cnt += 1
    }

    var minDist = Int.MaxValue
    for {
      i <- 0 until m
      j <- 0 until n
      if marked(i)(j) == cnt
      if -grid(i)(j) < minDist
    } {
      minDist = -grid(i)(j)
    }

    return minDist
  }

  def main(args: Array[String]): Unit = {
    val grid = Array(Array(1, 1, 1, 1, 1, 0), Array(0, 0, 0, 0, 0, 1), Array(0, 1, 1, 0, 0, 1), Array(1, 0, 0, 1, 0, 1), Array(1, 0, 1, 0, 0, 1),
      Array(1, 0, 0, 0, 0, 1), Array(0, 1, 1, 1, 1, 0))

    println(shortestDistance(grid))
  }
}
