package codechef.easy.worldcup

import scala.io.StdIn

/**
  * Created by wangsenyuan on 18/03/2017.
  */
object Main {

  val MOD = 1000000007

  def preCompute(n: Int): Array[Array[Long]] = {
    val comb = Array.fill(n + 1, n + 1)(0L)
    var i = 0
    while (i <= n) {
      comb(i)(i) = 1
      comb(i)(0) = 1
      i += 1
    }

    i = 2
    while (i <= n) {
      var j = 1
      while (j < i) {
        comb(i)(j) = (comb(i - 1)(j) + comb(i - 1)(j - 1)) % MOD
        j += 1
      }
      i += 1
    }

    comb
  }

  def solve(comb: Array[Array[Long]]) = {
    val line = StdIn.readLine().split("\\s+")
    val R = line(0).toInt
    val B = line(1).toInt
    val L = line(2).toInt

    if (R > 6 * B) {
      println(0)
    } else {

      def getCombs(a: Int, b: Int) = if (a < b) 0L else comb(a)(b)

      var sum = 0L
      var sixes = 0
      while (sixes * 6 <= R) {
        val fours = (R - 6 * sixes) / 4
        if (fours * 4 + 6 * sixes == R) {
          var wickets = 0
          while (wickets <= L) {
            sum = (sum + getCombs(B, fours) * ((getCombs(B - fours, sixes) * getCombs(B - fours - sixes, wickets)) % MOD)) % MOD;
            wickets += 1
          }
        }
        sixes += 1
      }

      println(sum)
    }
  }

  def main(args: Array[String]): Unit = {
    val comb = preCompute(300)
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve(comb)
      i += 1
    }
  }
}
