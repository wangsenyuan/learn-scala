package codechef.ammeat

import scala.io.StdIn

/**
  * Created by wangsenyuan on 17/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt
    while (t > 0) {
      t -= 1

      val firstLine = StdIn.readLine().split("\\s+")
      val n = firstLine(0).toInt
      var m = firstLine(1).toLong

      val balls = StdIn.readLine().split("\\s+").map(_.toLong).sorted.reverse

      var i = 0
      while (m > 0 && i < balls.length) {
        m -= balls(i)
        i += 1
      }

      if (m > 0) {
        println(-1)
      } else {
        println(i)
      }
    }
  }
}
