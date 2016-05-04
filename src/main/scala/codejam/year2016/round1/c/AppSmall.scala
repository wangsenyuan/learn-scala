package codejam.year2016.round1.c

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 5/4/16.
  */
object AppSmall extends App {

  def play(n: Int, f: Array[Int]): Int = {
    @tailrec
    def go(first: Int, second: Int, prev: Int, list: List[Int], i: Int, r: Int): Int = {
      def canExtend(cur: Int) =
        ((f(cur) == first || f(cur) == prev) &&
          (f(first) == cur || f(first) == second))

      def stopAtMid(cur: Int, tail: List[Int]) = f(cur) != prev && (i == n - 1 || f(cur) != tail.head)

      def extendResult(cur: Int) =
        if (canExtend(cur)) {
          r max (i + 1)
        } else {
          r
        }

      list match {
        case Nil => r
        case cur :: tail =>
          val nr = extendResult(cur)
          if (stopAtMid(cur, tail)) {
            nr
          } else {
            go(first, second, cur, tail, i + 1, nr)
          }
      }
    }

    val permutations = List.range(0, n).permutations;
    var r = 0
    for {
      p <- permutations
    } {
      val first = p.head
      val second = p.tail.head
      r = go(first, second, first, p.tail, 1, r)
    }

    r
  }

  var T = StdIn.readLine().toInt

  for {
    i <- 1 to T
  } {
    val n = StdIn.readLine().toInt
    val friends = StdIn.readLine().split("\\s+").map(_.toInt - 1)
    val r = play(n, friends)
    println(s"Case #$i: $r")
  }
}

