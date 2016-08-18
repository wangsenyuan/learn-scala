package codechef.decstr

import scala.io.StdIn

/**
  * Created by wangsenyuan on 8/18/16.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val k = StdIn.readInt()

      val str = decStr(k)

      println(str)

      t -= 1
    }
  }

  private def decStr(k: Int): String = {
    def go(i: Int, j: Int, sb: StringBuilder): String = {
      if (j == k) {
        sb.toString().reverse
      } else {
        val c = ('a' + (i % 26)).toChar
        sb += c
        go(i + 1, if (i % 26 == 0) j else j + 1, sb)
      }
    }
    go(0, 0, StringBuilder.newBuilder)
  }
}
