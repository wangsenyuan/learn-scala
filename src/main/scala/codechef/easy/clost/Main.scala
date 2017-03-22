package codechef.easy.clost

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
  * Created by wangsenyuan on 22/03/2017.
  */
object Main {

  def process(qs: ListBuffer[(Int, Int)]) = {
    var i = 0
    while (i < qs.length) {

      var j = 0
      while (j < i) {
        val (af, as) = qs(i)
        val (bf, bs) = qs(j)

        if (af <= bf && bs <= as && as <= bs) {
          qs += ((af, bf - 1))
          qs += ((bf, as))
          qs += ((as + 1, bs))
          qs.remove(i)
          qs.remove(j)
          i -= 2
        } else if (bf <= af && af <= bs && bs <= as) {
          qs += ((bf, af - 1))
          qs += ((af, bs))
          qs += ((bs + 1, as))
          qs.remove(i)
          qs.remove(j)
          i -= 2
        }

        j += 1
      }

      i += 1
    }

    qs.sortBy(x => x._2 - x._1 + 1).toArray
  }

  def solve() = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val m = line(1)
    val qs = new ListBuffer[(Int, Int)]()
    var i = 0
    while (i < m) {
      val ab = StdIn.readLine().split("\\s+").map(_.toInt)
      val a = ab(0)
      val b = ab(1)
      qs += ((a, b))
      i += 1
    }

    val vs = process(qs)

    val ans = Array.fill(n)('?')

    i = 0
    while (i < vs.size) {
      val (a, b) = vs(i)
      var j = a
      var cnt = 0
      while (j <= b) {
        if (ans(j) == '?') {
          cnt += 1
        }
        j += 1
      }

      var chk = 0
      j = a
      while (j <= b) {
        if (ans(j) == '?' && chk < cnt / 2) {
          ans(j) = '('
          chk += 1
        } else if (ans(j) == '?' && chk >= cnt / 2) {
          ans(j) = ')'
        }
        j += 1
      }
      i += 1
    }

    i = 0
    while (i < n) {
      if (ans(i) == '?') {
        ans(i) = '('
      }
      i += 1
    }

    println(ans.mkString(""))

  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      solve()
      t -= 1
    }

  }
}
