package codechef.easy.schedule

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
  * Created by wangsenyuan on 02/06/2017.
  */
object Main {

  def gen(s: String, n: Int): String = {
    val tmp = s * (n / 2)
    if (n % 2 == 1) {
      tmp + s(0)
    } else {
      tmp
    }
  }

  def solve() = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val K = line(1)
    val str = StdIn.readLine()

    val l01 = gen("01", n)
    val l10 = gen("10", n)
    if (l10.zip(str).count(x => x._1 != x._2) <= K) {
      println(1)
    } else if (l01.zip(str).count(x => x._1 != x._2) <= K) {
      println(1)
    } else {
      val blocksBuf = ListBuffer.empty[Int]
      var j = 0
      var i = 1
      while (i <= n) {
        if (i == n || str(i) != str(i - 1)) {
          blocksBuf += i - j
          j = i
        }

        i += 1
      }

      val blocks = blocksBuf.toArray

      def check(blocks: Array[Int], l: Int): Boolean = {
        blocks.map(_ / (l + 1)).sum <= K
      }

      var l = 2
      var r = blocks.max
      while (l < r) {
        val mid = l + (r - l) / 2
        if (check(blocks, mid)) {
          r = mid
        } else {
          l = mid + 1
        }
      }
      println(l)
    }

  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {

      solve()

      i += 1
    }
  }
}
