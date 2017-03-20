package codechef.easy.stfm

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/3/16.
  */
object Main {

  def cal(x: Long, m: Int) = {
    var r = x % m
    if (x % 2 == 0) {
      r *= (x / 2) % m
      r %= m
      r *= (x + 1) % m
      r %= m
    } else {
      r *= x % m
      r %= m
      r *= (x + 1) / 2 % m
      r %= m
    }
    r
  }

  def main(args: Array[String]): Unit = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val m = line(1)

    val xs = Array.fill(m)(1L)
    var i = 1
    while (i < m) {
      xs(i) = xs(i - 1) * i % m
      i += 1
    }

    val nums = StdIn.readLine().split("\\s+").map(_.toLong)
    var res = 0L
    i = 0
    while (i < n) {
      val x = nums(i)
      val a = cal(x, m)
      val b = if (x >= m - 1) {
        0
      } else {
        xs(x.toInt + 1)
      }
      res += (a + b + m - 1) % m
      res %= m
      i += 1
    }

    println(res)
  }
}
