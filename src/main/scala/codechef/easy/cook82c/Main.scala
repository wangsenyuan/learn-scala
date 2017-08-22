package codechef.easy.cook82c

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)

    val nums = StdIn.readLine().split("\\s+").map(_.toLong)

    val q1 = nums.sorted.reverse
    val q2 = Array.fill(63 * n)(0L)

    var a = 0
    var b = 0
    var c = 0

    val qs = Array.fill(m)(0)

    var i = 0
    while (i < m) {
      qs(i) = StdIn.readInt() - 1
      i += 1
    }
    val mx = qs.max
    val res = Array.fill(mx + 1)(0L)
    i = 0
    while (i <= mx) {
      if (a < n) {
        val x = q1(a)

        if (b < c) {
          val y = q2(b)

          if (x >= y) {
            a += 1
            if (x > 1) {
              q2(c) = x / 2
              c += 1
            }
            res(i) = x
          } else {
            b += 1
            if (y > 1) {
              q2(c) = y / 2
              c += 1
            }
            res(i) = y
          }
        } else {
          a += 1
          if (x > 1) {
            q2(c) = x / 2
            c += 1
          }
          res(i) = x
        }
      } else {
        val y = q2(b)
        b += 1
        if (y > 1) {
          q2(c) = y / 2
          c += 1
        }
        res(i) = y
      }

      i += 1
    }

    qs foreach {
      q => println(res(q))
    }
  }
}
