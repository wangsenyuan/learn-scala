package facebook.question1.missingterm

import scala.io.StdIn

object Solution {

  def main(args: Array[String]) {
    val n = StdIn.readInt()
    val xs = StdIn.readLine().split("\\s+").map(_.toInt)

    val a = xs(0)
    val b = xs(1)
    val c = xs(2)
    val d = xs(3)
    val ba = b - a
    val cb = c - b
    val dc = d - c
    val diff = if (ba == cb) ba else if (cb == dc) cb else dc

    var found = false
    var x = a
    for {
      i <- 1 until xs.length
      if (x + diff == xs(i))
    } {
      x += diff
    }
    println(x + diff)
  }

}
