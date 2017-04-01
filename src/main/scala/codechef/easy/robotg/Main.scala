package codechef.easy.robotg

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 01/04/2017.
  */
object Main {


  def solve() = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val m = line(1)

    @tailrec
    def go(i: Int, j: Int, str: String, k: Int): Boolean = {
      if (i < 0 || i >= n || j < 0 || j >= m) {
        false
      } else if (k == str.length) {
        true
      } else {
        str(k) match {
          case 'L' => go(i, j - 1, str, k + 1)
          case 'R' => go(i, j + 1, str, k + 1)
          case 'U' => go(i - 1, j, str, k + 1)
          case 'D' => go(i + 1, j, str, k + 1)
        }
      }
    }


    val str = StdIn.readLine()

    var unsafe = true
    var i = 0
    while (i < n && unsafe) {
      var j = 0
      while (j < m && unsafe) {
        unsafe = !go(i, j, str, 0)
        j += 1
      }
      i += 1
    }

    if (!unsafe) {
      println("safe")
    } else {
      println("unsafe")
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
