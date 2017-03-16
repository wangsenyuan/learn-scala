package codechef.easy.makeart

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/3/16.
  */
object Main {

  def solve() = {
    val n = StdIn.readInt()
    val colors = StdIn.readLine().split("\\s+")

    var can = false
    var i = 2
    while (!can && i < n) {
      can = colors(i) == colors(i - 1) && colors(i - 1) == colors(i - 2)
      i += 1
    }
    if (can) {
      println("Yes")
    } else {
      println("No")
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
