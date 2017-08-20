package codechef.easy.snsocial

import scala.collection.mutable
import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }

  val dx = Array(-1, -1, -1, 0, 0, 1, 1, 1)
  val dy = Array(-1, 0, 1, -1, 1, -1, 0, 1)

  def solve(): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)

    val houses = Array.fill[Array[Int]](n)(null)
    var maxWealth = 0
    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      houses(i) = line
      maxWealth = maxWealth max line.max
      i += 1
    }

    var queue = mutable.Queue.empty[(Int, Int)]

    i = 0
    while (i < n) {
      var j = 0
      while (j < m) {
        if (houses(i)(j) == maxWealth) {
          queue.enqueue(i -> j)
        }
        j += 1
      }
      i += 1
    }

    var ans = -1
    while (!queue.isEmpty) {
      ans += 1
      val k = queue.size
      var a = 0
      while (a < k) {
        val (x, y) = queue.dequeue()
        var b = 0
        while (b < dx.size) {
          val nx = x + dx(b)
          val ny = y + dy(b)
          if (nx >= 0 && nx < n && ny >= 0 && ny < m && houses(nx)(ny) < houses(x)(y)) {
            houses(nx)(ny) = houses(x)(y)
            queue.enqueue(nx -> ny)
          }

          b += 1
        }

        a += 1
      }
    }

    println(ans)
  }
}
