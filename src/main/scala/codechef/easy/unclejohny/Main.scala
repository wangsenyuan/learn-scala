package codechef.easy.unclejohny

import scala.io.StdIn

/**
  * Created by wangsenyuan on 8/11/16.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val T = StdIn.readInt()

    var t = 0
    while (t < T) {
      val n = StdIn.readInt()
      val nums = StdIn.readLine().split("\\s+").map(_.toInt)
      val x = StdIn.readInt()
      val y = nums(x - 1)
      var less = 0

      for {
        num <- nums
        if num < y
      } {
        less += 1
      }

      println(less + 1)

      t += 1
    }
  }
}
