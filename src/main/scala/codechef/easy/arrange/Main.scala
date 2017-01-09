package codechef.easy.arrange

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 29/12/2016.
  */
object Main {

  def rearrange(k: Int, appetizers: String) = {
    val n = 1 << k

    def mirror(i: Int): Int = {
      var j = 0
      var a = 0
      while (a < k) {
        val x = (i >> a) & 1
        if (x == 1) {
          j = j | (1 << (k - 1 - a))
        }
        a += 1
      }
      j
    }

    @tailrec
    def go(i: Int, res: String): String = {
      if (i == n) {
        res
      } else {
        val j = mirror(i)
        go(i + 1, res + appetizers(j))
      }
    }

    go(0, "")
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      val line = StdIn.readLine().split("\\s+")
      val k = line(0).toInt
      val appetizers = line(1)

      val res = rearrange(k, appetizers);

      println(res)
    }
  }
}
