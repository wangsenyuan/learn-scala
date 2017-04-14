package codechef.easy.devjerry

import scala.io.StdIn

/**
  * Created by wangsenyuan on 14/04/2017.
  */
object Main {

  def solve() = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val sx = line(1)
    val sy = line(2)
    val ex = line(3)
    val ey = line(4)
    val bx = line(5)
    val by = line(6)

    var ans = (sx - ex).abs + (sy - ey).abs

    if (sx == ex && sx == bx && by > (sy min ey) && by < (sy max ey)) {
      ans += 2
    } else if (sy == ey && sy == by && bx > (sx min ex) && bx < (sx max ex)) {
      ans += 2
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
