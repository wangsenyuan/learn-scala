package codejam.year2016.round2.b

import scala.io.StdIn

/**
  * Created by wangsenyuan on 6/13/16.
  */
object App extends App {

  def play(ps: Array[Double], k: Int): Double = {
    val n = ps.length
    val ss = ps.sorted
    val halfK = k / 2
    def dp(cs: Array[Double]): Double = {
      val fx = Array.fill(halfK + 1, k + 1)(0.0d)

      fx(0)(0) = 1.0d

      for {
        i <- 0 to halfK
        j <- (1 max i - 1) to k
      } {
        fx(i)(j) += fx(i)(j - 1) * (1 - cs(j - 1))
        if (i > 0) {
          fx(i)(j) += fx(i - 1)(j - 1) * cs(j - 1)
        }
      }

      fx(halfK)(k)
    }
    val array = Array.fill(k)(0.0d)

    def pick(m: Int) = {
      var i = 0
      while (i < m) {
        array(i) = ss(i)
        i += 1
      }

      while (i < k) {
        array(i) = ss(n - k + i)
        i += 1
      }
    }

    var i = 0
    var ret = 0.0d
    while (i <= k) {
      pick(i)
      ret = ret max dp(array)
      i += 1
    }

    ret
  }

  val T = StdIn.readInt()

  var t = 1
  while (t <= T) {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    //    val n = line(0)
    val k = line(1)
    val ps = StdIn.readLine().split("\\s+").map(_.toDouble)
    val result = play(ps, k)
    println(f"Case #$t: $result%.6f")
    t += 1
  }
}
