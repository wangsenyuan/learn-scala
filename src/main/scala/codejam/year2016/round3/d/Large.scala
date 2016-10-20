package codejam.year2016.round3.d

import scala.io.StdIn

/**
  * Created by wangsenyuan on 19/10/2016.
  */
object Large extends App {

  val T = StdIn.readInt

  var t = 1

  while (t <= T) {

    val nl = StdIn.readLine().split("\\s+")
    val g = StdIn.readLine().split("\\s+")
    val b = StdIn.readLine()

    play(g.toSet, b, nl(1).toInt) match {
      case None =>
        println(f"Case #$t: IMPOSSIBLE")
      case Some(x) =>
        println(f"Case #$t: $x")
    }

    t += 1
  }

  def play(good: Set[String], bad: String, l: Int): Option[String] = {
    if (good(bad)) {
      None
    } else if (l > 1) {
      val first = bad.flatMap {
        case '0' => "1?"
        case '1' => "0?"
      }
      val second = bad.init.flatMap {
        case '0' => "10"
        case '1' => "01"
      }

      Some(first + " " + second)
    } else {
      if (bad(0) == '0') {
        Some("1 1?")
      } else {
        Some("0 0?")
      }
    }
  }
}
