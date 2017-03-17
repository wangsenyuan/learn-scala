package codechef.easy.tproduct

import scala.io.StdIn

/**
  * Created by wangsenyuan on 17/03/2017.
  */
object Main {

  val MOD = 1000000007

  import math.log

  def solve(): Unit = {
    val h = StdIn.readInt()
    if (h > 0) {
      val v = StdIn.readLine().split("\\s+").map(_.toLong)

      val f = Array.fill(v.length)(0d)

      var i = v.length - 1
      while (i >= 0) {
        if (2 * (i + 1) > v.length) {
          f(i) = log(v(i))
        } else {
          val l = 2 * (i + 1) - 1
          val r = 2 * (i + 1)
          f(i) = (f(l) max f(r)) + log(v(i))
        }
        i -= 1
      }
      var ans = 1L
      i = 0
      while (i < f.length) {
        ans = (ans * v(i)) % MOD
        val l = 2 * (i + 1) - 1
        val r = 2 * (i + 1)
        if (r < f.length) {
          if (f(l) > f(r)) {
            i = l
          } else {
            i = r
          }
        } else {
          i = r
        }
      }

      println(ans)

      solve()
    }
  }

  def main(args: Array[String]): Unit = {

    solve()

  }
}
