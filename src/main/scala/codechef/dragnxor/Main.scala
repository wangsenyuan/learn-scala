package codechef.dragnxor

import scala.io.StdIn

/**
  * Created by wangsenyuan on 08/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt
    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val res = dragnxor(line(0), line(1), line(2))
      println(res)
      t -= 1
    }
  }

  def dragnxor(n: Int, a: Int, b: Int): Int = {
    val acnt = bitCount(n, a)
    val bcnt = bitCount(n, b)

    val overlap =
      if (acnt + bcnt > n) {
        acnt + bcnt - n
      } else {
        n - acnt - bcnt
      }

    ((1 << n) - 1) >> overlap << overlap
  }

  def bitCount(n: Int, x: Int): Int = {
    var cnt = 0
    var i = 0
    while (i < n) {
      if (((x >> i) & 1) == 1) {
        cnt += 1
      }
      i += 1
    }

    cnt
  }
}
