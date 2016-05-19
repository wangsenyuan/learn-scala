package codejam.year2016.roundw.c

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
    val ws = Array.fill(l + 1)(1L)

    ws(0) = 1
    ws(1) = v

    for {
      i <- 2 to l
    } {
      ws(i) = (v * ws(i - 1) + c * v * ws(i - 2)) % MASK
    }

    ws(l)
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
