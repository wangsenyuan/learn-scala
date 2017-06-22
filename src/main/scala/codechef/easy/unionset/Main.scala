package codechef.easy.unionset

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/6/22.
  */
object Main {

  def solve() = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val k = firstLine(1)

    val sets = Array.fill[mutable.Set[Int]](n)(null)
    val map = mutable.Map.empty[mutable.Set[Int], Int].withDefaultValue(0)
    var i = 0
    while (i < n) {
      sets(i) = mutable.Set.empty[Int]
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      sets(i) ++= line.tail
      map(sets(i)) += 1
      i += 1
    }

    val elems = map.toArray
    var res = 0
    i = 0
    while (i < elems.length) {
      val (a, ac) = elems(i)
      if (ac > 1 && a.size == k) {
        res += ac * (ac - 1) / 2
      }

      var j = i + 1
      while (j < elems.length) {
        val tmp = mutable.Set.empty[Int]
        tmp ++= a
        val (b, bc) = elems(j)
        tmp ++= b

        if (tmp.size == k) {
          res += ac * bc
        }

        j += 1
      }

      i += 1
    }

    println(res)
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
