package codechef.easy.chefmath

import scala.collection.mutable.ListBuffer
import scala.io.StdIn

/**
  * Created by wangsenyuan on 08/04/2017.
  */
object Main {

  import scala.language.postfixOps

  val MOD = 1000000007

  def sumWays(fs: Array[Int], x: Int, k: Int): Int = {

    var cache = Map.empty[(Int, Int, Int), Long]

    //f(x, n, k) = f(x, n - 1, k) + f(x - f(n - 1), n, k - 1)
    def go(x: Int, n: Int, k: Int): Long = {
      if (x == 0 && k == 0) {
        1
      } else if (x <= 0 || n == 0 || 1l * k * fs(n - 1) < x) {
        0L
      } else {
        cache.get((x, n, k)) match {
          case Some(r) => r
          case None =>
            val a = go(x, n - 1, k)
            val b = go(x - fs(n - 1), n, k - 1)
            val c = (a + b) % MOD
            cache += (x, n, k) -> c
            c
        }
      }

    }

    (go(x, fs.length, k) % MOD) toInt
  }

  def preCompute(): Array[Int] = {
    val fs = ListBuffer.empty[Int]
    fs += 1
    fs += 2
    var i = 2
    while (fs(i - 2) + fs(i - 1) > 0 && fs(i - 2) + fs(i - 1) < MOD) {
      fs += fs(i - 2) + fs(i - 1)
      i += 1
    }
    fs.toArray
  }

  def main(args: Array[String]): Unit = {
    val fs = preCompute()

    val q = StdIn.readInt()

    var i = 0
    while (i < q) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val x = line(0)
      val k = line(1)
      val ans = sumWays(fs, x, k)
      println(ans)
      i += 1
    }
  }
}
