package codechef.easy.grguy

import scala.io.StdIn

/**
  * Created by wangsenyuan on 13/03/2017.
  */
object Main {

  def solve() = {
    val lane1 = StdIn.readLine()
    val lane2 = StdIn.readLine()

    val n = lane1.length

    val f = Array.fill(n)(n + 1)
    val g = Array.fill(n)(n + 1)

    f(0) = if (lane1(0) == '.') 0 else n + 1
    g(0) = if (lane2(0) == '.') 0 else n + 1

    var i = 0
    while (i < n) {
      if (lane1(i) == '.') {
        if (i < n - 1 && lane1(i + 1) == '.') {
          f(i + 1) = f(i + 1) min f(i)
        }

        if (lane2(i) == '.') {
          g(i) = g(i) min (f(i) + 1)
        }

        if (i < n - 1 && lane2(i + 1) == '.') {
          g(i + 1) = g(i + 1) min (f(i) + 1)
        }
      }

      if (lane2(i) == '.') {
        if (i < n - 1 && lane2(i + 1) == '.') {
          g(i + 1) = g(i + 1) min g(i)
        }
        if (lane1(i) == '.') {
          f(i) = f(i) min (g(i) + 1)
        }

        if (i < n - 1 && lane1(i + 1) == '.') {
          f(i + 1) = f(i + 1) min (g(i) + 1)
        }
      }

      i += 1
    }

    val ans = f(n - 1) min g(n - 1)
    if (ans == n + 1) {
      println("No")
    } else {
      println("Yes")
      println(ans)
    }
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
