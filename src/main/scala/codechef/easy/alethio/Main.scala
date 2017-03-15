package codechef.easy.alethio

import scala.io.StdIn

/**
  * Created by wangsenyuan on 15/03/2017.
  */
object Main {

  def findUniverseAge(str: String): String = {
    val n = str.length
    val left = Array.fill(n)(n)
    val right = Array.fill(n)(-1)

    var prevDigit = 0
    var i = 0
    while (i < n) {
      if (str(i).isDigit) {
        left(i) = prevDigit
      } else {
        left(i) = prevDigit
        prevDigit = i + 1
      }
      i += 1
    }

    i = n - 1
    var nextDigit = n - 1
    while (i >= 0) {
      if (str(i).isDigit) {
        right(i) = nextDigit
      } else {
        right(i) = nextDigit
        nextDigit = i - 1
      }
      i -= 1
    }
    var res = ""

    i = 0

    while (i < n) {
      val a = left(i)
      val b = right(i) + 1
      val tmp =
        if (!str(i).isDigit) {
          str.substring(a, i) + "9" + str.substring(i + 1, b)
        } else {
          str.substring(a, b)
        }

      var c = 0
      while (c < tmp.length && tmp(c) == '0') {
        c += 1
      }
      val cur = if (c == tmp.length) "0" else tmp.substring(c)

      if (cur.length > res.length || (cur.length == res.length && cur > res)) {
        res = cur
      }
      i += 1
    }

    return res
  }

  def main(args: Array[String]): Unit = {
    val str = StdIn.readLine()

    val res = findUniverseAge(str)

    println(res)
  }
}
