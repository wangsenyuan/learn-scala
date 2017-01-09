package codechef.easy.tachstck

import scala.io.StdIn

/**
  * Created by wangsenyuan on 13/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+")

    val n = firstLine(0).toInt
    val d = firstLine(1).toLong

    val sticks = Array.fill(n)(0L)

    var i = 0
    while (i < n) {
      sticks(i) = StdIn.readLong()
      i += 1
    }

    val paired = pair(sticks, d)

    println(paired)
  }

  def pair(sticks: Array[Long], d: Long): Int = {
    val sorted = sticks.sorted

    def go(i: Int, res: Int): Int = {
      if (i >= sticks.length - 1) {
        res
      } else {
        val x = sorted(i + 1) - sorted(i)
        if (x <= d) {
          go(i + 2, res + 1)
        } else {
          go(i + 1, res)
        }
      }
    }

    go(0, 0)
  }
}
