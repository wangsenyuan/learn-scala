package codechef.easy.cookgame

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

  val mod = 1000000007

  def solve(): Unit = {
    val n = StdIn.readInt()
    val nums = StdIn.readLine().split("\\s+").map(_.toInt)

    if (nums(0) == -1) {
      nums(0) = 1
    }
    var valid = true
    var i = n - 2
    while (i >= 0 && valid) {
      if (nums(i + 1) > 1) {
        if (nums(i) == -1) {
          nums(i) = nums(i + 1) - 1
        } else if (nums(i) + 1 != nums(i + 1)) {
          valid = false
        }
      }
      i -= 1
    }

    val ans =
      if (!valid || nums(0) != 1) {
        0
      } else {
        pow(2, nums.count(_ == -1))
      }
    println(ans)
  }

  def pow(a: Int, n: Int): Long = {
    if (n == 0) {
      1L
    } else {
      val b = pow(a, n / 2)
      val c = (b * b) % mod
      if (n % 2 == 1) {
        (c * a) % mod
      } else {
        c
      }
    }
  }
}
