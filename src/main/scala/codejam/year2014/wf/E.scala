package codejam.year2014.wf

import codejam.FileOp

import scala.annotation.tailrec

/**
 * Created by senyuanwang on 15/4/28.
 */
object E extends App with FileOp {

  override val filePrefix = "src/main/scala/codejam/year2014/wf/E-large-practice";

  var cache = Map.empty[(Long, Long, Long), Long]

  def maxFoods(d: Long, a: Long, b: Long): Long = {
    val key = (d, a, b)
    cache.get(key) match {
      case Some(value) => value
      case None =>
        val value = if (d < a) 1
        else {
          maxFoods(d - a, a, b) + maxFoods(d - b, a, b)
        }
        cache += key -> value
        value
    }

  }

  @tailrec
  def minDays(n: Long, a: Long, b: Long, days: Long): Long = {
    val foods = maxFoods(days, a, b)
    if (foods >= n) days
    else minDays(n, a, b, days + 1)
  }

  val T = file.next().toInt

  for {
    t <- 1 to T
    line = file.next().split("\\s+")
    n = line(0).toLong
    a = line(1).toLong
    b = line(2).toLong
  } {
    println(s"Case #$t: ${minDays(n, a, b, 0)}")
  }

}
