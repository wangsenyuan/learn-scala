package codechef.amsgame1

import scala.io.StdIn

/**
  * Created by wangsenyuan on 8/20/16.
  */
object Main {

  def gcd(a: Int, b: Int): Int = {
    if (a < b) {
      gcd(b, a)
    } else if (b == 0) {
      a
    } else {
      gcd(b, a % b)
    }
  }

  def play(nums: Array[Int]) = {
    if (nums.length == 1) {
      nums(0)
    } else {
      nums.reduceLeft(gcd)
    }
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val n = StdIn.readInt()
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val r = play(line)
      println(r)
      t -= 1
    }
  }
}
