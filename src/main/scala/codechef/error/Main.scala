package codechef.error

import scala.io.StdIn

/**
  * Created by wangsenyuan on 8/17/16.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt
    while (t > 0) {
      val line = StdIn.readLine()
      if (isGood(line)) {
        println("Good")
      } else {
        println("Bad")
      }
      t -= 1
    }
  }

  def isGood(line: String): Boolean = {
    var i = 0
    var good = false
    while (i < line.length() - 2 && !good) {
      val x = line(i)
      good = line(i + 1) != x && line(i + 2) == x
      i += 1
    }

    good
  }
}
