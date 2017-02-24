package codechef.easy.setdiff

import scala.io.StdIn

/**
  * Created by wangsenyuan on 24/02/2017.
  */
object Main {
  val MOD = 1000000007

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val n = StdIn.readInt()
        val nums = StdIn.readLine().split("\\s+").map(_.toInt).sorted

        var p = 0L
        var q = 0L

        (0 until n) foreach {
          i =>
            p = (2 * p + nums(i)) % MOD
            q = (2 * q + nums(n - i - 1)) % MOD
        }

        println((q - p + MOD) % MOD)
    }

  }
}
