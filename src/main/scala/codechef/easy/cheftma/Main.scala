package codechef.easy.cheftma

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }

  def solve(): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val k = firstLine(1)
    val m = firstLine(2)

    val as = StdIn.readLine().split("\\s+").map(_.toInt)
    val bs = StdIn.readLine().split("\\s+").map(_.toInt)
    val cs = StdIn.readLine().split("\\s+").map(_.toInt)
    val ds = StdIn.readLine().split("\\s+").map(_.toInt)

    val xs = as.zip(bs).map {
      case (a, b) => a - b
    }.sorted.reverse

    val ys = (cs ++ ds).sorted.reverse

    var ans = 0L
    var i = 0
    var j = 0
    while (i < n && j < ys.length) {
      while (j < ys.length && ys(j) > xs(i)) {
        j += 1
      }

      if (j < ys.length) {
        ans += xs(i) - ys(j)
        j += 1
      }

      i += 1
    }

    while (i < n) {
      ans += xs(i)
      i += 1
    }

    println(ans)
  }
}
