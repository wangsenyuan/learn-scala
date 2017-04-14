package codechef.easy.bipin3

import scala.io.StdIn

/**
  * Created by wangsenyuan on 14/04/2017.
  */
object Main {

  val MOD = 1000000007


  def pow(a: Int, n: Int): Long = {
    if (n == 0) {
      1L
    } else {
      val b = pow(a, n >> 1)
      val c = (b * b) % MOD
      if ((n & 1) == 1) {
        (c * a) % MOD
      } else {
        c
      }
    }
  }

  def solve(): Unit = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val k = line(1)

    val ans = (1l * k * pow(k - 1, n - 1)) % MOD

    println(ans)

  }

  def main(args: Array[String]): Unit = {
    /*(0 until 10) foreach {
      i => println(pow(2, i))
    }*/

    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
