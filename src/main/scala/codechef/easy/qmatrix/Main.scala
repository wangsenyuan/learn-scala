package codechef.easy.qmatrix

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/7/1.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val rows = Array.fill[(Int, Int)](n)(null)
    val cols = new Bit(n)
    var i = 0
    var sum = 0

    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val a = line(0)
      val b = line(1)
      rows(i) = (a, b)
      cols.updateRange(a - 1, b - 1, 1)
      sum += b - a + 1
      i += 1
    }

    val q = StdIn.readInt()
    i = 0
    while (i < q) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val x = line(0)
      val y = line(1)
      val (a, b) = rows(x - 1)
      var tmp = sum - (b - a + 1) - cols.query(y - 1)
      if (y >= a && y <= b) {
        tmp += 1
      }
      if (tmp % 2 == 0) {
        println("E")
      } else {
        println("O")
      }
      i += 1
    }
  }

  class Bit(sz: Int) {
    val array = Array.fill(sz + 1)(0)

    def update(i: Int, v: Int): Unit = {
      var j = i + 1
      while (j <= sz) {
        array(j) += v
        j += j & -j
      }
    }

    def query(i: Int): Int = {
      var j = i + 1
      var res = 0
      while (j > 0) {
        res += array(j)
        j -= j & -j
      }
      res
    }

    def updateRange(l: Int, r: Int, v: Int): Unit = {
      update(l, v)
      update(r + 1, -v)
    }
  }

}
