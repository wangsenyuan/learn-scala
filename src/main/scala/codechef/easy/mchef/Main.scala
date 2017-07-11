package codechef.easy.mchef

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
  * Created by wangsenyuan on 11/07/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }


  case class Item(cost: Int, index: Int)

  implicit val itemOrd = new Ordering[Item] {
    override def compare(x: Item, y: Item): Int = {
      if (x.cost < y.cost || (x.cost == y.cost && x.index < y.index)) {
        -1
      } else if (x.cost == y.cost && x.index == y.index) {
        0
      } else {
        1
      }
    }
  }

  def solve(): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val k = firstLine(1)
    val m = firstLine(2)
    val ratings = StdIn.readLine().split("\\s+").map(_.toInt)

    val L = Array.fill[ListBuffer[Int]](n + 1)(null)
    val R = Array.fill[ListBuffer[Int]](n + 1)(null)

    val costs = Array.fill(n)(0)

    var i = 0
    while (i < m) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val l = line(0) - 1

      if (L(l) == null) {
        L(l) = ListBuffer.empty[Int]
      }
      L(l) += i

      val r = line(1) - 1

      if (R(r) == null) {
        R(r) = ListBuffer.empty[Int]
      }
      R(r) += i

      val c = line(2)
      costs(i) = c
      i += 1
    }

    val minCosts = Array.fill(n)(Int.MaxValue)

    val set = mutable.TreeSet.empty[Item]

    i = 0
    while (i < n) {
      if (L(i) != null) {
        L(i) foreach {
          j =>
            set += Item(costs(j), j)
        }
      }

      minCosts(i) = set.head.cost

      if (R(i) != null) {
        R(i) foreach {
          j =>
            set -= Item(costs(j), j)
        }
      }

      i += 1
    }


    val minusRatingsCnt = ratings.count(_ < 0)
    val w = Array.fill(minusRatingsCnt)(0)
    val v = Array.fill(minusRatingsCnt)(0)
    var j = 0

    i = 0
    while (i < n) {
      val cost = minCosts(i)
      if (ratings(i) < 0) {
        v(j) = cost
        w(j) = -ratings(i)
        j += 1
      }
      i += 1
    }


    val dp = Array.fill(k + 1)(0)

    i = 0
    while (i < v.length) {
      var x = k

      while (x >= v(i)) {
        dp(x) = dp(x) max (dp(x - v(i)) + w(i))
        x -= 1
      }

      i += 1
    }

    val tmp = dp(k)
    val ans = ratings.sum + tmp

    println(ans)

  }

}
