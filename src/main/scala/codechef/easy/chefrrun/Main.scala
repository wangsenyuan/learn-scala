package codechef.easy.chefrrun

import scala.annotation.tailrec
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
    val dishes = StdIn.readLine().split("\\s+").map(_.toInt)

    val checked = Array.fill(n)(0)

    @tailrec
    def check(i: Int): Unit = {
      if (checked(i) < 2) {
        checked(i) += 1
        check((i + dishes(i) + 1) % n)
      }
    }

    var i = 0
    while (i < n) {
      if (checked(i) == 0) {
        check(i)
      }

      i += 1
    }

    val res = checked.count(_ == 2)
    println(res)
  }
}
