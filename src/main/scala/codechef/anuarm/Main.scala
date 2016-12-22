package codechef.anuarm

import scala.io.StdIn

/**
  * Created by wangsenyuan on 22/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1

      val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = firstLine(0)
      val m = firstLine(1)

      val nums = StdIn.readLine().split("\\s+").map(_.toInt)

      val min = nums.min
      val max = nums.max

      val res =
        for {
          i <- 0 until n
        } yield {
          val a = (i - max).abs
          val b = (i - min).abs
          a max b
        }

      println(res mkString " ")
    }
  }
}
