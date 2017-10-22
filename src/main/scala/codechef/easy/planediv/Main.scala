package codechef.easy.planediv

import scala.annotation.tailrec
import scala.collection.mutable
import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }

  case class Slop(x: Int, y: Int)

  @tailrec
  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) {
      a
    } else {
      gcd(b, a % b)
    }
  }

  def solve(): Unit = {
    val n = StdIn.readInt()
    val xs = mutable.Set.empty[Slop]
    val ys = mutable.Set.empty[Slop]
    val os = mutable.Map.empty[Slop, mutable.Set[(Int, Int, Int)]]
    var i = 0

    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val a = line(0)
      val b = line(1)
      val c = line(2)
      if (a == 0) {
        val g = gcd(b, c)
        ys += Slop(b / g, c / g)
      } else if (b == 0) {
        val g = gcd(a, c)
        xs += Slop(a / g, c / g)
      } else {
        val d = gcd(a, b)
        val g = gcd(d, c)

        val key = Slop(a / d, b / d)
        val value = (a / g, b / g, c / g)
        if (!os.contains(key)) {
          os += key -> mutable.Set.empty
        }
        os(key) += value
      }
      i += 1
    }

    val ans = xs.size max ys.size max (os.maxBy(_._2.size)._2.size)

    println(ans)
  }
}
