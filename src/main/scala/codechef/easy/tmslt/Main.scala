package codechef.easy.tmslt

import scala.io.StdIn

/**
  * Created by wangsenyuan on 01/03/2017.
  */
object Main {

  val MOD = 1000000

  def fillStrength(nums: Array[Int], n: Int, a: Int, b: Int, c: Int, d: Int) = {

    var i = 0

    while (i < MOD) {
      nums(i) = 0
      i += 1
    }

    var s = d
    var j = 0
    while (j < n) {
      nums(s) += 1
      val x = 1L * a * s * s + 1L * b * s + 1L * c
      s = (x % MOD).toInt
      j += 1
    }
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    val nums = Array.fill(MOD)(0)


    (0 until t) foreach {
      _ =>
        val line = StdIn.readLine().split("\\s+").map(_.toInt)
        val n = line(0)
        val a = line(1)
        val b = line(2)
        val c = line(3)
        val d = line(4)

        fillStrength(nums, n, a, b, c, d)

        var i = MOD - 1
        var sign = 1
        var res = 0L
        while (i >= 0) {
          if (nums(i) % 2 > 0) {
            res += sign * i
            sign = -sign
          }
          i -= 1
        }

        println(res)
    }
  }
}
