package codechef.firesc

import scala.io.StdIn

/**
  * Created by wangsenyuan on 28/12/2016.
  */
object Main {


  def main(args: Array[String]): Unit = {
    var t = StdIn.readLine().trim.toInt
    while (t > 0) {
      t -= 1
      val firstLine = StdIn.readLine().trim.split("\\s+").map(_.toInt)
      val n = firstLine(0)
      val m = firstLine(1)
      var i = 0
      val set = new UFSet(n)
      while (i < m) {
        i += 1
        val line = StdIn.readLine().trim.split("\\s+").map(_.toInt - 1)
        set.union(line(0), line(1))
      }

      val x = set.routes

      val y = set.countCandidateSelectionWays()

      println(s"$x $y")
    }
  }
}

class UFSet(val n: Int) {
  val M = 1000000007

  private val nos = (0 until n).toArray
  private val size = Array.fill(n)(1)
  var routes = n

  private def find(x: Int): Int = {
    val p = nos(x)

    if (p != x) {
      nos(x) = find(p)
    }

    nos(x)
  }

  def union(x: Int, y: Int): Boolean = {
    val px = find(x)
    val py = find(y)
    if (px == py) {
      false
    } else {
      if (size(px) >= size(py)) {
        nos(py) = px
        size(px) += size(py)
      } else {
        nos(px) = py
        size(py) += size(px)
      }
      routes -= 1
      true
    }
  }

  def countCandidateSelectionWays() = {
    var i = 0
    var ans = 1L
    while (i < n) {
      if (nos(i) == i) {
        ans = ans * size(i) % M
      }

      i += 1
    }
    ans
  }

}
