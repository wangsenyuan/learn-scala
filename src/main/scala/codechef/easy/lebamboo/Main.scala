package codechef.easy.lebamboo

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
    val h = StdIn.readLine().split("\\s+").map(_.toInt)
    val d = StdIn.readLine().split("\\s+").map(_.toInt)

    val ans =
      if (n == 1) {
        solve1(h, d)
      } else if (n == 2) {
        solve2(h, d)
      } else {
        solveN(n, h, d)
      }
    println(ans)
  }

  def solve1(h: Array[Int], d: Array[Int]) = {
    if (h(0) >= d(0)) {
      // why this? I don't know, and no explaination
      h(0) - d(0)
    } else {
      -1
    }
  }

  def solve2(h: Array[Int], d: Array[Int]) = {
    if (h(0) - d(0) == d(1) - h(1)) {
      (h(0) - d(0)).abs
    } else {
      -1
    }
  }

  def solveN(n: Int, h: Array[Int], d: Array[Int]) = {
    val ss = d.sum - h.sum
    if (ss < 0 || ss % (n - 2) != 0) {
      -1
    } else {
      val s = ss / (n - 2)
      val invalid =
        (0 until n).exists(i => {
          val xi = h(i) + s - d(i)
          xi < 0 || xi > 2 * s || xi % 2 == 1
        })
      if (invalid) {
        -1
      } else {
        val step =
          (0 until n).map(i => {
            (h(i) + s - d(i)) / 2
          }).sum
        if (step == s) {
          s
        } else {
          -1
        }
      }
    }
  }

}
