package codejam.year2015.qr

import codejam.FileOp

/**
 * Created by senyuanwang on 15/5/5.
 */
object A extends App with FileOp {
  override val filePrefix = "/Users/senyuanwang/IdeaProjects/ALG/src/main/scala/codejam/year2015/qr/A-large-practice"

  def process(xs: Array[Int]): Int = {

    def go(i: Int, minInvite: Int, stand: Int): Int =
      if (i == xs.length) minInvite
      else {
        go(i + 1, minInvite max i - stand, stand + xs(i))
      }

    go(0, 0, 0)
  }

  val T = file.next().toInt

  for {
    i <- 1 to T
    line = file.next().split("\\s+")
    n = line(0).toInt
    xs = line(1).map(c => (c - '0')).toArray
  } {
    val minInvite = process(xs)
    println(s"Case #$i: $minInvite");
  }
}
