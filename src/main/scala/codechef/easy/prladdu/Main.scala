package codechef.easy.prladdu

import scala.io.StdIn

/**
  * Created by wangsenyuan on 27/02/2017.
  */
object Main {

  def feedDinosaurs(nums: Array[Int], n: Int) = {

    var cur = 0L
    var ans = 0L

    nums foreach {
      num =>
        cur += num
        ans += cur.abs
    }

    ans
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val n = StdIn.readInt()
        val nums = StdIn.readLine().split("\\s+").map(_.toInt)
        val res = feedDinosaurs(nums, n)
        println(res)
    }
  }
}
