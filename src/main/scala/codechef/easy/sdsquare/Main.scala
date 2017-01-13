package codechef.easy.sdsquare

import scala.io.StdIn

/**
  * Created by wangsenyuan on 12/01/2017.
  */
object Main {
  val PERFECT_DIGITS = Array.fill(10)(false)
  PERFECT_DIGITS(0) = true
  PERFECT_DIGITS(1) = true
  PERFECT_DIGITS(4) = true
  PERFECT_DIGITS(9) = true

  def isPerfectSquare(x: Long): Boolean = {
    var y = x
    var res = true
    while (y > 0 && res) {
      val m = (y % 10).toInt
      res = PERFECT_DIGITS(m)
      y = y / 10
    }

    res
  }


  def perfectSquareNumbers(n: Long): Stream[Long] = {
    def go(i: Long): Stream[Long] = {
      val x = i * i
      if (x > n) {
        Stream.empty
      } else if (isPerfectSquare(x)) {
        x #:: go(i + 1)
      } else {
        go(i + 1)
      }
    }

    go(0)
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readLine().trim.toInt

    val nums = perfectSquareNumbers(10000000000L)

    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toLong)

      val a = line(0)
      val b = line(1)

      val res = nums.filter(p => p >= a && p <= b).size

      println(res)

      t -= 1
    }
  }
}
