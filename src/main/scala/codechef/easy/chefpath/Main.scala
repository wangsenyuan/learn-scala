package codechef.easy.chefpath

import scala.io.StdIn

/**
  * Created by wangsenyuan on 17/03/2017.
  */
object Main {

  def solve() = {
    val line = StdIn.readLine().split("\\s+")
    val n = BigInt(line(0))
    val m = BigInt(line(1))

    if (n == 1 && m != 2) {
      println("No")
    } else if (m == 1 && n != 2) {
      println("No")
    } else if (n % 2 == 0 || m % 2 == 0) {
      println("Yes")
    } else {
      println("No")
    }
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
