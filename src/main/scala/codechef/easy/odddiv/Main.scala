package codechef.easy.odddiv

import scala.io.StdIn

/**
  * Created by wangsenyuan on 13/02/2017.
  */
object Main {

  /*def oddDiv(l: Int, r: Int): Long = {

    def cal(x: Int): Long = {
      var a = l / x
      if (a * x < l) {
        a += 1
      }
      val b = r / x

      1L * (b - a + 1) * x
    }

    var ans = 0L
    var x = 1

    while (x <= r) {
      ans += cal(x)
      x += 2
    }

    ans
  }
*/
  def main(args: Array[String]): Unit = {
    val M = 100000

    val f = Array.fill(M + 1)(0L)

    var i = 1
    while (i <= M) {
      var d = i
      while (d <= M) {
        f(d) += i
        d += i
      }
      i += 2
    }

    var t = StdIn.readInt()

    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val l = line(0)
      val r = line(1)

      //      val ans = oddDiv(l, r)
      var ans = 0L

      var x = l
      while (x <= r) {
        ans += f(x)
        x += 1
      }
      println(ans)

      t -= 1
    }
  }
}
