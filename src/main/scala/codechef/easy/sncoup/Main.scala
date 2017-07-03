package codechef.easy.sncoup

import scala.io.StdIn

/**
  * Created by wangsenyuan on 03/07/2017.
  */
object Main {

  def snake(c: Char): Int = if (c == '*') 1 else 0

  def solve() = {
    val n = StdIn.readInt()
    val row0 = StdIn.readLine().toCharArray.map(snake)
    val row1 = StdIn.readLine().toCharArray.map(snake)
    var cnt0 = row0.sum
    var cnt1 = row1.sum

    var ans = 0
    if (cnt0 == 0 && cnt1 == 0) {
      ans = 0
    } else if (cnt0 == 0) {
      ans = cnt1 - 1
    } else if (cnt1 == 0) {
      ans = cnt0 - 1
    } else {
      // horizontal
      ans = 1
      cnt0 = 0
      cnt1 = 0
      var i = 0
      while (i < n) {
        if (row0(i) == 1) {
          cnt0 += 1
        }

        if (row1(i) == 1) {
          cnt1 += 1
        }

        if (cnt0 > 1 || cnt1 > 1) {
          ans += 1
          cnt0 = 0
          cnt1 = 0
          i -= 1
        }

        i += 1
      }
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
