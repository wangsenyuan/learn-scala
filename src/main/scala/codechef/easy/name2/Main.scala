package codechef.easy.name2

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 08/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt

    while (t > 0) {
      val line = StdIn.readLine().split("\\s+")
      val x = line(0)
      val y = line(1)

      if (check(x, y) || check(y, x)) {
        println("YES")
      } else {
        println("NO")
      }
      t -= 1
    }
  }

  def check(x: String, y: String): Boolean = {
    @tailrec
    def go(i: Int, j: Int): Boolean = {
      if (j == y.length) {
        true
      } else if (i == x.length) {
        false
      } else if (x(i) == y(j)) {
        go(i + 1, j + 1)
      } else {
        go(i + 1, j)
      }
    }

    go(0, 0)
  }
}
