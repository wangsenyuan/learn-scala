package codechef.easy.clmbstrs

import scala.io.StdIn

/**
  * Created by wangsenyuan on 23/02/2017.
  */
object Main {

  val M = 1000000007
  val N = 1000001

  def guess(f: Array[Long], n: Int, g: Int): Boolean = {
    var a = f(n)
    var res = 0
    while (a > 0) {
      val x = a & 1

      res += x.toInt

      a = a >> 1
    }

    res == g
  }

  def preComputeFib(n: Int) = {
    val f = Array.fill(n)(0L)

    f(0) = 1
    f(1) = 2
    var i = 2
    while (i < n) {
      f(i) = (f(i - 1) + f(i - 2)) % M
      i += 1
    }
    f
  }

  def main(args: Array[String]): Unit = {

    val f = preComputeFib(N)

    var t = StdIn.readInt()
    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)

      val n = line(0)
      val g = line(1)

      if (guess(f, n - 1, g)) {
        println("CORRECT")
      } else {
        println("INCORRECT")
      }

      t -= 1
    }
  }
}
