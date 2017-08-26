package codechef.easy.dcgame

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)
    val nums = StdIn.readLine().split("\\s+").map(_.toInt)
    val left = Array.fill(n)(0)
    val right = Array.fill(n)(n)
    val stack = Array.fill(n)(-1)
    var i = 0
    var p = 0
    while (i < n) {

      while (p > 0 && nums(stack(p - 1)) < nums(i)) {
        p -= 1
      }

      left(i) =
        if (p > 0) {
          stack(p - 1)
        } else {
          -1
        }

      stack(p) = i
      p += 1

      i += 1
    }

    i = n - 1
    p = 0
    while (i >= 0) {
      while (p > 0 && nums(stack(p - 1)) <= nums(i)) {
        p -= 1
      }

      right(i) =
        if (p > 0) {
          stack(p - 1)
        } else {
          n
        }

      stack(p) = i
      p += 1

      i -= 1
    }

    val cnts = Array.fill[(Int, Long)](n)(null)

    i = 0
    while (i < n) {
      val num = nums(i)

      cnts(i) = num -> (1l * (right(i) - i) * (i - left(i)))

      i += 1
    }

    val srt = cnts.sortBy(_._1)

    val sum = Array.fill[(Int, Long)](n)(null)

    i = n - 1
    while (i >= 0) {
      sum(i) = cnts(i)

      if (i < n - 1) {
        sum(i) = sum(i)._1 -> (sum(i)._2 + sum(i + 1)._2)
      }

      i -= 1
    }

    val total = 1l * n * (n + 1) / 2
    var res = ""

    i = 0
    while (i < m) {
      val line = StdIn.readLine().split("\\s+")
      val x = line(1).toInt
      val first = line(2)
      val tmp =
        line(0) match {
          case ">" =>
            val j = binarySearch(n, sum(_)._1 > x)
            if (j == n) {
              0
            } else {
              sum(j)._2
            }
          case "<" =>
            val j = binarySearch(n, sum(_)._1 >= x)
            if (j == n) {
              total
            } else {
              total - sum(j)._2
            }
          case "=" =>
            val a = binarySearch(n, sum(_)._1 >= x)
            val b = binarySearch(n, sum(_)._1 > x)

            if (b < n) {
              sum(a)._2 - sum(b)._2
            } else if (a < n) {
              sum(a)._2
            } else {
              0
            }
        }
      if (tmp % 2 == 1) {
        res += first
      } else {
        res += anotherPlayer(first)
      }

      i += 1
    }

    println(res)
  }

  def binarySearch(len: Int, f: (Int) => Boolean): Int = {
    var i = 0
    var j = len
    while (i < j) {
      val mid = i + (j - i) / 2
      if (f(mid)) {
        j = mid
      } else {
        i = mid + 1
      }
    }
    j
  }

  def anotherPlayer(player: String) = if (player == "D") "C" else "D"
}
