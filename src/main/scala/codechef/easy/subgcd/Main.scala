package codechef.easy.subgcd

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 14/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1

      val n = StdIn.readInt()
      val nums = StdIn.readLine().split("\\s+").map(_.toInt)

      val res = gcd(nums)

      if (nums.length > 1 && res == 1) {
        println(n)
      } else {
        println(-1)
      }
    }
  }

  def gcd(nums: Array[Int]): Int = {

    @tailrec
    def gcd(a: Int, b: Int): Int =
      if (b == 0) {
        a
      } else {
        gcd(b, a % b)
      }

    @tailrec
    def go(i: Int, rem: Int): Int = {
      if (i == nums.length) {
        rem
      } else if (rem == 1) {
        1
      } else {
        go(i + 1, gcd(rem, nums(i)))
      }
    }

    go(1, nums(0))
  }


}
