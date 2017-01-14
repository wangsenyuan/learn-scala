package codechef.easy.montrans

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/1/14.
  */
object Main {

  def moneyTransform(a: Int, b: Int, c: Int) = {

    @tailrec
    def transform(cur: Int, best: Int, res: Int, i: Int): Int = {
      if (i > 10000 || cur < c) {
        res
      } else {
        val left = cur - c
        val b = left % 100
        val a = left / 100 + 100 * b
        if (a > best) {
          transform(a, a, i, i + 1)
        } else {
          transform(a, best, res, i + 1)
        }
      }
    }

    transform(a * 100 + b, a * 100 + b, 0, 1)
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val a = line(0)
      val b = line(1)
      val c = line(2)
      val res = moneyTransform(a, b, c)

      println(res)

      t -= 1
    }
  }
}
