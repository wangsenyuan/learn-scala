package codechef.easy.brokphon

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/1/1.
  */
object Main {

  def findWrongMessages(messages: Array[Int]): Int = {
    @tailrec
    def go(i: Int, prevWrong: Boolean, res: Int): Int = {
      if (i == messages.size) {
        res
      } else if (i > 0 && messages(i) != messages(i - 1)) {
        go(i + 1, true, res + 2 - (if (prevWrong) 1 else 0))
      } else {
        go(i + 1, false, res)
      }
    }

    go(0, false, 0)
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      val n = StdIn.readInt()
      val messages = StdIn.readLine().split("\\s+").map(_.toInt)
      println(findWrongMessages(messages))
    }
  }
}
