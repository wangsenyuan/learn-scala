package codechef.easy.permsuff

import java.util

import scala.io.StdIn

/**
  * Created by wangsenyuan on 27/02/2017.
  */
object Main {

  def sort(p: Array[Int], l: Int, r: Int): Unit = {
    util.Arrays.sort(p, l, r)
  }

  def shuffle(pairs: Array[(Int, Int)], p: Array[Int]): Boolean = {

    val sp = pairs.sortWith {
      (a, b) => a._1 < b._2 || (a._1 == b._1 && a._2 < b._2)
    }


    var l = sp(0)._1
    var r = sp(0)._2

    (1 until sp.length) foreach {
      i =>
        if (sp(i)._1 > r) {
          sort(p, l, r + 1)
          l = sp(i)._1
          r = sp(i)._2
        } else {
          r = r max sp(i)._2
        }
    }

    sort(p, l, r + 1)

    var i = 0
    var res = true
    while (res && i < p.length) {
      res = p(i) == i
      i += 1
    }
    res
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
        val n = firstLine(0)
        val m = firstLine(1)
        val p = StdIn.readLine().split("\\s+").map(_.toInt - 1)

        val pairs = Array.fill(m)((0, 0))
        (0 until m) foreach {
          i =>
            val line = StdIn.readLine().split("\\s+").map(_.toInt - 1)
            val l = line(0)
            val r = line(1)
            pairs(i) = (l, r)
        }
        val res = shuffle(pairs, p)
        if (res) {
          println("Possible")
        } else {
          println("Impossible")
        }
    }
  }
}
