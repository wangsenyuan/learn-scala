package codechef.easy.galactik

import scala.io.StdIn

/**
  * Created by wangsenyuan on 15/04/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    var m = firstLine(1)

    val set = new UFSet(n)

    while (m > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt - 1)
      set.union(line(0), line(1))
      m -= 1
    }


    val mi = Array.fill(n)(10001) //min cost in set i
    val count = Array.fill(n)(0) //no of planets in set i
    var ovi = 10001 //min cost in all planets
    var i = 0
    while (i < n) {
      val cost = StdIn.readInt()

      val p = set.find(i)
      count(p) += 1
      if (cost >= 0) {
        mi(p) = mi(p) min cost
        ovi = ovi min cost
      }

      i += 1
    }
    var fail = false
    var se = 0
    var total = 0
    i = 0
    while (i < n && !fail) {
      if (count(i) > 0) {
        se += 1
        if (mi(i) == 10001) {
          //has to add one more negative cost into the tree
          fail = true
        }
        total += mi(i)
      }
      i += 1
    }

    if (se == 1) {
      println(0)
    } else if (fail) {
      println(-1)
    } else {
      val ans = ovi * (se - 1) + total - ovi
      println(ans)
    }
  }

  class UFSet(size: Int) {
    val array = Array.fill(size)(-1)
    val count = Array.fill(size)(1)

    def find(x: Int): Int = {
      val p = array(x)
      if (p == x) {
        x
      } else if (p == -1) {
        array(x) = x
        x
      } else {
        val y = find(p)
        array(x) = y
        y
      }
    }

    def union(x: Int, y: Int): Unit = {
      val px = find(x)
      val py = find(y)
      if (px != py) {
        if (count(px) > count(py)) {
          array(py) = px
          count(px) += count(py)
        } else {
          array(px) = py
          count(py) += count(px)
        }
      }
    }
  }

}
