package codechef.easy.chearmy

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/7/6.
  */
object Main {

  def base5(k: Long): String = {
    var res = ""

    var x = k
    while (x > 0) {
      val r = x % 5
      res = r + res
      x = x / 5
    }
    res
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      val k = StdIn.readLong()

      val rep = base5(k - 1)
      var ans = 0L

      var j = 0
      while (j < rep.length) {
        val x = rep(j) - '0'
        ans = ans * 10 + 2 * x
        j += 1
      }

      println(ans)
      i += 1
    }
  }
}
