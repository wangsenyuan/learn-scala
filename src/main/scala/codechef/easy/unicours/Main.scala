package codechef.easy.unicours

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/6/15.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      val n = StdIn.readInt()
      val nums = StdIn.readLine().split("\\s+").map(_.toInt)
      val ans = n - nums.max

      println(ans)

      i += 1
    }
  }
}
