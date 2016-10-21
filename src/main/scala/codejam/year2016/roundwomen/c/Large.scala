package codejam.year2016.roundwomen.c

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 5/19/16.
  */
object Large extends App {

  val MASK = 1000000007L

  /**
    * W(X) = V * W(X-1) + C * V * W(X-2)
    * W(0) = 1
    * W(1) = V
    */

  def play(c: Int, v: Int, l: Int): Long = {

    @tailrec
    def go(i: Int, a: Long, b: Long): Long = {
      if (i == l) {
        a
      } else {
        go(i + 1, b, (v * b + c * v * a) % MASK)
      }
    }

    go(0, 1, v)
  }

  val t = StdIn.readInt()

  for {
    i <- 1 to t
  } {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val c = line(0)
    val v = line(1)
    val l = line(2)
    val r = play(c, v, l)
    println(s"Case #$i: $r")
  }
}
