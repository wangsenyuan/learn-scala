package codechef.easy.marblegf

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/1/31.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val q = line(1)

    val vals = StdIn.readLine().split("\\s").map(_.toInt)
    val bit = new BinaryIndexTree(vals)

    var i = 0
    while (i < q) {
      val ques = StdIn.readLine().split("\\s+")
      ques(0) match {
        case "S" =>
          println(bit.sum(ques(1).toInt, ques(2).toInt))
        case "G" =>
          bit.add(ques(1).toInt, ques(2).toInt)
        case _ =>
          bit.sub(ques(1).toInt, ques(2).toInt)
      }
      i += 1
    }
  }

  class BinaryIndexTree(vals: Array[Int]) {
    val n = vals.length
    val tree = Array.fill(n + 1)(0L)

    for {
      i <- 0 until n
    } {
      update(i, vals(i))
    }

    private def update(idx: Int, diff: Int): Unit = {
      var a = idx + 1
      while (a <= n) {
        tree(a) += diff
        a += a & (-a)
      }

      //vals(idx) += diff
    }

    def add(idx: Int, diff: Int) = update(idx, diff)

    def sub(idx: Int, diff: Int) = update(idx, -diff)

    def sum(a: Int, b: Int): Long = {

      def go(idx: Int): Long = {
        var s = 0L
        var a = idx + 1
        while (a > 0) {
          s += tree(a)
          a -= a & (-a)
        }
        s
      }

      go(b) - go(a - 1)
    }
  }

  /*class SegTree(vals: Array[Int]) {
    val n = vals.length
    val m = 2 * n + 2
    val sums = Array.fill(m)(0)

    for {
      i <- 0 until n
    } {
      add(i, vals(i))
    }

    private def mid(i: Int, j: Int) = i + (j - i) / 2

    private def update(i: Int, j: Int, k: Int, a: Int, diff: Int): Unit = {
      if (i > a || j < a || i == j) {
        //return
      } else {
        sums(k) += diff
        val m = mid(i, j)
        update(i, m, 2 * k, a, diff)
        update(m + 1, j, 2 * k + 1, a, diff)
      }
    }

    def add(a: Int, diff: Int): Unit = {
      update(0, n, 1, a, diff)
      vals(a) += diff
    }

    def sub(a: Int, diff: Int): Unit = {
      add(a, -diff)
    }

    private def sumRange(i: Int, j: Int, k: Int, a: Int, b: Int): Int = {
      if (i == j || i > b || j < a) {
        0
      } else if (a <= i && j <= b) {
        sums(k)
      } else {
        val m = mid(i, j)
        sumRange(i, m, 2 * k, a, b) + sumRange(m + 1, j, 2 * k + 1, a, b)
      }
    }

    def sum(a: Int, b: Int): Int = sumRange(0, n, 1, a, b)
  }
*/
}
