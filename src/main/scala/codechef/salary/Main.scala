package codechef.salary

import scala.io.StdIn

/**
  * Created by wangsenyuan on 12/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      t -= 1

      StdIn.readLine()

      val nums = StdIn.readLine().split("\\s+").map(_.toInt)

      val sum = nums.sum
      val min = nums.min

      val m = sum - min * nums.length

      println(m)
    }
  }
}
