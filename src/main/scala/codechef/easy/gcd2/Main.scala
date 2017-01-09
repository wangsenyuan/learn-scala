package codechef.easy.gcd2

import scala.io.StdIn

/**
  * Created by wangsenyuan on 8/16/16.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val line = StdIn.readLine().split("\\s+")
      val a = line(0)
      val b = line(1)
      if (a == "0") {
        println(b)
      } else {
        val c = gcd2(a, b)
        println(c)
      }
      t -= 1
    }
  }

  def gcd2(a: String, b: String): Int = {
    val len2 = b.length()

    var c = 0
    var i = 0
    val x = a.toInt

    while (i < len2) {
      c = c * 10 + b(i) - '0'
      c = c % x
      i += 1
    }
    gcd(x, c)
  }

  def gcd(a: Int, b: Int): Int = {
    if (b == 0) {
      a
    } else {
      gcd(b, a % b)
    }
  }
}
