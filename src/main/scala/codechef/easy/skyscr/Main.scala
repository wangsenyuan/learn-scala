package codechef.easy.skyscr

import scala.io.StdIn

/**
  * Created by wangsenyuan on 25/05/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      val line = StdIn.readLine().split("\\s+")
      val n = BigInt(line(0))
      val m = BigInt(line(1))

      val res = (n - m).abs

      println(res)

      i += 1
    }
  }
}
