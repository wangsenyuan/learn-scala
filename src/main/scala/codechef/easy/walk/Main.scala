package codechef.easy.walk

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 12/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      t -= 1
      StdIn.readInt()
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val v = walk(line)

      println(v)
    }
  }

  def walk(ws: Array[Int]): Int = {

    @tailrec
    def go(i: Int, v: Int): Int = {
      if (i < 0) {
        v
      } else {
        go(i - 1, ws(i) max (v + 1))
      }
    }

    go(ws.length - 1, 0)
  }
}
