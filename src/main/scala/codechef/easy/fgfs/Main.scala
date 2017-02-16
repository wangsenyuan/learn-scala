package codechef.easy.fgfs

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 16/02/2017.
  */
object Main {

  type Interval = (Int, Int)

  def serve(compartment: Vector[Interval]): Int = {
    val ss = compartment.sortBy(_._2)

    @tailrec
    def go(prev: Option[Interval], left: Vector[Interval], cnt: Int): Int = {
      left match {
        case Vector() => cnt
        case h +: tail =>
          prev match {
            case Some(x) if h._1 < x._2 => go(prev, tail, cnt)
            case _ => go(Some(h), tail, cnt + 1)
          }
      }
    }

    go(None, ss, 0)
  }

  def arrange(compartments: Array[Vector[Interval]]): Long = {

    @tailrec
    def go(i: Int, res: Long): Long = {
      if (i == compartments.length) {
        res
      } else {
        go(i + 1, serve(compartments(i)) + res)
      }
    }


    go(0, 0L)
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      var n = line(0)
      val k = line(1)

      val compartments = Array.fill(k)(Vector.empty[Interval])

      while (n > 0) {
        val customer = StdIn.readLine().split("\\s+").map(_.toInt)
        val s = customer(0)
        val t = customer(1)
        val p = customer(2)
        compartments(p - 1) = compartments(p - 1) :+ (s, t)
        n -= 1
      }

      val res = arrange(compartments)

      println(res)

      t -= 1
    }
  }
}
