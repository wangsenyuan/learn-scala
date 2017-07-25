package codechef.easy.timeasr

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val timesDiff = Array.fill[ListBuffer[String]](365)(null)

    var h = 0
    while (h < 12) {
      var m = 0
      while (m < 60) {
        val ah = 60 * h + m
        val am = 12 * m

        var diff = (ah - am).abs
        if (diff > 360) {
          diff = 720 - diff
        }

        if (timesDiff(diff) == null) {
          timesDiff(diff) = ListBuffer.empty[String]
        }

        timesDiff(diff) += f"$h%02d:$m%02d"

        m += 1
      }

      h += 1
    }


    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve(timesDiff)
      i += 1
    }
  }

  def solve(timesDiff: Array[ListBuffer[String]]): Unit = {
    val a = StdIn.readDouble()

    val error = 1.0 / 120

    var x = (a + 2 * error).toInt

    if ((a - x).abs < error) {
      x = 2 * x
    } else if ((a - x - 0.5).abs < error) {
      x = 2 * x + 1
    } else {
      x = -1
    }

    if (x != -1) {
      println(timesDiff(x).mkString("\n"))
    }

  }
}
