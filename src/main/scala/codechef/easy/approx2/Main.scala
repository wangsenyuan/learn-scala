package codechef.easy.approx2

import scala.io.StdIn

/**
  * Created by wangsenyuan on 11/01/2017.
  */
object Main {


  def main(args: Array[String]): Unit = {
    var t = StdIn.readLine().trim.toInt
    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)

      val n = line(0)
      val k = line(1)

      val nums = StdIn.readLine().split("\\s+").map(_.toInt)

      var m = Int.MaxValue

      for {
        i <- 0 until n
        j <- (i + 1) until n
      } {
        m = (nums(i) + nums(j) - k).abs min m
      }

      val res =
        (for {
          i <- 0 until n
          j <- (i + 1) until n
        } yield (nums(i) + nums(j))).count(x => (x - k).abs == m)

      println(m + " " + res)

      /*val a = binarySearch(sums.length, sums(_) > k)

      if (a == sums.length) {
        //all less than k
        println(count(sums, sums(a - 1)))
      } else if (a == 0) {
        //all bigger than k
        println(count(sums, sums(a)))
      } else if (sums(a - 1) == k) {
        println(count(sums, k))
      } else if (sums(a) - k < k - sums(a - 1)) {
        println(count(sums, sums(a)))
      } else if (sums(a) - k > k - sums(a - 1)) {
        println(count(sums, sums(a - 1)))
      } else {
        println(count(sums, sums(a)) + count(sums, sums(a - 1)))
      }*/

      t -= 1
    }
  }

  def count(nums: Array[Int], x: Int): Int = {
    val a = binarySearch(nums.length, nums(_) > x)
    val b = binarySearch(nums.length, nums(_) >= x)
    a - b
  }

  def binarySearch(len: Int, gt: Int => Boolean): Int = {
    //gt(-1) = false & gt(n) = true
    var i = 0
    var j = len
    while (j > i) {
      val k = i + (j - i) / 2
      if (!gt(k)) {
        i = k + 1
      } else {
        j = k
      }
    }
    i
  }

}
