package codechef.easy.setdiff

import scala.io.StdIn

/**
  * Created by wangsenyuan on 24/02/2017.
  */
object Main {
  val MOD = 1000000007

  val N = 100000

  def preComputePow2(n: Int) = {
    val ps = Array.fill(n + 1)(1L)

    (1 to n) foreach {
      i =>
        val j = i / 2
        val x = ps(j)
        val y = x * x % MOD
        ps(i) = y
        if (i % 2 == 1) {
          ps(i) = y * 2 % MOD
        }
    }

    ps
  }

  def main(args: Array[String]): Unit = {
    val p2 = preComputePow2(N)

    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val _ = StdIn.readInt()
        val nums = StdIn.readLine().split("\\s+").map(_.toInt).sorted
        val n = nums.length

        var res = 0L
        (0 until n) foreach {
          i =>
            (i + 1 until n) foreach {
              j =>
                val sz = j - i + 1 - 2
                res = (res + (nums(j).toLong - nums(i).toLong) * p2(sz) % MOD) % MOD
            }
        }

        println(res)
    }

  }

  def main2(args: Array[String]): Unit = {
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
