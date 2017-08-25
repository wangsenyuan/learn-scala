package codechef.easy.sealine

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }

  def solve(): Unit = {
    val n = StdIn.readInt()
    val A = StdIn.readLine().split("\\s+").map(_.toInt)

    val next = Array.fill(n + 1)(-1)
    val pos = Array.fill(n + 1)(0)

    var sum = 0
    var i = 1
    while (i <= n) {
      val a = A(i - 1)

      val left = pos(a)
      val right = i - left - 1

      sum += left min right

      var b = next(a)
      next(i) = b
      next(a) = i
      pos(i) = pos(a) + 1
      while (b >= 0) {
        pos(b) += 1
        b = next(b)
      }

      i += 1
    }

    println(sum)
  }

}
