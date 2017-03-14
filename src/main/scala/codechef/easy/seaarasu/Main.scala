package codechef.easy.seaarasu

import scala.io.StdIn

/**
  * Created by wangsenyuan on 14/03/2017.
  */
object Main {

  def gcd(a: Long, b: Long): Long = {
    if (b == 0) {
      a
    } else {
      gcd(b, a % b)
    }
  }

  def solve() = {
    val n = StdIn.readInt()
    val nums = StdIn.readLine().split("\\s+").map(_.toLong)

    val ans = if (n == 1) {
      nums(0)
    } else {
      val g = nums.reduce(gcd)
      g * n
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
