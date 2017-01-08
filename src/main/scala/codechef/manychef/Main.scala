package codechef.manychef

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/1/7.
  */
object Main {

  val CHEF = "CHEF"

  def replaceByChef(str: String): String = {

    def doMatch(a: Char, b: Char) = {
      a == '?' || a == b
    }

    def check(i: Int): Boolean = {
      if (i - 3 < 0) {
        false
      } else {
        var j = 3
        while (j >= 0 && doMatch(str(i - (3 - j)), CHEF(j))) {
          j -= 1
        }
        j < 0
      }
    }

    @tailrec
    def go(i: Int, res: String): String = {
      if (i < 0) {
        res
      } else if (check(i)) {
        go(i - 4, CHEF + res)
      } else if (str(i) == '?') {
        go(i - 1, 'A' + res)
      } else {
        go(i - 1, str(i) + res)
      }
    }

    go(str.length - 1, "")
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val str = StdIn.readLine()
      val res = replaceByChef(str)
      println(res)
      t -= 1
    }
  }
}
