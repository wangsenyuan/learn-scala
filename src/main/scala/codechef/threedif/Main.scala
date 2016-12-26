package codechef.threedif

import scala.io.StdIn

/**
  * Created by wangsenyuan on 26/12/2016.
  */
object Main {

  val M = 1000000007

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      t -= 1
      val line = StdIn.readLine().split("\\s+").map(_.toLong)
      val nums = line.sorted

      val a = nums(0) % M
      val b = (nums(1) - 1) % M
      val c = (nums(2) - 2) % M

      val r = a * b % M * c % M

      println(r)
    }

  }
}
