package codechef.easy.anuwta

import scala.io.StdIn

/**
  * Created by wangsenyuan on 12/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      val n = StdIn.readLong()
      val res = n + n * (n + 1) / 2
      println(res)
    }
  }
}
