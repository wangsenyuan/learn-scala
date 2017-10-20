package codechef.easy.germande

import scala.io.StdIn

object Main {

  def solve() = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val o1 = firstLine(0)
    val o2 = firstLine(1)
    val n = o1 * o2
    val votes = StdIn.readLine().split("\\s+").map(_.toInt)

    val states = Array.fill(o1)(0)
    var i = 0
    while (i < n) {
      states(i / o2) += votes(i)
      i += 1
    }

    val a = o1 / 2
    val b = o2 / 2

    var can = states.count(_ > b) > a

    i = 0
    while (i < o2 && !can) {
      var tmp = 0
      var j = 0
      while (j < o1) {
        states(j) += votes((i + (j + 1) * o2) % n)
        states(j) -= votes(i + j * o2)
        if (states(j) > b) {
          tmp += 1
        }
        j += 1
      }

      can = tmp > a

      i += 1
    }

    if (can) {
      println(1)
    } else {
      println(0)
    }
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }
}
