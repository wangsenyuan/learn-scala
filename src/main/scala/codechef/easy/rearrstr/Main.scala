package codechef.easy.rearrstr

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 04/03/2017.
  */
object Main {

  def zipExt(a: String, b: String): String = {
    var c = ""
    var i = 0
    while (i < a.length + b.length) {
      if (i % 2 == 0) {
        c += a(i / 2)
      } else {
        c += b(i / 2)
      }

      i += 1
    }

    c
  }

  def arrange(str: String): Option[String] = {
    val sg = str.groupBy(identity).mapValues(_.size).toVector.sortBy(_._2).reverse
    val (c, x) = sg.head

    val n = str.length
    if (2 * x > n + 1) {
      None
    } else {
      val top = (n + 1) / 2

      def dispatch(a: String, b: String, c: Char, x: Int) = {
        var na = a
        var nb = b
        var nx = x

        while (nx > 0) {
          if (na.length < top) {
            na += c
          } else {
            nb += c
          }

          nx -= 1
        }


        (na, nb)
      }


      @tailrec
      def go(sg: Vector[(Char, Int)], a: String, b: String): String = {
        sg match {
          case Vector() => zipExt(a, b)
          case (c, x) +: tail =>
            val (na, nb) = dispatch(a, b, c, x)
            go(tail, na, nb)
        }
      }

      Some(go(sg, "", ""))
    }
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val str = StdIn.readLine()

        arrange(str) match {
          case None => println("-1")
          case Some(s) => println(s)
        }

    }
  }
}
