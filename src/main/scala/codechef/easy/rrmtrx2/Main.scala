package codechef.easy.rrmtrx2

import scala.io.StdIn

/**
  * Created by wangsenyuan on 20/02/2017.
  */
object Main {

  val M = 10000007

  def calculate(matrix: Array[Array[Int]], n: Int, m: Int) = {

    def sumCol(j: Int): Int = {
      var i = 0
      var res = 0
      while (i < n) {
        res = (res + matrix(i)(j))
        i += 1
      }
      res
    }

    var res = 1L
    var j = 0
    while (j < m) {
      res = (res * sumCol(j)) % M
      j += 1
    }

    while (res < 0) {
      res += M
    }
    res
  }

  def main(args: Array[String]): Unit = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val m = line(1)
    val matrix = Array.fill[Array[Int]](n)(null)
    var i = 0
    while (i < n) {
      val row = StdIn.readLine().split("\\s+").map(_.toInt)
      matrix(i) = row
      i += 1
    }

    val res = calculate(matrix, n, m)

    println(res)
  }
}
