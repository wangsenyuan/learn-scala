package codejam.year2015.round1

import codejam.FileOp

/**
 * Created by senyuanwang on 15/5/16.
 */
object A extends App with FileOp {
  override val filePrefix = "/Users/senyuanwang/IdeaProjects/ALG/src/main/scala/codejam/year2015/round1/A-large-practice"

  def firstMethod(ms: Array[Int]): Long = {
    def go(i: Int, res: Long): Long =
      if (i == ms.length - 1) res
      else go(i + 1, res + (0 max ms(i) - ms(i + 1)))

    go(0, 0L)
  }

  def secondMethod(ms: Array[Int]): Long = {
    val n = ms.length
    val ps = ms.take(n - 1)
    val qs = ms.drop(1)
    val maxRate = 0 max ps.zip(qs).map(x => x._1 - x._2).max

    ps.foldLeft(0L) {
      case (res, mi) =>
        res + (mi min maxRate)
    }
  }

  val T = file.next().toInt

  for {
    t <- 1 to T
    _ = file.next().toInt
    ms = file.next().split("\\s+").map(_.toInt)
  } {
    val fx = firstMethod(ms)
    val sx = secondMethod(ms)
    println(s"Case #$t: $fx $sx")
  }
}
