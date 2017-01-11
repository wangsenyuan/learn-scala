package codechef.easy.maandi

import scala.io.StdIn

/**
  * Created by wangsenyuan on 11/01/2017.
  */
object Main {

  def isOverLucky(x: Int): Boolean = {
    if (x == 0) {
      false
    } else {
      val m = x % 10
      if (m == 4 || m == 7) {
        true
      } else {
        isOverLucky(x / 10)
      }
    }
  }

  def countOverLuckyDividers(n: Int): Int = {
    var x = 1
    var cnt = 0
    while (x * x <= n) {
      if (n % x == 0) {
        if (isOverLucky(x)) {
          cnt += 1
        }

        val y = n / x

        if (y != x && isOverLucky(y)) {
          cnt += 1
        }
      }

      x += 1
    }
    cnt
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val n = StdIn.readInt()

      val cnt = countOverLuckyDividers(n)

      println(cnt)
      t -= 1
    }
  }
}
