package codechef.easy.nuclearreactors

import scala.io.StdIn

/**
  * Created by wangsenyuan on 8/11/16.
  */
object Main {
  def main(args: Array[String]): Unit = {
    val line = StdIn.readLine().split("\\s+").map(_.toLong)
    val a = line(0)
    val n = line(1)
    val k = line(2)

    println(play(a, n + 1, k))
  }

  def play(a: Long, n: Long, k: Long): String = {
    def go(a: Long, i: Long, nums: List[Long]): List[Long] = {
      if (i == k) {
        nums.reverse
      } else {
        go(a / n, i + 1, (a % n) :: nums)
      }
    }
    return go(a, 0, Nil).mkString(" ")
  }

}
