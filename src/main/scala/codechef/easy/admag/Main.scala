package codechef.easy.admag

import scala.io.StdIn

/**
  * Created by wangsenyuan on 26/04/2017.
  */
object Main {

  def solve(n: Int) = {
    var a = 0L
    var b = 1L

    var i = 0

    while (a + b <= n) {
      i += 1
      val c = a + b
      a = b
      b = c
    }
    i
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      val n = StdIn.readInt()
      val res = solve(n)
      println(res)
      i += 1
    }
  }
}
