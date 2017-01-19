package codechef.easy.dboy

import scala.io.StdIn

/**
  * Created by wangsenyuan on 17/01/2017.
  */
object Main {

  def preCompute(h: Array[Int], k: Array[Int], n: Int) = {
    val mx = h.max
    val f = Array.fill(2 * mx + 1)(Int.MaxValue)
    f(0) = 0
    var i = 0
    while (i < n) {
      var j = k(i)
      while (j <= 2 * mx) {
        f(j) = f(j) min (1 + f(j - k(i)))
        j += 1
      }

      i += 1
    }

    f
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val n = StdIn.readInt()
      val h = StdIn.readLine().split("\\s+").map(_.toInt)
      val k = StdIn.readLine().split("\\s+").map(_.toInt)

      val f = preCompute(h, k, n)

      var i = 0
      var res = 0
      while (i < n) {
        res += f(2 * h(i))
        i += 1
      }

      println(res)

      t -= 1
    }
  }
}
