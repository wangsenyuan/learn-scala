package set300.set310.p316

/**
  * Created by wangsenyuan on 02/11/2016.
  */
object Solution3 {

  def main(args: Array[String]): Unit = {
    println(removeDuplicateLetters("bcabc"))
    println(removeDuplicateLetters("cbacdcbc"))
  }

  def removeDuplicateLetters(s: String): String = {

    def update(cnts: Map[Char, Int], queue: Vector[Char], added: Set[Char], c: Char): (Map[Char, Int], Vector[Char], Set[Char]) = {
      queue match {
        case Vector() => (cnts, Vector(c), added + c)
        case _ if added(c) => (cnts + (c -> (cnts(c) - 1)), queue, added)
        case init :+ last if (last > c && cnts(last) > 1) =>
          update(cnts + (last -> (cnts(last) - 1)), init, added - last, c)
        case _ =>
          (cnts, queue :+ c, added + c)
      }
    }

    def visit(i: Int, cnts: Map[Char, Int], queue: Vector[Char], added: Set[Char]): Vector[Char] = {
      if (i == s.length) {
        queue
      } else {
        val (newCnts, newQueue, newAdded) = update(cnts, queue, added, s(i))
        visit(i + 1, newCnts, newQueue, newAdded)
      }
    }


    def construct(queue: Vector[Char], added: Set[Int], res: String): String = {
      queue match {
        case Vector() => res
        case h +: tail if added(h) => construct(tail, added, res)
        case h +: tail => construct(tail, added + h, res + h)
      }
    }

    construct(visit(0, s.groupBy(identity).mapValues(_.length), Vector(), Set()), Set(), "")
  }
}
