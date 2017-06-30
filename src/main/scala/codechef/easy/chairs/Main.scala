package codechef.easy.chairs

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/6/30.
  */
object Main {

  def solve() = {
    val n = StdIn.readInt()
    val chairs = StdIn.readLine().toCharArray

    var i = 0
    while (i < n && chairs(i) == '0') {
      i += 1
    }
    require(i != n)
    // i == n should not happen
    // first not empty chair
    val x = i
    var empty = 0
    var longest = 0
    var j = x
    i = (i + 1) % n
    while (i != x) {
      if (chairs(i) == '0') {
        empty += 1
        val tmp = (i + n - j) % n
        if (tmp > longest) {
          longest = tmp
        }
      } else {
        j = i
      }
      i = (i + 1) % n
    }

    val ans = empty - longest
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
