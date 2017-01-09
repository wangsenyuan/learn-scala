package codechef.easy.flags

import scala.io.StdIn

/**
  * Created by wangsenyuan on 09/01/2017.
  */
object Main {

  def pn(n: Int, x: Int): Long = {
    if (x == 0) {
      1L
    } else {
      n * pn(n - 1, x - 1)
    }
  }

  def flag1(n: Int): Long = {
    if (n == 2) {
      pn(n, 2)
    } else {
      pn(n, 2) + pn(n, 3)
    }
  }

  def flag2(n: Int) = flag1(n)

  def flag3(n: Int): Long = {
    if (n == 2) {
      0
    } else {
      pn(n, 3)
    }
  }

  def flag4(n: Int): Long = {
    if (n == 2) {
      0
    } else if (n == 3) {
      pn(n, 3)
    } else {
      pn(n, 3) + pn(n, 4)
    }
  }

  def flag5(n: Int): Long = {
    flag4(n)
  }

  def flags(n: Int): Long = {
    if (n <= 1) {
      0
    } else {
      flag1(n) + flag2(n) + flag3(n) + flag4(n) + flag5(n)
    }
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val n = StdIn.readInt()
      println(flags(n))
      t -= 1
    }
  }
}
