package codechef.easy.life

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
    val s = StdIn.readLine().map(c => c - '0')
    val n = s.length

    def go(i: Int, res: Vector[Int]): Vector[Int] = {
      if (i == n + 2) {
        res.take(n)
      } else {
        val a = res(i - 2)
        val b = res(i - 1)
        val c = a ^ b ^ s((i - 1) % n)

        if (i % n == 0 && c != res(0)) {
          Vector()
        } else if (i % n == 1 && c != res(1)) {
          Vector()
        } else {
          go(i + 1, res :+ c)
        }
      }
    }

    val a = go(2, Vector(0, 0))
    val b = go(2, Vector(0, 1))
    val c = go(2, Vector(1, 0))
    val d = go(2, Vector(1, 1))

    val tmp = Vector(a, b, c, d)
    val candidate = tmp.filter(_.size > 0)
    if (candidate.isEmpty) {
      println("No solution")
    } else if (candidate.size > 1) {
      println("Multiple solutions")
    } else {
      println(candidate.head.mkString(""))
    }
  }
}
