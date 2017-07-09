package codechef.easy.xenrank

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/7/9.
  */
object Main {

  def solve() = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val u = line(0)
    val v = line(1)

    // x + y = u + v
    val side = 0L + u + v

    val points = (1 + side) * side / 2

    val rank = points + (u + 1)

    println(rank)
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
