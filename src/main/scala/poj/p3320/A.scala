package poj.p3320

import scala.io.Source

/**
 * Created by senyuanwang on 14/12/11.
 */
object A extends App {

  val lines = Source.fromFile("src/main/scala/poj/p3320/console.in").getLines()

  val p = lines.next().toInt

  val as = lines.next().split("\\s+").map(_.toInt)

  var set = Set.empty[Int]

  for {
    a <- as
  } {
    set += a
  }

  val n = set.size

  def sketch(j: Int, sum: Int, count: Map[Int, Int]): (Int, Int, Map[Int, Int]) = {
    if (j < as.length && sum < n) {
      val point = if (count(as(j)) == 0) 1 else 0
      sketch(j + 1, sum + point, count + (as(j) -> (1 + count(as(j)))))
    } else {
      (j, sum, count)
    }
  }

  def play(i: Int, j: Int, ans: Int, sum: Int, count: Map[Int, Int]): Int = {
    if (i == as.length) ans
    else if (sum < n) {
      val (nj, nsum, ncount) = sketch(j, sum, count)
      if (nsum < n) {
        ans
      } else {
        play(i, nj, ans, nsum, ncount)
      }
    } else if (count(as(i)) > 1) {
      play(i + 1, j, ans min (j - i), sum, count + (as(i) -> (count(as(i)) - 1)))
    } else {
      play(i + 1, j, ans min (j - i), sum - 1, count + (as(i) -> 0))
    }
  }

  println(play(0, 0, as.length, 0, Map.empty[Int, Int].withDefaultValue(0)))
}
