package codechef.tavisual

import scala.io.StdIn

/**
  * Created by wangsenyuan on 10/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt

    while (t > 0) {
      t -= 1

      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = line(0)
      val c = line(1)
      var q = line(2)
      var swaps = Vector.empty[(Int, Int)]
      while (q > 0) {
        q -= 1
        val lr = StdIn.readLine().split("\\s+").map(_.toInt)
        swaps :+= (lr(0), lr(1))
      }

      val x = swaps.foldLeft(c) {
        case (x, (l, r)) =>
          if (x < l || x > r) {
            x
          } else {
            l + r - x
          }
      }

      println(x)
    }
  }
}
