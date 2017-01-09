package codechef.easy.dividing

import scala.io.StdIn

/**
  * Created by wangsenyuan on 8/20/16.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val n = StdIn.readLong()
    val nums = StdIn.readLine().split("\\s+").map(_.toLong)

    val a = n * (n + 1) / 2
    val b = nums.sum

    if (a == b) {
      println("YES")
    } else {
      println("NO")
    }
  }
}
