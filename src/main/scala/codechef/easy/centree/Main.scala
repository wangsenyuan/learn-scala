package codechef.easy.centree

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
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val b = firstLine(1)
    if (n == 2 && b == 1) {
      println("YES")
      println("1 2")
    } else if (4 * b > n) {
      println("NO")
    } else {
      println("YES")
      val centroid = 1
      val end = 2 * b + 1
      var i = centroid
      while (i < end) {
        println(s"$i ${i + 1}")
        i += 1
      }

      i += 1
      while (i <= n) {
        println(s"1 $i")
        i += 1
      }
    }
  }
}
