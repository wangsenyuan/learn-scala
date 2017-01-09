package codechef.easy.lcpesy

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 21/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val a = StdIn.readLine()
      val b = StdIn.readLine()

      val as = groupAndSort(a)
      val bs = groupAndSort(b)

      val c = findCommonPattern(as, bs)

      println(c)

      t -= 1
    }
  }

  def findCommonPattern(as: List[(Char, Int)], bs: List[(Char, Int)]): Int = {
    @tailrec
    def go(as: List[(Char, Int)], bs: List[(Char, Int)], res: Int): Int = {
      (as, bs) match {
        case (Nil, _) => res
        case (_, Nil) => res
        case (a :: at, b :: bt) if (a._1 == b._1) =>
          go(at, bt, res + (a._2 min b._2))
        case (a :: _, b :: bt) if (a._1 > b._1) =>
          go(as, bt, res)
        case (a :: at, b :: _) if (a._1 < b._1) =>
          go(at, bs, res)
      }
    }

    go(as, bs, 0)
  }

  def groupAndSort(str: String): List[(Char, Int)] = {
    str.groupBy(identity).mapValues(_.length).toList.sortBy(_._1)
  }
}
