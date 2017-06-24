package codechef.easy.neo01

import scala.io.StdIn

/**
  * Created by wangsenyuan on 24/06/2017.
  */
object Main {

  def solve() = {
    val n = StdIn.readInt()
    val as = StdIn.readLine().split("\\s+").map(_.toLong).sorted.reverse

    var A = 0L
    var i = 0
    while (i < n && A + as(i) * i + as(i) >= 0) {
      A += as(i)
      i += 1
    }

    var res = A * i

    while (i < n) {
      res += as(i)
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
