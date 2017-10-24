package codechef.easy.fillmtr

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
    val q = firstLine(1)

    val parent = (0 until n).toArray
    val diff = Array.fill(n)(0)

    def find(x: Int): Int = {
      if (parent(x) != x) {
        val t = parent(x)
        parent(x) = find(parent(x))
        diff(x) ^= diff(t)
      }

      parent(x)
    }

    var valid = true

    var i = 0
    while (i < q) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)

      if (valid) {
        val a = line(0) - 1
        val b = line(1) - 1
        val c = line(2)
        val pa = find(a)
        val pb = find(b)
        if (pa == pb) {
          if (c != (diff(a) ^ diff(b))) {
            valid = false
          }
        } else {
          parent(pa) = pb
          diff(pa) = diff(a) ^ diff(b) ^ c
        }
      }

      i += 1
    }

    if (valid) {
      println("yes")
    } else {
      println("no")
    }
  }
}
