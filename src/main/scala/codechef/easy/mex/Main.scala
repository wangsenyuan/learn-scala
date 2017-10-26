package codechef.easy.mex

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
    val k = firstLine(1)
    val nums = StdIn.readLine().split("\\s+").map(_.toInt)


    var i = 0
    var m = 0
    while (i < n) {
      if (nums(i) > m) {
        m = nums(i)
      }
      i += 1
    }

    m += 1

    val flag = Array.fill(m + 1)(false)

    i = 0
    while (i < n) {
      flag(nums(i)) = true
      i += 1
    }
    var kk = k + 1

    i = 0
    while (i <= m && kk > 0) {
      if (!flag(i)) {
        kk -= 1
      }

      i += 1
    }

    println(i + kk - 1)
  }
}
