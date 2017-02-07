package codechef.easy.spread

import scala.io.StdIn

/**
  * Created by wangsenyuan on 07/02/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    var m = firstLine(1)
    val c = firstLine(2)

    val bit = new Bit(n)
    bit.update(0, c)

    while (m > 0) {
      val line = StdIn.readLine().split("\\s+")
      val tp = line(0)
      if (tp == "Q") {
        val i = line(1).toInt
        println(bit.query(i - 1))
      } else {
        val u = line(1).toInt
        val v = line(2).toInt
        val k = line(3).toInt
        bit.update(u - 1, k)
        bit.update(v, -k)
      }

      m -= 1
    }
  }

  class Bit(n: Int) {
    val arr = Array.fill(n + 1)(0L)

    def update(i: Int, v: Int): Unit = {
      var j = i + 1
      while (j <= n) {
        arr(j) += v
        j += j & (-j)
      }
    }

    def query(i: Int): Long = {
      var j = i + 1
      var res = 0L
      while (j > 0) {
        res += arr(j)
        j -= j & (-j)
      }
      res
    }
  }

}
