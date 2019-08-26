package set0000.set000.set000.p008

import scala.annotation.tailrec

object Solution {

  def myAtoi(str: String): Int = {
    if (str == null) {
      0
    } else {
      process(str.trim)
    }
  }

  private def process(str: String): Int = {
    if (str.isEmpty) {
      0
    } else if (str.charAt(0) == '-') {
      num(-1, str.substring(1))
    } else if (str.charAt(0) == '+') {
      num(1, str.substring(1))
    } else {
      num(1, str)
    }
  }

  private def num(sign: Int, str: String): Int = {
    @tailrec
    def go(i: Int, cur: Long): Long = {
      if (i == str.length || !str(i).isDigit) {
        sign * cur
      } else if (sign * cur >= Int.MaxValue) {
        Int.MaxValue
      } else if (sign * cur <= Int.MinValue) {
        Int.MinValue
      } else {
        val x = str(i) - '0'
        go(i + 1, cur * 10 + x)
      }
    }

    val res = go(0, 0)
    if (res >= Int.MaxValue) {
      Int.MaxValue
    } else if (res <= Int.MinValue) {
      Int.MinValue
    } else {
      res.toInt
    }
  }
}
