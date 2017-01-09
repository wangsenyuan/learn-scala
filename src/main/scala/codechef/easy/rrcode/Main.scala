package codechef.easy.rrcode

import scala.io.StdIn

/**
  * Created by wangsenyuan on 27/12/2016.
  */
object Main {


  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      val firstLine = StdIn.readLine().split("\\s+")
      val k = firstLine(1).toLong
      val answer = firstLine(2).toLong
      val nums = StdIn.readLine().split("\\s+").map(_.toLong)
      val operator = StdIn.readLine()
      if (k > 0) {
        val res = operator match {
          case "XOR" =>
            xor(k, answer, nums)
          case "OR" =>
            or(answer, nums)
          case "AND" =>
            and(answer, nums)
        }

        println(res)
      } else {
        println(answer)
      }
    }
  }

  def xor(k: Long, answer: Long, nums: Array[Long]): Long = {
    if (k % 2 == 0) {
      answer
    } else {
      nums.foldLeft(answer)(_ ^ _)
    }
  }

  def or(answer: Long, nums: Array[Long]) = nums.foldLeft(answer)(_ | _)

  def and(answer: Long, nums: Array[Long]) = nums.foldLeft(answer)(_ & _)

}
