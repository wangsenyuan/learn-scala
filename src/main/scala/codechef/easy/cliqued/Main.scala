package codechef.easy.cliqued

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/6/11.
  */
object Main {

  case class Road(dest: Int, dist: Double)

  implicit val ordRoad = new Ordering[Road] {
    override def compare(x: Road, y: Road): Int = {
      if (x.dist < y.dist) {
        1
      } else if (x.dist > y.dist) {
        -1
      } else {
        0
      }
    }
  }

  def solve() = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val k = firstLine(1)
    val x = firstLine(2)
    val m = firstLine(3)
    val s = firstLine(4) - 1

    val cities = Array.fill[ListBuffer[Road]](n + 1)(null)
    cities(n) = ListBuffer.empty[Road]
    var i = 0
    while (i < k) {
      //first k
      cities(i) = ListBuffer.empty[Road]
      cities(i) += Road(n, x.toDouble / 2)
      cities(n) += Road(i, x.toDouble / 2)
      i += 1
    }

    i = 0
    while (i < m) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val ai = line(0) - 1
      val bi = line(1) - 1
      val ci = line(2)

      if (cities(ai) == null) {
        cities(ai) = ListBuffer.empty[Road]
      }

      cities(ai) += Road(bi, ci)

      if (cities(bi) == null) {
        cities(bi) = ListBuffer.empty[Road]
      }

      cities(bi) += Road(ai, ci)

      i += 1
    }


    val cs = cities.map(_.toArray)

    val pq = mutable.PriorityQueue.empty[Road]

    val ds = Array.fill(n + 1)(Double.MaxValue)
    val visited = Array.fill(n + 1)(false)
    pq.enqueue(Road(s, 0))
    ds(s) = 0D
    //visited(s) = true

    while (!pq.isEmpty) {
      val Road(vx, dx) = pq.dequeue()

      if (!visited(vx)) {
        visited(vx) = true
        var j = 0
        while (j < cs(vx).length) {
          val Road(wx, wd) = cs(vx)(j)
          if (!visited(wx) && ds(wx) > dx + wd) {
            ds(wx) = dx + wd
            pq.enqueue(Road(wx, dx + wd))
          }
          j += 1
        }
      }
    }

    println(ds.init.map(_.toLong).mkString(" "))
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }
}
