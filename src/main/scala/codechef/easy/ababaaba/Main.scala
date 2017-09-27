package codechef.easy.ababaaba

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
    val str = StdIn.readLine()
    val n = str.length

    if (n == 1) {
      println(-1)
    } else if (n == 2) {
      if (str == "AA") {
        println("A")
      } else if (str == "BB") {
        println("B")
      } else {
        println(-1)
      }
    } else if (n == 3) {
      println(solve3(str))
    } else {
      println(solveN(str))
    }
  }

  def solve3(str: String): String = {
    val cnts = str.groupBy(identity)
    if (cnts.size == 1) {
      "-1"
    } else if (cnts('A') == 2) {
      "A"
    } else {
      "B"
    }
  }

  def solveN(str: String): String = {
    val cnts = str.groupBy(identity)
    if (cnts('A') == 2) {
      "A"
    } else if (cnts('B') == 2) {
      "B"
    } else {
      val i = str.indexOf("ABBA")
      if (i >= 0) {
        str.substring(0, i) + "ABA" + str.substring(i + 4)
      } else {
        val j = str.indexOf("BAAB")
        if (j >= 0) {
          str.substring(0, j) + "BAB" + str.substring(j + 4)
        } else {
          "-1"
        }
      }
    }
  }

}
