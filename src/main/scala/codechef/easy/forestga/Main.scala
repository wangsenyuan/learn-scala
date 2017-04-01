package codechef.easy.forestga

import scala.io.StdIn

/**
  * Created by wangsenyuan on 01/04/2017.
  */
object Main {


  def main(args: Array[String]): Unit = {

    println(Long.MaxValue)

    val firstLine = StdIn.readLine().split("\\s+")
    val n = firstLine(0).toInt
    val w = firstLine(1).toLong
    val l = firstLine(2).toLong

    val hs = Array.fill(n)(0L)
    val rs = Array.fill(n)(0L)
    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toLong)
      hs(i) = line(0)
      rs(i) = line(1)
      i += 1
    }

    def canLog(x: Long): Long = {
      var sum = 0L
      var i = 0
      while (i < n) {
        val cur = hs(i) + x * rs(i)
        if (cur >= l) {
          sum += cur
        }
        i += 1
      }

      sum
    }


    def check(x: Long): Boolean = {
      canLog(x) >= w
    }

    //    val MAX_X = w / (rs.min) + 1
    var right = 1L
    while (!check(right)) {
      right *= 2
    }

    var left = 0L

    while (left < right) {
      val mid = left + (right - left) / 2
      if (!check(mid)) {
        left = mid + 1
      } else {
        right = mid
      }
    }

    println(left)
  }
}
