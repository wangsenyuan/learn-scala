package codejam.year2015.qr

import codejam.FileOp

/**
 * Created by senyuanwang on 15/5/5.
 */
object B extends App with FileOp {
  override val filePrefix = "/Users/senyuanwang/IdeaProjects/ALG/src/main/scala/codejam/year2015/qr/B-large-practice"

  def process(xs: Array[Int]): Int = {
    val maxX = xs.max

    var ans = maxX

    for {
      x <- 1 until maxX
    } {
      var totalMoves = 0
      for {
        p <- xs
      } {
        totalMoves += (p - 1) / x
      }

      ans = ans min (x + totalMoves)
    }

    ans
  }

  val T = file.next().toInt

  for {
    t <- 1 to T
    n = file.next().toInt
    xs = file.next().split("\\s+").map(_.toInt)
  } {
    val y = process(xs)
    println(s"Case #$t: $y")
  }
}
