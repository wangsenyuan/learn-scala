package codechef.easy.d6

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by wangsenyuan on 03/06/2017.
  */
object Main {

  def find(a: (Int, Int), b: (Int, Int), coords: mutable.Set[(Int, Int)]): Int = {
    val (x1, y1) = a
    val (x2, y2) = b

    val d = (x1 + y1 - y2) -> (y1 + x2 - x1)
    val c = (x2 + y1 - y2) -> (y2 + x2 - x1)

    if (!coords.contains(c) || !coords.contains(d)) {
      0
    } else {
      1
    }
  }

  def solve() = {
    val n = StdIn.readInt()
    val coords = mutable.Set.empty[(Int, Int)]
    val array = Array.fill[(Int, Int)](n)(null)
    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val x = line(0) -> line(1)
      array(i) = x
      coords += x
      i += 1
    }

    val sa = array.sortWith((a, b) => a._1 < b._1 || (a._1 == b._1 && a._2 < b._2))

    var res = 0
    i = 0
    while (i < n) {
      val a = sa(i)
      var j = i + 1
      while (j < n) {
        val b = sa(j)
        if (b._2 > a._2) {
          res += find(a, b, coords)
        }

        j += 1
      }

      i += 1
    }

    println(res)
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
