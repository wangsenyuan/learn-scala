package wxalg.p063

import java.util

import scala.io.StdIn

/**
  * Created by wangsenyuan on 31/03/2017.
  */
object Main {

  def binarySearch(xs: Array[Int], from: Int, to: Int, x: Int) = {

    var i = from
    var j = to

    while (i < j) {
      val k = i + (j - i) / 2
      if (xs(k) < x) {
        i = k + 1
      } else {
        j = k
      }
    }

    i
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val _xs = StdIn.readLine().split("\\s+").map(_.toInt)
    val _ys = StdIn.readLine().split("\\s+").map(_.toInt)
    val ps = _xs.zip(_ys).sortBy(_._1)
    val (xs, ys) = ps.unzip

    var best = 0
    var i = 0
    while (i < n) {
      val x = xs(i)

      val j = binarySearch(xs, 0, i, x)

      var tmp = 0
      var k = i
      while (k >= j) {
        tmp += ys(k)
        k -= 1
      }

      util.Arrays.sort(ys, 0, j)
      var m = i - j

      k = j - 1
      while (k >= 0 && m > 0) {
        tmp += ys(k)
        k -= 1
        m -= 1
      }

      best = tmp max best

      i += 1
    }

    println(ys.sum - best)
  }

}
