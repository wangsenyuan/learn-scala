package codechef.easy.rrstone

import scala.io.StdIn

/**
  * Created by wangsenyuan on 19/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+")
    val n = firstLine(0).toInt
    val k = firstLine(1).toLong

    val nums = StdIn.readLine().split("\\s+").map(_.toLong)
    if (k == 0) {
      println(nums.mkString(" "))
    } else {
      val i = k % 2

      if (i == 1) {
        val max = nums.max
        val res = nums.map(max - _)
        println(res.mkString(" "))
      } else {
        val min = nums.min
        val res = nums.map(_ - min)
        println(res.mkString(" "))
      }
    }
  }
}
