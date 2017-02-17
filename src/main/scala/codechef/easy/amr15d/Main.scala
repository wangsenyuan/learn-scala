package codechef.easy.amr15d

import scala.io.StdIn

/**
  * Created by wangsenyuan on 17/02/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val coins = StdIn.readLine().split("\\s+").map(_.toInt).sorted

    var i = 1
    while (i < n) {
      coins(i) += coins(i - 1)
      i += 1
    }

    var q = StdIn.readInt()

    while (q > 0) {
      val k = StdIn.readInt()
      var x = n / (k + 1)
      if (x * (k + 1) < n) {
        x += 1
      }
      println(coins(x - 1))
      q -= 1
    }
  }
}
