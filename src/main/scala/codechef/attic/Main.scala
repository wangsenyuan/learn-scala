package codechef.attic

import scala.io.StdIn

/**
  * Created by wangsenyuan on 13/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      t -= 1
      val line = StdIn.readLine()
      val r = leanJumpDays(line)
      println(r)
    }
  }

  def leanJumpDays(line: String): Int = {

    def learn(i: Int, blanks: Int, canJump: Int, res: Int): Int = {
      if (i == line.length) {
        res
      } else if (line(i) == '#') {
        if (blanks + 1 > canJump) {
          learn(i + 1, 0, blanks + 1, res + 1)
        } else {
          learn(i + 1, 0, canJump, res)
        }
      } else {
        learn(i + 1, blanks + 1, canJump, res)
      }
    }

    learn(0, 0, 1, 0)
  }
}
