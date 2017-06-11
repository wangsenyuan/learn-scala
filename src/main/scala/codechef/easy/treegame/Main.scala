package codechef.easy.treegame

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/6/11.
  */
object Main {

  def fillLevels(children: Array[ListBuffer[Int]], n: Int) = {
    val levels = Array.fill(n + 1)(0)

    val tmp = Array.fill[ListBuffer[Int]](2)(null)
    tmp(0) = ListBuffer.empty[Int]
    tmp(1) = ListBuffer.empty[Int]

    var a = 0
    tmp(a) += 1

    var level = 0
    while (!tmp(a).isEmpty) {
      val b = 1 - a
      tmp(b).clear()

      var i = 0
      while (i < tmp(a).length) {
        val x = tmp(a)(i)
        levels(x) = level
        if (children(x) != null) {
          tmp(b) ++= children(x)
        }
        i += 1
      }
      a = b
      level += 1
    }

    levels
  }

  def solve() = {
    val n = StdIn.readInt()
    val children = Array.fill[ListBuffer[Int]](n + 1)(null)

    var i = 0
    while (i < n - 1) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val a = line(0)
      val b = line(1)
      if (children(a) == null) {
        children(a) = ListBuffer.empty[Int]
      }
      children(a) += b

      i += 1
    }
    val levels = fillLevels(children, n)

    val nodes = (1 to n).toArray.sortBy(levels(_))

    var l = -1
    var r = n
    var res = 0
    var turn = 0
    while (l < r - 1) {
      if (turn == 0) {
        l += 1
        var k = l
        while (k < r && levels(nodes(k)) == levels(nodes(l))) {
          k += 1
        }
        l = k - 1
      } else {
        r -= 1
      }
      res += 1
      turn = 1 - turn
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
