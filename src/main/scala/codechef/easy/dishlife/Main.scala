package codechef.easy.dishlife

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
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val k = firstLine(1)
    val islands = Array.fill[Array[Int]](n)(null)
    val cnts = Array.fill(k)(0)
    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      islands(i) = line.tail

      islands(i) foreach {
        x => cnts(x - 1) += 1
      }

      i += 1
    }

    val sad = cnts.exists(_ == 0)

    if (sad) {
      println("sad")
    } else {
      val mustGo = islands.count(island => {
        island.exists(x => cnts(x - 1) == 1)
      })

      if (mustGo == n) {
        println("all")
      } else {
        println("some")
      }
    }
  }
}
