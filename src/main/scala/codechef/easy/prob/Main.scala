package codechef.easy.prob

import scala.io.StdIn

/**
  * Created by wangsenyuan on 09/01/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {

      val line = StdIn.readLine().split("\\s+")

      val a = line(0).toInt
      val b = line(1).toInt

      val res = 1.0 * a / (a + b)

      println(res)

      t -= 1
    }
  }
}
