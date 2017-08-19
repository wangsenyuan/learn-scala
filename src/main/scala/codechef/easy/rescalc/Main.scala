package codechef.easy.rescalc

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

  def solve(): Unit = {
    val n = StdIn.readInt()
    var best = 0
    var bestPlayer = 0
    var bestCnt = 0
    var i = 1
    while (i <= n) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val m = line.head

      val cnts = Array.fill(6)(0)

      line.tail.foreach {
        x => cnts(x - 1) += 1
      }

      val types = cnts.sorted.reverse

      val tmp = m + (types(3) - types(4)) + (types(4) - types(5)) * 2 + types(5) * 4

      if (tmp > best) {
        best = tmp
        bestPlayer = i
        bestCnt = 1
      } else if (tmp == best) {
        bestCnt += 1
      }

      i += 1
    }

    if (bestCnt > 1) {
      println("tie")
    } else if (bestPlayer == 1) {
      println("chef")
    } else {
      println(bestPlayer)
    }
  }
}
