package codejam.year2016.round3.a

import scala.io.StdIn

/**
  * Created by wangsenyuan on 5/9/16.
  */
object Small extends App {

  case class Party(cnt: Int, label: String)

  def sortParty(a: Party, parties: List[Party]): List[Party] =
    if (a.cnt == 0) {
      parties
    } else parties match {
      case Nil => a :: Nil
      case h :: tail if (a.cnt >= h.cnt) => a :: parties
      case h :: tail => h :: sortParty(a, tail)
    }

  private def evacuate2(a: Party, b: Party, plan: List[String]): List[String] = {
    if (a.cnt == b.cnt && a.cnt == 0) {
      plan.reverse
    } else if (a.cnt - b.cnt >= 2) {
      evacuate2(a.copy(cnt = a.cnt - 2), b, a.label + a.label :: plan)
    } else if (a.cnt == b.cnt) {
      evacuate2(a.copy(cnt = a.cnt - 1), b.copy(cnt = b.cnt - 1), a.label + b.label :: plan)
    } else {
      evacuate2(a.copy(cnt = a.cnt - 1), b, a.label :: plan)
    }
  }


  private def evacuate(parties: List[Party], plan: List[String]): List[String] =
    parties match {
      case Nil => plan.reverse
      case a :: b :: Nil => evacuate2(a, b, plan)
      case a :: b :: c :: tail if (a.cnt - b.cnt >= 2) =>
        evacuate(sortParty(a.copy(cnt = a.cnt - 2), parties.tail), a.label + a.label :: plan)
      case h :: tail =>
        evacuate(sortParty(h.copy(cnt = h.cnt - 1), tail), h.label :: plan)
    }

  def play(parties: List[Int]): List[String] = {
    val labeled = parties.zip(('A' to 'Z')).map(p => Party(p._1, "" + p._2));
    evacuate(labeled.sortBy(_.cnt).reverse, Nil)
  }

  val T = StdIn.readLine().toInt
  for {
    i <- 1 to T
  } {
    val _ = StdIn.readLine().toInt
    val line = StdIn.readLine().split("\\s+").map(_.toInt).toList
    val plan = play(line)
    println(s"Case #$i: ${plan.mkString(" ")}")
  }
}
