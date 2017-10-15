package codechef.easy.chefpdig

import scala.io.StdIn

object Main {

  def solve() = {
    val n = StdIn.readLine()
    val cnt = Array.fill(10)(0)

    var i = 0
    while (i < n.length) {
      val c = n(i) - '0'
      if (cnt(c) < 10) {
        cnt(c) += 1
      }
      i += 1
    }

    var ans = ""
    i = 65
    while (i < 91) {
      val a = i / 10
      val b = i % 10
      if (a != b && cnt(a) > 0 && cnt(b) > 0) {
        ans += i.toChar
      } else if (a == b && cnt(a) > 1) {
        ans += i.toChar
      }

      i += 1
    }

    println(ans)
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
