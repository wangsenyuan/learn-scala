package codechef.easy.pairing

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 04/01/2017.
  */
object Main {

  def findBestPairing(pairs: Array[(Int, Int)], n: Int): List[Int] = {
    val paird = Array.fill(n + 1)(false)

    @tailrec
    def go(i: Int, res: List[Int]): List[Int] = {
      if (i < 0) {
        res
      } else {
        val (a, b) = pairs(i)
        if (paird(a) || paird(b)) {
          go(i - 1, res)
        } else {
          paird(a) = true
          paird(b) = true
          go(i - 1, i :: res)
        }
      }
    }

    go(pairs.length - 1, Nil)
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = firstLine(0)
      val m = firstLine(1)

      val pairs = Array.fill[(Int, Int)](m)(null)

      var i = 0
      while (i < m) {
        val line = StdIn.readLine().split("\\s+").map(_.toInt)
        pairs(i) = (line(0), line(1))
        i += 1
      }

      val res = findBestPairing(pairs, n)

      println(res.mkString(" "))

      t -= 1
    }
  }
}
