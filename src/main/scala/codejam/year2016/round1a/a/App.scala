package codejam.year2016.round1a.a

import scala.io.StdIn

/**
  * Created by wangsenyuan on 4/28/16.
  */
object App extends App {

  def play(s: String): String = {
    val sb = StringBuilder.newBuilder

    for {
      x <- s
    } {
      if (sb.isEmpty) {
        sb.append(x)
      } else {
        if (x >= sb(0)) {
          sb.insert(0, x)
        } else {
          sb.append(x)
        }
      }
    }
    return sb.toString()
  }

  val t = StdIn.readLine().toInt

  for {
    i <- 1 to t
  } {
    val s = StdIn.readLine()
    val t = play(s)
    println(s"Case #$i: $t")
  }
}
