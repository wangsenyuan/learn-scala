package codechef.easy.kirlab

import scala.io.StdIn

object Main {

  val MAX = 10000000

  def solve(pm: Array[Int], count: Array[Int]) = {

    val n = StdIn.readInt()
    val nums = StdIn.readLine().split("\\s+").map(_.toInt)
    val prime = Array.fill(50)(0)
    var ans = 0
    var i = 0
    while (i < n) {
      var num = nums(i)
      var pl = 0
      while (num > 1) {
        prime(pl) = pm(num)
        pl += 1
        val r = pm(num)
        while (num % r == 0) {
          num /= r
        }
      }

      val c = 1 + (0 until pl).foldLeft(0)((c, j) => c max count(prime(j)))

      if (ans < c) {
        ans = c
      }

      (0 until pl) foreach {
        j => count(prime(j)) = c
      }

      i += 1
    }

    println(ans)
  }


  def main(args: Array[String]): Unit = {
    val pm = Array.fill(MAX + 1)(0)

    var i = 2

    while (i <= MAX) {
      if (pm(i) == 0) {
        pm(i) = i
        if (i < 3163) {
          var j = i * i
          while (j <= MAX) {
            if (pm(j) == 0) {
              pm(j) = i
            }
            j += i
          }
        }
      }

      i += 1
    }

    val t = StdIn.readInt()

    val count = Array.fill(MAX)(0)

    i = 0
    while (i < t) {
      var j = 0
      while (j < MAX) {
        count(j) = 0
        j += 1
      }

      solve(pm, count)
      i += 1
    }
  }
}
