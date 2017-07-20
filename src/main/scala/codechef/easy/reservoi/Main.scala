package codechef.easy.reservoi

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
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val m = line(1)
    val wall = Array.fill[Array[Char]](n)(null)
    var i = 0
    while (i < n) {
      val row = StdIn.readLine().toCharArray
      wall(i) = row
      i += 1
    }
    var stable = true
    i = 0
    while (i < n && stable) {
      var j = 0
      while (j < m && stable) {
        val cell = wall(i)(j)

        if (cell == 'W') {
          if (j == 0 || j == m - 1) {
            stable = false
          } else if (wall(i)(j - 1) == 'A' || wall(i)(j + 1) == 'A') {
            stable = false
          } else if (i < n - 1 && wall(i + 1)(j) == 'A') {
            stable = false
          }
        } else if (cell == 'B') {
          if (i < n - 1 && wall(i + 1)(j) != 'B') {
            stable = false
          }
        }

        j += 1
      }

      i += 1
    }

    if (stable) {
      println("yes")
    } else {
      println("no")
    }
  }
}
