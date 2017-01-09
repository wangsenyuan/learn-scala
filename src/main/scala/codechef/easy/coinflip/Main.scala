package codechef.easy.coinflip

import scala.io.StdIn

/**
  * Created by wangsenyuan on 8/11/16.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val T = StdIn.readInt()
    var t = 0
    while (t < T) {
      val G = StdIn.readInt()
      var g = 0
      while (g < G) {
        val line = StdIn.readLine().split("\\s+").map(_.toInt)
        val i = line(0)
        val n = line(1)
        val q = line(2)

        if (n % 2 == 0) {
          println(n / 2)
        } else if (i == q) {
          println(n / 2)
        } else {
          println(n / 2 + 1)
        }

        g += 1
      }
      t += 1
    }
  }
}
