package codechef.easy.mtrxmod

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val q = firstLine(1)
    val B = Array.fill[Array[Int]](n)(null)
    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      B(i) = line
      i += 1
    }

    var A = play(B, n)
    println(A.mkString(" "))

    i = 0
    while (i < q) {
      val p = StdIn.readInt() - 1
      val F = StdIn.readLine().split("\\s+").map(_.toInt)

      var k = 0
      while (k < n) {
        B(k)(p) = F(k)
        B(p)(k) = F(k)
        k += 1
      }

      A = play(B, n)
      println(A.mkString(" "))

      i += 1
    }
  }

  def play(B: Array[Array[Int]], n: Int): Array[Int] = {
    val A = Array.fill(n)(0)

    var i = 0
    while (i < n && B(0)(i) == 0) {
      i += 1
    }

    if (i < n) {
      A(i) = -B(0)(i)
      val b = A(i)
      var j = i + 1
      while (j < n) {
        val x = -B(0)(j)
        if ((x - b).abs == B(i)(j)) {
          A(j) = x
        } else {
          A(j) = -x
        }
        j += 1
      }
    }

    A
  }
}
