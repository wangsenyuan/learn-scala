package codechef.easy.colarr

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/7/2.
  */
object Main {

  def readMatrix(n: Int) = {
    val matrix = Array.fill[Array[Int]](n)(null)
    var i = 0
    while (i < n) {
      matrix(i) = StdIn.readLine().split("\\s+").map(_.toInt)
      i += 1
    }
    matrix
  }

  def solve() = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)
    val k = firstLine(2)

    val A = StdIn.readLine().split("\\s+").map(_.toInt - 1)

    require(A.length == n)

    val B = readMatrix(n)
    val C = readMatrix(n)
    val X = Array.fill(n)(0)
    var sum = 0L
    var i = 0
    while (i < n) {
      sum += B(i)(A(i))
      var j = 0
      while (j < m) {
        X(i) = X(i) max (B(i)(j) - B(i)(A(i)) - C(i)(j))
        j += 1
      }
      i += 1
    }

    val Y = X.sorted.reverse.take(k)

    val ans = sum + Y.sum

    println(ans)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
