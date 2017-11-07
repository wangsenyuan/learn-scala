package codechef.easy.uaseq

import scala.collection.mutable
import scala.io.StdIn

object Main {

  case class Seq(a: Long, d: Long)

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val k = firstLine(1)
    val nums = StdIn.readLine().split("\\s+").map(_.toLong)

    val cnt = mutable.Map.empty[Seq, Int].withDefaultValue(0)

    var i = 1
    while (i < n) {
      val d = nums(i) - nums(i - 1)
      val a = nums(i) - i * d

      val seq = Seq(a, d)

      cnt(seq) += 1

      i += 1
    }

    val atLeastNum = n - 1 - 2 * k
    val candidates = cnt.filter(_._2 >= atLeastNum).keys.toArray.sortWith((x, y) => x.a < y.a || (x.a == y.a && x.d < y.d))

    def isArithmeticProgression(seq: Seq): Boolean = {
      val Seq(a, d) = seq
      var j = 0
      var change = 0
      while (j < n && change <= k) {
        if (nums(j) != a + j * d) {
          change += 1
        }

        j += 1
      }

      change <= k
    }

    val ans = candidates.find(isArithmeticProgression)

    val Seq(a, d) = ans.get

    i = 0
    while (i < n) {
      nums(i) = a + i * d
      i += 1
    }

    println(nums.mkString(" "))
  }


}
