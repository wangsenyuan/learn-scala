package codejam.year2016.round1b.a

import scala.io.StdIn
import scala.language.postfixOps

/**
 * Created by wangsenyuan on 5/5/16.
 */
object AppLarge extends App {

  val T = StdIn.readLine().toInt

  val uniqueWordList = List(
    'Z' -> 0,
    'X' -> 6,
    'G' -> 8,
    'W' -> 2,
    'U' -> 4,
    'F' -> 5,
    'V' -> 7,
    'T' -> 3,
    'I' -> 9,
    'O' -> 1
  )

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

  def removeNum(m: Map[Char, Int], num: Int, cnt: Int): Map[Char, Int] = {
    val name = names(num)
    val g = name.toSeq.groupBy(c => c).view.mapValues(_.length).toMap
    m.map[Char, Int](p => {
      val (k, x) = p
      g.get(k) match {
        case None => p
        case Some(y) =>
          k -> (x - cnt * y)
      }
    }).filter(_._2 > 0)
  }

  def play(m: Map[Char, Int], list: List[(Char, Int)], result: List[Int]): List[Int] = {
    list match {
      case Nil => result.sorted
      case h :: tail =>
        val (c, num) = h
        if (m.contains(c)) {
          val y = m(c)
          play(removeNum(m, num, y), tail, List.fill(y)(num) ::: result)
        } else {
          play(m, tail, result)
        }
    }
  }

  for {
    i <- 1 to T
  } {
    val line = StdIn.readLine()
    val m = line.groupBy(c => c).view.mapValues(_.length).toMap
    val r = play(m, uniqueWordList, Nil).mkString
    println(s"Case #$i: $r")
  }
}
