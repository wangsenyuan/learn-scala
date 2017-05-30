package codechef.easy.capimove

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/5/30.
  */
object Main {

  def solve() = {
    val n = StdIn.readInt()
    val p = StdIn.readLine().split("\\s+").map(_.toInt)
    //    val s = p.zipWithIndex.sortBy(_._1).reverse
    val g = Array.fill[ListBuffer[Int]](n)(null)

    val set = mutable.TreeSet.empty[Int]
    val map = mutable.Map.empty[Int, Int]
    var i = 0
    while (i < n) {
      g(i) = ListBuffer.empty[Int]
      g(i) += p(i)
      set += p(i)
      map(p(i)) = i
      i += 1
    }

    i = 0
    while (i < n - 1) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val j = line(0) - 1
      val k = line(1) - 1

      g(j) += p(k)
      g(k) += p(j)

      i += 1
    }


    val res = Array.fill(n)(0)
    i = 0
    while (i < n) {
      val neighbors = g(i)

      var j = 0
      while (j < neighbors.length) {
        set -= neighbors(j)
        j += 1
      }

      if (set.isEmpty) {
        res(i) = 0
      } else {
        res(i) = map(set.last) + 1
      }

      j = 0
      while (j < neighbors.length) {
        set += neighbors(j)
        j += 1
      }
      i += 1
    }
    println(res.mkString(" "))
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    (0 until t) foreach {
      _ => solve()
    }
  }
}
