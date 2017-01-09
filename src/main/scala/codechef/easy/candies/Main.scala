package codechef.easy.candies

import scala.io.StdIn

/**
  * Created by wangsenyuan on 12/10/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val line = StdIn.readLine()
      if (!line.trim().isEmpty) {
        val nk = line.split("\\s+").map(_.toLong)
        val n = nk(0)
        val k = nk(1)
        if (k == 0) {
          println(s"0 $n")
        } else {
          println(s"${n / k} ${n % k}")
        }
        t -= 1
      }
    }
  }
}
