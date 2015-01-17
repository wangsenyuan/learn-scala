package codejam.year2008.round1

import scala.io.Source

/**
 * Created by senyuanwang on 14/11/23.
 */
object A extends App {
  val file = Source.fromFile("src/main/scala/codejam/year2008/round1/A-large-practice.in").getLines()
  val T = file.next().toInt

  def process(t: Int): Unit = {
    val n = file.next().toInt
    val xs = file.next().split("\\s+").map(_.toLong).sorted
    val ys = file.next().split("\\s+").map(_.toLong).sorted

    var res: BigInt = 0

    for {
      i <- 0 until n
      x = xs(i)
      y = ys(n - 1 - i)
    } {
      res += x * y
    }

    println(s"Case #$t: $res")
  }

  for {
    i <- 1 to T
  } process(i)

}
