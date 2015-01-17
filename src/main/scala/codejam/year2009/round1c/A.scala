package codejam.year2009.round1c

import codejam.FileOp

/**
 * Created by senyuanwang on 14/11/29.
 */
object A extends App with FileOp {

  override val filePrefix = "src/main/scala/codejam/year2009/round1c/A-large-practice";

  val T = file.next().toInt

  def distinctNumberOf(chars: Array[Char]) = {
    chars.toSet.size
  }

  def fill(xs: Array[Char], ys: Array[Long], map: Map[Char, Long], i: Int, num: Long): Array[Long] =
    if (i >= xs.length) ys
    else {
      val c = xs(i)
      map.get(c) match {
        case None =>
          ys(i) = num
          fill(xs, ys, map + (c -> num), i + 1, if(num == 0) 2 else num + 1)
        case Some(n) =>
          ys(i) = n
          fill(xs, ys, map, i + 1, num)
      }
    }

  def process(t: Int, sa: Array[String]): Unit = {
    val xs = file.next().toCharArray

    val base = distinctNumberOf(xs) max 2

    val ys = fill(xs, Array.fill(xs.length)(0), Map(xs(0) -> 1), 0, 0)

    val r = ys.foldLeft(0L)((sum, y) => sum * base + y)

    sa(t - 1) = s"Case #$t: $r\n"
  }

  val sa = Array.fill(T)("")

  for {
    i <- 1 to T
  } {
    process(i, sa)
  }

  writeToOutput(sa)
}
