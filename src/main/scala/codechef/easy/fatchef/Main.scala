package codechef.easy.fatchef

import scala.io.StdIn

/**
 * Created by wangsenyuan on 24/03/2017.
 */
object Main {

  val MOD = 1000000009

  def solve() = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val m = line(1)

    val colors = Array.fill(n)('\n')

    var i = 0
    while (i < m) {
      val bucket = StdIn.readLine().split("\\s+")
      colors(bucket(1).toInt - 1) = bucket(0).charAt(0)
      i += 1
    }

    var ans = 1L
    var prev = -1
    i = 0
    while (i < n) {
      if (colors(i) != '\n') {
        if (prev > -1 && colors(i) != colors(prev)) {
          ans = (ans * (i - prev)) % MOD
        }
        prev = i
      }

      i += 1
    }

    println(ans)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
