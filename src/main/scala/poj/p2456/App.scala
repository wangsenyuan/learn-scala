package poj.p2456

import scala.io.Source

/**
 * Created by senyuanwang on 14/12/7.
 */
object App extends App {
  val lines = Source.fromFile("src/main/scala/poj/p2456/console.in").getLines()

  val firstLine = lines.next().split("\\s+")

  val n = firstLine(0).toInt
  val m = firstLine(1).toInt


  val ys = Array.fill(n)(0)

  for (i <- 0 until n) {
    ys(i) = lines.next().toInt
  }

  val xs = ys.sorted

  def check(d: Int, current: Int, last: Int, i: Int): Boolean =
    if (i == 0) true
    else if (current >= n) false
    else if (xs(current) - xs(last) < d) check(d, current + 1, last, i)
    else check(d, current + 1, current, i - 1)

  def play(lb: Int, ub: Int): Int =
    if (ub - lb <= 1) lb
    else {
      val mid = (lb + ub) / 2
      if(check(mid, 1, 0, m - 1)) play(mid, ub)
      else play(lb, mid)
    }

  println(play(0, ys.max))
}
