package poj.p3061

import scala.io.Source

/**
 * Created by senyuanwang on 14/12/10.
 */
object A extends App {
  val lines = Source.fromFile("src/main/scala/poj/p3061/console.in").getLines()

  val T = lines.next().toInt

  def play(): Unit = {
    val line = lines.next().split("\\s+")
    val n = line(0).toInt
    val s = line(1).toInt
    val xs = lines.next().split("\\s+").map(_.toInt)

    val sums = Array.fill(n + 1)(0)

    for {
      i <- 0 until n
    } {
      sums(i + 1) = sums(i) + xs(i)
    }

    if (sums(n) < s) {
      println(0)
    } else {
      def find(l: Int, r: Int, x: Int): Int =
        if (r - l <= 1) r
        else {
          val mid = (l + r) / 2
          if (sums(mid) >= x) find(l, mid, x)
          else find(mid, r, x)
        }


      var i = 1
      var ans = n
      while (sums(i) + s < sums(n)) {
        val j = find(i, n, sums(i) + s)
        ans = ans min (j - i)
        i += 1
      }
      println(ans)
    }
  }

  for {
    _ <- 0 until T
  } {
    play()
  }
}
