package poj.p3061

import scala.io.Source

/**
 * Created by senyuanwang on 14/12/10.
 */
object B extends App {

  val lines = Source.fromFile("src/main/scala/poj/p3061/console.in").getLines()

  val T = lines.next().toInt

  def play(): Unit = {
    val line = lines.next().split("\\s+")
    val n = line(0).toInt
    val s = line(1).toInt
    val xs = lines.next().split("\\s+").map(_.toInt)

    def go(i: Int, j: Int, sum: Int, ans: Int): Int =
      if(j < n && sum < s) go(i, j + 1, sum + xs(j), ans)
      else if(j == n && sum < s) ans % (n + 1)
      else go(i + 1, j, sum - xs(i), if(sum - xs(i) >= s) ans min (j - i - 1) else ans)

    println(go(0, 0, 0, n + 1))
  }

  for {
    _ <- 0 until T
  } {
    play()
  }
}
