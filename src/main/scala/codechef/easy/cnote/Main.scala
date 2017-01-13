package codechef.easy.cnote

import scala.io.StdIn

/**
  * Created by wangsenyuan on 13/01/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val x = line(0)
      val y = line(1)
      val k = line(2)
      val n = line(3)

      var i = 0
      var lucky = false

      while (i < n) {

        val pc = StdIn.readLine().split("\\s+").map(_.toInt)
        val p = pc(0)
        val c = pc(1)

        lucky = lucky || (p >= x - y && c <= k)

        i += 1
      }

      if (lucky) {
        println("LuckyChef")
      } else {
        println("UnluckyChef")
      }

      t -= 1
    }
  }
}
