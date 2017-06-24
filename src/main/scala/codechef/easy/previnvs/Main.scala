package codechef.easy.previnvs

import scala.io.StdIn

/**
  * Created by wangsenyuan on 24/06/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val s = StdIn.readLine()
    val n = s.length
    val cs = s.toCharArray
    var flips = 0
    var i = n - 1
    while (i >= 0) {
      if (cs(i) == '1' && flips % 2 == 0) {
        flips += 1
      } else if (cs(i) == '0' && flips % 2 == 1) {
        flips += 1
      }

      i -= 1
    }

    println(flips)
  }
}
