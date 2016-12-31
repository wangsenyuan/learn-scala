package codechef.compiler

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by senyuanwang on 2016/12/31.
  */
object Main {

  def parse(s: String): Int = {
    val n = s.size

    @tailrec
    def go(i: Int, count: Int, res: Int): Int = {
      if (count < 0 || i == n) {
        res
      } else s(i) match {
        case '<' => go(i + 1, count + 1, res)
        case '>' if count == 1 => go(i + 1, count - 1, i + 1)
        case _ => go(i + 1, count - 1, res)
      }
    }

    go(0, 0, 0)
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      t -= 1
      val s = StdIn.readLine()
      val res = parse(s)
      println(res)
    }
  }
}
