package codejam.year2016.roundw.c

import scala.io.StdIn

/**
  * Created by wangsenyuan on 5/19/16.
  */
object Small extends App {

  val V = 'V'
  val C = 'C'
  val MASK = 1000000007L
  def template(l: Int): List[List[Char]] = {
    if (l == 0) {
      List(Nil)
    } else {
      val sub = template(l - 1)
      sub.flatMap {
        s =>
          s match {
            case x :: _ if x == V => List(V :: s, C :: s)
            case _ => List(V :: s)
          }
      }
    }
  }

  private def calculate(list: List[Char], c: Long, v: Long): Long = {
    list.map(x => if (x == V) v else c).foldLeft(1L)(_ * _ % MASK)
  }

  def play(c: Long, v: Long, l: Long): Long = {
    template(l.toInt).foldLeft(0L) {
      (sum, l) =>
        (sum + calculate(l, c, v)) % MASK
    }
  }

  val t = StdIn.readInt()

  for {
    i <- 1 to t
  } {
    val line = StdIn.readLine().split("\\s+").map(_.toLong)
    val c = line(0)
    val v = line(1)
    val l = line(2)
    val r = play(c, v, l)
    println(s"Case #$i: $r")
  }
}
