package codechef.easy.csub

import scala.io.StdIn

/**
  * Created by wangsenyuan on 14/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      t -= 1
      val n = StdIn.readInt()
      val line = StdIn.readLine()
      val res = line.foldLeft((0L, 0)) {
        case ((res, ones), b) =>
          if (b == '1') {
            (res + ones + 1, ones + 1)
          } else {
            (res, ones)
          }
      }

      println(res._1)
    }
  }
}
