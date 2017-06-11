package codechef.easy.consesnk

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/6/10.
  */
object Main {

  def solve() = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val l = firstLine(1)
    val a = firstLine(2)
    val b = firstLine(3)

    val s = StdIn.readLine().split("\\s+").map(_.toInt).sorted.zipWithIndex

    def f(x: Int): Long = {
      s.map {
        case (y, i) =>
          (x + i * l - y).abs.toLong
      }.sum
    }

    val holes = b - a - n * l

    val res =
      if (holes > 0) {
        var left = a - 1
        var right = a + holes + 1
        var mid = 0

        while (left + 1 < right) {
          mid = (right + left) / 2
          if (f(mid) < f(mid + 1)) {
            right = mid
          } else {
            left = mid
          }
        }

        f(mid)
      } else {
        f(a)
      }

    println(res)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()

      i += 1
    }
  }
}
