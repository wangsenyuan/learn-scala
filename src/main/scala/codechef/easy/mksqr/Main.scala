package codechef.easy.mksqr

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/4/29.
  */
object Main {


  def solve() = {
    var line = StdIn.readLine()
    while (line.isEmpty) {
      line = StdIn.readLine()
    }
    val n = line.toInt
    var a = false
    var b = false
    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val x = line(0)
      val y = line(1)
      if (x > y) {
        a = true
      } else if (x < y) {
        b = true
      } else {
        a = true
        b = true
      }
      i += 1
    }
    if (a && b) {
      println("Yes")
    } else {
      println("No")
    }
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
