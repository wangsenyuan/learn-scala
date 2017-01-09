package codechef.easy.prosum

import scala.io.StdIn

/**
  * Created by wangsenyuan on 27/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      val _ = StdIn.readLine()
      val nums = StdIn.readLine().trim.split("\\s+").map(_.toInt)
      val m = nums.filter(_ > 1).size.toLong
      val k = nums.filter(_ == 2).size.toLong
      val r = m * (m - 1) / 2 - k * (k - 1) / 2
      println(r)
    }
  }
}
