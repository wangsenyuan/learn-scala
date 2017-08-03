package codechef.easy.leexams

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

  case class Ticket(p: Int, a: Int, b: Int)

  def solve(): Unit = {
    val n = StdIn.readInt()
    val tickets = Array.fill[Ticket](n)(null)

    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      tickets(i) = Ticket(line(0), line(1), line(2))
      i += 1
    }

    def go(i: Int, used: Set[Int], ans: Double): Double = {
      if (i == n) {
        ans
      } else {
        val ticket = tickets(i)
        var tmp = 0.0d
        if (!used(ticket.a)) {
          tmp += go(i + 1, used + ticket.a, ans * ticket.p / 100)
        }
        if (!used(ticket.b)) {
          tmp += go(i + 1, used + ticket.b, ans * (100 - ticket.p) / 100)
        }
        tmp
      }
    }

    val ans =
      if (n <= 16) {
        go(0, Set.empty, 1.0d)
      } else {
        0.0d
      }

    println(f"$ans%.6f")
  }
}
