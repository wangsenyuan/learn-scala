package codejam.year2016.roundwomen.b

import scala.io.StdIn

/**
  * Created by wangsenyuan on 5/14/16.
  */
object Large extends App {
  val t = StdIn.readInt()

  for {
    i <- 1 to t
  } {
    val line = StdIn.readLine().split("\\s+").map(_.toLong)
    val d = line(0)
    val k = line(1)
    val n = line(2)
    val (prev, next) = play(d, k, n)
    println(s"Case #$i: $next $prev")
  }


  def play(d: Long, k: Long, n: Long): (Long, Long) = {
    if (k % 2 == 1) {
      val prev = ((k - 2 + 2 * n) % d) + 1
      val next = ((k + 2 * n) % d) + 1
      (prev, next)
    } else {
      var prev = ((k - 2 - 2 * n) % d) + 1
      if (prev < 0) {
        prev += d
      }
      var next = ((k - 2 * n) % d) + 1
      if (next < 0) {
        next += d
      }
      (prev, next)
    }
  }
}
