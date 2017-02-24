package codechef.easy.adigit

import scala.io.StdIn

/**
  * Created by wangsenyuan on 24/02/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    var m = firstLine(1)
    val nums = StdIn.readLine().map(_ - '0')

    val A = Array.fill(10, n)(0)

    (0 until 10) foreach {
      i =>
        (0 until n) foreach {
          j =>
            if (j > 0) {
              A(i)(j) = A(i)(j - 1)
            }

            if (nums(j) == i) {
              A(i)(j) += 1
            }

        }
    }

    while (m > 0) {
      val x = StdIn.readInt() - 1
      val y = nums(x)
      val b1 = (0 until y) map {
        i => A(i)(x) * (y - i) toLong
      } sum

      val b2 = (y + 1 until 10) map {
        i => A(i)(x) * (i - y) toLong
      } sum

      println(b1 + b2)

      m -= 1
    }

  }
}
