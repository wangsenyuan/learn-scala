package codechef.easy.rnum

import scala.io.StdIn

/**
  * Created by wangsenyuan on 09/03/2017.
  */
object Main {

  def maxShoot(cnt: Int): Int = {
    (cnt + 1) / 2
  }

  def minShoot(cnt: Int) = (cnt + 2) / 3

  def shootEnemy(nums: Array[Int], n: Int): (Int, Int) = {
    val sorted = nums.sorted
    var a = 0
    var b = 0
    var prev = 0
    var i = 1
    while (i <= n) {
      if (i == n || sorted(i) > sorted(i - 1) + 1) {
        val cnt = i - prev
        a += minShoot(cnt)
        b += maxShoot(cnt)
        prev = i
      }

      i += 1
    }

    (a, b)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val n = StdIn.readInt()
        val nums = StdIn.readLine().split("\\s+").map(_.toInt)
        val (a, b) = shootEnemy(nums, n)
        println(s"$a $b")
    }
  }
}
