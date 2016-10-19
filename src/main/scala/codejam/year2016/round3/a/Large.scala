package codejam.year2016.round3.a

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 18/10/2016.
  */
object Large extends App {


  val t = StdIn.readInt()

  var i = 1
  while (i <= t) {
    val s = StdIn.readLine()
    val r = play(s)
    println(s"Case #$i: $r")
    i += 1
  }

  def play(s: String): Int = {

    @tailrec
    def pair(s: String, r: Int): Int = {
      if (s.isEmpty) {
        r
      } else {
        var i = 1
        while (i < s.length && s(i) != s(i - 1)) {
          i += 1
        }
        if (i == s.length) {
          r
        } else {
          pair(s.take(i - 1) + s.drop(i + 1), r + 1)
        }
      }
    }

    val x = pair(s, 0)
    val y = s.length / 2 - x

    10 * x + 5 * y
  }
}
