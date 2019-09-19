package codejam.year2016.round1b.a

import scala.io.StdIn

/**
 * Created by wangsenyuan on 5/5/16.
 */
object AppSmall extends App {

  val numbers = (0 to 9).toList
  val names = Map(
    1 -> "ONE",
    2 -> "TWO",
    3 -> "THREE",
    4 -> "FOUR",
    5 -> "FIVE",
    6 -> "SIX",
    7 -> "SEVEN",
    8 -> "EIGHT",
    9 -> "NINE",
    0 -> "ZERO"
  )

  def hasNumber(m: Map[Char, Int], num: Int): Boolean = {
    val name = names(num)
    val g = name.groupBy(c => c).mapValues(_.length)
    var has = true
    for {
      (c, v) <- g
      if has
    } {
      m.get(c) match {
        case Some(y) => has = y >= v
        case None => has = false
      }
    }
    has
  }

  def removeNum(m: Map[Char, Int], num: Int): Map[Char, Int] = {
    val name = names(num)
    val g = name.groupBy(c => c).mapValues(_.length)
    m.map(p => {
      val (k, x) = p
      g.get(k) match {
        case None => p
        case Some(y) =>
          k -> (x - y)
      }
    }).filter(_._2 > 0)
  }

  def play(m: Map[Char, Int], prev: Int): Option[List[Int]] = {
    if (m.isEmpty) {
      Some(Nil)
    } else {
      numbers.filter(_ >= prev).foldLeft(None: Option[List[Int]]) {
        (result, num) =>
          result match {
            case None if (hasNumber(m, num)) =>
              play(removeNum(m, num), num).map(num :: _)
            case _ => result
          }
      }
    }
  }


  val T = StdIn.readLine().toInt

  for {
    i <- 1 to T
  } {
    val line = StdIn.readLine()
    val m = line.toSeq.groupBy(c => c).view.mapValues(_.length).toMap
    val r = play(m, -1).get.mkString
    println(s"Case #$i: $r")
  }

}
