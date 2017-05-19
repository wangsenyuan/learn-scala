package codechef.easy.strq

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/5/19.
  */
object Main {

  def findPos(x: Char): Int = {
    if (x == 'c') {
      0
    } else if (x == 'h') {
      1
    } else if (x == 'e') {
      2
    } else {
      3
    }
  }

  def main(args: Array[String]): Unit = {
    val str = StdIn.readLine().trim

    val n = str.length
    val count = Array.fill(n, 4)(0L)
    val f = Array.fill(n, 4, 4)(0L)


    //c, h, e, f
    var i = 0
    while (i < n) {


      var k = 0
      while (k < 4) {
        var j = 0
        while (j < 4) {
          if (i > 0) {
            f(i)(j)(k) = f(i - 1)(j)(k)
          }

          if (i > 0 && k == findPos(str(i))) {
            f(i)(j)(k) += count(i - 1)(j)
          }
          j += 1
        }

        if (i > 0) {
          count(i)(k) = count(i - 1)(k)
        }

        if (k == findPos(str(i))) {
          count(i)(k) += 1
        }

        k += 1
      }

      i += 1
    }

    i = 0
    val q = StdIn.readInt()
    while (i < q) {
      val line = StdIn.readLine().split("\\s+")
      val a = findPos(line(0)(0))
      val b = findPos(line(1)(0))
      val l = line(2).toInt - 1
      val r = line(3).toInt - 1

      val ans =
        if (l == 0) {
          f(r)(a)(b)
        } else {
          val tmp1 = f(l - 1)(a)(b)
          val tmp2 = 1l * count(l - 1)(a) * (count(r)(b) - count(l - 1)(b))
          f(r)(a)(b) - tmp1 - tmp2
        }

      println(ans)
      i += 1
    }
  }
}
