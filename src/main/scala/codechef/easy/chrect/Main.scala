package codechef.easy.chrect

import scala.io.StdIn

/**
  * Created by wangsenyuan on 13/02/2017.
  */
object Main {

  def dropStones(n: Int, m: Int, k: Int): Int = {
    if (n == 1 && m <= 2) {
      0
    } else if (n == 1) {
      k
    } else {
      (k + 1) / 2
    }
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val n = line(0)
      val m = line(1)
      val k = line(2)

      println(dropStones(n min m, n max m, k))

      t -= 1
    }
  }
}
