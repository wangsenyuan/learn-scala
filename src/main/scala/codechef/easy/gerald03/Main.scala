package codechef.easy.gerald03

import scala.io.StdIn

/**
  * Created by wangsenyuan on 17/03/2017.
  */
object Main {

  val dn = Array("L+", "L-", "R+", "R-")
  val dl = Array(1, -1, 0, 0)
  val dr = Array(0, 0, 1, -1)

  def transform(a: Int, b: Int, c: Int, d: Int, sb: StringBuilder) = {
    var x = a
    var y = b

    while (x != c || y != d) {
      var i = 0
      var j = -1
      var maxDist = Int.MaxValue
      while (i < 4) {
        val nx = x + dl(i)
        val ny = y + dr(i)
        if (nx < ny) {
          val dist = ((c - nx).abs) + ((d - ny).abs)
          if (j == -1 || dist < maxDist || (dist == maxDist && dn(j) > dn(i))) {
            j = i
            maxDist = dist
          }
        }
        i += 1
      }
      x = x + dl(j)
      y = y + dr(j)
      sb.append(dn(j))
    }
  }

  def solve() = {
    val n = StdIn.readInt()
    val sb = new StringBuilder()
    var i = 0
    var a = -1
    var b = -1
    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      if (i > 0) {
        transform(a, b, line(0), line(1), sb)
      }
      a = line(0)
      b = line(1)

      i += 1
    }
    val l = sb.length / 2
    println(l)
    println(sb.toString())
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
