package codechef.rrcopy

import scala.io.StdIn

/**
  * Created by wangsenyuan on 09/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt
    while (t > 0) {
      t -= 1

      val n = StdIn.readInt()

      val nums = StdIn.readLine().split("\\s+").map(_.toInt)

      println(nums.distinct.size)
    }


  }
}
