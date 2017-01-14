package codechef.easy.chefrp

import scala.io.StdIn

/**
  * Created by wangsenyuan on 14/01/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      var n = StdIn.readInt()
      val freqs = StdIn.readLine().split("\\s+").map(_.toInt)
      val minFreq = freqs.min

      if (minFreq == 1) {
        println(-1)
      } else {
        val total = freqs.sum
        println(total - minFreq + 2)
      }

      t -= 1
    }
  }
}
