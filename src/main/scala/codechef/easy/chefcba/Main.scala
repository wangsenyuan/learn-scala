package codechef.easy.chefcba

import scala.io.StdIn

/**
  * Created by wangsenyuan on 09/02/2017.
  */
object Main {

  def isProportion(nums: Array[Int]) = {

    def possible(a: Int, b: Int, c: Int, d: Int): Boolean = {
      a * d == b * c
    }

    possible(nums(1), nums(0), nums(3), nums(2)) || possible(nums(2), nums(0), nums(3), nums(1))
  }

  def main(args: Array[String]): Unit = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)

    val nums = line.sorted

    if (isProportion(nums)) {
      println("Possible")
    } else {
      println("Impossible")
    }

  }
}
