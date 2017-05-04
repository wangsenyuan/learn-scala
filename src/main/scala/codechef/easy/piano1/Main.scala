package codechef.easy.piano1

import scala.io.StdIn

/**
  * Created by wangsenyuan on 04/05/2017.
  */
object Main {

  def convert(c: Char) =
    if (c == 'T') {
      2
    } else {
      1
    }

  def solve() = {
    val s = StdIn.readLine().trim
    val n = StdIn.readInt()
    val k = s.map(convert).sum
    val m = 12 * n
    var res = 0L
    var i = k
    while (i < m) {
      res += m - i
      i += k
    }

    println(res)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readLine().trim.toInt
    var i = 0
    while (i < t) {
      solve()

      i += 1
    }
  }
}
